(ns funktP)

(def initial-state
  "Initialisiert das 4x4 Sudoku-Feld mit bestimmten Zahlen."
  [[0 1 0 0]
   [3 0 0 1]
   [4 0 0 2]
   [0 0 4 0]])

(defn valid-move?
  "Überprüft die Gültigkeit eines Zugs (Einfügen einer Zahl an einer bestimmten Position) im 4x4 Sudoku."
  [sudoku row col num]
  (and (zero? (get-in sudoku [row col]))               ; Überprüfen, ob die Position leer ist
       (<= 1 num 4)))                                  ; Gültige Zahlen sind 1 bis 4

(defn execute-move
  "Führt einen Zug im 4x4 Sudoku aus (setzt eine Zahl an einer bestimmten Position)."
  [sudoku row col num]
  (assoc-in sudoku [row col] num))

(defn display-sudoku
  "Gibt das 4x4 Sudoku-Feld auf der Konsole aus."
  [sudoku]
  (doseq [row sudoku]
    (println row)))

(defn is-solved?
  "Überprüft, ob das 4x4 Sudoku-Feld gelöst ist (keine leeren Positionen mehr)."
  [sudoku]
  (every? (partial every? #(not= 0 %)) sudoku))

(defn check-sudoku
  "Überprüft, ob das 4x4 Sudoku-Feld alle Regeln erfüllt."
  [sudoku]
  (if (and (is-solved? sudoku)
           (every? #(apply distinct? %) sudoku) ; Überprüft, ob in jeder Zeile alle Zahlen unterschiedlich sind
           (every? #(apply distinct? %) (apply map vector sudoku)) ; Überprüft, ob in jeder Spalte alle Zahlen unterschiedlich sind
           (every? #(apply distinct? %)         ; Überprüft, ob in jedem Quadranten alle Zahlen unterschiedlich sind
                   (for [r (range 0 4 2)
                         c (range 0 4 2)]
                     (flatten (for [i (range 2)
                                    j (range 2)]
                                (get-in sudoku [(+ r i) (+ c j)]))))))
    true
    (do
      (println "Invalid Sudoku:")
      (display-sudoku sudoku)
      false)))

(defn zug-einlesen
  "Liest die Eingabe des Spielers aus der Kommandozeile und gibt den Zug des Spielers zurück."
  []
  (let [eingabe (clojure.string/split (read-line) #"\s+")
        [row col num] (map #(Integer. %) eingabe)]
    [(dec row) (dec col) num])) ; Dekrementiere row und col, um 0-basierte Indizes zu erhalten

(defn play-turn
  "Fragt den Benutzer nach einem Zug und führt ihn aus, bis das Sudoku gelöst ist."
  [sudoku]
  (if (is-solved? sudoku)
    (do
      (println "Sudoku gelöst!")
      (display-sudoku sudoku))
    (do
      (display-sudoku sudoku)
      (let [move (zug-einlesen)
            [row col num] move]
        (if (and (<= 1 num 4) (valid-move? sudoku row col num))
          (recur (execute-move sudoku row col num))
          (do
            (println "Ungültiger Zug! Bitte versuchen Sie es erneut.")
            (recur sudoku)))))))

(defn -main
  "Startet das 4x4 Sudoku-Spiel."
  []
  (let [final-state (play-turn initial-state)]
    (if (check-sudoku final-state)
      (println "Sudoku korrekt gelöst!")
      (println "Sudoku nicht korrekt gelöst!"))))
