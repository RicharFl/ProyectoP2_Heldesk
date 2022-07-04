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
@NoArgsConstructor
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



}
