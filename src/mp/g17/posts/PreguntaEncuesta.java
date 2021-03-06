package mp.g17.posts;

import mp.g17.demostrator.Sistema;
import mp.g17.users.Usuario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class PreguntaEncuesta implements Serializable {
    private String question;
    private List<String> answers;
    private Map<Usuario, String> answersRegistered;
    private static Logger LOGGER = Sistema.LOGGER;


    public PreguntaEncuesta(String question) { //Constructor of the questions from the poll
        this.question = question;
        this.answers = new ArrayList<>();
        this.answersRegistered = new HashMap<>();
    }

    public List<String> addAnswer(String newAnswer) {
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
            } else
                throw new IllegalArgumentException("La respuesta mandada no es una de las posibles para esta pregunta"); //This part is in charge of that if the answer is not in a correct format or returns a mistake
        } catch (IllegalArgumentException e) {
            LOGGER.severe("Error almacenando respuesta de encuesta. " + e.getMessage());
        } catch (Exception e) {
            LOGGER.severe("Error guardando la respuesta...");
        }
        return false;
    }

    public List<String> getAnswers() {
        return answers;
    }
}

