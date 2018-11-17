package twoPossibleOperations;

/**
 You are given N counters, initially set to 0, and you have two possible operations on them:

 increase(X) − counter X is increased by 1,
 max counter − all counters are set to the maximum value of any counter.
 A non-empty array A of M integers is given. This array represents consecutive operations:

 if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
 if A[K] = N + 1 then operation K is max counter.
 For example, given integer N = 5 and array A such that:

 A[0] = 3
 A[1] = 4
 A[2] = 4
 A[3] = 6
 A[4] = 1
 A[5] = 4
 A[6] = 4
 the values of the counters after each consecutive operation will be:

 (0, 0, 1, 0, 0)
 (0, 0, 1, 1, 0)
 (0, 0, 1, 2, 0)
 (2, 2, 2, 2, 2)
 (3, 2, 2, 2, 2)
 (3, 2, 2, 3, 2)
 (3, 2, 2, 4, 2)
 The goal is to calculate the value of every counter after all operations.

 Write a function:

 class Solution { public int[] solution(int N, int[] A); }

 that, given an integer N and a non-empty array A consisting of M integers, returns a sequence of integers representing the values of the counters.

 The sequence should be returned as:

 a structure Results (in C), or
 a vector of integers (in C++), or
 a record Results (in Pascal), or
 an array of integers (in any other programming language).

 */

public class TwoPossibleOperations {

    private TwoPossibleOperations() {

    }


    public static int[] solution(int N, int[] A) {

        if (N <= 0 || A == null || A.length == 0) {
            int[] empty = {};
            return empty;
        }

        int[] result = new int[N];
        int max = 0;
        int lastUpdate = 0;
        for(int a: A) {
            int index = a - 1;
            if(index < N) {
                if(result[index] < lastUpdate) {
                    result[index] = lastUpdate + 1;
                }
                else {
                    result[index]++;
                }
                max = Math.max(max, result[index]);
            }
            else {
                lastUpdate = max;
            }
        }
        for(int i = 0; i < N; i++) {
            if (result[i] < lastUpdate) {
                result[i] = lastUpdate;
            }
        }

        return result;
    }
}
