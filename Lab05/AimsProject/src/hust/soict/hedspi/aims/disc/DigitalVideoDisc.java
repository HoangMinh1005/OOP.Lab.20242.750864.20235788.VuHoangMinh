package AimsProject.src.hust.soict.hedspi.aims.disc;

public class DigitalVideoDisc extends Disc implements Playable {
	public static int nbDigitalVideoDisc=0;

    public DigitalVideoDisc(int id, String title, String category, float cost, int length, String director) {
        super(id, title, category, cost, length, director);
		nbDigitalVideoDisc++;
    }

    public DigitalVideoDisc(int id, String title, String category, float cost, int length) {
        super(id, title, category, cost, length);
		nbDigitalVideoDisc++;
    }

    public DigitalVideoDisc(int id, String title, String category, float cost, String director) {
        super(id, title, category, cost, director);
		nbDigitalVideoDisc++;
    }

    public DigitalVideoDisc(int id, String title, String category, float cost) {
        super(id, title, category, cost);
		nbDigitalVideoDisc++;
    }

	public DigitalVideoDisc(String title) {
        super(title);
		nbDigitalVideoDisc++;
    }

	public static int getNbDigitalVideoDisc(){
		return nbDigitalVideoDisc;
	}

    public String toString(){
			String inforString;
            inforString = "DVD - " + getTitle() +" - " + getCategory()+ " - " + getDirector()+" - " + getLength() + ": " + getCost() + "$" ;
			return inforString;
        }

	@Override
	public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}
