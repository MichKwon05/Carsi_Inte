package mx.edu.utez.Int_DBN.dto;

public class AlbumDto {

    private String nameAlbum;
    private String release_date;
    private int numSongs;
    private int sales;

    public AlbumDto() {
    }

    public AlbumDto( String nameAlbum, String release_date, int numSongs, int sales) {
        this.nameAlbum = nameAlbum;
        this.release_date = release_date;
        this.numSongs = numSongs;
        this.sales = sales;
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
