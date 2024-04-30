import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Theatre[] theatres = new Theatre[4];
        for(int i = 0; i < 4; i ++) {
            int theatreid = Integer.parseInt(bf.readLine());
            String theatreName = bf.readLine().toString();
            int seatCapacity = Integer.parseInt(bf.readLine());
            Double ticketRate = Double.parseDouble(bf.readLine());
            int theatreRating = Integer.parseInt(bf.readLine());

            theatres[i] = new Theatre(theatreid,theatreName, seatCapacity, ticketRate, theatreRating);
        }
        int id = sc.nextInt();

        Map<String, String> mp = new HashMap<>();
        mp.putAll(new HashMap<>());

        String theatreFound = findTheatreCategory(theatres, id);
        if(theatreFound == null) {
            System.out.println("There is no Theatre with given theatreId");
        } else {
            System.out.println(theatreFound);
        }
        Theatre secondTheatre = findSecondHighestTicket(theatres);
        if(secondTheatre == null) {
            System.out.println("Only low rating theatres are available");
        } else {
            System.out.println(secondTheatre.getTheatreName());
        }

    }

    static public String findTheatreCategory(Theatre[] theatres, int theatreid) {
        Theatre searchedTheatre = null;
        for(Theatre theatre : theatres) {
            if(theatre.getTheatreid() == theatreid) {
                searchedTheatre = theatre;
                break;
            }
        }
        if(searchedTheatre == null) return null;
        if(searchedTheatre.getSeatCapacity() > 1000 && searchedTheatre.getTheatreRating() >= 4)
            return "Premium";
        return "Non Premium";
    }

    static public Theatre findSecondHighestTicket(Theatre[] theatres) {
        Theatre first = theatres[0], second = null;
        for(Theatre theatre : theatres) {
            if(theatre.getTicketRate() > first.getTicketRate()) {
                second = first;
                first = theatre;
            } else if (second == null) {
                second = theatre;
            } else if (theatre.getTicketRate() > second.getTicketRate() && theatre.getTicketRate() < first.getTicketRate())
                second = theatre;
        }
        if(second.getTheatreRating() < 2) return null;
        return second;
    }
}
class Theatre {
    private int theatreid;
    private String theatreName;
    private int seatCapacity;
    private Double ticketRate;
    private int theatreRating;
    Theatre(int theatreid, String theatreName, int seatCapacity, Double ticketRate, int theatreRating) {
        this.theatreid = theatreid;
        this.theatreName = theatreName;
        this.seatCapacity = seatCapacity;
        this.ticketRate = ticketRate;
        this.theatreRating = theatreRating;
    }

    public int getTheatreid() {
        return theatreid;
    }

    public Double getTicketRate() {
        return ticketRate;
    }

    public int getSeatCapacity() {
        return seatCapacity;
    }

    public int getTheatreRating() {
        return theatreRating;
    }

    public String getTheatreName() {
        return theatreName;
    }
}
