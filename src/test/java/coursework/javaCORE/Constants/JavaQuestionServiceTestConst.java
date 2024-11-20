package coursework.javaCORE.Constants;

import coursework.javaCORE.Model.Question;

public class JavaQuestionServiceTestConst {
    public static final String expQ = "Question";
    public static final String expA = "Answer";
    public static final Question EXP_QUESTION_OBJ = new Question(expQ, expA);
    public static final String altQ = "Alternative question";
    public static final String altA = "Alternative answer";
    public static final Question ALT_QUESTION_OBJ = new Question(altQ, altA);

    public static final String CORRECT_Q_OR_A = "This is a question or an answer";
    public static final String NULL = null;
    public static final String EMPTY = "";
    public static final String BLANK = " ";
}
