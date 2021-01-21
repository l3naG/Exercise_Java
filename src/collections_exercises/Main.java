package collections_exercises;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Cinema olympian = new Cinema("Olympian", 8, 12);

        if (olympian.reserveSeat("D12")) {
            System.out.println("Please pay for seat D12");
        } else {
            System.out.println("Seat already reserved");
        }

        if (olympian.reserveSeat("D12")) {
            System.out.println("Please pay for seat D12");
        } else {
            System.out.println("Seat already reserved");
        }

        if (olympian.reserveSeat("B13")) {
            System.out.println("Please pay for B13");
        } else {
            System.out.println("There is no seat B13");
        }


//        List<Cinema.Seat> olympian_seat_plan = olympian.getSeats();
//        printList(olympian_seat_plan);

        List<Cinema.Seat> reversedSeats = new ArrayList<>(olympian.getSeats());
        Collections.reverse(reversedSeats);
        printList(reversedSeats);


        List<Cinema.Seat> seatPriceList = new ArrayList<>(olympian.getSeats());
        seatPriceList.add(olympian.new Seat("B00", 13.00));
        seatPriceList.add(olympian.new Seat("A00", 13.00));

        Collections.sort(seatPriceList, Cinema.PRICE_ORDER);
        printList(seatPriceList);


//        Cinema cinema = new Cinema("Cinema", 12, 28);
//        List<Cinema.Seat> copyList = new ArrayList<>(cinema.seats);
//        printList(copyList);
//
//        if (cinema.seats.get(1).reserve()) {
//            System.out.println("Please pay for A02");
//        } else {
//            System.out.println("A2 already reserved");
//        }
//
//        if (copyList.get(1).reserve()) {
//            System.out.println("Please pay for A02");
//        } else {
//            System.out.println("A2 already reserved");
//        }

//        List<Cinema.Seat> seat_plan = new ArrayList<>();
//        for (Cinema.Seat seat : cinema.seats) {
//            seat_plan.add(seat);
//        }
//
//        Collections.copy(seat_plan, cinema.seats);
//        printList(seat_plan);
//
//        seat_plan.remove(1);
//        printList(seat_plan);
//        printList(cinema.seats);


//        Cinema.Seat minCopy = Collections.min(copyList);
//        Cinema.Seat maxCopy = Collections.max(copyList);
//        Collections.reverse(copyList);
//        printList(copyList);
//        Collections.shuffle(copyList);
//        printList(copyList);
//        System.out.println(minCopy);
//        System.out.println(maxCopy);
//
//        Collections.shuffle(copyList);
//        printList(copyList);
//        sortList(copyList);
//        printList(copyList);


//        if (cinema.reserveSeat("D12")) {
//            System.out.println("Please pay");
//        } else {
//            System.out.println("Sorry seat not available");
//        }


//        if (cinema.reserveSeat("N18")) {
//            System.out.println("Please pay");
//        } else {
//            System.out.println("Sorry seat not available");
//        }
//        cinema.reserveSeat("N18");


    }

    public static void printList(List<Cinema.Seat> list) {
        for (Cinema.Seat seat : list) {
            System.out.print(String.format("%s : %.2f  ", seat, seat.getPrice()));
        }
        System.out.println();
    }

    public static void sortList(List<? extends Cinema.Seat> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).compareTo(list.get(j)) > 0) {
                    Collections.swap(list, i, j);
                }
            }
        }
    }

    public static void swapList(List<? extends Cinema.Seat> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).compareTo(list.get(j)) > 0) {
                    Collections.swap(list, i, j);
                }
            }
        }
    }
}
