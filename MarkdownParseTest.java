import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MarkdownParseTest {
    String content;
    
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testGetLinks() throws IOException {   
        List l = List.of("https://something.com", "some-thing.html");
        Path p = Paths.get("test-file.md");
        String st = Files.readString(p);
        assertEquals(l, MarkdownParse.getLinks(st));
    }

    @Test
    public void TestLinksImage()throws IOException{   
        content = Files.readString(Path.of("testImage.md"));
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals("tests if the links are the same", 0, links.size());
    }

    @Test
    public void TestLinksNoParantheses()throws IOException{   
        content = Files.readString(Path.of("testNoParantheses.md"));
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals("tests if the links are the same", 0, links.size());
    }
    @Test
    public void TestLinksNoBrackets()throws IOException{   
        content = Files.readString(Path.of("testNoBracket.md"));
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals("tests if the links are the same", 0, links.size());
    }
    @Test
    public void TestLinksNoLink()throws IOException{   
        content = Files.readString(Path.of("testNoLink.md"));
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals("tests if the links are the same", 0, links.size());
    }

    @Test
    public void testGetLinks2()throws IOException{   
        List l = List.of("https://something.com", "some-thing.html");
        Path p = Paths.get("test-file.md");
        String st = Files.readString(p);
        assertEquals(l, MarkdownParse.getLinks(st));
    }

    @Test
    public void TestLinksNoLink2()throws IOException{   
        content = Files.readString(Path.of("test-file7.md"));
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals("tests if the links are the same", 0, links.size());
    }

    @Test
    public void TestLinksNoLink3()throws IOException{   
        content = Files.readString(Path.of("test-file7.md"));
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals("tests if the links are the same", 0, links.size());
    }

    @Test
    public void TestLinksNoLink4()throws IOException{   
        content = Files.readString(Path.of("test-file7.md"));
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals("tests if the links are the same", 0, links.size());
    }

    
    @Test
    public void testSnippet1() throws IOException {
        Path snip1 = Path.of("Snippet1.md");
        String testfile = Files.readString(snip1);
        List expectedList = List.of("google.com", "google.com", "ucsd.edu");
        assertEquals(expectedList, MarkdownParse.getLinks(testfile));

    }

    @Test
    public void testSnippet2() throws IOException {
        Path snip2 = Path.of("Snippet2.md");
        String testfile = Files.readString(snip2);
        List expectedList = List.of("a.com", "a.com(())", "example.com");
        assertEquals(expectedList, MarkdownParse.getLinks(testfile));

    }

    @Test
    public void testSnippet3() throws IOException {
        Path snip3 = Path.of("Snippet3.md");
        String testfile = Files.readString(snip3);
        List expectedList = List.of("https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule");
        assertEquals(expectedList, MarkdownParse.getLinks(testfile));
    }
}
