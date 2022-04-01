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
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "usuarios", schema = "helpdesk_qa_prep")
public class usuarios implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user;

    @Column(name = "nombre_user")
    private String nombre_user;

    @Column(name = "ApellidoM_user")
    private String apellidom_user;

    @Column(name = "ApellidoP_user")
    private String apellidop_user;

    @Column(name = "correo_user")
    private String correo_user;
    @Column(name = "password")
    private String password;

    @Column(name = "ext_user")
    private Integer ext_user;

    @Column(name = "tel_user")
    private Integer tel_user;

    @Column(name = "staus_user")
    private String staus_user;

    @ManyToOne(optional = true, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name = "id_per", foreignKey = @ForeignKey(name = "FK_1_Perfil_ID"))
    private perfil perfil;

   // @OneToMany(mappedBy = "id_zona", fetch = FetchType.LAZY)
    //private Set<ZonaEstados> zona_estado;

    @Column(name = "fecha_creacion", nullable = false)
    private Date register_date;

    @Column(name = "fecha_modificacion")
    private Date last_update_date;

    public usuarios(Long id_user, String nombre_user, String apellidom_user, String apellidop_user, String correo_user, Integer ext_user, Integer tel_user, String staus_user, perfil perfil, Set<ZonaEstados> zona_estado, Date register_date) {
        this.id_user = id_user;
        this.nombre_user = nombre_user;
        this.apellidom_user = apellidom_user;
        this.apellidop_user = apellidop_user;
        this.correo_user = correo_user;
        this.ext_user = ext_user;
        this.tel_user = tel_user;
        this.staus_user = staus_user;
        this.perfil = perfil;
        //this.zona_estado = zona_estado;
        this.register_date = register_date;
       
    }
    @Override
	public String toString() 
	{
		StringBuilder builder = new StringBuilder();
		builder.append("Usuario [id = ");
        builder.append(id_user);
        builder.append(", Nombre  = ");
        builder.append(nombre_user);
        builder.append(", Apellido Parterno  = ");
        builder.append(apellidop_user);
        builder.append(", Apellido Parterno   = ");
        builder.append(apellidom_user);
        builder.append(", Correo=");
		builder.append(correo_user);
		builder.append(", Estaus de Usuario =");
		builder.append(staus_user);
		builder.append("]");
		return builder.toString();

	
	}



}
