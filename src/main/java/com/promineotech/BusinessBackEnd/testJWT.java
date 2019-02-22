package com.promineotech.BusinessBackEnd;

import java.security.Key;
import java.util.Base64;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class testJWT {

	public static void main(String[] args) {
		
		Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
		
		// admin jwt
		String jwt = Jwts.builder()
				.claim("role", "USER")
				.claim("username", "tuura032")
				.setSubject("tuura032")
				.signWith(key)
				.compact();
		
		// store current version of key in endoedKey
		String encodedKey = Base64.getEncoder().encodeToString(key.getEncoded());
		
		//decoded key
		byte[] decodedKey = Base64.getDecoder().decode(encodedKey);
		
		System.out.println(jwt);
		
		System.out.println(key);
		
		System.out.println(encodedKey);
		
		System.out.println(decodedKey);

		System.out.println(Jwts.parser().setSigningKey(decodedKey).parseClaimsJws(jwt).getBody().getSubject().equals("tuura032"));
		System.out.println(Jwts.parser().setSigningKey(decodedKey).parseClaimsJws(jwt).getBody().get("role"));
	}

}
