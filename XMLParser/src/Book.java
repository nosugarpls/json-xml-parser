public class Book {

    private String title;
    private int publishedYear;
    private int numberOfPages;
    private String authors;

    public Book() {

    }

    public Book(String title, int publishedYear, int numberOfPages, String authors) {
        this.title = title;
        this.publishedYear = publishedYear;
        this.numberOfPages = numberOfPages;
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public String getAuthors() {
        return authors;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("\n");
        res.append("-------\n");
        res.append("title: " + title + "\n");
        res.append("publishedYear: " + publishedYear + "\n");
        res.append("numberOfPages: "+ numberOfPages + "\n");
        res.append("authors: " + authors);
        return res.toString();
    }


}
