(defproject shale "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "https://github.com/cardforcoin/shale"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [ring "1.3.1"]
                 [javax.servlet/servlet-api "2.5"]
                 [compojure "1.1.9"]
                 [liberator "0.12.2"]
                 [clj-http "1.0.0"]
                 [clj-json "0.5.3"]
                 [clj-webdriver "0.6.0"]
                 [clj-wallhack "1.0.1"]
                 [hiccup "1.0.5"]
                 [sonian/carica "1.1.0" :exclusions  [[cheshire]]]
                 [environ "1.0.0"]
                 [com.taoensso/carmine "2.7.0" :exclusions [org.clojure/clojure]]
                 [com.brweber2/clj-dns "0.0.2"]
                 [org.bovinegenius/exploding-fish "0.3.4"]
                 [overtone/at-at "1.2.0"]
                 [prismatic/schema "0.3.0"]]
  :auto-clean false
  :main shale.handler
  :plugins [[lein-ring "0.8.12"]
            [lein-environ "1.0.0"]]
  :ring {:handler shale.handler/app
         :init shale.handler/init
         :destroy shale.handler/destroy
         :port 5000}
  :profiles {:dev
              {:dependencies [[org.clojure/tools.trace "0.7.8"]
                              [ring-mock "0.1.5"]]}
             :aws {:dependencies [[amazonica "0.2.26" :exclusions [joda-time]]]
                   :uberjar-name "shale-aws.jar"}
             :uberjar {:aot :all}})
