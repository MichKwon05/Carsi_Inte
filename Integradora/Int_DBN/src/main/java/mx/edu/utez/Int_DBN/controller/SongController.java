package mx.edu.utez.Int_DBN.controller;

import mx.edu.utez.Int_DBN.dto.SongDto;
import mx.edu.utez.Int_DBN.message.ResourceNotFoundException;
import mx.edu.utez.Int_DBN.model.songs.Song;
import mx.edu.utez.Int_DBN.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/songs")
@CrossOrigin
public class SongController {

    @Autowired
    SongService songService;

    @GetMapping("/")
    public ResponseEntity<List<Song>> getAllSongs(){
        return ResponseEntity.ok(songService.getAllSongs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Song> getSongById(@PathVariable("id") int id) throws ResourceNotFoundException {
        return ResponseEntity.ok(songService.getSongById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<Song> save(@RequestBody SongDto songDto){
        return ResponseEntity.ok(songService.save(songDto));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Song> update(@PathVariable("id") int id, @RequestBody SongDto songDto) throws ResourceNotFoundException {
        return ResponseEntity.ok(songService.update(id, songDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Song> delete(@PathVariable("id") int id) throws ResourceNotFoundException {
        return ResponseEntity.ok(songService.delete(id));}
}
