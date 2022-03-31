package com.ipn.Helpdesk.modelo.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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


    @OneToMany (mappedBy = "usuario", fetch = FetchType.LAZY)



    

    public String getNieve_permisosString() {
        return this.nieve_permisosString;
    }

    public void setNieve_permisosString(String nieve_permisosString) {
        this.nieve_permisosString = nieve_permisosString;
    }

  
    public String getNombre_perfIString() {
		return this.nombre_perfIString;
	}

	public void setNombre_perfIString(String nombre_perfIString) {
		this.nombre_perfIString = nombre_perfIString;
	}
    public String getDescripcion_perfiString() {
        return this.descripcion_perfiString;
    }

    public void setDescripcion_perfiString(String descripcion_perfiString) {
        this.descripcion_perfiString = descripcion_perfiString;
    }
 



}
