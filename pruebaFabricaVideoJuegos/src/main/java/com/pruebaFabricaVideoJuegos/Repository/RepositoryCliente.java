package com.pruebaFabricaVideoJuegos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pruebaFabricaVideoJuegos.Model.ModelCliente;

public interface RepositoryCliente extends JpaRepository <ModelCliente,Integer>{

}
