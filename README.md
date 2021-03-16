# BullsAndCows from hyperskill.org

# Stage 1/7

## Description
Let's start by reminding ourselves how the game goes. There are two players: the first writes a secret 4-digit code using different digits, and the second has to guess it. At each turn, the second player writes a 4-digit number that they think might be the correct answer. Then, the first player grades that answer using bulls and cows as a notation. If a digit in the given answer matches a digit and its position in the code, it's called a "bull." If a given digit appears in the code but its position doesn't match, then it's called a "cow." The first player reveals how many bulls and cows there are. The information is general; in other words, it isn't bound to any particular digit. For example:

The code is 4931.
The answer is 1234.
The grade is 1 bull and 2 cows.

Here, 3 is a bull, 1 and 4 are cows. If all the digits are bulls, the secret code has been guessed and the game ends. If not, the game continues and the second player tries again.

This may sound rather complicated, but don't worry, we will take it very gradually. In this stage, you will not even have to implement the gameplay: all you need to do now is output the text that could be in the game. In other words, you don't have to worry about handling any requests or processing data: your goal is to display an example text of the game.

## Objectives
In this stage, your program should:

- Print a predefined game log that contains at least two turns.
- The output to be graded is a 4-digit code consisting of unique digits.
- The last line of your output contains a secret number.

## Example
```
The secret code is prepared: ****.

Turn 1. Answer:
1234
Grade: None.

Turn 2. Answer:
9876
Grade: 4 bulls.
Congrats! The secret code is 9876.
```
# Stage 2/7

## Description
Let's add some interactivity to our program. The program should create a 4-digit secret code, and the player should try to guess it on the first try. The program should give a grade to evaluate how accurate the player was.

As you remember, a correctly guessed digit is a cow, and if its position is also correct, then it is a bull. After the player tries to guess the secret code, the program should grade the attempt and finish the execution.

For example, if the secret code is 9305, then:

1. The number 9305 contains 4 bulls and 0 cows since all 4 digits are correct and their positions are correct as well. It's the only number that can contain 4 bulls, so it's also the secret code itself.
2. The numbers 3059, 3590, 5930, 5039 contain 0 bulls and 4 cows since all 4 digits are correct but their positions don't match the positions in the secret code.
3. The numbers 9306, 9385, 9505, 1305 contain 3 bulls.
4. The numbers 9350, 9035, 5309, 3905 contain 2 bulls and 2 cows.
5. The numbers 1293, 5012, 3512, 5129 contain 0 bulls and 2 cows.
6. The numbers 1246, 7184, 4862, 2718 contain 0 bulls and 0 cows.

Note that guesses can contain repetitive digits, so:

1. The number 1111 contains 0 bulls and 0 cows.
2. The number 9999 contains 1 bull and 3 cows.
3. The number 9955 contains 2 bulls and 2 cows.

## Objectives
In this stage, your goal is to write the core part of the game: the grader.

1. Your program should take a 4-digit number as an input.
2. Use a predefined 4-digit code and grade the answer that was input. You can do it digit by digit.
The grade is considered correct if it contains number-and-word pairs (like X bulls and Y cows) that give the correct information. If the answer doesn't contain any bulls and cows, you should output None.

## Example
```
Example 1
> 9087
Grade: 1 bull(s) and 1 cow(s). The secret code is 9305.
```
Example 2
```
> 1267
Grade: None. The secret code is 9305.
```
# Stage 3/7

## Description
Using a predefined secret code doesn't make a fun game. Let's implement the ability to generate a pseudo-random secret number of a given length. If the length is greater than 10, print a warning message and do not generate a number.

We suggest you use the following algorithm to generate the numbers:
```
long pseudoRandomNumber = System.nanoTime();
```
This code saves the nanoseconds elapsed since a certain time to the pseudoRandomNumber variable. We can assume that this is a random number. You can generate a secret code by iterating over the pseudoRandomNumber in the reverse order and adding unique digits. If the pseudoRandomNumber lacks the required amount of unique digits, call System.nanoTime() again and try to generate the secret code again until you get a satisfactory result.
## Objectives
In this stage, your program should generate a pseudo-random number of a given length with unique digits and print it. If the length is greater than 10, the program should print a message containing the word Error. The secret code may contain any digits from 0 to 9 but only once. Secret code shouldn't start with a digit 0: for the first digit of the secret code, use digits from 1 to 9.

Don't delete your previous work, just move your code to a separate method. You will need it in the future stages.

## Example
Example 1
```
> 5
The random secret number is 48379.
```
Example 2
```
> 4
The random secret number is 5213.
```
Example 3
```
> 11
Error: can't generate a secret number with a length of 11 because there aren't enough unique digits
```