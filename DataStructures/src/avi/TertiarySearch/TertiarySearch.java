/**
 * 
 */
package avi.TertiarySearch;

/**
 * @author avinash
 * 
 */
public class TertiarySearch {  
    /**
     * This method searches the key in the given array using the tertiary sorting.
     * @param array
     * @param key
     * @param low
     * @param high
     * @return
     */
    public static int search(int[] array, int key, int low, int high) {
        int oneThird = ((2*low)+high)/3;
        int twoThird = ((low+(2*high))/3);

        if (oneThird >= twoThird) {
        	if((oneThird == twoThird) && (key == array[oneThird])){
        		return oneThird;
        	}
            return -1;

        }else if (key > array[twoThird] && twoThird <= high) { 
            return search(array, key, twoThird+1, high);
            
        } else if(key == array[twoThird]){
        	return twoThird;
        	
        } else if (key > array[oneThird]) { 
            return search(array, key, oneThird+1, twoThird);
            
        } else if(array[oneThird] == key){
        	return oneThird;
        	
        } else if (key < array[oneThird]) { 
            return search(array, key, low, oneThird);
            
        }
        else {
            return -1;
            
        }
    }

    /**
     * This is a main method which calls the other methods.
     * @param args
     */
    public static void main(String[] args) {
    	int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int key = search(array, 1, 0, array.length-1);
        if(key != -1){
        	 System.out.println(array[key]+ " key was found in the array at position "+ ++key);
        }else
            System.out.println("The key couldn't be found in the given array");
    }

}