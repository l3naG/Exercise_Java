package other;

public class Binary {

    public static void main(String[] args) {
        int[] my_array = {2, 34, 56, 77, 89, 112, 123, 234, 506};
        int index = binarySearch(my_array, 234);
        System.out.println(index);

        int low = 0;
        int high = my_array.length - 1;
        int index_2 = binarySearch(my_array, low, high, 89);
        System.out.println(index_2);

    }

    public static int binarySearch(int[] val, int target) {
        int low = 0;
        int high = val.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (val[mid] == target) {
                return mid;
            } else if (val[mid] < target) {
                low = mid + 1;
            } else if (val[mid] > target) {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] vals, int low, int high, int target) {
        low = 0;
        high = vals.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (vals[mid] < target) {
                return binarySearch(vals, mid + 1, high, target);
            } else if (vals[mid] > target) {
                return binarySearch(vals, 0, mid - 1, target);
            } else if (vals[mid] == target) {
                return mid;
            }
        }
        return -1;
    }


    public static int find_number(int[] vals, int target) {
        int low = 0;
        int high = vals.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (vals[mid] < target) {
                low = mid + 1;
            } else if (vals[mid] > target) {
                high = mid - 1;
            } else if (vals[mid] == target) {
                return mid;
            }
        }
        return -1;
    }

}
