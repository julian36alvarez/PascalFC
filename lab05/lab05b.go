package main

import (
	"fmt"
	"sync"
	"time"
)

type Nums []int

var arrayNumber [16385]int
var arraymin [8192]int

func Minimo(compu, from, until int, wg *sync.WaitGroup) {
	min := arrayNumber[from]
	for i := from + 1; i < until; i++ {
		if arrayNumber[i] < min {
			min = arrayNumber[i]
		}
	}
	arraymin[compu] = min
	defer wg.Done()
}

func main() {

	var wg sync.WaitGroup

	var enteros int
	var gorutinas int
	//canales := make(chan int, gorutinas)
	//cfinal := make(chan int, enteros)

	fmt.Scanf("%d\n", &enteros)
	fmt.Scanf("%d\n", &gorutinas)

	for i := 0; i < enteros; i++ {
		fmt.Scanf("%d", &arrayNumber[i])
	}
	start := time.Now()
	for i := 0; i < gorutinas; i++ {
		wg.Add(1)
		go Minimo(i, (i * (enteros / gorutinas)), (i+1)*(enteros/gorutinas), &wg)
	}

	//var final = make(Nums, gorutinas)

	wg.Wait()

	min := arraymin[0]
	for i := 1; i < gorutinas; i++ {
		if arraymin[i] < min {
			min = arraymin[i]
		}
	}
	fmt.Println(min)
	fmt.Println(time.Since(start).Nanoseconds())
}
