package main

import "C"
import (
	"github.com/evanw/esbuild/pkg/api"
	"log"
	"strings"
)

//export Build
func Build() C.int {
	res := api.Build(build)
	n := newSession()
	putBuildCache(int(n), res)
	return C.int(n)
}
func putBuildCache(n int, res api.BuildResult) {
	m := make(map[CacheType]string)
	if len(res.Warnings) > 0 {
		m[Warn] = strings.Join(api.FormatMessages(res.Warnings, api.FormatMessagesOptions{}), "\n")

	}
	if len(res.Errors) > 0 {
		m[Error] = strings.Join(api.FormatMessages(res.Errors, api.FormatMessagesOptions{}), "\n")
	}
	if len(res.Metafile) > 0 {
		m[Meta] = res.Metafile
	}
	if len(res.OutputFiles) > 0 {
		b := new(strings.Builder)
		for _, file := range res.OutputFiles {
			if b.Len() != 0 {
				b.WriteRune(arrSp)
			}
			b.WriteString(file.Path)
			b.WriteRune(keySp)
			b.WriteString(string(file.Contents))
		}
		m[Output] = b.String()
	}

	cacheResult[n] = m
	cacheMangle[n] = res.MangleCache
	if debug {
		log.Printf("cache result of Transform: %+v \n", cacheResult)
	}
}
