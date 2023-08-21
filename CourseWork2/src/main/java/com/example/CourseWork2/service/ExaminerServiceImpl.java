package com.example.CourseWork2.service;

import com.example.CourseWork2.exception.NotEnoughQuestionException;
import com.example.CourseWork2.object.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@Service
public class ExaminerServiceImpl implements ExaminerService{
    private final JavaQuestionService questionService;

    public ExaminerServiceImpl(JavaQuestionService questionService) {

        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int mount) {
        if (mount > questionService.getAll().size()) {
            throw new NotEnoughQuestionException();
        }
        return Stream.generate(questionService::getRandomQuestion)
                .distinct()  //стрим берёт уникальные элементы
                .limit(mount)  //ограничивать количество
                .collect(Collectors.toList());  //собирает в список
    }
}
