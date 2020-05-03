(ns clossword.convert
  (:require [clojure.string :as string]))

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

(defn words->entries
  [direction idx words]
  (let [across? (= :across direction)]
    (for [[coord word] words]
      {:direction direction
       :solution word
       :x (if across? coord idx)
       :y (if across? idx coord)})))

(defn entries-in-grid
  [{grid                :grid
    {:keys [cols]} :size}]
  (let [cols (int cols)
        across (map get-words (partition cols grid))
        down (->> (range cols)
                  (map #(drop % grid))
                  (map #(take-nth cols %))
                  (map get-words))]
    (flatten (concat (map-indexed (partial words->entries :across) across)
                       (map-indexed (partial words->entries :down) down)))))

(defn get-clue
  [clues dir n]
  (->> clues
       dir
       (filter #(string/starts-with? % (str n ".")))
       first))

(defn guardianize
  [{{:keys [rows cols]} :size
    clues :clues
    :as puzzle}]
  (let [raw (entries-in-grid puzzle)
        nums (->> raw
                  (map #(select-keys % [:x :y]))
                  distinct
                  (sort-by (juxt :y :x))
                  (map-indexed (fn [i xy]
                                 [xy (inc i)]))
                  (into {}))]
    {:dimensions {:rows (int rows)
                  :cols (int cols)}
     :entries
     (for [entry raw]
       (let [num (get nums (select-keys entry [:x :y]))
             clue (get-clue clues (:direction entry) num)]
         (assoc entry
                :number num
                :clue clue)))}))
