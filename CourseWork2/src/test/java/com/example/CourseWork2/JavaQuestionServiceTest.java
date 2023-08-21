package com.example.CourseWork2;

import com.example.CourseWork2.object.Question;
import com.example.CourseWork2.service.JavaQuestionService;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JavaQuestionServiceTest {
    JavaQuestionService javaQuestionService = new JavaQuestionService();

    @Test
    public void add(){
        javaQuestionService.add("123","234");
        javaQuestionService.add("345","456");
        Collection<Question> actual = javaQuestionService.getAll();
        assertEquals(2,actual.size());
        assertTrue(actual.contains(new Question("123","234")));
        assertTrue(actual.contains(new Question("345","456")));
    }
    @Test
    public void remove(){
        Question q1 = javaQuestionService.add("123", "234");
        Question q2 = javaQuestionService.add("345", "456");
        javaQuestionService.remove(q1);

        Collection<Question> actual = javaQuestionService.getAll();
        assertEquals(1,actual.size());
        assertFalse(actual.contains(q1));
        assertTrue(actual.contains(q2));
    }
}
