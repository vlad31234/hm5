import java.util.ArrayList;

class MusicLibrary {
    private String name;
    private String owner;
    private ArrayList<String> mainTracks;
    private ArrayList<Playlist> playlists;

    public MusicLibrary(String name, String owner) {
        this.name = name;
        this.owner = owner;
        this.mainTracks = new ArrayList<>();
        this.playlists = new ArrayList<>();
    }

    public void addTrack(String track) {
        if (!mainTracks.contains(track)) {
            mainTracks.add(track);
        }
    }

    public void removeTrack(String track) {
        mainTracks.remove(track);
        for (Playlist playlist : playlists) {
            playlist.removeTrack(track);
        }
    }

    public void displayTracks() {
        System.out.println("All Tracks:");
        for (String track : mainTracks) {
            System.out.println(" - " + track);
        }
    }

    public void searchTracks(String phrase) {
        System.out.println("Search results for: " + phrase);
        for (String track : mainTracks) {
            if (track.contains(phrase)) {
                System.out.println(" - " + track);
            }
        }
    }

    public void createPlaylist(String name) {
        for (Playlist playlist : playlists) {
            if (playlist.name.equals(name)) return;
        }
        playlists.add(new Playlist(name));
    }

    public Playlist findPlaylist(String name) {
        for (Playlist playlist : playlists) {
            if (playlist.name.equals(name)) {
                return playlist;
            }
        }
        return null;
    }

    public void addTrackToPlaylist(String track, String playlistName) {
        Playlist playlist = findPlaylist(playlistName);
        if (playlist != null && mainTracks.contains(track)) {
            playlist.addTrack(track);
        }
    }

    public void displayPlaylist(String name) {
        Playlist playlist = findPlaylist(name);
        if (playlist != null) {
            playlist.displayTracks();
        }
    }

    public void displayAllPlaylists() {
        for (Playlist playlist : playlists) {
            System.out.println("Playlist: " + playlist.name);
        }
    }

    public int getTrackCount() {
        return mainTracks.size();
    }

    public int getPlaylistCount() {
        return playlists.size();
    }
}