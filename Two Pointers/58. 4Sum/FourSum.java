/**
 * Four Sum
 * Two Pointers
 * Jake Ma
 * 1-8-2018
 */

public class FourSum {
    /**
     * @param numbers: Give an array
     * @param target: An integer
     * @return: Find all unique quadruplets in the array which gives the sum of zero
     */
    public List<List<Integer>> fourSum(int[] numbers, int target) {
        if (numbers.length == 0 || numbers == null) {
            return null;
        }
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(numbers);
        
        for (int i = 0; i < numbers.length - 3; i++) {
            // Remove duplicates
            if (i != 0 && numbers[i - 1] == numbers[i]) {
                continue;
            }
            for (int j = i + 1; j < numbers.length - 2; j++) {
                // Remove duplicates
                if (j != i + 1 && numbers[j - 1] == numbers[j]) {
                    continue;
                }
                int left = j + 1;
                int right = numbers.length - 1;
                
                while (left < right) {
                    int sum = numbers[i] + numbers[j] + numbers[left] + numbers[right];
                    
                    if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else {
                        List<Integer> result = new ArrayList<>();
                        result.add(numbers[i]);
                        result.add(numbers[j]);
                        result.add(numbers[left]);
                        result.add(numbers[right]);
                        results.add(result);
                        left++;
                        right--;
                        // Move left and right pointers to skip duplicates
                        while (left < right && numbers[left] == numbers[left - 1]) {
                            left++;
                        }
                        while (left < right && numbers[right] == numbers[right + 1]) {
                            right--;
                        }
                    }
                }
            }
        }
        
        return results;
    }
}