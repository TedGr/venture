package algorithm.sort;

/**
 * 二分查找
 *
 * @Author: gongran
 * @Date: 2020 2020/7/15 9:23 下午
 */
public class DichotomySeek {

    /**
     * 二分查找
     *
     * @param a
     * @param low
     * @param high
     * @param seekNum
     * @return
     */
    private static int dichotomySeek(int[] a, int low, int high, int seekNum) {
        while (low <= high) {
            //避免high + low值太大溢出，>>1移位操作是提升效率
            int mid = low + ((high - low) >> 1);
            if (a[mid] == seekNum) {
                return mid;
            }
            if (a[mid] > seekNum) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 二分查找递归实现
     *
     * @return
     */
    private static int recursiveDichotomySeek(int[] a, int low, int high, int seekNum) {
        if(low > high){
            return -1;
        }
        int mid = low + ((high - low) >> 1);
        if (a[mid] == seekNum) {
            return mid;
        }
        if (a[mid] > seekNum) {
            return recursiveDichotomySeek(a, low, mid - 1, seekNum);
        } else {
            return recursiveDichotomySeek(a, mid + 1, high, seekNum);
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 5, 6, 7, 8, 9, 12, 13, 17, 19};
        System.out.println(recursiveDichotomySeek(a, 3, 9, 12));
    }
}
