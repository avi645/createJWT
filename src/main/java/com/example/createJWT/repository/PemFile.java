package com.example.createJWT.repository;

import java.io.FileNotFoundException;

import java.io.IOException;

import java.io.StringWriter;
import java.security.Key;

import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemWriter;

public class PemFile {

	private PemObject pemObject;

	public PemFile(Key key, String description) {
		this.pemObject = new PemObject(description, key.getEncoded());
	}

	public String getKey() throws FileNotFoundException, IOException {

		StringWriter stringWriter = new StringWriter();
		PemWriter pemWriter = new PemWriter(stringWriter);
		try {
			pemWriter.writeObject(this.pemObject);
			pemWriter.flush();
			return stringWriter.toString();

		} finally {
			pemWriter.close();
		}
	}

}
