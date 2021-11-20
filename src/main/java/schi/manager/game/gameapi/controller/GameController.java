package schi.manager.game.gameapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import schi.manager.game.gameapi.dto.request.GamesDTO;
import schi.manager.game.gameapi.dto.response.MessageResponseDTO;
import schi.manager.game.gameapi.service.GameService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/games")
public class GameController {

    private GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createGame(@Valid @RequestBody GamesDTO gamesDTO ){
        return gameService.createGame(gamesDTO);
    }

    @GetMapping
    public List<GamesDTO> listAll(){
        return gameService.listAll();
    }
}
