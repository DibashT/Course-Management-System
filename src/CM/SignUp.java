package CM;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import CM.Validation;
import CM.Courses;
import CM.InvalidFormat;
import CM.NullException;
import CM.Instructor;
import CM.Student;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;

public class SignUp {

	private JFrame frame;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblNewLabel;
	private JTextField username;
	private JTextField email;
	private JPasswordField password;
	private JTextField phone;
	private JComboBox rolesSelect;
	private JComboBox course;
	private JButton btnCreate;
	private JButton btnNewButton;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;

	/**
	 * Create the application.
	 */
	public SignUp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 825, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		panel = new JPanel();
		panel.setBackground(new Color(128, 128, 255));
		frame.getContentPane().add(panel, BorderLayout.NORTH);

		lblNewLabel = new JLabel("Sign UP");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 35));
		panel.add(lblNewLabel);

		panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);

		username = new JTextField();
		username.setToolTipText("");
		username.setColumns(10);
		username.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		email = new JTextField();
		email.setToolTipText("");
		email.setColumns(10);
		email.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		password = new JPasswordField();
		password.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		phone = new JTextField();
		phone.setToolTipText("");
		phone.setColumns(10);
		phone.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		rolesSelect = new JComboBox(new Object[] { "Student", "Instructor" });
		rolesSelect.setForeground(Color.BLACK);
		rolesSelect.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
		rolesSelect.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		rolesSelect.setBackground(new Color(248, 248, 248));

		ArrayList<Courses> cor = new ArrayList<Courses>();
		Courses c = new Courses();
		cor = c.getCourse();
		// cor.toArray();

		course = new JComboBox(new Object[] {});
		for (int i = 0; i < cor.size(); i++) {
			course.addItem(cor.get(i).course_name);
		}
		course.setForeground(Color.BLACK);
		course.setFont(new Font("Poppins", Font.PLAIN, 14));
		course.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		course.setBackground(new Color(248, 248, 248));

		Student s = new Student();
		btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Instructor i = new Instructor();
				String uname = username.getText();
				String p = new String(password.getPassword());
				String em = email.getText();
				String ph = phone.getText();
				Validation v = new Validation();
				int courseId = c.getCourseId(course.getSelectedItem().toString());
				try {
					if (v.emailCheck(em) && v.phoneCheck(ph) && v.passCheck(p)){
						if(rolesSelect.getSelectedItem().equals("Student")) {
						s.studentRegister(uname,courseId, em, p, ph, 1);
						}else {
							i.addInstructor(uname, em, ph, p);
						}
					}
					
				} catch (NullException ex) {
					JOptionPane.showMessageDialog(null, "Please fill all the fields");
				} catch (InvalidFormat ex1) {
					JOptionPane.showMessageDialog(null, "Invalid Email or Phone Number or Password Format");
				}

			}
		});
		btnCreate.setForeground(new Color(248, 248, 248));
		btnCreate.setFont(new Font("Poppins", Font.PLAIN, 16));
		btnCreate.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnCreate.setBackground(new Color(64, 128, 128));

		btnNewButton = new JButton("Log In");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new Login();
			}
		});
		btnNewButton.setForeground(new Color(248, 248, 248));
		btnNewButton.setFont(new Font("Poppins", Font.PLAIN, 16));
		btnNewButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnNewButton.setBackground(new Color(64, 128, 128));

		JLabel lblNewLabel_1 = new JLabel("Enter Username:");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Bookman Old Style", Font.BOLD, 15));

		JLabel lblNewLabel_1_1 = new JLabel("Enter Email:");
		lblNewLabel_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1.setFont(new Font("Bookman Old Style", Font.BOLD, 14));

		JLabel lblNewLabel_1_2 = new JLabel("Enter Password:\r\n");
		lblNewLabel_1_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_2.setFont(new Font("Bookman Old Style", Font.BOLD, 14));

		JLabel lblNewLabel_1_3 = new JLabel("Enter Phone Number:");
		lblNewLabel_1_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_3.setFont(new Font("Bookman Old Style", Font.BOLD, 14));

		lblNewLabel_2 = new JLabel("User:");
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("Bookman Old Style", Font.BOLD, 14));

		lblNewLabel_3 = new JLabel("Select Course:");
		lblNewLabel_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_3.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(300)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addComponent(rolesSelect, 0, 207, Short.MAX_VALUE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
						.addComponent(phone, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
						.addComponent(password, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
						.addComponent(email, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
						.addComponent(username, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_1_2)
						.addComponent(lblNewLabel_1_3)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(btnCreate, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
							.addGap(29)
							.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(course, 0, 207, Short.MAX_VALUE)
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(304, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(24)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(username, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(email, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(password, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(phone, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rolesSelect, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(course, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCreate, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(52))
		);
		panel_1.setLayout(gl_panel_1);
		frame.setVisible(true);

		String[] roles = { "Teacher", "Student" };
	}
}