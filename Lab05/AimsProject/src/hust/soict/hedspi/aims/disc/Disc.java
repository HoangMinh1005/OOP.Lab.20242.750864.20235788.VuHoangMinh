package AimsProject.src.hust.soict.hedspi.aims.disc;

import AimsProject.src.hust.soict.hedspi.aims.media.Media;

public class Disc extends Media{
    private int length;
    private String director;

    public Disc(String title){
        super(title);
    }

    public Disc(int id, String title, String category, float cost, int length,
                String director) {
        super(id, title, category, cost);
        this.length = length;
        this.director = director;
    }

    public Disc(int id, String title, String category, float cost, int length) {
        super(id, title, category, cost);
        this.length = length;
    }

    public Disc(int id, String title, String category, float cost, String director) {
        super(id, title, category, cost);
        this.director = director;
    }

    public Disc(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }
}
