package AimsProject.src.hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.Comparator;

public abstract class Media {
    private int id;
    private String title;
    private String category;
    private float cost;
    private ArrayList<Media> mediaList = new ArrayList<Media>();

    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();

    public Media(String title){
        this.title = title;
    }

    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean equals(Media media){
        return this.title.equals(media.title);
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public float getCost() {
        return cost;
    }

    public boolean isMatch(String title){
        return getTitle().equalsIgnoreCase(title);
    }

    public boolean isMatch(int id){
		if(this.id == id){
			return true;
		}
		return false;
	}

}
