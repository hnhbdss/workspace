package com.demo.match.gui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.demo.match.common.Chess;
import com.demo.match.common.ChessColor;

public class BoardPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private static final int BOARD_SIZE = 5;
 
	private Chess[][] board = null;
	public BoardPanel() {
		this.setLayout(new GridLayout(BOARD_SIZE,BOARD_SIZE));
	}
	
	public synchronized void updateData(Chess[][] board) {
		this.board = board;
	}
	
	public synchronized void refresh() {
		this.removeAll();
		this.setLayout(new GridLayout(BOARD_SIZE, BOARD_SIZE));
		for (int row = 0; row < BOARD_SIZE; row++) {
			for (int col = 0; col < BOARD_SIZE; col++) {
				 JPanel chess = new JPanel();
				 chess.setBackground(board[row][col].getColor() == ChessColor.Red ? Color.RED : Color.BLUE);
				 JLabel label = new JLabel(String.valueOf(board[row][col].getValue()));
				 chess.add(label);
				 this.add(chess);
			}
		}
	}
}
