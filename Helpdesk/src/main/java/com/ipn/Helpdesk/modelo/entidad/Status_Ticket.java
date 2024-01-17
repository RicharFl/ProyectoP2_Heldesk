package com.ipn.Helpdesk.modelo.entidad;

import java.io.Serializable;
import java.util.Date;
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

@Table(name = "Status_Ticket", schema = "helpdesk_qa_prep")
public class Status_Ticket implements Serializable {
	
	 /**
		 * 
		 */
	private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_status_ticket;

    @OneToMany(mappedBy = "status_Ticket", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Ticket> ticket;

    @Column(name = "Nom_status")
    private String nom_status;

    @Column(name = "Descr_status")
    private String descr_status;

    @Column(name = "fecha_creacion", nullable = false)
    private Date register_date;

    @Column(name = "fecha_modificacion")
    private Date last_update_date;


    public Status_Ticket() {
    	
    }


	public Status_Ticket(Long id_status_ticket, Set<Ticket> ticket, String nom_status, String descr_status,
			Date register_date, Date last_update_date) {
		super();
		this.id_status_ticket = id_status_ticket;
		this.ticket = ticket;
		this.nom_status = nom_status;
		this.descr_status = descr_status;
		this.register_date = register_date;
		this.last_update_date = last_update_date;
	}

	public String getNom_status() {
		return nom_status;
	}

	public void setNom_status(String nom_status) {
		this.nom_status = nom_status;
	}

	public String getDescr_status() {
		return descr_status;
	}

	public void setDescr_status(String descr_status) {
		this.descr_status = descr_status;
	}

	@PrePersist
    private void antesPersistir() {
        this.register_date = new Date();
    }

    @PreUpdate
    private void antesActualizar() {
        this.last_update_date = new Date();
    }

	public Long getId_status_ticket() {
		return id_status_ticket;
	}

	public void setId_status_ticket(Long id_status_ticket) {
		this.id_status_ticket = id_status_ticket;
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
