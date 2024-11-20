package coursework.javaCORE.Services;

import coursework.javaCORE.Model.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static coursework.javaCORE.Constants.JavaQuestionServiceTestConst.*;

class JavaQuestionServiceTest {

    private QuestionService out;

    @BeforeEach
    void setUp() {
        this.out = new JavaQuestionService();
    }

    @Test
    public void shouldReturnObjectOfQuestionClassWhileAdding() {
        assertEquals(EXP_QUESTION_OBJ, out.add(expQ, expA));
    }

    @ParameterizedTest
    @MethodSource("provideArgsForThrowingIllegalArgumentException")
    public void shouldThrowIllegalArgumentExceptionWhileAdding(String q, String a) {
        assertThrows(IllegalArgumentException.class, () -> out.add(q, a));
    }

    @Test
    public void shouldReturnObjectOfQuestionClassWhileRemoving() {
        assertEquals(EXP_QUESTION_OBJ, out.add(expQ, expA));
        assertEquals(EXP_QUESTION_OBJ, out.remove(expQ, expA));
    }

    @ParameterizedTest
    @MethodSource("provideArgsForThrowingIllegalArgumentException")
    public void shouldThrowIllegalArgumentExceptionWhileRemoving(String q, String a) {
        assertThrows(IllegalArgumentException.class, () -> out.remove(q, a));
    }

    @Test
    public void shouldGetAllQuestionsInList() {
        List<Question> expected = List.of(EXP_QUESTION_OBJ);
        out.add(expQ, expA);
        assertEquals(expected, out.getAll());
    }

    @Test
    public void shouldGetRandQuestion() {
        out.add(expQ, expA);
        assertEquals(EXP_QUESTION_OBJ, out.getRandomQuestion());

        out.add(altQ, altA);
        Question outObj = out.getRandomQuestion();
        assertTrue(outObj.equals(EXP_QUESTION_OBJ)
                || outObj.equals(ALT_QUESTION_OBJ));
    }

    @Test
    public void shouldGetSize() {
        out.add(expQ, expA);
        assertEquals(1, out.sizeOfQuestionRepository());

        out.add(expQ, expA);
        assertEquals(1, out.sizeOfQuestionRepository());

        out.add(altQ, altA);
        assertEquals(2, out.sizeOfQuestionRepository());
    }

    public static Stream<Arguments> provideArgsForThrowingIllegalArgumentException() {
        return Stream.of(
                Arguments.of(CORRECT_Q_OR_A, NULL),
                Arguments.of(CORRECT_Q_OR_A, EMPTY),
                Arguments.of(CORRECT_Q_OR_A, BLANK),
                Arguments.of(NULL, CORRECT_Q_OR_A),
                Arguments.of(EMPTY, CORRECT_Q_OR_A),
                Arguments.of(BLANK, CORRECT_Q_OR_A)
        );
    }
}