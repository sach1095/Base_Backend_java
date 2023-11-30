package learning.app.Backend.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import learning.app.Backend.entites.Commentary;
import learning.app.Backend.enums.TypeCommentary;

public interface CommentaryRepository extends JpaRepository<Commentary, Integer> {

        List<Commentary> findByType(TypeCommentary type);
}
