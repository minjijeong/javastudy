package com.programmers;

public class IntegerTriangle {
    public static int solution(int[][] triangle) {
        int answer = 0;
        int[][] table = new int[triangle.length][triangle.length];
        for(int i=0;i<triangle.length;i++){
            if(i==0){
                table[i][0] = triangle[i][0];
            }else{
                table[i][0] = triangle[i][0] + table[i-1][0];
                System.out.printf("i : %d, j : %d, data:%d \n", i, 0, table[i][0]);

                if(i == triangle.length -1){
                    answer = table[i][0];
                }

                for(int j=1;j< triangle[i].length; j++){
                    if(j > triangle[i-1].length - 1){
                        table[i][j] = triangle[i][j] + table[i-1][j-1];
                    }
                    else {
                        table[i][j] = Math.max(triangle[i][j] + table[i-1][j], triangle[i][j] + table[i-1][j-1]);
                    }
                    answer = Math.max(answer,table[i][j]);
                    System.out.printf("i : %d, j : %d, data:%d \n", i, j, table[i][j]);
                }

            }
        }

        int lastLevel = table.length-1;

        for(int i=0; i<table[lastLevel].length;i++){
            System.out.printf("[%d] : %d \n",i,table[lastLevel][i]);
            answer = Math.max(answer,table[lastLevel][i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] triangle  ={{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}};
//        int[][] triangle  ={{9},{2,7},{7,3,2},{0,0,0,4}};
        System.out.println(solution(triangle));
    }
}
