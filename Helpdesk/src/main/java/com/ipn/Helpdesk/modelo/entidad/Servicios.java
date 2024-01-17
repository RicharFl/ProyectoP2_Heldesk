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

@Table(name = "Servicios", schema = "helpdesk_qa_prep")

public class Servicios implements Serializable {
	
	 /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_serv;
    @Column(name = "Nom_service")
    private String nom_service;

    @Column(name = "Descr_ser")
    private String descr_ser;

    @Column(name = "Impa_ser")
    private String impa_ser;

    @Column(name = "Sla")
    private Integer sla;
    @OneToMany(mappedBy = "servicios", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Ticket> ticket;

    @Column(name = "fecha_creacion", nullable = false)
    private Date register_date;

    @Column(name = "fecha_modificacion")
    private Date last_update_date;

   public Servicios () {
	   
   }
  

    public Servicios(Long Id_serv, String Nom_service, String Descr_ser, String Impa_ser, Integer Sla, Date register_date, Date last_update_date, Set<Ticket> Ticket) {
        this.Id_serv = Id_serv;
        this.nom_service = Nom_service;
        this.descr_ser = Descr_ser;
        this.impa_ser = Impa_ser;
        this.sla = Sla;
        this.register_date = register_date;
        this.last_update_date = last_update_date;
        this.ticket = Ticket;
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(Id_serv, nom_service);
    }
  
    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (!(obj instanceof Servicios))
        return false;
        Servicios other = (Servicios) obj;
      return Objects.equals(Id_serv, other.Id_serv) && Objects.equals(nom_service, other.nom_service);
    }

    
    @PrePersist
    private void antesPersistir() {
        this.register_date = new Date();
    }

    @PreUpdate
    private void antesActualizar() {
        this.last_update_date = new Date();
    }


	public Long getId_serv() {
		return Id_serv;
	}


	public void setId_serv(Long id_serv) {
		Id_serv = id_serv;
	}


	public String getNom_service() {
		return nom_service;
	}


	public void setNom_service(String nom_service) {
		this.nom_service = nom_service;
	}


	public String getDescr_ser() {
		return descr_ser;
	}


	public void setDescr_ser(String descr_ser) {
		this.descr_ser = descr_ser;
	}


	public String getImpa_ser() {
		return impa_ser;
	}


	public void setImpa_ser(String impa_ser) {
		this.impa_ser = impa_ser;
	}


	public Integer getSla() {
		return sla;
	}


	public void setSla(Integer sla) {
		this.sla = sla;
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


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

    
    
    
  
}
