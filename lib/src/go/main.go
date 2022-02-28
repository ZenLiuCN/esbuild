package main

import "C"
import (
	"github.com/evanw/esbuild/pkg/api"
	"github.com/google/flatbuffers/go"
	"unsafe"
)

func main() {

}

func Transform(str *C.Char, bytes *C.Char, len C.int) *C.res {
	bytes := C.GoBytes(unsafe.Pointer(bytes), len)
	flatbuffers.
		res := api.Transform(C.GoString(str), api.TransformOptions{
		Color:             conf.color,
		LogLimit:          conf.logLimit,
		LogLevel:          conf.logLevel,
		Sourcemap:         conf.sourceMap,
		SourceRoot:        "",
		SourcesContent:    0,
		Target:            api.Target(conf.target),
		Drop:              api.Drop(conf.drop),
		MinifyWhitespace:  conf.minify>>1 > 0,
		MinifyIdentifiers: false,
		MinifySyntax:      false,
		Charset:           0,
		TreeShaking:       0,
		IgnoreAnnotations: false,
		LegalComments:     0,
		JSXMode:           0,
		JSXFactory:        "",
		JSXFragment:       "",
		TsconfigRaw:       "",
		Banner:            "",
		Footer:            "",
		Define:            nil,
		Pure:              nil,
		KeepNames:         false,
		Sourcefile:        "",
		Loader:            0,
	})
	return res
}
