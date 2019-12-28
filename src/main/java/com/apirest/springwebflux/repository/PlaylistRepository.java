package com.apirest.springwebflux.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.apirest.springwebflux.document.Playlist;

public interface PlaylistRepository extends ReactiveMongoRepository<Playlist, String>{

}
