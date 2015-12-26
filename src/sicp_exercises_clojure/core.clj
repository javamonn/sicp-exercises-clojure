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

(defn main
  [n]
  (exercise-1-11 (Integer/parseInt n)))
