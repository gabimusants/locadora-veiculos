package main;

import java.awt.EventQueue;

import controller.MainController;

import view.MenuView;

public class Main {

	public static void main(String[] args) {

		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            	System.err.println(ex);
        }
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				MainController.load();

				try {
					MenuView window = new MenuView();
					window.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}