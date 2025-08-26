use std::cmp::max;

impl Solution {

    pub fn area_of_max_diagonal_my(dimensions: Vec<Vec<i32>>) -> i32 {
        let mut a = 0;
        let mut md = 0.0;
        for row in dimensions {
            let d = ((row[0].pow(2) + row[1].pow(2)) as f32).sqrt();
            a = if md < d {
                md = d;
                row[0] * row[1]
            } else if md == d {
                max(a, row[0] * row[1])
            } else {
                a
            }
        }
        a
    }

    pub fn area_of_max_diagonal(d: Vec<Vec<i32>>) -> i32 {
        d.iter().map(|d|(d[0]*d[0]+d[1]*d[1],d[0]*d[1])).max().unwrap().1
    }
}