(ns sicp-exercises-clojure.core)

(defn exercise-1-11
  [n]
  (defn rec
    [n]
    (cond
      (< n 3) n
      (>= n 3) (+ 
                 (rec (dec n))
                 (* (rec (- n 2)) 2)
                 (* (rec (- n 3)) 3))))
  (defn iter
    [a b c counter]
    (if
      (< counter 3) 
        a
        (iter (+ a (* b 2) (* c 3))
              a
              b
              (- counter 1))))

  (println (rec n))
  (println (iter 2 1 0 n)))

(defn exercise-1-12
  "Pascal's Triangle"
  [rows]

  (defn build-elem
    [row col prev-elem]
    (* prev-elem
       (/ (- (+ row 1) col)
          col)))


  (defn build-row
    [row row-vec]
    (cond
      (< row (count row-vec))
        row-vec
      (<= (Math/round (double (/ row 2 ))) (count row-vec))
        (if (even? row)
          (into (conj row-vec (build-elem row (count row-vec) (last row-vec)))
                (reverse row-vec))
          (into row-vec (reverse row-vec)))
      :else
        (build-row row 
                   (conj row-vec 
                   (build-elem row 
                               (count row-vec) 
                               (last row-vec))))))

  (defn build-triangle
    [rows]
    (reduce 
      #(str %1 (clojure.string/join " " %2) "\n")
      ""
      (map #(build-row % (vector 1)) 
            (range rows))))

  (println (build-triangle rows)))

  

(defn main
  [n]
  (exercise-1-11 (Integer/parseInt n))
  (exercise-1-12 (Integer/parseInt n)))

