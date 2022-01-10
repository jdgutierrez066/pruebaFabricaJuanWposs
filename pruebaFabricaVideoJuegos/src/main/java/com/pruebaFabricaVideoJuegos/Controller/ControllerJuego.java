package com.pruebaFabricaVideoJuegos.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pruebaFabricaVideoJuegos.Utilidades;
import com.pruebaFabricaVideoJuegos.Dto.DtoJuego;
import com.pruebaFabricaVideoJuegos.Model.ModelJuego;
import com.pruebaFabricaVideoJuegos.Repository.RepositoryJuego;

@RestController
@RequestMapping(path="juego")

public class ControllerJuego {
	
	@Autowired
	private RepositoryJuego repositoryJuego;
	
	
//Creacion de un juego
@PostMapping(path="/crearJuego")
public @ResponseBody Map<String, Object> crearJuego (@RequestBody ModelJuego jue){
	
	try {
		
		if(jue.getTit_juego().equals(null) || jue.getNom_juego().equals(null) || jue.getYear_juego().equals(null) || jue.getDirector_juego().equals(null)
				|| jue.getProductor_juego().equals(null) || jue.getTipTecnologia_juego().equals(null) || jue.getTipTecnologia_juego().equals(null)
				|| jue.getPrecio_juego().equals(null)) {
			return Utilidades.response(false, "Faltan datos, error al crear el juego", null);
		}
		jue.setStatus_juego(true);
		repositoryJuego.save(jue);
		return Utilidades.response(true,"El juego se registro correctamente" , jue);
		
		
	}catch (Exception e) {
		return Utilidades.response(false, "Error al registrar el juego", null);
	}
}

//Obtener los juegos

	@GetMapping(path="/obtenerLosJuegos")
	public @ResponseBody Map<String, Object> listJuego(){
		List<ModelJuego> juego = new ArrayList<ModelJuego>();
		List<DtoJuego> juegoMostrar = new ArrayList<DtoJuego>();
		
		try {
			
			juego = repositoryJuego.findAll();
			
			if(juego.size()==0) {
				return Utilidades.response(false, "No se encontraron juegos", null);
			}
			
			for(int i=0; i<juego.size();i++) {
			
				DtoJuego dtojuego = new DtoJuego(juego.get(i).getIdJuego(),juego.get(i).getTit_juego(),juego.get(i).getNom_juego(),
					juego.get(i).getYear_juego(),juego.get(i).getDirector_juego(),juego.get(i).getProductor_juego(),
					juego.get(i).getTipTecnologia_juego(),juego.get(i).getPrecio_juego(),juego.get(i).isStatus_juego());
				juegoMostrar.add(dtojuego);
			}
			return Utilidades.response(true, "Juegos encontrados exitosamente", juegoMostrar);
			
			
			
		}catch (Exception e) {
			return Utilidades.response(false, "Error al obtener los juegos", null);
		}
		
	}
	
	//Modificar un juego
	
	@PutMapping(path="/modificarJuego")
	public @ResponseBody Map<String, Object> modificarJuego (@RequestBody DtoJuego dtoJuego){
		
		try {

			Optional<ModelJuego> juegoModificar = repositoryJuego.findById(dtoJuego.getId_juego());
			
			if(juegoModificar.isPresent()) {
				ModelJuego juegoReemplazar = juegoModificar.get();

					
				String precio_juego;
				precio_juego =  String.valueOf(dtoJuego.getPrecio_juego());
				
				
				if(!dtoJuego.getTit_juego().isBlank()) {
					juegoReemplazar.setTit_juego(dtoJuego.getTit_juego());
				}
				if(!dtoJuego.getNom_juego().isBlank()) {
					juegoReemplazar.setNom_juego(dtoJuego.getNom_juego());
				}
				if(!dtoJuego.getYear_juego().isBlank()) {
					juegoReemplazar.setYear_juego(dtoJuego.getYear_juego());
				}
				if(!dtoJuego.getDirector_juego().isBlank()) {
					juegoReemplazar.setDirector_juego(dtoJuego.getDirector_juego());
				}
				if(!dtoJuego.getProductor_juego().isBlank()) {
					juegoReemplazar.setProductor_juego(dtoJuego.getProductor_juego());
				}
				if(!dtoJuego.getTipTecnologia_juego().isBlank()) {
					juegoReemplazar.setTipTecnologia_juego(dtoJuego.getTipTecnologia_juego());
				}
				if(!precio_juego.isBlank()) {
					juegoReemplazar.setPrecio_juego(dtoJuego.getPrecio_juego());
				}
				
				repositoryJuego.save(juegoReemplazar);
			
				
				DtoJuego dtoJue = new DtoJuego(juegoReemplazar.getIdJuego(),juegoReemplazar.getTit_juego(),juegoReemplazar.getNom_juego(),
						juegoReemplazar.getYear_juego(),juegoReemplazar.getDirector_juego(),juegoReemplazar.getProductor_juego(),
						juegoReemplazar.getTipTecnologia_juego(), juegoReemplazar.getPrecio_juego(),juegoReemplazar.isStatus_juego());
				
				return Utilidades.response(true, "Se modifico el juego correctamente", dtoJue);
			}
			return Utilidades.response(false, "No se encontro el juego", null);
		
		}catch (Exception e) {
			return Utilidades.response(false, "Error al modifcar el juego", null);
		}
	}
	
	// Eliminar un juego por id
	
	@DeleteMapping(path="/deleteJuego/{id}")
	public @ResponseBody Map<String, Object> deleteJuego (@PathVariable Integer id){
		
		try {
			
			Optional<ModelJuego> juegoEliminar = repositoryJuego.findById(id);
			if(juegoEliminar.isPresent()) {
				repositoryJuego.delete(juegoEliminar.get());
				return Utilidades.response(true, "El juego se elimino correctamente", juegoEliminar);
			}
			return Utilidades.response(false, "El juego no se encontro", null);
		}catch (Exception e) {
			return Utilidades.response(false, "Error al eliminar el juego", null);
		}
	}
	
}
