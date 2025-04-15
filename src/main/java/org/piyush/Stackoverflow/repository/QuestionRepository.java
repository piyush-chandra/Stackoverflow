package org.piyush.Stackoverflow.repository;

import java.util.List;

import org.piyush.Stackoverflow.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findByTitleContaining(String title);
    List<Question> findByTagsContaining(String tags);
    List<Question> findByUserId(Long userId); 
}
