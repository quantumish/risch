(ns risch.core
  (:require [instaparse.core :as insta]))

(def parse-arithmetic
  (insta/parser
    "S = num op num
     num = #'[0-9]+'
     op = ('+'|'-')
     "))

(defn eval-parsed-arithmetic [parsed]
  (rest parsed))
  
(eval-parsed-arithmetic (parse-arithmetic "12+23"))


