package class01;


import java.util.Arrays;

/**
 * 二分法查找
 *
 * @author huangcheng
 */
public class Code04BSExist {
  public static boolean exist(int[] sortedArr, int num) {
    if (sortedArr == null || sortedArr.length < 2) {
      return false;
    }
    int L = 0, R = sortedArr.length, mid = 0;
    while (L < R) {
      // 考虑L和R很大的情况采用这种
      // (L+R)/2
      mid = L + ((R - L) >> 1);
      if (sortedArr[mid] == num) {
        return true;
      } else if (sortedArr[mid] > num) {
        R = mid - 1;
      } else {
        L = mid + 1;
      }
    }
    return sortedArr[mid] == num;
  }

  /**
   * 找到满足>=value的最左位置
   *
   * @param arr
   * @param value
   * @return
   */
  public static int nearestIndex(int[] arr, int value) {
    // index 记录最左的序号
    int L = 0, R = arr.length - 1, index = -1;
    while (L <= R) {
      int mid = L + ((R - L) >> 1);
      if (arr[mid] >= value) {
        index = mid;
        R = mid - 1;
      } else {
        L = mid + 1;
      }
    }
    return index;
  }

  public static int test(int[] arr, int value) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] >= value) {
        return i;
      }
    }
    return -1;
  }


  public static int[] copyArray(int[] arr) {
    if (arr == null) {
      return null;
    }
    int[] res = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
      res[i] = arr[i];
    }
    return res;
  }

  public static void printArray(int[] arr) {
    if (arr == null) {
      return;
    }
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  /**
   * 生成符合规范的数组
   *
   * @param maxSize  数组最大长度
   * @param maxValue 数组内数值最大值
   * @return 符合规范的数组
   */
  public static int[] generateRandomArray(int maxSize, int maxValue) {
    int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
    }
    return arr;
  }

  public static void main(String[] args) {
    int testTimes = 500000;
    int maxSize = 100;
    int maxValue = 100;
    boolean succeed = true;
    for (int i = 0; i < testTimes; i++) {
      int[] arr = generateRandomArray(maxSize, maxValue);
      Arrays.sort(arr);
      int value = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
      if (test(arr, value) != nearestIndex(arr, value)) {
        printArray(arr);
        System.out.println(value);
        System.out.println(test(arr, value));
        System.out.println(nearestIndex(arr, value));
        succeed = false;
        break;
      }
    }
    System.out.println(succeed ? "Nice" : "Not Good");
  }
}

