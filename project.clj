(defproject risch "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.3"]
                 [instaparse "1.4.10"]
                 [macroz/tangle "0.2.2"]
                 [rhizome "0.2.9"]]
  :repl-options {:init-ns risch.core})
