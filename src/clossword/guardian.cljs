(ns clossword.guardian
  "Code supporting react-crossword"
  (:require [clossword.convert :as convert]
            [reagent.dom :as dom]
            ["react-crossword" :default Crossword]))

(def ^:private minimal-data
  {:date                  0
   :number                1
   :name                  "Auto-converted crossword"
   :dimensions            {:cols 13
                           :rows 13}
   :dateSolutionAvailable 0
   :id                    "clossword/1"
   :solutionAvailable     true})

(defn- fill-entry
  [{:keys [number solution direction x y]
    :as entry}]
  (let [id (str number "-" (name direction))]
    (merge
     {:humanNumber        (str number)
      :separatorLocations {}
      :group              [id]
      :id                 id
      :length             (count solution)
      :position           {:x x
                           :y y}}
    (dissoc entry :x :y))))

(defn ->guardian-format
  [data]
  (let [size (some-> data :dimensions :cols)
        css-type (if (= 15 size)
                   "cryptic"
                   "quick")
        merged (merge minimal-data data)]
    (assoc merged
           :entries (map fill-entry (:entries data))
           :crosswordType css-type)))

(defn guardian-crossword
  [id data]
  [:> Crossword
   {:data (clj->js (->guardian-format data))
    :id id}])

(defn ^:export render-xw
  [elem xw]
  (dom/render
   (let [xw-clj (js->clj xw :keywordize-keys true)
         data (convert/guardianize xw-clj)]
     [guardian-crossword :demo data])
   elem))
