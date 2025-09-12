# Elementary Cellular Automata in Java

A little Java program that simulates **elementary cellular automata** for all rules from **0 up to 255**.  

The program is designed to work with configurations using **`.`** (dead cell) and **`x`** (alive cell).  
By default, the first and last cell of each generation must always be a `.` (dot).  

---

## Features
- Supports **all rules (0–255)**.  
- You can change the **line length** to control the width of the automaton.  
- You can modify the **initial configuration** (first generation) as you like.  
- Simple console output using only `.` and `x`.  

---

## Example
Start configuration:
...........................x.

markdown
Code kopieren

Rule **110** (20 generations):
..........................xx.
.........................xxx.
........................xx.x.
.......................xxxxx.
......................xx...x.
.....................xxx..xx.
....................xx.x.xxx.
...................xxxxxxx.x.
..................xx.....xxx.
.................xxx....xx.x.
................xx.x...xxxxx.
...............xxxxx..xx...x.
..............xx...x.xxx..xx.
.............xxx..xxxx.x.xxx.
............xx.x.xx..xxxxx.x.
...........xxxxxxxx.xx...xxx.
..........xx......xxxx..xx.x.
.........xxx.....xx..x.xxxxx.
........xx.x....xxx.xxxx...x.
.......xxxxx...xx.xxx..x..xx. 


---

## How to Use
1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/cellular-automata-java.git
