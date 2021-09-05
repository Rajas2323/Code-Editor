package project;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBManager {

	private static Connection c = null;
	private static Statement stmt = null;
	public static String appdata = System.getenv("APPDATA");
	
	
	public static void makeDB() throws ClassNotFoundException, SQLException {		
		File directory = new File(appdata + "\\Code Editor");
		
		if (directory.exists() && directory.isFile()) {
			System.out.println("Exists");
		} else {
			directory.mkdir();
			System.out.println("Created");
		}
		
		
		Class.forName("org.sqlite.JDBC");
		c = DriverManager.getConnection("jdbc:sqlite:" + appdata +"\\Code Editor\\test.db");
		
		stmt = c.createStatement();
		
		try {
			stmt.executeUpdate("CREATE TABLE FILENAME (file TEXT, id INTEGER);");
			stmt.executeUpdate("CREATE TABLE FONT_SIZE (size INTEGER, id INTEGER);");
			stmt.executeUpdate("CREATE TABLE LOOKANDFEEL (lookandfeel TEXT, id INTEGER);");
			stmt.executeUpdate("CREATE TABLE PLANGUAGE (language TEXT, id INTEGER);");
			
			stmt.executeUpdate("INSERT INTO FILENAME(id) VALUES(1)");
			stmt.executeUpdate("INSERT INTO FONT_SIZE(size, id) VALUES(25, 1)");
			stmt.executeUpdate("INSERT INTO LOOKANDFEEL(lookandfeel, id) VALUES(\"com.formdev.flatlaf.FlatIntelliJLaf\", 1)");
			stmt.executeUpdate("INSERT INTO PLANGUAGE(language, id) VALUES(\"Java\", 1)");

		} catch (Exception e) {
			// TODO: handle exception
		}
		
		c.close();
		
		
		System.out.println(appdata);
	}

	public static void setFontSize(Object size) throws SQLException, ClassNotFoundException {

		Class.forName("org.sqlite.JDBC");
		c = DriverManager.getConnection("jdbc:sqlite:" + appdata +"\\Code Editor\\test.db");

		stmt = c.createStatement();

		String sql = "UPDATE FONT_SIZE SET size=" + size + " WHERE id=1";

		stmt.executeUpdate(sql);
		c.close();
	}

	public static int getFontSize() throws SQLException, ClassNotFoundException {

		Class.forName("org.sqlite.JDBC");
		c = DriverManager.getConnection("jdbc:sqlite:" + appdata +"\\Code Editor\\test.db");

		stmt = c.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM FONT_SIZE;");

		int size = 0;
		while (rs.next()) {
			size = rs.getInt("size");
		}

		rs.close();
		stmt.close();

		return size;
	}

	public static void setLanguage(Object language) throws SQLException, ClassNotFoundException {

		Class.forName("org.sqlite.JDBC");
		c = DriverManager.getConnection("jdbc:sqlite:" + appdata +"\\Code Editor\\test.db");

		stmt = c.createStatement();

		String sql = "UPDATE PLANGUAGE SET language=\"" + language + "\" WHERE id=1";

		stmt.executeUpdate(sql);
		c.close();

	}

	public static String getLanguage() throws SQLException, ClassNotFoundException {

		Class.forName("org.sqlite.JDBC");
		c = DriverManager.getConnection("jdbc:sqlite:" + appdata +"\\Code Editor\\test.db");

		stmt = c.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM PLANGUAGE;");

		String language = null;
		while (rs.next()) {
			language = rs.getString("language");
		}

		rs.close();
		stmt.close();
		c.close();

		return language;
	}

	public static void setFileName(Object file) throws SQLException, ClassNotFoundException {

		Class.forName("org.sqlite.JDBC");
		c = DriverManager.getConnection("jdbc:sqlite:" + appdata +"\\Code Editor\\test.db");

		stmt = c.createStatement();

		String sql = "UPDATE FILENAME SET file=\"" + file + "\" WHERE id=1";

		stmt.executeUpdate(sql);
		c.close();
	}

	public static String getFileName() {
		String file = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:" + appdata +"\\Code Editor\\test.db");

			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM FILENAME;");

			while (rs.next()) {
				file = rs.getString("file");
			}

			rs.close();
			stmt.close();
			c.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return file;
	}

	public static void setLookAndFeel(Object lookAndFeel) throws ClassNotFoundException, SQLException {

		Class.forName("org.sqlite.JDBC");
		c = DriverManager.getConnection("jdbc:sqlite:" + appdata +"\\Code Editor\\test.db");

		stmt = c.createStatement();

		String finalLookAndFeel = null;
		lookAndFeel = lookAndFeel.toString();

		if (lookAndFeel
				.equals("[The Microsoft Windows Look and Feel - com.sun.java.swing.plaf.windows.WindowsLookAndFeel]")) {
			finalLookAndFeel = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";

		} else if (lookAndFeel.equals("[The Java(tm) Look and Feel - javax.swing.plaf.metal.MetalLookAndFeel]")) {
			finalLookAndFeel = "javax.swing.plaf.metal.MetalLookAndFeel";

		} else if (lookAndFeel.equals("[The XP Look and Feel - com.jtattoo.plaf.luna.LunaLookAndFeel]")) {
			finalLookAndFeel = "com.jtattoo.plaf.luna.LunaLookAndFeel";

		} else if (lookAndFeel.equals("[The HiFi Look and Feel - com.jtattoo.plaf.hifi.HiFiLookAndFeel]")) {
			finalLookAndFeel = "com.jtattoo.plaf.hifi.HiFiLookAndFeel";

		} else if (lookAndFeel.equals("[The McWin Look and Feel - com.jtattoo.plaf.mcwin.McWinLookAndFeel]")) {
			finalLookAndFeel = "com.jtattoo.plaf.mcwin.McWinLookAndFeel";

		} else if (lookAndFeel.equals("[The Mint Look and Feel - com.jtattoo.plaf.mint.MintLookAndFeel]")) {
			finalLookAndFeel = "com.jtattoo.plaf.mint.MintLookAndFeel";

		} else if (lookAndFeel.equals("[The Noire Look and Feel - com.jtattoo.plaf.noire.NoireLookAndFeel]")) {
			finalLookAndFeel = "com.jtattoo.plaf.noire.NoireLookAndFeel";

		} else if (lookAndFeel.equals("[The Smart Look and Feel - com.jtattoo.plaf.smart.SmartLookAndFeel]")) {
			finalLookAndFeel = "com.jtattoo.plaf.smart.SmartLookAndFeel";

		} else if (lookAndFeel.equals("[Arc Dark - com.formdev.flatlaf.intellijthemes.FlatArcDarkIJTheme]")) {
			finalLookAndFeel = "com.formdev.flatlaf.intellijthemes.FlatArcDarkIJTheme";

		} else if (lookAndFeel.equals("[FlatLaf IntelliJ Look and Feel - com.formdev.flatlaf.FlatIntelliJLaf]")) {
			finalLookAndFeel = "com.formdev.flatlaf.FlatIntelliJLaf";
		}

		String sql = "UPDATE LOOKANDFEEL SET lookandfeel=\"" + finalLookAndFeel + "\" WHERE id=1";

		stmt.executeUpdate(sql);
		c.close();

	}

	public static String getLookAndFeel() {

		String theme = null;

		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:" + appdata +"\\Code Editor\\test.db");

			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM LOOKANDFEEL;");

			while (rs.next()) {
				theme = rs.getString("lookandfeel");
			}

			rs.close();
			stmt.close();
			c.close();
		} catch (SQLException e) {
			// TODO: handle exception
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return theme;
	}
}
