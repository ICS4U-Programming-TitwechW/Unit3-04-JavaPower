import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
* Program return the result of the base.
*
* @author Titwech Wal
* @version 1.0
* @since   2023-06-01
*/

public final class RecPow {

    /**
     * This is a private constructor used to satisfy the
     * style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private RecPow() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the main method.
     *
     * @param args Unused.
     */
    public static void main(String[] args) {

        // Pass path to file as parameter.
        final File input = new File("input.txt");

        // Display on the marks spreadsheet.
        final File output = new File("output.txt");

        try {
            // Create FileWriter object to write to file.
            final FileWriter fW = new FileWriter(output);
            // Create Scanner object to read from file.
            final Scanner sc = new Scanner(input);
            // Create PrintWriter object to write to file.
            final PrintWriter write = new PrintWriter(fW);

            // Create a list to add values.
            final ArrayList<String> inpList = new ArrayList<String>();

            while (sc.hasNextLine()) {
                // Read line as string.
                final String str = sc.nextLine();

                // Add into list.
                inpList.add(str);

            }

            // Go through input list
            for (String inputTxt : inpList) {
                try {
                    // Split base and exponent into sting.
                    final String[] inpParts = inputTxt.split(" ");

                    // Parse exponents as integers.
                    final int base = Integer.parseInt(inpParts[0]);
                    final int exp = Integer.parseInt(inpParts[1]);

                    if (base >= 1 || exp >= 0) {
                        // call the function to call the power.
                        final int recPower = RecPowAns(base, exp);

                        // Write to output file and console.
                        write.print("The number " + base);
                        write.print("^" + exp);
                        write.println(" is = " + recPower);

                        System.out.print("The number " + base);
                        System.out.print("^" + exp);
                        System.out.println(" is = " + recPower);

                    } else {
                        write.println("Please enter a positive number.");
                        System.out.println("Please enter a positive number.");
                    }

                } catch (NumberFormatException error) {
                    System.out.println("An error occurred: "
                        + error.getMessage());
                    write.println("An error occurred: "
                        + error.getMessage());
                }
            }

            // Closes scanner & writer.
            write.close();
            sc.close();

        } catch (IOException error) {
            System.out.println("An error occurred: "
                + error.getMessage());
        }
    }

    /**
     * This function returns n.
     *
     * @param base
     * @param exp
     *
     * @return n
     *
     */
    public static int RecPowAns(int base, int exp) {

        // See if the line is empty.
        // If it is return the line.
        if (exp == 0) {
            return 1;
        } else {

            // Re-call the function with all characters but the first.
            return RecPowAns(base, exp - 1) * base;
        }
    }
}
