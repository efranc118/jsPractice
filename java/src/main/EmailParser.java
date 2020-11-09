package main;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 1. Ask Questions
 * 2. Fill the gaps after finishing main method
 */
public class EmailParser {


    private static String getUrl(String url) throws Exception {
//        HttpClient client = HttpClient.newHttpClient();
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create(url))
//                .build();
//
//        HttpResponse<String> response = client.send(request,
//                HttpResponse.BodyHandlers.ofString());
//
//        return response.body();
        return "";
    }


    private static List<Map<String, String>> parseEmails(String url, String body) {
        List<Map<String, String>> emailList = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\b[A-Z0-9._%-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,4}\\b");
        Matcher m = pattern. matcher(body);

        while(m.find()) {
            Map<String, String> emails = new HashMap<>();
            emails.put("url:", url);
            emails.put("email:", m.group());
            emailList.add(emails);
        }
        return emailList;
    }

    public List<Map<String, String>> getUrlEmails(List<String> urls) {
        List<Map<String,String>> result = new ArrayList<>(urls.size());

//        for(String url: urls) {
//            String body = getUrl(url);
//            List<Map<String,String>> result = parseEmails(body);
//            if(result.size() > 0) {
//                result.addAll(parseEmails(body));
//            }
//        }
        return result;
    }





    public static void main(String[] args) {
        EmailParser solution = new EmailParser();
//        System.out.println(solution.parseEmails());
    }

}
