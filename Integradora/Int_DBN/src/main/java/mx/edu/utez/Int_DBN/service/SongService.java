package mx.edu.utez.Int_DBN.service;

import mx.edu.utez.Int_DBN.dto.SongDto;
import mx.edu.utez.Int_DBN.message.ResourceNotFoundException;
import mx.edu.utez.Int_DBN.model.songs.Song;
import mx.edu.utez.Int_DBN.model.songs.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class SongService {

    @Autowired
    SongRepository songRepository;

    public List<Song> getAllSongs(){
        return songRepository.findAll();
    }

    public Song getSongById(int id) throws ResourceNotFoundException {
        return songRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Not Found"));
    }

    public Song save(SongDto songDto){
        int id = autoIncrements();
        Song song = new Song(id, songDto.getNameSong(), songDto.getRelease_date(), songDto.getAwards(), songDto.getAlbum());
        return songRepository.save(song);
    }

    public Song update(int id, SongDto songDto) throws ResourceNotFoundException {
        Song song = songRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Not Found"));
        song.setNameSong(songDto.getNameSong());
        song.setRelease_date(songDto.getRelease_date());
        song.setAwards(songDto.getAwards());
        song.setAlbum(songDto.getAlbum());
        return songRepository.save(song);
    }

    public Song delete(int id) throws ResourceNotFoundException {
        Song song = songRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Not Found"));
        songRepository.delete(song);
        return song;
    }

    //Id autoincrement
    private int autoIncrements(){
        List<Song> songs = songRepository.findAll();
        return songRepository.findAll().isEmpty()? 1 :
                songs.stream().max(Comparator.comparing(Song::getId)).get().getId() + 1;
    }
}
