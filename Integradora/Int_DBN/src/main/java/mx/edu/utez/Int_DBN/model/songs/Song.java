package mx.edu.utez.Int_DBN.model.songs;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "songs")
public class Song {

    @Id
    private int id;

    //{ '_id': 1, 'nameSong': 'DDU-DU DDU-DU',
    // 'release_date': '2018-06-15',
    // 'awards': 6, 'album': 'Blackpink in your area'},
    private String nameSong;
    private String release_date;
    private int awards;
    private String album;

    public Song() {
    }

    public Song(int id, String nameSong, String release_date, int awards, String album) {
        this.id = id;
        this.nameSong = nameSong;
        this.release_date = release_date;
        this.awards = awards;
        this.album = album;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public int getAwards() {
        return awards;
    }

    public void setAwards(int awards) {
        this.awards = awards;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }
}
