package cinema;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Cinema {
    public int total_rows;
    public int total_columns;
    public List<Seat> available_seats;

    @JsonIgnore
    private List<OrderedSeat> orderedSeats;

    public Cinema(int total_rows, int total_columns, List<Seat> available_seats) {
        this.total_rows = total_rows;
        this.total_columns = total_columns;
        this.available_seats = available_seats;
        this.orderedSeats = new ArrayList<>();
    }

    public static Cinema getAllSeats(int rows, int columns) {
        List<Seat> seats = new ArrayList<>();
        for (int row = 1; row <= rows; row++) {
            for (int column = 1; column <= columns; column++) {
                seats.add(new Seat(row, column));
            }
        }
        return new Cinema(rows, columns, seats);
    }


    public int getTotal_rows() {
        return total_rows;
    }

    public void setTotal_rows(int total_rows) {
        this.total_rows = total_rows;
    }

    public int getTotal_columns() {
        return total_columns;
    }

    public void setTotal_columns(int total_columns) {
        this.total_columns = total_columns;
    }

    public List<Seat> getAvailable_seats() {
        return available_seats;
    }

    public void setAvailable_seats(List<Seat> available_seats) {
        this.available_seats = available_seats;
    }

    public List<OrderedSeat> getOrderedSeats() {
        return orderedSeats;
    }

    public void setOrderedSeats(List<OrderedSeat> orderedSeats) {
        this.orderedSeats = orderedSeats;
    }
}
