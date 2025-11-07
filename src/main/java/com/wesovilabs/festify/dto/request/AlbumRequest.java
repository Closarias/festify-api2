package com.wesovilabs.festify.dto.request;

import java.sql.Date;

import jakarta.validation.constraints.*;

public record AlbumRequest(

        @NotBlank 
        Long artistId,

        @NotBlank @Size(max = 255, message = "El título no puede superar los 255 caracteres") 
        String title,

        Date releaseDate,

        @PositiveOrZero 
        Integer tracksCount,

        @PositiveOrZero 
        Integer durationSeconds) {

}
