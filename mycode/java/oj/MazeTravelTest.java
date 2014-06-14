package com.dss;

public class MazeTravelTest {
    public static void main(String[] args) {
        int size = 1000;
        int[][] maze1 = new int[size][size];
        init(maze1, size);
        System.out.println(Mazetravel.travel(size, maze1));
    }
    
    public static void init(int[][] maze, int size) {
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                maze[i][j] = 0;
            }
        }
    }
}
