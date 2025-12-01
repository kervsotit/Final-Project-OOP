# 💸📊PERSONAL EXPENSES TRACKER 
---

## 📝OVERVIEW
Personal Expenses Tracker is console-based program that allows the user to track, manage, and categorize their daily expenses. It is designed to make monitoring and spending simple and efficient by recording different types of expenses such as food, transportation, bills, and etc.

# OOP Concepts Applied
---
## 🛡️ ENCAPSULATION 
Encapsulation is applied in the Expenses class where it has four variables such as date, category, description and amount and declared it as private. This will prevent them from being accessed directly from outside the class and it will only can be accessed through the use of constructor. Also, it has getters methods which give controlled visibility to the values  when viewing the expenses.

---

## 🧬INHERITANCE 
Inheritance is applied to the most common expenses such as food, transportation, and bills by creating them as subclasses of the Expenses class. These subclasses inherit the properties of the parent class, which means they automatically receive the attributes and behavior of Expenses without rewriting them. Each subclass only sets its own category by calling super() in its constructor. For example, if the user inputs “Food” as the category, the program creates a Foodexpense object, and its behavior and data structure come from the parent Expenses class.

---

## 🎭 POLYMORPHISM
Polymorphism is applied in the program by allowing the Expenses parent type to store different subclass objects such as food, transport, and bills. Even though these objects come from different subclasses, polymorphism lets them be treated as one group while still keeping their own categories and behaviors. It is also shown through the ExpenseViewer interface, where the viewer is declared using the interface type but can use any class that implements it, allowing the same view() method to work differently depending on the specific viewer class.

---

## ⚙️ ABSTRACTION
Abstraction is applied by using the ExpenseViewer interface, which defines the view() method without revealing how the viewing process works, while ConsoleExpenseViewer provides the actual implementation. It is also shown in the Addexpense class, where the whole process of adding an expense is grouped into one method, hiding the internal steps so the main program only needs to call it.

---

## 📁 Project Structure

<img src="./structure ss.png" width="400">
- [Main.java](./src/Main.java)-

