(ns clojure-alura.aula6)

(def pedido {:mochila {:quantidade 2,  :preco 80}
             :camiseta {:quantidade 3, :preco 40}})

(defn imprime-e-15 [valor]
  (println "valor" valor)
  15)

(println (map imprime-e-15 pedido))

;desestruturacao de vetores (destruct)
(defn imprime-e-15 [[chave valor]]
  valor)

(println (map imprime-e-15 pedido))

(defn preco-dos-produtos [[chave valor]]
  (* (:quantidade valor) (:preco valor)))

;trocar o nume de um parametro por _ mostra que não sera utilizado
(defn preco-dos-produtos [[_ valor]]
  (* (:quantidade valor) (:preco valor)))

(println (reduce + (map preco-dos-produtos pedido)))

(defn total-do-pedido
  [pedido]
  (reduce + (map preco-dos-produtos pedido)))

;THREAD LAST
; colecao no final da funcao
(defn total-do-pedido
  [pedido]
  (->> pedido
      (map preco-dos-produtos)
      (reduce +)))

(defn preco-total-do-produto [produto]
  (* (:quantidade produto) (:preco produto)))

;THREAD LAST
; colecao no final da funcao
(defn total-do-pedido
  [pedido]
  (->> pedido
       vals
       (map preco-total-do-produto)
       (reduce +)))

(println (total-do-pedido pedido))

(def pedido {:mochila {:quantidade 2,  :preco 80}
             :camiseta {:quantidade 3, :preco 40}
             :chaveiro {:quantidade 1, }})

(defn gratuito?
  [item]
  (<= (get item :preco 0) 0))

(println (filter (fn [[cahve item]] (gratuito? item )) pedido))
(println (filter #(gratuito? (second %)) pedido))

(defn pago?
    [item]
  (not (gratuito? item)))

(println (pago? {:preco 50}))

(println ((comp not gratuito?) {:preco 50}))

;compor funcoes
(def pago? (comp not gratuito?))
