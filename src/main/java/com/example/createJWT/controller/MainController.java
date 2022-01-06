package com.example.createJWT.controller;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.createJWT.entities.Data;
import com.example.createJWT.entities.ReturnValue;
import com.example.createJWT.service.CreateJWTService;



@RestController
@CrossOrigin
public class MainController {
	
	private final CreateJWTService createJWTService ;
	
	public MainController(CreateJWTService createJWTService) {
		
		this.createJWTService = createJWTService;
	}

	@PostMapping("/sendData")
	public ReturnValue executePost(@RequestBody Data data) throws InvalidKeyException, NoSuchAlgorithmException, SignatureException, ParseException, IOException  {
		return this.createJWTService.createJWT(data);
	}

}
