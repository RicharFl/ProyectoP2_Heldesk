package com.ipn.Helpdesk.modelo.entidad;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;



import javax.persistence.Column;
import javax.persistence.Entity;



import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity

@Table(name = "Sla_ticket", schema = "helpdesk_qa_prep")
public class Sla_ticket implements Serializable  {
	

		private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_sla;
    
    @Column(name = "Nivel")
    private String  nivel;
    
    @Column(name = "tiempo_sla")
    private float  tiempo_sla;
    
    @Column(name = "Descripcion")
    private String  descripcion;
    



    @Column(name = "fecha_creacion", nullable = false)
    private Date register_date;

    @Column(name = "fecha_modificacion")
    private Date last_update_date;

    
 public Sla_ticket ()
 {
	 
 }


    public Sla_ticket(Long id_sla, String nivel, float tiempo_sla, String descripcion,
			Date register_date, Date last_update_date) {
		super();
		this.id_sla = id_sla;
		this.nivel = nivel;
		this.tiempo_sla = tiempo_sla;
		this.descripcion = descripcion;

		this.register_date = register_date;
		this.last_update_date = last_update_date;
	}

	@Override
    public int hashCode() {
        return Objects.hash(id_sla, nivel);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Sla_ticket))
            return false;
        Sla_ticket other = (Sla_ticket) obj;
        return Objects.equals(id_sla, other.id_sla) && Objects.equals(nivel, other.nivel);
    }

    


    @PrePersist
    private void antesPersistir() {
        this.register_date = new Date();
    }

    @PreUpdate
    private void antesActualizar() {
        this.last_update_date = new Date();
    }


	public Long getId_sla() {
		return id_sla;
	}


	public void setId_sla(Long id_sla) {
		this.id_sla = id_sla;
	}


	public String getNivel() {
		return nivel;
	}


	public void setNivel(String nivel) {
		this.nivel = nivel;
	}


	public float getTiempo_sla() {
		return tiempo_sla;
	}


	public void setTiempo_sla(float tiempo_sla) {
		this.tiempo_sla = tiempo_sla;
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



}
