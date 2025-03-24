public class ReverseStringUsingStringBuilder {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Hello");
        for(int i=0; i< sb.length()/2; i++)
        {
            char front = sb.charAt(i); //0
            char last = sb.charAt(sb.length()-1-i); //5-1-0 =4
            sb.setCharAt(i,last);
            sb.setCharAt(sb.length()-1-i,front);
        }
        System.out.println(sb);
    }
}