(ns clojure-alura.aula3)

;predicate
(defn mais-caro-que-100? [valor-bruto] (> valor-bruto 100))

(defn aplica-desconto?
  [valor-bruto]
  (> valor-bruto 100))

(defn valor-descontado
  "Retorna o valor com desconto de 10% se o valor bruto for estritamente maior que 100."
  [aplica? valor-bruto]
  (if (aplica? valor-bruto)
    (let [taxa-de-desconto (/ 10 100)
          desconto (* valor-bruto taxa-de-desconto)]
      (- valor-bruto desconto))
    valor-bruto))



(println (valor-descontado (fn [valor-bruto] (> valor-bruto 100)) 1000))