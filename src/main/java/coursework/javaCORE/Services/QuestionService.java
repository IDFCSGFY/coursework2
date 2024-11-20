package coursework.javaCORE.Services;

import coursework.javaCORE.Model.Question;

import java.util.Collection;

public interface QuestionService {
    Question add(String question, String answer);

    Question remove(String question, String answer);

    Collection<Question> getAll();

    Question getRandomQuestion();

    int sizeOfQuestionRepository();
}
