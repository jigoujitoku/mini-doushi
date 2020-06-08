package hr.sarko.hi;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

/**
 * Created with IntelliJ IDEA. User: Eugene Chipachenko Date: 20.09.13 Time:
 * 10:21
 */
public class BetterFileWriter extends OutputStreamWriter {
	public BetterFileWriter(String fileName) throws IOException {
		super(new FileOutputStream(fileName), Charset.forName("UTF-8"));
	}

	public BetterFileWriter(String fileName, boolean append) throws IOException {
		super(new FileOutputStream(fileName, append), Charset.forName("UTF-8"));
	}

	public BetterFileWriter(String fileName, String charsetName, boolean append) throws IOException {
		super(new FileOutputStream(fileName, append), Charset.forName(charsetName));
	}

	public BetterFileWriter(File file) throws IOException {
		super(new FileOutputStream(file), Charset.forName("UTF-8"));
	}

	public BetterFileWriter(File file, boolean append) throws IOException {
		super(new FileOutputStream(file, append), Charset.forName("UTF-8"));
	}

	public BetterFileWriter(File file, String charsetName, boolean append) throws IOException {
		super(new FileOutputStream(file, append), Charset.forName(charsetName));
	}
}