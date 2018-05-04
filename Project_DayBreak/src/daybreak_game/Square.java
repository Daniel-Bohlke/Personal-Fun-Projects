package daybreak_game;

import daybreak_model.CharacterClass;

/**
 * 
 * @author Daniel Bohlke
 *
 */
public class Square {

	//Lets us know if the Square is Occupied
	private boolean occupied;
	//Keeps track of whether the Square is Accessible or not
	private boolean inaccessible;
	//Holds the value of whatever Character is in the Square
	public CharacterClass character;
	
	Square(boolean occupied, boolean inaccessible, CharacterClass character){
		this.inaccessible = inaccessible;
		if(!inaccessible){
			this.occupied = occupied;
			if(occupied){
				this.character = character;
			}
			else{
				this.character = null;
			}
		}
		else{
			this.character = null;
		}
	}
	
	public boolean isOpen(){
		if((inaccessible == false) && occupied == false && character == null){
			return true;
		}
		return false;
	}

	/**
	 * @return the occupied
	 */
	public boolean isOccupied() {
		return occupied;
	}

	/**
	 * @param occupied the occupied to set
	 */
	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}

	/**
	 * @return the inaccessible
	 */
	public boolean isInaccessible() {
		return inaccessible;
	}

	/**
	 * @param inaccessible the inaccessible to set
	 */
	public void setInaccessible(boolean inaccessible) {
		this.inaccessible = inaccessible;
	}

	/**
	 * @return the character
	 */
	public CharacterClass getCharacter() {
		return character;
	}

	/**
	 * @param character the character to set
	 */
	public void setCharacter(CharacterClass character) {
		this.character = character;
	}
	
	
}
