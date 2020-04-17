package mp.g17.posts;

import mp.g17.users.Usuario;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class PreguntaEncuesta {
    private String question;
    private Set<String> answers;
    private Map<Usuario, String> answersRegistered;

    public PreguntaEncuesta(String question) {
        this.question = question;
        this.answers = new HashSet<>();
        this.answersRegistered = new HashMap<>();
    }

    public Set<String> addAnswer(String newAnswer) {
        answers.add(newAnswer);
        return answers;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Map<Usuario, String> getAnswersRegistered() {
        return answersRegistered;
    }

    public boolean answer(Usuario user, String answer) {
        try {
            if (answers.contains(answer)) {
                answersRegistered.put(user, answer);
                return true;
            } else throw new IllegalArgumentException("La respuesta mandada no es una de las posibles para esta pregunta");
        } catch (IllegalArgumentException e) {
            System.err.println("Error almacenando respuesta de encuesta. " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error guardando la respuesta...");
        }
        return false;
    }
}
