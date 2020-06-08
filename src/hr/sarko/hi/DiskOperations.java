package hr.sarko.hi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DiskOperations {

	public static List<String> readLines(String filename) throws IOException {
		List<String> list = new ArrayList<String>();
		// DiskOperations.class.getClass().getResourceAsStream(filename);
		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(Drugi.class.getResourceAsStream("/" + filename), "UTF-8"))) {
			String str;
			while ((str = br.readLine()) != null) {
				str.trim();
				list.add(str);
			}
		}
		return list;
	}

}
