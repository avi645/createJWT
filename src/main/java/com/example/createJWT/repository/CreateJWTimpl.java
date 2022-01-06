package com.example.createJWT.repository;

import java.io.IOException;

import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SignatureException;

import java.util.ArrayList;

import java.util.Date;

import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Repository;

import com.example.createJWT.entities.Data;
import com.example.createJWT.entities.ReturnValue;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Repository
public class CreateJWTimpl implements ICreateJWT {

	@Override
	public ReturnValue createJWT(Data Data)
			throws InvalidKeyException, NoSuchAlgorithmException, SignatureException, ParseException, IOException {

		KeyPairGenerator keyGenerator = KeyPairGenerator.getInstance("RSA");
		keyGenerator.initialize(2048);

		KeyPair kp = keyGenerator.genKeyPair();
		PublicKey publicKey = (PublicKey) kp.getPublic();
		PrivateKey privateKey = (PrivateKey) kp.getPrivate();

		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(Data.getJson());

		String token = Jwts.builder().setSubject("create-sample-jwt").setIssuedAt(new Date())
				.setExpiration(new Date(new Date().getTime() + 300000l)).setIssuer("dummy@email.com")
				.claim("payload", json)
				// RS256 with privateKey
				.signWith(SignatureAlgorithm.RS256, privateKey).compact();

		PemFile pubkey = new PemFile(publicKey, "PUBLIC KEY");

		PemFile privKey = new PemFile(privateKey, "PRIVATE KEY");

		ReturnValue returnValue = new ReturnValue(token,privKey.getKey(),pubkey.getKey());
		
		

		

		return returnValue;

	}

}
