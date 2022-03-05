package main

import "C"
import (
	"github.com/evanw/esbuild/pkg/api"
	"log"
	"time"
)

var (
	debug       = false
	cacheResult = make(map[int]map[CacheType]string)
	cacheMangle = make(map[int]map[string]interface{})
)

const (
	keySp  = 'Θ'
	arrSp  = ','
	arrSpS = ","
)

type CacheType int

const (
	Warn CacheType = iota
	Error
	Code
	SourceMap
	Meta
	Output
)

func main() {

}

//export Debugger
func Debugger(n C.int) {
	debug = n == 1
}

//export GetResult
func GetResult(n C.int, t C.int) *C.char {
	if res, ok := cacheResult[int(n)]; ok {
		if debug {
			log.Printf("found result for %d of %d as %s \n", n, t, res[CacheType(t)])
		}
		return C.CString(res[CacheType(t)])
	}
	if debug {
		log.Printf("result missing of %d:%d with cacheMangle %+v \n", n, t, cacheResult)
	}
	return nil
}

//export EndSession
func EndSession(n C.int) {
	delete(cacheResult, int(n))
	delete(cacheMangle, int(n))
}

//export Reset
func Reset() {
	cacheResult = make(map[int]map[CacheType]string)
	cacheMangle = make(map[int]map[string]interface{})
	transform = api.TransformOptions{}
	build = api.BuildOptions{}
}

func newSession() C.int {
	return C.int(time.Now().UnixMilli())
}
