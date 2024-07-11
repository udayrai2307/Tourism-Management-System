import java.util.ArrayList;
import java.util.List;

class Tourist {
    private String name;
    private String email;
    private List<Tour> bookedTours;

    public Tourist(String name, String email) {
        this.name = name;
        this.email = email;
        this.bookedTours = new ArrayList<>();
    }

    public void bookTour(Tour tour) {
        bookedTours.add(tour);
    }

    public List<Tour> getBookedTours() {
        return bookedTours;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}


class Tour {
    private String name;
    private String destination;
    private double price;

    public Tour(String name, String destination, double price) {
        this.name = name;
        this.destination = destination;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDestination() {
        return destination;
    }

    public double getPrice() {
        return price;
    }

    public String getDetails() {
        return String.format("Tour: %s, Destination: %s, Price: %.2f", name, destination, price);
    }
}

// TourOperatorInterface
interface TourOperatorInterface {
    void addTour(Tour tour);
    void removeTour(Tour tour);
    List<String> listTours();
    void bookTourForTourist(Tourist tourist, Tour tour);
}


class TourOperator implements TourOperatorInterface {
    private List<Tour> tours;
    private List<Tourist> tourists;

    public TourOperator() {
        this.tours = new ArrayList<>();
        this.tourists = new ArrayList<>();
    }

    public void addTour(Tour tour) {
        tours.add(tour);
    }

    public void removeTour(Tour tour) {
        tours.remove(tour);
    }

    public List<String> listTours() {
        List<String> tourDetails = new ArrayList<>();
        for (Tour tour : tours) {
            tourDetails.add(tour.getDetails());
        }
        return tourDetails;
    }

    public void bookTourForTourist(Tourist tourist, Tour tour) {
        tourist.bookTour(tour);
        if (!tourists.contains(tourist)) {
            tourists.add(tourist);
        }
    }
}


public class Main {
    public static void main(String[] args) {
        Tour tour1 = new Tour("Beach Paradise", "Hawaii", 1200.00);
        Tour tour2 = new Tour("Mountain Adventure", "Swiss Alps", 2500.00);

        Tourist tourist1 = new Tourist("John Doe", "john.doe@example.com");

        TourOperator operator = new TourOperator();

        operator.addTour(tour1);
        operator.addTour(tour2);

        System.out.println("Available Tours:");
        for (String tour : operator.listTours()) {
            System.out.println(tour);
        }

        operator.bookTourForTourist(tourist1, tour1);

        System.out.println("John's Booked Tours:");
        for (Tour tour : tourist1.getBookedTours()) {
            System.out.println(tour.getDetails());
        }
    }
}
