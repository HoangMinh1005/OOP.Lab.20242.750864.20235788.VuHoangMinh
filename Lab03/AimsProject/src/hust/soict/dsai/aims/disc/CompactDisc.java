package AimsProject.src.hust.soict.dsai.aims.disc;

import java.util.ArrayList;
import java.util.List;
public class CompactDisc extends Disc implements Playable {
    private String artist;
    private List<Track> tracks = new ArrayList<>();

    public CompactDisc(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    public CompactDisc(int id, String title, String category, float cost, int length, String director, String artist, List<Track> tracks) {
        super(id, title, category, cost, length, director);
        this.artist = artist;
        this.tracks = tracks;
    }

    public CompactDisc(int id, String title, String category, float cost, int length, String director, String artist) {
        super(id, title, category, cost, length, director);
        this.artist = artist;
    }

    public CompactDisc(int id, String title, String category, float cost, String artist) {
        super(id, title, category, cost);
        this.artist = artist;
    }

    public CompactDisc(int id, String title, String category, float cost, String artist, List<Track> tracks) {
        super(id, title, category, cost);
        this.artist = artist;
        this.tracks = tracks;
    }

    public CompactDisc(int id, String title, String category, float cost, int length, String director) {
        super(id, title, category, cost, length, director);
    }

    public CompactDisc(int id, String title, String category, float cost, int length) {
        super(id, title, category, cost, length);
    }


    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
            System.out.println("A track has been added!");
        } else {
            System.out.println("Track existed!");
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("A track has been removed!");
        } else {
            System.out.println("Not exist track!");
        }
    }

    public int getLength() {
        int length = 0;
        for (Track track : tracks) {
            length += track.getLength();
        }
        return length;
    }

    public String getArtist() {
        return artist;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("CD: ").append(getId()).append(" - Title: ").append(getTitle()).append(" - Category: ").append(getCategory()).append(" - Director: ")
                .append(getDirector()).append(" - Artist: ").append(artist).append(" - Length: ").append(getLength())
                .append(" mins").append(" - Cost: $").append(getCost());

        if (!tracks.isEmpty()) {
            result.append("\nTracks:");
            for (Track track : tracks) {
                result.append("\n  - ").append(track.getTitle()).append(" (").append(track.getLength()).append(" mins)");
            }
        }

        return result.toString();
    }


    @Override
    public void play() {

    }
}
