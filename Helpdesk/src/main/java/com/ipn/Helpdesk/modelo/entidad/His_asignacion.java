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
    
	 /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
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


  
    
    @Column(name = "status_sla")
    private String status_sla;

    public His_asignacion()
    {
    	
    }



    public His_asignacion(Long id_his_asignacion, Ticket ticket, Long id_user_inicio, Long id_user_final,
			String comentarios, Date register_date, Date last_update_date, String status_sla) {
		super();
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

	public Long getId_his_asignacion() {
		return id_his_asignacion;
	}

	public void setId_his_asignacion(Long id_his_asignacion) {
		this.id_his_asignacion = id_his_asignacion;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public Long getId_user_inicio() {
		return id_user_inicio;
	}

	public void setId_user_inicio(Long id_user_inicio) {
		this.id_user_inicio = id_user_inicio;
	}

	public Long getId_user_final() {
		return id_user_final;
	}

	public void setId_user_final(Long id_user_final) {
		this.id_user_final = id_user_final;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
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

	public String getStatus_sla() {
		return status_sla;
	}

	public void setStatus_sla(String status_sla) {
		this.status_sla = status_sla;
	}


    
    
    

}
