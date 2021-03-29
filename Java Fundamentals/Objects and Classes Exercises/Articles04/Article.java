package Articles04;

public class Article {
    String title;
    String content;
    String author;

    String getTitle() {
        return title;
    }

    String getContent() {
        return content;
    }

    String getAuthor() {
        return author;
    }

    Article(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    @Override
    public String toString() {
        return String.format("%s - %s: %s", title, content, author);
    }
}
