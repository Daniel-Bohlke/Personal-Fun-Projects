package com.RoadsToAdventure.model;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

/**
 * 
 * @author Daniel Bohlke
 *
 */
public class Civilian extends NPC{
	
	public Civilian(int x, int y) {super(x, y);}

	public Civilian(int lvl, int x, int y){
		super(lvl, y, x);
	}
	
	@Override
	public String interact(Player player) {
		setTalk(getDialogue());
		return getTalk();
	}
	
	public String getDialogue(){
	String speech = null;
	Random rand = new Random(System.currentTimeMillis());
	int n = rand.nextInt(50) + 1;
	switch(n){
	case 1:	speech = "Are you a Boy or a Girl?";
		break;
	case 2:	speech = "My Milkshakes are better than yours.";
		break;
	case 3:	speech = "\"Wise men speak because they have something to say.\nFools speak because they have to say something.\"";
		break;
	case 4: speech = "I am looking 4ward 2 finding the meaning of life one day!";
		break;
	case 5: speech = "Omae wa, mo shindeiru.";
		break;
	case 6: speech = "Help me I'm lost!";
		break;
	case 7: speech = "Roads to Adventure? Sounds cheesy.";
		break;
	case 8: speech = "Excuse me! I'm trying to nap over here!";
		break;
	case 9: speech = "I wanna know what love is.";
		break;
	case 10: speech = "I want you to show me.";
		break;
	case 11: speech = "I used to be an adventurer like you.. But then I stopped playing crappy video games!";
		break;
	case 12: speech = "Go to Heaven for the climate, and Hell for the company.";
		break;
	case 13: speech = "How long have I been here?";
		break;
	case 14: speech = "Go away.";
		break;
	case 15: speech = "Where's my dog?!";
		break;
	case 16: speech = "Hey don't touch me there!";
		break;
	case 17: speech = "Why are you just staring at me?";
		break;
	case 18: speech = "Winter is coming.";
		break;
	case 19: speech = "I'm an idiot, Dan";
		break;
	case 20: speech = "I don't know, I don't know, I don't know...";
		break;
	case 21: speech = "They're finally making a play about clocks! It's about time!";
		break;
	case 22: speech = "I'm dead inside...";
		break;
	case 23: speech = "I can show you the world!";
		break;
	case 24: speech = "I am God.";
		break;
	case 25: speech = "AH! Oh sorry... I thought you were a monster.";
		break;
	case 26: speech = "WOAAAAAH WE'RE HALFWAY THEEEERE!";
		break;
	case 27: speech = "*cue Rick Astley's Never Gonna Give You Up*";
		break;
	case 28: speech = "I like you";
		break;
	case 29: speech = "Please love me.";
		break;
	case 30: speech = "It's 10 years too soon for you to fight me!";
		break;
	case 31: speech = "I want to go home.";
		break;
	case 32: speech = "Where am I?";
		break;
	case 33: speech = "Hey Randal is that you?! Long time no se... Oh nevermind";
		break;
	case 34: speech = "Tip: Did you know that you can instantly level up by hitting your head on your keyboard?";
		break;
	case 35: speech = "Tip: Don't forget to stock up on healing potions when you're in town!";
		break;
	case 36: speech = "Tip: Don't fight the final boss if you arent at least level 70!";
		break;
	case 37: speech = "Tip: Training can be done easily by fighting monsters less than or equal to your own level!";
		break;
	case 38: speech = "They say you can climb the Northern Mountains if you get some special climbing gear..\n But where would you get something like that?";
		break;
	case 39: speech = "Tip: Finding Quest Givers is a good way to get Gold!";
		break;
	case 40: speech = "Please save me, I'm trapped in this game!!!";
		break;
	case 41: speech = "How many times are you going to talk to me? Geez get a life.";
		break;
	case 42: speech = "I am definitely not a thief..";
		break;
	case 43: speech = "I have a dream.. No wait I'm just non-sentient code.";
		break;
	case 44: speech = "I've heard if you find a cave you should stay away! Monsters like to lurk in there.";
		break;
	case 45: speech = "Tip: Caves: Caves can be a gamble, if you encounter a cave you will fight a series of strong monsters.\n However, If you can survive you will get a rare reward!";
		break;
	case 46: speech = "I believe I can fly";
		break;
	case 47: speech = "I haven't bathed in 3 days";
		break;
	case 48: speech = "\"The unexamined life is not worth living\" a wise man once said this to me.";
		break;
	case 49: speech = "\"There is only one good, Knowledge, and one evil, Ignorance.\"";
		break;
	case 50: speech = "Let's gather 'round the campfire and sing our campfire song! Our C-A-M-P-F-I... (You walked away)";
		break;
	}
	setTalk(speech);
	return getTalk();
	}


}
