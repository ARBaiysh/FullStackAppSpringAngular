package kg.baiysh.FullStackAppJavaSpringAndAngular.services;

import kg.baiysh.FullStackAppJavaSpringAndAngular.dto.CommentDTO;
import kg.baiysh.FullStackAppJavaSpringAndAngular.entity.Comment;
import kg.baiysh.FullStackAppJavaSpringAndAngular.entity.Post;
import kg.baiysh.FullStackAppJavaSpringAndAngular.entity.User;
import kg.baiysh.FullStackAppJavaSpringAndAngular.exceptions.PostNotFoundException;
import kg.baiysh.FullStackAppJavaSpringAndAngular.repository.CommentRepository;
import kg.baiysh.FullStackAppJavaSpringAndAngular.repository.PostRepository;
import kg.baiysh.FullStackAppJavaSpringAndAngular.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public CommentService(CommentRepository commentRepository, PostRepository postRepository, UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public Comment saveComment(Long postId, CommentDTO commentDTO, Principal principal) {
        User user = getUserByPrincipal(principal);
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new PostNotFoundException("Post cannot be found for username: " + user.getEmail()));

        Comment comment = new Comment();
        comment.setPost(post);
        comment.setUserId(user.getId());
        comment.setUsername(user.getUsername());
        comment.setMessage(commentDTO.getMessage());

        log.info("Saving comment for Post: {}", post.getId());
        return commentRepository.save(comment);
    }

    public List<Comment> getAllCommentsForPost(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new PostNotFoundException("Post cannot be found"));
        return commentRepository.findAllByPost(post);
    }

    public void deleteComment(Long commentId) {
        Optional<Comment> comment = commentRepository.findById(commentId);
        comment.ifPresent(commentRepository::delete);
    }


    private User getUserByPrincipal(Principal principal) {
        String username = principal.getName();
        return userRepository.findUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found with username " + username));
    }
}
