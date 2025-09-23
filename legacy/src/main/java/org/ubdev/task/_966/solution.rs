use std::collections::{HashMap, HashSet};

fn devowel(s: &str) -> String {
    s.chars()
        .map(|c| match c {
            'a' | 'e' | 'i' | 'o' | 'u' => '*',
            _ => c,
        })
        .collect()
}

impl Solution {
    pub fn spellchecker(wordlist: Vec<String>, queries: Vec<String>) -> Vec<String> {
        let mut exact: HashSet<String> = HashSet::new();
        let mut cap_map: HashMap<String, String> = HashMap::new();
        let mut vowel_map: HashMap<String, String> = HashMap::new();

        for w in &wordlist {
            exact.insert(w.clone());
            let lower = w.to_lowercase();
            cap_map.entry(lower.clone()).or_insert_with(|| w.clone());
            let dev = devowel(&lower);
            vowel_map.entry(dev).or_insert_with(|| w.clone());
        }

        queries
            .into_iter()
            .map(|q| {
                if exact.contains(&q) {
                    q
                } else {
                    let lower = q.to_lowercase();
                    if let Some(w) = cap_map.get(&lower) {
                        w.clone()
                    } else if let Some(w) = vowel_map.get(&devowel(&lower)) {
                        w.clone()
                    } else {
                        String::new()
                    }
                }
            })
            .collect()
    }

    pub fn spellchecker_my(wordlist: Vec<String>, queries: Vec<String>) -> Vec<String> {
        fn make_pattern(s: &String) -> String {
            s.to_lowercase().chars()
                .map(|c| if "aeiou".contains(c) { '_' } else { c })
                .collect()
        }
        let n = queries.len();
        let mut res: Vec<String> = Vec::with_capacity(n);
        let mut wordSet: HashSet<String> = HashSet::with_capacity(n);
        let mut caseMap: HashMap<String, String> = HashMap::with_capacity(n);
        let mut patternMap: HashMap<String, String> = HashMap::with_capacity(n);
        for word in wordlist {
            wordSet.insert(word.clone());
            let lowercase = word.to_lowercase();
            caseMap.entry(lowercase).or_insert(word.clone());
            let pattern = make_pattern(&word);
            patternMap.entry(pattern).or_insert(word.clone());
        }
        for query in queries {
            let lowercase = query.to_lowercase();
            let pattern = make_pattern(&query);
            let default = String::from("");
            if wordSet.contains(&query) {
                res.push(query);
            } else if caseMap.contains_key(&lowercase) {
                let case = caseMap.get(&lowercase).unwrap_or(&default);
                res.push(case.to_string());
            } else {
                let pat = patternMap.get(&pattern).unwrap_or(&default);
                res.push(pat.to_string());
            }
        }
        res
    }
}
