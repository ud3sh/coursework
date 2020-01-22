package com.example.java8.lambda._02.interfaces;

import java.security.MessageDigest;

public class FunctionalInterfaceExample3 {
	public static void main(String[] args) {
		PasswordEncoder4 md5Encoder = (password, salt) ->{
			//This will actually throw NoSuchAlgorithmException
			//unlike the interface, therefore
			//this is not a valid lamda expression
			MessageDigest md = MessageDigest.getInstance("MD5"); 
			String saltedPassword = password + salt;
			byte[] digest = md.digest(saltedPassword.getBytes());
			return new String(digest);

		}; 
	}
}
