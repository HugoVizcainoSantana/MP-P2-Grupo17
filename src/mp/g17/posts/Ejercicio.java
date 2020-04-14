package mp.g17.posts;

import mp.g17.users.Usuario;

public class Ejercicio extends EntradaGenerica {

private String solucion;


    @Override
    public void verify(boolean resultado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean comment(Comentario texto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean vote(int valor, Usuario usuarioComent, Usuario usuarioVoto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getSolucion() {
        return solucion;
    }

    public void setSolucion(String solucion) {
        this.solucion = solucion;
    }
}
