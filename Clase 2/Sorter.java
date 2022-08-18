public class Sorter {
    
    public static void sort(int[] arr) {
        int aux = 0;
        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j + 1] < arr [j]) {
                    aux = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = aux;
                }
            }
        }
    }

    public static <T extends Comparable<T>> void genercSort(T[] arr) {
        T aux = null;
        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j + 1].compareTo(arr [j]) > 0) {
                    aux = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = aux;
                }
            }
        }
    }

}
