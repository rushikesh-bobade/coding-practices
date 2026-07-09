package main

import "fmt"

func main() {
	var T int
	fmt.Scan(&T)

	for ; T > 0; T-- {
		var N int
		var S string

		fmt.Scan(&N)
		fmt.Scan(&S)

		ans := 0

		for i := 1; i < N; i++ {
			if S[i] == S[i-1] {
				ans++
			}
		}

		fmt.Println(ans)
	}
}