package com.wesovilabs.festify.mapper;

import com.wesovilabs.festify.dto.request.AlbumRequest;
import com.wesovilabs.festify.dto.response.AlbumResponse;
import com.wesovilabs.festify.persistence.jpa.entity.AlbumEntity;

public class AlbumMapper {
    
    public static AlbumResponse mapAlbumToAlbumResponse(AlbumEntity a) {
        return new AlbumResponse(
            a.getId(), 
            a.getArtistId(), 
            a.getTitle(), 
            a.getReleaseDate(), 
            a.getTracksCount(), 
            a.getDurationSeconds()
        );
    }

    public static AlbumEntity mapAlbumRequestToAlbumEntity (AlbumRequest r) {
        return new AlbumEntity(null, r.artistId(), r.title(), r.releaseDate(), r.tracksCount(), r.durationSeconds());
    }

}
