package mp.g17.posts;

import mp.g17.users.Usuario;
import mp.g17.utils.LoggerUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

public class PreguntaEncuesta {
    private String question;
    private Set<String> answers;
    private Map<Usuario, String> answersRegistered;
    public static Logger LOGGER = LoggerUtils.getLogger(PreguntaEncuesta.class.getSimpleName());

    public PreguntaEncuesta(String question) { //Constructor of the questions from the poll
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

    public boolean answer(Usuario user, String answer) { //This method is used to answer a poll's question
        try {
            if (answers.contains(answer)) {
                answersRegistered.put(user, answer);
                return true;
            } else throw new IllegalArgumentException("La respuesta mandada no es una de las posibles para esta pregunta"); //This part is in charge of that if the answer is not in a correct format or returns a mistake
        } catch (IllegalArgumentException e) {
            LOGGER.severe("Error almacenando respuesta de encuesta. " + e.getMessage());
        } catch (Exception e) {
            LOGGER.severe("Error guardando la respuesta...");
        }
        return false;
    }
}

