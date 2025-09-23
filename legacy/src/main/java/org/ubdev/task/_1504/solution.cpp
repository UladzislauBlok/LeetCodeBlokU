class Solution {
public:
    int numSubmat(vector<vector<int>>& mat) {
        int n=mat.size(),m=mat[0].size();
        vector<int>histogram(m,0);
        int totalCount=0;
        for(int i=0;i<n;i++) {
            stack<array<int,3>>st;
            st.push({-1,-1,0});
            for(int j=0;j<m;j++) {
                  histogram[j]=(mat[i][j]==0)?0:histogram[j]+mat[i][j];
                  while(st.top()[0]>=histogram[j]) st.pop();
                  auto[height,index,prev]=st.top();
                  int gap=(j-index);
                  int count=gap*histogram[j];
                  count+=prev;
                  totalCount+=count;
                  st.push({histogram[j],j,count});
            }
        }
        return totalCount;
    }
};