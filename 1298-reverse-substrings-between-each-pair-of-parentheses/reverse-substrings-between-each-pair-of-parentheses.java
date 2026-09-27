class Solution {
    public String reverseParentheses(String s) {

        Stack<StringBuilder> stack = new Stack<>();

        StringBuilder current = new StringBuilder();

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                // Save the current string
                stack.push(current);

                // Start a new string
                current = new StringBuilder();
            }

            else if (ch == ')') {
                // Reverse the current substring
                current.reverse();

                // Get the previous string
                StringBuilder previous = stack.pop();

                // Join them
                previous.append(current);

                current = previous;
            }

            else {
                // Normal character
                current.append(ch);
            }
        }

        return current.toString();
    }
}