package com.startworks.starttm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.startworks.starttm.model.Eventos.TipoEvento;

public interface TipoEventoRepositorio extends JpaRepository<TipoEvento, Long> {

}
