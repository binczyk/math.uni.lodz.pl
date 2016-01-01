package com.gft.structuraltest.testconference.registrationdata;

import static org.junit.Assert.*;

import org.junit.*;

import java.util.ArrayList;
import java.util.List;

public class AnswerEntityTest {

    public static AnswerEntity ae1 = new AnswerEntity();
    public static AnswerEntity ae2 = new AnswerEntity();

    //equals

    @Before
    public void setUp() {
        ae1.setAnswerText("1");
        ae1.setId(1l);
        QuestionEntity qe1 = new QuestionEntity();
        qe1.setId(1l);
        qe1.setCorrectAnswer(1l);
        qe1.setQuestionText("1");
        qe1.setType("1");
        List<AnswerEntity> asnswers = new ArrayList<>();
        asnswers.add(ae1);
        qe1.setAnswers(asnswers);
        ae1.setQuestion(qe1);
        ae2.setAnswerText("2");
        ae2.setId(2l);
        QuestionEntity qe2 = new QuestionEntity();
        qe2.setId(2l);
        qe2.setCorrectAnswer(2l);
        qe2.setQuestionText("2");
        qe2.setType("2");
        asnswers.remove(0);
        asnswers.add(ae2);
        qe2.setAnswers(asnswers);
        ae2.setQuestion(qe2);
    }

    @Test
    public void shouldReturnFalseWhenObjectIsNull() {
        assertFalse(ae1.equals(null));
    }

    @Test
    public void shouldReturnTrueWhenObjectIsEquals() {
        assertTrue(ae1.equals(ae1));
    }

    @Test
    public void shouldReturnFalseWhenAnswerTextIsDifferent() {
        assertFalse(ae1.equals(ae2));
    }

    @Test
    public void shouldReturnFalseWhenClassIsDifferent() {
        String string = "string";
        assertFalse(ae1.equals(string));
    }

    @Test
    public void shouldReturnFalseWhenIdIsDifferent() {
        setAnswerText();
        assertFalse(ae1.equals(ae2));
    }

    @Test
    public void shouldReturnFalseWhenIdIsNull() {
        setAnswerText();
        ae1.setId(null);
        assertFalse(ae1.equals(ae2));
    }

    @Test
    public void shouldReturnFalseWhenQuestionIsNull() {
        setAnswerTextAndId();
        ae1.setQuestion(null);
        assertFalse(ae1.equals(ae2));
    }

    @Test
    public void shouldReturnFalseWhenQuestionIsDifferent() {
        setAnswerTextAndId();
        assertFalse(ae1.equals(ae2));
    }

    private void setAnswerText() {
        ae1.setAnswerText(ae2.getAnswerText());
    }


    private void setAnswerTextAndId() {
        setAnswerText();
        ae1.setId(ae2.getId());
    }

    //toString

    @Test
    public void schouldReturnTrueWhenTextIsEquals() {
        StringBuilder answerEntityTrue = new StringBuilder("AnswerEntity [id=1, answerText=1, question=");
        answerEntityTrue.append("QuestionEntity [id=1, type=1, questionText=1, correctAnswer=1]]");
        String answerEntityFalse = "";
        assertTrue(ae1.toString().equals(answerEntityTrue.toString()));
        assertFalse(ae1.toString().equals(answerEntityFalse));
    }

    //HashCode

    @Test
    public void schouldReturnTrueWhenHashIsEquals() {//napewno działą :)
        AnswerEntity ae = new AnswerEntity();
        assertFalse(ae.hashCode() == 31l);
        assertFalse(ae1.hashCode() == 31l);
    }
}