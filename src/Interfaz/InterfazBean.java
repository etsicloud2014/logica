package Interfaz;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import logica.AbrirXml;
import logica.EcloudEJB;
import logica.LanzaParser;
import model.Noticia;

@ManagedBean
@ApplicationScoped
public class InterfazBean {

	@EJB
	private EcloudEJB ejb;
	
	public List<Noticia> getUniversidad(){
		
		return ejb.getUniversidad();
	}
	public List<Noticia> getAnuncios(){
		
		return ejb.getAnuncios();
	}
	public List<Noticia> getUltimas(){
		
		return ejb.getUltimas();
	}
	public void save(NoticiaBean nb){
		nb.setFuente("user");
		Date d=new Date();
		nb.setFecha(d.toString());
		ejb.setInfo(nb);
	}
	public void lanzarParser(){
		String[] items = new String[6];
		String path=LanzaParser.lanzar();
		items=AbrirXml.open(path);
		NoticiaBean nb=new NoticiaBean();
		nb.setTitulo(items[1]);
		nb.setTema(items[2]);
		nb.setFecha(items[3]);
		nb.setFuente(items[4]);
		nb.setSubTema(items[5]);
		ejb.setInfo(nb);
	}
}
