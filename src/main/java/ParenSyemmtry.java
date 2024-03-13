
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
class ParenSymmetry {
    public Boolean isBalanced(String s) {
        // implement this method
        int opencount = 0;
        int closecount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                opencount++;
            } else if (s.charAt(i) == ')') {
                closecount++;
                if (closecount > opencount) {
                    return false;
                }
            }
        }
        return opencount == closecount;
    }
    private void checkFile(String filename) {
        try {
            File myfile = new File("filename");
            Scanner myReader = new Scanner(myfile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    // open file named filename
    // for each line in the file
    // read the line
    // print whether or not the line's parenthesis are balanced
    // CLOSE the file
    public static void main(String[] args) {
        ParenSymmetry ps = new ParenSymmetry();
        Boolean b0 = ps.isBalanced("()");
        printResult(b0, true);
        String[] falseStrings = {"(", "((", ")", "", "(()())((())))"};
        Boolean falses = true;
        for (String strToTest : falseStrings) {
            falses = ps.isBalanced(strToTest);
        }
        printResult(falses, false);
        String[] trueStrings = {"()", "(())", "(((())))", "", "(()())((()))", "(   )", "( () ( ) )"};
        Boolean trues = false;
        for (String strToTest : trueStrings) {
            trues = ps.isBalanced(strToTest);
        }
        printResult(trues, true);
    }
    private static void printResult(Boolean b0, boolean b) {
        if (b0 == null) {
            System.out.println("Null Failure");
            return;
        }
        if (b0 == b) {
            System.out.println("Success");
        } else {
            System.out.println("Failure");
        }
    }
}