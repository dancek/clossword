(ns clossword.guardian
  "Code supporting react-crossword"
  (:require ["react-crossword" :default Crossword]))

(def ^:private minimal-data
  {:date                  0
   :crosswordType         "quick"
   :number                1
   :name                  "Auto-converted crossword"
   :dimensions            {:cols 13
                           :rows 13}
   :dateSolutionAvailable 0
   :id                    "clossword/1"
   :solutionAvailable     true})

(defn- fill-entry
  [{:keys [number clue solution direction x y]
    :as entry}]
  (let [id (str number "-" direction)] 
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
  (merge minimal-data
         data
         {:entries (map fill-entry (:entries data))}))

(defn guardian-crossword
  [id data]
  [:> Crossword
   {:data (clj->js (->guardian-format data))
    :id id}])
