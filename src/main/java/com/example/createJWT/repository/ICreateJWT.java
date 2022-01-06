package com.example.createJWT.repository;

import com.example.createJWT.entities.Data;
import com.example.createJWT.entities.ReturnValue;
import org.json.simple.parser.ParseException;
import java.io.IOException;

import java.security.NoSuchAlgorithmException;
import java.security.InvalidKeyException;
import java.security.SignatureException;


public interface ICreateJWT {
	ReturnValue createJWT(Data Data) throws NoSuchAlgorithmException,SignatureException,IOException,ParseException, InvalidKeyException;
}
