package logica;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Interfaz.NoticiaBean;
import model.Categoria;
import model.Noticia;

/**
 * Session Bean implementation class EcloudEJB
 */
@Singleton
@LocalBean
public class EcloudEJB {


	List<Noticia> noticias;
	List<Noticia> ultimas=new ArrayList<Noticia>();
	@PersistenceContext
	private EntityManager em;

    @SuppressWarnings("unchecked")
    public List<Noticia> getUniversidad(){
    	noticias= (List<Noticia>)em.createNamedQuery("Noticia.findTema").setParameter("tema", "Universidad").getResultList();
    	return noticias;
    }
    @SuppressWarnings("unchecked")
	public List<Noticia> getAnuncios(){
    	noticias= (List<Noticia>)em.createNamedQuery("Noticia.findTema").setParameter("tema", "Anuncios").getResultList();
    	return noticias;
    }
    @SuppressWarnings("unchecked")
	public List<Noticia> getUltimas(){
    	ultimas.clear();
    	noticias= (List<Noticia>)em.createNamedQuery("Noticia.findAll").getResultList();
    	int i=noticias.size();
    	if (i>5){
    		for(int j=0;j<5;j++){
    			ultimas.add(noticias.get(i-1-j));
    		}
    		return ultimas;
    	}
    	return noticias;
    }

    public void setInfo(NoticiaBean nb){
    	
    	Categoria cat = new Categoria ();
    	Noticia noticia=new Noticia();
    	noticia.setFecha(nb.getFecha());
    	
    	cat= (Categoria)em.createNamedQuery("Categoria.findSubTema").setParameter("subtema", nb.getSubTema()).getSingleResult();
    	noticia.setCategoria(cat);
    	noticia.setFuente(nb.getFuente());
    	String link=("/home/borja/proyectos/ecloud/noticias/"+nb.getTitulo()+"_parseado.xml");
    			
    	noticia.setLink(link);
    	noticia.setTitulo(nb.getTitulo());

    	AbrirXml.save(nb);
    	em.persist(noticia);
    }
}
