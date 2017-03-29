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
        /**
         * Displaying the information about the location of the movies
         */
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\t\t\t\tMovie Theater\n");
        stringBuilder.append("------------------------------------------------------------\n");

        position.entrySet().stream()
                .sorted(Map.Entry.<String,Integer>comparingByValue())
                .forEachOrdered(x-> {

                    switch (x.getValue()) {

                        case 1:
                            stringBuilder.append("Queue No 1\n" );
                            break;
                        case 4:
                            stringBuilder.append("Queue No 2\n" );
                            break;
                        case 7:
                            stringBuilder.append("Queue No 3\n" );
                            break;
                        case 10:
                            stringBuilder.append("Queue No 4\n" );
                            break;
                        case 13:
                            stringBuilder.append("Queue No 5\n" );
                            break;

                    }

                    stringBuilder.append("\t" + x.getKey() + " \n");
                    if (x.getValue() % 3 == 0) {
                        stringBuilder.append("\n");
                    }
                });
        return stringBuilder.toString();
    }
}


class Customer {

    public int id;
    public String wichMovie;

    public Customer(int id, String wichMovie) {
        this.id = id;
        this.wichMovie = wichMovie;
    }


    public String toString(){
        return "Customer #" + this.id;
    }
}

final class MovieQueues {
    private static LinkedList<Customer> movieQueue1 = new LinkedList<Customer>();
    private static LinkedList<Customer> movieQueue2 = new LinkedList<Customer>();
    private static LinkedList<Customer> movieQueue3 = new LinkedList<Customer>();
    private static LinkedList<Customer> movieQueue4 = new LinkedList<Customer>();
    private static LinkedList<Customer> movieQueue5 = new LinkedList<Customer>();

    public static void enterCustomer(int queue,Customer customer) {
        switch (queue) {
            case 1:
                movieQueue1.add(customer);
                break;
            case 2:
                movieQueue2.add(customer);
                break;
            case 3:
                movieQueue3.add(customer);
                break;
            case 4:
                movieQueue4.add(customer);
                break;
            case 5:
                movieQueue5.add(customer);
                break;
        }

    }

    public static Customer attendCustomer(int queue) {
        /**
         * removin customer from the queue line
         */
        switch (queue) {
            case 1:
                return movieQueue1.removeFirst();
            case 2:
                return movieQueue2.removeFirst();
            case 3:
                return movieQueue3.removeFirst();
            case 4:
                return movieQueue4.removeFirst();
            case 5:
                return movieQueue5.removeFirst();
                default:
                    return null;
        }
    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\tQueue 1 :" + movieQueue1);
        stringBuilder.append("\n\tQueue 2 :" + movieQueue2);
        stringBuilder.append("\n\tQueue 3 :" + movieQueue3);
        stringBuilder.append("\n\tQueue 4 :" + movieQueue4);
        stringBuilder.append("\n\tQueue 5 :" + movieQueue5);

        return  stringBuilder.toString();
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