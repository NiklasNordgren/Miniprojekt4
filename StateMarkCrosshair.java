

public class StateMarkCrosshair extends State{

	private static StateMarkCrosshair instance = null;

	private StateMarkCrosshair() {
	}

	public void pointerDown(Point point, ShapeContainer mother) {
		mother.select(point);
		if (mother.selected != null) {
			Shape markedShape = new ShapeDecoratorCrosshair(mother.selected);
			mother.getShapes().remove(mother.selected);
			mother.getShapes().add(markedShape);
			mother.repaint();
		}
	}

	public static StateMarkCrosshair getInstance() {

		if (instance == null)
			instance = new StateMarkCrosshair();
		return instance;

	}
}
