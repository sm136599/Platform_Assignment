package edu.pnu.admin;

import edu.pnu.collection.GenericList;

public class Cafe {
    private String name;
    private GenericList<Beverage> students = new GenericList<Beverage>();

    public Cafe(String name) {
        this.name = name;
    }

    public void addBeverage(Beverage newBeverage) {
        students.add(newBeverage);
    }

    public void removeAllBeverage() {
        students = new GenericList<>();
    }

    public Beverage findBeverage(String name, String type) {
        Beverage beverage = new Beverage(name, type);
        return students.find(beverage);
    }

    @Override
    public String toString() {
        String string = " Cafe Name: " + name + " Beverage Count: " + students.getSize();
        for (int i = 0; i < students.getSize(); i++) {
            string = string + "\n\t" + students.getNext(i);
        }
        return string;
    }
}
