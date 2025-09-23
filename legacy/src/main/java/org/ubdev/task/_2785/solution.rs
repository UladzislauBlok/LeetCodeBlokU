use itertools::Itertools;
use std::collections::HashSet;

impl Solution {
    pub fn sort_vowels_my(s: String) -> String {
        let n = s.len();
        let mut chars = s.into_bytes();
        let mut sorted = chars.clone();
        sorted.sort();
        let vowels: HashSet<u8> = HashSet::from([65, 69, 73, 79, 85, 97, 101, 105, 111, 117]);
        let mut j = 0;
        // println!("{chars:?} : {sorted:?}");
        for i in 0..n {
            if (!vowels.contains(&chars[i])) {
                continue;
            }
            if (i == n) {
                break;
            }
            while j < n && !vowels.contains(&sorted[j]) {
                j += 1;
            }
            chars[i] = sorted[j];
            j += 1;
        }
        String::from_utf8(chars).unwrap()
    }

    pub fn sort_vowels(s: String) -> String {
        let mut sorted_vowels = s
            .chars()
            .filter_map(|c| {
                if "AEIOUaeiou".contains(c) {
                    Some(c)
                } else {
                    None
                }
            })
            .sorted_by_key(|&c| c as usize);
        s.chars()
            .map(|x| {
                if "AEIOUaeiou".contains(x) {
                    sorted_vowels.next().unwrap()
                } else {
                    x
                }
            })
            .collect()
    }
}
