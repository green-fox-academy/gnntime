package aa;

public class MultipleCharacters {

  /*//létrehozunk egy új ArrayListet ami Character típusu
//ebbe tesszük bele az előző ArrayListet
  List<Character> chars = new ArrayList<>();
        for (String line : lines) {      //kiolvassuk a line ArrayListből az elemeket
    for (char c : line.toCharArray()) {      //a kiolvasott elemeket CharArray-jé alakítjuk
      chars.add(c);               //hozzáadjuk a chars ArrayListhez a karaktereket
    }
  }
  //Most már megvannak a karakterek egy Character ArrayList-ben
//Létrehozunk egy új ArrayListet amibe belerakjuk az újból kiolvasni kívánt karaktereket
//Létrehozunk egy HashMap-et amibe bele fogjuk rakni az új AL-ből a karaktereket és számukat
  List<Character> uniqueChars = new ArrayList<>();
  HashMap<Character, Integer> lettersAndOccurences = new HashMap<>();
//Kiolvassuk a chars ArrayListből a karaktereket
//Ha nem tartalmazza az új ArraryList őket akkor hozzáadja és
//beletesszük továbbá a HashMap-be is őket
        for (char c : chars) {
    if (!uniqueChars.contains(c)) {
      uniqueChars.add(c);
      lettersAndOccurences.put(c, 0);
    }
  }
//Ismét végig megyünk a char AL-en, hogy ellenőrizzük a karakterek ismétlődését
//bejárjuk a HashMap-et (entry) és ha a Key megegyezik a beolvasás elemével akkor
//létrehozunk egy változót (temp) ami megegyezik az értékkel és mindig növelni fogja
//az értéket 1-el ha egyezést talált, majd beállítjuk ezt az értéket
        for (char c : chars) {
    for (Map.Entry<Character, Integer> entry : lettersAndOccurences.entrySet()) {
      if (entry.getKey().equals(c)) {
        int temp = entry.getValue();
        temp++;
        entry.setValue(temp);
      }
    }
  }
  //létrehozunk két tömböt amibe bele fogjuk helyezni a KÉT legnagyobb értéket
//majd 2x lefuttatjuk a for LOOP-ot és a for LOOP vége előtt kitöröljük az első
//legtöbb karaktert, így találja meg a 2. legtöbb karaktert
//a for LOOP-ban 2x fut le, hogy megkapjuk a két-két értéket
// 2. for: belépünk a HashMap-be és végig fut a value-on a HashMap és a legnagyobb értékű
// betűt beteszi a tömbbe
//3. for: belépünk a HashMap-be és végig fut a value-n és megkeresi, hogy hol egyenlő a betű
//és ott bele teszi a Key-t(betűt) a tömbjébe, így a 2 tömb első eleme 1 pár
//majd törli a HashMap-ból a Key-t (betűt) így még 1x lefut és megtalálja a 2. párt is
//végül vissza return-jük az értékeket
  int[] twoHighestOccurences = new int[2];
  char[] twoMostCommonLetters = new char[2];
        for (int i = 0; i < 2; i++) {
    for (Map.Entry<Character, Integer> entry : lettersAndOccurences.entrySet()) {
      if (entry.getValue() >= twoHighestOccurences[i]) {
        twoHighestOccurences[i] = entry.getValue();
      }
    }
    for (Map.Entry<Character, Integer> entry : lettersAndOccurences.entrySet()){
      if (entry.getValue() == twoHighestOccurences[i]){
        twoMostCommonLetters[i] = entry.getKey();
      }
    }
    lettersAndOccurences.remove(twoMostCommonLetters[i]);
  }
        return twoMostCommonLetters[0] + " : " + twoHighestOccurences[0] + "\n" +
  twoMostCommonLetters[1] + " : " + twoHighestOccurences[1];
}*/

}
