public class PalindromeChecker {
    String text;
    PalindromeChecker(String text){
        this.text=text;
    }
    void Palindrome(){
        String clearText=text.toLowerCase();
        StringBuilder sb=new StringBuilder(clearText);
        String newStr=sb.reverse().toString();
        if(text.equals(newStr)){
            System.out.println("Its a Plaindrome");
        }
        else{
            System.out.println("Not a Palindrome");
        }
    }
    public static void main(String[] args){
        // Scanner sc=new Scanner(System.in);
        // String input=sc.nextLine();
        PalindromeChecker pc=new PalindromeChecker("131");
        pc.Palindrome();
    }
}
