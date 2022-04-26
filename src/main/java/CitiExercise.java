import java.util.Scanner;

/**
 * h=[4,1,1,3]
 * ans=9
 *
 *
 *
 * h=[1,8,6,2,5,4,8,3,7]
 *  * ans=49
 *
 *  max = 0 //non local
 *  F(h,start)
 *
 *  for (i = start; i < h.length; i++) {
 *
 *      if (h[i] > max)
 *         max = h[i];
 *      else
 *         for (j=i, j < h.length; j++) {
 *          if h[j] < max
 *             totalWater += max;
 *          else {
 *             F(h,j+1);
 *          }
 *
 *
 *      }
 *  }
 */

// Java implementation of the approach
class CitiExercise{

    // Function to return the maximum
// water that can be stored
    public static int maxWater(int[] arr, int n)
    {

        // To store the maximum water
        // that can be stored
        int res = 0;

        // For every element of the array
        // except first and last element
        for(int i = 1; i < n - 1; i++)
        {

            // Find maximum element on its left
            int left = arr[i];
            for(int j = 0; j < i; j++)
            {
                left = Math.max(left, arr[j]);
            }

            // Find maximum element on its right
            int right = arr[i];
            for(int j = i + 1; j < n; j++)
            {
                right = Math.max(right, arr[j]);
            }

            // Update maximum water value
            res += Math.min(left, right) - arr[i];
        }
        return res;
    }

    // Driver code
    public static void main(String[] args)
    {
        //                     i
        final int[] arr = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        final int n = arr.length;

        System.out.print(maxWater(arr,n));
    }
}


