package com.ipn.Helpdesk.modelo.entidad;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.ForeignKey;


@Setter
@NoArgsConstructor
@Getter
@Entity

@Table(name = "his_asigancion",schema = "helpdesk_qa_prep" )

public class His_asignacion implements Serializable  {
    
   @Id
   @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id_his_asignacion;

    
    @ManyToOne(optional = true, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name = "id_ticket", foreignKey = @ForeignKey(name = "FK_1_ticket"))
    private Ticket ticket;

    @Column (name = "id_user_inicio")
    private Long id_user_inicio;

    @Column (name = "id_user_final")
    private Long id_user_final;

    @Column (name = "comentarios")
    private String  comentarios;


    @Column(name = "fecha_creacion", nullable = false)
    private Date register_date;

    @Column(name = "fecha_modificacion")
    private Date last_update_date;



}
