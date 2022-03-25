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
{: 

(defn show-tree [parsed] 
  (rhizome/view-tree next rest parsed
                     :node->descriptor
                     (fn [expr] {:label (let [n (first expr)]
                                          (cond
                                            (string? n) n
                                            (= :expr n) "expr"
                                            (= :op n) "op"
                                            (= :num n) "num"
                                            (= :var n) "var"
                                            (number? n) n
                                            :else (str n)
                                            ))})))

 (show-tree (risch/parse "1x^2+1"))
   
