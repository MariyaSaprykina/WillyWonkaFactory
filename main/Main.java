package main;

import entities.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import register.*;
import song.OompaLoompaSong;
import ticket.GoldenTicket;
import ticket.RaffleTickets;
import ticket.RandomString;

public class Main {

    public static void main(String[] args) {

        BeingRegister br = new BeingRegister();
        ArrayList<Product> products = new ArrayList<>();
        ArrayList<GoldenTicket> goldenTickets = new ArrayList<>();
        //blablablabla
        Scanner sc = new Scanner(System.in);

        boolean end = false;
        int num;
        do {

            System.out.println("Choose the operation");
            int op = sc.nextInt();
            switch (op) {
                case 1:
                    System.out.println("Register Prize tickets");
                    System.out.print("Number of tickets: ");
                    num = sc.nextInt();
                    for (int i = 0; i < num; i++) {
                        goldenTickets.add(new GoldenTicket(RandomString.generateString(), null));
                    }
                    System.out.println("Prize tickets registered");

                    break;
                case 2:
                    System.out.println("List all prize tickets");
                    for (GoldenTicket ticket : goldenTickets) {
                        System.out.println(ticket);
                    }
                    break;
                case 3:
                    System.out.println("List only raffled tickets");
                    for (GoldenTicket ticket : goldenTickets) {
                        if (ticket.isRaffled()) {
                            System.out.println(ticket);
                        }
                    }
                    break;
                case 4:
                    System.out.println("Let's sing!");
                    System.out.println("Type the number of lines");
                    int lines = sc.nextInt();
                    OompaLoompaSong song = new OompaLoompaSong(lines);
                    System.out.println(song.sing());
                    break;
                case 5:
                    System.out.println("Register beings");
                    System.out.println("Choose: k - Kid; o - Oompaloompa");
                    String being = sc.next();

                    if (being.equals("k")) {
                        System.out.print("Code: ");
                        int code = sc.nextInt();
                        System.out.print("Name: ");
                        String name = sc.next();
                        System.out.print("Year of birth: ");
                        int yearOfBirth = sc.nextInt();
                        System.out.print("Country: ");
                        String country = sc.next();
                        ArrayList<Product> kidsProducts = new ArrayList<>();
                        Kid kid = new Kid(code, name, yearOfBirth, kidsProducts, country);
                        br.addKid(kid);
                        System.out.println("Kid " + kid.getName() + " registered");

                    } else if (being.equals("o")) {
                        System.out.print("Code: ");
                        int code = sc.nextInt();
                        System.out.print("Name: ");
                        String name = sc.next();
                        System.out.print("Height: ");
                        int height = sc.nextInt();
                        System.out.print("Favorite food: ");
                        String favoriteFood = sc.next();
                        ArrayList<Product> kidsProducts = new ArrayList<>();
                        OompaLoompa ol = new OompaLoompa(code, name, height, favoriteFood);
                        br.addOompaLoompa(ol);
                        System.out.println("OompaLoompa " + ol.getName() + " registered");
                    }
                    break;

                case 6:
                    System.out.println("Register Products");

                    System.out.print("Description: ");
                    String desc = sc.next();
                    System.out.print("Barcode: ");
                    int barcode = sc.nextInt();
                    System.out.print("Serial number: ");
                    String sn = sc.next();
                    products.add(new Product(desc, barcode, sn, null));

                    System.out.println("The product registered");

                    break;

                case 7:
                    System.out.println("Raffle tickets");
                    System.out.print("Number of tickets to be raffled: ");
                    num = sc.nextInt();
                    ArrayList<GoldenTicket> ticketsToRaffle = new ArrayList<>();
                    int count = 0;
                    if (products.size()>num) {
                        for (GoldenTicket ticket : goldenTickets) {
                            if (!ticket.isRaffled()) {
                                ticket.setRaffled(new Date());
                                ticketsToRaffle.add(ticket);
                                count++;

                            }
                            if (count == num) {
                                break;
                            }
                        }
                        if (ticketsToRaffle.size() != num) {
                            num -= ticketsToRaffle.size();
                            for (int i = 0; i < num; i++) {
                                GoldenTicket ticket = new GoldenTicket(RandomString.generateString(), new Date());
                                goldenTickets.add(ticket);
                                ticketsToRaffle.add(ticket);
                            }
                        }

                        RaffleTickets.raffleTickets(ticketsToRaffle, products);

                    } else {
                        System.out.println("Not enough products");
                    }

                    break;
                case 8:
                    System.out.println("Register Sale");
                    System.out.print("Usercode: ");
                    int userCode = sc.nextInt();
                    System.out.print("Product barcode: ");
                    int productBarcode = sc.nextInt();
                    RegisterSale rs = new RegisterSale(br.getKids(), products);
                    rs.buyProduct(userCode, productBarcode);
                    for (Product pr : products) {
                        System.out.println(pr);
                    }
                    break;

                case 9:
                    System.out.println("List Winners");
                    for (Kid kid : br.getKids()) {
                        for (Product product : kid.getProducts()) {
                            if (product.getPrizeTicket() != null) {
                                System.out.println(kid);
                                break;
                            }
                        }
                    }
		    break;
                case 10:
                    end = true;
                    System.out.println("Exit");
                    break;

            }

        } while (!end);

    }

}

