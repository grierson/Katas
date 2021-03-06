(ns aoc2018.01
  (:require [clojure.java.io :as io]
            [clojure.string :as string]))

(defn foo [state expr]
  (let [op (-> expr first str symbol resolve)
        v (->> expr rest (apply str) read-string)]
    (op state v)))

(def data (-> "aoc2018/01.txt"
              io/resource
              slurp
              string/split-lines))

(comment
  (reduce foo 0 data))