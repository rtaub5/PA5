/**
 * PA05: Prints words of file in alphabetical order with frequencies
 * Also prints ratio of different words to total words
 * This class uses the file entered in args[0] and creates an instance of WordHamsterWithBst.
 * It prints the values returned from the methods of that class.
 * @author Rocki Taub
 * 12/21/23
 */
public class PA5Demo
{
    public static void main(String[] args)
    {
        if (args.length < 1)
        {
            System.out.println("no filename provided");
        } else
        {
            String file = args[0];
            WordHamsterWithBst wordHamster = new WordHamsterWithBst();
            double ttr = wordHamster.gatherWords(file);
            wordHamster.getTree().printTree();
            System.out.println("TTR in decimal form: " + ttr);
        }
    }
}