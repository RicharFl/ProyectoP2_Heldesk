package com.ipn.Helpdesk.modelo.entidad;

import java.io.Serializable;
import java.util.Date;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.ForeignKey;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity


@Table(name = "ticket", schema = "helpdesk_qa_prep")

public class Ticket implements Serializable {
	 /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_ticket;

    @Column(name = "des_error")
    private String des_error;
//cascade = { CascadeType.PERSIST, CascadeType.MERGE }
    @ManyToOne(optional = true )
    @JoinColumn(name = "Id_est_repu", foreignKey = @ForeignKey(name = "FK_1_ID_Estados_REPU"))
    private EstadosRepu estadosrepu;

    @ManyToOne(optional = true)
    @JoinColumn(name = "id_user", foreignKey = @ForeignKey(name = "FK_1_ID_usiarios"))

    private Usuarios usuarios;


    @ManyToOne(optional = true)
    @JoinColumn(name = "Id_serv", foreignKey = @ForeignKey(name = "FK_1_Id_serv"))
    private Servicios servicios;

    @ManyToOne(optional = true)
    @JoinColumn(name = "id_cliente", foreignKey = @ForeignKey(name = "FK_1_Id_cliente"))
    private Cliente cliente;

    @ManyToOne(optional = true)
    @JoinColumn(name = "id_status_ticket", foreignKey = @ForeignKey(name = "FK_1_id_status_ticket"))
    private Status_Ticket status_Ticket;

    @OneToMany (mappedBy = "ticket", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<HisTicket> histicket;


    @OneToMany (mappedBy = "ticket", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JsonIgnore
    private Set<Sol_Alm> sol_Alms;

    @OneToMany (mappedBy = "ticket", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<His_asignacion> asignacions;


    @Column(name = "Sla_status")
    private String sla_status;

    @Column(name = "No_serie")
    private String no_serie;
    @Column(name = "fecha_creacion", nullable = false)
    private Date register_date;

    @Column(name = "fecha_modificacion")
    private Date last_update_date;

     public Ticket() {
		// TODO Auto-generated constructor stub
	} 
    



	public Ticket(Long id_ticket, String des_error, EstadosRepu estadosrepu, Usuarios usuarios, Servicios servicios,
			Cliente cliente, Status_Ticket status_Ticket, Set<HisTicket> histicket, Set<Sol_Alm> sol_Alms,
			Set<His_asignacion> asignacions, String sla_status, String no_serie, Date register_date,
			Date last_update_date) {
		super();
		this.id_ticket = id_ticket;
		this.des_error = des_error;
		this.estadosrepu = estadosrepu;
		this.usuarios = usuarios;
		this.servicios = servicios;
		this.cliente = cliente;
		this.status_Ticket = status_Ticket;
		this.histicket = histicket;
		this.sol_Alms = sol_Alms;
		this.asignacions = asignacions;
		this.sla_status = sla_status;
		this.no_serie = no_serie;
		this.register_date = register_date;
		this.last_update_date = last_update_date;
	}




	public String getNo_serie() {
	return no_serie;
}

public void setNo_serie(String no_serie) {
	this.no_serie = no_serie;
}

	public Long getId_ticket() {
	return id_ticket;
}


public void setId_ticket(Long id_ticket) {
	this.id_ticket = id_ticket;
}


	@PrePersist
    private void antesPersistir() {
        this.register_date = new Date();
    }

    @PreUpdate
    private void antesActualizar() {
        this.last_update_date = new Date();
    }





	public String getDes_error() {
		return des_error;
	}



	public void setDes_error(String des_error) {
		this.des_error = des_error;
	}



	public EstadosRepu getEstadosrepu() {
		return estadosrepu;
	}



	public void setEstadosrepu(EstadosRepu estadosrepu) {
		this.estadosrepu = estadosrepu;
	}



	public Usuarios getUsuarios() {
		return usuarios;
	}



	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}



	

	public Servicios getServicios() {
		return servicios;
	}





	public void setServicios(Servicios servicios) {
		this.servicios = servicios;
	}





	public Cliente getCliente() {
		return cliente;
	}



	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}



	public Status_Ticket getStatus_Ticket() {
		return status_Ticket;
	}



	public void setStatus_Ticket(Status_Ticket status_Ticket) {
		this.status_Ticket = status_Ticket;
	}



	public Set<HisTicket> getHisticket() {
		return histicket;
	}



	public void setHisticket(Set<HisTicket> histicket) {
		this.histicket = histicket;
	}



	public Set<Sol_Alm> getSol_Alms() {
		return sol_Alms;
	}



	public void setSol_Alms(Set<Sol_Alm> sol_Alms) {
		this.sol_Alms = sol_Alms;
	}



	public String getSla_status() {
		return sla_status;
	}



	public void setSla_status(String sla_status) {
		this.sla_status = sla_status;
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




	public Set<His_asignacion> getAsignacions() {
		return asignacions;
	}




	public void setAsignacions(Set<His_asignacion> asignacions) {
		this.asignacions = asignacions;
	}

    
    
    
    
    
    
    
    
    
}
