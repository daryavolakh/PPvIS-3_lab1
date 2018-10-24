package controller;

import model.Field;
import model.World;
import model.WorldSecondLevel;

public class Controller {
	private World world;
	public Controller(World world) {
		this.world = world;
	}
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
	
	public void checkLeft(int x, int y) {
		world.checkLeft(x, y);
	}
	
	public void checkRight(int x, int y) {
		world.checkRight(x, y);
	}
	
	public void checkTop(int x, int y) {
		world.checkTop(x, y);
	}
	
	public void checkBottom(int x, int y) {
		world.checkBottom(x, y);
	}
	
	public void moveSecurity()
	{
		world.moveSecurity(); 
	}
	
	public void updateWorld() {
		world.update();
	}
	
	public void startNextLevel() {
		
	}
	
	public boolean isPrisonerWin() {
		return world.isPrisonerWin();
	}
	
	public boolean isPrisonerLoose() {
		return world.isPrisonerLoose();
	}
	
	public void createWorldForSecondLevel() {
		world = new WorldSecondLevel();
	}
}
