(ns core)

(let [url "psql://postgres:mysecretpassword@localhost/postgres"
      client (new (.-Client pg) url)]
  (-> (.connect client)
      (.then (fn []
               (-> (.query client "SELECT NOW()")
                   (.then #(js/console.log %)))))))
