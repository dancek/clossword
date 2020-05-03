(ns clossword.ui
  (:require [cljs.pprint :refer [pprint]]
            [reagent.dom :as dom]
            ["react-crossword" :default Crossword]
            [clossword.guardian :refer [guardian-crossword]]
            [clossword.convert :as convert]))

(defn init-xw
  [xw]
  (dom/render
   [:<>
    (let [xw-clj (js->clj xw :keywordize-keys true)
          data (convert/guardianize xw-clj)]
      [:<>
       [guardian-crossword :demo data]
       [:pre (with-out-str (pprint data))]])]
   (js/document.getElementById "app")))
