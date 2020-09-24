import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class JSONParser {

    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();

        try {
            Book[] books = mapper.readValue(new File("src/Books.json"), Book[].class);
            for (Book book : books) {
                System.out.println(book.toString());
            }
            System.out.println("\nTotal number of books in array: " + books.length);

        } catch (Exception e) {

            e.printStackTrace();
        }



    }
}

/**
 * The output of the above program
 *
 * -------
 * title: Programming Pearls
 * publishedYear: 1999
 * numberOfPages: 256
 * authors: Jon Bentley
 *
 * -------
 * title: The Explorers Guild
 * publishedYear: 2015
 * numberOfPages: 784
 * authors: Kevin Costner, Jon Baird
 *
 * -------
 * title: Tiny Pretty Things
 * publishedYear: 2015
 * numberOfPages: 448
 * authors: Sona Charaipotra
 *
 * -------
 * title: Zenith
 * publishedYear: 2018
 * numberOfPages: 576
 * authors: Sasha Alsberg
 *
 * Total number of books in array: 4
 *
 */
