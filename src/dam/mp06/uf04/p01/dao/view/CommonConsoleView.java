package dam.mp06.uf04.p01.dao.view;

import java.util.Scanner;

public class CommonConsoleView {

	public int getInt(String requestMessage) {
		this.showMessage(requestMessage);
		int result = -1;
		Scanner scanner = new Scanner(System.in);
		result = scanner.nextInt();
		//scanner.close();
		return result;
	}

	public String getWord(String requestMessage) {
		this.showMessage(requestMessage);
		String result = null;
		Scanner scanner = new Scanner(System.in);
		result = scanner.next();
		//scanner.close();
		return result;
	}

	public String getPhrase(String requestMessage) {
		this.showMessage(requestMessage);
		String result = null;
		Scanner scanner = new Scanner(System.in);
		result = scanner.nextLine();
		//scanner.close();
		return result;
	}

	public void showMessage(String message) {
		this.showMessage(message, false);

	}

	public void showMessage(String message, boolean isError) {
		if (isError) {
			System.err.println(message);
		} else {
			System.out.println(message);
		}

	}
}
