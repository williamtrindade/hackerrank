# Arrays: Left Rotation

## Descrição
Uma operação de rotação à esquerda em um array desloca cada um dos elementos do array em $1$ unidade para a esquerda. Por exemplo, se $2$ rotações à esquerda forem realizadas no array $[1, 2, 3, 4, 5]$, o array se tornará $[3, 4, 5, 1, 2]$. Note que o item de menor índice se move para o índice mais alto em uma rotação. Isso é chamado de array circular.

Dado um array $a$ de $n$ inteiros e um número $d$, realize $d$ rotações à esquerda no array. Retorne o array atualizado para ser impresso como uma única linha de inteiros separados por espaço.

## Descrição da Função
Complete a função `rotLeft`.

`rotLeft` tem os seguintes parâmetros:
* `int a[n]`: o array para rotacionar
* `int d`: o número de rotações

**Retorno:**
* `int a'[n]`: o array rotacionado

## Formato de Entrada
A primeira linha contém dois inteiros separados por espaço $n$ e $d$, o tamanho de $a$ e o número de rotações à esquerda.
A segunda linha contém $n$ inteiros separados por espaço, cada um sendo $a[i]$.

## Restrições
* $1 \le n \le 10^5$
* $1 \le d \le n$
* $1 \le a[i] \le 10^6$

## Exemplo de Entrada
```text
5 4
1 2 3 4 5
```

## Exemplo de Saída
```text
5 1 2 3 4
```

## Explicação
Quando realizamos $d = 4$ rotações à esquerda, o array passa pela seguinte sequência de mudanças:

$[1, 2, 3, 4, 5] \rightarrow [2, 3, 4, 5, 1] \rightarrow [3, 4, 5, 1, 2] \rightarrow [4, 5, 1, 2, 3] \rightarrow [5, 1, 2, 3, 4]$