/**
 *  _Assessment Definition_ :  Create an in-memory store for recently played songs 
 *  that can accommodate N songs per user, with a fixed initial capacity. 
 *  This store must have the capability to store a list of song-user pairs, 
 *  with each song linked to a user. It should also be able to fetch recently played songs,
 *  based on the user and eliminate the least recently played songs
 *  when the store becomes full.
 *  
 *  _Approach_ : To maintain the User-Songs relation we are using combination of Hashmap and Linkedlist as LinkedHashMap
 *  
 *  _Synopsis_ :
 *  	- Songs list is stored in LHMap wrt username
 *  	- For each songs entry checking the capacity of store wrt initialized limit
 *  	- Case if user played existing song -- it should be updated
 *  	- Fetching songs list using username
 *  	- Added two static user Manasi and Kunal for testing 2 cases
 *  		- If user (~Manasi) play/add new song above capacity
 *  		- If user (~Kunal)  play already existing song from playlist
 */

package memorystore;

/**
 * @author Manasi Surwade
 *
 */

public class SongsPlayer {

	public static void songsListHeader(String userName) {

		System.out.println("\n");
		System.out.println("---------------------------------------------------------------------------------");
		System.out
				.println("-                         " + userName + "'s Playlist                                     -");
		System.out.println("---------------------------------------------------------------------------------");
	}

	public static void main(String[] args) {

		Store UserMusicStore = new Store();

		// Create new Music Store for User Manasi with initial Capacity of 3 songs
		UserMusicStore.InitializeStore(3);

		songsListHeader("Manasi");

		// Play song to get added in play list
		UserMusicStore.playSong("Manasi", "Song 1");
		UserMusicStore.playSong("Manasi", "Song 2");
		UserMusicStore.playSong("Manasi", "Song 3");

		// Play new song 4 - which get added in list by removing the least played song
		UserMusicStore.playSong("Manasi", "Song 4");

		// Create new Music Store for User Kunal with initial Capacity of 5 songs
		UserMusicStore.InitializeStore(5);

		songsListHeader("Kunal");
		// Play song to get added in play list
		UserMusicStore.playSong("Kunal", "Song 1");
		UserMusicStore.playSong("Kunal", "Song 2");
		UserMusicStore.playSong("Kunal", "Song 3");
		UserMusicStore.playSong("Kunal", "Song 4");
		UserMusicStore.playSong("Kunal", "Song 5");

		// Play new song 3 - which get updated in list
		UserMusicStore.playSong("Kunal", "Song 3");

	}

}
