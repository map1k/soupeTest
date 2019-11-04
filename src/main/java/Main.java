import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("https://en.wikipedia.org/wiki/List_of_original_stand-up_comedy_specials_distributed_by_Netflix").get();
        System.out.println(doc.title());
        List<Special> list = getSpesial(doc);
        List<SpecialImdbInfo> listImdb = new ArrayList<>();

        String apiKey = "&apikey=ee2ac704";
        String urlStart = "http://www.omdbapi.com/?t=";
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        for (Special special : list) {
            String r = urlStart +
                    special.name.replace(" ", "+")
                            .replace(":", "%3A") +
                    "&y=" + special.year +
                    apiKey;
            URL url = new URL(r);
            SpecialImdbInfo s = mapper.readValue(url, SpecialImdbInfo.class);
            special.setScore(s.ratings);
            System.out.println(special);
        }
    }

    private static List<Special> getSpesial(Document doc) {

        List<Special> list = new ArrayList<>();

        for (Element table : doc.select("table")) {

            for (Element row : table.select("tr")) {

                Elements tds = row.select("td");
                if(tds.isEmpty()) continue;
                if(tds.size() != 4) continue;
                String author;
                String text = tds.get(0).text();
                if(text.contains("["))
                    text = text.substring(0, text.indexOf("["));
                if(text.contains(":"))
                    author = text.substring(0, text.indexOf(": "));
                else
                {
                    String[] arr = text.split("\\s+");
                    author = arr[0] + " " + arr[1];
                }
                String year = tds.get(1).text().substring(tds.get(1).text().indexOf(", ") + 2);
                if(year.contains("["))
                    year = year.substring(0, year.indexOf("["));
                if(!year.chars().allMatch( Character::isDigit )) continue;
                Special nevv = new Special(
                        text,
                        author,
                        Integer.valueOf(year),
                        tds.get(3).text()
                );
                list.add(nevv);
            }
        }
        return list;
    }

    static class Special{
        String name, author, language;
        int year;
        Ratings [] score;

        public Special(String name, String author, int year, String language) {
            this.name = name;
            this.author = author;
            this.year = year;
            this.language = language;
        }

        public String getRatings(){
            String ret = "";
            for (Ratings ratings : score) {
                ret += "\t";
                ret += ratings.toString() + "\n";
            }
            return ret;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public Ratings [] getScore() {
            return score;
        }

        public void setScore(Ratings [] score) {
            this.score = score;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }


        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("Special{").append("\n");
            sb.append("\t").append("name='").append(name).append('\'').append("\n");
            sb.append("\t").append("language='").append(language).append('\'').append("\n");
            sb.append("\t").append("year=").append(year).append("\n");
            sb.append(score == null ? "null" : getRatings());
            sb.append('}');
            return sb.toString();
        }
    }
}
