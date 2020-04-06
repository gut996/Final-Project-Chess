package com.javacourse;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

//	copy from registration file to understand the coding:
//
//
//

public class HotelSample extends JFrame {
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HotelSample frame = new HotelSample();
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
	public HotelSample() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 321, 437);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JTextPane user = new JTextPane();
		user.setBounds(63, 75, 164, 36);
		contentPane.add(user);

		JTextPane email = new JTextPane();
		email.setBounds(63, 157, 164, 36);
		contentPane.add(email);

		JTextPane password = new JTextPane();
		password.setBounds(63, 236, 164, 36);
		contentPane.add(password);

		JLabel userLabel = new JLabel("User");
		userLabel.setBounds(63, 47, 61, 16);
		contentPane.add(userLabel);

		JLabel emailLabel = new JLabel("Email");
		emailLabel.setBounds(63, 129, 61, 16);
		contentPane.add(emailLabel);

		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(63, 208, 61, 16);
		contentPane.add(passwordLabel);

		JButton RegistrationButton = new JButton("Registration");

		RegistrationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = (Connection) DriverManager.getConnection(
							"jdbc:mysql://localhost:8889/Bakery?serverTimezone=UTC", "root", "xyz@#Amora#2016");
					PreparedStatement ps = conn
							.prepareStatement("insert into users(user_name, user_email, user_password) values(?,?,?)");
					ps.setString(1, user.getText());
					ps.setString(2, email.getText());
					ps.setString(3, password.getText());
					int x = ps.executeUpdate();
					if (x > 0) {
						System.out.println("Registration is done successfully.");
					} else {
						System.out.println("Registration failed.");
					}
				} catch (Exception e1) {
					System.out.println(e1);
				}
			}
		});

		RegistrationButton.setBounds(63, 301, 117, 29);
		contentPane.add(RegistrationButton);

	}
}
