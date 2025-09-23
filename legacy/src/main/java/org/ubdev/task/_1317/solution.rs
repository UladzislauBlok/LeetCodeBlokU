impl Solution {
    pub fn get_no_zero_integers(n: i32) -> Vec<i32> {
        fn has_zero(mut n: i32) -> bool {
            while n > 0 {
                if n % 10 == 0 {
                    return true;
                }
                n /= 10;
            }
            false
        }
        let mut a = 1;
        loop {
            let b = n - a;
            if !has_zero(a) && !has_zero(b) {
                break;
            }
            a += 1;
        }
        vec![a, n - a]
    }
}
