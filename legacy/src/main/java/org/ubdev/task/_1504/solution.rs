pub fn num_submat(mat: Vec<Vec<i32>>) -> i32 {
    let m = mat.len();
    let n = mat.first().map_or(0, |row| row.len());

    let mut heights = vec![0; n];
    let mut stack   = Vec::with_capacity(n);
    let mut n_subs  = 0;

    for row in mat {
        for (&val, h) in row.iter().zip(&mut heights) {
            *h = (*h + 1) * val;
        }

        stack.push((-1, 0, -1));

        for (i, &h) in (0..).zip(&heights) {
            while stack.last().map_or(false, |x| x.2 >= h) {
                stack.pop();
            }
            let (j, prev, _) = stack.last().unwrap();
            let cur = prev + (i - j) * h;

            stack.push((i, cur, h));
            n_subs += cur;
        }
        stack.clear();
    }

    n_subs
}