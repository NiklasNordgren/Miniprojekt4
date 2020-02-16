import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class ShapeApp extends JFrame {
	private static final long serialVersionUID = 1L;
	private ShapeContainer shapeContainer = new ShapeContainer();

	public ShapeApp() {
		createMenue();
		this.add(shapeContainer);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 400);
		this.setVisible(true);
	}

	public void createMenue() {
		JMenu menu = new JMenu("Modes");
		createMenuItem(menu, "Insert", e -> shapeContainer.setState(StateInsert.getInstance()));
		createMenuItem(menu, "Move", e -> shapeContainer.setState(StateMove.getInstance()));
		createMenuItem(menu, "Delete", e -> shapeContainer.setState(StateDelete.getInstance()));
		createMenuItem(menu, "Mark", e -> shapeContainer.setState(StateMark.getInstance()));
		createMenuItem(menu, "Unmark", e -> shapeContainer.setState(StateUnmark.getInstance()));
		createMenuItem(menu, "Resize", e -> shapeContainer.setState(StateResize.getInstance()));
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(menu);
		this.setJMenuBar(menuBar);
	}

	private void createMenuItem(JMenu menu, String label, ActionListener listener) {
		JMenuItem menuItem = new JMenuItem(label);
		menuItem.addActionListener(listener);
		menu.add(menuItem);
	}
}
