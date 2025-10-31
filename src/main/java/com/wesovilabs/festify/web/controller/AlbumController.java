package com.wesovilabs.festify.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.wesovilabs.festify.dto.response.AlbumResponse;
import com.wesovilabs.festify.service.AlbumService;

public class AlbumController {
    
    final private AlbumService albumService;

    @Autowired
    public AlbumController (AlbumService albumService){
        this.albumService = albumService;
    }

    @GetMapping("/artists/{id}/albums")
    public List<AlbumResponse> listAlbum() {
        return this.albumService.listAlbum();
    }
    
}
