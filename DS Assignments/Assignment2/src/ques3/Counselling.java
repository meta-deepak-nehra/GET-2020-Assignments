package ques3;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
public class Counselling 
{
	int sum=0;
	Queue<String> students = new LinkedList<String>();
	HashMap<String, Integer> program = new HashMap<String, Integer>();
	HashMap<String, String> studentpref = new HashMap<String, String>();
	
	public void readProgramFile(String filePath) {

		File file = new File(filePath);
		Workbook workbook;
		try {
			workbook = Workbook.getWorkbook(file);
			Sheet sheet = workbook.getSheet(0);
			for (int row = 1; row < sheet.getRows(); row++) {
				Cell cell = sheet.getCell(0, row);
				String programName = cell.getContents();
				cell = sheet.getCell(1, row);
				Integer capacity = Integer.parseInt(cell.getContents());
				sum+=capacity;
				program.put(programName, capacity);
			}
		} catch (Exception ex) {
			System.out.println("Message " + ex.getMessage());
		}

	}

	public void readStudentPref(String filePath) {

		File file = new File(filePath);
		Workbook workbook;
		try {
			workbook = Workbook.getWorkbook(file);
			Sheet sheet = workbook.getSheet(0);
			for (int col = 1; col < sheet.getRows(); col++) {
				Cell cell = sheet.getCell(0, col);
				String studenName = cell.getContents();
				students.add(studenName);
				cell = sheet.getCell(1, col);
				String pref = cell.getContents();
				studentpref.put(studenName, pref);
			}
		} catch (Exception ex) {
			System.out.println("Message " + ex.getMessage());
		}

	}

	public void studentCounselling(String path, String programfile, String studentpreference) {
		readProgramFile(programfile);
		readStudentPref(studentpreference);
		WritableWorkbook workbook;
		try {
			workbook = Workbook.createWorkbook(new File(path));
			WritableSheet sheet = workbook.createSheet("Output", 0);
			Integer count = 1;
			sheet.addCell(new Label(0, 0, "Student Name"));
			sheet.addCell(new Label(1, 0, "College Alloted"));
			while (!students.isEmpty()&&count<=sum) 
			{
				String studentName = students.remove();
				String pref = studentpref.get(studentName);
				String preference[] = new String[5];
				preference = pref.split(",");
				for (int loop = 0; loop < pref.length(); loop++) {
					String subject = preference[loop];
					Integer capacity = program.get(subject);
					if (capacity > 0) {
						Label label = new Label(0, count, studentName);
						sheet.addCell(label);
						Label label1 = new Label(1, count, preference[loop]);
						sheet.addCell(label1);
						count++;
						capacity--;
						program.put(subject, capacity);
						break;
					}
				}		
			}
			workbook.write();
			workbook.close();
		} catch (Exception ex) {
			System.out.println("hello " + ex.getMessage());
		}

	}
}
