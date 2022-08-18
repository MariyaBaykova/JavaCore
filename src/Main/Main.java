package Main;

public class Main {
    public static void main(String[] args) {
        doPhoneBook();
        WordsArray wordsArray = new WordsArray(createArrayWords());
        wordsArray.doArrayWords();

    }

    private static void doPhoneBook() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addElementPhoneBook("Mike","88005553555");
        phoneBook.addElementPhoneBook("Mike","88005553555");
        phoneBook.addElementPhoneBook("Mike","89007006655");

        phoneBook.addElementPhoneBook("Nick","12345");
        phoneBook.addElementPhoneBook("Nick","12345");
        phoneBook.addElementPhoneBook("Nick","123 456   ");
        phoneBook.addElementPhoneBook("Nick","12 34 56 ");
        phoneBook.addElementPhoneBook("Nick","1  23  456  7    ");

        System.out.println("Mike: " + phoneBook.getPhonesByName("Mike"));
        System.out.println("Nick: " + phoneBook.getPhonesByName("Nick"));
        System.out.println("Mary: " + phoneBook.getPhonesByName("Mary"));
        System.out.println("Anna: " + phoneBook.getPhonesByName("Anna"));
    }

    private static String[] createArrayWords() {
        String [] strings = new String[10];
        strings[0] = "Mama";
        strings[1] = "Papa";
        strings[2] = "Tom";
        strings[3] = "Andrew";
        strings[4] = "Mama";
        strings[5] = "Papa";
        strings[6] = "Kitti";
        strings[7] = "Finn";
        strings[8] = "Pavel";
        strings[9] = "Viki";
        return strings;
    }
}
