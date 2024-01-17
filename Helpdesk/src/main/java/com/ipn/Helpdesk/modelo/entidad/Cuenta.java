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
@Table(name = "Cuenta", schema = "helpdesk_qa_prep")

public class Cuenta  implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_cuen;

    @OneToMany(mappedBy = "cuenta", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Cliente> cliente; 

    @Column(name = "Nombre_cuen")
    private String Nombre_cuen;
    @Column(name = "Desc_cuen")
    private String Desc_cuenta;

    @Column(name = "Repre_cuen")
    private String Repre_cuen;
    @Column(name = "Alcan_cuen")
    private String Alcan_cuen;

    
    @Column(name = "fecha_creacion", nullable = false)
    private Date register_date;

    @Column(name = "fecha_modificacion")
    private Date last_update_date;

    public Cuenta()
    {
    	
    }
    
    public Cuenta(Long Id_cuen, Set<Cliente> cliente, String Nombre_cuen, String Desc_cuenta, String Repre_cuen, String Alcan_cuen, Date register_date, Date last_update_date) {
        this.Id_cuen = Id_cuen;
        this.cliente = cliente;
        this.Nombre_cuen = Nombre_cuen;
        this.Desc_cuenta = Desc_cuenta;
        this.Repre_cuen = Repre_cuen;
        this.Alcan_cuen = Alcan_cuen;
        this.register_date = register_date;
        this.last_update_date = last_update_date;
    }

    @Override
    public int hashCode() {
      return Objects.hash(Id_cuen, cliente);
    }
  
    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (!(obj instanceof Cuenta))
        return false;
        Cuenta other = (Cuenta) obj;
      return Objects.equals(Id_cuen, other.Id_cuen) && Objects.equals(cliente, other.cliente);
    }

    
    @PrePersist
    private void antesPersistir() {
        this.register_date = new Date();
    }

    @PreUpdate
    private void antesActualizar() {
        this.last_update_date = new Date();
    }

	public Long getId_cuen() {
		return Id_cuen;
	}

	public void setId_cuen(Long id_cuen) {
		Id_cuen = id_cuen;
	}

	public Set<Cliente> getCliente() {
		return cliente;
	}

	public void setCliente(Set<Cliente> cliente) {
		this.cliente = cliente;
	}

	public String getNombre_cuen() {
		return Nombre_cuen;
	}

	public void setNombre_cuen(String nombre_cuen) {
		Nombre_cuen = nombre_cuen;
	}

	public String getDesc_cuenta() {
		return Desc_cuenta;
	}

	public void setDesc_cuenta(String desc_cuenta) {
		Desc_cuenta = desc_cuenta;
	}

	public String getRepre_cuen() {
		return Repre_cuen;
	}

	public void setRepre_cuen(String repre_cuen) {
		Repre_cuen = repre_cuen;
	}

	public String getAlcan_cuen() {
		return Alcan_cuen;
	}

	public void setAlcan_cuen(String alcan_cuen) {
		Alcan_cuen = alcan_cuen;
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
