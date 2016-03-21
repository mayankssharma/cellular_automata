package mypackage;

import java.util.ArrayList;

public class CAGenerationSet {

	public void callCAGeneration90(int r) // it will be called from class CAApp
											// when the user selects rule 90.
											// variable "r" is the number of
											// generations that the user have
											// selected.
	{
		CARule ja = new CARule();
		ja.onetime();
		ja.rulecreation1(r);
	}

	public void callCAGeneration130(int r) // it will be called from class CAApp
											// when the user selects rule 130.
											// variable "r" is the number of
											// generations that the user have
											// selected.
	{
		CARule ja = new CARule();
		ja.onetime();
		ja.rulecreation2(r);
	}

	public void callCAGeneration165(int r) // it will be called from class CAApp
											// when the user selects rule 165.
											// variable "r" is the number of
											// generations that the user have
											// selected.
	{
		CARule ja = new CARule();
		ja.onetime();
		ja.rulecreation3(r);
	}

	public void printing(ArrayList<CACell> ar, int r) // it is used to print the
														// logic of the selected
														// ruleset into the
														// console.
	{
		for (int i = 0; i < r; i++) {
			CACell c2 = ar.get(i);
			for (int j = 0; j < 64; j++) {
				System.out.print(c2.c[j]);
			}
			System.out.println();

		}

	}

}
