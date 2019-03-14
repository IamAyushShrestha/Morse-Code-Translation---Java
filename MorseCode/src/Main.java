import java.util.*;
public class Main {
    /**
     * @author Ayush Shrestha
     * @param args
     */

        public static void main ( String [] args )
        {
            {
/* Scanner object to scan user input*/
                Scanner input = new Scanner(System.in);

                String chars = "";
                String words = "";
                String morseWords = "";
                String text = "";
                String UserIn = "";
                int ch = 0;
                int a;
                /*Array of english alphabet and its corresponding morse code*/
                final  String[] EngArray = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L",
                        "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
                        "Y", "Z", " ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};

                final String[] MorseArray = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
                        ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.",
                        "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", " ",
                        ".----", "..---", "...--", "....-", ".....", "-....", "--...",
                        "---..", "----.", "-----"};
                /* Showing user interface*/
                while(ch == 0) {

                    System.out.println("Enter 1 for English to Morse:\n"+"Enter 2 for Morse to English:");
                    a= input.nextInt();
                /* validating input */
                    while (a<=0|| a>=3)  {
                        System.out.println("\nInvalid response. \nPlease enter 1 or 2.\n");
                        System.out.println("Enter 1 for English to Morse:\n"+"Enter 2 for Morse to English:");
                        a= input.nextInt();
                    }
                    if (a==1) {
                        System.out.print("\nEnter text here: ");
                        input.nextLine();
                        text = input.nextLine();

                        System.out.println("\nYour text: " + text.toUpperCase());
                        text = text.toUpperCase();
                        System.out.print("In morse code: ");

                        /* evaluating english and assigning morse code to display*/

                        for (int count = 0; count < text.length(); count++) {
                            for (int i = 0; i < EngArray.length; i++) {
                                if (text.substring(count, (count + 1)).equals(EngArray[i]))
                                    System.out.print(MorseArray[i] + " ");
                            }
                        }

                        /* scanning morse code and ouputs English text*/

                    } else if (a==2) {
                        System.out.print("\nEnter Morse-code text: ");
                        input.nextLine();
                        text = input.nextLine();

                        String[] Morse = text.split("   ");

                        System.out.println("\nYou entered: " + text);
                        System.out.print("In English: ");

                        for (int i = 0; i < Morse.length; i++) {
                            words = Morse[i];

                            String[] MorseCh = words.split(" ");

                            for (int j = 0; j < MorseCh.length; j++) {
                                chars += MorseCh[j];


                                for (int index = 0; index < MorseArray.length; index++) {
                                    if (chars.equals(MorseArray[index]))
                                        morseWords += EngArray[index];
                                }
                                chars = "";
                            }
                            morseWords += " ";
                            words = "";
                        }
                        System.out.println(morseWords);
                    }
                    ch++;

                    System.out.print("\n\ncontinue:(Y or N): ");
                    UserIn = input.next();

                    while (!(UserIn.equalsIgnoreCase("Y") || UserIn.equalsIgnoreCase("N"))) {
                        System.out.print("\nIncorrect input.Enter either 'Y' or 'N'.");
                        UserIn = input.next();
                    }
                    if (UserIn.equalsIgnoreCase("Y")) {
                        morseWords = "";
                        ch = 0;
                    } else {
                        System.out.println("Exiting...");
                        input.close();
                    }

                }
            }
        }
}