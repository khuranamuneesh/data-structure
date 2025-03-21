class Movie
{
    String title;
    String director;
    int year;
    double rating;
    Movie next;
    Movie prev;

    public Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

class MovieManagement {
    private Movie head;
    private Movie tail;

    public void addMovie(String title, String director, int year, double rating, Integer position) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
            return;
        }
        if (position == null || position == 0) {  // Insert at beginning
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        } else {
            Movie temp = head;
            int count = 0;
            while (temp.next != null && count < position - 1) {
                temp = temp.next;
                count++;
            }
            newMovie.next = temp.next;
            newMovie.prev = temp;
            if (temp.next != null) {
                temp.next.prev = newMovie;
            } else {
                tail = newMovie;
            }
            temp.next = newMovie;
        }
    }

    public void removeMovie(String title) {
        Movie temp = head;
        while (temp != null && !temp.title.equals(title)) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Movie not found!");
            return;
        }
        if (temp.prev != null) {
            temp.prev.next = temp.next;
        } else {
            head = temp.next;
        }
        if (temp.next != null) {
            temp.next.prev = temp.prev;
        } else {
            tail = temp.prev;
        }
        System.out.println("Movie \"" + title + "\" removed.");
    }

    public void searchMovieByDirector(String director) {
        Movie temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.director.equals(director)) {
                System.out.println("Title: " + temp.title + ", Year: " + temp.year + ", Rating: " + temp.rating);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No movies found for director: " + director);
    }

    public void searchMovieByRating(double rating) {
        Movie temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.rating == rating) {
                System.out.println("Title: " + temp.title + ", Director: " + temp.director + ", Year: " + temp.year);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No movies found with rating: " + rating);
    }

    public void displayMoviesForward() {
        Movie temp = head;
        if (temp == null) {
            System.out.println("No movies available.");
            return;
        }
        while (temp != null) {
            System.out.println("Title: " + temp.title + ", Director: " + temp.director + ", Year: " + temp.year + ", Rating: " + temp.rating);
            temp = temp.next;
        }
    }

    public void displayMoviesReverse() {
        Movie temp = tail;
        if (temp == null) {
            System.out.println("No movies available.");
            return;
        }
        while (temp != null) {
            System.out.println("Title: " + temp.title + ", Director: " + temp.director + ", Year: " + temp.year + ", Rating: " + temp.rating);
            temp = temp.prev;
        }
    }

    public void updateRating(String title, double newRating) {
        Movie temp = head;
        while (temp != null) {
            if (temp.title.equals(title)) {
                temp.rating = newRating;
                System.out.println("Updated rating for \"" + title + "\" to " + newRating);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found!");
    }
}

public class MovieManagementDLL {
    public static void main(String[] args) {
        MovieManagement movies = new MovieManagement();
        movies.addMovie("Se7en", "David Fincher", 1995, 8.6, null);
        movies.addMovie("Animal", "Sandeep Reddy Vanga", 2023, 6.1, 1);
        movies.addMovie("Interstellar", "Christopher Nolan", 2014, 8.6, 2);

        System.out.println("\nAll Movies (Forward):");
        movies.displayMoviesForward();

        System.out.println("\nAll Movies (Reverse):");
        movies.displayMoviesReverse();

        System.out.println("\nSearching for movies by Christopher Nolan:");
        movies.searchMovieByDirector("Christopher Nolan");

        System.out.println("\nUpdating Rating for Inception:");
        movies.updateRating("Inception", 9.2);

        System.out.println("\nAll Movies After Update:");
        movies.displayMoviesForward();

        System.out.println("\nRemoving The Dark Knight:");
        movies.removeMovie("The Dark Knight");

        System.out.println("\nAll Movies After Removal:");
        movies.displayMoviesForward();
    }
}
