# Ice Cream Parlor

## 📝 Problem Description

Two friends like to pool their money and go to the ice cream parlor. They always choose two distinct flavors and they spend all of their money.

Given a list of prices for the flavors of ice cream, select the two that will cost all of the money they have.

### 💡 Example

`m = 6`
`cost = [1, 3, 4, 5, 6]`

The two flavors that cost `1` and `5` meet the criteria. Using 1-based indexing, they are at indices `1` and `4`.

---

## ⚙️ Function Description

Complete the `icecreamParlor` function. It has the following parameter(s):

* `int m`: the amount of money they have to spend
* `int cost[n]`: the cost of each flavor of ice cream (represented as an array or list)

### 📥 Returns
* `int[2]`: the indices of the prices of the two flavors they buy, sorted ascending.

---

## 📋 Input Format

The first line contains an integer, `t`, the number of trips to the ice cream parlor. The next `t` sets of lines each describe a visit.

Each trip is described as follows:
1. The integer `m`, the amount of money they have pooled.
2. The integer `n`, the number of flavors offered at the time.
3. `n` space-separated integers denoting the cost of each flavor: `cost[1], cost[2], ..., cost[n]`.

**Note:** The index within the cost array represents the flavor of the ice cream purchased (using 1-based indexing).

---

## ⚠️ Constraints

* `1 <= t <= 50`
* `2 <= m <= 10^4`
* `2 <= n <= 10^4`
* `1 <= cost[i] <= 10^4`, for all `i` in `[1, n]`
* There will always be a unique solution.

---

## 💻 Sample Input / Output

### Sample Input
```text
2
4
5
1 4 5 3 2
4
4
2 2 4 3

```


### Sample Output
```text
1 4
1 2
``