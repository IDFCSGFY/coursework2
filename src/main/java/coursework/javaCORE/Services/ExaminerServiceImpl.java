package coursework.javaCORE.Services;

import coursework.javaCORE.Exceptions.NotEnoughQuestionsToFulfillRequestException;
import coursework.javaCORE.Model.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService service;

    public ExaminerServiceImpl(QuestionService service) {
        this.service = service;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (service.sizeOfQuestionRepository() < amount) {
            throw new NotEnoughQuestionsToFulfillRequestException();
        }
        Set<Question> target = new HashSet<>(amount);
        for (int i = 0; i < amount;) {
            if (target.add(service.getRandomQuestion())) {
                i++;
            }
        }
        return target;
    }
}
