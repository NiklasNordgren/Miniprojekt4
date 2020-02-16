import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;

public class ShapeContainer extends JPanel implements Pointable { // ska ej implementa pointable
	private static final long serialVersionUID = 1L;
	private List<Shape> shapes = new LinkedList<Shape>();
	public Shape selected;

	public ShapeContainer() {
		super();
		MouseHandler mouseHandler = new MouseHandler(this);
		this.addMouseListener(mouseHandler);
		this.addMouseMotionListener(mouseHandler);
		this.setBackground(Color.white);
		setState(StateInsert.getInstance());
	}

	public void addShape(Shape shape) {
		getShapes().add(shape);
	}

	public void paintComponent(Graphics g) // anropas av Swing när det är dags att rendera
	{
		super.paintComponent(g);
		for (Shape shape : getShapes())
			shape.draw(g);

	}

	public void select(Point point) {
		for (Shape shape : getShapes()) {
			if (shape.intersects(point)) {
				selected = shape;
				return;
			}
		}
	}

	public void pointerDown(Point point) { 
		State.getState().pointerDown(point, this);
	}

	public void pointerUp(Point point) {
		selected = null;
	}

	public void pointerMoved(Point point, boolean pointerDown) {
		State.getState().pointerMoved(point, this, pointerDown);
	}

	public void setState(State newState) {
		State.setState(newState);
	}

	public List<Shape> getShapes() {
		return shapes;
	}
}
