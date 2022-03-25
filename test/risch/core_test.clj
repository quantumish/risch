(ns risch.core-test
  (:require [clojure.test :refer :all]
            [risch.core :refer :all]))

(deftest simple-add
  (testing "Sanity check: simple addition parsed correctly."
    (is (= (parse "1+1")
           [:expr [:expr [:num "1"]] [:op "+"] [:expr [:num "1"]]]))))

;; (deftest polynomial
;;   (testing "Check if polynomial parsed correctly."
;;     (is (= (parse "a_0+a_1x^1+a_2x^2+a_3x^3")
;;    )  

(deftest bad-expr
  (testing "Sanity check: invalid expressions fail to parse."
    (is (= false (vector? (parse "&+@"))))))

