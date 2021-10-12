package main;

import workers.ParallelWorker;

/**
 * The Class ParallelSum.
 * This class will obtain the total sum of the partial parallel sums
 * @author Mariano Navarrete
 */
public class ParallelSum {
	
	/** The parallel sums, this will be the total of the cpu core */
	private ParallelWorker[] sums;
	
	/** The num of threads. */
	private int numOfThreads;

	/**
	 * Instantiates a new parallel sum.
	 *
	 * @param numOfThreads the num of threads
	 */
	public ParallelSum(int numOfThreads) {
		this.numOfThreads = numOfThreads;
		this.sums = new ParallelWorker[numOfThreads];
	}

	/**
	 * This method will add in a parallel way an indicated array
	 *
	 * @param nums the nums to be added
	 * @return the total of the sum
	 */
	public int sum(int[] nums) {
		int steps = (int) Math.ceil(nums.length * 1.0 / numOfThreads);
		for (int i = 0; i < numOfThreads; i++) {
			sums[i] = new ParallelWorker(nums, i * steps, (i + 1) * steps);
			sums[i].start();
		}
		try {
			for (ParallelWorker worker : sums) {
				worker.join();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int total = 0;

		for (ParallelWorker worker : sums) {
			total += worker.getPartilSum();
		}
		return total;
	}
}
