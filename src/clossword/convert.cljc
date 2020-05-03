(ns clossword.convert
  (:require [cljs.pprint :refer [pprint]]
            [clojure.string :as string]))

(defn get-words
  ([cs] (get-words 0 cs))
  ([idx cs]
   (if (empty? cs)
     nil
     (let [[blanks char-tail] (split-with #(= "." %) cs)
           [word tail] (split-with #(not= "." %) char-tail)
           word-idx (+ idx (count blanks))
           tail-idx (+ word-idx (count word))]
       (if (< 1 (count word))
         (cons [word-idx (string/join word)] 
               (get-words tail-idx tail))
         (get-words tail-idx tail))))))

(defn words-in-grid
  [{grid                :grid
    {:keys [rows cols]} :size}]
  (let [across (map get-words (partition cols grid))
        down (->> (range cols)
                  (map #(drop % grid))
                  (map #(take-nth cols %))
                  (map get-words))]
    (with-out-str
      (pprint (concat (zipmap (range) across)
                      (zipmap (range) down))))))
