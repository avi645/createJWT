package com.example.createJWT.entities;

public class ReturnValue {
	
	private String jwt;
	private String privateKey;
	private String publicKey;
	public ReturnValue() {
		
	}
	
	
	
	public ReturnValue(String jwt, String privateKey, String publicKey) {
		
		this.jwt = jwt;
		this.privateKey = privateKey;
		this.publicKey = publicKey;
	}



	public String getJwt() {
		return jwt;
	}
	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	public String getPrivateKey() {
		return privateKey;
	}
	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}
	public String getPublicKey() {
		return publicKey;
	}
	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}
	
	
	

}
