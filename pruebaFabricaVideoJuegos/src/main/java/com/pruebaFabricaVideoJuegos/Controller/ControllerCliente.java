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
import com.pruebaFabricaVideoJuegos.Dto.DtoCliente;
import com.pruebaFabricaVideoJuegos.Model.ModelCliente;
import com.pruebaFabricaVideoJuegos.Repository.RepositoryCliente;

@RestController
@RequestMapping(path="cliente")

public class ControllerCliente {
	
	@Autowired
	private RepositoryCliente repositoryCliente;
	
	
	//Creacion del cliente
	@PostMapping(path="/crearCliente")
	
	public @ResponseBody Map<String, Object> crearCliente (@RequestBody ModelCliente cli){
		
		try {
			if(cli.getNo_cc_cliente().equals(null) || cli.getNom_cliente().equals(null) || cli.getApe_cliente().equals(null) || cli.getNo_cel_cliente().equals(null)) {
				return Utilidades.response(false, "Faltan datos, error al crear el cliente", null);
			}else {
				repositoryCliente.save(cli);
				return Utilidades.response(true, "Creacion del cliente exitosa", cli);
			}
		}catch (Exception e) {
			return Utilidades.response(false, "Error al crear el cliente", null);
		}
	}
	
	//Obtener cliente por id
	@GetMapping(path="/obtenerCliente/{id}")
	public @ResponseBody Map<String, Object> listClientes(@PathVariable Integer id){
		
		try {
			
			Optional<ModelCliente> obtenerCliente = repositoryCliente.findById(id);
			
			if(obtenerCliente.isPresent()) {
				DtoCliente dtoCliente = new DtoCliente(obtenerCliente.get().getIdcliente(),obtenerCliente.get().getNo_cc_cliente(),
						obtenerCliente.get().getNom_cliente(),obtenerCliente.get().getApe_cliente(),obtenerCliente.get().getNo_cel_cliente());
					return Utilidades.response(true, "Cliente encontrado exitosamente", dtoCliente);
			}
			return Utilidades.response(false, "Cliente no registrado", null);
		}catch (Exception e) {
			return Utilidades.response(false, "Error al buscar el cliente", null);
		}
		
		
	}
	
	
	//Obtener clientes registrados
	@GetMapping(path="/obtenerLosClientes")
	
	public @ResponseBody Map<String, Object> listClientes(){
		List<ModelCliente> clientes = new ArrayList<ModelCliente>();
		List<DtoCliente> clientes2 = new ArrayList<DtoCliente>();
		
		try {
			clientes = repositoryCliente.findAll();
			if(clientes.size()==0) {
				return Utilidades.response(false, "No hay clientes registrados", null);
			}
			
			for(int i=0; i<clientes.size();i++) {
				DtoCliente dtoCliente = new DtoCliente(clientes.get(i).getIdcliente(),clientes.get(i).getNo_cc_cliente(),clientes.get(i).getNom_cliente(),clientes.get(i).getApe_cliente(),clientes.get(i).getNo_cel_cliente());
				clientes2.add(dtoCliente);
			}
			return Utilidades.response(true, "Registros encontrados exitosamente", clientes2);
			
		}catch (Exception e) {
			return Utilidades.response(false, "Error al obtener los registros", null);
		}
	}
	
	//Modificar un cliente
	@PutMapping(path="/modificarCliente")
	public @ResponseBody Map<String, Object> modificarCliente(@RequestBody DtoCliente dtoCliente){
		
		try {
			Optional<ModelCliente> clienteModificar = repositoryCliente.findById(dtoCliente.getId_cli());
			
			if(clienteModificar.isPresent()) {
				
				ModelCliente clienteReemplazar = clienteModificar.get();
				
				String cc;
				cc = String.valueOf(dtoCliente.getCc_cli());
				String cel;
				cel = String.valueOf(dtoCliente.getCel_cli());
				
				if(!cc.isBlank()) {
					clienteReemplazar.setNo_cc_cliente(dtoCliente.getCc_cli());
				}
				if(!dtoCliente.getNom_cli().isBlank()) {
					clienteReemplazar.setNom_cliente(dtoCliente.getNom_cli());
				}
				if(!dtoCliente.getApe_cli().isBlank()) {
					clienteReemplazar.setApe_cliente(dtoCliente.getApe_cli());
				}
				if(!cel.isBlank()) {
					clienteReemplazar.setNo_cel_cliente(dtoCliente.getCel_cli());
				}
				repositoryCliente.save(clienteReemplazar);
				
				DtoCliente dtoCli = new DtoCliente(clienteReemplazar.getIdcliente(),clienteReemplazar.getNo_cc_cliente(),
						clienteReemplazar.getNom_cliente(),clienteReemplazar.getApe_cliente(),clienteReemplazar.getNo_cel_cliente());
			
				return Utilidades.response(true, "Se moficio correctamente", dtoCli);
			}
			return Utilidades.response(false, "Cliente no encontrado",null);
		}catch (Exception e) {
			return Utilidades.response(false, "Error al modificar "+dtoCliente.getId_cli(), null);
		}		
	}
	
	
	//Eliminar un cliente por el id
	@DeleteMapping(path="/deleteCliente/{id}")
	public @ResponseBody Map<String, Object> deleteCliente(@PathVariable Integer idCliente){
		
		try {
			Optional<ModelCliente> clienteEliminar = repositoryCliente.findById(idCliente);
			if(clienteEliminar.isPresent()) {
				repositoryCliente.delete(clienteEliminar.get());
				return Utilidades.response(true, "Cliente eliminado correctamente", clienteEliminar);
			}
			return Utilidades.response(false, "Cliente no existe", null);
		}catch (Exception e) {
			return Utilidades.response(false, "Error al eliminar el clietne", null);
		}
	}
		
	
	

}
