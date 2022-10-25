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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@NoArgsConstructor

@Table(name = "ticket", schema = "helpdesk_qa_prep")

public class Ticket implements Serializable {
	 /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_ticket;

    @Column(name = "des_error")
    private String des_error;

    @ManyToOne(optional = true, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name = "Id_est_repu", foreignKey = @ForeignKey(name = "FK_1_ID_Estados_REPU"))
    private EstadosRepu estadosrepu;

    @ManyToOne(optional = true, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name = "id_user", foreignKey = @ForeignKey(name = "FK_1_ID_usiarios"))

    private Usuarios usuarios;


    @ManyToOne(optional = true, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name = "Id_serv", foreignKey = @ForeignKey(name = "FK_1_Id_serv"))
    private Servicios Servicios;

    @ManyToOne(optional = true, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name = "id_cliente", foreignKey = @ForeignKey(name = "FK_1_Id_cliente"))
    private Cliente cliente;

    @ManyToOne(optional = true, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name = "id_status_ticket", foreignKey = @ForeignKey(name = "FK_1_id_status_ticket"))
    private Status_Ticket status_Ticket;

    @OneToMany (mappedBy = "ticket", fetch = FetchType.LAZY)
    private Set<HisTicket> histicket;


    @OneToMany (mappedBy = "ticket", fetch = FetchType.LAZY)
    private Set<Sol_Alm> sol_Alms;

    

    @Column(name = "Sla_status")
    private String sla_status;

    @Column(name = "fecha_creacion", nullable = false)
    private Date register_date;

    @Column(name = "fecha_modificacion")
    private Date last_update_date;

    
    
    
    
    
    
    public Ticket(Long id_ticket, String des_error, EstadosRepu estadosrepu, Usuarios usuarios,
			com.ipn.Helpdesk.modelo.entidad.Servicios servicios, Cliente cliente, Status_Ticket status_Ticket,
			Set<HisTicket> histicket, Set<Sol_Alm> sol_Alms, String sla_status, Date register_date,
			Date last_update_date) {
		super();
		Id_ticket = id_ticket;
		this.des_error = des_error;
		this.estadosrepu = estadosrepu;
		this.usuarios = usuarios;
		Servicios = servicios;
		this.cliente = cliente;
		this.status_Ticket = status_Ticket;
		this.histicket = histicket;
		this.sol_Alms = sol_Alms;
		this.sla_status = sla_status;
		this.register_date = register_date;
		this.last_update_date = last_update_date;
	}

    
    
    @Override
    public int hashCode() {
      return Objects.hash(Id_ticket);
    }
  
    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (!(obj instanceof Ticket))
        return false;
      Ticket other = (Ticket) obj;
      return Objects.equals(Id_ticket, other.Id_ticket);
    }
    
	@PrePersist
    private void antesPersistir() {
        this.register_date = new Date();
    }

    @PreUpdate
    private void antesActualizar() {
        this.last_update_date = new Date();
    }



	public Long getId_ticket() {
		return Id_ticket;
	}



	public void setId_ticket(Long id_ticket) {
		Id_ticket = id_ticket;
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
		return Servicios;
	}



	public void setServicios(Servicios servicios) {
		Servicios = servicios;
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

    
    
    
    
    
    
    
    
    
}
