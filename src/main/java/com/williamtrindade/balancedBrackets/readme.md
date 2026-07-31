# Balanced Brackets

This repository contains an optimized Java solution for the **Balanced Brackets** algorithmic challenge (commonly found on platforms like HackerRank).

## Problem Description

A bracket is considered to be any one of the following characters: `(`, `)`, `{`, `}`, `[`, or `]`.

Two brackets are considered to be a matched pair if the an opening bracket (i.e., `(`, `[`, or `{`) occurs to the left of a closing bracket (i.e., `)`, `]`, or `}`) of the exact same type. There are three types of matched pairs of brackets: `[]`, `{}`, and `()`.

A matching pair of brackets is not balanced if the set of brackets it encloses are not matched. For example, `{[(])}` is not balanced because the contents in between `{` and `}` are not balanced. The pair of square brackets encloses a single, unbalanced opening bracket, `(`, and the pair of parentheses encloses a single, unbalanced closing square bracket, `]`.

By this logic, we say a sequence of brackets is balanced if the following conditions are met:
- It contains no unmatched brackets.
- The subset of brackets enclosed within the confines of a matched pair of brackets is also a matched pair of brackets.

Given `n` strings of brackets, determine whether each sequence of brackets is balanced. If a string is balanced, return `YES`. Otherwise, return `NO`.

### Constraints
- $1 \le n \le 10^3$
- $1 \le |s| \le 10^3$, where $|s|$ is the length of the sequence.
- All characters in the sequences $\in \{ \{, \}, (, ), [, ] \}$.

---

## Example

**Sample Input:**
```text
3
{[()]}
{[(])}
{{[[(())]]}}
```

**Sample Output:**
```text
YES
NO
YES
```

**Explanation:**
1. The string `{[()]}` meets both criteria for being a balanced string.
2. The string `{[(])}` is not balanced because the brackets enclosed by the matched pair `{` and `}` are not balanced: `[(])`.
3. The string `{{[[(())]]}}` meets both criteria for being a balanced string.

---

## Solution & Approach

The optimal way to solve this problem is by using a **Stack (Pilha)** data structure.

### Logic:
1. Iterate through the string one character at a time.
2. If the character is an opening bracket (`{`, `[`, `(`), we push it onto the stack (or simply push the corresponding closing bracket to make comparison easier).
3. If the character is a closing bracket (`}`, `]`, `)`), we check the top of the stack.
    - If the stack is empty, it means there is a closing bracket without an opening one (return `NO`).
    - If the top of the stack doesn't match the current closing bracket, the sequence is unbalanced (return `NO`).
    - Otherwise, we pop the element from the stack and continue.
4. Finally, if the stack is completely empty after checking all characters, the string is perfectly balanced (return `YES`).

### Optimized Java Implementation

This solution avoids the legacy `Stack` class (which is synchronized and slower) in favor of `ArrayDeque`, and uses `Map.of` for a clean, immutable lookup table. It also includes an early exit condition if the stack grows larger than half of the string length.

```java
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class Solution {
    
    public static String isBalanced(String s) {
        // Immutable map for quick O(1) lookups
        Map<Character, Character> mapClose = Map.of(
            '}', '{',
            ']', '[',
            ')', '('
        );
        
        // ArrayDeque is faster than java.util.Stack
        Deque<Character> stack = new ArrayDeque<>();
        
        // A perfectly balanced string can't have more opening brackets than half its length
        int maxStackSize = s.length() / 2; 

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i); 
            
            // Early exit optimization
            if (stack.size() > maxStackSize) {
                return "NO";
            }
            
            // If it's a closing bracket
            if (mapClose.containsKey(c)) {
                if (stack.isEmpty()) {
                    return "NO";
                }
                // Check if it matches the most recent opening bracket
                if (mapClose.get(c) != stack.pop()) {
                    return "NO";
                }
            } 
            // If it's an opening bracket
            else {
                stack.push(c);
            }
        }
        
        return stack.isEmpty() ? "YES" : "NO";
    }
}
```

### Complexity Analysis
* **Time Complexity:** $O(N)$ - Where $N$ is the length of the string. We iterate through the string exactly once, and `push`/`pop`/`map lookups` all take $O(1)$ time.
* **Space Complexity:** $O(N)$ - In the worst-case scenario (e.g., `((((((`), all characters are pushed onto the stack. However, the optimization limits it to $O(N/2)$, which simplifies to $O(N)$.