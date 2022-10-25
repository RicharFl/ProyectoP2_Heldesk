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

import lombok.Getter;
import  lombok.Setter;
import lombok.NoArgsConstructor;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table ( name = "perfil", schema = "helpdesk_qa_prep")
public class perfil implements Serializable {
	
	 /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_per;

    @Column (name = "nom_per")
    private String nombre_perfIString;

    @Column (name = "desc_per")
    private String descripcion_perfiString;

    @Column (name ="niv_perm_per" )
    private String nieve_permisosString;


    @Column(name = "fecha_creacion", nullable = false)
	private Date register_date;
	
	@Column(name = "fecha_modificacion")
	private Date last_update_date;

    
    @OneToMany (mappedBy = "perfil", fetch = FetchType.LAZY)
 private Set<Usuarios> usuarios;

    public perfil ( Long id2,  String nombre_perfIString2,  String descripcion_perfiString2, String nieve_permisosString2, Date register_date2)

    {
        this.Id_per= id2; 
        this.nombre_perfIString= nombre_perfIString2;
        this.descripcion_perfiString = descripcion_perfiString2;
        this.nieve_permisosString = nieve_permisosString2;
        this.register_date = register_date2;

    }
	

    @Override
	public String toString() 
	{
		StringBuilder builder = new StringBuilder();
		builder.append("Perfil [id = ");
        builder.append(Id_per);
        builder.append(", Nombre del Perfil = ");
        builder.append(nombre_perfIString);
        builder.append(", Descripcion  = ");
        builder.append(descripcion_perfiString);
        builder.append(", Nivel de permisos  = ");
        builder.append(nieve_permisosString);
        builder.append(", fechaCreacion=");
		builder.append(register_date);
		builder.append(", fechaModificacion=");
		builder.append(last_update_date);
		builder.append("]");
		return builder.toString();

	
	}
    @Override
	public int hashCode() 
	{
		return Objects.hash(Id_per, nombre_perfIString);
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (!(obj instanceof perfil))
			return false;
            perfil other = (perfil) obj;
		return Objects.equals(Id_per, other.Id_per) && Objects.equals(nombre_perfIString, other.nombre_perfIString);
	}



    
 
    @PrePersist
	private void antesPersistir()
	{
		this.register_date = new Date();
	}
	
	@PreUpdate
	private void antesActualizar()
	{
		this.last_update_date = new Date();
	}


	public Long getId_per() {
		return Id_per;
	}


	public void setId_per(Long id_per) {
		Id_per = id_per;
	}


	public String getNombre_perfIString() {
		return nombre_perfIString;
	}


	public void setNombre_perfIString(String nombre_perfIString) {
		this.nombre_perfIString = nombre_perfIString;
	}


	public String getDescripcion_perfiString() {
		return descripcion_perfiString;
	}


	public void setDescripcion_perfiString(String descripcion_perfiString) {
		this.descripcion_perfiString = descripcion_perfiString;
	}


	public String getNieve_permisosString() {
		return nieve_permisosString;
	}


	public void setNieve_permisosString(String nieve_permisosString) {
		this.nieve_permisosString = nieve_permisosString;
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
