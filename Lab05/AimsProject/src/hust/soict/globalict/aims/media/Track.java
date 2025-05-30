package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

public class Track implements Playable {
	private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }
    
    @Override
    public void play() throws PlayerException {
        if (length <= 0) {
            System.out.println("Cannot play track: " + title);
        } else {
            System.out.println("Playing track: " + title);
            System.out.println("Track length: " + length);
        }
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Track)) return false;
        Track other = (Track) obj;
        return title != null && title.equals(other.title) && length == other.length;
    }
} 

