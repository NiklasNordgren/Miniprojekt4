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

		int x1 = (int) (position.getX() + 0.5);
		int y1 = (int) (position.getY() + 0.5);

		g.drawLine(x1, y1, x1 + 50, y1 + 50);

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
