package com.ipn.Helpdesk.modelo.entidad;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "UsuarioPerfil", schema = "helpdesk_qa_prep")
public class UsuarioPerfil implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idusuarioPerfil;

	//@ManyToOne(optional = true, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	 @ManyToOne(optional = true, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "id_user", foreignKey = @ForeignKey(name = "FK_1_USUARIO_PERFIL_ID"))
	private Usuarios usuarios;

	//@ManyToOne(optional = true, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	 @ManyToOne(optional = true, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "Id_per", foreignKey = @ForeignKey(name = "FK_4_PERFIL_ID"))
	private Perfil perfil;
	 //@ManyToOne(optional = true, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
		//@JoinColumn(name = "id_zona", foreignKey = @ForeignKey(name = "FK_1_ZONA_ID"))
	//	private ZonaEstados zonaestados;
	 
	 public UsuarioPerfil()
	 {
		 
	 }
	public UsuarioPerfil(Long idusuarioPerfil, Usuarios usuarios, Perfil perfil) {
		super();
		this.idusuarioPerfil = idusuarioPerfil;
		this.usuarios = usuarios;
		this.perfil = perfil;
	}

	public Long getIdusuarioPerfil() {
		return idusuarioPerfil;
	}

	public void setIdusuarioPerfil(Long idusuarioPerfil) {
		this.idusuarioPerfil = idusuarioPerfil;
	}

	public Usuarios getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

}
