package com.datastructure.datastructureandalgorithm;
import java.util.Stack;

public class GraphDFS {
    private final int maxVertices = 20;
    private Vertex vertexList[];
    private int adjMatrix[][];
    private  int vertexCount;
    private Stack<Integer> theStack;
    public GraphDFS(){
        vertexList = new Vertex[maxVertices];
        adjMatrix = new int [maxVertices][maxVertices];
        vertexCount = 0;
        for(int y=0; y < maxVertices; y++){
            for(int x=0; x<maxVertices; x++){
                adjMatrix[x][y] = 0;
            }
        }
        theStack = new Stack<>();
    }
    public void addVertex(char lab){
        vertexList[vertexCount++] = new Vertex(lab);
    }
    public void addEdge(int start, int end){
        adjMatrix[start][end] = 1;
        adjMatrix[end][start] = 1;
    }
    public void displayVertex(int v){
        System.out.println(vertexList[v].label);
    }
    public void dfs(){
        vertexList[0].visited = true;
        displayVertex(0);
        theStack.push(0);
        while(!theStack.isEmpty()){
            // 방문하지 않은 인접한 접점을 얻어와 스택 상단에 쌓는다.
            int v= getAdjUnvisitedVertex(theStack.peek());
            if(v == -1){
                theStack.pop();
            }else{
                vertexList[v].visited = true;
                displayVertex(v);
                theStack.push(v);
            }
        }
    }

    private int getAdjUnvisitedVertex(int v) {
        for(int j=0; j <vertexCount; j++){
            if(adjMatrix[v][j] == 1 && vertexList[j].visited == false){
                return j;
            }
        }
        return -1;
    }

}
