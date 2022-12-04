package com.ipn.Helpdesk.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ipn.Helpdesk.modelo.entidad.Cuenta;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Long>{

}
