package mp.g17.posts;

import java.util.ArrayList;

class Encuesta extends EntradaGenerica {

    private ArrayList<String> respuestas = new ArrayList<>();


    public ArrayList<String> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(ArrayList<String> respuestas) {
        this.respuestas = respuestas;
    }
}
