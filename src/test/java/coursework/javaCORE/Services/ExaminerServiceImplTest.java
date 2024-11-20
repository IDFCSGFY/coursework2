package coursework.javaCORE.Services;

import coursework.javaCORE.Exceptions.NotEnoughQuestionsToFulfillRequestException;
import coursework.javaCORE.Model.Question;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static coursework.javaCORE.Constants.JavaQuestionServiceTestConst.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    JavaQuestionService serviceMock;

    @InjectMocks
    ExaminerServiceImpl out;

    @Test
    public void shouldThrowNotEnoughQuestionsToFulfillRequestException() {
        when(serviceMock.sizeOfQuestionRepository()).thenReturn(1);
        assertThrows(NotEnoughQuestionsToFulfillRequestException.class, () -> out.getQuestions(2));
        assertDoesNotThrow(() -> out.getQuestions(1));
    }

    @Test
    public void shouldReturnHashSetOfRandQuestions() {
        Set<Question> expected = new HashSet<>();
        expected.add(EXP_QUESTION_OBJ);
        when(serviceMock.sizeOfQuestionRepository()).thenReturn(1);
        when(serviceMock.getRandomQuestion()).thenReturn(EXP_QUESTION_OBJ);
        assertEquals(expected, out.getQuestions(1));

        expected.add(ALT_QUESTION_OBJ);
        when(serviceMock.sizeOfQuestionRepository()).thenReturn(2);
        when(serviceMock.getRandomQuestion()).thenReturn(EXP_QUESTION_OBJ).thenReturn(ALT_QUESTION_OBJ);
        assertEquals(expected, out.getQuestions(2));
    }
}