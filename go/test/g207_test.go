package test

import (
	"github.com/stretchr/testify/assert"
	"leetcode/graph"
	"testing"
)

func Test207(t *testing.T) {
	prep := [][]int{{1, 0}}
	result := graph.FindOrder(2, prep)
	assert.Equal(t, result, []int{0, 1}) // ok
}
