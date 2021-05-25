package com.pruebaTecnica.demo.RestAuth.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

	private String user;
	private String token;
	private String pass;
	private long idUser;


}
