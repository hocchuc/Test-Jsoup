import org.jsoup.Jsoup;

import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainApplication {

    public static void main(String[] args) {
        try {
            String title = Jsoup.connect("https://www.bbc.com/news/business-46548527")
                    .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                    .referrer("http://www.google.com")
                    .get().select("h1.story-body__h1")
                    .first()
                    .toString();
            System.out.print(title);
            System.out.print("\n");
            List<String> body = Jsoup.connect("https://www.bbc.com/news/business-46548527")
                    .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                    .referrer("http://www.google.com")
                    .get().select("div.story-body")
                    .first()
                    .select("p").eachText();
            if(body != null)
            for (String part: body){
                if(part != null)
                System.out.print("\n "+part);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
