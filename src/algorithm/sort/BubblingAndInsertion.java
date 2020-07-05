package algorithm.sort;

/**
 * 冒泡排序和插入排序
 *
 * @Author: gongran
 * @Date: 2020 2020/7/5 10:31 上午
 */
public class BubblingAndInsertion {

    /**
     * 冒泡排序
     *
     * @param a
     */
    public static void bubblingSort(int[] a) {
        if (a == null || a.length <= 1) {
            return;
        }
        for (int i = 0; i < a.length; i++) {
            //当某一次排序没有数据交换时代表完全有序，就无需再次排序了
            boolean isStillCompare = false;
            for (int j = 1; j < a.length - i; j++) {
                if (a[j - 1] > a[j]) {
                    isStillCompare = true;
                    int temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                }
            }
            if (!isStillCompare) {
                break;
            }
        }
    }

    /**
     * 插入排序
     *
     * @param a
     */
    public static void insertionSort(int[] a) {
        if (a == null || a.length <= 1) {
            return;
        }
        for (int i = 1; i < a.length; i++) {
            int cur = a[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (a[j] > cur) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = cur;
        }

    }

    public static void main(String[] args) {
        int[] a = new int[50000];
        for (int i = 0; i < 50000; i++) {
            a[i] = (int) (Math.random() * 50000);
        }
        int[] bubblinga = a.clone();
        int[] insertiona = a.clone();
        Long startTime = System.currentTimeMillis();
        bubblingSort(bubblinga);
        Long endTime = System.currentTimeMillis();
        System.out.println("bubblingSort time consuming(ms)：" + (endTime - startTime));

        startTime = System.currentTimeMillis();
        insertionSort(insertiona);
        endTime = System.currentTimeMillis();
        System.out.println("insertionSort time consuming(ms)：" + (endTime - startTime));
    }
}
