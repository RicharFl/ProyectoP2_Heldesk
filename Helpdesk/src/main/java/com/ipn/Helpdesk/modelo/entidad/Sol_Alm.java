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
@NoArgsConstructor
@Table(name = "Sol_Alm", schema = "helpdesk_qa_prep")

public class Sol_Alm implements Serializable {
	
	 /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_solalm;

    @ManyToOne(optional = true, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name = "Id_ticket", foreignKey = @ForeignKey(name = "FK_1_Id_ticket2"), nullable=false)
    private Ticket ticket;

    @Column(name = "id_user")
    private String id_user;

    

    @ManyToOne(optional = true, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name = "id_almacen", foreignKey = @ForeignKey(name = "FK_1_id_almacen"), nullable=false)
    private Almacen almacen ;

    @Column(name = "Comtario")
    private String comeString;

    @Column(name = "Cantidad")
    private Integer Cantidad;

    @Column(name = "Guia")
    private String Guia;


    @Column(name = "Fec_inicio", nullable = false)
    private Date Fec_inicio;

    @Column(name = "Sla_status_hist")
    private Long Sla_status_hist;

    @Column(name = "fecha_creacion", nullable = false)
    private Date register_date;

    @Column(name = "fecha_modificacion")
    private Date last_update_date;



    public Sol_Alm(Long Id_solalm, Ticket ticket, String id_user, Almacen almacen, String comeString, Integer Cantidad, String Guia, Date Fec_inicio, Long Sla_status_hist, Date register_date, Date last_update_date) {
        this.Id_solalm = Id_solalm;
        this.ticket = ticket;
        this.id_user = id_user;
        this.almacen = almacen;
        this.comeString = comeString;
        this.Cantidad = Cantidad;
        this.Guia = Guia;
        this.Fec_inicio = Fec_inicio;
        this.Sla_status_hist = Sla_status_hist;
        this.register_date = register_date;
        this.last_update_date = last_update_date;
    }
  

    
    @Override
    public int hashCode() {
        return Objects.hash(Id_solalm, id_user);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Sol_Alm))
            return false;
        Sol_Alm other = (Sol_Alm) obj;
        return Objects.equals(Id_solalm, other.Id_solalm) && Objects.equals(id_user, other.id_user);
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
