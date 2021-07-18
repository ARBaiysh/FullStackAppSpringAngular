package kg.baiysh.FullStackAppJavaSpringAndAngular.facade;

import kg.baiysh.FullStackAppJavaSpringAndAngular.dto.PostDTO;
import kg.baiysh.FullStackAppJavaSpringAndAngular.entity.Post;
import org.springframework.stereotype.Component;

@Component
public class PostFacade {

    public PostDTO postToPostDTO(Post post) {
        PostDTO postDTO = new PostDTO();
        postDTO.setUsername(post.getUser().getUsername());
        postDTO.setId(post.getId());
        postDTO.setCaption(post.getCaption());
        postDTO.setLikes(post.getLikes());
        postDTO.setUsersLiked(post.getLikeUsers());
        postDTO.setLocation(post.getLocation());
        postDTO.setTitle(post.getTitle());

        return postDTO;
    }

}
