impl Solution {
    pub fn can_be_typed_words_my(text: String, broken_letters: String) -> i32 {
        text.split(' ')
            .filter(|&w| broken_letters.chars().filter(|&c| w.contains(c)).count() == 0)
            .count() as i32
    }

    pub fn can_be_typed_words(text: String, broken_letters: String) -> i32 {
        let broken_hash = broken_letters
            .into_bytes()
            .iter()
            .fold([false; 26], |mut acc, &b| {
                acc[(b - b'a') as usize] = true;
                acc
            });

        text.split_ascii_whitespace()
            .filter(|&s| {
                s.as_bytes()
                    .iter()
                    .all(|&b| !broken_hash[(b - b'a') as usize])
            })
            .count() as _
    }
}
