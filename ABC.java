import java.util.*;
public class ABC {
    int N;
    int K;
    String[][][][] memo;
  public String createString(int N, int K) {

        this.N = N;
        this.K = K;
        
        memo = new String[N + 1][K + 1][N + 1][ N + 1];
    String res = go(0, K, 0, 0);
    
    if (res.equals("X")) {
        res = "";
    }


    return res;
  }

  private String go(int pos, int k, int nA, int nB) {
      if (memo[pos][k][nA][nB] != null) {
          return memo[pos][k][nA][nB];
      }
      if (pos == N) {
          if (k == 0) {
              return memo[pos][k][nA][nB] = "";
          } else {
              return memo[pos][k][nA][nB] = "X";
          }
      } else {
          String res = go(pos + 1, k, nA + 1, nB);
          if (!res.equals("X")) {
              return memo[pos][k][nA][nB] = "A" + res;
          }
          if (k >= nA) {
              res = go(pos + 1, k - nA, nA, nB + 1);
              if (!res.equals("X")) {
                  return  memo[pos][k][nA][nB]= "B" + res;
              }
          }
          if (k >= nA + nB) {
              res = go(pos + 1, k - nA - nB, nA, nB);
              if (!res.equals("X")) {
                  return memo[pos][k][nA][nB] = "C" + res;
              }
          }
          
          return memo[pos][k][nA][nB] = "X";
      }
  }

}
