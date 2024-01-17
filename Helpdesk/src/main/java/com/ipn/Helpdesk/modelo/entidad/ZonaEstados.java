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
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "zonaestados", schema = "helpdesk_qa_prep")
public class ZonaEstados implements Serializable {

		private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long Id_zon;

  @Column(name = "nombreE")
  private String nombree;
  
  @Column(name = "Descripcion")
  private String descripcion;
  @Column(name = "register_date", nullable = false)
  private Date register_date;

  @Column(name = "last_update_date")
  private Date last_update_date;

  @OneToMany(mappedBy = "zonaestados", fetch = FetchType.LAZY)
	@JsonIgnore
  private Set<Usuarios> usuarios;

  @OneToMany(mappedBy = "zonaestados", fetch = FetchType.LAZY)
	@JsonIgnore
    private Set<EstadosRepu> estadosrepu; 

/*
    @ManyToOne (optional = true, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name = "Id_est_repu", foreignKey = @ForeignKey(name = "FK_1_ZONA_ID"))
    private EstadosRepu estadosrepu;
*/
    
public ZonaEstados () {
	//System.out.println("estoy en el constructor de zona estados");
}
  



  public ZonaEstados(Long id_zon, String nombree, String descripcion, Date register_date, Date last_update_date,
		Set<Usuarios> usuarios, Set<EstadosRepu> estadosrepu) {
	super();
	Id_zon = id_zon;
	this.nombree = nombree;
	this.descripcion = descripcion;
	this.register_date = register_date;
	this.last_update_date = last_update_date;
	this.usuarios = usuarios;
	this.estadosrepu = estadosrepu;
}




@Override
  public int hashCode() {
    return Objects.hash(Id_zon, nombree);
  }


@Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!(obj instanceof ZonaEstados))
      return false;
    ZonaEstados other = (ZonaEstados) obj;
    return Objects.equals(Id_zon, other.Id_zon) && Objects.equals(nombree, other.nombree);
  }

  @PrePersist
  private void antesPersistir() {
    this.register_date = new Date();
  }

  @PreUpdate
  private void antesActualizar() {
    this.last_update_date = new Date();
  }

public Long getId_zon() {
	return Id_zon;
}

public void setId_zon(Long id_zon) {
	Id_zon = id_zon;
}

public String getNombree() {
	return nombree;
}

public Set<EstadosRepu> getEstadosrepu() {
	return estadosrepu;
}




public void setEstadosrepu(Set<EstadosRepu> estadosrepu) {
	this.estadosrepu = estadosrepu;
}




public void setNombree(String nombree) {
	this.nombree = nombree;
}

public String getDescripcion() {
	return descripcion;
}

public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
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
