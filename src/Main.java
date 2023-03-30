public class Main {
    public static void main(String[] args) {
        int[] arr = {5, 1, 4, 3, 2, 8};
        System.out.println(cons(arr));
    }

    public static boolean cons(int[] arr) {
        boolean flag = false;
        int lowest = arr[0];
        int container = arr.length;
        int [] orgnazidedArr = new int[arr.length];

        //Repeated values

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                if(i == j){
                    continue;
                }
                if(arr[i] == arr[j]){
                    return false;
                }
            }
        }

        for (int i = 0; i < container; i ++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] <= lowest) {
                    lowest = arr[j];
                }
            }
            orgnazidedArr[i] = lowest;
            arr = removeItem(arr, lowest);
            lowest = 10000;
        }

        for(int i = orgnazidedArr.length - 1; i > 0; i--){
            if(orgnazidedArr[i] - 1 == orgnazidedArr[i - 1]){
                flag = true;
            }else {
                return false;
            }
        }

        return flag;
    }

    public static int[] removeItem(int[] arr, int pos){
        int[] proxyArray = new int[arr.length - 1];
        int indexRem = 0;
        for(int j = 0; j < arr.length; j++){
            if(arr[j] == pos){
                indexRem = j;
            }
        }

        // copy all the elements in the original to proxy array except the one at index
        for (int i = 0, k = 0; i < arr.length; i++) {
            // check if index is crossed, continue without copying
            if (i == indexRem) {
                continue;
            }
            // else copy the element
            proxyArray[k++] = arr[i];
        }
        return proxyArray;
    }
}