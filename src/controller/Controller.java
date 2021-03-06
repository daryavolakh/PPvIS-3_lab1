package controller;

import model.Field;
import model.World;

public class Controller {
	private World world;

	public Controller(World world) {
		this.world = world;
	}

	public void createWorld() {
		world.generateWorld();
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
	
	public void checkLeftForJump(int x, int y) {
		world.checkLeftForJump(x, y);
	}
	
	public void checkRightForJump(int x, int y) {
		world.checkRightForJump(x, y);
	}

	public void checkTopForJump(int x, int y) {
		world.checkTopForJump(x, y);
	}
	
	public void checkBottomForJump(int x, int y) {
		world.checkBottomForJump(x, y);
	}

	public void moveSecurity() {
		world.moveSecurity();
	}

	public void updateWorld() {
		world.update();
	}

	public boolean isPrisonerWin() {
		return world.isPrisonerWin();
	}

	public boolean isPrisonerLoose() {
		return world.isPrisonerLoose();
	}

	public Boolean prisonerWinGame() {
		return world.prisonerWinGame();
	}

	public int getLevel() {
		return world.getLevel();
	}
	
	public void hitRLSecurity(int x, int y) {
		world.hitRLSecurity(x, y);
	}
	
	public void hitBTSecurity(int x, int y) {
		world.hitBTSecurity(x, y);
	}
	
	public void securityLoseAttention() {
		world.securityLoseAttention();
	}
}
