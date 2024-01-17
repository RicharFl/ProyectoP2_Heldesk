package com.ipn.Helpdesk.modelo.entidad;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity


@Table(name = "HisTicket", schema = "helpdesk_qa_prep")
public class HisTicket implements Serializable  {
	
	
	 /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_histori;


    @ManyToOne(optional = true)
    @JoinColumn(name = "Id_ticket", foreignKey = @ForeignKey(name = "FK_1_Id_ticket"), nullable=false)
    private Ticket ticket;

    @Column(name = "Username")
    private String username;
    @Column(name = "Comentario", columnDefinition = "text")
    private String  comentario;
    
    @Column(name = "Fec_inicio", nullable = false)
    private Date fec_inicio;

    @Column(name = "Sla_status_hist")
    private float sla_status_hist;

    @Column(name = "fecha_creacion", nullable = false)
    private Date register_date;

    @Column(name = "fecha_modificacion")
    private Date last_update_date;
    


    
public HisTicket()
{
	}


	public HisTicket(Long id_histori, Ticket ticket, String username, String comentario, Date fec_inicio,
			float sla_status_hist, Date register_date, Date last_update_date) {
	super();
	this.id_histori = id_histori;
	this.ticket = ticket;
	this.username = username;
	this.comentario = comentario;
	this.fec_inicio = fec_inicio;
	this.sla_status_hist = sla_status_hist;
	this.register_date = register_date;
	this.last_update_date = last_update_date;

}


	@Override
    public int hashCode() {
        return Objects.hash(id_histori, username);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof HisTicket))
            return false;
        HisTicket other = (HisTicket) obj;
        return Objects.equals(id_histori, other.id_histori) && Objects.equals(username, other.username);
    }

    


    @PrePersist
    private void antesPersistir() {
        this.register_date = new Date();
    }

    @PreUpdate
    private void antesActualizar() {
        this.last_update_date = new Date();
    }


	public Long getId_histori() {
		return id_histori;
	}


	public void setId_histori(Long id_histori) {
		this.id_histori = id_histori;
	}


	public Ticket getTicket() {
		return ticket;
	}


	public void setTicket(Ticket ticket) {
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
	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Date getFec_inicio() {
		return fec_inicio;
	}

	public void setFec_inicio(Date fec_inicio) {
		this.fec_inicio = fec_inicio;
	}

	public float getSla_status_hist() {
		return sla_status_hist;
	}


	public void setSla_status_hist(float sla_status_hist) {
		this.sla_status_hist = sla_status_hist;
	}


	public void setSla_status_hist(Long sla_status_hist) {
		this.sla_status_hist = sla_status_hist;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


    
    
    
    


}
