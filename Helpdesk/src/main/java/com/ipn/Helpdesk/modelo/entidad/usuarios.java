package com.ipn.Helpdesk.modelo.entidad;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
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

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
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

	@Column(name = "correo_user")
	private String correo_user;
	@Column(name = "password")
	private String password;

	@Column(name = "ext_user")
	private Integer ext_user;

	@Column(name = "tel_user")
	private String tel_user;

	@Column(name = "staus_user")
	private String staus_user;

	@ManyToOne(optional = true, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "id_per", foreignKey = @ForeignKey(name = "FK_1_Perfil_ID"))
	private perfil perfil;

	@ManyToOne(optional = true, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "Id_zona", foreignKey = @ForeignKey(name = "FK_1_ZONA_ID"))
	private ZonaEstados zonaestado;

	@OneToMany(mappedBy = "usuarios", cascade = { CascadeType.PERSIST, CascadeType.MERGE },fetch = FetchType.LAZY)
	private Set<Ticket> ticket;

	@Column(name = "fecha_creacion", nullable = false)
	private Date register_date;

	@Column(name = "fecha_modificacion")
	private Date last_update_date;
	
	
	public Usuarios()
	{
		
	}

	public Usuarios(Long id_user, String nombre_user, String apellidom_user, String apellidop_user, String correo_user,
			String password, Integer ext_user, String tel_user, String staus_user,
			com.ipn.Helpdesk.modelo.entidad.perfil perfil, ZonaEstados zonaestado, Set<Ticket> ticket,
			Date register_date, Date last_update_date) {
		super();
		this.id_user = id_user;
		this.nombre_user = nombre_user;
		this.apellidom_user = apellidom_user;
		this.apellidop_user = apellidop_user;
		this.correo_user = correo_user;
		this.password = password;
		this.ext_user = ext_user;
		this.tel_user = tel_user;
		this.staus_user = staus_user;
		this.perfil = perfil;
		this.zonaestado = zonaestado;
		this.ticket = ticket;
		this.register_date = register_date;
		this.last_update_date = last_update_date;
	}
/*
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Usuario [id = ");
		builder.append(id_user);
		builder.append(", Nombre  = ");
		builder.append(nombre_user);
		builder.append(", Apellido Parterno  = ");
		builder.append(apellidop_user);
		builder.append(", Apellido Parterno   = ");
		builder.append(apellidom_user);
		builder.append(", Correo=");
		builder.append(correo_user);
		builder.append(", Estaus de Usuario =");
		builder.append(staus_user);
		builder.append("]");
		return builder.toString();

	}*/

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

	public String getCorreo_user() {
		return correo_user;
	}

	public void setCorreo_user(String correo_user) {
		this.correo_user = correo_user;
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

	public perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(perfil perfil) {
		this.perfil = perfil;
	}

	public ZonaEstados getZonaestado() {
		return zonaestado;
	}

	public void setZonaestado(ZonaEstados zonaestado) {
		this.zonaestado = zonaestado;
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

}
