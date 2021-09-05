package project;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;


public class LookAndFeelManager {
	
	public LookAndFeelManager(JFrame frame, String theme) {
		try {
			UIManager.setLookAndFeel(theme);
			SwingUtilities.updateComponentTreeUI(frame);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public static void setFontSizeAndStyle(RSyntaxTextArea textArea, JComboBox stylebox, JComboBox sizebox) {
		textArea.setFont(new Font((String) stylebox.getSelectedItem(), Font.PLAIN, Integer.parseInt((String) sizebox.getSelectedItem())));
	}
	
	public static void setTextAreaColor(RSyntaxTextArea textArea, Color color) {
		textArea.setBackground(color);
	}
	
	public static void setLineColor(Color color, RSyntaxTextArea textArea) {
		
		if (color != null) {
			textArea.setCurrentLineHighlightColor(color);
		} else {
			textArea.setCurrentLineHighlightColor(textArea.getBackground());
		}
	}
	
	public static void setForegroundColor(RSyntaxTextArea textArea, Color color) {
		textArea.setForeground(color);
	}
}
