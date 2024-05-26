package CM;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import CM.DBConnection;
import CM.InvalidCredintial;

public  class User {
	public int id;
	public String name;
	public String email;
	public String phone;
	protected Connection connect;
	static DBConnection db = new DBConnection();

	public User() {
		try {
			connect = db.load();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public User(int id, String name, String email, String phone) {
		this.id = id;
		this.email = email;
		this.name = name;
		this.phone = phone;
		try {
			connect = db.load();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}