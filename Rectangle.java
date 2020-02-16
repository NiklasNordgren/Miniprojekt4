import java.awt.Graphics;

public class Rectangle implements Shape {

	private Point center;
	private double width, height;

	public Rectangle(Point point, double width, double height) {
		center = point;
		this.width = width;
		this.height = height;
	}

	@Override
	public void draw(Graphics g) {
		g.drawRect((int) center.getX(), (int) center.getY(), (int) this.getWidth(), (int) this.getHeight());
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
		return intersectsX(point) && intersectsY(point);
	}

	private boolean intersectsX(Point point) {
		return (point.getX() <= center.getX() + this.getWidth() / 2)
				&& (point.getX() >= center.getX() - this.getHeight() / 2);
	}

	private boolean intersectsY(Point point) {
		return (point.getY() <= center.getY() + this.getHeight() / 2)
				&& (point.getY() >= center.getY() - this.getHeight() / 2);
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
