package mp.g17.users;

import mp.g17.Subforo;
import mp.g17.demostrator.Sistema;
import mp.g17.events.EventoEntradaCreada;
import mp.g17.events.IObserver;
import mp.g17.posts.EntradaGenerica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.logging.Logger;

public abstract class Usuario implements IObserver<EventoEntradaCreada>, Serializable {
    protected String firstname;
    protected String lastname;
    protected String alias;
    protected String email;
    protected String password;
    protected List<Subforo> suscribedSubforos; //List that saves in which forums are the user subscribed
    protected List<EntradaGenerica> createdEntradas;
    protected List<EventoEntradaCreada> notifications;
    private static Logger LOGGER = Sistema.LOGGER;


    public Usuario(String firstname, String lastname, String alias, String email, String password) {//Constructor for a general user
        this.firstname = firstname;
        this.lastname = lastname;
        this.alias = alias;
        this.email = email;
        this.password = password;
        this.suscribedSubforos= new ArrayList<>();
        this.createdEntradas= new ArrayList<>();
        this.notifications = new ArrayList<>();
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFullName() {
        return this.firstname + " " + this.lastname;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Subforo> getSuscribedSubForos() {
        return suscribedSubforos;
    }

    public void setSuscribedSubForos(List<Subforo> suscribedSubforos) {
        this.suscribedSubforos = suscribedSubforos;
    }
    public void subscribeForum(Subforo subforo){
        suscribedSubforos.add((subforo));
        subforo.addUser(this);
    }

    @Override
    public boolean equals(Object o) {//Remade equals
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Usuario other = (Usuario) o;

        if (!firstname.equals(other.firstname)) return false;
        if (!lastname.equals(other.lastname)) return false;
        if (!alias.equals(other.alias)) return false;
        if (!email.equals(other.email)) return false;
        return password.equals(other.password);
    }

    @Override
    public int hashCode() {
        int result = firstname.hashCode();
        result = 31 * result + lastname.hashCode();
        result = 31 * result + alias.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }


    @Override
    public String toString() {//Remade toString
        return new StringJoiner(", ", Usuario.class.getSimpleName() + "[", "]")
                .add("firstname='" + firstname + "'")
                .add("lastname='" + lastname + "'")
                .add("alias='" + alias + "'")
                .add("email='" + email + "'")
                .add("password='" + password + "'")
                .add("suscribedSubforos=" + suscribedSubforos)
                .toString();
    }

    @Override
    public void update(EventoEntradaCreada event) {
        LOGGER.info("Se ha creado una nueva entrada. " + event.toString());
        notifications.add(event);
    }
    
    public int getNumberNotifications(){
        return notifications.size();
    }

}
