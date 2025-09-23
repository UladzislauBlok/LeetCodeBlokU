use std::cmp::max;

impl Solution {
    pub fn longest_subarray(nums: Vec<i32>) -> i32 {
        let n = nums.len();
        let mut left: usize = 0;
        let mut zero_count = 0;
        let mut max_len: i32 = 0;

        for right in 0..n {
            if nums[right] == 0 {
                zero_count += 1;
            }
            while zero_count > 1 {
                if nums[left] == 0 {
                    zero_count -= 1;
                }
                left += 1;
            }
            max_len = max(max_len, (right - left) as i32);
        }

        max_len
    }
}