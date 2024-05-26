package CM;
import java.awt.EventQueue;

import CM.DBConnection;
import CM.DatabaseMGMT;
import CM.Login;
import CM.UpdateCourse;

public class Main {
	 public static void main(String[] args) {
		 DatabaseMGMT db = new DatabaseMGMT();
		 db.setUrl("jdbc:mysql://localhost:3306/managementsystemcourse");
		 db.setUsername("root");
		 db.setPassword("");
		 EventQueue.invokeLater(new Runnable() {
		 public void run() {
		 try {
		 Login window = new Login();
		 window.frame.setVisible(true);
		 } catch (Exception e) {
		 e.printStackTrace();
		 }
		 }
});
		 }
}