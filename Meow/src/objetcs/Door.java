package objetcs;

public class Door extends Object {
	
	private boolean open;

	public Door(int positionX, int positionY, int width, int height) {
		super(positionX, positionY, width, height);
	}

	public boolean isOpen() {
		return open;
	}

}
