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

@Table(name = "Cliente", schema = "helpdesk_qa_prep")
public class Cliente implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cliente;
//cascade = { CascadeType.PERSIST, CascadeType.MERGE }
    @ManyToOne(optional = true)
    @JoinColumn(name = "id_cuen", foreignKey = @ForeignKey(name = "FK_1_id_cuen"))
    private Cuenta cuenta;

    @OneToMany (mappedBy = "cliente", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Ticket> ticket;

    @Column(name = "Nombre_cli")
    private String nombre_cli;

    @Column(name = "ApellidoP_cli")
    private String apellidoP_cli;
    @Column(name = "ApellidoM_cli")
    private String apellidoM_cli;

    @Column(name = "Correo_cli")
    private String correo_cli;

    @Column(name = "Tel_cli")
    private String tel_cli;

    @Column(name = "Ext_cli")
    private String ext_cli;

    @Column(name = "Adscrp_cli")
    private String adscrp_cli;

    @Column(name = "Area_cli")
    private String area_cli;

    @Column(name = "fecha_creacion", nullable = false)
    private Date register_date;

    @Column(name = "fecha_modificacion")
    private Date last_update_date;

    public Cliente ()
    {
    	
    }



    public Cliente(Long id_cliente, Cuenta cuenta, Set<Ticket> ticket, String nombre_cli, String apellidoP_cli,
			String apellidoM_cli, String correo_cli, String tel_cli, String ext_cli, String adscrp_cli, String area_cli,
			Date register_date, Date last_update_date) {
		super();
		this.id_cliente = id_cliente;
		this.cuenta = cuenta;
		this.ticket = ticket;
		this.nombre_cli = nombre_cli;
		this.apellidoP_cli = apellidoP_cli;
		this.apellidoM_cli = apellidoM_cli;
		this.correo_cli = correo_cli;
		this.tel_cli = tel_cli;
		this.ext_cli = ext_cli;
		this.adscrp_cli = adscrp_cli;
		this.area_cli = area_cli;
		this.register_date = register_date;
		this.last_update_date = last_update_date;
	}



	@PrePersist
    private void antesPersistir() {
        this.register_date = new Date();
    }

    @PreUpdate
    private void antesActualizar() {
        this.last_update_date = new Date();
    }



	public Long getId_cliente() {
		return id_cliente;
	}



	public void setId_cliente(Long id_cliente) {
		this.id_cliente = id_cliente;
	}



	public Cuenta getCuenta() {
		return cuenta;
	}



	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
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


	public String getNombre_cli() {
		return nombre_cli;
	}



	public void setNombre_cli(String nombre_cli) {
		this.nombre_cli = nombre_cli;
	}


	public String getApellidoP_cli() {
		return apellidoP_cli;
	}

	public void setApellidoP_cli(String apellidoP_cli) {
		this.apellidoP_cli = apellidoP_cli;
	}


	public String getApellidoM_cli() {
		return apellidoM_cli;
	}

	public void setApellidoM_cli(String apellidoM_cli) {
		this.apellidoM_cli = apellidoM_cli;
	}


	public String getCorreo_cli() {
		return correo_cli;
	}



	public void setCorreo_cli(String correo_cli) {
		this.correo_cli = correo_cli;
	}

	public String getTel_cli() {
		return tel_cli;
	}


	public void setTel_cli(String tel_cli) {
		this.tel_cli = tel_cli;
	}


	public String getExt_cli() {
		return ext_cli;
	}


	public void setExt_cli(String ext_cli) {
		this.ext_cli = ext_cli;
	}



	public String getAdscrp_cli() {
		return adscrp_cli;
	}

	public void setAdscrp_cli(String adscrp_cli) {
		this.adscrp_cli = adscrp_cli;
	}



	public String getArea_cli() {
		return area_cli;
	}


	public void setArea_cli(String area_cli) {
		this.area_cli = area_cli;
	}

    
    
    

    
}
