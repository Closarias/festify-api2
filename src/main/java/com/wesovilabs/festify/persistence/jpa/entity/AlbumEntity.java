package com.wesovilabs.festify.persistence.jpa.entity;

import java.sql.Timestamp;
import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table(name="albums")
public class AlbumEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "artist_id")
    private Long artistId;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(name = "release_date")
    private Date releaseDate;

    @Column(name = "tracks_count")
    private int tracksCount;

    @Column(name = "duration_seconds")
    private int durationSeconds;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    public AlbumEntity(){}

    public AlbumEntity(Long id, Long artistId, String title, Date releaseDate, int tracksCount, int durationSeconds){
        this.id = id;
        this.artistId = artistId;
        this.title = title;
        this.releaseDate = releaseDate;
        this.tracksCount = tracksCount;
        this.durationSeconds = durationSeconds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    } 

    public Long getArtistId() {
        return artistId;
    }

    public void setArtistId(Long artistId) {
        this.artistId = artistId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getTracksCount() {
        return tracksCount;
    } 

    public void setTracksCount(int tracksCount) {
        this.tracksCount = tracksCount;
    }

    public int getDurationSeconds() {
        return durationSeconds;
    }

    public void setDurationSeconds(int durationSeconds) {
        this.durationSeconds = durationSeconds;
    }
}
