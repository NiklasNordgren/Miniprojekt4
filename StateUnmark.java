

public class StateUnmark extends State {
	
	private static StateUnmark instance = null;

	private StateUnmark() {
	}

	public void pointerDown(Point point, ShapeContainer mother) {
		mother.select(point);
		if (mother.selected != null) {
			Shape unmarkedShape = mother.selected.peel();
			mother.getShapes().remove(mother.selected);
			mother.getShapes().add(unmarkedShape);
			mother.repaint();
		}
	}

	public static StateUnmark getInstance() {

		if (instance == null)
			instance = new StateUnmark();
		return instance;

	}
}
