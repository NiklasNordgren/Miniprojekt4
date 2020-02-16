

public class StateMarkCrosshair extends State{

	private static StateMarkCrosshair instance = null;

	private StateMarkCrosshair() {
	}

	public void pointerDown(Point point, ShapeContainer moder) {
		moder.select(point);
		if (moder.selected != null) {
			Shape markedShape = new ShapeDecoratorCrosshair(moder.selected);
			moder.getShapes().remove(moder.selected);
			moder.getShapes().add(markedShape);
			moder.repaint();
		}
	}

	public static StateMarkCrosshair getInstance() {

		if (instance == null)
			instance = new StateMarkCrosshair();
		return instance;

	}
}
