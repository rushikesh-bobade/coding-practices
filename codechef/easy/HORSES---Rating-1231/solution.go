package main

import (
	"fmt"
	"sort"
)

func main() {
	var T int
	fmt.Scan(&T)

	for ; T > 0; T-- {
		var N int
		fmt.Scan(&N)

		arr := make([]int, N)
		for i := 0; i < N; i++ {
			fmt.Scan(&arr[i])
		}

		sort.Ints(arr)

		minDiff := arr[1] - arr[0]
		for i := 1; i < N-1; i++ {
			diff := arr[i+1] - arr[i]
			if diff < minDiff {
				minDiff = diff
			}
		}

		fmt.Println(minDiff)
	}
}