using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DataProje3
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int[] unsortedArray = {5,8,3,4,9,7};
            int[] unsortedArray2 = { 5, 8, 3, 4, 9, 7 };
            SelectionSort(unsortedArray);
            MergeSort(unsortedArray2);
            Console.WriteLine();
        }
        public static void SelectionSort(int[] arr)
        {
            // Loop through the array
            for (int i = 0; i < arr.Length; i++)
            {
                // Find the minimum element in the unsorted portion of the array
                int minIndex = i;
                for (int j = i + 1; j < arr.Length; j++)
                {
                    if (arr[j] < arr[minIndex])
                    {
                        minIndex = j;
                    }
                }

                // Swap the minimum element with the first element in the unsorted portion of the array
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
        public static void MergeSort(int[] arr)
        {
            // Base case: if the array has fewer than 2 elements, it is already sorted
            if (arr.Length < 2)
            {
                return;
            }

            // Divide the array in half
            int mid = arr.Length / 2;
            int[] left = new int[mid];
            int[] right = new int[arr.Length - mid];
            Array.Copy(arr, 0, left, 0, mid);
            Array.Copy(arr, mid, right, 0, arr.Length - mid);
            // Recursively sort the two halves
            MergeSort(left);
            MergeSort(right);
            // Merge the two sorted halves back together
            int i = 0, j = 0, k = 0;
            while (i < left.Length && j < right.Length)
            {
                if (left[i] <= right[j])
                {
                    arr[k] = left[i];
                    i++;
                }
                else
                {
                    arr[k] = right[j];
                    j++;
                }
                k++;
            }
            // Copy any remaining elements from the left half
            while (i < left.Length)
            {
                arr[k] = left[i];
                i++;
                k++;
            }
            // Copy any remaining elements from the right half
            while (j < right.Length)
            {
                arr[k] = right[j];
                j++;
                k++;
            }
        }
    }
}
