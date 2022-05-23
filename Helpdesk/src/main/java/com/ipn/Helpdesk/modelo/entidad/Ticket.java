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

    @PrePersist
    private void antesPersistir() {
        this.register_date = new Date();
    }

    @PreUpdate
    private void antesActualizar() {
        this.last_update_date = new Date();
    }

}
