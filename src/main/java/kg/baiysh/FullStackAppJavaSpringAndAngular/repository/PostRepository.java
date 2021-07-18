package kg.baiysh.FullStackAppJavaSpringAndAngular.repository;


import kg.baiysh.FullStackAppJavaSpringAndAngular.entity.Post;
import kg.baiysh.FullStackAppJavaSpringAndAngular.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findAllByUserOrderByCreatedDateDesc(User user);

    List<Post> findAllByOrderByCreatedDateDesc();

    Optional<Post> findPostByIdAndUser(Long id, User user);
}
