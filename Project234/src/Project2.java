public class Project2 {
    public boolean isPalindrome(String s) {
        // check the string is empty or not
        if (s == null || "".equals(s)) return true;
        int start = 0, end = s.length() - 1;
        while (start < end) {
            // check the character is letter or digit, if not jump that index
            if (!Character.isLetterOrDigit(s.charAt(start)))
            {
                start++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(end)))
            {
                end--;
                continue;
            }
            // Convert uppercase letters to lowercase letters
            if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end)))
            {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
