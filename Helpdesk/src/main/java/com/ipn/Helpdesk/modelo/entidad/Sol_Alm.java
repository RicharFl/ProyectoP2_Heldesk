package com.ipn.Helpdesk.modelo.entidad;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.ForeignKey;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity

@Table(name = "Sol_Alm", schema = "helpdesk_qa_prep")

public class Sol_Alm implements Serializable {
	
	 /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_solalm;

    @ManyToOne(optional = true, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name = "Id_ticket", foreignKey = @ForeignKey(name = "FK_1_Id_ticket2"), nullable=false)
    private Ticket ticket;

    @Column(name = "Id_user")
    private String id_user;

    

    @ManyToOne(optional = true, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name = "id_almacen", foreignKey = @ForeignKey(name = "FK_1_id_almacen"), nullable=false)
    private Almacen almacen ;

    @Column(name = "Comtario")
    private String comeString;

    @Column(name = "Cantidad")
    private Integer cantidad;

    @Column(name = "Guia")
    private String guia;


    @Column(name = "Fec_inicio", nullable = false)
    private Date fec_inicio;

    @Column(name = "Sla_status_hist")
    private Long sla_status_hist;

    @Column(name = "fecha_creacion", nullable = false)
    private Date register_date;

    @Column(name = "fecha_modificacion")
    private Date last_update_date;


  public Sol_Alm () {
	  
  }
    
    public Sol_Alm(Long id_solalm, Ticket ticket, String id_user, Almacen almacen, String comeString, Integer cantidad,
			String guia, Date fec_inicio, Long sla_status_hist, Date register_date, Date last_update_date) {
		super();
		this.id_solalm = id_solalm;
		this.ticket = ticket;
		this.id_user = id_user;
		this.almacen = almacen;
		this.comeString = comeString;
		this.cantidad = cantidad;
		this.guia = guia;
		this.fec_inicio = fec_inicio;
		this.sla_status_hist = sla_status_hist;
		this.register_date = register_date;
		this.last_update_date = last_update_date;
	}

	@Override
    public int hashCode() {
        return Objects.hash(id_solalm, id_user);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Sol_Alm))
            return false;
        Sol_Alm other = (Sol_Alm) obj;
        return Objects.equals(id_solalm, other.id_solalm) && Objects.equals(id_user, other.id_user);
    }

    


    @PrePersist
    private void antesPersistir() {
        this.register_date = new Date();
    }

    @PreUpdate
    private void antesActualizar() {
        this.last_update_date = new Date();
    }

	public Ticket getTicket() {
		return ticket;
	}



	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}



	public String getId_user() {
		return id_user;
	}



	public void setId_user(String id_user) {
		this.id_user = id_user;
	}



	public Almacen getAlmacen() {
		return almacen;
	}



	public void setAlmacen(Almacen almacen) {
		this.almacen = almacen;
	}



	public String getComeString() {
		return comeString;
	}



	public void setComeString(String comeString) {
		this.comeString = comeString;
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

	public Long getId_solalm() {
		return id_solalm;
	}

	public void setId_solalm(Long id_solalm) {
		this.id_solalm = id_solalm;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getGuia() {
		return guia;
	}

	public void setGuia(String guia) {
		this.guia = guia;
	}

	public Date getFec_inicio() {
		return fec_inicio;
	}

	public void setFec_inicio(Date fec_inicio) {
		this.fec_inicio = fec_inicio;
	}

	public Long getSla_status_hist() {
		return sla_status_hist;
	}

	public void setSla_status_hist(Long sla_status_hist) {
		this.sla_status_hist = sla_status_hist;
	}


    
    
    
    
    


}
