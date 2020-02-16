import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;

public class ShapeContainer extends JPanel  { // ska ej implementa pointable
	private static final long serialVersionUID = 1L;
	private List<Shape> shapes = new LinkedList<Shape>();
	//StateInsert stateA = new StateInsert(this);
	//private State state;


	public enum Mode {
		INSERT, MOVE, DELETE, MARK, UNMARK, RESIZE
	};

	private Mode mode = Mode.INSERT;
	public Shape selected;

	public ShapeContainer() {
		super();
		MouseHandler mouseHandler = new MouseHandler();
		this.addMouseListener(mouseHandler);
		this.addMouseMotionListener(mouseHandler);
		this.setBackground(Color.white);
	
	}

	public void addShape(Shape shape) {
		getShapes().add(shape);
	}

	public void paintComponent(Graphics g) // anropas av Swing nÃ¤r det Ã¤r dags att
											// rendera
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

	public void pointerDown(Point point) { // här ska det vara att varje state sköter sin grej av pointerDown

		System.out.println("jolawf");
		State.getState().pointerDown();
		System.out.println(State.getState());
		// stateA.pointerDown(point);

		if (mode == Mode.MOVE)
			select(point);
		else if (mode == Mode.DELETE) {

		} else if (mode == Mode.MARK) {
			select(point);
			if (selected != null) {
				Shape markedShape = new ShapeDecorator(selected);
				getShapes().remove(selected);
				getShapes().add(markedShape);
				repaint();
			}
		} else if (mode == Mode.UNMARK) {
			select(point);
			if (selected != null) {
				Shape unmarkedShape = selected.peel();
				getShapes().remove(selected);
				getShapes().add(unmarkedShape);
				repaint();
			}
		} else if (mode == Mode.RESIZE) {
			select(point);
		}
	}

	public void pointerUp(Point point) {
		selected = null;
	}

	public void pointerMoved(Point point, boolean pointerDown) {
		if (selected != null && pointerDown) {
			if (mode == Mode.MOVE) {
				selected.moveTo(point);
				repaint(); // uppmanar swing att mÃ¥la om
			} else if (mode == Mode.RESIZE) {
				selected.resizeTo(point);
				repaint();
			}
		}
	}

	// här ska state grej komma
	public void setMode(Mode mode) {
		this.mode = mode;
	}
	public void setState(State newState) {
		State.setState(newState);
	}

	public List<Shape> getShapes() {
		return shapes;
	}
}
