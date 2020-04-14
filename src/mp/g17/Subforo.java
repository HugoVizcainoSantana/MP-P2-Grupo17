package mp.g17;

import java.util.List;

import mp.g17.events.EventoEntradaCreada;
import mp.g17.users.Usuario;
import mp.g17.posts.EntradaGenerica;

public class Subforo {
    private String name;
    private List<Usuario> usersForo;
    private List<EntradaGenerica> inputSubforo;

    public String getName() {
        return name;
    }

    public void setName(String nombre) {
        this.name = nombre;
    }

    public void addUser (Usuario subs){
        usersForo.add(subs);
    }

    public void addInput (EntradaGenerica input){
        inputSubforo.add(input);
    }

    public void deleteUser (Usuario subs){
        usersForo.remove(subs);
    }

    public void deleteInput (EntradaGenerica input){
        inputSubforo.remove(input);
    }

    private void notifyUsers (){
        usersForo.forEach(user -> user.update(new EventoEntradaCreada(this,null)));
    }


}
