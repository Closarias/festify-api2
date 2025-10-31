package com.wesovilabs.festify.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wesovilabs.festify.dto.request.AlbumRequest;
import com.wesovilabs.festify.dto.response.AlbumResponse;
import com.wesovilabs.festify.mapper.AlbumMapper;
import com.wesovilabs.festify.persistence.jpa.entity.AlbumEntity;
import com.wesovilabs.festify.persistence.jpa.repository.AlbumJpaRepository;
import com.wesovilabs.festify.service.AlbumService;
import com.wesovilabs.festify.util.exception.AlbumNotFoundException;
import com.wesovilabs.festify.util.exception.ArtistNotFoundException;
import com.wesovilabs.festify.util.exception.InvalidIdException;

@Service
public class AlbumServiceImpl implements AlbumService{

    final private AlbumJpaRepository albumJpaRepository;

    @Autowired
    public AlbumServiceImpl(AlbumJpaRepository albumJpaRepository){
        this.albumJpaRepository = albumJpaRepository;
    }

    @Override
    public List<AlbumResponse> listAlbum() {
        List<AlbumEntity> albums = this.albumJpaRepository.findAll();
        return albums.stream().map(AlbumMapper::mapAlbumToAlbumResponse).toList();
    }

    @Override
    public AlbumResponse createAlbum(AlbumRequest albumRequest){
        AlbumEntity albums = AlbumMapper.mapAlbumRequestToAlbumEntity(albumRequest);
        AlbumEntity result = this.albumJpaRepository.save(albums);
        return AlbumMapper.mapAlbumToAlbumResponse(result);
    }

    @Override
    public AlbumResponse updateAlbum(String strId, AlbumRequest albumRequest){
        Long id = parseAlbumId(strId);
        AlbumEntity albums = AlbumMapper.mapAlbumRequestToAlbumEntity(albumRequest);
        albums.setId(id);
        if (!this.albumJpaRepository.existsById(id)) {
            throw new AlbumNotFoundException("Album no encontrado con id " + strId);
        }
        AlbumEntity result = this.albumJpaRepository.save(albums);
        return AlbumMapper.mapAlbumToAlbumResponse(result);
    }

    private Long parseAlbumId(String strId) {
        try {
            strId = strId.trim().replace("ART-","");
            Long id = Integer.valueOf(strId).longValue();
            return id;
        }catch (NumberFormatException e) {
            throw new InvalidIdException("Invalid album id " + strId);
        }
    }
}
