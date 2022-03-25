(ns risch.debug
  (:require [risch.core :as risch] [rhizome.viz :as rhizome]))

(defn parse-tree
  ([tree] (apply str (map #(parse-tree % "") tree)))
  ([tree prefix]
   (if (vector? tree)
     (->> (map #(parse-tree % (str prefix "-")) tree)
          (apply str))
     (str prefix tree "\n"))))

(defn dump-tree [parsed]
  (println (parse-tree parsed)))


(risch/parse "1a")

(str [:expr [:expr [:num "1"]] [:expr [:var "a"]]])

(defn my-next [thing]
  (if (string? thing)
    
    (next thing)))

(defn show-tree [parsed] 
  (rhizome/view-tree my-next rest parsed
                     :node->descriptor
                     (fn [expr] {:label (let [n (first expr)]
                                          (cond
                                            (string? n) n
                                            (keyword? n) (name n)
                                            (number? n) n
                                            :else (str n)
                                            ))})))

 (show-tree (risch/parse "a_2x^2+bx^3"))
   
