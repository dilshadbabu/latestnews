import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TimeWebsiteScraper {

    public static void main(String[] args) {
        String url = "https://time.com";
        String htmlContent = fetchHtmlContent(url);
        
        if (htmlContent != null) {
            String[] stories = extractLatestStories(htmlContent, 6);
            
            for (String story : stories) {
                System.out.println(story);
            }
        } else {
            System.out.println("Failed to fetch the website content.");
        }
    }

    private static String fetchHtmlContent(String url) {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder content = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line);
                }
                reader.close();
                return content.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String[] extractLatestStories(String htmlContent, int count) {
        String[] stories = new String[count];
        
        // Implement the logic to parse HTML and extract story information here
        
        return stories;
    }
}






--------------------------------------


	import com.google.gson.Gson; // Import Gson library

public class TimeWebsiteScraper {

    public static void main(String[] args) {
        // ... (similar code for fetching HTML content and extracting stories)
        String[] stories = extractLatestStories(htmlContent, 6);
        
        // Convert stories to JSON and print
        Gson gson = new Gson();
        String json = gson.toJson(stories);
        System.out.println(json);
    }

    // ... (fetchHtmlContent method and extractLatestStories method)

    private static String[] extractLatestStories(String htmlContent, int count) {
        String[] stories = new String[count];

        // Implement the logic to parse HTML and extract story information here
        // Populate the stories array with JSON formatted strings
        stories[0] = "{\"title\": \"Amy Schneider’s Jeopardy! Streak Ends at 40 Consecutive Wins and $1.4 Million\", \"link\": \"https://time.com/6142934/amy-schneider-jeopardy-streak-ends/\"}";
        stories[1] = "{\"title\": \"'Writing With Fire' Shines a Light on All-Women News Outlet\", \"link\": \"https://time.com/6142628/writing-with-fire-india-documentary/\"}";
        // ... (similar entries for other stories)

        return stories;
    }
}
