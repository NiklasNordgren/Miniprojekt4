

public class StateMarkDinosaur extends State{

	private static StateMarkDinosaur instance = null;

	private StateMarkDinosaur() {
	}

	public void pointerDown(Point point, ShapeContainer moder) {
		moder.select(point);
		if (moder.selected != null) {
			Shape markedShape = new ShapeDecoratorDino(moder.selected);
			moder.getShapes().remove(moder.selected);
			moder.getShapes().add(markedShape);
			moder.repaint();
		}
	}

	public static StateMarkDinosaur getInstance() {

		if (instance == null)
			instance = new StateMarkDinosaur();
		return instance;

	}

}
