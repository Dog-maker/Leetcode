//给定一个 m x n 的非负整数矩阵来表示一片大陆上各个单元格的高度。“太平洋”处于大陆的左边界和上边界，而“大西洋”处于大陆的右边界和下边界。 
//
// 规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。 
//
// 请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。 
//
// 
//
// 提示： 
//
// 
// 输出坐标的顺序不重要 
// m 和 n 都小于150 
// 
//
// 
//
// 示例： 
//
// 
//
// 
//给定下面的 5x5 矩阵:
//
//  太平洋 ~   ~   ~   ~   ~ 
//       ~  1   2   2   3  (5) *
//       ~  3   2   3  (4) (4) *
//       ~  2   4  (5)  3   1  *
//       ~ (6) (7)  1   4   5  *
//       ~ (5)  1   1   2   4  *
//          *   *   *   *   * 大西洋
//
//返回:
//
//[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (上图中带括号的单元).
// 
//
// 
// Related Topics 深度优先搜索 广度优先搜索 
// 👍 242 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    int[][] heights;
    int row,col;
    boolean[][] canToA;
    boolean[][] canToP;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> toAP = new ArrayList<>();
        if(heights == null && heights.length == 0)
            return toAP;
        this.heights = heights;
        row = heights.length;
        col = heights[0].length;
        canToA = new boolean[row][col];
        canToP = new boolean[row][col];
        //判断上下流动（上流向太平洋，下流向大西洋）
        for(int i = 0;i<col;++i){
            flow(0,i,true); //太平洋流向
            flow(row-1, i, false);  //大西洋
        }
        for(int i = 1;i<row;++i){
            flow(i, 0, true);
            flow(row-i-1, col-1, false);
        }

        for(int i = 0;i<row;++i){
            for(int j = 0;j<col;++j){
                if(canToA[i][j] && canToP[i][j])
                    toAP.add(Arrays.asList(i,j));
            }
        }
        return toAP;
    }

    //可以流动(ture流向太平洋 false流向大西洋)
    public void flow(int row,int col,boolean AP){
        if(AP)
            canToA[row][col] = true;
        else
            canToP[row][col] = true;
        //纵向流向
        int[] colFlow = {-1,1,0,0};
        //横向流
        int[] rowFlow = {0,0,-1,1};
        int new_x;
        int new_y;
        for(int i = 0;i<4;++i){
            new_x = row+rowFlow[i];
            new_y = col+colFlow[i];
            if(new_x < 0 || new_x>=this.row || new_y<0 || new_y>=this.col ){
                continue;
            }
            if( heights[row][col] <= heights[new_x][new_y] ){
                if(AP && !canToA[new_x][new_y]){
                    flow(new_x, new_y, AP);
                }
                if(!AP && !canToP[new_x][new_y])
                    flow(new_x, new_y, AP);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
