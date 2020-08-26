public class CountAndSay {

    public String countAndSay(int n) {
        String result = "1";
        for(int i = 1; i < n; i++) {
            StringBuilder nextResult = new StringBuilder();
            int currentCount = 0;
            int currentCharacter = Integer.parseInt(result.substring(0,1));
            for(int j = 0; j < result.length(); j++) {
                if(currentCharacter == Integer.parseInt(result.substring(j, j+ 1))) {
                    currentCount += 1;
                } else {
                    nextResult.append(String.valueOf(currentCount) + String.valueOf(currentCharacter));
                    currentCount = 1;
                    currentCharacter = Integer.parseInt(result.substring(j, j+ 1));
                }
            }
            nextResult.append(String.valueOf(currentCount) + String.valueOf(currentCharacter));
        result = nextResult.toString();
        }
    return result;
    }

    public static void main(String[] args) {
        CountAndSay solution = new CountAndSay();
        System.out.println(solution.countAndSay(5));
    }

}
