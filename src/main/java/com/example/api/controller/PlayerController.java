package com.example.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.model.Player;
import com.example.api.repository.PlayerRepository;

@RestController
@RequestMapping("/players")
public class PlayerController {
    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping
    public List<Player> index() {
        return playerRepository.findAll();
    }

    @GetMapping("{id}")
    public Player show(@PathVariable Long id) {
     return playerRepository.findOne(id);
    }

    @PostMapping
    public Player create(@RequestBody Player player) {
        return playerRepository.save(player);
    }

    @PutMapping("{id}")
    public Player update(@PathVariable Long id, @RequestBody Player player) {
        player.setId(id);
        return playerRepository.save(player);
    }

    @DeleteMapping("{id}")
    public void destroy(@PathVariable Long id) {
        playerRepository.delete(id);
    }
}
