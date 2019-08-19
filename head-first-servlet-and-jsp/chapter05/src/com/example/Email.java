package com.example;

public class Email {
	String name;
	String domain;
	
	public Email(String name, String domain) {
		this.name = name;
		this.domain = domain;
	}
	
	public String getEmail() {
		return name + "@" + domain;
	}
}