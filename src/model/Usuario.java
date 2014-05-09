package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Usuarios database table.
 * 
 */
@Entity
@Table(name="Usuarios")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUsuarios;

	@Column(name="Admin")
	private byte admin;

	@Column(name="Apellido")
	private String apellido;

	@Column(name="Correo")
	private String correo;

	@Column(name="Nick")
	private String nick;

	@Column(name="Nombre")
	private String nombre;

	@Column(name="Pass")
	private String pass;

	//bi-directional many-to-many association to Categoria
	@ManyToMany(mappedBy="usuarios1")
	private List<Categoria> categorias1;

	//bi-directional many-to-many association to Categoria
	@ManyToMany
	@JoinTable(
		name="Usuarios_has_Categoria"
		, joinColumns={
			@JoinColumn(name="Usuarios_idUsuarios")
			}
		, inverseJoinColumns={
			@JoinColumn(name="Categoria_idCategoria")
			}
		)
	private List<Categoria> categorias2;

	public Usuario() {
	}

	public int getIdUsuarios() {
		return this.idUsuarios;
	}

	public void setIdUsuarios(int idUsuarios) {
		this.idUsuarios = idUsuarios;
	}

	public byte getAdmin() {
		return this.admin;
	}

	public void setAdmin(byte admin) {
		this.admin = admin;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNick() {
		return this.nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public List<Categoria> getCategorias1() {
		return this.categorias1;
	}

	public void setCategorias1(List<Categoria> categorias1) {
		this.categorias1 = categorias1;
	}

	public List<Categoria> getCategorias2() {
		return this.categorias2;
	}

	public void setCategorias2(List<Categoria> categorias2) {
		this.categorias2 = categorias2;
	}

}