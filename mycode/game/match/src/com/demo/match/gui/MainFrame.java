package com.demo.match.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.Timer;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MainFrame {

	private JFrame frame = new JFrame();
	private JPanel leftPanel = new JPanel();
	private JButton rightPanel = new JButton("lili2");
	private JTextArea redText = new JTextArea();
	private JTextArea blueText = new JTextArea();
	private JScrollPane historyPane = new JScrollPane();

	public MainFrame() {
		
		Container container = frame.getContentPane();
		GridBagLayout layout = new GridBagLayout();
		container.setLayout(layout);
		
		redText.setFont(new Font("Courier", Font.BOLD, 20));
		redText.setForeground(Color.RED);
		redText.setBackground(Color.GRAY);
		redText.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		blueText.setFont(new Font("Courier", Font.BOLD, 20));
		blueText.setForeground(Color.BLUE);
		blueText.setBackground(Color.GRAY);
		blueText.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		JList list = new JList(new String[] {"lili", "lili2", "lili3"});
		list.setFont(new Font("Courier", Font.BOLD, 20));
		list.setForeground(Color.GREEN);
		list.setBackground(Color.DARK_GRAY);
		list.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		historyPane.add(list);
		list.setVisible(true);
		
		redText.setText("Red(ClientID):asdfasdfad");
		blueText.setText("Blue(ClientID):afadfasdf");
		
		leftPanel.setBackground(Color.RED);
		rightPanel.setBackground(Color.BLUE);
		container.add(leftPanel);
		container.add(redText);
		container.add(blueText);
		container.add(historyPane);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridwidth = 1;
		gbc.gridheight = 3;
		gbc.weightx = 1;
		gbc.weighty = 2;
		layout.setConstraints(leftPanel, gbc);
		gbc.weightx = 0;
		gbc.weighty = 0;
		gbc.gridwidth = 0;
		gbc.gridheight = 1;
		layout.setConstraints(redText, gbc);
		layout.setConstraints(redText, gbc);
		gbc.gridwidth = 0;
		layout.setConstraints(blueText, gbc);
		gbc.gridwidth = 0;
		gbc.gridheight = 0;
		layout.setConstraints(historyPane, gbc);

		/*
		rightPanel.setLayout(new GridLayout(3, 1));
		rightPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		rightPanel.add(redText);
		rightPanel.add(blueText);
		rightPanel.add(historyText);


		*/
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension displaySize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize((int)(displaySize.getWidth() * 0.6), (int)(displaySize.getHeight() * 0.6));
	}

	public void show() {
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
