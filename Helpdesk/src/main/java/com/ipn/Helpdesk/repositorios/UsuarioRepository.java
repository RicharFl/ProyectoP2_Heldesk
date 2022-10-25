package com.ipn.Helpdesk.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ipn.Helpdesk.modelo.entidad.Usuarios;

public interface UsuarioRepository extends JpaRepository  <Usuarios, Integer>{

}
