import java.util.Scanner;

public class LibraryUI {
	private Library library;

	LibraryUI() {
		library = new Library();
	}

	public void run() {
		scenario1();
		scenario2();
	}

	public void scenario1() {
		System.out.println();

		if (!library.login("asmith", "12345")) {
			System.out.println("Sorry we couldn't login.");
			return;
		}

		System.out.println("Amy Smith is now logged in");

		if (!library.findItem("The Cat in the Hat")) {
			System.out.println("Sorry, we don't have that book");
		}
		System.out.println("'The Cat in the Hat' is in the System");

		if (!library.checkout("The Cat in the Hat")) {
			System.out.println("Sorry, you were not able to checkout that book");
		}
		System.out.println("You have successfully checked out 'The Cat in the Hat'");
	}

	public void scenario2() {
		System.out.println();

		if (!library.login("bsmith", "12345")) {
			System.out.println("Sorry we couldn't login.");
			return;
		}
		System.out.println("Bobby Smith is now logged in");

		if (!library.payFine(5)) {
			System.out.println("The fine was not successfully paid.");
		}
		System.out.println("Fine was successfully paid.");

		if (!library.rateItem("The Wizard of Oz", 3)) {
			System.out.println("Didn't successfully rate the 'Wizard of Oz'");
		}
		System.out.println("The Wizard of Oz was successfully rated.");
	}

	public static void main(String[] args) {
		LibraryUI libraryInterface = new LibraryUI();
		libraryInterface.run();

	}
}