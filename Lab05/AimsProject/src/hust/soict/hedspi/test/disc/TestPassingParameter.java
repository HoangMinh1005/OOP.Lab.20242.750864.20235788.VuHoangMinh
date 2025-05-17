package AimsProject.src.hust.soict.hedspi.test.disc;

import AimsProject.src.hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class TestPassingParameter {

    public static void main(String[] args) {

        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        swap(jungleDVD, cinderellaDVD);

        System.out.println("jungleDVD title: " + jungleDVD.getTitle());
        System.out.println("cinderellaDVD title: " + cinderellaDVD.getTitle());
        changeTitle(jungleDVD, cinderellaDVD.getTitle());

        System.out.println("jungleDVD updated title: " + jungleDVD.getTitle());
    }

    public static void swap(Object o1, Object o2) {
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    }

    public static void changeTitle(DigitalVideoDisc disc, String newTitle) {
        String originalTitle = disc.getTitle();
        disc.setTitle(newTitle);
        disc = new DigitalVideoDisc(originalTitle); 
    }
}