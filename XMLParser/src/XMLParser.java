import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLParser {
    public static void main(String[] args) {
        String filePath = "src/Books.xml";
        File xmlFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element : " + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("Book");
            List<Book> books = new ArrayList<Book>();

            for (int i = 0; i < nodeList.getLength(); i++) {
                books.add(getBook(nodeList.item(i)));
                System.out.println("\n" + "Total number of books in list: " + books.size() +"\n");
            }
            for (Book book : books) {
                System.out.println(book.toString());
            }
        } catch (SAXException | ParserConfigurationException | IOException e1) {
            e1.printStackTrace();
        }

    }

    private static Book getBook(Node node) {
        Book book = new Book();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            book.setTitle(getTagValue("title", element));
            book.setPublishedYear(Integer.parseInt(getTagValue("publishedYear", element)));
            book.setNumberOfPages(Integer.parseInt(getTagValue("numberOfPages", element)));
            book.setAuthors(getTagValue("authors", element));
        }
        return book;
    }

    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }

}


/**
 * The output of the above program:
 *
 * Root element : Books
 *
 * Total number of books in list: 1
 *
 *
 * Total number of books in list: 2
 *
 *
 * Total number of books in list: 3
 *
 *
 * Total number of books in list: 4
 *
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
 */
