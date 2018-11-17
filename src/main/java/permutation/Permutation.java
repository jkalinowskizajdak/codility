package permutation;

import java.util.HashSet;
import java.util.Set;

/**
 A non-empty array A consisting of N integers is given.

 A permutation is a sequence containing each element from 1 to N once, and only once.

 For example, array A such that:

 A[0] = 4
 A[1] = 1
 A[2] = 3
 A[3] = 2
 is a permutation, but array A such that:

 A[0] = 4
 A[1] = 1
 A[2] = 3
 is not a permutation, because value 2 is missing.

 The goal is to check whether array A is a permutation.

 Write a function:

 class Solution { public int solution(int[] A); }

 that, given an array A, returns 1 if array A is a permutation and 0 if it is not.

 For example, given array A such that:

 A[0] = 4
 A[1] = 1
 A[2] = 3
 A[3] = 2
 the function should return 1.

 Given array A such that:

 A[0] = 4
 A[1] = 1
 A[2] = 3
 the function should return 0.

 Assume that:

 N is an integer within the range [1..100,000];
 each element of array A is an integer within the range [1..1,000,000,000].
 Complexity:

 expected worst-case time complexity is O(N);
 expected worst-case space complexity is O(N) (not counting the storage required for input arguments).
 */

public class Permutation {

    private Permutation() {

    }

    public static int solution(int[] A) {

        if (A == null || A.length == 0 ) {
            return 0;
        }

        if (A.length == 1) {
            if (A[0] == 1) {
                return 1;
            } else {
                return 0;
            }
        }


        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            set.add(i + 1);
        }
        Set<Integer> removed = new HashSet<>();
        for (int a: A) {
            if (!removed.contains(a)) {
                set.remove(a);
                removed.add(a);
            } else {
                return 0;
            }
        }

        if (set.size() == 0) {
            return 1;
        }

        return 0;


//        Set<Integer> set = new TreeSet<>();
//        for (int a: A) {
//            if (set.contains(a)) {
//                return 0;
//            }
//            set.add(a);
//        }
//
//        Iterator it = set.iterator();
//        int prev = 0;
//        int current = 0;
//        boolean first = true;
//        int firstElement = 0;
//        while (it.hasNext()) {
//            current = (Integer)it.next();
//            if (first) {
//                prev = current;
//                firstElement = current;
//                first = false;
//            }
//            if (current - prev > 1) {
//                return 0;
//            }
//            prev = current;
//        }
//        if (firstElement == 1) {
//            return 1;
//        }
//        return 0;
    }

}
