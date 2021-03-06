package mp.g17.posts;

import mp.g17.users.Usuario;

import java.util.ArrayList;
import java.util.List;

public class Entrada extends EntradaGenerica {
    private List<EntradaGenerica> entradas = new ArrayList<>();
    private boolean verified;

    public Entrada(Usuario createdBy, String title) { //Constructor of a new post
        super(createdBy, title);
        this.verified = false;
    }

    public void verify(boolean resultado) {
        setVerified(resultado);
    }
    public void setEntradas(List<EntradaGenerica> entradas) {
        this.entradas = entradas;
    }
    public void setVerified(boolean verified) {
        this.verified = verified;
    }
    public boolean isVerified() {
        return verified;
    }

    public void add(EntradaGenerica entry) {
        entradas.add(entry);
    }

    public List<EntradaGenerica> getEntradas() {
        return entradas;
    }

    @Override
    public void vote(Boolean valor, Usuario userVoting) {
        if (!userVoting.equals(this.getCreatedBy()))
            super.vote(valor, userVoting);
    }
}
