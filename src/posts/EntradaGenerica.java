package posts;

abstract class EntradaGenerica{
    
private int puntuacion;
private String titulo;
private String texto;
private boolean verificada;

    public int getPuntuacion(){
        return puntuacion;
    }
    public abstract void verificar(boolean resultado);
    public abstract boolean comentar(String texto);
    public abstract boolean votar(int valor);
    


}
