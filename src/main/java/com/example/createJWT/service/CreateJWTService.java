package com.example.createJWT.service;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;


import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import com.example.createJWT.entities.Data;
import com.example.createJWT.entities.ReturnValue;
import com.example.createJWT.repository.ICreateJWT;

@Service
public class CreateJWTService {
	
	private final ICreateJWT iCreateJWT;

	public CreateJWTService(ICreateJWT iCreateJWT) {
		
		this.iCreateJWT = iCreateJWT;
	}
	
	public ReturnValue createJWT(Data data) throws  InvalidKeyException, NoSuchAlgorithmException, SignatureException, ParseException, IOException {
		return this.iCreateJWT.createJWT(data);
	}
}
