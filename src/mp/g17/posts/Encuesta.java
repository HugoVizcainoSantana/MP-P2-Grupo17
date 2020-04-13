package mp.g17.posts;

import java.util.ArrayList;
import mp.g17.users.Usuario;

class Encuesta extends EntradaGenerica {

    private ArrayList<String> respuestas = new ArrayList<>();


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

    public ArrayList<String> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(ArrayList<String> respuestas) {
        this.respuestas = respuestas;
    }
}
