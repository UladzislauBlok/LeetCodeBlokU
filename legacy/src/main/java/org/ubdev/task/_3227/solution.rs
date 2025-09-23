impl Solution {
    pub fn does_alice_win_my(s: String) -> bool {
        let res: String = s.chars().filter(|&x| "aeiou".contains(x)).collect();
        if res.len() > 0 {
            true
        } else {
            false
        }
    }

    pub fn does_alice_win_1(s: String) -> bool {
        s.chars().any(|c| matches!(c, 'a' | 'e' | 'i' | 'o' | 'u'))
    }

    pub fn does_alice_win(s: String) -> bool {
        for c in s.bytes() {
            if (0x104111 >> (c - b'a')) & 1 != 0 {
                return true;
            }
        }
        false
    }
}
