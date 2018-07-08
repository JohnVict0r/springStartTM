package com.startworks.starttm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.startworks.starttm.model.Eventos.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long>{

}
