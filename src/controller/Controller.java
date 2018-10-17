package controller;

import model.Field;
import model.World;

public class Controller {

	World world;

	public void createWorld() {
		world = new World();
	}

	public Field getField(int x, int y) {
		return world.getField(x, y);
	}

	public boolean isFieldDoor(int x, int y) {
		return world.isFieldDoor(x, y);
	}

	public boolean isFieldSecurity(int x, int y) {
		return world.isFieldSecurity(x, y);
	}

	public boolean isFieldHuman(int x, int y) {
		return world.isFieldHuman(x, y);
	}

	public void movePrisoner(int deltaX, int deltaY) {
		world.movePrisoner(deltaX, deltaY);
	}
	
	public void moveSecurity()
	{
		world.moveSecurity(); 
	}
	
	public void updateWorld() {
		world.update();
	}
	/*
	 * public Circle createSecurity(Color color) { security = new Human(color);
	 * return security.getHuman(); }
	 * 
	 * public Circle getSecurity() { return security.getHuman(); }
	 * 
	 * public Circle createPrisoner(Color color) { prisoner = new Human(color);
	 * return prisoner.getHuman();
	 * 
	 * }
	 * 
	 * public Circle getPrisoner() { return security.getHuman(); }
	 */
}
