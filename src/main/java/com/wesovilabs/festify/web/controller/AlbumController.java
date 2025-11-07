package com.wesovilabs.festify.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.wesovilabs.festify.dto.response.AlbumResponse;
import com.wesovilabs.festify.service.AlbumService;

@CrossOrigin(origins = "*")
@RestController
public class AlbumController {
    
    final private AlbumService albumService;

    @Autowired
    public AlbumController (AlbumService albumService){
        this.albumService = albumService;
    }

    @GetMapping("/artists/{artistId}/albums")
    public AlbumResponse getAlbum(@PathVariable String artistId) {
        return this.albumService.getAlbumById(artistId);
    }
    
}
