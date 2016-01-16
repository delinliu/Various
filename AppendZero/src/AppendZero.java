import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.RandomAccessFile;

public class AppendZero {

	private static String zero = "0000000000000000000000000000000000000000000000000000000000000000";

	public static void main(String[] args) {

		if (args.length == 1 && "--help".equals(args[0])) {
			System.out.println("-p /testfolder -t append\n-p /testfolder -t remove");
			return;
		}

		int countP = 0;
		int countT = 0;
		String folder = null;
		String type = null;
		for (int i = 0; i < args.length; i++) {

			if (args[i].equals("-p")) {
				countP++;
				if (i + 1 >= args.length || "-p".equals(args[i + 1]) || "-t".equals(args[i + 1])) {
					System.err.println("Error -p param.");
					return;
				}
				folder = args[i + 1];
			} else if (args[i].equals("-t")) {
				countT++;
				if (i + 1 >= args.length || "-p".equals(args[i + 1]) || "-t".equals(args[i + 1])) {
					System.err.println("Error -p param.");
					return;
				}
				type = args[i + 1];
			} else if (i <= 0 || (!"-p".equals(args[i - 1]) && !"-t".equals(args[i - 1]))) {
				System.err.println("Error param: " + args[i]);
				return;
			}
		}

		if (countP == 0) {
			System.err.println("Need -p param as folder path.");
		} else if (countT == 0) {
			System.err.println("Need -t param as 'remove' or 'append'.");
		} else if (countP > 1) {
			System.err.println("More than 1 -p param.");
		} else if (countT > 1) {
			System.err.println("More than 1 -t param.");
		} else if (countT == 1 && (!"append".equals(type) && !"remove".equals(type))) {
			System.err.println("Unkown -t param: " + type);
		} else {
			File root = new File(folder);
			if ("append".equals(type)) {
				recursionAppendZero(root);
			} else if ("remove".equals(type)) {
				recursionRemoveZero(root);
			}
		}

	}

	private static void recursionAppendZero(File root) {
		if (root == null) {
			return;
		}

		if (root.isDirectory()) {
			File[] children = root.listFiles();
			for (File child : children) {
				recursionAppendZero(child);
			}
		} else if (root.isFile()) {
			appendZero(root);
		} else {
			System.err.println("not file & not folder: " + root.getAbsolutePath());
		}
	}

	private static void recursionRemoveZero(File root) {
		if (root == null) {
			return;
		}

		if (root.isDirectory()) {
			File[] children = root.listFiles();
			for (File child : children) {
				recursionRemoveZero(child);
			}
		} else if (root.isFile()) {
			removeZero(root);
		} else {
			System.err.println("not file & not folder: " + root.getAbsolutePath());
		}
	}

	/**
	 * Append zero string if the file does not have the zero string in the end.
	 * 
	 * @param file
	 */
	private static void appendZero(File file) {
		try {
			RandomAccessFile raf = new RandomAccessFile(file, "rw");
			if (raf.length() >= zero.length()) {
				raf.seek(raf.length() - zero.length());
				String lastLine = raf.readLine();
				if (zero.equals(lastLine)) {
					System.out.println("append zero(already): " + file.getAbsolutePath());
					raf.close();
					return;
				}
			}
			raf.seek(raf.length());
			raf.writeBytes(zero);
			System.out.println("append zero: " + file.getAbsolutePath());
			raf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Remove zero string if the file has the zero string in the end.
	 * 
	 * @param file
	 */
	private static void removeZero(File file) {
		try {
			RandomAccessFile raf = new RandomAccessFile(file, "rw");
			if (raf.length() >= zero.length()) {
				raf.seek(raf.length() - zero.length());
				String lastLine = raf.readLine();
				if (zero.equals(lastLine)) {
					raf.setLength(raf.length() - zero.length());
					System.out.println("remove zero: " + file.getAbsolutePath());
					raf.close();
					return;
				}
			}
			System.out.println("remove zero(already): " + file.getAbsolutePath());
			raf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Print the text content of a file.
	 * 
	 * @param file
	 */
	private static void printFile(File file) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
