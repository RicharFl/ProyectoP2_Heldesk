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
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter

@Entity
@Table(name = "usuarios", schema = "helpdesk_qa_prep")
public class Usuarios implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_user;

	@Column(name = "nombre_user")
	private String nombre_user;

	@Column(name = "ApellidoM_user")
	private String apellidom_user;

	@Column(name = "ApellidoP_user")
	private String apellidop_user;

	@Column(name = "username")
	private String username;
	
	@Column(name = "correo")
	private String correo;
	
	@Column(name = "password")
	private String password;

	@Column(name = "ext_user")
	private Integer ext_user;

	@Column(name = "tel_user")
	private String tel_user;

	@Column(name = "staus_user")
	private String staus_user;


	@ManyToOne(optional = true)
	@JoinColumn(name = "id_zona", foreignKey = @ForeignKey(name = "FK_1_ZONA_ID"))
	private ZonaEstados zonaestados;

	@OneToMany(mappedBy = "usuarios", fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<Ticket> ticket;

	@Column(name = "fecha_creacion", nullable = false)
	private Date register_date;

	@Column(name = "fecha_modificacion")
	private Date last_update_date;
	
	
	@ManyToOne(optional = true )
	@JoinColumn(name = "Id_per", foreignKey = @ForeignKey(name = "FK_4_PERFIL_ID"))
	private Perfil perfil ;

	public Usuarios() {

	}


	



	public Usuarios(Long id_user, String nombre_user, String apellidom_user, String apellidop_user, String username,
			String correo, String password, Integer ext_user, String tel_user, String staus_user,
			ZonaEstados zonaestados, Set<Ticket> ticket, Date register_date, Date last_update_date, Perfil perfil) {
		super();
		this.id_user = id_user;
		this.nombre_user = nombre_user;
		this.apellidom_user = apellidom_user;
		this.apellidop_user = apellidop_user;
		this.username = username;
		this.correo = correo;
		this.password = password;
		this.ext_user = ext_user;
		this.tel_user = tel_user;
		this.staus_user = staus_user;
		this.zonaestados = zonaestados;
		this.ticket = ticket;
		this.register_date = register_date;
		this.last_update_date = last_update_date;
		this.perfil = perfil;
	}






	public Perfil getPerfil() {
		return perfil;
	}






	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}






	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Usuario [id = ");
		builder.append(id_user);
		builder.append("\n");
		builder.append(", Nombre  = ");
		builder.append(nombre_user);
		builder.append("\n");
		builder.append(", Apellido Parterno  = ");
		builder.append(apellidop_user);
		builder.append("\n");
		builder.append(", Apellido Parterno   = ");
		builder.append(apellidom_user);
		builder.append("\n");
		builder.append(", Correo=");
		builder.append(correo);
		builder.append("\n");
		builder.append(", Estaus de Usuario =");
		builder.append(staus_user);
		builder.append("\n");
		builder.append(", Estaus de UserName =");
		builder.append(username);
		builder.append("\n");
		builder.append(", Estaus de Password =");
		builder.append(password);
		builder.append("\n");
		builder.append("]");
		return builder.toString();

	}

	@Override
	public int hashCode() {
		return Objects.hash(id_user, nombre_user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Usuarios))
			return false;
		Usuarios other = (Usuarios) obj;
		return Objects.equals(id_user, other.id_user) && Objects.equals(nombre_user, other.nombre_user);
	}

	@PrePersist
	private void antesPersistir() {
		this.register_date = new Date();
	}

	@PreUpdate
	private void antesActualizar() {
		this.last_update_date = new Date();
	}

	public Long getId_user() {
		return id_user;
	}

	public void setId_user(Long id_user) {
		this.id_user = id_user;
	}

	public String getNombre_user() {
		return nombre_user;
	}

	public void setNombre_user(String nombre_user) {
		this.nombre_user = nombre_user;
	}

	public String getApellidom_user() {
		return apellidom_user;
	}

	public void setApellidom_user(String apellidom_user) {
		this.apellidom_user = apellidom_user;
	}

	public String getApellidop_user() {
		return apellidop_user;
	}

	public void setApellidop_user(String apellidop_user) {
		this.apellidop_user = apellidop_user;
	}



	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getExt_user() {
		return ext_user;
	}

	public void setExt_user(Integer ext_user) {
		this.ext_user = ext_user;
	}

	public String getTel_user() {
		return tel_user;
	}

	public void setTel_user(String tel_user) {
		this.tel_user = tel_user;
	}

	public String getStaus_user() {
		return staus_user;
	}

	public void setStaus_user(String staus_user) {
		this.staus_user = staus_user;
	}

	public ZonaEstados getZonaestados() {
		return zonaestados;
	}

	public void setZonaestados(ZonaEstados zonaestados) {
		this.zonaestados = zonaestados;
	}



	public Set<Ticket> getTicket() {
		return ticket;
	}

	public void setTicket(Set<Ticket> ticket) {
		this.ticket = ticket;
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

	public String getUsername() {
		return username;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}



	
	
	
	

}
