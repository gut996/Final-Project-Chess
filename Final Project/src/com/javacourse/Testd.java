package com.javacourse;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class Testd {

	JButton btn;
	// Date datee;

	private JLabel input;
	private JLabel output;

	public static void main(String[] args) {
		new Testd();
	}

	public Testd() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException ex) {
					ex.printStackTrace();
				}

				JFrame frame = new JFrame("Testing");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				try {
					frame.add(new TestPane());
					frame.pack();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					frame.setLayout(null);
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		});
	}

	public class TestPane extends JPanel {

		private Connection con;

		public TestPane() throws SQLException {
			make();

			setLayout(new GridBagLayout());
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridx = 0;
			gbc.gridy = 0;

			btn = new JButton("Add");

			UtilDateModel model = new UtilDateModel();
			Properties p = new Properties();
			p.put("text.today", "Today");
			p.put("text.month", "Month");
			p.put("text.year", "Year");
			JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
			JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());

			JPanel top = new JPanel();

			top.add(datePicker);
			top.add(btn);

			add(top, gbc);

			input = new JLabel("---");
			output = new JLabel("---");

			JPanel bottom = new JPanel();
			bottom.add(input);
			bottom.add(output);

			gbc.gridx = 0;
			gbc.gridy = 1;
			add(bottom, gbc);

			btn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					try {
						// String text = datee;
						// DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
						// Date myDate = formatter.parse(text);
						java.util.Date datee = (java.util.Date) datePicker.getModel().getValue();
						if (datee != null) {
							java.sql.Date sqlDate = new java.sql.Date(datee.getTime());

							String sql = "INSERT INTO Invoice" + "(Issuedate)" + "VALUES (?)";

							input.setText(sqlDate.toString());

							try (PreparedStatement stmt = con.prepareStatement(sql)) {
								stmt.setDate(1, sqlDate);
								int rowCount = stmt.executeUpdate();
								System.out.println(rowCount);
								con.commit();
							}

							select();

						} else {
							JOptionPane.showMessageDialog(TestPane.this, "You need to select a date");
						}
					} catch (SQLException | HeadlessException ex) {
						ex.printStackTrace();
						JOptionPane.showMessageDialog(TestPane.this, ex);

					}
				}
			});
		}

		protected void select() throws SQLException {
			try (PreparedStatement stmt = con.prepareStatement("select * from Invoice")) {
				try (ResultSet rs = stmt.executeQuery()) {
					while (rs.next()) {
						java.sql.Date date = rs.getDate(1);
						output.setText(date.toString());
					}
				}
			}
		}

		protected void make() throws SQLException {
			con = DriverManager.getConnection("jdbc:h2:mem:");
			try (Statement stmt = con.createStatement()) {
				boolean result = stmt.execute("create table Invoice( Issuedate date not null )");
				System.out.println(result);
				con.commit();
				select();
			}
		}
	}

	public class DateLabelFormatter extends AbstractFormatter {

		private String datePattern = "yyyy-MM-dd";
		private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

		@Override
		public Object stringToValue(String text) throws ParseException {
			return dateFormatter.parseObject(text);
		}

		@Override
		public String valueToString(Object value) throws ParseException {
			if (value != null) {
				Calendar cal = (Calendar) value;
				return dateFormatter.format(cal.getTime());
			}

			return "";
		}

	}
}