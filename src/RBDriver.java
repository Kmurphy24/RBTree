import java.io.*;
import java.util.*;

public class RBDriver {

	public static void main(String[] args) {
		String line;
		Book element;
		RBTree<Book> rb = new RBTree<Book>();
		int unsuccessfulComparisons = 0;
		int successfulComparisons = 0;
		int unsuccessfulSearches = 0;
		int successfulSearches = 0;
		IntObject searchCount = new IntObject(0);
		int count = 0;

		try {
			Scanner inFile = new Scanner(new FileInputStream("Books.txt"));
			Scanner keyboard = new Scanner(System.in);

			Scanner testFile = new Scanner(new FileInputStream("TestISBN.txt"));

			PrintWriter out = new PrintWriter(new FileWriter("BSTOutput.txt"));

			while (inFile.hasNextLine()) {
				line = inFile.nextLine();
				Book aBook = new Book(line.substring(0, 10), line.substring(15,
						55).trim(), line.substring(55, 95).trim(),
						Integer.parseInt(line.substring(95, 99)),
						line.substring(104, line.length()));
				rb.add(aBook);
			}
			inFile.close();
			out.println("All " + rb.size()
					+ " elements have been inserted into the " + "AVL tree");
			out.println();
			out.println("The height of the tree is " + rb.height());
			out.println();

			out.println("The minimum element in the tree is: ");
			out.println(rb.first());

			out.println("\nThe maximum element in the tree is: ");
			out.println(rb.last());
			out.println();
			out.println();
			while (testFile.hasNextLine()) {
				line = testFile.nextLine();
				element = new Book();
				element.setIsbn(line);
				searchCount.setData(0);
				Book result = rb.find(element, searchCount);
				if (result != null) {
					out.println("Sucessful Search!!!");
					out.println(result);
					out.println("The number of comparisons made for "
							+ "this succeesful search is "
							+ searchCount.getData());
					out.println();
					out.println();
					successfulComparisons += searchCount.getData();
					successfulSearches++;
				} else { // key is not found in the BST
					out.println("There is no book with ISBN "
							+ element.getIsbn());
					out.println("The number of comparisons made for "
							+ "this unsucceesful search is "
							+ searchCount.getData());
					out.println();

					unsuccessfulComparisons += searchCount.getData();
					unsuccessfulSearches++;
				} // else
			} // while

			out.println("There were " + successfulSearches
					+ " successful searches");
			if (successfulSearches > 0)
				out.println("The average number of comparisons for a "
						+ "successful search is "
						+ (double) successfulComparisons / successfulSearches);
			out.println();

			out.println("There were " + unsuccessfulSearches
					+ " unsuccessful searches");
			if (unsuccessfulSearches > 0)
				out.println("The average number of comparisons for "
						+ "an unsuccessful search is "
						+ (double) unsuccessfulComparisons
						/ unsuccessfulSearches);

			testFile.close();
			out.close();
		} catch (IOException e) {
			System.out.println("Input file or the test file cannot be opened");
			System.exit(0);
		}
	}
}