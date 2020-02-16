import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ShapeDecoratorDino implements Shape {

	private Shape decoratee;

	private BufferedImage image;

	public ShapeDecoratorDino(Shape decoratee) {
		this.decoratee = decoratee;

		try {
			image = ImageIO.read(new File("images\\dino.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void draw(Graphics g) {
		decoratee.draw(g);
		Point position = decoratee.getPosition();

		int x = (int) (position.getX() - decoratee.getWidth() / 2 + 0.5);
		int y = (int) (position.getY() - decoratee.getHeight() / 2 + 0.5);

		Image tmp = image.getScaledInstance((int) decoratee.getWidth(), (int) decoratee.getHeight(),
				Image.SCALE_SMOOTH);

		g.drawImage(tmp, x, y, null);

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
