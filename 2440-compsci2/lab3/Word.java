import java.util.Arrays;
/**
 * Creates a Word object and counts syllables
 */
public class Word {
	String word;
	int syllables = 0;
	boolean vowel = false;
	char[] vowels = {'a','e','i','o','u'};
	public Word(String w) {
		word = w;
		Arrays.sort(vowels);
		countSyllables();
	}
	private void countSyllables() {
		for(int i = 1;i<word.length();i++){
			if(i == word.length()-1 && word.toLowerCase().charAt(i)=='e' && syllables != 1){
				syllables--;
			} else 	if(isVowel(word.charAt(i)) && vowel==false){
				syllables ++;
				vowel = true;
			} else  if(isVowel(word.charAt(i)) && vowel==true){
				vowel = true;
			} else {
				vowel = false;
			}
		}
	}
	private boolean isVowel(char charAt) {
		if(Arrays.binarySearch(vowels,charAt)>0){
			return true;
		}else{
			return false;
		}
	}
	public int getSyllables() {
		return syllables;
	}
}

