import java.awt.Graphics;

public class Rectangle implements Shape {

	private Point center;
	private double width, height;
	private java.awt.Rectangle rect;

	public Rectangle(Point point, double width, double height) {

		center = point;
		this.width = width;
		this.height = height;

		rect = new java.awt.Rectangle();
		rect.setBounds((int) (center.getX() - width / 2 + 0.5), (int) (center.getY() - height / 2 + 0.5), (int) width,
				(int) height);
	}

	@Override
	public void draw(Graphics g) {
		g.drawRect((int) rect.getX(), (int) rect.getY(), (int) rect.getWidth(), (int) rect.getHeight());
	}

	@Override
	public Point getPosition() {
		return center;
	}

	@Override
	public double getWidth() {
		return width;
	}

	@Override
	public double getHeight() {
		return height;
	}

	@Override
	public boolean intersects(Point point) {
		return rect.contains(point.getX(), point.getY());
	}

	@Override
	public void moveTo(Point point) {
		center.moveTo(point);
	}

	@Override
	public void move(double dx, double dy) {
		center.move(dx, dy);
	}

	@Override
	public void resizeTo(Point point) {
		height = center.distanceTo(point);
		width = center.distanceTo(point);
	}

	@Override
	public Shape peel() {
		return this;
	}

}
