package com.programmers;

public class IntegerTriangle_2 {
    public static int solution(int[][] triangle) {
        int answer = 0;

        for(int i=0; i < triangle.length; i++){
            for(int j=0; j < triangle[0].length;j++){
                // 왼쪽변
                if(j==0){
                    triangle[i][j] = triangle[i][j] + triangle[i-1][j];
                } // 오른쪽변
                else if (i == j) {
                    triangle[i][j] = triangle[i][j] + triangle[i-1][j-1];
                }else{
                    int left = triangle[i][j] + triangle[i-1][j-1];
                    int right = triangle[i][j] + triangle[i-1][j];
                    triangle[i][j] = Math.max(left, right);
                }
                answer = Math.max(answer, triangle[i][j]);
            }
        }
        return answer;
    }

    /**
     * 삼각형 아래부분 부터 탐색 시작
     */
    public static int solution_2(int[][] triangle) {
        int answer = 0; // max

        for(int i=0; i < triangle.length; i++){
            for(int j=0; j < triangle[0].length;j++){
                int left = triangle[i][j] = triangle[i][j] + triangle[i+1][j];
                int right = triangle[i][j] = triangle[i][j] + triangle[i+1][j+1];
                triangle[i][j] = Math.max(left, right);
            }
        }
        return triangle[0][0];
    }
    public static void main(String[] args) {
//        int[][] triangle  ={{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6}};
        int[][] triangle  ={{9},{2,7},{7,3,2}};
        System.out.println(solution(triangle));
    }
}
