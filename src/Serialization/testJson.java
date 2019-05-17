package Serialization;
import java.io.IOException;

public class testJson {
    private String author="Follonier Grégory";
    private String title="Un jour, un espoir: La vie d'un homme";
    private String journal="London herald";
    private String url="https://www.gregory.com/sites/Un jour, un espoir";


    public String getAuthor(){
        return author;
    }public void setAuthor(String author){
        this.author=author;

    }public String getTitle(){
        return title;
    }public void setTitle(String title){
        this.title=title;

    }public String getJournal(){
        return journal;
    }public void setJournal(String journal){
        this.journal=journal;

    }public String getUrl(){
        return url;
    }public void setUrl(String url){
        this.url=url;

    }public String toString(){
        return author + ". " + title + ". In " + journal + ".\n(" + url + ")";
    }public static void main(String[] args)  {
            testJson t1=new testJson();

    }
}
