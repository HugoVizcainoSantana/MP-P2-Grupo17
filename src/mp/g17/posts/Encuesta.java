package mp.g17.posts;

import java.util.HashMap;
import java.util.List;

class Encuesta extends EntradaGenerica {

    private List<String> respuestas;
    HashMap<String, String> respuestasUsuarios = new HashMap<String, String>();

    public List<String> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<String> respuestas) {
        this.respuestas = respuestas;
    }
}
