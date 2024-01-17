package com.ipn.Helpdesk.modelo.entidad;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
//import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter

@Entity
@Table(name = "estadosrepu", schema = "helpdesk_qa_prep")
public class EstadosRepu implements Serializable {
	 /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_est_repu;

    @Column(name = "nombre_esatdo", nullable = false)
    private String nombre_esatdo;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "register_date", nullable = false)
    private Date register_date;

    @Column(name = "last_update_date")
    private Date last_update_date;

    @ManyToOne(optional = true)
    @JoinColumn(name = "Id_zon", foreignKey = @ForeignKey(name = "FK_1_ZonaEstado_ID"))
    private ZonaEstados zonaestados;

    public  EstadosRepu() {
	
	}
    public EstadosRepu(Long Id_est_repu, String nombre_esatdo, String descripcion, Date register_date,
            Date last_update_date) {
        this.Id_est_repu = Id_est_repu;
        this.nombre_esatdo = nombre_esatdo;
        this.descripcion = descripcion;
        this.register_date = register_date;
        this.last_update_date = last_update_date;
        /* this.zonaestados = zonaestados; */
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id_est_repu, nombre_esatdo);
    }

    @Override 
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof EstadosRepu))
            return false;
        EstadosRepu other = (EstadosRepu) obj;
        return Objects.equals(Id_est_repu, other.Id_est_repu) && Objects.equals(nombre_esatdo, other.nombre_esatdo);
    }

    @PrePersist
    private void antesPersistir() {
        this.register_date = new Date();
    }

    @PreUpdate
    private void antesActualizar() {
        this.last_update_date = new Date();
    }

	public Long getId_est_repu() {
		return Id_est_repu;
	}

	public void setId_est_repu(Long id_est_repu) {
		Id_est_repu = id_est_repu;
	}

	public String getNombre_esatdo() {
		return nombre_esatdo;
	}

	public void setNombre_esatdo(String nombre_esatdo) {
		this.nombre_esatdo = nombre_esatdo;
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

	public ZonaEstados getZona() {
		return zonaestados;
	}

	public void setZona(ZonaEstados zonaestados) {
		this.zonaestados = zonaestados;
	}

    
    
    
    
    
}
