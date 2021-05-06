package michael.slf4j.learning.hdu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class C1497_Library {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while (sc.hasNext()) {
				int m = sc.nextInt();
				int n = sc.nextInt();
				int c = sc.nextInt();
				sc.nextLine();
				Map<Integer, Integer> books = new HashMap<>();
				for (int i = 1; i <= n; i++) {
					books.put(i, null);
				}
				Map<Integer, Map<Integer, Integer>> database = new HashMap<>();
				for (int i = 0; i < c; i++) {
					String command = sc.nextLine();
					String[] parts = command.split("[\\s]+");
					if("B".equals(parts[0])) {
						int userId = Integer.valueOf(parts[1]);
						int bookId = Integer.valueOf(parts[2]);
						if(!books.containsKey(bookId)) {
							System.out.println("The book is not in the library now");
						} else {
							Map<Integer, Integer> booksPerUser = database.get(userId);
							if(booksPerUser == null) {
								booksPerUser = new TreeMap<>();
								database.put(userId, booksPerUser);
							}
							if(booksPerUser.size() == 9) {
								System.out.println("You are not allowed to borrow any more");
							} else {
								booksPerUser.put(bookId, null);
								books.replace(bookId, userId);
								System.out.println("Borrow success");
							}
						}
					} else if("R".equals(parts[0])) {
						int bookId = Integer.valueOf(parts[1]);
						Integer bookBorrowedBy = books.get(bookId);
						if(bookBorrowedBy == null) {
							System.out.println("The book is already in the library");
						} else {
							Map<Integer, Integer> booksPerUser = database.get(bookBorrowedBy);
							booksPerUser.remove(bookId);
							books.replace(bookId, null);
							System.out.println("Return success");
						}
					} else {
						int userId = Integer.valueOf(parts[1]);
						Map<Integer, Integer> booksPerUser = database.get(userId);
						if(booksPerUser == null || booksPerUser.size() == 0) {
							System.out.println("Empty");
						} else {
							System.out.println(booksPerUser.entrySet().stream().map(entry -> entry.getKey().toString()).collect(Collectors.joining(" ")));
						}
					}
				}
				m = m + 1;
				System.out.println();
			}
		}
	}

}
