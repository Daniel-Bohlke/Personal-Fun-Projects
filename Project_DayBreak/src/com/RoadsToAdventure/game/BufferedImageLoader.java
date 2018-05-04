package com.RoadsToAdventure.game;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BufferedImageLoader {

	
	private BufferedImage image;
	
	public BufferedImage loadImage(String path){
		try {
			this.image = ImageIO.read(getClass().getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return this.image;
	}
}
