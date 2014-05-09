package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Noticias database table.
 * 
 */
@Entity
@Table(name="Noticias")
@NamedQueries({
@NamedQuery(name="Noticia.findAll", query="SELECT n FROM Noticia n"),
@NamedQuery(name="Noticia.findTema", query="SELECT n FROM Noticia n JOIN n.categoria c WHERE c.tema = :tema"),
})
public class Noticia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idNoticias;

	@Column(name="Fecha")
	private String fecha;

	@Column(name="Fuente")
	private String fuente;

	@Column(name="Link")
	private String link;

	@Column(name="Titulo")
	private String titulo;

	//bi-directional many-to-one association to Categoria
	@ManyToOne
	@JoinColumn(name="Categoria_idCategoria")
	private Categoria categoria;

	public Noticia() {
	}

	public int getIdNoticias() {
		return this.idNoticias;
	}

	public void setIdNoticias(int idNoticias) {
		this.idNoticias = idNoticias;
	}

	public String getFecha() {
		return this.fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getFuente() {
		return this.fuente;
	}

	public void setFuente(String fuente) {
		this.fuente = fuente;
	}

	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}