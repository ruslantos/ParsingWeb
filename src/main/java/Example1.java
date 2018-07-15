/**
 * Created by Руслан on 15.07.2018.
 */
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Example1 {
    public static void main(String[] args) throws IOException {
        List<Article> articleList = new ArrayList<Article>();
        Document doc = Jsoup.connect("http://4pda.ru/").get();
        Elements h2Elements = doc.getElementsByAttributeValue("class", "list-post-title");
        h2Elements.forEach(h2Element -> {
            Element ah2element = h2Element.child(0);
            String url = ah2element.attr("href");
            String title = ah2element.child(0).text();
            articleList.add(new Article(url, title));
        });
        articleList.forEach(System.out::println);
    }
}
class Article {
    private String url;
    private String name;

    public Article(String url, String name) {
        this.url = url;
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String  toString() {
        return "Article{" +
                "url='http:" + url + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}