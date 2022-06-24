package test.date;

import java.util.Scanner;
/**
 * @Project: TestDate
 * @Author: 陈祖生
 * @Version: 1.0
 * @CreateTime: 2022/6/15 16:58
 * @Description: TestDate
 * 给你一个长度为 n 的整数数组nums和 一个目标值target。请你从 nums 中选出三个整数，使它们的和与target最接近。
 * 返回这三个数的和。
 * 假定每组输入只存在恰好一个解。
 */
public class TestDate {
    public static void main(String[] args) {
        System.out.println("请输入target");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println("请输入一组数组nums，以逗号分隔。");
        String[] str = scanner.next().split(",");
        int[] nums = new int[str.length];
        for(int i=0;i<nums.length;i++){
            nums[i]=Integer.parseInt(str[i]);
        }

        CloseNumber closeNumber = new CloseNumber(n, nums);
        System.out.println(closeNumber.addition());
    }
}

class CloseNumber {
    int target;
    int[] nums;
    CloseNumber(int target, int[] nums) {
        this.target = target;
        this.nums = nums;
    }
    public int addition() {
        int result1 = 0;
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            for (int i1 = i + 1; i1 < nums.length; i1++) {
                for (int i2 = i1 + 1; i2 < nums.length; i2++) {
                    result1 = nums[i] + nums[i1] + nums[i2];
                    if (Math.abs(result1 - target) <= Math.abs(result - target)) {
                        result = result1;
                    }
                }
            }
        }
        return result;
    }
}