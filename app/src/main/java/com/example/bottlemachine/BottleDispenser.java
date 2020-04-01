package com.example.bottlemachine;

import java.util.ArrayList;

public class BottleDispenser {

    private int bottles;
    private double money;
    public ArrayList<Bottle> pullotList;

    private static BottleDispenser bottleDispenser = new BottleDispenser();

    static BottleDispenser getInstance(){
        return bottleDispenser;
    }

    private BottleDispenser() {
        bottles = 5;
        money = 0;

        ArrayList<Bottle> pullot = new ArrayList<Bottle>();

        Bottle pepemake = new Bottle("Pepsi Max", "Pepsi", 0.3, 1.8, 0.5);
        Bottle pepeMake = new Bottle("Pepsi Max", "Pepsi", 0.5, 2.2, 1.5);
        Bottle colazero = new Bottle("Coca-Cola Zero", "Coca-Cola", 0.3, 2.0, 0.5);
        Bottle colaZero = new Bottle("Coca-Cola Zero", "Coca-Cola", 0.5, 2.5, 1.5);
        Bottle fantazero = new Bottle("Fanta Zero", "Fanta", 0.3, 1.95, 0.5);
        pullot.add(pepemake);
        pullot.add(pepeMake);
        pullot.add(colazero);
        pullot.add(colaZero);
        pullot.add(fantazero);

        setPullolista(pullot);
    }

    private void setPullolista(ArrayList<Bottle> pullolista) {
        pullotList = pullolista;
    }

    public ArrayList<Bottle> getPullolista(){
        return pullotList;
    }

    private double getMoney() {
        return money;
    }

    private int getBottles() {
        return bottles;
    }

    String addMoney(int m) {
        money += m;
        return("Klink! Added more money!");
    }

    public void printList(ArrayList<Bottle> pullolista) {
        Bottle currentBottle;
        ArrayList<Bottle> pullotLista = getPullolista();
        for(int i = 0; i < pullotLista.size(); i++) {
            currentBottle = pullotLista.get(i);
            System.out.println((i+1)+". Name: "+currentBottle.getName());
            System.out.println("	Size: "+currentBottle.getSize()+"	Price: "+currentBottle.getCost());
        }
    }

    public String buyBottle(Bottle pullo) {
        ArrayList<Bottle> pullotList = getPullolista();

        if (getMoney() == 0 ||  getMoney() < pullo.getCost()) {
            return ("Add money first!");
        }
        else if (getBottles() == 0) {
            return ("Out of bottles!");
        }
        else{
            bottles -= 1;
            money = (double) (money - pullo.getCost());
            pullotList.remove(pullo);
            return ("KACHUNK! " +pullo.getName()+" came out of the dispenser!");
        }
    }

    String returnMoney() {
        String palautus = String.format("%.2f", money);
        money = 0;
        return("Klink klink. Money came out! You got "+palautus+"€ back");
    }
}

