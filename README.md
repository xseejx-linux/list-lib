---

# Custom Java List Implementation

## **Introduction**
This project is a custom implementation of a **List** in Java. The primary goal of this project is to gain a deeper understanding of how lists work under the hood by building one from scratch.
Unlike Java's built-in `ArrayList or `LinkedList`, this implementation is designed purely for educational purposes.

The custom List is built using **nodes**, where each node contains
- **obj** The object stored in the node.
- **link** A reference (or pointer) to the next node in the list.

This structure allows the list to grow dynamically, unlike arrays, which have a fixed size.

---

## **Features**
- **Dynamic memory allocation**: The list grows as needed, without requiring a predefined size.
- **Node-based structure**: Each element is stored in a node, which links to the next node.
- **Custom methods**: Includes basic operations like adding, removing, sorting.

---

## **Comparison: List vs Array**

### **Advantages of a List**
1. **Dynamic size**: Lists can grow or shrink as needed, whereas arrays have a fixed size.
2. **Efficient insertion/deletion**: Adding or removing elements in the middle of a list is more efficient since it doesn't require shifting elements like an array.
3. **Memory usage**: Lists allocate memory dynamically, which can be more efficient for unpredictable data sizes.

### **Disadvantages of a List**
1. **Memory overhead**: Each node in a list requires extra memory for the `link` attribute, making it less memory-efficient than arrays for small datasets.
2. **Access time**: Accessing an element in a list requires traversal from the head node, resulting in O(n) time complexity, whereas arrays provide O(1) access time.
3. **Cache performance**: Arrays are stored in contiguous memory locations, making them more cache-friendly compared to lists.

---

## **How to Use**
1. Clone the repository:
   ```bash
   git clone https://github.com/xseejx-linux/list-lib.git
   ```
2. Navigate to the project directory:
   ```bash
   cd list-lib
   ```
3. Compiling the Java Files:
   ```bash
   javac src/main/java/list/*.java
   ```
4. Running the Program:
   ```bash
   java -cp src/main/java list.App
   ```
---

## **Future Improvements**
- [ ] Implement an Iterator (allows to traverse the list using a for-each loop)
- [ ] Support generics
- [ ] Custom sorting using Comparator

---

## **TODO**
- [ ] Write detailed documentation for each method.

---

Feel free to contribute or provide feedback to improve this project! 😊

--- 
