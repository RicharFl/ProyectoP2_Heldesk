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


@Table(name = "Almacen", schema = "helpdesk_qa_prep")
public class Almacen implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_almacen;

    @OneToMany (mappedBy = "almacen", fetch = FetchType.LAZY)
    private Set<Sol_Alm> sol_Alms;

    @Column(name = "Marca")
    private String Marca;

    @Column(name = "Modelo")
    private String Moedelo;
    @Column(name = "Descripcin")
    private String Descripcin;

    @Column(name = "stoc")
    private Integer stoc;

    @Column(name = "fecha_creacion", nullable = false)
    private Date register_date;

    @Column(name = "fecha_modificacion")
    private Date last_update_date;


    public Almacen(Long id_almacen, Set<Sol_Alm> sol_Alms, String Descripcin, Integer stoc, Date register_date, Date last_update_date) {
        this.id_almacen = id_almacen;
        this.sol_Alms = sol_Alms;
        this.Descripcin = Descripcin;
        this.stoc = stoc;
        this.register_date = register_date;
        this.last_update_date = last_update_date;
    }


    
    @Override
    public int hashCode() {
        return Objects.hash(sol_Alms, id_almacen);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Almacen))
            return false;
        Almacen other = (Almacen) obj;
        return Objects.equals(sol_Alms, other.sol_Alms) && Objects.equals(id_almacen, other.id_almacen);
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
