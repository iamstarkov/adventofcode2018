(def raw (slurp "01-input.txt"))
(def input (map read-string (clojure.string/split-lines raw)))


(defn part1 [deltas] (reduce + 0 deltas))

(defn first-duplicate [freqs]
  (loop [freqs freqs
         visited #{}]
    (let [freq (first freqs)]
      (if (contains? visited freq)
        freq
        (recur
          (rest freqs)
          (conj visited freq))))))

(defn part2 [diffs]
  (->> diffs
    cycle
    (reductions +)
    first-duplicate))

(println "Part 1:" (part1 input))
(println "Part 2:" (part2 input))
