package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import hust.soict.hedspi.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable {
	private String artist;
    private List<Track> tracks = new ArrayList<>();
    
    public String getArtist() {return artist;}

//    public CompactDisc(String title, String category, float cost, String director, String artist) {
//        super(title, category, cost, director, 0); // Length set later
//        this.artist = artist;
//    }

    public CompactDisc(int id, String title, String category, float cost, String artist) {
        super(id, title, category, cost);
        this.artist = artist;
    }

	public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
            System.out.println("Track " + track.getTitle() + " added");
        } else {
            System.out.println("Track " + track.getTitle() + " already exists");
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track " + track.getTitle() + " removed");
        } else {
            System.out.println("Track " + track.getTitle() + " not found");
        }
    }

    @Override
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }
    
    @Override
    public void play() throws PlayerException {
    	if (this.getLength() > 0) {
            Iterator<Track> iter = tracks.iterator();
            Track nextTrack;
            while (iter.hasNext()) {
                nextTrack = iter.next();
                try {
                    nextTrack.play();
                } catch (PlayerException e) {
                    throw e;
                }
            }
        } else {
            System.err.println("ERROR: CD length is non-positive!");
            throw new PlayerException("ERROR: CD length is non-positive!");
        }
    }
    
    @Override
    public String toString() {
        return "CD - " + getTitle() + " - " + (getCategory() != null ? getCategory() : "Unknown") +
               " - " + (artist != null ? artist : "Unknown") + ": " + getCost() + " $";
    }
}
