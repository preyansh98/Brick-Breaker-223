package ca.mcgill.ecse223.block.view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import ca.mcgill.ecse223.block.controller.InvalidInputException;



public class UserEntryListener implements KeyListener {

	/**
	 * 'String input from keyboard - marked as volatile since it is shared by two
	 * threads
	 */
	private volatile String keyString = "";
	private boolean keyA=false;
	private boolean keyD=false;
	private boolean keyL=false;
	private boolean keyR=false;
	@Override
	public synchronized void keyPressed(KeyEvent e) {
		int location = e.getKeyCode();
		if (location == KeyEvent.VK_LEFT) {
			keyL=true;
		} else if (location == KeyEvent.VK_RIGHT) {
			keyR=true;
		}  else if (location == KeyEvent.VK_A){
			keyA=true;
		}else if (location == KeyEvent.VK_D) {
			keyD=true;
		} else {
			if (location == KeyEvent.VK_SPACE) {
				keyString += " ";
			}
		}
		/*
		 * try { keyInputs(e); } catch (InvalidInputException e1) {
		 * System.out.print(e1); }
		 */
	}

	private synchronized String keyInputs(KeyEvent e) throws InvalidInputException {
		int location = e.getKeyCode();
		if (keyL) {
			keyString += "l";
		} 
		if (keyR) {
			keyString += "r";
		} 
		if (location == KeyEvent.VK_SPACE) {
			keyString += " ";
		} 
		if (keyA){
			keyString+="a";
		}
		if (keyD) {
			keyString+="d";
		} 
		return keyString;
	}

	/**
	 * Takes key inputs and clears the input string. marked as synchronized to make
	 * the key inputs as thread-safe
	 */
	public synchronized String takeInputs() {
		String passString = keyString;
		keyString = "";
		if (passString.contains(" ")) {
			return passString;
		}else {
			if (keyL) {
				passString += "l";
			} 
			if (keyR) {
				passString += "r";
			} 
			if (keyA){
				passString+="a";
			}
			if (keyD) {
				passString+="d";
			} 
		}
		
		return passString;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int location = e.getKeyCode();
		if (location == KeyEvent.VK_LEFT) {
			keyL=false;
		} else if (location == KeyEvent.VK_RIGHT) {
			keyR=false;
		}  else if (location == KeyEvent.VK_A){
			keyA=false;
		}else if (location == KeyEvent.VK_D) {
			keyD=false;
		} else {
			// ignore all other keys
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	
}

