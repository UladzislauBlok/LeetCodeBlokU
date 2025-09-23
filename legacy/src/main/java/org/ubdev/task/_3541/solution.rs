impl Solution {
    pub fn max_freq_sum(s: String) -> i32 {
        s.bytes()
            .fold([[0; 26]; 2], |mut l, b| {
                l[b"aeiou".contains(&b) as usize][(b - b'a') as usize] += 1;
                l
            })
            .into_iter()
            .flat_map(|l| l.into_iter().max())
            .sum()
    }
}
