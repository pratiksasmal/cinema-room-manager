package cinema;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.List;
import java.util.UUID;

import static cinema.Cinema.getAllSeats;

@RestController
public class SeatsController {
    private Cinema cinema;

    public SeatsController() {
        this.cinema = getAllSeats(9, 9);
    }

    //handles get request
    @GetMapping("/seats")
    public Cinema getSeats() {
        return cinema;
    }

    /*endpoint that handles POST requests and marks a booked ticket as purchased.*/

    @PostMapping("/purchase")
    public ResponseEntity<?> purchase(@RequestBody Seat seat) {
        if (seat.getColumn() > cinema.getTotal_columns()
                || seat.getRow() > cinema.getTotal_rows()
                || seat.getRow() < 1
                || seat.getColumn() < 1) {
            return new ResponseEntity<>(Map.of("error", "The number of a row or a column is out of bounds!"), HttpStatus.BAD_REQUEST);
            //400 (Bad Request)
        }
        for (int i = 0; i < cinema.getAvailable_seats().size(); i++) {
            Seat s = cinema.getAvailable_seats().get(i);

            //using uuid to generate a token
            if (s.equals(seat)) {
                OrderedSeat orderedSeat = new OrderedSeat(UUID.randomUUID(), s);
                cinema.getOrderedSeats().add(orderedSeat);
                cinema.getAvailable_seats().remove(i);
                return new ResponseEntity<>(orderedSeat, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(Map.of("error", "The ticket has been already purchased!"), HttpStatus.BAD_REQUEST);
        //400 is (Bad Request)
    }

}

class Token {
    UUID token;

    public Token() {
    }

    public Token(UUID token) {
        this.token = token;
    }

    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }
}