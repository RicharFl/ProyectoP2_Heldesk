package com.ipn.Helpdesk.modelo.entidad;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Table (name = "zonaestados")


public class ZonaEstados implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdZonaEsta;

    @Column (name = "nombreE")
    private String nombree;
    @Column(name = "register_date", nullable = false)
    private Date register_date;

    @Column(name = "last_update_date")
    private Date last_update_date;

 /*    @ManyToOne (optional = true, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name = "ZonaEstados", foreignKey = @ForeignKey(name = "FK_1_ZONA_ID"))
    private usuarios usuarios; */


    public ZonaEstados(Long IdZonaEsta, String nombree, Date register_date, Date last_update_date, usuarios usuarios) {
        this.IdZonaEsta = IdZonaEsta;
        this.nombree = nombree;
        this.register_date = register_date;
        this.last_update_date = last_update_date;
        //this.usuarios = usuarios;
    }

    @PrePersist
    private void antesPersistir()
    {
      this.register_date = new Date();
    }
    
    @PreUpdate
    private void antesActualizar()
    {
      this.last_update_date = new Date();
    }
}
