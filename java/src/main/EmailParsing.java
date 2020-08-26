import java.util.HashSet;
import java.util.Set;

public class EmailParsing {

    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<String>();

        for(String email : emails) {
            String parsedEmail = parseEmail(email);
            uniqueEmails.add(parsedEmail);
        }
        return uniqueEmails.size();


    }


    private String parseEmail(String email) {
        StringBuilder builder = new StringBuilder();
        boolean localName = true;
        boolean skip = false;
        for(int i = 0; i < email.length(); i++) {
            Character cur = email.charAt(i);
            if(cur == '@') localName = false;
            if(localName) {
                if(skip) continue;
                if(cur == '.') continue;
                if(cur == '+') {
                    skip = true;
                    continue;
                }
            }
            builder.append(cur);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        EmailParsing solution = new EmailParsing();
        System.out.println(solution.numUniqueEmails(new String[] {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"}));
    }

}
