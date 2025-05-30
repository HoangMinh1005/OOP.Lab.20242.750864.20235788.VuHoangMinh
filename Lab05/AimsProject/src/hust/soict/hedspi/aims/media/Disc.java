package AimsProject.src.hust.soict.hedspi.aims.media;

public class Disc extends Media {
    private int length;
    private String director;
    
    public Disc(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }
    
    public Disc(int id, String title, String category, float cost, String director, int length) {
        super(id, title, category, cost);
        this.director = director;
        this.length = length;
    }

//    public Disc(String title, String category, float cost, String director, int length) {
//        super();
//        setTitle(title);
//        setCategory(category);
//        setCost(cost);
//        this.director = director;
//        this.length = length;
//    }

    public int getLength() {return length;}
    public String getDirector() {return director;}

	public void setLength(int length) {this.length = length;}
	public void setDirector(String director) {this.director = director;}
}