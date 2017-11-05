public class Student {

  public String studentName = "";
	private int speechesOwed = 0;

	public Student(String studentName, int speechesOwed) {
	  this.studentName = studentName;
	  this.speechesOwed = speechesOwed;
	}

	public int getSpeechesOwed() {
	  return speechesOwed;
  }

}
