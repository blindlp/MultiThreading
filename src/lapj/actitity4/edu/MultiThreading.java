package lapj.actitity4.edu;

import sun.security.krb5.internal.Ticket;

import java.util.*;
import java.lang.InterruptedException;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MultiThreading {

    public static void main(String[] args) throws Exception {
        Scanner inputReader = new Scanner(System.in);
        String userinput;

        String filePath = "/Users/luispo/IdeaProjects/MultiThreading/src/lapj/actitity4/edu/movies.txt";
        /*Read Movies from movies.txt*/




        BufferedReader input = null;
        String line;
        try {
            input =  new BufferedReader(new FileReader(filePath));
            while ((line = input.readLine()) !=null) {
                MovieTicketsStock.addMovie(line);
            }

        } catch (IOException ex) {
            System.out.println(ex.toString());
        } finally {
            if (input != null) {
                input.close();

            }
        }


        MovieTicketsStock movieTicketsStock = new MovieTicketsStock();
        System.out.println(movieTicketsStock.toString());
        /*Create classes*/

        /*Start Threads*/

        //Stop with any key, except just Enter
        while(true){
            userinput = inputReader.next();
            /*End Threads*/
            System.exit(0);
        }
    }
}

final class MovieTicketsStock {
    //Hint: Use a two-dimensional array or a hasmap to store the available tickets and the name of each available movie.
    //public static ? movies = new ?;
    public static HashMap<String,Integer> movies = new HashMap<String,Integer>();
    public static HashMap<String,Integer> position = new HashMap<String,Integer>();

    public static int index = 1;

    public static void addMovie(String movie) {
        movies.put(movie, 50);
        position.put(movie,index);
        index++;
    }

    public static boolean sellTicket(String movie) {
        return false;
    }

    public String toString() {




        StringBuilder stringBuilder = new StringBuilder();
        movies.forEach((k,v) -> {

                Map<String, Integer> collect =  position.entrySet()
                        .parallelStream()
                        .filter(e -> e.getKey() == k)
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

                collect.forEach((x,y) -> {
                    stringBuilder.append("No " + y + "\t" );
                });


                stringBuilder.append( k + " Tickets Avaible : " + v + "\n");
        });
        return stringBuilder.toString();
    }
}


class Customer {

    public Customer(){

    }

    public String toString(){
        return "";
    }
}

final class MovieQueues {
    private static LinkedList<Customer> movieQueue1 = new LinkedList<Customer>();
    private static LinkedList<Customer> movieQueue2 = new LinkedList<Customer>();
    private static LinkedList<Customer> movieQueue3 = new LinkedList<Customer>();
    private static LinkedList<Customer> movieQueue4 = new LinkedList<Customer>();
    private static LinkedList<Customer> movieQueue5 = new LinkedList<Customer>();

    public static void enterCustomer() {

    }

    public static Customer attendCustomer() {
        return null;
    }

    public String toString(){
        return  "";
    }
}

class Entry extends Thread {
    Random randomgenerator = new Random();
    private static int IDs;
    private boolean threadalive = true;

    public Entry() {

    }

    public void run() {

        while(this.threadalive){

        }
    }

    public void entry(int timecustomerenter){

    }

    public void end(){
        this.threadalive = false;
    }
}

class Attender extends Thread {
    private boolean threadalive = true;

    public Attender() {

    }

    public void run() {

        while(this.threadalive){

        }
    }
    public void attend(Customer customer){

    }

    public void end(){
        this.threadalive = false;
    }
}