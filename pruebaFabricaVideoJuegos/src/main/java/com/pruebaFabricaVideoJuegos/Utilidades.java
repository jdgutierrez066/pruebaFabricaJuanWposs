package com.pruebaFabricaVideoJuegos;

import java.util.HashMap;
import java.util.Map;

public class Utilidades {
	
	  public static Map<String, Object> response(boolean status, String message, Object descripcion) {
	        Map<String, Object> response = new HashMap<>();
	        response.put("status", status);
	        response.put("message", message);
	        response.put("descripcion", descripcion);
	        return response;
	    }
}
