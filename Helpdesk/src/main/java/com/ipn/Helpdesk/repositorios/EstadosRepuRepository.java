package com.ipn.Helpdesk.repositorios;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ipn.Helpdesk.modelo.entidad.EstadosRepu;

@Repository
public interface EstadosRepuRepository extends JpaRepository<EstadosRepu, Long>{
	
	
	@Query(value = "select *from estadosrepu where id_zon = :zona", nativeQuery = true)
	Set<EstadosRepu> ListaEstadosPorZonaEconomica (@Param ("zona") Long zona );
	

}
