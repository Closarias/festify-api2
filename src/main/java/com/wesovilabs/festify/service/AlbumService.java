package com.wesovilabs.festify.service;

import java.util.List;

import com.wesovilabs.festify.dto.request.AlbumRequest;
import com.wesovilabs.festify.dto.response.AlbumResponse;
import com.wesovilabs.festify.dto.response.ArtistDetailResponse;

public interface AlbumService {

    AlbumResponse getAlbumById(String artistId);
}
