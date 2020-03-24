package com.example.bottlemachine;

import java.util.ArrayList;
import java.util.Scanner;

public class BottleDispenser {

    private int bottles;
    private double money;
    public ArrayList<Bottle> pullotList;

    private static BottleDispenser bottleDispenser = new BottleDispenser();

    public static BottleDispenser getInstance(){
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

    public void setPullolista(ArrayList<Bottle> pullolista) {
        pullotList = pullolista;
    }

    public ArrayList<Bottle> getPullolista(){
        return pullotList;
    }

    public double getMoney() {
        return money;
    }

    public int getBottles() {
        return bottles;
    }

    public void addMoney() {
        money += 1;
        System.out.println("Klink! Added more money!");
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

    public void buyBottle(ArrayList<Bottle> pullolista) {
        Scanner scanner = new Scanner(System.in);
        printList(pullotList);
        System.out.print("Your choice: ");
        int valinta = scanner.nextInt();
        Bottle currentBottle;
        ArrayList<Bottle> pullotList = getPullolista();
        currentBottle = pullotList.get(valinta-1);

        if (getMoney() < currentBottle.getCost()) {
            System.out.println("Add money first!");
        }

        else if (getBottles() == 0) {
            System.out.println("Out of bottles!");
        }

        else{
            System.out.println("KACHUNK! " +currentBottle.getName()+" came out of the dispenser!");
            bottles -= 1;
            money = (double) (money - currentBottle.getCost());
            pullotList.remove(valinta - 1);

        }
    }

    public void returnMoney() {
        String palautus = String.format("%.2f", money);
        System.out.println("Klink klink. Money came out! You got "+palautus+"€ back");
    }
}

