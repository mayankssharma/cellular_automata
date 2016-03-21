package mypackage;

public class CARule {
	int[] ruleset90 = { 0, 1, 0, 1, 1, 0, 1, 0 };
	int[] ruleset130 = { 1, 0, 0, 0, 0, 0, 1, 0 };
	int[] ruleset165 = { 1, 0, 1, 0, 0, 1, 0, 1 };

	int l = 0;

	int cells[] = new int[64];

	public void onetime() // to fill the first row of the cells . All will be 0
							// and at the center we have a single 1
	{
		for (int i = 0; i < cells.length; i++) {
			cells[i] = 0;
		}
		cells[cells.length / 2] = 1;
		CACell cb = new CACell();
		cb.c = cells;
		CAGeneration.ar.add(cb);

		// System.out.println();
	}

	public void rulecreation1(int r) // for creation of rule 90
	{

		int[] nextgen = new int[64];
		try { // for handling deep recursion error
			for (int i = 1; i < cells.length - 1; i++) {

				String mm = "" + cells[i - 1] + cells[i] + cells[i + 1];
				int index = Integer.parseInt(mm, 2); // converts the string "mm"
														// to binary and then to
														// integer value
				nextgen[i] = ruleset90[index];

			}
		} catch (Throwable t) {
		}
		cells = nextgen;
		CACell ca = new CACell();
		ca.c = nextgen;
		CAGeneration.ar.add(ca);
		l++;
		if (l == r) {

			CAGenerationSet cage = new CAGenerationSet();
			cage.printing(CAGeneration.ar, r);

		} else {
			try {
				rulecreation1(r);
			} catch (Throwable t) {
			}
		}

	}

	public void rulecreation2(int r) // for creation of rule 130
	{

		int[] nextgen = new int[64];
		try { // for handling deep recursion error
			for (int i = 1; i < cells.length - 1; i++) {

				String mm = "" + cells[i - 1] + cells[i] + cells[i + 1];
				int index = Integer.parseInt(mm, 2); // converts the string "mm"
														// to binary and then to
														// integer value
				nextgen[i] = ruleset130[index];

			}
		} catch (Throwable t) {
		}
		cells = nextgen;
		CACell ca = new CACell();
		ca.c = nextgen;
		CAGeneration.ar.add(ca);
		l++;
		if (l == r) {
			CAGenerationSet cage = new CAGenerationSet();
			cage.printing(CAGeneration.ar, r);

		} else {
			try {
				rulecreation2(r);
			} catch (Throwable t) {
			}
		}

	}

	public void rulecreation3(int r) // for creation of rule 165
	{

		int[] nextgen = new int[64];
		try { // for handling deep recursion error
			for (int i = 1; i < cells.length - 1; i++) {

				String mm = "" + cells[i - 1] + cells[i] + cells[i + 1];
				int index = Integer.parseInt(mm, 2); // converts the string "mm"
														// to binary and then to
														// integer value
				nextgen[i] = ruleset165[index];

			}
		} catch (Throwable t) {
		}
		cells = nextgen;
		CACell ca = new CACell();
		ca.c = nextgen;
		CAGeneration.ar.add(ca);
		l++;
		if (l == r) {
			CAGenerationSet cage = new CAGenerationSet();
			cage.printing(CAGeneration.ar, r);

		} else {
			try {
				rulecreation3(r);
			} catch (Throwable t) {
			}
		}

	}
}
