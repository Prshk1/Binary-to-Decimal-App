# Activity 2 – Binary to Decimal Converter App (8-bit)

This project is an Android application developed for **Free Elective 3: Mobile Computing**. The main focus of this activity is the use of **Plain Text (EditText)** inputs and the **`doAfterTextChanged`** function to dynamically process user input.

The application converts an **8-bit binary number** into its **decimal equivalent** while showing step-by-step results for learning purposes.

---

## Application Overview

The app allows the user to:

* Enter binary values (`0` or `1`) for each bit
* View the decimal value of each individual bit
* Display the full 8-bit binary number
* Compute and display the final decimal result

This project is designed for **educational and demonstration purposes**.

---

## Features

* Accepts **binary input only (0 or 1)**
* Uses **Plain Text (EditText)** with `doAfterTextChanged`
* Real-time update of per-bit decimal values
* Displays **8-bit binary overview (MSB to LSB)**
* Calculates and displays the **final decimal value**
* Default value is **0** when input is empty
* Clear button resets:

  * All binary inputs
  * Per-bit decimal values
  * Binary overview
  * Final decimal result
---
## Screenshots
![c1773c54-feec-4a39-b55c-7792712cd377](https://github.com/user-attachments/assets/b9568eea-ef52-4195-8e6d-51bf9ee05086)
![935af0ba-51d3-4706-a482-2b0c48f4e23a](https://github.com/user-attachments/assets/9527a079-4c43-4527-aac4-b50dc71c5d7c)

---

## How the Converter Works

Each binary digit (bit) has a fixed decimal weight:

| Bit Position | Binary Weight |
| ------------ | ------------- |
| Bit 8 (MSB)  | 128           |
| Bit 7        | 64            |
| Bit 6        | 32            |
| Bit 5        | 16            |
| Bit 4        | 8             |
| Bit 3        | 4             |
| Bit 2        | 2             |
| Bit 1 (LSB)  | 1             |

### Example

Binary Input:

```
1 0 1 0 1 0 1 1
```

Decimal Calculation:

```
128 + 32 + 8 + 2 + 1 = 171
```

---

## Technologies Used

* **Android Studio**
* **Kotlin**
* Android SDK

---

## Key Concepts Used

* Plain Text (`EditText`)
* `doAfterTextChanged` listener
* Event handling using buttons
* Basic loops and conditional statements
* Simple UI updates using `TextView`

---

## Purpose of the Activity

The main objective of this activity is to:

* Practice handling user input using Plain Text
* Understand real-time input processing using `doAfterTextChanged`
* Apply basic binary-to-decimal conversion logic
* Create a clean and beginner-friendly Android application

Additional features such as reset functionality and binary overview were added to improve usability and learning experience.

---

## Developer Information

**Carl Alfred G. Chan**  
BSIT – 405  
Free Elective 3: Mobile Computing  

---

## Release Information

This repository includes:

* Source code
* APK file for testing and demonstration

This project is intended for **academic submission and learning purposes only**.
