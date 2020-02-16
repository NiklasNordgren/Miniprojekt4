import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JPanel;


public class ShapeContainer extends JPanel implements Pointable { // ska ej implementa pointable
	private static final long serialVersionUID = 1L;
	private List<Shape> shapes = new LinkedList<Shape>();
	public Shape selected;

	public enum Mode {
		INSERT, INSERT2, MOVE, DELETE, MARK, MARK2, MARK3, UNMARK, RESIZE
	};

	private Mode mode = Mode.INSERT;


	public ShapeContainer() {
		super();
		MouseHandler mouseHandler = new MouseHandler(this);
		this.addMouseListener(mouseHandler);
		this.addMouseMotionListener(mouseHandler);
		this.setBackground(Color.white);

		setState(StateInsertCirle.getInstance());
	}

	public void addShape(Shape shape) {
		getShapes().add(shape);
	}

	public void paintComponent(Graphics g) // anropas av Swing nÃ¤r det Ã¤r dags att rendera
	{
		super.paintComponent(g);
		for (Shape shape : getShapes())
			shape.draw(g);

	}

	public void select(Point point) {
		for (Shape shape : shapes) {
			if (shape.intersects(point)) {
				selected = shape;
				return;
			}
		}
	}

	public void pointerDown(Point point) { 
		State.getState().pointerDown(point, this);

	 if (mode == Mode.MARK2) {
			select(point);
			if (selected != null) {
				Shape markedShape = new ShapeDecoratorCrosshair(selected);
				shapes.remove(selected);
				shapes.add(markedShape);
				repaint();
			}
		} else if (mode == Mode.MARK3) {
			select(point);
			if (selected != null) {
				Shape markedShape = new ShapeDecoratorDino(selected);
				shapes.remove(selected);
				shapes.add(markedShape);
				repaint();
			}
		} else if (mode == Mode.INSERT2) {
			shapes.add(new Rectangle(point, Math.random() * 100.0, Math.random() * 100.0));
			repaint();
		}

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
	public void setMode(Mode mode) {
		
	}
}
