import java.io.*;
import java.util.*;

/**
 * @author Katz9
 * @modified Rocki Taub
 * 12/21/23
 * Modified WordHamster to store elements in bst(an instance of BinarySearchTree) as well as arraylist.
 * @returns TTR number of different words divided by the total number of words
 */
public class WordHamsterWithBst
{

    private ArrayList<String> words = new ArrayList<>();
    private BinarySearchTree bst = new BinarySearchTree();

    /**
     *
     * @param filePath file where text is coming from
     * @return TTR number of different words divided by the total number of words
     */
    public double gatherWords(String filePath)
    {
        int ttr = 0;
        try (Scanner wordsIn = new Scanner(new FileReader(filePath)))
        {
            int totalWords = 0;
            wordsIn.useDelimiter("[^a-zA-Z']+");
            while (wordsIn.hasNext())      // while more words to process
            {
                String word = wordsIn.next();
                word = word.toLowerCase();
                words.add(word);
                bst.insert(word);
                totalWords++;
            }
            System.out.println(bst.getNumberOfNodes() + ":" + totalWords);
            return bst.getNumberOfNodes() / (double)totalWords;
        }
        catch (IOException ioex)
        {
            ttr = -1;
            System.out.println(ioex.getMessage());
        }
        return ttr;
    }

    /**
     *
     * @return arraylist of words in text file
     */
    public ArrayList<String> exposeWords()
    {
        return words;
    }

    /**
     *
     * @return BinarySearchTree of words in text file
     */
    public BinarySearchTree getTree() {return bst;}
}
