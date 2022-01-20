
// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {
    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then take up to
        // the next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            int nextOpenBracket = markdown.indexOf("[", currentIndex);
            if(nextOpenBracket==-1){
                break;
            }
            int nextCloseBracket = markdown.indexOf("]", nextOpenBracket);
            int openParen = markdown.indexOf("(", nextCloseBracket);
            int closeParen = markdown.indexOf(")", openParen);
            if(markdown.substring(nextOpenBracket-1, nextOpenBracket).equals("!")) {
                currentIndex = closeParen + 1;
                continue;
            }
            // System.out.println(nextOpenBracket);
            // System.out.println(closeParen);
            toReturn.add(markdown.substring(openParen + 1, closeParen));
            // System.out.println(toReturn.get(toReturn.size()-1));
            if (closeParen>currentIndex){
                currentIndex = closeParen + 1;
            }else{
                break;
            }
            
        }
        return toReturn;
    }
    public static void main(String[] args) throws IOException {
		Path fileName = Path.of(args[0]);
	    String contents = Files.readString(fileName);
        ArrayList<String> links = getLinks(contents);
        System.out.println(links);
    }
}