package algorithm.sort;

/**
 * 排序算法
 *
 * @Author: gongran
 * @Date: 2020 2020/7/5 10:31 上午
 */
public class SortAlgorithm {

    /**
     * 冒泡排序（time：O(n2) space:O(1) 稳定）
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
     * 插入排序 （time：O(n2) space:O(1) 不稳定）
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

    /**
     * 归并排序 （time：O(nlogn) space:O(n) 稳定）
     *
     * @param a
     */
    public static void mergeSort(int[] a) {
        if (a == null || a.length <= 1) {
            return;
        }
        merge(a, 0, a.length - 1);
    }

    /**
     * @param a
     * @param start
     * @param end
     */
    private static void merge(int[] a, int start, int end) {
        if (start >= end) {
            return;
        }

        int c = (start + end) / 2;

        merge(a, start, c);
        merge(a, c + 1, end);
        combine(a, start, c, end);
    }

    /**
     * @param a
     * @param start
     * @param mid
     * @param end
     * @return
     */
    private static int[] combine(int[] a, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int lIndex = start;
        int rIndex = mid + 1;
        int i = 0;
        while (lIndex <= mid && rIndex <= end) {
            if (a[lIndex] > a[rIndex]) {
                temp[i] = a[rIndex++];
            } else {
                temp[i] = a[lIndex++];
            }
            i++;
        }

        while (lIndex <= mid) {
            temp[i++] = a[lIndex++];
        }

        while (rIndex <= end) {
            temp[i++] = a[rIndex++];
        }

        for (int j = 0; j <= end - start; j++) {
            a[start + j] = temp[j];
        }
        return temp;
    }

    /**
     * 快排 （time：O(nlogn) space:O(1) 不稳定）
     *
     * @param a
     */
    private static void quickSort(int[] a) {
        if (a == null || a.length <= 1) {
            return;
        }

        quick(a, 0, a.length - 1);
    }

    private static void quick(int[] a, int p, int r) {
        if (p >= r) {
            return;
        }

        int q = parition(a, p, r);

        quick(a, p, q - 1);
        quick(a, q + 1, r);
    }

    private static int parition(int[] a, int p, int r) {
        int j = p;
        for (int i = p; i <= r - 1; i++) {
            if (a[i] <= a[r]) {
                swap(a, i, j++);
            }
        }
        swap(a, j, r);
        return j;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }

    /**
     * 计数排序 (time：O(n+k) space：O(n) 稳定) k是数据范围，即数组中最大的数
     *
     * @param a
     */
    public static void countingSort(int[] a) {
        if(a.length <= 1){
            return;
        }

        int max = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }

        int[] countArray = new int[max + 1];

        for (int i = 0; i < a.length; i++) {
            countArray[a[i]]++;
        }

        for (int i = 1; i < countArray.length; i++) {
            countArray[i] = countArray[i] + countArray[i - 1];
        }

        int[] temp = new int[a.length];
        //关键点，需要画图理解
        for (int i = 0; i < a.length; i++) {
            temp[(countArray[a[i]]--) - 1] = a[i];
        }

        for (int i = 0; i < a.length; i++) {
            a[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] a = new int[50000];
        for (int i = 0; i < 50000; i++) {
            a[i] = (int) (Math.random() * 50000);
        }
        /*Arrays.stream(a).forEach(item -> System.out.print(item + ","));
        System.out.println();
        countingSort(a);
        Arrays.stream(a).forEach(item -> System.out.print(item + ","));*/
        int[] bubblinga = a.clone();
        int[] insertiona = a.clone();
        int[] mergea = a.clone();
        int[] quicka = a.clone();



        Long startTime = System.currentTimeMillis();
        bubblingSort(bubblinga);
        Long endTime = System.currentTimeMillis();
        System.out.println("bubblingSort time consuming(ms)：" + (endTime - startTime));

        startTime = System.currentTimeMillis();
        insertionSort(insertiona);
        endTime = System.currentTimeMillis();
        System.out.println("insertionSort time consuming(ms)：" + (endTime - startTime));

        startTime = System.currentTimeMillis();
        mergeSort(mergea);
        endTime = System.currentTimeMillis();
        System.out.println("mergeSort time consuming(ms)：" + (endTime - startTime));

        startTime = System.currentTimeMillis();
        quickSort(quicka);
        endTime = System.currentTimeMillis();
        System.out.println("quicka time consuming(ms)：" + (endTime - startTime));

    }
}
