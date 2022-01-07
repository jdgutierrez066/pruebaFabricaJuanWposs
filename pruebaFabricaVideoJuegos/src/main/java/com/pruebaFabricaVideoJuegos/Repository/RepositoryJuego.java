package com.pruebaFabricaVideoJuegos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pruebaFabricaVideoJuegos.Model.ModelJuego;

public interface RepositoryJuego extends JpaRepository <ModelJuego,Integer>{

}
