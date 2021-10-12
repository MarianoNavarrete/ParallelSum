package workers;

/**
 * The Class ParallelWorker.
 * This class will operate the partial sum
 * @author Mariano Navarrete
 */
public class ParallelWorker extends Thread{
	
	/** The nums that will be added */
	private int[] nums;
	
	/** Start index of the array */
	private int low;
	
	/** max index of the array */
	private int high;
	
	/** The total value of the thread, this is the partial sum of the entire array*/
	private int partialSum;
	
	/**
	 * Instantiates a new parallel worker.
	 *
	 * @param nums the nums
	 * @param low the low
	 * @param high the high
	 */
	public ParallelWorker(int[]nums, int low, int high) {
		this.nums = nums;
		this.low = low;
		this.high = high;
	}
	
	/**
	 * Gets the partil sum.
	 *
	 * @return the partil sum
	 */
	public int getPartilSum() {
		return partialSum;
	}
	
	/**
	 * Add the given values
	 */
	@Override
	public void run() {
		partialSum = 0;
		for(int i=low;i<high;i++) {
			partialSum+=nums[i];
		}
	}
}
