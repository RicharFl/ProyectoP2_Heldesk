package com.ipn.Helpdesk.modelo.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import  lombok.Setter;
import lombok.NoArgsConstructor;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table ( name = "perfil", schema = "helpdesk_qa_prep")
public class perfil implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

   

    @Column (name = "nom_per")
    private String nombre_perfIString;

    @Column (name = "desc_per")
    private String descripcion_perfiString; 

    @Column (name ="niv_perm_per" )
    private String nieve_permisosString; 

  

 

}
