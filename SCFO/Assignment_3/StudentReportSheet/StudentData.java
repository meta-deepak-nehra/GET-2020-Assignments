
public class StudentData 
{
	int studentRollNo;
	String studentName;
	float studentGrades;
	
	public StudentData(int studentRollNo, String studentName, float studentGrades) 
	{
		super();
		this.studentRollNo = studentRollNo;
		this.studentName = studentName;
		this.studentGrades = studentGrades;
	}

	public int getStudentRollNo() {
		return studentRollNo;
	}

	public void setStudentRollNo(int studentRollNo) {
		this.studentRollNo = studentRollNo;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public float getStudentGrades() {
		return studentGrades;
	}

	public void setStudentGrades(float studentGrades) {
		this.studentGrades = studentGrades;
	}
	
	
}
