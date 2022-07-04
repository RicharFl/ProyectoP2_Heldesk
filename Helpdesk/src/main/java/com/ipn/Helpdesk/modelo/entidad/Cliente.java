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


@Table(name = "Cliente", schema = "helpdesk_qa_prep")
public class Cliente implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cliente;

    @ManyToOne(optional = true, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name = "id_cuen", foreignKey = @ForeignKey(name = "FK_1_id_cuen"))
    private Cuenta cuenta;

    @OneToMany (mappedBy = "cliente", fetch = FetchType.LAZY)
    private Set<Ticket> ticket;

    @Column(name = "Nombre_cli")
    private String Nombre_cli;

    @Column(name = "ApellidoP_cli")
    private String ApellidoP_cli;
    @Column(name = "ApellidoM_cli")
    private String ApellidoM_cli;

    @Column(name = "Correo_cli")
    private String Correo_cli;

    @Column(name = "Tel_cli")
    private String Tel_cli;

    @Column(name = "Ext_cli")
    private String Ext_cli;

    @Column(name = "Adscrp_cli")
    private String Adscrp_cli;

    @Column(name = "Area_cli")
    private String Area_cli;

    @Column(name = "fecha_creacion", nullable = false)
    private Date register_date;

    @Column(name = "fecha_modificacion")
    private Date last_update_date;



    public Cliente(Long id_cliente, Cuenta cuenta, Set<Ticket> ticket, String Nombre_cli, String ApellidoP_cli, String ApellidoM_cli, String Correo_cli, String Tel_cli, String Ext_cli, String Adscrp_cli, String Area_cli, Date register_date, Date last_update_date) {
        this.id_cliente = id_cliente;
        this.cuenta = cuenta;
        this.ticket = ticket;
        this.Nombre_cli = Nombre_cli;
        this.ApellidoP_cli = ApellidoP_cli;
        this.ApellidoM_cli = ApellidoM_cli;
        this.Correo_cli = Correo_cli;
        this.Tel_cli = Tel_cli;
        this.Ext_cli = Ext_cli;
        this.Adscrp_cli = Adscrp_cli;
        this.Area_cli = Area_cli;
        this.register_date = register_date;
        this.last_update_date = last_update_date;
    }



    @Override
    public int hashCode() {
      return Objects.hash(id_cliente, Nombre_cli);
    }
  
    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (!(obj instanceof Cliente))
        return false;
        Cliente other = (Cliente) obj;
      return Objects.equals(id_cliente, other.id_cliente) && Objects.equals(Nombre_cli, other.Nombre_cli);
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
