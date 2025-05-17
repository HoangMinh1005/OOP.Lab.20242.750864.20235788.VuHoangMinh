package AimsProject.src.hust.soict.hedspi.aims.book;

import java.util.ArrayList;
import java.util.List;

import AimsProject.src.hust.soict.hedspi.aims.media.Media;

public class Book extends Media {
    private ArrayList<String> authors = new ArrayList<String>();

    public Book(int id, String title, String category, float cost, ArrayList<String> authors) {
        super(id, title, category, cost);
        this.authors = authors;
    }

    public void addAuthor(String name){
        if(!authors.contains(name)) {
            authors.add(name);
        }
        else {
            System.out.println("Author existed!");
        }
    }
    public void removeAuthor(String name){
        if(authors.contains(name)) {
            authors.remove(name);
        }
        else {
            System.out.println("Not exist author!");
        }
    }

    @Override
    public String toString() {
        return "Book: " + getId() + " - " + getTitle() + " - " + getCategory() + " - " + String.join(", ", authors)
                + " - " + getCost() + "$";
    }

}
