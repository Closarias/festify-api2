package com.wesovilabs.festify.dto.response;

import java.sql.Date;

public record AlbumResponse (Long id, Long artistId, String title, Date releaseDate, Integer tracksCount, Integer durationSeconds) {

}
