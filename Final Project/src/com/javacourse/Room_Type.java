package com.ig.javacourse.finalProject;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class Room_Type extends JFrame {
	private JPanel frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Room_Type frame3 = new Room_Type();
					frame3.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Room_Type() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JPanel();
		setBounds(100, 100, 449, 604);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		JLabel HotelNameLabel = new JLabel("Vancouver Hotel");
		HotelNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		HotelNameLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		HotelNameLabel.setBounds(40, 22, 350, 37);
		getContentPane().add(HotelNameLabel);
		JPanel panel = new JPanel();
		panel.setBounds(40, 98, 350, 92);
		getContentPane().add(panel);
		panel.setLayout(null);
		JLabel Room1Label = new JLabel("Couple Room");
		Room1Label.setBounds(6, 6, 117, 16);
		panel.add(Room1Label);
		JRadioButton couple_room_double_bed_label = new JRadioButton("Double bed");
		couple_room_double_bed_label.setBounds(6, 29, 141, 23);
		panel.add(couple_room_double_bed_label);
		JRadioButton couple_room_twin_bed_label = new JRadioButton("Twin bed");
		couple_room_twin_bed_label.setBounds(6, 64, 141, 23);
		panel.add(couple_room_twin_bed_label);
		JLabel priceLabel = new JLabel("Price per day: $40,00");
		priceLabel.setBounds(175, 19, 141, 23);
		panel.add(priceLabel);
		JButton CoupleBookBtn = new JButton("Book now");
		CoupleBookBtn.setBounds(199, 54, 117, 29);
		panel.add(CoupleBookBtn);
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(40, 220, 350, 92);
		getContentPane().add(panel_1);
		JLabel Room2Label = new JLabel("Family Room");
		Room2Label.setBounds(6, 6, 117, 16);
		panel_1.add(Room2Label);
		JRadioButton family_room_double_bed_label = new JRadioButton("2 Double bed");
		family_room_double_bed_label.setBounds(6, 29, 141, 23);
		panel_1.add(family_room_double_bed_label);
		JRadioButton family_room_twin_bed_label = new JRadioButton("1 Couple + 2 Twin bed");
		family_room_twin_bed_label.setBounds(6, 64, 198, 23);
		panel_1.add(family_room_twin_bed_label);
		JLabel lblPricePerDay = new JLabel("Price per day: $60,00");
		lblPricePerDay.setBounds(175, 19, 141, 23);
		panel_1.add(lblPricePerDay);
		JButton FamilyBookBtn = new JButton("Book now");
		FamilyBookBtn.setBounds(202, 54, 117, 29);
		panel_1.add(FamilyBookBtn);
		JButton newSearch = new JButton("Search again");
		newSearch.setBounds(148, 502, 117, 29);
		getContentPane().add(newSearch);
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(40, 340, 350, 92);
		getContentPane().add(panel_1_1);
		JLabel Room3Label = new JLabel("Single Room");
		Room3Label.setBounds(6, 6, 117, 16);
		panel_1_1.add(Room3Label);
		JRadioButton single_room_double_bed_label_1 = new JRadioButton(" Double bed");
		single_room_double_bed_label_1.setBounds(6, 29, 141, 23);
		panel_1_1.add(single_room_double_bed_label_1);
		JRadioButton single_room_single_bed_label = new JRadioButton(" Single bed");
		single_room_single_bed_label.setBounds(6, 64, 198, 23);
		panel_1_1.add(single_room_single_bed_label);
		JLabel lblPricePerDay_2 = new JLabel("Price per day: $35,00");
		lblPricePerDay_2.setBounds(175, 19, 141, 23);
		panel_1_1.add(lblPricePerDay_2);
		JButton SingleBookBtn = new JButton("Book now");
		SingleBookBtn.setBounds(202, 54, 117, 29);
		panel_1_1.add(SingleBookBtn);
		FamilyBookBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registration9 frame2 = new Registration9();
				frame2.setVisible(true);
				dispose();
			}
		});
		CoupleBookBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registration9 frame2 = new Registration9();
				frame2.setVisible(true);
				dispose();
			}
		});
		SingleBookBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registration9 frame2 = new Registration9();
				frame2.setVisible(true);
				dispose();
			}
		});
	}

}