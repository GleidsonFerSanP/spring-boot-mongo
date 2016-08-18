package com.spring.mongo.example.util;

public class Uteis {

	public static boolean ehNuloOuVazio(String texto) {
		
		if(texto == null || texto.equals("")){
			return true;
		}else{
			return false;
		}
		
	}

}
