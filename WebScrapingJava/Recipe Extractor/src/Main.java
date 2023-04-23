import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter URL: ");
        String url = scan.nextLine();

        Instant start = Instant.now();

        RecipeExtractor re = new RecipeExtractor();
//
        re.setUrl(url);
//        System.out.println(re.getUrl());

        // call recipeScrape
        int startIndex = url.indexOf("//") + 2; // start index of the substring
        int endIndex = url.indexOf(".com"); // end index of the substring
        String domain = url.substring(startIndex, endIndex);

        if (domain != null && domain.startsWith("www.")) {
            domain = domain.substring(4);
        }
//        System.out.println(domain);

        if (domain.equals("addapinch")) {
            re.scrapeData1();
        } else if (domain.equals("lifeloveandsugar")) {
            re.scrapeData2();
        } else if (domain.equals("natashaskitchen")) {
            re.scrapeData3();
        } else if (domain.equals("eitanbernath")) {
            re.scrapeData4();
        } else if (domain.equals("thespruceeats")) {
            re.scrapeData5();
        } else if (domain.equals("allrecipes")) {
            re.scrapeData6();
        } else if (domain.equals("delish")) {
            re.scrapeData7();
        } else if (domain.equals("pinchofyum")) {
            re.scrapeData8();
        } else {
            System.out.println(domain+ " No data for this website!");
        }

        System.out.println("----------------------------");
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start,end);
        System.out.println("Time taken for Scraping: "+timeElapsed.toSeconds()+" secs");
    }
}