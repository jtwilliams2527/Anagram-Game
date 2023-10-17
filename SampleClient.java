import java.util.*;

public class SampleClient {
    //constant
    static final String WORDS_FILE_NAME = "anagram_words.txt" ;

    public static void main (String [] args) {
        ArrayList<String> wordsL = MyLibrary.readTheFileToArrayList(WORDS_FILE_NAME) ;
        // System.out.printf("There are %d words\n",wordsL.size()) ;

        Map<String,List<String>> anagram = getWAnagrams(wordsL) ;
        // System.out.println(anagram) ;

        Map<String,List<String>> onlyAnaMap = genClnMap (anagram) ;
        // System.out.println(onlyAnaMap) ;

        String targetWord = getTargetWord(onlyAnaMap,wordsL) ;
        // System.out.println(targetWord) ;

        Scanner console = new Scanner(System.in) ;
        String playAgainResponse = "y" ;

        while(playAgainResponse.equals("y")) {
            anaGame(onlyAnaMap,wordsL) ;
            System.out.print("Would you like to play another round with a new target word? Y/N ") ;
            String response = console.next() ;

            playAgainResponse = response.toLowerCase() ;



        } //while loop
        System.out.println("Thank you for playing!") ;

    } //main

    public static Map<String,List<String>> getWAnagrams(ArrayList<String> wordL) {
        Map <String,List<String>> result = new HashMap <> () ;

        for(int i = 0; i < wordL.size(); i++) {

            String word = wordL.get(i) ;

            String alphaW = MyLibrary.alphaS(word) ;

            if(result.containsKey(alphaW) ) {
                result.get(alphaW).add(word) ;

            } //if statement
            else{
                List<String> anaWord = new ArrayList <> () ;
                anaWord.add(word) ;
                result.put(alphaW,anaWord) ;

            } //else
        } //for loop

        return result;

    } //function call

    public static Map<String,List<String>> genClnMap (Map<String,List<String>> anaMap) {
        Map<String,List<String>> result = new HashMap <> () ;

        for(Map.Entry<String,List<String>> z : anaMap.entrySet()) {
            if(z.getValue().size() > 1) {
                result.put(z.getKey(),z.getValue()) ;

            } //if statement

        } //for loop

        return result;


    } //function call

    public static String getTargetWord(Map<String,List<String>> anaMap, List<String> wordL) {
        Random randInt = new Random() ;
        String result = "" ;


        while(result.isEmpty()) {
            int num2 = randInt.nextInt(wordL.size() + 1 ) ;

            String randWord2 = wordL.get(num2) ;
            String alphaRWord2 = MyLibrary.alphaS(randWord2) ;

            if(anaMap.containsKey(alphaRWord2)) {
                // System.out.println(anaMap.get(alphaRWord2)) ;
                result = randWord2;


            } //if statement




        } //while loop
        return result;










    } //function call

    public static void anaGame(Map<String, List<String>> anaMap, List <String> wordL) {
        String response = "y";
        String startRound = "n";
        int wordCounter = 0;
        int anaCounter = 0;
        int score = 0;

        String targetWord = MyLibrary.getTargetWord(anaMap, wordL);
        System.out.println("Welcome to the Anagram Game\nYour target word is: " + targetWord);
        String alphaTW = MyLibrary.alphaS(targetWord);
        System.out.println(anaMap.get(alphaTW));

        Scanner console = new Scanner(System.in);

        while (response.equals("y") && anaCounter != anaMap.get(alphaTW).size() - 1 && startRound.equals("n")) {
            System.out.print("Please enter an anagram for the target word: ");
            String guessWord = console.next();
            wordCounter += 1;

            String alphaGW = MyLibrary.alphaS(guessWord);
            Set<String> uniAna = new HashSet<>();

            if (guessWord.equals(targetWord)) {
                System.out.print("The word you entered was the target word itself, which is not an anagram. You did not earn any points. Would you like to enter another word? Y/N ");
                String anotherWord = console.next();
                System.out.println("Your score: " + score);
                response = anotherWord.toLowerCase();
            } //if statement

            else if (!anaMap.get(alphaTW).contains(guessWord) || !wordL.contains(guessWord)) {
                System.out.print("The word you entered is not an anagram of the target word or it's an invalid word. You did not earn any points. Would you like to enter another word? Y/N ");
                String anotherWord2 = console.next();
                System.out.println("Your score: " + score);
                response = anotherWord2.toLowerCase();
            } //else if

            else if (anaMap.get(alphaTW).contains(guessWord)) {
                if (!targetWord.equals(guessWord) && !uniAna.contains(guessWord)) {
                    System.out.println("The word you entered is an anagram of the target word.");
                    anaCounter += 1;
                    score += 1;

                    uniAna.add(guessWord);

                    if (anaCounter != anaMap.get(alphaTW).size() - 1) {
                        System.out.print("Would you like to enter another word? Y/N ");
                        String anotherWord3 = console.next();
                        response = anotherWord3.toLowerCase();
                    } //if statement

                    System.out.println("Your score: " + score);
                } //if statement
            } //else if
        } //while loop

        if (!response.equals("y")) {
            System.out.println("The number of words entered: " + wordCounter);
            System.out.println("The number of words entered that were anagrams: " + anaCounter);
            System.out.println("Your final score: " + score);
        } //if statement

        else if (anaCounter == anaMap.get(alphaTW).size() - 1) {
            System.out.println("\n\nCongratulations! You have entered the total number of anagrams for the target word!");
            System.out.println("The number of words entered: " + wordCounter);
            System.out.println("The number of words entered that were anagrams: " + anaCounter);
            System.out.println("Your final score: " + score);
        } //else if
    } //function call














} //class