import com.google.gson.Gson;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class ParseMetroSite {
    public static void main(String[] args) throws Exception {
        Gson json = new Gson();
        try {
            Document document = Jsoup.connect("https://www.moscowmap.ru/metro.html#lines")
                    .userAgent("Chrome/4.0.249.0 Safari/532.5").referrer("http://www.google.com").maxBodySize(0).get();
            Elements listLines = document.select("div.js-metro-stations.t-metrostation-list-table");

            Map<String, List<String>> stationsMetro = new LinkedHashMap<String, List<String>>();
            List<metroln> linesMetro = new ArrayList<metroln>();

            for (Element element1 : listLines) {
                String numberLine = element1.attr("data-line");
                Elements listStations = element1.select("span.name");
                String lineName = document
                        .select("span.js-metro-line.t-metrostation-list-header.t-icon-metroln.ln-" + numberLine).text();
                List<String> stations1 = new ArrayList<>();

                for (Element element2 : listStations) {
                    String nameStation = element2.select("span.name").text();
                    stations1.add(nameStation);
                }

                metroln line1 = new metroln();
                line1.name = lineName;
                line1.number = numberLine;
                stationsMetro.put(numberLine, stations1);
                linesMetro.add(line1);
            }

            Metro metro = new Metro();
            metro.stations = stationsMetro;
            metro.lines = linesMetro;
            String jsonOutput = json.toJson(metro);

            FileWriter fileWriter = new FileWriter("Data/metro.json");
            fileWriter.write(jsonOutput);
            fileWriter.close();

            Metro metro1 = json.fromJson(parseFile(), Metro.class);

        } catch (Exception error) {
            System.out.println(error.toString());
        }

        Metro metro = json.fromJson(parseFile(), Metro.class);
        Iterator<Map.Entry<String, List<String>>> iterator = metro.stations.entrySet().iterator();
        List<LinesOutput> lines = new ArrayList<>();

        while (iterator.hasNext()) {
            Map.Entry<String, List<String>> stations = iterator.next();
            String key = stations.getKey();

            for (metroln lines1 : metro.lines) {
                if (key.equals(lines1.number))
                    key = lines1.name;
            }

            List<String> value = stations.getValue();
            lines.add(new LinesOutput(key, value.size()));
        }

        for (LinesOutput linesOutput : lines)
            System.out
                    .println("На линии \"" + linesOutput.nameLine + "\" " + linesOutput.quantityStation + " станций.");
    }

    public static String parseFile() {
        StringBuilder builder = new StringBuilder();
        try {
            List<String> files = Files.readAllLines(Paths.get("Data/metro.json"));
            files.forEach(file -> builder.append(file).append("\n"));
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }

        return builder.toString();
    }

    public static class Metro {
        public Map<String, List<String>> stations = new HashMap<String, List<String>>();
        public List<metroln> lines = new ArrayList<>();
    }

    public static class metroln {
        public String number;
        public String name;
    }

    public static class LinesOutput {
        String nameLine;
        int quantityStation;

        public LinesOutput(String nameLine, int quantityStation) {
            this.nameLine = nameLine;
            this.quantityStation = quantityStation;
        }
    }
}
