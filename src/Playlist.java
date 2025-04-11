import java.util.ArrayList;

class Playlist {
    String name;
    ArrayList<String> tracks;

    public Playlist(String name) {
        this.name = name;
        this.tracks = new ArrayList<>();
    }

    public void addTrack(String track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
        }
    }

    public void removeTrack(String track) {
        tracks.remove(track);
    }

    public void displayTracks() {
        System.out.println("Playlist: " + name);
        for (String track : tracks) {
            System.out.println(" - " + track);
        }
    }
}