(set-env!
  :source-paths #{"src"}
  :dependencies '[[boot/core "2.0.0-rc9" :scope "provided"]
                  [adzerk/bootlaces "0.1.10" :scope "test"]])

(require '[adzerk.bootlaces :refer :all])

(def +version+ "0.0.1-SNAPSHOT")
(bootlaces! +version+)

(task-options!
 aot {:namespace '#{danielsz.autoprefixer}}
 pom {:project 'danielsz/boot-autoprefixer
      :version +version+
      :scm {:name "git"
            :url "https://github.com/danielsz/boot-autoprefixer"}})

(deftask build
  "Build jar and install to local repo."
  []
  (comp (aot) (pom) (jar) (install)))