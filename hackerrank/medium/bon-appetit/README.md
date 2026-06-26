# Bill Division

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Two friends Anna and Brian, are deciding how to split the bill at a dinner. Each will only pay for the items they consume. Brian gets the check and calculates Anna's portion.  You must determine if his calculation is correct.

For example, assume the bill has the following prices: $bill = [2, 4, 6]$.  Anna declines to eat item $k = bill[2]$ which costs $6$.  If Brian calculates the bill correctly, Anna will pay $(2 + 4) / 2 = 3$.  If he includes the cost of $bill[2]$, he will calculate $(2 + 4 + 6)/ 2 = 6$.  In the second case, he should refund $3$ to Anna.

**Function Description**  

Complete the *bonAppetit* function in the editor below.  It should print `Bon Appetit` if the bill is fairly split.  Otherwise, it should print the integer amount of money that Brian owes Anna.  

bonAppetit has the following parameter(s):  

- *bill*: an array of integers representing the cost of each item ordered  
- *k*: an integer representing the zero-based index of the item Anna doesn't eat  
- *b*: the amount of money that Anna contributed to the bill  

**Input Format**

The first line contains two space-separated integers $n$ and $k$, the number of items ordered and the $0$-based index of the item that Anna did not eat.  		
The second line contains $n$ space-separated integers $bill[i]$ where $0 \le i \lt n$.  
The third line contains an integer, $b$, the amount of money that Brian charged Anna for her share of the bill.

**Constraints**

+ $2 \le n \le 10^5$  
+ $0 \le k \lt n$  
+ $0 \le bill[i] \le 10^4$  
+ $0 \le b \le \sum\limits_{i=0}^{n-1} bill[i]$    
+ The amount of money due Anna will always be an integer  

**Output Format**

If Brian did not overcharge Anna, print `Bon Appetit` on a new line; otherwise, print the difference (i.e., $b_{charged} - b_{actual}$) that Brian must refund to Anna.  This will always be an integer.  

**Sample Input 0**  

    4 1
    3 10 2 9
    12

**Sample Output 0**  

    5

**Explanation 0**  
Anna didn't eat item $bill[1] = 10$, but she shared the rest of the items with Brian. The total cost of the shared items is $3 + 2 + 9 = 14$ and, split in half, the cost per person is $b_{actual} = 7$. Brian charged her $b_{charged} = 12$ for her portion of the bill. We print the amount Anna was overcharged, $b_{charged} - b_{actual} = 12 - 7 = 5$, on a new line.

**Sample Input 1**  

    4 1
    3 10 2 9
    7

**Sample Output 1**  

    Bon Appetit
    
**Explanation 1**  
Anna didn't eat item $bill[1] = 10$, but she shared the rest of the items with Brian. The total cost of the shared items is $3 + 2 + 9 = 14$ and, split in half, the cost per person is $b_{actual} = 7$. Because $b_{actual} = b_{charged} = 7$, we print `Bon Appetit` on a new line.

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-06-26T14:41:55.479Z  

```cpp
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'bonAppetit' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY bill
     *  2. INTEGER k
     *  3. INTEGER b
     */


    public static void bonAppetit(List<Integer> bill, int k, int b) {

        int sum = 0;

        for (int i = 0; i < bill.size(); i++) {
            if (i != k) {
                sum += bill.get(i);
            }
        }

        int actualShare = sum / 2;

        if (actualShare == b) {
            System.out.println("Bon Appetit");
        } else {
            System.out.println(b - actualShare);
        }
    
}

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> bill = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int b = Integer.parseInt(bufferedReader.readLine().trim());

        Result.bonAppetit(bill, k, b);

        bufferedReader.close();
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/bon-appetit/problem)