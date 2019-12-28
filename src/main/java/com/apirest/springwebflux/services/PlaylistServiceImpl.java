package com.apirest.springwebflux.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.springwebflux.document.Playlist;
import com.apirest.springwebflux.repository.PlaylistRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PlaylistServiceImpl implements PlaylistService{
	
	@Autowired
	PlaylistRepository playListRepository;

	@Override
	public Flux<Playlist> findAll() {
		return playListRepository.findAll();
		
	}

	@Override
	public Mono<Playlist> findById(String id) {
		return playListRepository.findById(id);
	}

	@Override
	public Mono<Playlist> save(Playlist playlist) {
		return playListRepository.save(playlist);
	}
	
	

}
