impl Solution {
    pub fn find_diagonal_order(mat: Vec<Vec<i32>>) -> Vec<i32> {
        let m = mat.len();
        let n = mat[0].len();
        let mut res = Vec::with_capacity(m*n);
        if m == 1 {
            for i in 0..n {
                res.push(mat[0][i]);
            }
            return res;
        }
        if n == 1 {
            for i in 0..m {
                res.push(mat[i][0]);
            }
            return res;
        }
        let mut idx = 0;
        let mut a = 0;
        let mut b = 0;
        let mut op: [i32; 2] = [1,-1];
        while a < m && b < n {
            op[0] *= -1;
            op[1] *= -1;
            let endA = if op[0] == 1 { m-1 } else { 0 };
            let endB = if op[0] == 1 { 0 } else { n-1 };
            while a != endA && b != endB {
                res.push(mat[a][b]);
                a+=op[0] as usize;
                b+=op[1] as usize;
                idx += 1;
            }
            res.push(mat[a][b]);
            idx += 1;
            if a == endA && b == endB && endB == n-1 {
                a += 1;
            } else if a == endA && b == endB && endB == 0 {
                b += 1;
            } else if a == endA {
                b += 1;
            }  else if b == endB {
                a += 1;
            }
        }
        res
    }

    pub fn find_diagonal_order_example(mat: Vec<Vec<i32>>) -> Vec<i32> {
        let (m, n, mut r, mut c, mut d) = (mat.len() as i32, mat[0].len() as i32, 0, 0, 1);
        let mut ans = Vec::new();

        for _ in 0..(m*n){
            ans.push(mat[r as usize][c as usize]);
            r -= d; c += d;
            if r<0 || r==m || c<0 || c==n {
                if r==m { r=m-1; c -= d-1; }
                if c==n { c=n-1; r += d+1; }
                if r<0 { r=0; }
                if c<0 { c=0; }
                d = -d;
            }
        }
        return ans;
    }
}