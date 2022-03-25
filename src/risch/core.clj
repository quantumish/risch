(ns risch.core
  (:require [instaparse.core :as insta]))

(def parse
  (insta/parser "
expr = expr op expr |  '(' expr ')' | expr expr | num | var
var = #'[A-Za-zΑ-Ωα-ω]'
num = #'[0-9]+'
op = ('+'|'-'|'^'|'/'|'*')
    "))

(defn print-tree
  ([tree] (apply str (map #(print-tree % "") tree)))
  ([tree prefix]
   (if (vector? tree)
     (->> (map #(print-tree % (str prefix "-")) tree)
          (apply str))
     (str prefix tree "\n"))))


(println (print-tree (parse "(12+23)^Λ+β")))

(doseq [expr (parse "(12+23)^Λ+β")]
  
  (println expr))

(defn integrate [parsed wrt]
  (if (not (some? (re-matches #"[A-Za-zΑ-Ωα-ω]" wrt)))
    (throw (AssertionError. "Integral taken with respect to invalid variable!")))
  (println "All good!"))

(integrate (parse "A+B") "2")
  ; (doseq [expr parsed] 
         
(def trivial-integrals
  {:cos [:expr [:scalar -1] [:func :sin]]
   :sin [:func :cos]})

(trivial-integrals :sin)
