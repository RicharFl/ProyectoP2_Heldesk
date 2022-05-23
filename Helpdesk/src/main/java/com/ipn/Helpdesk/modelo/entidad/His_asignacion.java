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


    @Column(name = "status SLA")
    private String status_sla;


    public His_asignacion(Long id_his_asignacion, Ticket ticket, Long id_user_inicio, Long id_user_final, String comentarios, Date register_date, Date last_update_date, String status_sla) {
        this.id_his_asignacion = id_his_asignacion;
        this.ticket = ticket;
        this.id_user_inicio = id_user_inicio;
        this.id_user_final = id_user_final;
        this.comentarios = comentarios;
        this.register_date = register_date;
        this.last_update_date = last_update_date;
        this.status_sla = status_sla;
    }

    @Override
    public int hashCode() {
      return Objects.hash(id_his_asignacion);
    }
  
    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (!(obj instanceof His_asignacion))
        return false;
        His_asignacion other = (His_asignacion) obj;
      return Objects.equals(id_his_asignacion, other.id_his_asignacion);
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
