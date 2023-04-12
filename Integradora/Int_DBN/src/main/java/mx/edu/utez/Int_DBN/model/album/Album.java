package mx.edu.utez.Int_DBN.model.album;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "album")
public class Album {

    @Id
    private int id;

    /* { '_id': 1, 'nameAlbum': 'Square One',
    'release_date': '2016-08-08',
     'numSongs': 2, 'sales': 50000},*/

    private String nameAlbum;
    private String release_date;
    private int numSongs;
    private int sales;

    public Album() {
    }

    public Album(int id, String nameAlbum, String release_date, int numSongs, int sales) {
        this.id = id;
        this.nameAlbum = nameAlbum;
        this.release_date = release_date;
        this.numSongs = numSongs;
        this.sales = sales;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameAlbum() {
        return nameAlbum;
    }

    public void setNameAlbum(String nameAlbum) {
        this.nameAlbum = nameAlbum;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public int getNumSongs() {
        return numSongs;
    }

    public void setNumSongs(int numSongs) {
        this.numSongs = numSongs;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }
}
