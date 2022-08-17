package com.test.kafka.learning.controller;

public class TestDTO {

	private String id;
	private String name;
	private String document;

	public TestDTO(String id, String name, String document) {
		super();
		this.id = id;
		this.name = name;
		this.document = document;
	}

	public TestDTO() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	@Override
	public String toString() {
		return "TestDTO [id=" + id + ", name=" + name + ", document=" + document + "]";
	}
	
	

}
