/**
 * 
 */
package memorystore;

/**
 * @author Manasi Surwade
 *
 */

import java.util.*;

public class Store {

	/**
	 * @param args
	 */

	private int capacity;
	private LinkedHashMap<String, LinkedList<String>> userSongsList;

	/**
	 * Function to initialize the Memory Store - logic can also be used in
	 * constructor
	 * 
	 * @param capacity : initial capacity of inMemory store
	 */

	public void InitializeStore(int capacity) {
		this.capacity = capacity;
		this.userSongsList = new LinkedHashMap<>();
	}

	/**
	 * Function to add new song in playlist - as currently playing song Add new song
	 * if capacity exist or remove least recently played song
	 * 
	 * @param SongName: Song Name
	 * @param userName: User playing song wrt his/her playlist
	 * 
	 */

	public void playSong(String userName, String SongName) {
		LinkedList<String> UserSongs = userSongsList.getOrDefault(userName, new LinkedList<>());

		this.addSongInPlayList(UserSongs, SongName, userName);

		this.checkStoreCapacity(UserSongs, userName);

		userSongsList.put(userName, UserSongs);
		showPlaylist(userName);
	}

	/**
	 * Function to print recently played songs playlist using user's name
	 * 
	 * @param userName: User playing song wrt his/her playlist
	 */

	public void showPlaylist(String userName) {
//    	System.out.println("\n");
		System.out.println("Playlist -> " + getUsersSongsPlaylist(userName));
		System.out.println("\n");
	}

	/**
	 * Function to add new song or update song in playlist if already exist
	 * 
	 * @param userName: User playing song wrt his/her playlist
	 * @param userSongs: Songs list of a user
	 * @param songName: song to be added in playlist
	 */

	public void addSongInPlayList(LinkedList<String> userSongs, String songName, String userName) {

		// Remove song from the playlist if already exist
		int songIndex = userSongs.indexOf(songName);

		if (songIndex > -1) {
			userSongs.remove(songName);
			System.out.println("Updating song in playlist :" + songName);
		}

		// Add or Update the new song in playlist at the end of it
		userSongs.addLast(songName);
		if (songIndex == -1) {
			System.out.println("Addig new song: " + songName);
		}

	}

	/**
	 * Function to check the capacity to add new song and if not then removing the
	 * least recently played song
	 * 
	 * @param userName: User playing song wrt his/her playlist
	 * @param userSongs: Songs list of a user
	 */

	public void checkStoreCapacity(LinkedList<String> userSongs, String userName) {

		// Check if Songs list is trying to add more than capacity and remove the least
		// recently played song
		if (userSongs.size() > capacity) {
			// Remove the least recently played song from start of the list
			String removedSong = userSongs.removeFirst();
			System.out.println("Removing least recently played song: " + removedSong);
//        	showPlaylist(userName);
		}
	}

	/**
	 * Function to get songs from memory store using user's name
	 * 
	 * @param userName: User playing song wrt his/her playlist
	 * @return Songslist
	 */

	public LinkedList<String> getUsersSongsPlaylist(String userName) {
		LinkedList<String> songsPlaylist = userSongsList.getOrDefault(userName, new LinkedList<>());
		return songsPlaylist;
	}

}
