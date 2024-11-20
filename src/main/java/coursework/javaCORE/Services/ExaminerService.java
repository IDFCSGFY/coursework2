package coursework.javaCORE.Services;

import coursework.javaCORE.Model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
