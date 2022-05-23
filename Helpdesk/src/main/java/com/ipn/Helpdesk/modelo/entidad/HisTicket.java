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
@NoArgsConstructor

@Table(name = "HisTicket", schema = "helpdesk_qa_prep")
public class HisTicket implements Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_histori;


    @ManyToOne(optional = true, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name = "Id_ticket", foreignKey = @ForeignKey(name = "FK_1_Id_ticket"), nullable=false)
    private Ticket ticket;

    @Column(name = "Id_user")
    private Long Id_user;
    @Column(name = "Comentario")
    private String  Comentario;
    
    @Column(name = "Fec_inicio", nullable = false)
    private Date Fec_inicio;

    @Column(name = "Sla_status_hist")
    private Long Sla_status_hist;

    @Column(name = "fecha_creacion", nullable = false)
    private Date register_date;

    @Column(name = "fecha_modificacion")
    private Date last_update_date;

    


    public HisTicket(Long id_histori, Ticket ticket, Long Id_user, String Comentario, Date Fec_inicio, Long Sla_status_hist, Date register_date, Date last_update_date) {
        this.id_histori = id_histori;
        this.ticket = ticket;
        this.Id_user = Id_user;
        this.Comentario = Comentario;
        this.Fec_inicio = Fec_inicio;
        this.Sla_status_hist = Sla_status_hist;
        this.register_date = register_date;
        this.last_update_date = last_update_date;
    }


    @Override
    public int hashCode() {
        return Objects.hash(id_histori, Id_user);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof HisTicket))
            return false;
        HisTicket other = (HisTicket) obj;
        return Objects.equals(id_histori, other.id_histori) && Objects.equals(Id_user, other.Id_user);
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
