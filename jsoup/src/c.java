import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class c {
    public static void main( String[] args ) throws IOException {
//        Document doc = Jsoup.connect("http://www.nettruyen.com/").get();
//        String title = doc.title();
//        System.out.println("Title : " + title);
        BufferedReader br = null;

        try {

            URL url = new URL("https://dantri.com.vn/");
            br = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;

            StringBuilder sb = new StringBuilder();

            while ((line = br.readLine()) != null) {

                sb.append(line);
                sb.append(System.lineSeparator());
            }

            System.out.println(sb);
        } finally {

            if (br != null) {
                br.close();
            }
        }
    }
}
