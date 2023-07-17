# TestVagrant
Assignment for TestVagrant


__Definition__

Create an in-memory store for recently played songs 
that can accommodate N songs per user, with a fixed initial capacity. 
This store must have the capability to store a list of song-user pairs, 
with each song linked to a user. It should also be able to fetch recently played songs,
based on the user and eliminate the least recently played songs
when the store becomes full.


__Approach__ 

To maintain the User-Songs relation we are using combination of Hashmap and Linkedlist as LinkedHashMap

__Synopsis__

- Songs list is stored in LHMap wrt username.
- For each songs entry checking the capacity of store wrt initialized limit
- Case if user played existing song -- it should be updated
- Fetching songs list using username
- Added two static user Manasi and Kunal for testing 2 cases
- If user (~Manasi) play/add new song above capacity
- If user (~Kunal)  play already existing song from playlist


__Launguage__

- Java: Develop the logic
- TestNG: Framework for test case execution

__Structure__

- _SongsPlayer.java_ : File executes the logic of in-memory store with predefined values
- _Store.java_ : File have modular functions to manage the memory store
- _TestClassForMultipleUser.java_ : File have test cases to be executed using testNG

__Commands__

- To execute the program select _SongsPlayer.java_ class file and run as  Java Application 
(Alt +shift+X, J)

- To execute the test cases select _TestClassForMultipleUser.java_ class file and run as TestNG Test
(Alt +shift+X, N)


