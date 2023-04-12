package mx.edu.utez.Int_DBN.controller;

import mx.edu.utez.Int_DBN.dto.AlbumDto;
import mx.edu.utez.Int_DBN.message.ResourceNotFoundException;
import mx.edu.utez.Int_DBN.model.album.Album;
import mx.edu.utez.Int_DBN.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/album")
@CrossOrigin
public class AlbumController {
    @Autowired
    AlbumService albumService;

    @GetMapping("/")
    public ResponseEntity<List<Album>> getAllAlbum(){
        return ResponseEntity.ok(albumService.getAllAlbum());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Album> getAlbumById(@PathVariable("id") int id) throws ResourceNotFoundException {
        return ResponseEntity.ok(albumService.getAlbumById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<Album> save(@RequestBody AlbumDto albumDto){
        return ResponseEntity.ok(albumService.save(albumDto));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Album> update(@PathVariable("id") int id, @RequestBody AlbumDto albumDto) throws ResourceNotFoundException {
        return ResponseEntity.ok(albumService.update(id, albumDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Album> delete(@PathVariable("id") int id) throws ResourceNotFoundException {
        return ResponseEntity.ok(albumService.delete(id));
    }
}