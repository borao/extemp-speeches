import static java.lang.System.out;
import java.util.ArrayList;
import org.jsoup.*;
import org.jsoup.nodes.*;
import java.io.IOException;
import java.util.Scanner;

public class Main {

  public static final String PRELIM_STANDINGS_URL = "";

  public static void main(String[] args) throws IOException {
    Document doc = Jsoup.connect(PRELIM_STANDINGS_URL).get();
    String result = doc.text();

    // Break results into two parts and dispose of everything before the text "Inverse Reciprocals"
    String[] parts = result.split("Inverse Reciprocals ");
    // Break remaining results into another two parts and dispose of everything after "Home"
    String[] parts2 = parts[1].split("Home");
    result = parts2[0];

    Scanner scanResult = new Scanner(result);

    // Create an array of students and populate according to data
    ArrayList<Student> students = new ArrayList<>();
    while (scanResult.hasNext()) {
      int speechesOwed = 0;
      // Scan first name followed by last name
      String studentName = scanResult.next() + " " + scanResult.next();
      // Accounts for middle names
      if (!scanResult.hasNextInt()) {
        studentName += " " + scanResult.next();
      }
      // Add first prelim rank and second prelim rank
      speechesOwed += Integer.parseInt(scanResult.next());
      speechesOwed += Integer.parseInt(scanResult.next());

      // Skip over total ranks and inverse reciprocals
      scanResult.next();
      scanResult.next();

      students.add(new Student(studentName, speechesOwed));
    }

    for (Student student : students) {
      System.out.printf("%s: %d\n", student.studentName, student.getSpeechesOwed());
    }
  }
}
