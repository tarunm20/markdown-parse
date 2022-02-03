import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.Test;

//import the junit file
public class MarkdownParseTest {   //create the public class that test for the MarkdownParse code
   @Test          //indicate that the following code can be written as a test case
   public void addition() {     
       assertEquals(2, 1 + 1);
   }

   @Test
   public void testGetLinks1() throws IOException {
       String fileName = "./test-file1.md";
       List<String> expected = List.of("https://something.com", "some-page.html");
       assertEquals(expected, MarkdownParse.getLinks(Files.readString(Path.of(fileName))));
   }

   @Test
   public void testGetLinks2() throws IOException {
       String fileName = "./test-file2.md";
       List<String> expected = List.of("https://www.newlink.com", " ");
       assertEquals(expected, MarkdownParse.getLinks(Files.readString(Path.of(fileName))));
   }

   @Test
   public void testGetLinks3() throws IOException {
       String fileName = "./test-file3.md";
       List<String> expected = List.of();
       assertEquals(expected, MarkdownParse.getLinks(Files.readString(Path.of(fileName))));
   }

   @Test
   public void testGetLinks4() throws IOException {
       String fileName = "./test-file4";
       List<String> expected = List.of();
       assertEquals(expected, MarkdownParse.getLinks(Files.readString(Path.of(fileName))));
   }
}

