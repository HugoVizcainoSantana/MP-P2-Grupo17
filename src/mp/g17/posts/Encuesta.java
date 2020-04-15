package mp.g17.posts;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mp.g17.users.Usuario;

class Encuesta extends EntradaGenerica {
    private List<Pregunta> poll;
    Map<Usuario,Object[][]> answers = new HashMap<>();
    
    public void addQuestion(Pregunta question){
        poll.add(question);
    }
    
    public void deleteQuestion(Pregunta question){
        poll.remove(question);
    }
    
    public void addUserAnswer(Usuario user,Encuesta poll, Pregunta question){
        Object[][] a = new Object[][]{ {poll, question} };
        answers.put(user,a);
    }
    
    public void deleteUserAnswer(Usuario user,Encuesta poll, Pregunta question){
        Object[][] a = new Object[][]{{poll, question} };
        answers.remove(user,a);
    }

    public List<Pregunta> getEncuesta() {
        return poll;
    }

    public void setEncuesta(List<Pregunta> poll) {
        this.poll = poll;
    }

    public Map<Usuario, Object[][]> getRespuestas() {
        return answers;
    }

    public void setRespuestas(Map<Usuario, Object[][]> answers) {
        this.answers = answers;
    }
    
    
}
