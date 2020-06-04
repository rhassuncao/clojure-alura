(ns clojure-alura.aula4)

(def precos [30 700 1000])

(println (precos 0))
(println (get precos 0))
;devolve null
(println (get precos 17))
;devolve erro
;(println (precos 17))
;colocar padrao quando nao encontra
(println (get precos 17 0))

;mostra o vetor adicionado o elemento 5
; nao altera o vetor original
(println (conj precos 5))

;incremento
(println (+ 5 1))
(println (inc 5))

;alteracao de vetores
(println (update precos 0 inc))
(println (update precos 1 dec))

(println precos)

(defn soma-1
    [valor]
    (println "estou somando um em" valor)
    (+ valor 1))

(println (update precos 0 soma-1))

(defn aplica-desconto?
  [valor-bruto]
  (> valor-bruto 100))

(defn valor-descontado
  "Retorna o valor com desconto de 10% se o valor bruto for estritamente maior que 100."
  [valor-bruto]
  (if (aplica-desconto? valor-bruto)
    (let [taxa-de-desconto (/ 10 100)
          desconto (* valor-bruto taxa-de-desconto)]
      (- valor-bruto desconto))
    valor-bruto))

; aplica a funcao a todos os elementos do vetor
(println (map valor-descontado precos))

; imprime os numero de 0-9
(println (range 10))

;filtra valores para imprimir apenas os pares
(println (filter even? (range 10)))

; filtra apenas os valores que sao maiores que 100
(println (filter aplica-desconto? precos))

; aplica o desconto apenas nos valores maiores que 100
(println (map valor-descontado (filter aplica-desconto? precos)))

(println (reduce + precos))

(defn minha-soma
    [valor-1 valor-2]
    (println "somando" valor-1 valor-2)
    (+ valor-1 valor-2))

(println (reduce minha-soma precos))

(println (reduce minha-soma (range 10)))

;reduce com valor inicial
(println (reduce minha-soma 0 (range 10)))