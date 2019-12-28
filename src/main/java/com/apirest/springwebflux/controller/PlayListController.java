package com.apirest.springwebflux.controller;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.springwebflux.document.Playlist;
import com.apirest.springwebflux.services.PlaylistService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@RestController
public class PlayListController {
	
	@Autowired
	PlaylistService playListService;
	
	@GetMapping(value="/")
	public Flux<Playlist> getPlaylist(){
		return playListService.findAll();
	}
	
	@GetMapping(value="/playlist/{id}")
	public Mono<Playlist> getPlaylistId(@PathVariable String id){
		return playListService.findById(id);
	}
	
	@PostMapping(value="/playlist")
	public Mono<Playlist> save(@RequestBody Playlist playlist){
		return playListService.save(playlist);
	}
	
	@GetMapping(value="/playlist/webflux", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Tuple2<Long, Playlist>> getPlaylistByWebflux(){

		System.out.println("---Start get Playlists by WEBFLUX--- " + LocalDateTime.now());
		Flux<Long> interval = Flux.interval(Duration.ofSeconds(10));
        Flux<Playlist> playlistFlux = playListService.findAll();

        return Flux.zip(interval, playlistFlux);
        
	}


}
