package project;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.filechooser.*;

import java.awt.event.ActionEvent;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rsyntaxtextarea.SyntaxScheme;
import org.fife.ui.rtextarea.RTextScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;

class MainExternalThread extends Thread {

	public void run() {

		while (true) {

			try {

				int height = app.frame.getHeight(), width = app.frame.getWidth();
				app.scrollPane.setBounds(0, 33, width - 13, height - 120);

//				// Line numbers Algo
				int caretOffset = app.textArea.getCaretPosition();
				int lineNumber = app.textArea.getLineOfOffset(caretOffset);
				lineNumber += 1;
				app.lblNewLabel_2.setBounds(width - 175, height - 90, 113, 27);
				app.lblNewLabel_2.setText("Line: " + lineNumber);

				// Col numbers algo
				int caretOffset1 = app.textArea.getCaretPosition();
//				int offset = Utilities.getRowStart(app.textArea, caretOffset);
				int lineNumber1 = app.textArea.getLineOfOffset(caretOffset1);
				int offset = app.textArea.getLineStartOffset(lineNumber1);
				int colNum = caretOffset1 - offset + 1;
				app.lblNewLabel_3.setBounds(width - 100, height - 90, 113, 27);
				app.lblNewLabel_3.setText("Column: " + colNum);

				if (app.language.equals("Java"))
					app.textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);

				else if (app.language.equals("Python"))
					app.textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_PYTHON);

				else if (app.language.equals("C++"))
					app.textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_CPLUSPLUS);

				else if (app.language.equals("C"))
					app.textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_C);

				else if (app.language.equals("JavaScript"))
					app.textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVASCRIPT);

				else if (app.language.equals("C#"))
					app.textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_CSHARP);

				else if (app.language.equals("PHP"))
					app.textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_PHP);

				else if (app.language.equals("HTML"))
					app.textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_HTML);

//				String look_and_feel = UIManager.getLookAndFeel().toString();

//				if (look_and_feel.equals("[The Microsoft Windows Look and Feel - com.sun.java.swing.plaf.windows.WindowsLookAndFeel]")) {
//					System.out.println(true);
//				} 

			} catch (Exception e6) {

			}
		}
	}
}

public class app {
	public static RTextScrollPane sp;
	public static JLabel lblNewLabel_3;
	public static volatile String language;
	public static JLabel lblNewLabel_2 = new JLabel();
	public static String opened_file = "";
	public static JFrame frame;
	public static RTextScrollPane scrollPane;
	public static RSyntaxTextArea textArea;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenu mnNewMenu_2;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	private JMenuItem mntmNewMenuItem_3;
	private JMenuItem mntmNewMenuItem_7;
	private JSeparator separator;
	private JMenuItem mntmNewMenuItem_8;
	private JButton btnNewButton;
	private JComboBox comboBox_1;
	private JMenuItem mntmNewMenuItem_9;
	public static JPanel panel;
	public static volatile JCheckBox chckbxNewCheckBox_1;
	public static volatile boolean Autosave = true;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {

			UIManager.setLookAndFeel(DBManager.getLookAndFeel());

			JFrame.setDefaultLookAndFeelDecorated(false);
		} catch (Throwable e) {
			e.printStackTrace();
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					app window = new app();
					window.frame.setVisible(true);

					TextAreaColor color = new TextAreaColor(UIManager.getLookAndFeel(), textArea);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public app() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1129, 638);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		scrollPane = new RTextScrollPane();
		scrollPane.setBounds(0, 29, 1107, 586);
		frame.getContentPane().add(scrollPane);
		
		try {
			DBManager.makeDB();
		} catch (ClassNotFoundException e4) {
			// TODO Auto-generated catch block
			e4.printStackTrace();
		} catch (SQLException e4) {
			// TODO Auto-generated catch block
			e4.printStackTrace();
		}
		DBManager manager = new DBManager();
		
		
		ImageIcon img = new ImageIcon("icon.png");
		
		frame.setIconImage(img.getImage());
		

		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox.setToolTipText("Change Font Size");
		comboBox.setFocusable(false);
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
				"11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27",
				"28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44",
				"45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61",
				"62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78",
				"79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95",
				"96", "97", "98", "99", "100", "101", "102", "103", "104", "105", "106", "107", "108", "109", "110",
				"111", "112", "113", "114", "115", "116", "117", "118", "119", "120", "121", "122", "123", "124", "125",
				"126", "127", "128", "129", "130", "131", "132", "133", "134", "135", "136", "137", "138", "139", "140",
				"141", "142", "143", "144", "145", "146", "147", "148", "149", "150", "151", "152", "153", "154", "155",
				"156", "157", "158", "159", "160", "161", "162", "163", "164", "165", "166", "167", "168", "169", "170",
				"171", "172", "173", "174", "175", "176", "177", "178", "179", "180", "181", "182", "183", "184", "185",
				"186", "187", "188", "189", "190", "191", "192", "193", "194", "195", "196", "197", "198", "199", "200",
				"201", "202", "203", "204", "205", "206", "207", "208", "209", "210", "211", "212", "213", "214", "215",
				"216", "217", "218", "219", "220", "221", "222", "223", "224", "225", "226", "227", "228", "229", "230",
				"231", "232", "233", "234", "235", "236", "237", "238", "239", "240", "241", "242", "243", "244", "245",
				"246", "247", "248", "249", "250", "251", "252", "253", "254", "255", "256", "257", "258", "259", "260",
				"261", "262", "263", "264", "265", "266", "267", "268", "269", "270", "271", "272", "273", "274", "275",
				"276", "277", "278", "279", "280", "281", "282", "283", "284", "285", "286", "287", "288", "289", "290",
				"291", "292", "293", "294", "295", "296", "297", "298", "299", "300", "301", "302", "303", "304", "305",
				"306", "307", "308", "309", "310", "311", "312", "313", "314", "315", "316", "317", "318", "319", "320",
				"321", "322", "323", "324", "325", "326", "327", "328", "329", "330", "331", "332", "333", "334", "335",
				"336", "337", "338", "339", "340", "341", "342", "343", "344", "345", "346", "347", "348", "349", "350",
				"351", "352", "353", "354", "355", "356", "357", "358", "359", "360", "361", "362", "363", "364", "365",
				"366", "367", "368", "369", "370", "371", "372", "373", "374", "375", "376", "377", "378", "379", "380",
				"381", "382", "383", "384", "385", "386", "387", "388", "389", "390", "391", "392", "393", "394", "395",
				"396", "397", "398", "399", "400", "401", "402", "403", "404", "405", "406", "407", "408", "409", "410",
				"411", "412", "413", "414", "415", "416", "417", "418", "419", "420", "421", "422", "423", "424", "425",
				"426", "427", "428", "429", "430", "431", "432", "433", "434", "435", "436", "437", "438", "439", "440",
				"441", "442", "443", "444", "445", "446", "447", "448", "449", "450", "451", "452", "453", "454", "455",
				"456", "457", "458", "459", "460", "461", "462", "463", "464", "465", "466", "467", "468", "469", "470",
				"471", "472", "473", "474", "475", "476", "477", "478", "479", "480", "481", "482", "483", "484", "485",
				"486", "487", "488", "489", "490", "491", "492", "493", "494", "495", "496", "497", "498", "499", "500",
				"501", "502", "503", "504", "505", "506", "507", "508", "509", "510", "511", "512", "513", "514", "515",
				"516", "517", "518", "519", "520", "521", "522", "523", "524", "525", "526", "527", "528", "529", "530",
				"531", "532", "533", "534", "535", "536", "537", "538", "539", "540", "541", "542", "543", "544", "545",
				"546", "547", "548", "549", "550", "551", "552", "553", "554", "555", "556", "557", "558", "559", "560",
				"561", "562", "563", "564", "565", "566", "567", "568", "569", "570", "571", "572", "573", "574", "575",
				"576", "577", "578", "579", "580", "581", "582", "583", "584", "585", "586", "587", "588", "589", "590",
				"591", "592", "593", "594", "595", "596", "597", "598", "599", "600", "601", "602", "603", "604", "605",
				"606", "607", "608", "609", "610", "611", "612", "613", "614", "615", "616", "617", "618", "619", "620",
				"621", "622", "623", "624", "625", "626", "627", "628", "629", "630", "631", "632", "633", "634", "635",
				"636", "637", "638", "639", "640", "641", "642", "643", "644", "645", "646", "647", "648", "649", "650",
				"651", "652", "653", "654", "655", "656", "657", "658", "659", "660", "661", "662", "663", "664", "665",
				"666", "667", "668", "669", "670", "671", "672", "673", "674", "675", "676", "677", "678", "679", "680",
				"681", "682", "683", "684", "685", "686", "687", "688", "689", "690", "691", "692", "693", "694", "695",
				"696", "697", "698", "699", "700", "701", "702", "703", "704", "705", "706", "707", "708", "709", "710",
				"711", "712", "713", "714", "715", "716", "717", "718", "719", "720", "721", "722", "723", "724", "725",
				"726", "727", "728", "729", "730", "731", "732", "733", "734", "735", "736", "737", "738", "739", "740",
				"741", "742", "743", "744", "745", "746", "747", "748", "749", "750", "751", "752", "753", "754", "755",
				"756", "757", "758", "759", "760", "761", "762", "763", "764", "765", "766", "767", "768", "769", "770",
				"771", "772", "773", "774", "775", "776", "777", "778", "779", "780", "781", "782", "783", "784", "785",
				"786", "787", "788", "789", "790", "791", "792", "793", "794", "795", "796", "797", "798", "799", "800",
				"801", "802", "803", "804", "805", "806", "807", "808", "809", "810", "811", "812", "813", "814", "815",
				"816", "817", "818", "819", "820", "821", "822", "823", "824", "825", "826", "827", "828", "829", "830",
				"831", "832", "833", "834", "835", "836", "837", "838", "839", "840", "841", "842", "843", "844", "845",
				"846", "847", "848", "849", "850", "851", "852", "853", "854", "855", "856", "857", "858", "859", "860",
				"861", "862", "863", "864", "865", "866", "867", "868", "869", "870", "871", "872", "873", "874", "875",
				"876", "877", "878", "879", "880", "881", "882", "883", "884", "885", "886", "887", "888", "889", "890",
				"891", "892", "893", "894", "895", "896", "897", "898", "899", "900", "901", "902", "903", "904", "905",
				"906", "907", "908", "909", "910", "911", "912", "913", "914", "915", "916", "917", "918", "919", "920",
				"921", "922", "923", "924", "925", "926", "927", "928", "929", "930", "931", "932", "933", "934", "935",
				"936", "937", "938", "939", "940", "941", "942", "943", "944", "945", "946", "947", "948", "949", "950",
				"951", "952", "953", "954", "955", "956", "957", "958", "959", "960", "961", "962", "963", "964", "965",
				"966", "967", "968", "969", "970", "971", "972", "973", "974", "975", "976", "977", "978", "979", "980",
				"981", "982", "983", "984", "985", "986", "987", "988", "989", "990", "991", "992", "993", "994", "995",
				"996", "997", "998", "999", "1000", "1001", "1002", "1003", "1004", "1005", "1006", "1007", "1008" }));
		try {
			comboBox.setSelectedIndex(manager.getFontSize());
		} catch (SQLException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		comboBox.setBounds(402, 2, 90, 26);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setFont(new Font((String) comboBox_1.getSelectedItem(), Font.PLAIN,
						Integer.parseInt((String) comboBox.getSelectedItem())));
				try {
					manager.setFontSize(comboBox.getSelectedItem());

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "Agency FB", "Algerian", "Arial", "Arial Black",
				"Arial Narrow", "Arial Rounded MT Bold", "Bahnschrift", "Baskerville Old Face", "Bauhaus 93", "Bell MT",
				"Berlin Sans FB", "Berlin Sans FB Demi", "Bernard MT Condensed", "Blackadder ITC", "Bodoni MT",
				"Bodoni MT Black", "Bodoni MT Condensed", "Bodoni MT Poster Compressed", "Book Antiqua",
				"Bookman Old Style", "Bookshelf Symbol 7", "Bradley Hand ITC", "Britannic Bold", "Broadway",
				"Brush Script MT", "Calibri", "Calibri Light", "Californian FB", "Calisto MT", "Cambria",
				"Cambria Math", "Candara", "Candara Light", "Castellar", "Centaur", "Century", "Century Gothic",
				"Century Schoolbook", "Chiller", "Colonna MT", "Comic Sans MS", "Consolas", "Constantia",
				"Cooper Black", "Copperplate Gothic Bold", "Copperplate Gothic Light", "Corbel", "Corbel Light",
				"Courier New", "Curlz MT", "Dialog", "DialogInput", "Dubai", "Dubai Light", "Dubai Medium", "Ebrima",
				"Edwardian Script ITC", "Elephant", "Engravers MT", "Eras Bold ITC", "Eras Demi ITC", "Eras Light ITC",
				"Eras Medium ITC", "Felix Titling", "Footlight MT Light", "Forte", "Franklin Gothic Book",
				"Franklin Gothic Demi", "Franklin Gothic Demi Cond", "Franklin Gothic Heavy", "Franklin Gothic Medium",
				"Franklin Gothic Medium Cond", "Freestyle Script", "French Script MT", "Gabriola", "Gadugi", "Garamond",
				"Georgia", "Gigi", "Gill Sans MT", "Gill Sans MT Condensed", "Gill Sans MT Ext Condensed Bold",
				"Gill Sans Ultra Bold", "Gill Sans Ultra Bold Condensed", "Gloucester MT Extra Condensed",
				"Goudy Old Style", "Goudy Stout", "Haettenschweiler", "Harlow Solid Italic", "Harrington",
				"High Tower Text", "HoloLens MDL2 Assets", "Impact", "Imprint MT Shadow", "Informal Roman", "Ink Free",
				"Javanese Text", "Jokerman", "Juice ITC", "Kristen ITC", "Kunstler Script", "Leelawadee",
				"Leelawadee UI", "Leelawadee UI Semilight", "Lucida Bright", "Lucida Calligraphy", "Lucida Console",
				"Lucida Fax", "Lucida Handwriting", "Lucida Sans", "Lucida Sans Typewriter", "Lucida Sans Unicode",
				"Magneto", "Maiandra GD", "Malgun Gothic", "Malgun Gothic Semilight", "Marlett",
				"Matura MT Script Capitals", "Microsoft Himalaya", "Microsoft JhengHei", "Microsoft JhengHei Light",
				"Microsoft JhengHei UI", "Microsoft JhengHei UI Light", "Microsoft New Tai Lue", "Microsoft PhagsPa",
				"Microsoft Sans Serif", "Microsoft Tai Le", "Microsoft Uighur", "Microsoft YaHei",
				"Microsoft YaHei Light", "Microsoft YaHei UI", "Microsoft YaHei UI Light", "Microsoft Yi Baiti",
				"MingLiU-ExtB", "MingLiU_HKSCS-ExtB", "Mistral", "Modern No. 20", "Mongolian Baiti", "Monospaced",
				"Monotype Corsiva", "MS Gothic", "MS Outlook", "MS PGothic", "MS Reference Sans Serif",
				"MS Reference Specialty", "MS UI Gothic", "MT Extra", "MV Boli", "Myanmar Text", "Niagara Engraved",
				"Niagara Solid", "Nirmala UI", "Nirmala UI Semilight", "NSimSun", "OCR A Extended",
				"Old English Text MT", "Onyx", "Palace Script MT", "Palatino Linotype", "Papyrus", "Parchment",
				"Perpetua", "Perpetua Titling MT", "Playbill", "PMingLiU-ExtB", "Poor Richard", "Pristina",
				"Rage Italic", "Ravie", "Rockwell", "Rockwell Condensed", "Rockwell Extra Bold", "SansSerif",
				"Script MT Bold", "Segoe MDL2 Assets", "Segoe Print", "Segoe Script", "Segoe UI", "Segoe UI Black",
				"Segoe UI Emoji", "Segoe UI Historic", "Segoe UI Light", "Segoe UI Semibold", "Segoe UI Semilight",
				"Segoe UI Symbol", "Serif", "Showcard Gothic", "SimSun", "SimSun-ExtB", "Sitka Banner", "Sitka Display",
				"Sitka Heading", "Sitka Small", "Sitka Subheading", "Sitka Text", "Snap ITC", "Stencil", "Sylfaen",
				"Symbol", "Tahoma", "Tempus Sans ITC", "Times New Roman", "Trebuchet MS", "Tw Cen MT",
				"Tw Cen MT Condensed", "Tw Cen MT Condensed Extra Bold", "Verdana", "Viner Hand ITC", "Vivaldi",
				"Vladimir Script", "Webdings", "Wide Latin", "Wingdings", "Wingdings 2", "Wingdings 3", "Yu Gothic",
				"Yu Gothic Light", "Yu Gothic Medium", "Yu Gothic UI", "Yu Gothic UI Light", "Yu Gothic UI Semibold",
				"Yu Gothic UI Semilight" }));

		comboBox_1.setSelectedIndex(41);
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox_1.setBounds(188, 2, 209, 26);
		comboBox_1.setFocusable(false);
		frame.getContentPane().add(comboBox_1);

		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a = (String) comboBox_1.getSelectedItem();
				System.out.println(a);
				textArea.setFont(new Font(a, Font.PLAIN, Integer.parseInt((String) comboBox.getSelectedItem())));
			}
		});

		textArea = new RSyntaxTextArea();
		textArea.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {

				if (e.isControlDown()) {

					if (e.getWheelRotation() < 0)
						textArea.setFont(
								new Font(textArea.getFont().getFamily(), Font.PLAIN, textArea.getFont().getSize() + 1));

					else {
						if (textArea.getFont().getSize() > 1)
							textArea.setFont(new Font(textArea.getFont().getFamily(), Font.PLAIN,
									textArea.getFont().getSize() - 1));
					}
				}
				else 
					textArea.getParent().dispatchEvent(e);
				
			}
		});
		textArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_0) {
					System.out.println(UIManager.getLookAndFeel());
				}
			}
		});
		
		Color color_1 = new Color(204, 120, 50);
		Color color_2 = new Color(6, 125, 23);
		Color color_3 = new Color(140, 140, 140);
		textArea.getSelectionEnd();
		SyntaxScheme scheme = textArea.getSyntaxScheme();
		scheme.getStyle(org.fife.ui.rsyntaxtextarea.Token.RESERVED_WORD).foreground = color_1;
		scheme.getStyle(org.fife.ui.rsyntaxtextarea.Token.DATA_TYPE).foreground = Color.BLUE;
		scheme.getStyle(org.fife.ui.rsyntaxtextarea.Token.LITERAL_STRING_DOUBLE_QUOTE).foreground = color_2;
		scheme.getStyle(org.fife.ui.rsyntaxtextarea.Token.COMMENT_EOL).foreground = color_3;

		textArea.setFont(new Font(comboBox_1.getSelectedItem().toString(), Font.PLAIN,
				Integer.parseInt((String) comboBox.getSelectedItem())));
		textArea.setTabSize(4);

//		textArea.setCurrentLineHighlightColor(textArea.getBackground().cyan);
//		textArea.setCurrentLineHighlightColor(textArea.getBackground().black);
		Color color2 = new Color(232, 242, 254);
		textArea.setCurrentLineHighlightColor(textArea.getBackground());
		textArea.setCodeFoldingEnabled(true);

		sp = new RTextScrollPane(textArea);
		textArea.setCodeFoldingEnabled(true);
		scrollPane.setViewportView(textArea);
		textArea.setLineWrap(false);
		textArea.setClearWhitespaceLinesEnabled(false);
		textArea.setAntiAliasingEnabled(true);
		frame.getContentPane().add(sp);
		sp.setLineNumbersEnabled(true);

		frame.getContentPane().add(comboBox);

		JCheckBox chckbxNewCheckBox = new JCheckBox("Word Wrap");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (chckbxNewCheckBox.isSelected() == true) {
					textArea.setLineWrap(true);
					JOptionPane.showMessageDialog(frame, "Word Wrap Enabled!\n");
				} else {
					textArea.setLineWrap(false);
					JOptionPane.showMessageDialog(frame, "Word Wrap Disabled!\n");
				}
			}
		});
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbxNewCheckBox.setBounds(0, 5, 105, 21);
		chckbxNewCheckBox.setFocusable(false);
		frame.getContentPane().add(chckbxNewCheckBox);

		JLabel lblNewLabel = new JLabel("Font Style:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(111, 2, 131, 26);

		frame.getContentPane().add(lblNewLabel);

		ImageIcon icon = new ImageIcon("play.png");

		btnNewButton = new JButton(icon);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (Autosave) {
						
						try {
							if (opened_file != "") {
								BufferedWriter writer2 = new BufferedWriter(new FileWriter(opened_file));
								textArea.write(writer2);
							}
						} catch (FileNotFoundException e10) {
							// TODO: handle exception
							JFileChooser filechooser = new JFileChooser();
							FileNameExtensionFilter filter = new FileNameExtensionFilter("Save File", "*");
							filechooser.setAcceptAllFileFilterUsed(false);
							filechooser.addChoosableFileFilter(filter);

							int action = filechooser.showSaveDialog(null);

							if (action != JFileChooser.APPROVE_OPTION)
								return;

							else {
								String filename = filechooser.getSelectedFile().getAbsolutePath().toString();

								try {
									textArea.setTabSize(4);
									BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
									textArea.write(writer);
									textArea.setTabSize(4);
									opened_file = filename;
									frame.setTitle(opened_file);
								} catch (Exception e1) {
									e1.printStackTrace();
								}
							}
						}
					}

					if (language == "Python") {

						if (opened_file != "") {

							String command = "python " + opened_file;
							Runtime.getRuntime().exec("cmd /c start cmd.exe /K " + command);
						} else
							JOptionPane.showMessageDialog(frame, "No file opened");
					}

					else if (language.equals("Java")) {

						if (opened_file != "") {
							String classpath = opened_file.replace(".java", "");
							String[] last_name_list = opened_file.split("\\\\");
							String lastname = last_name_list[last_name_list.length - 1];
							String folderpath = opened_file.replace(lastname, "");
							String[] classpath_1 = classpath.split("\\\\");
							String class_file = classpath_1[classpath_1.length - 1];

							Runtime rt = Runtime.getRuntime();
							rt.exec("cmd /c start cmd.exe /K \"cd " + folderpath + " && javac " + opened_file
									+ " && java " + class_file + "\"");
						} else
							JOptionPane.showMessageDialog(frame, "No file opened");
					}

					else if (language.equals("C++")) {

						if (opened_file != "") {
							String[] last_name_list = opened_file.split("\\\\");
							String lastname = last_name_list[last_name_list.length - 1];
							String folderpath = opened_file.replace(lastname, "");
							String exe_name = opened_file.replace(".cpp", "");

							Runtime rt = Runtime.getRuntime();
							rt.exec("cmd /c start cmd.exe /K \" cd " + folderpath + " && g++ -o " + exe_name + " "
									+ opened_file + " && " + exe_name + "\"");
						} else
							JOptionPane.showMessageDialog(frame, "No file opened");
					}

					else if (language.equals("C")) {

						if (opened_file != "") {

							String[] last_name_list = opened_file.split("\\\\");
							String lastname = last_name_list[last_name_list.length - 1];
							String folderpath = opened_file.replace(lastname, "");
							String exe_name = opened_file.replace(".c", "");

							Runtime rt = Runtime.getRuntime();
							rt.exec("cmd /c start cmd.exe /K \" cd " + folderpath + " && gcc -o " + exe_name + " "
									+ opened_file + " && " + exe_name + "\"");
						} else
							JOptionPane.showMessageDialog(frame, "No file opened");
					}

					else if (language.equals("C#")) {
						String exe_path = opened_file.replace(".cs", ".exe");
						Runtime rt = Runtime.getRuntime();
//					rt.exec("path=C:\\Windows\\Microsoft.NET\\Framework\\v4.0.30319");
//					rt.exec("cmd /c start cmd.exe /K \"csc "  +  opened_file + "\"");
						String homeDirectory = System.getProperty("user.home");
						rt.exec(String.format("cmd.exe /c dir %s", homeDirectory));
					}

					else if (language.equals("JavaScript")) {

						if (opened_file != "") {
							String[] last_name_list = opened_file.split("\\\\");
							String lastname = last_name_list[last_name_list.length - 1];
							String folderpath = opened_file.replace(lastname, "");

							Runtime rt = Runtime.getRuntime();
							rt.exec("cmd /c start cmd.exe /K \"cd " + folderpath + " && node " + lastname + "\"");
						} else
							JOptionPane.showMessageDialog(frame, "No file opened");
					}

					else if (language.equals("PHP")) {
						JOptionPane.showMessageDialog(frame, "PHP is not meant to be runned in console");
					}

					else if (language.equals("HTML")) {
						JOptionPane.showMessageDialog(frame, "You noob! How can you run HTML on console");
					}

					else if (language.equals("CSS")) {
						JOptionPane.showMessageDialog(frame, "You noob! How can you run CSS on console");
					}

				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnNewButton.setToolTipText("Run Code");
		btnNewButton.setFocusable(false);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(502, 2, 30, 30);
		frame.getContentPane().add(btnNewButton);

		JLabel lblNewLabel_1 = new JLabel("Language:");
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(549, 1, 82, 26);
		frame.getContentPane().add(lblNewLabel_1);

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(
				new String[] { "Java", "C++", "C#", "C", "JavaScript", "Python", "PHP", "HTML", "CSS" }));
		comboBox_2.setFont(new Font("Dialog", Font.PLAIN, 16));
		comboBox_2.setBounds(635, 2, 105, 26);
		comboBox_2.setFocusable(false);

		frame.getContentPane().add(comboBox_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(490, frame.getHeight() - 85, 113, 27);
		frame.getContentPane().add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(658, 440, 82, 17);
		frame.getContentPane().add(lblNewLabel_3);

		chckbxNewCheckBox_1 = new JCheckBox("Save on Run");
		chckbxNewCheckBox_1.setSelected(true);
		chckbxNewCheckBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					if (chckbxNewCheckBox_1.isSelected())
						Autosave = true;

					else
						Autosave = false;

				} catch (Exception e2) {
					// TODO: handle exception
				}

			}
		});
		chckbxNewCheckBox_1.setFont(new Font("Dialog", Font.PLAIN, 16));
		chckbxNewCheckBox_1.setBounds(749, 1, 131, 26);
		frame.getContentPane().add(chckbxNewCheckBox_1);
		chckbxNewCheckBox_1.setFocusable(false);

		try {
			comboBox_2.setSelectedItem(DBManager.getLanguage());
			DBManager.setLanguage(comboBox_2.getSelectedItem());

			String lang = DBManager.getLanguage();
			System.out.println(lang);

			switch (lang) {
			case "Java":
				language = "Java";
				textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
				break;

			case "C++":
				language = "C++";
				textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_CPLUSPLUS);
				break;

			case "C":
				language = "C";
				textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_C);
				break;

			case "Python":
				language = "Python";
				textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_PYTHON);
				break;

			case "JavaScript":
				language = "JavaScript";
				textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVASCRIPT);
				break;

			case "C#":
				language = "C#";
				textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_CSHARP);
				break;

			case "PHP":
				language = "PHP";
				textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_PHP);
				break;

			case "CSS":
				language = "CSS";
				textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_CSS);
				break;

			case "HTML":
				language = "CSS";
				textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_HTML);
				break;

			}

		} catch (ClassNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (SQLException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}

		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					DBManager.setLanguage(comboBox_2.getSelectedItem());

					language = (String) comboBox_2.getSelectedItem();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		mnNewMenu = new JMenu("File");
		mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.add(mnNewMenu);

		mntmNewMenuItem = new JMenuItem("New");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int result = JOptionPane.showConfirmDialog(frame,
						"Are you sure you want a new file\n The data in existing file can be lost if it is not saved.",
						"Message", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

				if (result == JOptionPane.YES_OPTION) {
					textArea.setText(null);
				}
			}
		});
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnNewMenu.add(mntmNewMenuItem);

		mntmNewMenuItem_1 = new JMenuItem("Save");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					if (opened_file != "") {
						
						try {
							BufferedWriter writer2 = new BufferedWriter(new FileWriter(opened_file));
							textArea.write(writer2);
							JOptionPane.showMessageDialog(frame, "Saved");
							textArea.setTabSize(4);
						} catch (FileNotFoundException e9) {
							// TODO: handle exception
							JFileChooser filechooser = new JFileChooser();
							FileNameExtensionFilter filter = new FileNameExtensionFilter("Save File", "*");
							filechooser.setAcceptAllFileFilterUsed(false);
							filechooser.addChoosableFileFilter(filter);

							int action = filechooser.showSaveDialog(null);

							if (action != JFileChooser.APPROVE_OPTION)
								return;

							else {
								String filename = filechooser.getSelectedFile().getAbsolutePath().toString();

								try {
									textArea.setTabSize(4);
									BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
									textArea.write(writer);
									textArea.setTabSize(4);
									opened_file = filename;
									frame.setTitle(opened_file);
								} catch (Exception e1) {
									e1.printStackTrace();
								}
							}
						}
					} else if (opened_file == "") {

						JFileChooser filechooser = new JFileChooser();
						FileNameExtensionFilter filter = new FileNameExtensionFilter("Save File", "Java");
						filechooser.setAcceptAllFileFilterUsed(true);
						filechooser.addChoosableFileFilter(filter);

						int action = filechooser.showSaveDialog(null);

						if (action != JFileChooser.APPROVE_OPTION)
							return;

						else {
							String filename = filechooser.getSelectedFile().getAbsolutePath().toString();

							try {
								textArea.setTabSize(4);
								BufferedWriter writer1 = new BufferedWriter(new FileWriter(filename));
								textArea.write(writer1);
								textArea.setTabSize(4);
								opened_file = filename;
								frame.setTitle(opened_file);
							} catch (Exception e1) {
								e1.printStackTrace();
							}
						}
					}

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		try {
			opened_file = DBManager.getFileName();
			frame.setTitle(opened_file);
			BufferedReader reader = new BufferedReader(new FileReader(opened_file));
			textArea.read(reader, null);
		} catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
//			e3.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
		} catch (NullPointerException e) {
			// TODO: handle exception
		}

		mntmNewMenuItem_8 = new JMenuItem("Open File...");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFileChooser fileChooser = new JFileChooser();
				FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter("Open Files", "*");
				fileChooser.setAcceptAllFileFilterUsed(true);
				fileChooser.addChoosableFileFilter(fileNameExtensionFilter);

				int action = fileChooser.showOpenDialog(null);

				if (action != JFileChooser.APPROVE_OPTION)
					return;
				else {
					try {

						BufferedReader reader = new BufferedReader(new FileReader(fileChooser.getSelectedFile()));
						textArea.read(reader, null);
						opened_file = fileChooser.getSelectedFile().toString();
						frame.setTitle(opened_file);
						textArea.setTabSize(4);
						DBManager.setFileName(fileChooser.getSelectedFile());

					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
			}
		});
		mntmNewMenuItem_8.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnNewMenu.add(mntmNewMenuItem_8);
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnNewMenu.add(mntmNewMenuItem_1);

		mntmNewMenuItem_2 = new JMenuItem("Save As...");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFileChooser filechooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Save File", "*");
				filechooser.setAcceptAllFileFilterUsed(false);
				filechooser.addChoosableFileFilter(filter);

				int action = filechooser.showSaveDialog(null);

				if (action != JFileChooser.APPROVE_OPTION)
					return;

				else {
					String filename = filechooser.getSelectedFile().getAbsolutePath().toString();

					try {
						textArea.setTabSize(4);
						BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
						textArea.write(writer);
						textArea.setTabSize(4);
						opened_file = filename;
						frame.setTitle(opened_file);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		mntmNewMenuItem_2.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnNewMenu.add(mntmNewMenuItem_2);

		mntmNewMenuItem_9 = new JMenuItem("Close File");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (opened_file != "") {
					frame.setTitle("");
					JOptionPane.showMessageDialog(frame, opened_file + " Has been closed");
					opened_file = "";
					frame.setTitle(opened_file);
					textArea.setTabSize(4);
					textArea.setText("");

					try {
						DBManager.setFileName("");
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(frame, "No file to be closed");
					textArea.setTabSize(4);
				}
			}
		});
		mntmNewMenuItem_9.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnNewMenu.add(mntmNewMenuItem_9);

		separator = new JSeparator();
		mnNewMenu.add(separator);

		mntmNewMenuItem_3 = new JMenuItem("Exit");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mntmNewMenuItem_3.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnNewMenu.add(mntmNewMenuItem_3);

		JMenu mnNewMenu_3 = new JMenu("Themes");
		mnNewMenu_3.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.add(mnNewMenu_3);

		ButtonGroup bg = new ButtonGroup();

		JRadioButtonMenuItem rdbtnmntmNewRadioItem = new JRadioButtonMenuItem("Cross Platform Theme");
		rdbtnmntmNewRadioItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color color = new Color(255, 255, 255);

				LookAndFeelManager changer = new LookAndFeelManager(frame, "javax.swing.plaf.metal.MetalLookAndFeel");
				changer.setFontSizeAndStyle(textArea, comboBox_1, comboBox);
				changer.setTextAreaColor(textArea, color);
				changer.setLineColor(null, textArea);
				changer.setForegroundColor(textArea, Color.BLACK);

				try {
					DBManager.setLookAndFeel(UIManager.getLookAndFeel());
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		rdbtnmntmNewRadioItem.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnNewMenu_3.add(rdbtnmntmNewRadioItem);

		JRadioButtonMenuItem rdbtnmntmNewRadioItem_1 = new JRadioButtonMenuItem("System Default Theme");
		rdbtnmntmNewRadioItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color color = new Color(255, 255, 255);

				LookAndFeelManager changer = new LookAndFeelManager(frame, UIManager.getSystemLookAndFeelClassName());
				changer.setFontSizeAndStyle(textArea, comboBox_1, comboBox);
				changer.setTextAreaColor(textArea, color);
				changer.setLineColor(null, textArea);
				changer.setForegroundColor(textArea, Color.BLACK);

				try {
					DBManager.setLookAndFeel(UIManager.getLookAndFeel());
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		rdbtnmntmNewRadioItem_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnNewMenu_3.add(rdbtnmntmNewRadioItem_1);

		JRadioButtonMenuItem rdbtnmntmNewRadioItem_2 = new JRadioButtonMenuItem("Windows Xp Theme");
		rdbtnmntmNewRadioItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Color color = new Color(255, 255, 255);

				LookAndFeelManager changer = new LookAndFeelManager(frame, "com.jtattoo.plaf.luna.LunaLookAndFeel");
				changer.setFontSizeAndStyle(textArea, comboBox_1, comboBox);
				changer.setTextAreaColor(textArea, color);
				changer.setLineColor(null, textArea);
				changer.setForegroundColor(textArea, Color.BLACK);

				try {
					DBManager.setLookAndFeel(UIManager.getLookAndFeel());
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		rdbtnmntmNewRadioItem_2.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnNewMenu_3.add(rdbtnmntmNewRadioItem_2);

		JRadioButtonMenuItem rdbtnmntmNewRadioItem_3 = new JRadioButtonMenuItem("HiFi Theme (Dark)");
		rdbtnmntmNewRadioItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Color color = new Color(80, 80, 80);

				LookAndFeelManager changer = new LookAndFeelManager(frame, "com.jtattoo.plaf.hifi.HiFiLookAndFeel");
				changer.setFontSizeAndStyle(textArea, comboBox_1, comboBox);
				changer.setTextAreaColor(textArea, color);
				changer.setLineColor(null, textArea);
				changer.setForegroundColor(textArea, Color.WHITE);

				try {
					DBManager.setLookAndFeel(UIManager.getLookAndFeel());
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		rdbtnmntmNewRadioItem_3.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnNewMenu_3.add(rdbtnmntmNewRadioItem_3);

		JRadioButtonMenuItem rdbtnmntmNewRadioItem_4 = new JRadioButtonMenuItem("McWin Theme");
		rdbtnmntmNewRadioItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Color color = new Color(255, 255, 255);

				LookAndFeelManager changer = new LookAndFeelManager(frame, "com.jtattoo.plaf.mcwin.McWinLookAndFeel");
				changer.setFontSizeAndStyle(textArea, comboBox_1, comboBox);
				changer.setTextAreaColor(textArea, color);
				changer.setLineColor(null, textArea);
				changer.setForegroundColor(textArea, Color.BLACK);

				try {
					DBManager.setLookAndFeel(UIManager.getLookAndFeel());
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		rdbtnmntmNewRadioItem_4.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnNewMenu_3.add(rdbtnmntmNewRadioItem_4);

		JRadioButtonMenuItem rdbtnmntmNewRadioItem_5 = new JRadioButtonMenuItem("Mint Theme");
		rdbtnmntmNewRadioItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Color color = new Color(255, 255, 255);

				LookAndFeelManager changer = new LookAndFeelManager(frame, "com.jtattoo.plaf.mint.MintLookAndFeel");
				changer.setFontSizeAndStyle(textArea, comboBox_1, comboBox);
				changer.setTextAreaColor(textArea, color);
				changer.setLineColor(null, textArea);
				changer.setForegroundColor(textArea, Color.BLACK);

				try {
					DBManager.setLookAndFeel(UIManager.getLookAndFeel());
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		rdbtnmntmNewRadioItem_5.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnNewMenu_3.add(rdbtnmntmNewRadioItem_5);

		JRadioButtonMenuItem rdbtnmntmNewRadioItem_6 = new JRadioButtonMenuItem("Noire Theme (Dark)");
		rdbtnmntmNewRadioItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Color color = new Color(52, 55, 59);

				LookAndFeelManager changer = new LookAndFeelManager(frame, "com.jtattoo.plaf.noire.NoireLookAndFeel");
				changer.setFontSizeAndStyle(textArea, comboBox_1, comboBox);
				changer.setTextAreaColor(textArea, color);
				changer.setLineColor(null, textArea);
				changer.setForegroundColor(textArea, Color.WHITE);

				try {
					DBManager.setLookAndFeel(UIManager.getLookAndFeel());
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		rdbtnmntmNewRadioItem_6.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnNewMenu_3.add(rdbtnmntmNewRadioItem_6);

		JRadioButtonMenuItem rdbtnmntmNewRadioItem_7 = new JRadioButtonMenuItem("Smart Theme");
		rdbtnmntmNewRadioItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Color color = new Color(255, 255, 255);

				LookAndFeelManager changer = new LookAndFeelManager(frame, "com.jtattoo.plaf.smart.SmartLookAndFeel");
				changer.setFontSizeAndStyle(textArea, comboBox_1, comboBox);
				changer.setTextAreaColor(textArea, color);
				changer.setLineColor(null, textArea);
				changer.setForegroundColor(textArea, Color.BLACK);

				try {
					DBManager.setLookAndFeel(UIManager.getLookAndFeel());
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		rdbtnmntmNewRadioItem_7.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnNewMenu_3.add(rdbtnmntmNewRadioItem_7);

		mnNewMenu_2 = new JMenu("Help");
		mnNewMenu_2.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.add(mnNewMenu_2);

		mntmNewMenuItem_7 = new JMenuItem("This is beta \r\nSo no help");
		mntmNewMenuItem_7.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnNewMenu_2.add(mntmNewMenuItem_7);

		JRadioButtonMenuItem rdbtnmntmNewRadioItem_8 = new JRadioButtonMenuItem("FlarLaf Theme (Dark & Recommended)");
		rdbtnmntmNewRadioItem_8.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		rdbtnmntmNewRadioItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Color color = new Color(71, 76, 91);

				LookAndFeelManager changer = new LookAndFeelManager(frame,
						"com.formdev.flatlaf.intellijthemes.FlatArcDarkIJTheme");
				changer.setFontSizeAndStyle(textArea, comboBox_1, comboBox);
				changer.setTextAreaColor(textArea, color);
				changer.setLineColor(null, textArea);
				changer.setForegroundColor(textArea, Color.WHITE);

				try {
					DBManager.setLookAndFeel(UIManager.getLookAndFeel());
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		mnNewMenu_3.add(rdbtnmntmNewRadioItem_8);

		JRadioButtonMenuItem rdbtnmntmNewRadioItem_9 = new JRadioButtonMenuItem("FlatLaf Theme (Light)");
		rdbtnmntmNewRadioItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Color color = new Color(255, 255, 255);

				LookAndFeelManager changer = new LookAndFeelManager(frame, "com.formdev.flatlaf.FlatIntelliJLaf");
				changer.setFontSizeAndStyle(textArea, comboBox_1, comboBox);
				changer.setTextAreaColor(textArea, color);
				changer.setLineColor(null, textArea);
				changer.setForegroundColor(textArea, Color.BLACK);

				try {
					DBManager.setLookAndFeel(UIManager.getLookAndFeel());
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		rdbtnmntmNewRadioItem_9.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnNewMenu_3.add(rdbtnmntmNewRadioItem_9);

		MainExternalThread mainExternalThread = new MainExternalThread();
		mainExternalThread.start();

		bg.add(rdbtnmntmNewRadioItem);
		bg.add(rdbtnmntmNewRadioItem_1);
		bg.add(rdbtnmntmNewRadioItem_2);
		bg.add(rdbtnmntmNewRadioItem_3);
		bg.add(rdbtnmntmNewRadioItem_4);
		bg.add(rdbtnmntmNewRadioItem_5);
		bg.add(rdbtnmntmNewRadioItem_6);
		bg.add(rdbtnmntmNewRadioItem_7);
		bg.add(rdbtnmntmNewRadioItem_8);
		bg.add(rdbtnmntmNewRadioItem_9);

		ActionListener a = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {

					try {

						if (opened_file != "") {
							BufferedWriter writer2 = new BufferedWriter(new FileWriter(opened_file));
							textArea.write(writer2);
							JOptionPane.showMessageDialog(frame, "Saved");
							textArea.setTabSize(4);
							System.out.println("Saved");
						} else if (opened_file == "") {

							JFileChooser filechooser = new JFileChooser();
							FileNameExtensionFilter filter = new FileNameExtensionFilter("Save File", "Java");
							filechooser.setAcceptAllFileFilterUsed(true);
							filechooser.addChoosableFileFilter(filter);

							int action = filechooser.showSaveDialog(null);

							if (action != JFileChooser.APPROVE_OPTION)
								return;

							else {
								String filename = filechooser.getSelectedFile().getAbsolutePath().toString();

								try {
									textArea.setTabSize(4);
									BufferedWriter writer1 = new BufferedWriter(new FileWriter(filename));
									textArea.write(writer1);
									textArea.setTabSize(4);
									opened_file = filename;
									frame.setTitle(opened_file);
								} catch (Exception e1) {
									e1.printStackTrace();
								}
							}
						}

					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				} catch (Exception e2) {
					// TODO: handle exception
					System.out.println(e2);
				}
			}
		};

		frame.getRootPane().registerKeyboardAction(a, KeyStroke.getKeyStroke("Control S"),
				JComponent.WHEN_IN_FOCUSED_WINDOW);

		frame.setLocationRelativeTo(null);

	}
}
