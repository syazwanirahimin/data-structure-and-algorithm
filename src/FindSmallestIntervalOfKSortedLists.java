/** Given K sorted lists of integers, find the smallest interval (inclusive) that contains at least one element
 * from each of the k list.
 * If there are multiple intervals of the same size, return the one that strts at the smallest number
 *
 * A[] = {4, 10, 15, 24, 26}, 24 is in range [20,24]
 * B[] = [0, 9, 12, 20}, 20 is in range [20,24]
 * C[] = [5, 18, 22, 30}, 22 is in range [20,24]
 *
 * output: smallest range is: 2 from 1 to 3
 */
public class FindSmallestIntervalOfKSortedLists {

    /**
     * 1. create a min heap to store k elements, one from each array and a variable minrange initialized to a
     * maximum value and also keep a vairable max to store the maximum integer.
     * 2. initially put the first element of each element from each list and store the maximum value in max
     * 3. repeat the followings teops until at least one list exhausts:
     * a. to find the min value, use the top or root of the min heap which is the min element
     * b. now update the minrange if current (max - min) is less than minrange
     * c. remove the top or rott element from priority queue and insert the next element from the list which contains the min
     * element and update the max with the new element inserted
     */
    // a min heap node
    public static class Node {
        int ele; //the element to be stored
        int i; //index of the list from which the element is taken
        int j; // index of the next element to be picked from the list
        Node(int a, int b, int c){
            this.ele = a;
            this.i = b;
            this.j = c;
        }
    }
    // a class for min heap
    public static class MinHeap {
        Node[] array; // array of elements in heap
        int size; // size of min heap

        MinHeap(Node[] arr, int size){ //constructor: create a min heap of given size
            this.array = arr;
            this.size = size;
            int i = (size - 1) / 2;
            while (i >= 0) {
                MinHeapify(i);
                i--;
            }
        }

        int left(int i){ // to get index of left child of node at index i
            return 2*i+1;
        }
        int right(int i) { // to get index of right child of node at index i
            return 2 * i + 2;
        }

        public void MinHeapify(int i) {
            int l = left(i);
            int r = right(i);
            int small = i;
            if ( l < size && array[l].ele < array[i].ele)
                small = l;
            if (r < size && array[r].ele < array[small].ele)
                small = r;
            if (small != i){
                swap(small, i);
                MinHeapify(small);
            }
        }
        void swap(int i, int j){
            Node temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

        // to get the root
        Node getMin(){
            return array[0];
        }

        //to replace root with new node x and heapify() new root
        void replaceMin(Node x){
            array[0] = x;
            MinHeapify(0);
        }
    }


    // This function takes an k sorted lists
    // in the form of 2D array as an argument.
    // It finds out smallest range that includes
    // elements from each of the k lists.
    static void findSmallestRange(int[][] arr, int k)
    {
        int range = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int start = -1, end = -1;

        int n = arr[0].length;

        // Create a min heap with k heap nodes.
        // Every heap node has first element of an list
        Node[] arr1 = new Node[k];
        for (int i = 0; i < k; i++) {
            Node node = new Node(arr[i][0], i, 1);
            arr1[i] = node;

            // store max element
            max = Math.max(max, node.ele);
        }

        // Create the heap
        MinHeap mh = new MinHeap(arr1, k);

        // Now one by one get the minimum element
        // from min heap and replace it with
        // next element of its list
        while (true) {
            // Get the minimum element and
            // store it in output
            Node root = mh.getMin();

            // update min
            min = root.ele;

            // update range
            if (range > max - min + 1) {
                range = max - min + 1;
                start = min;
                end = max;
            }

            // Find the next element that will
            // replace current root of heap.
            // The next element belongs to same
            // list as the current root.
            if (root.j < n) {
                root.ele = arr[root.i][root.j];
                root.j++;

                // update max element
                if (root.ele > max)
                    max = root.ele;
            }
            // break if we have reached
            // end of any list
            else
                break;

            // Replace root with next element of list
            mh.replaceMin(root);
        }
        System.out.print("The smallest range is [" + start + " " + end + "]");
    }

    // Driver Code
    public static void main(String[] args)
    {
        int arr[][] = { { 4, 7, 9, 12, 15 },
                { 0, 8, 10, 14, 20 },
                { 6, 12, 16, 30, 50 } };

        int k = arr.length;

        findSmallestRange(arr, k);
    }
}