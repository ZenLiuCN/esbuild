package main

import "C"
import (
	"github.com/Joker/jade"
)

//export CompileSFC
func CompileSFC(code *C.char) *C.char {
	return C.CString(compileSFC(C.GoString(code)))
}
func compileSFC(code string) string {
	return ""
}
func compileJade(code string) (string, error) {
	return jade.Parse("jade", []byte(code))
}
