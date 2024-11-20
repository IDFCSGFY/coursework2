package coursework.javaCORE.Services;

import coursework.javaCORE.Model.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private Set<Question> questionSet;
    private Random random = new Random();

    public JavaQuestionService() {
        this.questionSet = new HashSet<>();
    }

    @Override
    public Question add(String question, String answer) {
        if (question == null || answer == null ||
                question.isBlank() || answer.isBlank()) {
            throw new IllegalArgumentException();
        }
        Question target = new Question(question, answer);
        questionSet.add(target);
        return target;
    }

    @Override
    public Question remove(String question, String answer) {
        if (question == null || answer == null ||
                question.isBlank() || answer.isBlank()) {
            throw new IllegalArgumentException();
        }
        Question target = new Question(question, answer);
        questionSet.remove(target);
        return target;
    }

    @Override
    public Collection<Question> getAll() {
        return List.copyOf(questionSet);
    }

    @Override
    public Question getRandomQuestion() {
        return ((List<Question>) getAll()).get(random.nextInt(questionSet.size()));
    }

    @Override
    public int sizeOfQuestionRepository() {
        return questionSet.size();
    }
}
