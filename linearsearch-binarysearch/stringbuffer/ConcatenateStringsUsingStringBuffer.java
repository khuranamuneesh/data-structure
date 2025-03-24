
public class ConcatenateStringsUsingStringBuffer {
    public static String concatenate(String[] words) {
        StringBuffer result = new StringBuffer();

        for (String word : words) {
            result.append(word);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String[] words = {"Hello", " ", "World", "!", " Welcome", " to", " Java."};
        String output = concatenate(words);

        System.out.println("Concatenated String: " + output);
    }
}
