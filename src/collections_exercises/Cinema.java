package collections_exercises;

import java.util.*;

public class Cinema {
    private final String cinemaName;
    private List<Seat> seats = new ArrayList<>();
    static final Comparator<Seat> PRICE_ORDER = (seat1, seat2) -> {
        if (seat1.getPrice() < seat2.getPrice()) {
            return -1;
        } else if (seat1.getPrice() > seat2.getPrice()) {
            return 1;
        } else {
            return 0;
        }
    };


    public Cinema(String cinemaName, int numberOfRows, int seatsPerRow) {
        this.cinemaName = cinemaName;

        int lastRow = 'A' + (numberOfRows - 1);
        for (char row = 'A'; row <= lastRow; row++) {
            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
                double price = 12.00;
                if (row < 'D' && seatNum >= 4 && seatNum <= 9) {
                    price = 14.00;
                } else if (row > 'F' || seatNum < 4 || seatNum > 9) {
                    price = 7.00;
                }
                Seat seat = new Seat(row + String.format("%02d", seatNum), price);
                seats.add(seat);
            }
        }
    }

    public List<Seat> getSeats() {
        return seats;
    }


    // for testing
//    public void getSeats() {
//        for (Seat seat : seats) {
//            System.out.println(seat.getSeatNumber() + " ");
//        }
//    }

    public String getCinemaName() {
        return cinemaName;
    }

    public boolean reserveSeat(String seatNumber) {
        Seat requestedSeat = new Seat(seatNumber, 0);
        int foundSeat = Collections.binarySearch(seats, requestedSeat, null);
        System.out.println("*");
        if (foundSeat >= 0) {
            return seats.get(foundSeat).reserve();
        } else {
            return false;
        }
    }

    public boolean reserveTheSeat(String seatNumber) {
        int low = 0;
        int high = seats.size() - 1;

        while (low <= high) {
            System.out.println("*");
            int mid = (low + high) / 2;
            Seat midVal = seats.get(mid);
            int comp = midVal.getSeatNumber().compareToIgnoreCase(seatNumber);
            if (comp < 0) {
                low = mid + 1;
            } else if (comp > 0) {
                high = mid - 1;
            } else {
                return midVal.reserve();
            }
        }
        System.out.println("Seat " + seatNumber + " not found");
        return false;
    }

    public class Seat implements Comparable<Seat> {
        private String seatNumber;
        private double price;

        private boolean reserved;

        public Seat(String seatNumber, double price) {
            this.seatNumber = seatNumber;
            this.price = price;
        }

        public String getSeatNumber() {
            return seatNumber;
        }

        public double getPrice() {
            return price;
        }

        public boolean reserve() {
            if (!reserved) {
                reserved = true;
                System.out.println("Seat number " + seatNumber + " successfully reserved");
                return true;
            } else {
                return false;
            }
        }

        public boolean cancel() {
            if (reserved) {
                reserved = false;
                System.out.println("Reservation of seat " + seatNumber + " successfully cancelled");
                return true;
            } else {
                return false;
            }
        }

        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }

        @Override
        public String toString() {
            return seatNumber + " ";
        }
    }

}
