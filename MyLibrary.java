import java.util.* ;
import java.io.* ;

public class MyLibrary {

    public static ArrayList<String> readTheFileToArrayList(String filnam) {
        ArrayList<String> contents = new ArrayList<>() ;

        File the_file = new File(filnam) ;
        try (Scanner fil_scanner = new Scanner(the_file)) {
            //this part executes if the try succeds

            while(fil_scanner.hasNextLine()) {
                String one_line_from_file = fil_scanner.nextLine() ;
                contents.add(one_line_from_file) ;


            } //while loop


        } catch (FileNotFoundException e) {
            //executes when the attempt fails
            System.out.println("could not open file: " + filnam) ;
            System.exit(0) ;

        }

        // Scanner fil_scanner = new Scanner(new File(filnam)) ;


        return contents;


    } //function call

    public static String alphaS(String word) {

        char [] charAr = word.toCharArray() ;
        Arrays.sort(charAr) ;
        String sortS = new String(charAr) ;
        return sortS ;




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


} //class