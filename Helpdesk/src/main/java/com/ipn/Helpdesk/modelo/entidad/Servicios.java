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
@Table(name = "Servicios", schema = "helpdesk_qa_prep")

public class Servicios implements Serializable {
	
	 /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_serv;
    @Column(name = "Nom_service")
    private String Nom_service;

    @Column(name = "Descr_ser")
    private String Descr_ser;

    @Column(name = "Impa_ser")
    private String Impa_ser;

    @Column(name = "Sla")
    private Integer Sla;
    @OneToMany(mappedBy = "Servicios", fetch = FetchType.LAZY)
    private Set<Ticket> Ticket;

    @Column(name = "fecha_creacion", nullable = false)
    private Date register_date;

    @Column(name = "fecha_modificacion")
    private Date last_update_date;

   
  

    public Servicios(Long Id_serv, String Nom_service, String Descr_ser, String Impa_ser, Integer Sla, Date register_date, Date last_update_date, Set<Ticket> Ticket) {
        this.Id_serv = Id_serv;
        this.Nom_service = Nom_service;
        this.Descr_ser = Descr_ser;
        this.Impa_ser = Impa_ser;
        this.Sla = Sla;
        this.register_date = register_date;
        this.last_update_date = last_update_date;
        this.Ticket = Ticket;
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(Id_serv, Nom_service);
    }
  
    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (!(obj instanceof Servicios))
        return false;
        Servicios other = (Servicios) obj;
      return Objects.equals(Id_serv, other.Id_serv) && Objects.equals(Nom_service, other.Nom_service);
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
