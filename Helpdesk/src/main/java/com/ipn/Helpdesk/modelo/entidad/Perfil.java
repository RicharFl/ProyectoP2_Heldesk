package com.ipn.Helpdesk.modelo.entidad;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.Getter;

import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "perfil", schema = "helpdesk_qa_prep")
public class Perfil implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id_per;

	@Column(name = "nom_per")
	private String nom_per;

	@Column(name = "desc_per")
	private String desc_per;

	@Column(name = "niv_perm_per")
	private String niv_perm_per;

	@Column(name = "register_date")
	private Date register_date;

	@Column(name = "last_update_date")
	private Date last_update_date;
	
	@OneToMany(mappedBy = "perfil", fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<Usuarios> usuarios;

	
	public Perfil() {
		//System.out.println("perfil Vacio");
	}
	


	public Perfil(Long id_per, String nom_per, String desc_per, String niv_perm_per, Date register_date,
			Date last_update_date) {
		super();
		Id_per = id_per;
		this.nom_per = nom_per;
		this.desc_per = desc_per;
		this.niv_perm_per = niv_perm_per;
		this.register_date = register_date;
		this.last_update_date = last_update_date;

	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Perfil [id = ");
		builder.append(Id_per);
		builder.append(", Nombre del Perfil = ");
		builder.append(nom_per);
		builder.append(", Descripcion  = ");
		builder.append(desc_per);
		builder.append(", Nivel de permisos  = ");
		builder.append(niv_perm_per);
		builder.append(", fechaCreacion=");
		builder.append(register_date);
		builder.append(", fechaModificacion=");
		builder.append(last_update_date);
		builder.append("]");
		return builder.toString();

	}

	@Override
	public int hashCode() {
		return Objects.hash(Id_per, nom_per);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Perfil))
			return false;
		Perfil other = (Perfil) obj;
		return Objects.equals(Id_per, other.Id_per) && Objects.equals(nom_per, other.nom_per);
	}

	@PrePersist
	private void antesPersistir() {
		this.register_date = new Date();
	}

	@PreUpdate
	private void antesActualizar() {
		this.last_update_date = new Date();
	}

	public Long getId_per() {
		return Id_per;
	}

	public void setId_per(Long id_per) {
		Id_per = id_per;
	}

	public String getNom_per() {
		return nom_per;
	}

	public void setNom_per(String nom_per) {
		this.nom_per = nom_per;
	}

	public String getDesc_per() {
		return desc_per;
	}

	public void setDesc_per(String desc_per) {
		this.desc_per = desc_per;
	}

	public String getNiv_perm_per() {
		return niv_perm_per;
	}

	public void setNiv_perm_per(String niv_perm_per) {
		this.niv_perm_per = niv_perm_per;
	}

	public Date getRegister_date() {
		return register_date;
	}

	public void setRegister_date(Date register_date) {
		this.register_date = register_date;
	}

	public Date getLast_update_date() {
		return last_update_date;
	}

	public void setLast_update_date(Date last_update_date) {
		this.last_update_date = last_update_date;
	}

	public Set<Usuarios> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuarios> usuarios) {
		this.usuarios = usuarios;
	}


	

}
