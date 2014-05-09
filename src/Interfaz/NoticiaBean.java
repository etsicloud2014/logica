package Interfaz;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import model.Noticia;

@ManagedBean
@RequestScoped
public class NoticiaBean extends Noticia{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String texto;
	private String subTema;
	private String tema;
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getSubTema() {
		return subTema;
	}
	public void setSubTema(String subTema) {
		this.subTema = subTema;
	}
	public String getTema() {
		return tema;
	}
	public void setTema(String tema) {
		this.tema = tema;
	}

}
