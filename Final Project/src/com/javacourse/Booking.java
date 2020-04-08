package com.ig.javacourse.finalProject;

import java.awt.EventQueue;
//import java.util.Calendar; //search this
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class Booking extends JFrame {
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Booking frame = new Booking();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Booking() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 529, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		JTextPane checkin = new JTextPane();
		checkin.setBounds(63, 89, 164, 36);
		contentPane.add(checkin);
		JTextPane checkout = new JTextPane();
		checkout.setBounds(299, 89, 164, 36);
		contentPane.add(checkout);
		JLabel checkinLabel = new JLabel("Check-in");
		checkinLabel.setBounds(63, 61, 61, 16);
		contentPane.add(checkinLabel);
		JLabel checkoutLabel = new JLabel("Check-out");
		checkoutLabel.setBounds(299, 61, 89, 16);
		contentPane.add(checkoutLabel);
		JLabel amountPeopleLabel = new JLabel("N. of People");
		amountPeopleLabel.setBounds(217, 154, 80, 16);
		contentPane.add(amountPeopleLabel);
		JLabel lblNewLabel = new JLabel("Booking");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblNewLabel.setBounds(217, 20, 98, 25);
		contentPane.add(lblNewLabel);
		JSpinner people_amount = new JSpinner();
		people_amount.setBounds(241, 179, 34, 26);
		contentPane.add(people_amount);
		JLabel roomTypeLabel = new JLabel("Type of room");
		roomTypeLabel.setBounds(217, 234, 89, 16);
		contentPane.add(roomTypeLabel);
		JCheckBox LuxuryRoom = new JCheckBox("Luxury");
		LuxuryRoom.setBounds(162, 270, 89, 23);
		contentPane.add(LuxuryRoom);
		JCheckBox StandardRoom = new JCheckBox("Standard");
		StandardRoom.setBounds(274, 270, 98, 23);
		contentPane.add(StandardRoom);
		JButton Search_Result = new JButton("");
		Search_Result.setBounds(63, 384, 401, 36);
//		Search_Result.setBorderPainted(false);
		contentPane.add(Search_Result);
		JButton checkAvailabilityButton = new JButton("Check Availability");
		checkAvailabilityButton.setBounds(179, 321, 164, 41);
		contentPane.add(checkAvailabilityButton);
		checkAvailabilityButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:8889/Hotel",
							"ion_gutu", "HelloWorld1234");
					PreparedStatement ps = conn.prepareStatement(
							"insert into booking(checkin, checkout, days, people_amount) values(?,?,?,?)");

					ps.setString(1, checkin.getText());
					ps.setString(2, checkout.getText());
					ps.setInt(3, 0);
					ps.setInt(4, (int) (people_amount.getValue()));
					int x = ps.executeUpdate();
					if (x > 0) {
						System.out.println("Registration is done successfully.");
						Search_Result.setText("Room available, click to book now!");
					} else {
						System.out.println("Registration failed.");
					}
				} catch (Exception e1) {
					System.out.println(e1);
				}
			}
		});
		Search_Result.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Room_Type frame3 = new Room_Type();
				frame3.setVisible(true);
				dispose();
			}
		});
	}
}