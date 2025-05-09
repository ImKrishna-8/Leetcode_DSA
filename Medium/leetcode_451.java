/*


---

### 🧠 **Concept: Sort characters in a string based on how frequently they appear (highest first)**

We're making a **priority queue of characters**, where the one who shouts the loudest (i.e., appears most) gets to come out first.

---

### 👨‍🏫 **Step-by-step Breakdown (with funny comments)**

---

#### 📦 Step 1: Create a `Pair` class

This is a fancy box that holds:

* a `char` (like `'A'` or `'3'`)
* its **frequency** (how many times it appears)

```java
class Pair {
    char c;
    int freq;

    public Pair(char c, int freq){
        this.c = c;
        this.freq = freq;
    }
}
```

> Think of it as a contestant on a reality show. `c` is their name, `freq` is how many fans they have (votes).

---

#### 🚨 Step 2: Create a max-heap PriorityQueue

```java
PriorityQueue<Pair> q = new PriorityQueue<>(new Comparator<Pair>() {
    public int compare(Pair a, Pair b) {
        return b.freq - a.freq; // bigger freq = higher priority
    }
});
```

> 🎯 **Goal**: We want the most popular characters (those with the highest frequency) to come out first — like Instagram influencers entering a party based on follower count. 💃📸

---

#### 🔢 Step 3: Count the characters

```java
int arr[] = new int[58];      // For letters (capital & small)
int digits[] = new int[10];   // For 0-9 digits
```

> 🧐 Why 58? Because `'z' - 'A' + 1 = 57`, and you're indexing like:
> `s.charAt(i) - 'A'` (works for both 'A'-'Z' and 'a'-'z' if needed later)

```java
for (int i = 0; i < s.length(); i++) {
    if(Character.isDigit(s.charAt(i))){
        digits[s.charAt(i)-'0']++; // Count digits
        continue;
    }
    arr[s.charAt(i) - 'A']++;     // Count letters
}
```

> 🧮 We loop over the string and start counting like a cashier at a candy store:

* "1 chocolate 🍫... 2 chocolates 🍫🍫... A letter A? Noted 📝..."

---

#### 💌 Step 4: Stuff the popular people (characters) into the priority queue

```java
for (int i = 0; i < arr.length; i++) {
    if(arr[i] > 0){
        Pair pair = new Pair((char)(i + 'A'), arr[i]);
        q.add(pair);
    }
}
```

> Here we go: "Yo A, you came 5 times. Into the VIP queue!"
> We convert `i` back to character using `(char)(i + 'A')`.

---

#### 🔢 Step 5: Add digits to the queue too!

```java
for (int i = 0; i < digits.length; i++) {
    if(digits[i] > 0){
        Pair pair = new Pair((char)(i + '0'), digits[i]);
        q.add(pair);
    }
}
```

> Numbers don’t want to feel left out: “Digit 3 showed up 4 times? Get in line!”

---

#### 🧱 Step 6: Build the result string

```java
StringBuilder str = new StringBuilder();

while(!q.isEmpty()){
    Pair p = q.poll(); // Take out most frequent char
    for(int i = 0; i < p.freq; i++){
        str.append(p.c); // Add that char p.freq times
    }
}
```

> We roll out the red carpet and let the **loudest fans** walk out first.
> So if `A` had `5` votes → `"AAAAA"`
> then `B` with `3` votes → `"BBB"`
> Total result: `"AAAAABBB"`

---

#### 🏁 Step 7: Return it!

```java
return str.toString();
```

---

### ✅ What does this whole thing do?

> It sorts all the letters and digits in your string by how often they appear — **most frequent first** — and returns a new string made by repeating each character based on its frequency.

---

### 🧠 Quick Revision Tip (Like Talking to Yourself)

* **Pair class** = holds char and count (like player and score)
* **PriorityQueue** = max-heap of those pairs
* **arr\[]** = letter counter
* **digits\[]** = number counter
* **add Pair to PQ** = if someone shows up, record them
* **poll & build string** = let the most frequent characters party first

---

### 🎉 Example:

Input: `"aab1b1c"`
Output: `"bb11aa"`, `"11bbac"` or any correct **frequency-based order** (as long as high freq first).

---
*/


class Pair {
    char c;
    int freq;

    public Pair(char c,int freq){
        this.c=c;
        this.freq=freq;
    }
}

class Solution {
    public String frequencySort(String s) {
        PriorityQueue<Pair> q = new PriorityQueue<>(new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                return b.freq - a.freq; // Max-heap
            }
        });

        int arr[] = new int[58];
        int digits[] = new int[10];
        for (int i = 0; i < s.length(); i++) {
            if(Character.isDigit(s.charAt(i))){
                digits[s.charAt(i)-'0']++;
                continue;
            }
            arr[s.charAt(i) - 'A']++;
        }

        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>0){
                Pair pair = new Pair((char)(i+'A') , arr[i]);
                q.add(pair);
            }
        }

    for (int i = 0; i < digits.length; i++) {
            if(digits[i]>0){
                Pair pair = new Pair((char)(i+'0') , digits[i]);
                q.add(pair);
            }
        }

        StringBuilder str = new StringBuilder();

        while(!q.isEmpty()){
            Pair p = q.poll();
            for(int i=0;i<p.freq;i++){
                str.append(p.c);
            }
        }
        return str.toString();
    }
}
