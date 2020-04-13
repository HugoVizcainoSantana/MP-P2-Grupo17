package mp.g17.posts;

public class Entrada extends EntradaGenerica {
    private int i;

    @Override
    public void verificar(boolean resultado) {
        setVerificada(resultado);
    }
    
    @Override
    public boolean comentar(Comentario texto) {
        getCommentList().add(texto);
        return true;
    }

    @Override
    public boolean votar(int valor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
