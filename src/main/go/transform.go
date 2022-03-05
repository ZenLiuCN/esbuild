package main

import "C"
import (
	"github.com/evanw/esbuild/pkg/api"
	"log"
	"strings"
)

func putTransformCache(n int, res api.TransformResult) {
	m := make(map[CacheType]string)
	if len(res.Warnings) > 0 {
		m[Code] = strings.Join(api.FormatMessages(res.Warnings, api.FormatMessagesOptions{}), "\n")

	}
	if len(res.Errors) > 0 {
		m[Error] = strings.Join(api.FormatMessages(res.Errors, api.FormatMessagesOptions{}), "\n")
	}
	if len(res.Code) > 0 {
		m[Code] = string(res.Code)
	}
	if len(res.Map) > 0 {
		m[SourceMap] = string(res.Map)
	}

	cacheResult[n] = m
	cacheMangle[n] = res.MangleCache
	if debug {
		log.Printf("cache result of Transform: %+v \n", cacheResult)
	}
}

//export Transform
func Transform(str *C.char) C.int {
	ced := C.GoString(str)
	if debug {
		log.Printf("code to transform: %s \n", ced)
	}
	res := api.Transform(ced, transform)
	n := newSession()
	putTransformCache(int(n), res)
	return C.int(n)
}
