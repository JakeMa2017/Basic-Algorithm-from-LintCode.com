/**
 * 代码来自：https://blog.csdn.net/zjkC050818/article/details/66474150
 * 侵删
 */

public class PageNumber {
    public void display(int n) {
        int[] result = new int[10];
        for (int i = 0; i < 10; i++) {
            result[i] = 0;
        }
        count(n, result);
        for (int i = 9; i >= 0; i--) {
            System.out.print(result[i] + " ");
        }
    }

    public void count(int n, int arr[]) {
        for (int i = 1; n / i != 0; i *= 10) {
            //394 i=1时，before=39 after=0 current=4;
            // i=10 before=3 after=3,current=9;
            int before = n / (i * 10);
            int after = n % i;
            int current = (n / i) % 10;
            //统计当前循环0的个数
            if (current == 0) {
                arr[0] += (before - 1) * i + after + 1;
            } else {
                arr[0] += before * i;
            }
            //统计当前current循环1至9的个数
            for (int index = 1; index < 10; index++) {
                if (index < current) {
                    arr[index] += (1 + before) * i;
                } else if (index == current) {
                    arr[index] += before * i + after + 1;
                } else {
                    arr[index] += before * i;
                }
            }
        }

    }
}
