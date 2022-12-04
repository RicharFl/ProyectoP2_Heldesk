package com.ipn.Helpdesk.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ipn.Helpdesk.modelo.entidad.His_asignacion;

@Repository
public interface His_asignacionRepository extends JpaRepository<His_asignacion, Long>{

}
