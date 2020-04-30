package mp.g17.posts;

import mp.g17.users.Profesor;
import mp.g17.users.Usuario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Encuesta extends EntradaGenerica {
    private List<PreguntaEncuesta> polls;

    public Encuesta(Profesor createdBy, String title) { //Constructor poll
        super(createdBy, title);
        this.polls = new ArrayList<>();
    }

    public void addQuestion(PreguntaEncuesta question) {
        polls.add(question);
    }

    public void deleteQuestion(PreguntaEncuesta question) {
        polls.remove(question);
    }

    public List<PreguntaEncuesta> getPolls() {
        return polls;
    }

    public void setPolls(List<PreguntaEncuesta> polls) {
        this.polls = polls;
    }

    public Map<String, Map<String, Long>> getAllAnswersAnonymously() { //This method gives back answers anonymously and the poll's name
        Map<String, Map<String, Long>> answers = new HashMap<>();
        polls.forEach(poll -> answers.put(
                poll.getQuestion(),
                poll.getAnswersRegistered() //Returns the answers from the list and puts in a sort new one
                        .values()
                        .stream()
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        ));
        return answers;
    }

    public Map<String, Map<Usuario, String>> getAllAnswers() { //This method gives back the anwers from every voted user and the poll's name
        Map<String, Map<Usuario, String>> answers = new HashMap<>();
        polls.forEach(poll -> answers.put(
                poll.getQuestion(),
                poll.getAnswersRegistered()
        ));
        return answers;
    }


}

