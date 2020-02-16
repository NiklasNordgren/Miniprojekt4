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

		createMenuItem(menu, "Insert Circle", e -> shapeContainer.setState(StateInsertCirle.getInstance()));
		createMenuItem(menu, "Insert Rectangle", e -> shapeContainer.setState(StateInsertRectangle.getInstance()));
		createMenuItem(menu, "Mark Fill", e -> shapeContainer.setState(StateMark.getInstance()));
		createMenuItem(menu, "Mark Dinosaur", e -> shapeContainer.setState(StateMarkDinosaur.getInstance()));
		createMenuItem(menu, "Mark Crosshair", e -> shapeContainer.setState(StateMarkCrosshair.getInstance()));
		createMenuItem(menu, "Unmark", e -> shapeContainer.setState(StateUnmark.getInstance()));
		createMenuItem(menu, "Resize", e -> shapeContainer.setState(StateResize.getInstance()));
		createMenuItem(menu, "Move", e -> shapeContainer.setState(StateMove.getInstance()));
		createMenuItem(menu, "Delete", e -> shapeContainer.setState(StateDelete.getInstance()));

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
