public class Orders {

    public static void thirdSmallest(int[] array, int n) {
        int firstmin = Integer.MAX_VALUE;
        int secmin = Integer.MAX_VALUE;
        int thirdmin = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            /**
             * check if current element is less than firstmin, then update first, sec, third
             */
            if (array[i] < firstmin){
                thirdmin = secmin;
                secmin = firstmin;
                firstmin = array[i];
            }

            /**
             * check if current element is less than secmin and then update second and third
             */
            else if (array[i] < secmin){
                thirdmin = secmin;
                secmin = array[i];
            }
             else if (array[i] < thirdmin){
                 thirdmin = array[i];
            }

        }

        System.out.println("first min: " + firstmin);
        System.out.println("sec min: " + secmin);
        System.out.println("third min: " + thirdmin);

    }

    public static void main(String[] args) {
        Orders test = new Orders();
        int array[] = {4,9,1,32,12};
        int n = array.length;
        thirdSmallest(array, n);
    }
}


/**
 * pseudocode
 * First take an element
 * then if array[index] < Firstelement
 *         Thirdelement = Secondelement
 *         Secondelement = Firstelement
 *         Firstelement = array[index]
 *      else if array[index] < Secondelement
 *         Thirdelement = Secondelement
 *         Secondelement = array[index]
 *      else if array[index] < Thirdelement
 *         Thirdelement = array[index]
 *
 * then print all the element
 */