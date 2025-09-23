impl Solution {
    pub fn max_frequency_elements_my(nums: Vec<i32>) -> i32 {
        let vec: Vec<i32> = nums.iter()
            .fold(vec![0; 101], |mut map, n| {map[*n as usize] += 1; map});
        let max = vec.iter()
            .max()
            .unwrap();
        max * vec.iter().filter(|x| *x == max).count() as i32
    }

    pub fn max_frequency_elements(mut n: Vec<i32>) -> i32 {
        n.sort_unstable(); n.chunk_by(|a, b| a == b)
        .fold((0, 0, 0), |r, c| if c.len() > r.0 { (c.len(), 1, c.len())} 
            else if c.len() == r.0 { (r.0, r.1 + 1, r.0 * (r.1+1))} else { r }).2 as _
    }
}
