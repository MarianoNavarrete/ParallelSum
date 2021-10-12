package app;

import java.util.Random;

import main.ParallelSum;

public class App {
	public static void main(String[] args) {
		Random random = new Random();
		int numOfThreads = Runtime.getRuntime().availableProcessors();
		ParallelSum parallelSum = new ParallelSum(numOfThreads);

		int[] nums = new int[1000000000];

		for (int i = 0; i < nums.length; i++) {
			nums[i] = random.nextInt(100);
		}
		long initExecution = System.currentTimeMillis();
		System.out.println("Parallel");
		System.out.println("The sum is " + parallelSum.sum(nums));
		System.out.println("End " + (System.currentTimeMillis() - initExecution) + "ms");
		System.out.println("--------------");
		System.out.println("Sequencial");
		long initSequencialExecution = System.currentTimeMillis();
		System.out.println("The sum is " + normalSum(nums));
		System.out.println("End " + (System.currentTimeMillis() - initSequencialExecution) + "ms");

	}

	public static int normalSum(int[] nums) {
		int total = 0;
		for (int i = 0; i < nums.length; i++) {
			total += nums[i];
		}
		return total;
	}
}
