package mp.g17.posts;

import java.util.List;
import mp.g17.users.Usuario;

public abstract class EntradaGenerica {

    private int puntuacion;
    private String titulo;
    private String texto;
    private boolean verificada = false;
    private List<Comentario> commentList;

    public int getPuntuacion() {
        return puntuacion;
    }

    public List<Comentario> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comentario> commentList) {
        this.commentList = commentList;
    }

    public abstract void verify(boolean resultado);

    public abstract boolean comment(Comentario texto);

    public abstract boolean vote(int valor, Usuario usuarioComent, Usuario usuarioVoto);


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public boolean isVerificada() {
        return verificada;
    }

    public void setVerificada(boolean verificada) {
        this.verificada = verificada;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
}
