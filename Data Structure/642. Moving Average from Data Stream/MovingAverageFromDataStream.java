/**
 * Jake Ma
 * Moving Average From Data Stream
 * Data Structure
 * 4/3/2019
 */

public class MovingAverage {
    /*
    * @param size: An integer
    */
    private Queue<Integer> queue;
    private double sum = 0;
    private int size;
    
    public MovingAverage(int size) {
        queue = new LinkedList<Integer>();
        this.size = size;
    }

    /*
     * @param val: An integer
     * @return:  
     */
    public double next(int val) {
        sum += val;
        
        if (queue.size() == size) {
            sum = sum - queue.poll();
        }
        
        queue.offer(val);
        return sum / queue.size();
    }
}