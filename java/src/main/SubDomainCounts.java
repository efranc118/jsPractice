import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class SubDomainCounts {
    public List<String> subdomainVisits(String[] cpdomains) {

        HashMap<String, Integer> map = new HashMap<>();

        for(String item: cpdomains) {
        Integer count = Integer.parseInt(item.split(" ")[0]);
        String domain = item.split(" ")[1];

        String[] splitDomains = domain.split("\\.");
        StringBuilder domainBuilder = new StringBuilder();
        for(int i = splitDomains.length - 1; i >= 0; i--) {
            if(domainBuilder.length() == 0) domainBuilder = new StringBuilder(splitDomains[i]);
            else domainBuilder.insert(0, splitDomains[i] + ".");
            if(map.get(domainBuilder.toString()) != null) map.put(domainBuilder.toString(),
                    count + map.get(domainBuilder.toString()));
            else map.put(domainBuilder.toString(), count);
        }
    }
    ArrayList<String> result = new ArrayList<>();
        map.forEach((key, value) -> {
        String returnValue = value + " " + key;
        result.add(returnValue);
    });

        return result;
}

    public static void main(String[] args) {
        SubDomainCounts test = new SubDomainCounts();
        String[] examples = new String[4];
        examples[0] = "900 google.mail.com";
        examples[1] = "50 yahoo.com";
        examples[2] = "1 intel.mail.com";
        examples[3] = "5 wiki.org";
        List<String> result = test.subdomainVisits(examples);
        for(String item: result) {
            System.out.println(item);
        }
    }
}
