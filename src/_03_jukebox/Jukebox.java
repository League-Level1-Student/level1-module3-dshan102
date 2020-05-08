package _03_jukebox;
/*
 *    Copyright (c) The League of Amazing Programmers 2013-2019
 *    Level 1
 */


import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javazoom.jl.player.advanced.AdvancedPlayer;

/*   If you don't have javazoom.jar in your project, you can download it from here: http://bit.ly/javazoom
 *   Right click your project and add it as a JAR (Under Java Build Path > Libraries).*/

public class Jukebox implements Runnable, ActionListener {
Song song1;
Song song2;
Song song3;
JButton button1;
JButton button2;
JButton button3;

    public void run() {

		// 1. Find an mp3 on your computer or on the Internet.
		// 2. Create a Song object for that mp3
    	song1 = new Song("Crisp_Ocean_Waves-Mike_Koenig-1486046376.mp3");
    	song1.setDuration(10);
    	song2 = new Song("rainforest_ambience-GlorySunz-1938133500.mp3");
    	song2.setDuration(10);
    	song3 = new Song("Atomic_Bomb-Sound_Explorer-897730679.mp3");
    	song3.setDuration(10);

		// 3. Play the Song
		/*
		 * 4. Create a user interface for your Jukebox so that the user can to
		 * choose which song to play. You can use can use a different button for
		 * each song, or a picture of the album cover. When the button or album
		 * cover is clicked, stop the currently playing song, and play the one
		 * that was selected.
		 */
    	JFrame frame = new JFrame("Jukebox");
    	frame.setVisible(true);
    	JPanel panel = new JPanel();
    	JLabel label = new JLabel();
    	button1 = new JButton("Ocean");
    	button1.addActionListener(this);
    	button2 = new JButton("Rainforest");
    	button2.addActionListener(this);
    	button3 = new JButton("Quiet Noise: Play at high volume");
    	button3.addActionListener(this);
    	frame.add(panel);
    	panel.add(button1);
    	panel.add(button2);
    	panel.add(button3);
    	frame.pack();
    	frame.setSize(400, 200);
    }
    
    
	/* Use this method to add album covers to your Panel. */
	private JLabel loadImage(String fileName) {
		URL imageURL = getClass().getResource(fileName);
		Icon icon = new ImageIcon(imageURL);
		return new JLabel(icon);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==button1) {
			song2.stop();
			song3.stop();
			song1.play();
		}
		else if(e.getSource()==button2) {
			song1.stop();
			song3.stop();
			song2.play();
		}
		else if(e.getSource()==button3) {
			song1.stop();
			song2.stop();
			song3.play();
		}
	}

}

class Song {

	private int duration;
	private String songAddress;
	private AdvancedPlayer mp3Player;
	private InputStream songStream;

	/**
	 * Songs can be constructed from files on your computer or Internet
	 * addresses.
	 * 
	 * Examples: <code> 
	 * 		new Song("everywhere.mp3"); 	//from default package 
	 * 		new Song("/Users/joonspoon/music/Vampire Weekend - Modern Vampires of the City/03 Step.mp3"); 
	 * 		new	Song("http://freedownloads.last.fm/download/569264057/Get%2BGot.mp3"); 
	 * </code>
	 */
	public Song(String songAddress) {
		this.songAddress = songAddress;
	}

	public void play() {
		loadFile();
		if (songStream != null) {
			loadPlayer();
			startSong();
		} else
			System.err.println("Unable to load file: " + songAddress);
	}

	public void setDuration(int seconds) {
		this.duration = seconds * 100;
	}

	public void stop() {
		if (mp3Player != null)
			mp3Player.close();
	}

	private void startSong() {
		Thread t = new Thread() {
			public void run() {
				try {
					if (duration > 0)
						mp3Player.play(duration);
					else
						mp3Player.play();
				} catch (Exception e) {
				}
			}
		};
		t.start();
	}

	private void loadPlayer() {
		try {
			this.mp3Player = new AdvancedPlayer(songStream);
		} catch (Exception e) {
		}
	}

	private void loadFile() {
		if (songAddress.contains("http"))
			this.songStream = loadStreamFromInternet();
		else
			this.songStream = loadStreamFromComputer();
	}

	private InputStream loadStreamFromInternet() {
		try {
			return new URL(songAddress).openStream();
		} catch (Exception e) {
			return null;
		}
	}

	private InputStream loadStreamFromComputer() {
		try {
			return new FileInputStream(songAddress);
		} catch (FileNotFoundException e) {
			return this.getClass().getResourceAsStream(songAddress);
		}
	}
}

