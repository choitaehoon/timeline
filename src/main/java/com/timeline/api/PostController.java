package com.timeline.api;

import com.timeline.dto.request.RequestPost;
import com.timeline.dto.response.ResponsePost;
import com.timeline.dto.token.ExtractAccountFromToken;
import com.timeline.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/api/v1/posts")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<ResponsePost> writePost(@Valid @RequestBody RequestPost requestPost, Authentication authentication) {
        return new ResponseEntity<>(postService.writePost(requestPost, ExtractAccountFromToken.getUsernameFromAuthentication(authentication))
                , HttpStatus.OK);
    }
}
