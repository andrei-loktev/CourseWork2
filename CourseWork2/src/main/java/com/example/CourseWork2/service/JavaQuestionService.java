package com.example.CourseWork2.service;

import com.example.CourseWork2.exception.QuestionIsAlreadyThereException;
import com.example.CourseWork2.exception.QuestionNotFoundException;
import com.example.CourseWork2.object.Question;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class JavaQuestionService implements QuestionService{
    private Set<Question> questions = new HashSet<>();
    private static final Random RANDOM = new Random();

    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        if (questions.add(question)) {
            return question;
        }
        throw new QuestionIsAlreadyThereException();
    }

    @Override
    public Question remove(Question question) {
        if (questions.remove(question)) {
            return question;
        }
        throw new QuestionNotFoundException();
    }

    @Override
    public Collection<Question> getAll() {

        return Collections.unmodifiableSet(questions);
    }

    @Override
    public Question getRandomQuestion() {
        if (questions.isEmpty()) {
            throw new QuestionNotFoundException();
        }
        int index = RANDOM.nextInt(questions.size());
        return questions.stream()
                .skip(index)  // пропуск ограниченного кол-ва рандомных вопросов
                .findFirst()  // берём первый элемент
                .orElseThrow(QuestionNotFoundException::new);  // достаём элемент из option
    }
}
