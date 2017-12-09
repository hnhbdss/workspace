package com.dss;

import java.util.Deque;
import java.util.LinkedList;

public class Mazetravel {
	
	public enum Direction {EAST, SOUTH, WEST, NORTH, NONE};
	
	public static class Point {
		private int x;
		private int y;
		private Point parent;
		private int pathWeight;
		private Direction direct;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
			this.parent = null;
			this.pathWeight = 0;
			this.direct = Direction.EAST;
		}
		
		public void setX(int x) {
			this.x = x;
		}
		
		public int getX() {
			return this.x;
		}
		
		public void setY(int y) {
			this.y = y;
		}
		
		public int getY() {
			return this.y;
		}
		
		public void setParent(Point parent) {
			this.parent = parent;
		}
		
		public Point getParent() {
			return this.parent;
		}
		
		public void setPathWeight(int pathWeight) {
			this.pathWeight = pathWeight;
		}
		
		public int getPathWeight() {
			return this.pathWeight;
		}
			
		public void setDirect(Direction direct) {
			this.direct = direct;
		}
		
		public Direction getDirect() {
			return this.direct;
		}
			
		public boolean equals(Point other) {
			return this.x == other.x && this.y == other.y;
		}
	}
	
	public static class DirectionUtils {
		public static Point getNextPoint(Point self, int[][] maze, int mazeSize, int[][] track) {
			
			if (self.getDirect() == Direction.EAST) {
				self.setDirect(Direction.SOUTH);				
				int x = self.getX() + 1;
				int y = self.getY();
				if (checkPointValid(x, y, maze, mazeSize, track)) {
					return new Point(x, y);
				}
			}
			
			if (self.getDirect() == Direction.SOUTH) {
				self.setDirect(Direction.WEST);
				int x = self.getX();
				int y = self.getY() + 1;
				if (checkPointValid(x, y, maze, mazeSize, track)) {
					return new Point(x, y);
				}
			}
			
			if (self.getDirect() == Direction.WEST) {
				self.setDirect(Direction.NORTH);
				int x = self.getX() - 1;
				int y = self.getY();
				if (checkPointValid(x, y, maze, mazeSize, track)) {
					return new Point(x, y);
				}
			}
			
			if (self.getDirect() == Direction.NORTH) {
				self.setDirect(Direction.NONE);
				int x = self.getX();
				int y = self.getY() - 1;
				if (checkPointValid(x, y, maze, mazeSize, track)) {
					return new Point(x, y);
				}
			}
			
			return null;
		}
			
		public static boolean checkPointValid(int x, int y, int[][] maze, int mazeSize, int[][] track) {
			return x < mazeSize && x >= 0 && y < mazeSize 
				&& y >= 0 && maze[x][y] != 1 && track[x][y] != 1;
		}
	}

	public static int travel(int size, int[][] maze) {
		
		if (maze[0][0] == 1 || maze[size - 1][size - 1] == 1) {
			return -1;
		}
		int[][] track = new int[size][size];
		for (int row = 0; row < size; ++row) {
			for (int col = 0; col < size; ++col) {
				track[row][col] = 0;
			}
		}
		Deque<Point> visited = new LinkedList<Point>();
		visited.addLast(new Point(0,0));
		
		Point target = new Point(size - 1, size - 1);
		while(!visited.isEmpty()) {
			Point curStep = visited.pollFirst();
			if (curStep.equals(target)) {
				return curStep.getPathWeight();
			}
			
			while(true) {
				Point nextStep = DirectionUtils.getNextPoint(curStep, maze, size, track);
				if (nextStep != null) {
					track[nextStep.getX()][nextStep.getY()] = 1;
					nextStep.setParent(curStep);
					nextStep.setPathWeight(curStep.getPathWeight() + 1);
					visited.addLast(nextStep);
				}
				else {
					break;
				}
			}
		}
				
		return -1;
	}
}
