(ns clojure-alura.aula5)

;hash map/dicionario
(def estoque {"mochila" 10 "camiseta" 5})
(println estoque)

;contagem de elementos
(println (count estoque))

;listar as chaves
(println (keys estoque))

;listar os valores
(println (vals estoque))

;keyword
; :mochila
(def estoque {:mochila 10
              :camiseta 5})

;criar um novo mapa com um novo valor
(println (assoc estoque :cadeira 3))
; pode tambem alterar valor, porem nao altera o hashmap original
(println (assoc estoque :mochila 3))

;incremento
(println (update estoque :mochila inc))

(defn tira-um
    [valor]
    (println "tirando um de" valor)
  (- valor 1))

(println (update estoque :mochila tira-um))
(println (update estoque :mochila #(- % 3)))

;remover elementos

(println (dissoc estoque :mochila))

(println estoque)

(def pedido {:mochila {:quantidade 2,  :preco 80}
             :camiseta {:quantidade 3, :preco 40}})

(println "\n\n\n\n")
(println pedido)

(def pedido (assoc pedido :chaveiro {:quantidade 1, :preco 10}))

(println pedido)

;buscar valores no mapa dificilmente usa essa maneira
(println (pedido :mochila))
(println (get pedido :mochila))
;get quando nao existe
(println (get pedido :cadeira))
;get com valor default vazio
(println (get pedido :cadeira {}))
;invertido, maneira mais comum
(println (:mochila pedido {}))

;acessar valores internos
(println (:quantidade (:mochila pedido)))

;alterar valore sinternos
(println (update-in pedido [:mochila :quantidade] inc))

;THREADING FIRST
(println (-> pedido
         :mochila
         :quantidade))

