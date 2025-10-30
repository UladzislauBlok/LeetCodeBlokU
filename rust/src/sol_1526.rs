struct Solution {}

impl Solution {
    pub fn min_number_operations(target: Vec<i32>) -> i32 {
        let (mut res, mut prev) = (0, 0);
        for i in 0..target.len() {
            if target[i] > prev {
                res += target[i] - prev;
            }
            prev = target[i];
        }
        res
    }

    pub fn min_number_operations_window(t: Vec<i32>) -> i32 {
        t[0] + t.windows(2).map(|w| 0.max(w[1] - w[0])).sum::<i32>()
    }
}
