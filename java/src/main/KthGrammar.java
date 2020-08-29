package main;

public class KthGrammar {


    public int kthGrammar(int N, int K) {
        if(N == 1) return 0;
        int prevN = N -1;
        int prevK = (int) Math.ceil(K / 2.0);
        int prevKth = kthGrammar(prevN, prevK);
        if(prevKth == 0 && K % 2 == 1 || prevKth == 1 && K % 2 == 0) {
            return 0;
        } else return 1;
    }

    public static void main(String[] args) {
        KthGrammar solution = new KthGrammar();
        System.out.println(solution.kthGrammar(30, 434991989));
    }

}
