package com.example.CourseWork2;

import com.example.CourseWork2.object.Question;
import com.example.CourseWork2.service.ExaminerServiceImpl;
import com.example.CourseWork2.service.JavaQuestionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
public class ExaminerServiceTest {
    @Mock
    JavaQuestionService questionService;
    @InjectMocks
    ExaminerServiceImpl examinerService;

    private final List<Question> questions = List.of(
            new Question("123", "234"),
            new Question("345", "456"),
            new Question("567", "678"),
            new Question("789", "890")
    );
    @Test
    public void getQuestions() {
        when(questionService.getAll()).thenReturn(questions);
        when(questionService.getRandomQuestion())
                .thenReturn(questions.get(0))
                .thenReturn(questions.get(1))
                .thenReturn(questions.get(2));

        Collection<Question> actual = examinerService.getQuestions(2);
        assertEquals(2, actual.size());
        assertTrue(questions.containsAll(actual));
    }
}
