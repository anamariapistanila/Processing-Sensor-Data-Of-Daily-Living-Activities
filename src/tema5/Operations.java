package tema5;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Operations {

	public List<MonitoredData> read() {
		String fileName = "activities.txt";
		List<MonitoredData> monitoredData = new ArrayList<>();

		try {
			Stream<String> stream = Files.lines(Paths.get(fileName));
			monitoredData = stream.map(MonitoredData::new).collect(Collectors.toList());
			stream.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return monitoredData;
	}

	public Long task2() {

		List<MonitoredData> monitoredData = this.read();
		List<String> string = monitoredData.stream().map(m -> m.getDate()).collect(Collectors.toList());

		return string.stream().distinct().count();
	}

	public Map<String, Long> task3() {
		List<MonitoredData> monitoredData = this.read();

		Map<String, Long> numar = monitoredData.stream()
				.collect(Collectors.groupingBy(MonitoredData::getActivityLabel, Collectors.counting()));

		return numar;
	}

	public Map<Integer, Map<String, Long>> task4() {

		List<MonitoredData> monitoredData = this.read();

		Map<Integer, Map<String, Long>> numar = monitoredData.stream().collect(Collectors.groupingBy(
				MonitoredData::getDay, Collectors.groupingBy(MonitoredData::getActivityLabel, Collectors.counting())));

		return numar;
	}

	public Long getTime(MonitoredData m) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = dateFormat.parse(m.getStartTime());
			
		} catch (ParseException e) {

			e.printStackTrace();
		}
		Date date1 = null;
		try {
			date1 = dateFormat.parse(m.getEndTime());
		} catch (ParseException e) {

			e.printStackTrace();
		}
		Long time = (date1.getTime() - date.getTime());
		return time;
	}

	public Map<String, Long> task5() {
		List<MonitoredData> date = this.read();

		Map<String, Long> res = date.stream().collect(
				Collectors.groupingBy(MonitoredData::getActivityLabel, Collectors.summingLong(m -> getTime(m))));

		return res;
	}

	public Long getMinutes(MonitoredData m) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = dateFormat.parse(m.getStartTime());
		} catch (ParseException e) {

			e.printStackTrace();
		}
		Date date1 = null;
		try {
			date1 = dateFormat.parse(m.getEndTime());
		} catch (ParseException e) {

			e.printStackTrace();
		}
		Long time = (date1.getTime() - date.getTime());

		return time / (60 * 1000);
	}

	public List<String> task6() {
		List<MonitoredData> date = this.read();

		Map<String, Long> numar = date.stream()
				.collect(Collectors.groupingBy(MonitoredData::getActivityLabel, Collectors.counting()));

		Map<String, Long> filter = date.stream().filter(min -> getMinutes(min) <= 5)
				.collect(Collectors.groupingBy(MonitoredData::getActivityLabel, Collectors.counting()));

		List<String> res = filter.entrySet().stream().filter(e -> (e.getValue() * 100) / numar.get(e.getKey()) > 90)
				.map(e -> e.getKey()).collect(Collectors.toList());

		return res;
	}
}
