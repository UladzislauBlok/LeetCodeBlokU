impl Solution {
    pub fn does_alice_win_my(s: String) -> bool {
        let res: String = s.chars().filter(|&x| "aeiou".contains(x)).collect();
        if res.len() > 0 {
            true
        } else {
            false
        }
    }

    pub fn does_alice_win(s: String) -> bool {
        let res: String = s.chars().filter(|&x| "aeiou".contains(x)).collect();
        if res.len() > 0 {
            true
        } else {
            false
        }
    }
}
