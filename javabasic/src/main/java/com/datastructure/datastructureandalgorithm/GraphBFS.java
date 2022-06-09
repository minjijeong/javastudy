package com.datastructure.datastructureandalgorithm;

import java.util.LinkedList;
import java.util.Queue;
import sun.awt.image.ImageWatched.Link;

public class GraphBFS {
    private final int maxVertices = 20;
    private Vertex vertexList[];
    private int adjMatrix[][];
    private int vertexCount;
    private Queue<Integer> theQueue;
    public GraphBFS() {
        vertexList = new Vertex[maxVertices];
        adjMatrix = new int[maxVertices][maxVertices];
        vertexCount = 0;
        for (int y = 0; y < maxVertices; y++) {
            for (int x = 0; x < maxVertices; x++)
                adjMatrix[x][y] = 0;
        }
        theQueue = new LinkedList<>();
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
        theQueue.offer(0);
        int v2;
        while(!theQueue.isEmpty()){
            // 방문하지 않은 인접한 접점을 얻어와 스택 상단에 쌓는다.
            int v1= theQueue.poll();
            while((v2=getAdjUnvisitedVertex(v1)) != -1){
                vertexList[v2].visited = true;
                displayVertex(v2);
                theQueue.offer(v2);
            }
        }
        for(int j=0; j < vertexList.length; j++){
            vertexList[j].visited = false;
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
