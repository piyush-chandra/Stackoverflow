package org.piyush.Stackoverflow.repository;

import java.util.List;

import org.piyush.Stackoverflow.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
    List<Answer> findByUserId(Long userId);
    List<Answer> findByQuestionId(Long questionId);
    List<Answer> findByAnswerTextContaining(String answerText);
}
