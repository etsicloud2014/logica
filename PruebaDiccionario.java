/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diccionario;

/**
 *
 * @author borja
 */
public class PruebaDiccionario {
    public static void main(String[] args){
        Diccionario dic = new Diccionario();
        for (String s : dic.getPalabras())
            System.out.println(s);
        String tipo;
        tipo=dic.getTipo("discoteca");
        if (tipo==null)
            System.out.println("No se reconoce el tipo de palabra");
        System.out.println(tipo);
    }
    
    
}
