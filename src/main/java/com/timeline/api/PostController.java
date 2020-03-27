package com.timeline.api;

import com.timeline.dto.request.RequestPost;
import com.timeline.dto.response.ResponsePost;
import com.timeline.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    public ResponseEntity<ResponsePost> writePost(@Valid @RequestBody RequestPost requestPost) {
        return new ResponseEntity<>(postService.writePost(requestPost), HttpStatus.OK);
    }
}
