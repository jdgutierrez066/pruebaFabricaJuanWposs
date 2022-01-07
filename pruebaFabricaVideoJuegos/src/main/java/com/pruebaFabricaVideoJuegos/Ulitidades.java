package com.pruebaFabricaVideoJuegos;

import java.util.HashMap;
import java.util.Map;

public class Ulitidades {
	
	  public static Map<String, Object> respuesta(boolean status, String message, Object descripcion) {
	        Map<String, Object> response = new HashMap<>();
	        response.put("status", status);
	        response.put("message", message);
	        response.put("descripcion", descripcion);
	        return response;
	    }
}
