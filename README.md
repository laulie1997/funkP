Ein 4x4 Sudoku, Eingaben erfolgen im Format Zeile Spalte Zahl mit jeweils einem Leerzeichen dazwischen.
Ganz funktionieren tut es leider nicht, jedoch unterscheiden sich die Ausgaben bei einem richtig und falsch gelösten Sudoku inzwischen wenigstens.


![image](https://github.com/laulie1997/funkP/assets/57483600/392390d1-f6b7-48f7-acd2-ec8c4543f5d6)


Bei einem falsch gelösten Sudoku kommt erst "Sudoku gelöst" (was ja eigentlich nicht so sein soll) und dann eine Fehlermeldung, die ich leider nicht behoben bekommen habe.


Bei einem richtig gelösten Sudoku kommt erst die Fehlermeldung, dann "Sudoku gelöst".


![image](https://github.com/laulie1997/funkP/assets/57483600/51645e74-49af-4cc5-9c9e-af497c97230c)

Beispiele für die Verwendung der Prinzipien der funktionalen Programmierung:

1. Verwendung von Klassen

   Alle durchgeführten Aktionen des Spieles sind in Klassen aufgeteilt, z.B.
   
   ![image](https://github.com/laulie1997/funkP/assets/57483600/a0ed07cd-398e-4435-bfec-f02ffd3ce1ba)


2. Keine Seiteneffekte

z.B. execute-move

![image](https://github.com/laulie1997/funkP/assets/57483600/b10e3510-dda9-4ad2-bf2a-6dee84139f71)

Input: aktuelles Sudoku, Zeile, Spalte und Zahl

Output: neues Sudokufeld mit eingesetzter Zahl

3. Higher-Order Funktions

![image](https://github.com/laulie1997/funkP/assets/57483600/f0109a48-2cec-4ff9-a06d-a6135a8482bb)

In play-turn wird die Funktion execute-move als Argument angenommen, sie ist also eine Higher-Order Funktion

4. Keine Variablen

Alle Informationen, die benötigt werden, um die Funktionen auszuführen, werden als Argumente übergeben, und die Funktionen liefern Ergebnisse zurück.

5. Funktionsaufrufe statt Abfolgen

 Es werden Funktionen wie execute-move, display-sudoku und is-solved? um das Sudoku zu steuern.


