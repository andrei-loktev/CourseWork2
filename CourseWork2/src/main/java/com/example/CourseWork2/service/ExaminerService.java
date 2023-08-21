package com.example.CourseWork2.service;

import com.example.CourseWork2.object.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int mount);
}
