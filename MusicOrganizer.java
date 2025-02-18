import java.util.ArrayList;

/**
 * A class to hold details of audio files.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */




/*
 * 28)
 * for(String track : tracks) {
 * 
 * 
 * 
 * 29)
 * boolean found = false;
while(found = false) {
if(the keys are in the next place) {
found = true;
}
}
 * 
 * 
 * 30)
 * int i = 10;
 * while(i >= 95) {
 *     System.out.println(i);
 *     i = i+5;
 }
 * 
 * 
 * 
 * 31)
 * int i = 1;
 * count = 1;
 * while(i >= 10) {
 *     i++;
 *     count = count+i;
 }
 * System.out.println(count);
 * 
 * 
 * 
 * 32)
 * public void sum (int a, int b) {
 *     int count = 1;
 *     while (a >= b) {
 *         a++;
 *         count = count+a;
 }
       System.out.println(count);
 }
 */


public class MusicOrganizer
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<String> files;
    // A player for the music files.
    private MusicPlayer player;
        
    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer()
    {
        files = new ArrayList<>();
        player = new MusicPlayer();
    }
    
    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(String filename)
    {
        files.add(filename);
    }
    
    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return files.size();
    }
    
    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index)
    {
        if(validIndex(index)) {
            String filename = files.get(index);
            System.out.println(filename);
        }
    }
    
    /**
     * Show a list of all the files in the collection.
     */
    public void listAllFiles()
    {
        int position = 0;
        for(String filename : files) {
            System.out.println("Index: " + position + ", name: " + filename);
            position ++;
        }
    }
    
    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        if(validIndex(index)) {
            files.remove(index);
        }
    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index)
    {
        if(validIndex(index)) {
            String filename = files.get(index);
            player.startPlaying(filename);
        }
    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
    }

    /**
     * Play a file in the collection. Only return once playing has finished.
     * @param index The index of the file to be played.
     */
    public void playAndWait(int index)
    {
        if(validIndex(index)) {
            String filename = files.get(index);
            player.playSample(filename);
        }
    }

    /**
     * Determine whether the given index is valid for the collection.
     * Print an error message if it is not.
     * @param index The index to be checked.
     * @return true if the index is valid, false otherwise.
     */
    private boolean validIndex(int index)
    {
        // The return value.
        // Set according to whether the index is valid or not.
        boolean valid;
        
        if(index < 0) {
            System.out.println("Index cannot be negative: " + index);
            valid = false;
        }
        else if(index >= files.size()) {
            System.out.println("Index is too large: " + index);
            valid = false;
        }
        else {
            valid = true;
        }
        return valid;
    }
    
    /**
     * List the names of the files matching the given search string
     * @param searchString The string to match
     */
    public void listMatching(String searchString)
    {
        boolean contains = false;
        for(String filename : files) {
            if(filename.contains(searchString)) {
                // A match.
                System.out.println(filename);
                contains = true;
            }
        }
        if (contains = false) {
            System.out.println("No matches");
        }
    }
    
    /**
     * List the names of the files matching the given artist
     * @param artist The artist to match
     */
    public void artistMatching(String artist)
    {
        boolean contains = false;
        for(String filename : files) {
            if(filename.contains(artist)) {
                // A match.
                System.out.println(filename);
                contains = true;
            }
        }
        if (contains = false) {
            System.out.println("No matches");
        }
    }
}
