import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseHandler implements MouseListener, MouseMotionListener {
	private Pointable pointable = new Pointable() { //?? fkn questionable

		@Override
		public void pointerUp(Point point) {
			// TODO Auto-generated method stub

		}

		@Override
		public void pointerMoved(Point point, boolean pointerDown) {
			// TODO Auto-generated method stub

		}

		@Override
		public void pointerDown(Point point) {
			// TODO Auto-generated method stub

		}
	};

	public MouseHandler() { // tog in pointable innan
		
		this.pointable = pointable;
	}

	public void mouseDragged(MouseEvent e) {
		pointable.pointerMoved(new Point(e.getX(), e.getY()), true);
	}

	public void mouseMoved(MouseEvent e) {
		pointable.pointerMoved(new Point(e.getX(), e.getY()), false);
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
		pointable.pointerDown(new Point(e.getX(), e.getY()));
	}

	public void mouseReleased(MouseEvent e) {
		pointable.pointerUp(new Point(e.getX(), e.getY()));
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}
}
