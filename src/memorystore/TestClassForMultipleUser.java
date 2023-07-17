package memorystore;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class TestClassForMultipleUser {
    private Map<String, LinkedList<String>> userPlaylists;
    private int capacity = 3;

    @BeforeClass
    public void setUp() {
        userPlaylists = new HashMap<>();
        userPlaylists.put("Manasi", createInitialPlaylist());
//        userPlaylists.put("Kunal", createInitialPlaylist());
    }

    private LinkedList<String> createInitialPlaylist() {
        LinkedList<String> playlist = new LinkedList<>();
        playlist.add("Song-1");
        playlist.add("Song-2");
        playlist.add("Song-3");
        return playlist;
    }

    @Test
    public void testInitialPlaylist() {
        for (String user : userPlaylists.keySet()) {
            LinkedList<String> playlist = userPlaylists.get(user);
            printPlaylist("Initial Playlist for " + user, playlist);
            Assert.assertEquals(playlist.size(), capacity);
            Assert.assertEquals(playlist.get(0), "Song-1");
            Assert.assertEquals(playlist.get(1), "Song-2");
            Assert.assertEquals(playlist.get(2), "Song-3");
        }
    }

    @Test(dependsOnMethods = "testInitialPlaylist")
    public void testAddFourthSong() {
        for (String user : userPlaylists.keySet()) {
            LinkedList<String> playlist = userPlaylists.get(user);
            playlist.add("Song-4");
            if (playlist.size() > capacity) {
                String removedSong = playlist.removeFirst();
                printPlaylist("Updated Playlist after adding Song-4 for " + user, playlist);
                System.out.println("Removed Element for " + user + ": " + removedSong);
            }
            Assert.assertEquals(playlist.size(), capacity);
            Assert.assertEquals(playlist.get(0), "Song-2");
            Assert.assertEquals(playlist.get(1), "Song-3");
            Assert.assertEquals(playlist.get(2), "Song-4");
        }
    }

    @Test(dependsOnMethods = "testAddFourthSong")
    public void testPlayS2Song() {
        for (String user : userPlaylists.keySet()) {
            LinkedList<String> playlist = userPlaylists.get(user);
            playlist.remove("Song-2");
            playlist.add("Song-2");
            printPlaylist("Updated Playlist after playing Song-2 for " + user, playlist);
            Assert.assertEquals(playlist.size(), capacity);
            Assert.assertEquals(playlist.get(0), "Song-3");
            Assert.assertEquals(playlist.get(1), "Song-4");
            Assert.assertEquals(playlist.get(2), "Song-2");
        }
    }

    private void printPlaylist(String message, LinkedList<String> playlist) {
        System.out.println("--------------------------------------------------");
        System.out.println(message);
        System.out.println("Playlist -> " + playlist);
        System.out.println("--------------------------------------------------");
    }
}

