import java.awt.Color;
import java.awt.Graphics;

public class ShapeDecoratorCrosshair implements Shape {

	private Shape decoratee;

	public ShapeDecoratorCrosshair(Shape decoratee) {
		this.decoratee = decoratee;
	}

	@Override
	public void draw(Graphics g) {
		decoratee.draw(g);
		Point position = decoratee.getPosition();

		int x1 = (int) (position.getX() - (decoratee.getWidth() / 2) + 0.5);
		int y1 = (int) (position.getY() + 0.5);

		int x2 = (int) (position.getX() + (decoratee.getWidth() / 2) + 0.5);
		int y2 = (int) (position.getY() + 0.5);

		int x3 = (int) (position.getX() + 0.5);
		int y3 = (int) (position.getY() - (decoratee.getHeight() / 2) + 0.5);

		int x4 = (int) (position.getX() + 0.5);
		int y4 = (int) (position.getY() + (decoratee.getHeight() / 2) + 0.5);

		g.setColor(Color.GREEN);
		g.drawLine(x1, y1, x2, y2);
		g.drawLine(x3, y3, x4, y4);
		g.setColor(Color.BLACK);

		/*
		 * int x = (int) (position.getX() - decoratee.getWidth() / 2.0 + 0.5); int y =
		 * (int) (position.getY() - decoratee.getHeight() / 2.0 + 0.5); g.fillOval(x, y,
		 * (int) (decoratee.getWidth() + 0.5), (int) (decoratee.getHeight() + 0.5));
		 */

		// TODO: Draw crosshair on top off shape
	}

	@Override
	public Point getPosition() {
		return decoratee.getPosition();
	}

	@Override
	public double getWidth() {
		return decoratee.getWidth();
	}

	@Override
	public double getHeight() {
		return decoratee.getHeight();
	}

	@Override
	public boolean intersects(Point point) {
		return decoratee.intersects(point);
	}

	@Override
	public void moveTo(Point point) {
		decoratee.moveTo(point);
	}

	@Override
	public void move(double dx, double dy) {
		decoratee.move(dx, dy);
	}

	@Override
	public void resizeTo(Point point) {
		decoratee.resizeTo(point);
	}

	@Override
	public Shape peel() {
		return decoratee;
	}

}
