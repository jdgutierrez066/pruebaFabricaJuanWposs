package com.pruebaFabricaVideoJuegos.Controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pruebaFabricaVideoJuegos.Utilidades;
import com.pruebaFabricaVideoJuegos.Dto.DtoAlquiler;
import com.pruebaFabricaVideoJuegos.Model.ModelAlquiler;
import com.pruebaFabricaVideoJuegos.Model.ModelCliente;
import com.pruebaFabricaVideoJuegos.Model.ModelJuego;
import com.pruebaFabricaVideoJuegos.Repository.RepositoryAlquiler;
import com.pruebaFabricaVideoJuegos.Repository.RepositoryCliente;
import com.pruebaFabricaVideoJuegos.Repository.RepositoryJuego;

@RestController
@RequestMapping(path="alquiler")

public class ControllerAlquiler {
	
	
	@Autowired
	private RepositoryAlquiler repositoryAlquiler;
	
	@Autowired
	private RepositoryCliente repositoryCliente;
	
	@Autowired
	private RepositoryJuego repositoryJuego;
	

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date fec_inicio_alq;
	
	
	//Creacion de un alquiler
	
	@PostMapping(path="/crearAlquiler")
	public @ResponseBody Map<String, Object> crearAlquiler(@RequestBody DtoAlquiler alq){
		
		try {

			List<ModelJuego> juegosadd = new ArrayList<ModelJuego>();
			List<ModelJuego> juegoRepository = repositoryJuego.findAll();
			List<ModelCliente> listCli =  repositoryCliente.findAll();
				System.out.println("fec"+fec_inicio_alq);
					
		if( alq.getFec_fin_alq().equals(null) || alq.getFec_fin_alq().equals(null) || alq.getPrecio_alq().equals(null)){
			return Utilidades.response(false, "Faltan datos, error al crear el alquiler", null);
		}else {
			for(int i=0;i<juegoRepository.size();i++) {
				Optional<ModelJuego> jueadd = repositoryJuego.findById(juegoRepository.get(i).getIdJuego());

				if(jueadd.isPresent()) {
					juegosadd.add(jueadd.get());
				}
			}
			
			for(int i=0;i<listCli.size();i++) {
				Optional<ModelCliente> cli = repositoryCliente.findById(listCli.get(i).getIdcliente());
				if(cli.isPresent()) {

					ModelAlquiler modAlq = new ModelAlquiler(cli.get(),juegosadd,alq.getFec_fin_alq(),
							alq.getFec_fin_alq(),alq.getPrecio_alq());
					repositoryAlquiler.save(modAlq);
					return Utilidades.response(true,"Alquiler fue registrado exitosamente", modAlq);
				}
			}
		}
			return Utilidades.response(false, "Error al registrar el alquiler", null);
		}catch (Exception e) {
			System.out.println("por aca entra");
			return Utilidades.response(false, "Error al registrar el alquiler", null);
		}

}
	
	
	//Obtener Alquileres registrados
	
	@GetMapping(path="/obtenerLosAlquileres")
	public @ResponseBody Map<String, Object> obtenerLosAlquileres(){
		
		try {
			List<ModelAlquiler> modAlq = new ArrayList<ModelAlquiler>();
			
			modAlq = repositoryAlquiler.findAll();
			
			if(modAlq.size()==0) {
				return Utilidades.response(false, "No hay registro de ningun alquiler", modAlq);
			}
			return 	Utilidades.response(true, "Registros encontrados exitosamente", modAlq);
		}
		catch (Exception e) {
			return Utilidades.response(false, "Error al obtener los registros", null);

		 }
	}
}
