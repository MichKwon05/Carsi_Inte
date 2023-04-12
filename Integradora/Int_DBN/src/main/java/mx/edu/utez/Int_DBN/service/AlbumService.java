package mx.edu.utez.Int_DBN.service;

import mx.edu.utez.Int_DBN.dto.AlbumDto;
import mx.edu.utez.Int_DBN.message.ResourceNotFoundException;
import mx.edu.utez.Int_DBN.model.album.Album;
import mx.edu.utez.Int_DBN.model.album.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;


@Service
public class AlbumService {

    @Autowired
    AlbumRepository albumRepository;

    public List<Album> getAllAlbum(){
        return albumRepository.findAll();
    }

    public Album getAlbumById(int id) throws ResourceNotFoundException {
        return albumRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Not Found"));
    }

    public Album save(AlbumDto albumDto){
        int id = autoIncrements();
        Album album = new Album(id, albumDto.getNameAlbum(), albumDto.getRelease_date(), albumDto.getNumSongs(), albumDto.getSales());
        return albumRepository.save(album);
    }

    public Album update(int id, AlbumDto albumDto) throws ResourceNotFoundException {
        Album album = albumRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Not Found"));
        album.setNameAlbum(albumDto.getNameAlbum());
        album.setRelease_date(albumDto.getRelease_date());
        album.setNumSongs(albumDto.getNumSongs());
        album.setSales(albumDto.getSales());
        return albumRepository.save(album);
    }

    public Album delete(int id) throws ResourceNotFoundException {
        Album album = albumRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Not Found"));
        albumRepository.delete(album);
        return album;
    }

    //Id autoincrementable
    private int autoIncrements(){
        List<Album> albums = albumRepository.findAll();
        return albumRepository.findAll().isEmpty()? 1 :
                albums.stream().max(Comparator.comparing(Album::getId)).get().getId() + 1;
    }
}

/*
@RestController
@RequestMapping("/api-integradora/album")
public class AlbumService {

    @Autowired
    AlbumRepository albumRepository;

    @GetMapping("/")
    public ResponseEntity<List<Album>> getAllAlbum(){
        return ResponseEntity.ok(albumRepository.findAll());
    }
}*/
