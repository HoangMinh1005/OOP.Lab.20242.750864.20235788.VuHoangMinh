package hust.soict.hedpi.aims.media;

import hust.soict.hedpi.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {
	private static int nbDigitalVideoDiscs = 0;    // static member

	public static int getNbDigitalVideoDiscs() {
		return nbDigitalVideoDiscs;
	}
	
//	public DigitalVideoDisc(String title) {     // constructor 1
//		super();
//		setTitle(title);
//		nbDigitalVideoDiscs++;
//		setId(nbDigitalVideoDiscs);		//assign unique id
//	}
//	
//	public DigitalVideoDisc(String category, String title, float cost) {	//constructor 2
//		super();
//		setCategory(category);
//		setTitle(title);
//		setCost(cost);
//		nbDigitalVideoDiscs++;         
//        setId(nbDigitalVideoDiscs); 
//	}
//	
//	public DigitalVideoDisc(String director, String category, String title, float cost) {	   // constructor 3
//		super();
//		setDirector(director);
//		setCategory(category);
//		setTitle(title);
//		setCost(cost);
//		nbDigitalVideoDiscs++;        
//        setId(nbDigitalVideoDiscs);
//	}
//	
//	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {	   //constructor 4
//		super();
//		setTitle(title);
//		setCategory(category);
//		setDirector(director);
//		setLength(length);
//		setCost(cost);
//        nbDigitalVideoDiscs++;
//        setId(nbDigitalVideoDiscs);
//	}
	
	public DigitalVideoDisc(int id, String title, String category, float cost, String director, int length) {
        super(id, title, category, cost, director, length);
        nbDigitalVideoDiscs++;
    }
	
	@Override
    public String toString() {
        return "DVD - " + getTitle() + " - " + (getCategory() != null ? getCategory() : "Unknown") + " - " +
               (getDirector() != null ? getDirector() : "Unknown") + " - " + getLength() + ": " + getCost() + " $";
    }

    public boolean isMatch(String title) {		// for title search
        return (getTitle() != null) && getTitle().toLowerCase().contains(title.toLowerCase());
    }
    
    @Override
    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());
        } else {
            System.err.println("ERROR: DVD length is non-positive!");
            throw new PlayerException("ERROR: DVD length is non-positive!");
        }
    }
}
