public class Complement {


    public int findComplement(int num) {
        StringBuilder base2 = new StringBuilder();

        int quotient = num;
        int remainder = 0;
        while(quotient != 0) {
            remainder = quotient % 2;
            quotient = quotient / 2;
            base2.insert(0, remainder);
        }
        int complement = 0;
        for(int i = 0; i < base2.length(); i++) {
            if(base2.charAt(i) == '0') {
                complement += Math.pow(2,i);
            }
        }
        return complement;
    }

    public static void main(String[] args) {
        Complement solution = new Complement();
        System.out.println(solution.findComplement(11));
    }

}
