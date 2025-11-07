package com.wesovilabs.festify.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wesovilabs.festify.dto.response.AlbumResponse;
import com.wesovilabs.festify.mapper.AlbumMapper;
import com.wesovilabs.festify.persistence.jpa.entity.AlbumEntity;
import com.wesovilabs.festify.persistence.jpa.repository.AlbumJpaRepository;
import com.wesovilabs.festify.service.AlbumService;
import com.wesovilabs.festify.util.exception.AlbumNotFoundException;
import com.wesovilabs.festify.util.exception.InvalidIdException;

@Service
public class AlbumServiceImpl implements AlbumService{

    final private AlbumJpaRepository albumJpaRepository;

    @Autowired
    public AlbumServiceImpl(AlbumJpaRepository albumJpaRepository){
        this.albumJpaRepository = albumJpaRepository;
    }

    @Override
    public AlbumResponse getAlbumById(String strId) {
        Long artistId = parseAlbumId(strId);
        Optional<AlbumEntity> albums = this.albumJpaRepository.findById(artistId);
        if (albums.isEmpty()){
            throw new AlbumNotFoundException("Album no encontrado con id " + strId);
        }
        return AlbumMapper.mapAlbumToAlbumResponse(albums.get());
    }

    private Long parseAlbumId(String strId) {
        try {
            strId = strId.trim();
            Long artistId = Integer.valueOf(strId).longValue();
            return artistId;
        }catch (NumberFormatException e) {
            throw new InvalidIdException("Invalid album id " + strId);
        }
    }
}
