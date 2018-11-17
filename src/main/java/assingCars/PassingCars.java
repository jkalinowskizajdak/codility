package assingCars;

/**
 A non-empty array A consisting of N integers is given. The consecutive elements of array A represent consecutive cars on a road.

 Array A contains only 0s and/or 1s:

 0 represents a car traveling east,
 1 represents a car traveling west.
 The goal is to count passing cars. We say that a pair of cars (P, Q), where 0 ≤ P < Q < N, is passing when P is traveling to the east and Q is traveling to the west.

 For example, consider array A such that:

 A[0] = 0
 A[1] = 1
 A[2] = 0
 A[3] = 1
 A[4] = 1
 We have five pairs of passing cars: (0, 1), (0, 3), (0, 4), (2, 3), (2, 4).

 Write a function:

 class Solution { public int solution(int[] A); }

 that, given a non-empty array A of N integers, returns the number of pairs of passing cars.

 The function should return −1 if the number of pairs of passing cars exceeds 1,000,000,000.

 For example, given:

 A[0] = 0
 A[1] = 1
 A[2] = 0
 A[3] = 1
 A[4] = 1
 the function should return 5, as explained above.
 */


public class PassingCars {

    private PassingCars() {

    }

    public static int solution1(int[] A) {
        if (A == null || A.length <= 1 ) {
            return 0;
        }

        final int east = 0;
        final int west = 1;
        final int max = 1000000000;
        int result = 0;
        int amount = 0;
        boolean wasFirstEast = false;
        for (int a : A) {
            if (wasFirstEast) {
                if ( a == east) {
                    amount++;
                } else if (a == west) {
                    result = result + amount;
                }
            } else {
                if (a == east) {
                    wasFirstEast = true;
                    amount++;
                    continue;
                }
            }

            if (result > max) {
                return -1;
            }
        }
        return result;
    }

}
