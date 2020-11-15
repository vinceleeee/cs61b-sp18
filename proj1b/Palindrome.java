public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
        Deque<Character> charDeque = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            charDeque.addLast(word.charAt(i));
        }
        return charDeque;
    }

    public boolean isPalindrome(String word) {
        if (word == null) {
            return false;
        }
        Deque<Character> characterDeque = wordToDeque(word);
        return isPalindrome(characterDeque);
    }

    private boolean isPalindrome(Deque<Character> characterDeque) {
        if (characterDeque.size() <= 1) {
            return true;
        }
        return characterDeque.removeLast().equals(characterDeque.removeFirst())
                && isPalindrome(characterDeque);
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word == null) {
            return false;
        }
        return isPalindrome(wordToDeque(word), cc);
    }

    private boolean isPalindrome(Deque<Character> characterDeque, CharacterComparator cc) {
        if (characterDeque.size() <= 1) {
            return true;
        }
        return cc.equalChars(characterDeque.removeFirst(), characterDeque.removeLast())
                && isPalindrome(characterDeque, cc);
    }
}
