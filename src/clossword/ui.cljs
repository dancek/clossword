(ns clossword.ui
  (:require [reagent.dom :as dom]
            ["react-crossword" :default Crossword]
            [clossword.demo :refer [demo-raw demo-simple demo-grid]]
            [clossword.guardian :refer [guardian-crossword]]
            [clossword.convert :as convert]))

(defn init
  []
  (dom/render
   [:<>
    [:pre (convert/words-in-grid demo-grid)]
    [guardian-crossword :demo demo-simple]]
   (js/document.getElementById "app")))

(init)
