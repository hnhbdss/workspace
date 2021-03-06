package com.demo.match;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MyFrame extends JFrame{
	
	private static final long serialVersionUID = 799982163761004073L;
	private Timer timer = new Timer();
	

	public static class MyPanel extends JPanel {

		private static final long serialVersionUID = 5317260038182520749L;

		private static int i = 0;
		public void paintComponent(Graphics g) {
			g.clearRect(0, 0, this.getWidth(), this.getHeight());
			g.drawString("hello" + String.valueOf(i), 30, 30);
			i++;
		}
	}
	private MyPanel panel = new MyPanel();
	private JButton button = new JButton();
	public MyFrame() {
		this.getContentPane().setLayout(new GridLayout(1,2));
		this.getContentPane().add(panel);
		this.getContentPane().add(button);
		
		panel.setBackground(Color.BLUE);
		button.setText("hello");
		
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				panel.repaint();
			}
			
		});
		
	}
	
	public static void main(String[] args) {
		
		MyFrame frame = new MyFrame();
		frame.start();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,300);
		frame.setVisible(true);
	}

	public void start() {
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				SwingUtilities.invokeLater(new Runnable() {

					@Override
					public void run() {
						MyFrame.this.repaint();
					}
					
				});
			}
			
		}, 1000, 2000);
	}

}
