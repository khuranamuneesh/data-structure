public class SearchingSpecificWordsInList {
    public static String findSentenceWithWord(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.toLowerCase().contains(word.toLowerCase())) { // Case-insensitive search
                return sentence; // Return the first sentence containing the word
            }
        }
        return "Not Found"; // If no sentence contains the word
    }

    public static void main(String[] args) {
        String[] sentences = {
                "Java is a powerful programming language.",
                "Data structures and algorithms are essential for coding.",
                "Linear search is simple but not always efficient.",
                "Practice makes a programmer better."
        };

        String wordToFind = "search"; // Word to search for

        String result = findSentenceWithWord(sentences, wordToFind);

        System.out.println("Result: " + result);
    }
}

