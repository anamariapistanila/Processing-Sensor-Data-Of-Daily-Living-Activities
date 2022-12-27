package tema5;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException {
		Operations dataProcessing = new Operations();
		List<MonitoredData> monitoredData = dataProcessing.read();

		File file = new File("task_1.txt");
		FileWriter fileWriter = new FileWriter(file);
		PrintWriter printWriter = new PrintWriter(fileWriter);
		printWriter.println("Task1" + "\n");

		for (int i = 0; i < monitoredData.size(); i++) {

			printWriter.println("Start time: " + monitoredData.get(i).getStartTime());
			printWriter.println("End time : " + monitoredData.get(i).getEndTime());
			printWriter.println("Activity Label: " + monitoredData.get(i).getActivityLabel() + "\n");

		}

		printWriter.close();
		fileWriter.close();

		File file1 = new File("task_2.txt");
		FileWriter fileWriter1 = new FileWriter(file1);
		PrintWriter printWriter1 = new PrintWriter(fileWriter1);
		printWriter1.println("Task2" + "\n");
		Long zile = dataProcessing.task2();
		printWriter1.println("The distinct days that appear in the monitoring data " + zile);

		printWriter1.close();
		fileWriter1.close();

		List<String> s = new ArrayList<String>();
		File file2 = new File("task_3.txt");
		FileWriter fileWriter2 = new FileWriter(file2);
		PrintWriter printWriter2 = new PrintWriter(fileWriter2);
		printWriter2.println("Task3" + "\n");
		printWriter2.println("How many times each activity has appeared over the entire monitoring period" + "\n");
		Map<String, Long> res = dataProcessing.task3();
		for (Map.Entry<String, Long> m : res.entrySet()) {
			s.add(m.getKey() + " " + m.getValue().toString());
		}
		for (String a : s) {
			printWriter2.println(a);
			printWriter.println("\n");
		}

		printWriter2.close();
		fileWriter2.close();

		File file3 = new File("task_4.txt");
		FileWriter fileWriter3 = new FileWriter(file3);
		PrintWriter printWriter3 = new PrintWriter(fileWriter3);
		printWriter3.println("Task4" + "\n");
		printWriter3
				.println("How many times each activity has appeared for each day over the monitoring period" + "\n");
		Map<Integer, Map<String, Long>> res2 = dataProcessing.task4();

		for (Map.Entry<Integer, Map<String, Long>> entry : res2.entrySet()) {
			printWriter3.println(entry + "\n");
		}

		printWriter3.close();
		fileWriter3.close();

		File file4 = new File("task_6.txt");
		FileWriter fileWriter4 = new FileWriter(file4);
		PrintWriter printWriter4 = new PrintWriter(fileWriter4);
		printWriter4.println("Task6" + "\n");
		printWriter4.println(
				" The activities that have more than 90% of the monitoring records with duration less than 5 minutes"
						+ "\n");
		List<String> res6 = dataProcessing.task6();
		for (int i = 0; i < res6.size(); i++) {
			printWriter4.println(res6.get(i));
		}

		printWriter4.close();
		fileWriter4.close();

		File file5 = new File("task_5.txt");
		FileWriter fileWriter5 = new FileWriter(file5);
		PrintWriter printWriter5 = new PrintWriter(fileWriter5);
		printWriter5.println("Task5" + "\n");
		printWriter5.println("The entire duration over the monitoring period" + "\n");
		Map<String, Long> res5 = dataProcessing.task5();
		for (Map.Entry<String, Long> entry : res5.entrySet()) {
			long Seconds = entry.getValue() / 1000 % 60;
			long Minutes = entry.getValue() / (60 * 1000) % 60;
			long Hours = entry.getValue() / (60 * 60 * 1000) % 24;
			long Days = entry.getValue() / (24 * 60 * 60 * 1000);
			 printWriter5.println (entry.getKey()+ "  =  "+ "Days: " + Days + " hours: " + Hours + " minutes: " + Minutes + " seconds: "+ Seconds);
		}

		printWriter5.close();
		fileWriter5.close();

	}
}
