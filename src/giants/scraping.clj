(ns giants.scraping
  (:gen-class))

(use 'net.cgrand.enlive-html)

(defn fetch-lyrics
  [url]
  (def page (html-resource (java.net.URL. url)))
  (def lyrics (select page [:p.verse :> text-node]))
  (println (clojure.string/join "\n" lyrics)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (def url (first args))
  (println "Fetching lyrics from: " url "\n")
  (fetch-lyrics url))
