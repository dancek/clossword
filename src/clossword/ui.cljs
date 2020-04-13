(ns clossword.ui
  (:require [reagent.dom :as dom]
            ["react-crossword" :default Crossword]
            [clossword.demo :refer [demo-raw]]))

(defn xw-demo []
  [:> Crossword
   {:data (clj->js demo-raw)}])

(defn init
  []
  (dom/render
   [xw-demo]
   (js/document.getElementById "app")))

(init)
