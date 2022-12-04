package com.ipn.Helpdesk.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ipn.Helpdesk.modelo.entidad.Sol_Alm;

@Repository
public interface Sol_AlmRepository extends JpaRepository<Sol_Alm,Long>{

}
