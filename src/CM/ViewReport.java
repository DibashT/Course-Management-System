package CM;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import CM.Result;
import CM.NullException;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewReport {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public ViewReport() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 255));
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Results");
		lblNewLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		
		textField = new JTextField();
		textField.setBounds(134, 74, 106, 22);
		textField.setFont(new Font("Poppins", Font.PLAIN, 10));
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Student ID");
		lblNewLabel_1.setBounds(134, 44, 113, 19);
		lblNewLabel_1.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		
		JButton btnNewButton = new JButton("View");
		Result r = new Result();
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int id = Integer.parseInt(textField.getText());
				new StudentResult(id);
				}catch(NullException |NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Fill the empty box!!", "Error!", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		btnNewButton.setBounds(134, 107, 77, 25);
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		btnNewButton.setBackground(new Color(255, 255, 255));
		
		
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new String[] {"Module Name", "Marks"});
		panel_1.setLayout(null);
		panel_1.add(textField);
		panel_1.add(lblNewLabel_1);
		panel_1.add(btnNewButton);
		frame.setVisible(true);
	}
}