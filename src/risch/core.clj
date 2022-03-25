(ns risch.core
  (:require [instaparse.core :as insta]))

(def parse
  (insta/parser "
expr =  num | var | num expr | expr op expr | expr '^' var | expr '^' num | expr '^' '(' expr ')' | '(' expr ')'
var = #'[A-Za-zΑ-Ωα-ω]' | #'[A-Za-zΑ-Ωα-ω]_[0-9A-Za-zΑ-Ωα-ω]'
num = #'[0-9]+'
op = ('-'|'+'|'/'|'*')
    "))

(defn integrate [parsed wrt]
  (if (not (some? (re-matches #"[A-Za-zΑ-Ωα-ω]" wrt)))
    (throw (AssertionError. "Integral taken with respect to invalid variable!")))
  (println "All good!"))
         
(def trivial-integrals
  {:cos [:expr [:scalar -1] [:func :sin]]
   :sin [:func :cos]})
