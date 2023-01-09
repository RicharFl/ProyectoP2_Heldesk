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


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor


@Table(name = "Almacen", schema = "helpdesk_qa_prep")
public class Almacen implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_almacen;

    @OneToMany (mappedBy = "almacen", fetch = FetchType.LAZY)
    private Set<Sol_Alm> sol_Alms;

    @Column(name = "Marca")
    private String Marca;

    @Column(name = "Modelo")
    private String Moedelo;
    @Column(name = "Descripcin")
    private String Descripcin;

    @Column(name = "stoc")
    private Integer stoc;

    @Column(name = "fecha_creacion", nullable = false)
    private Date register_date;

    @Column(name = "fecha_modificacion")
    private Date last_update_date;

    public Almacen()
    {
    	
    }
    
    public Almacen(Long id_almacen, String Descripcin, Integer stoc, Date register_date, Date last_update_date) {
        this.id_almacen = id_almacen;
      
        this.Descripcin = Descripcin;
        this.stoc = stoc;
        this.register_date = register_date;
        this.last_update_date = last_update_date;
    }


    
    @Override
    public int hashCode() {
        return Objects.hash(sol_Alms, id_almacen);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Almacen))
            return false;
        Almacen other = (Almacen) obj;
        return Objects.equals(sol_Alms, other.sol_Alms) && Objects.equals(id_almacen, other.id_almacen);
    }

    


    @PrePersist
    private void antesPersistir() {
        this.register_date = new Date();
    }

    @PreUpdate
    private void antesActualizar() {
        this.last_update_date = new Date();
    }



	public Long getId_almacen() {
		return id_almacen;
	}



	public void setId_almacen(Long id_almacen) {
		this.id_almacen = id_almacen;
	}



	public Set<Sol_Alm> getSol_Alms() {
		return sol_Alms;
	}



	public void setSol_Alms(Set<Sol_Alm> sol_Alms) {
		this.sol_Alms = sol_Alms;
	}



	public String getMarca() {
		return Marca;
	}



	public void setMarca(String marca) {
		Marca = marca;
	}



	public String getMoedelo() {
		return Moedelo;
	}



	public void setMoedelo(String moedelo) {
		Moedelo = moedelo;
	}



	public String getDescripcin() {
		return Descripcin;
	}



	public void setDescripcin(String descripcin) {
		Descripcin = descripcin;
	}



	public Integer getStoc() {
		return stoc;
	}



	public void setStoc(Integer stoc) {
		this.stoc = stoc;
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
