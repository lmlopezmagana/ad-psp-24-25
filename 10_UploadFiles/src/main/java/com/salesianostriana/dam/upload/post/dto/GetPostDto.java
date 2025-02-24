package com.salesianostriana.dam.upload.post.dto;

import com.salesianostriana.dam.upload.post.model.Post;

public record GetPostDto(
        Long id,
        String title,
        String imageUrl
) {

    public static GetPostDto of(Post post, String url) {
        return new GetPostDto(post.getId(), post.getTitle(), url);
    }

}
