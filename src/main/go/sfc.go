package main

import "C"

//export CompileSFC
func CompileSFC(code *C.char) *C.char {
	return C.CString(compileSFC(C.GoString(code)))
}
func compileSFC(code string) string {
	return ""
}
