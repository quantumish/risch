(ns risch.core-test
  (:require [clojure.test :refer :all]
            [risch.core :refer :all]))

(deftest simple-add
  (testing "Sanity check: simple addition parsed correctly."
    (is (= (parse-arithmetic "1+1")
           [:S [:num "1"] [:op "+"] [:num "1"]]))))

(deftest bad-expr
  (testing "Sanity check: invalid expressions fail to parse."
    (is (= false (vector? (parse-arithmetic "a+b"))))))
