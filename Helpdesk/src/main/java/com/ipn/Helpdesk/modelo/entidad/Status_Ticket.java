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
@Table(name = "Status_Ticket", schema = "helpdesk_qa_prep")
public class Status_Ticket implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_status_ticket;

    @OneToMany(mappedBy = "status_Ticket", fetch = FetchType.LAZY)
    private Set<Ticket> Ticket;

    @Column(name = "Nom_status")
    private String Nom_status;

    @Column(name = "Descr_status")
    private String Descr_status;

    @Column(name = "fecha_creacion", nullable = false)
    private Date register_date;

    @Column(name = "fecha_modificacion")
    private Date last_update_date;

    

    public Status_Ticket(Long id_status_ticket, Set<Ticket> Ticket, String Nom_status, String Descr_status, Date register_date, Date last_update_date) {
        this.id_status_ticket = id_status_ticket;
        this.Ticket = Ticket;
        this.Nom_status = Nom_status;
        this.Descr_status = Descr_status;
        this.register_date = register_date;
        this.last_update_date = last_update_date;
    }

    @Override
    public int hashCode() {
      return Objects.hash(id_status_ticket, Ticket);
    }
  
    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (!(obj instanceof Status_Ticket))
        return false;
        Status_Ticket other = (Status_Ticket) obj;
      return Objects.equals(id_status_ticket, other.id_status_ticket) && Objects.equals(Ticket, other.Ticket);
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
