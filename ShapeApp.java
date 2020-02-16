import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ShapeApp extends JFrame {
	private static final long serialVersionUID = 1L;
	private ShapeContainer shapeContainer = new ShapeContainer();

	public ShapeApp() {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		createMenue();
		this.add(shapeContainer);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 400);
		this.setVisible(true);
	}

	public void createMenue() {
		JMenu menu = new JMenu("Modes");
		createMenuItem(menu, "Insert Circle", e -> shapeContainer.setMode(ShapeContainer.Mode.INSERT));
		createMenuItem(menu, "Insert Rectangle", e -> shapeContainer.setMode(ShapeContainer.Mode.INSERT2));
		createMenuItem(menu, "Move", e -> shapeContainer.setMode(ShapeContainer.Mode.MOVE));
		createMenuItem(menu, "Delete", e -> shapeContainer.setMode(ShapeContainer.Mode.DELETE));
		createMenuItem(menu, "Mark Fill", e -> shapeContainer.setMode(ShapeContainer.Mode.MARK));
		createMenuItem(menu, "Mark Crosshair", e -> shapeContainer.setMode(ShapeContainer.Mode.MARK2));
		createMenuItem(menu, "Mark Dinosaur", e -> shapeContainer.setMode(ShapeContainer.Mode.MARK3));
		createMenuItem(menu, "Unmark", e -> shapeContainer.setMode(ShapeContainer.Mode.UNMARK));
		createMenuItem(menu, "Resize", e -> shapeContainer.setMode(ShapeContainer.Mode.RESIZE));
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(menu);
		this.setJMenuBar(menuBar);
	}

	private void createMenuItem(JMenu menu, String label, ActionListener listener) {
		JMenuItem menuItem = new JMenuItem(label);
		menuItem.addActionListener(listener);
		menuItem.setHorizontalAlignment(SwingConstants.LEFT);
		menu.add(menuItem);
	}

}
