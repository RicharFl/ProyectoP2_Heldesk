package com.ipn.Helpdesk.modelo.entidad;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Table(name = "zonaestados", schema = "helpdesk_qa_prep")
public class ZonaEstados implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long Id_zon;

  @Column(name = "nombreE")
  private String nombree;
  @Column(name = "register_date", nullable = false)
  private Date register_date;

  @Column(name = "last_update_date")
  private Date last_update_date;

  @OneToMany(mappedBy = "zonaestado", fetch = FetchType.LAZY)
  private Set<usuarios> usuarios;

 /*  @OneToMany(mappedBy = "zonaestado", fetch = FetchType.LAZY)
    private Set<EstadosRepu> estadosrepu; */


    @ManyToOne (optional = true, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name = "id_per", foreignKey = @ForeignKey(name = "FK_1_ZONA_ID"))
    private EstadosRepu estadosrepu;

  public ZonaEstados(Long IdZonaEsta, String nombree, Date register_date, Date last_update_date) {
    this.Id_zon = IdZonaEsta;
    this.nombree = nombree;
    this.register_date = register_date;
    this.last_update_date = last_update_date;

  }

  @Override
  public int hashCode() {
    return Objects.hash(Id_zon, nombree);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!(obj instanceof ZonaEstados))
      return false;
    ZonaEstados other = (ZonaEstados) obj;
    return Objects.equals(Id_zon, other.Id_zon) && Objects.equals(nombree, other.nombree);
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
