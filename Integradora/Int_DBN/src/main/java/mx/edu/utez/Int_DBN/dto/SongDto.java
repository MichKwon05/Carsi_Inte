package mx.edu.utez.Int_DBN.dto;

public class SongDto {
    private String nameSong;
    private String release_date;
    private int awards;
    private String album;

    public SongDto() {
    }

    public SongDto(String nameSong, String release_date, int awards, String album) {
        this.nameSong = nameSong;
        this.release_date = release_date;
        this.awards = awards;
        this.album = album;
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
