package hr.sarko.hi;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

public class SendReport {

	public static boolean createdFile;
	public static boolean done;

	private static String OS = System.getProperty("os.name").toLowerCase();

	public static boolean isWindows() {
		return (OS.indexOf("win") >= 0);
	}

	public static boolean isMac() {
		return (OS.indexOf("mac") >= 0);
	}

	public static boolean isUnix() {
		return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0);
	}

	public static File createFile() {
		String dirName = "";
		if (isWindows()) {
			dirName = "C:\\ProgramData\\MiniDoushi\\";
		} else if (isMac()) {
			dirName = "/var/tmp/MiniDoushi";
		} else if (isUnix()) {
			dirName = "/tmp/MiniDoushi";
		}
		File file = new File(dirName + fileName());
		if (!file.getParentFile().exists())
			file.getParentFile().mkdirs();
		createdFile = true;
		return file;
	}

	private static String randomizeName() {
		Random random = new Random();
		DateFormat format2 = new SimpleDateFormat("dd-MM-yyyy-");
		Calendar cal = Calendar.getInstance();
		String randomName = "MiniDoushiReport " + format2.format(cal.getTime()) + random.nextInt() + ".dat";
		return randomName;

	}

	public static String fileName() {
		DateFormat format2 = new SimpleDateFormat("dd-MM-yyyy");
		Calendar cal = Calendar.getInstance();
		String filename = "MiniDoushiReport " + format2.format(cal.getTime()) + ".dat";
		return filename;
	}

	public static String writeReport(File file) throws IOException {
		String eol = System.getProperty("line.separator");
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		// BufferedWriter writer = new BufferedWriter(new FileWriter(file,
		// true));
		BetterFileWriter writer = new BetterFileWriter(file, "UTF-8", true);
		String unos = Gui.text.getText();
		String glagol = Gui.glagol.getText();
		String tense = Gui.tense.getText();
		String odgovor = Gui.odgovor;
		String time = dateFormat.format(cal.getTime());
		if (unos != null) {
			if (unos.equals(odgovor))
				writer.append(time + "\t" + "T" + "\t" + unos + "\t" + odgovor + "\t" + glagol + "\t" + tense + eol);
			else
				writer.append(time + "\t" + "F" + "\t" + unos + "\t" + odgovor + "\t" + glagol + "\t" + tense + eol);
		}
		writer.close();
		return createFile().getName();
	}

	public static boolean sendReport(String filename) throws IOException {
		String server = "ftp.byethost33.com";
		int port = 21;
		String user = "b33_17689042";
		String pass = "wmg1kv9t";
		filename = fileName();

		FTPClient ftpClient = new FTPClient();
		try {

			ftpClient.connect(server, port);
			ftpClient.login(user, pass);
			ftpClient.enterLocalPassiveMode();
			ftpClient.changeWorkingDirectory("htdocs");

			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

			// APPROACH #1: uploads first file using an InputStream

			String firstRemoteFile = randomizeName();
			String dirName = "";
			if (isWindows()) {
				dirName = "C:\\ProgramData\\MiniDoushi\\";
			} else if (isMac()) {
				dirName = "/var/tmp/MiniDoushi";
			} else if (isUnix()) {
				dirName = "/tmp/MiniDoushi";
			}

			InputStream inputStream = new FileInputStream(dirName + fileName());
			done = ftpClient.storeFile(firstRemoteFile, inputStream);
			inputStream.close();

			System.out.println("Start uploading report file");
			if (done) {
				System.out.println("The report file is uploaded successfully.");
				return true;
			}

			// // APPROACH #2: uploads second file using an OutputStream
			// File secondLocalFile = new File("test2.txt");
			// String secondRemoteFile = "test2.txt";
			// inputStream = new FileInputStream(secondLocalFile);
			//
			// System.out.println("Start uploading second file");
			// OutputStream outputStream =
			// ftpClient.storeFileStream(secondRemoteFile);
			// byte[] bytesIn = new byte[4096];
			// int read = 0;
			//
			// while ((read = inputStream.read(bytesIn)) != -1) {
			// outputStream.write(bytesIn, 0, read);
			// }
			// inputStream.close();
			// outputStream.close();
			//
			// boolean completed = ftpClient.completePendingCommand();
			// if (completed) {
			// System.out.println("The second file is uploaded successfully.");
			// }

		} catch (IOException ex) {
			System.out.println("Error: " + ex.getMessage());
			ex.printStackTrace();
		} finally {
			try {
				if (ftpClient.isConnected()) {
					ftpClient.logout();
					ftpClient.disconnect();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return false;
	}

}