impl Solution {
    pub fn sum_zero_my(n: i32) -> Vec<i32> {
        let mut res: Vec<i32> = Vec::new();
        for i in 1..(n / 2 + 1) {
            res.push(i);
            res.push(i * -1);
        }
        if (n & 1) == 1 {
            res.push(0);
        }
        return res;
    }

    pub fn sum_zero(n: i32) -> Vec<i32> {
        (1..=n / 2)
            .flat_map(|i| [i, -i])
            .chain((n % 2 == 1).then_some(0))
            .collect()
    }
}
