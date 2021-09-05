package project;

import java.awt.Color;

import javax.swing.LookAndFeel;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;

public class TextAreaColor {
	
	public TextAreaColor(Object lookAndFeel, RSyntaxTextArea textArea) {
		
		
		lookAndFeel = lookAndFeel.toString();
		
		if (lookAndFeel
				.equals("[The Microsoft Windows Look and Feel - com.sun.java.swing.plaf.windows.WindowsLookAndFeel]")) {
			LookAndFeelManager.setTextAreaColor(textArea, Color.WHITE);
			
		} else if (lookAndFeel.equals("[The Java(tm) Look and Feel - javax.swing.plaf.metal.MetalLookAndFeel]")) {
			LookAndFeelManager.setTextAreaColor(textArea, Color.WHITE);
			
		} else if (lookAndFeel.equals("[The XP Look and Feel - com.jtattoo.plaf.luna.LunaLookAndFeel]")) {
			LookAndFeelManager.setTextAreaColor(textArea, Color.WHITE);
		} else if (lookAndFeel.equals("[The HiFi Look and Feel - com.jtattoo.plaf.hifi.HiFiLookAndFeel]")) {
			Color color = new Color(80, 80, 80);
			LookAndFeelManager.setTextAreaColor(textArea, color);
			LookAndFeelManager.setForegroundColor(textArea, Color.WHITE);
		} else if (lookAndFeel.equals("[The McWin Look and Feel - com.jtattoo.plaf.mcwin.McWinLookAndFeel]")) {
			LookAndFeelManager.setTextAreaColor(textArea, Color.WHITE);
		} else if (lookAndFeel.equals("[The Mint Look and Feel - com.jtattoo.plaf.mint.MintLookAndFeel]")) {
			LookAndFeelManager.setTextAreaColor(textArea, Color.WHITE);
			LookAndFeelManager.setForegroundColor(textArea, Color.BLACK);
		} else if (lookAndFeel.equals("[The Noire Look and Feel - com.jtattoo.plaf.noire.NoireLookAndFeel]")) {
			Color color = new Color(52, 55, 59);
			LookAndFeelManager.setTextAreaColor(textArea, color);
			LookAndFeelManager.setForegroundColor(textArea, Color.WHITE);
		} else if (lookAndFeel.equals("[The Smart Look and Feel - com.jtattoo.plaf.smart.SmartLookAndFeel]")) {
			LookAndFeelManager.setTextAreaColor(textArea, Color.WHITE);
		} else if (lookAndFeel.equals("[Arc Dark - com.formdev.flatlaf.intellijthemes.FlatArcDarkIJTheme]")) {
			Color color = new Color(71, 76, 91);
			LookAndFeelManager.setTextAreaColor(textArea, color);
			LookAndFeelManager.setForegroundColor(textArea, Color.WHITE);
		} else if (lookAndFeel.equals("[FlatLaf IntelliJ Look and Feel - com.formdev.flatlaf.FlatIntelliJLaf]")) {
			LookAndFeelManager.setTextAreaColor(textArea, Color.WHITE);
		}
		
		LookAndFeelManager.setLineColor(null, textArea);
	}
	
}
