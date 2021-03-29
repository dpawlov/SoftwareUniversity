package Articles02;

public class Article {
    private String title;
    private String content;
    private String author;

    public Article(String title, String content, String author){
        this.author = author;
        this.content = content;
        this.title = title;
    }

    public void edit(String content){
        this.content = content;
    }

    public void changeAuthor(String author){
        this.author = author;
    }

    public void rename(String title){
        this.title = title;
    }

    @Override
    public String toString(){
        String result = String.format("%s - %s: %s",
                this.title, this.content, this.author);
        return result;
    }
}


