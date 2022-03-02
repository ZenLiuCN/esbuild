package main

/*
typedef struct result{
long long cache;
char * code;
char * map;
char * err;
char * warn;
} Result;
*/
import "C"
import (
	"github.com/evanw/esbuild/pkg/api"
	"log"
	"strings"
	"time"
)

var (
	cache     = make(map[int]map[string]interface{})
	transform = api.TransformOptions{}
	//build          = api.BuildOptions{}
	debug          = false
	cacheTransform = make(map[int]map[int]string)
)

func main() {

}

func putCache(n int, res api.TransformResult) {
	m := make(map[int]string)
	if len(res.Warnings) > 0 {
		m[0] = strings.Join(api.FormatMessages(res.Warnings, api.FormatMessagesOptions{}), "\n")

	}
	if len(res.Errors) > 0 {
		m[1] = strings.Join(api.FormatMessages(res.Errors, api.FormatMessagesOptions{}), "\n")
	}
	if len(res.Code) > 0 {
		m[2] = string(res.Code)
	}
	if len(res.Map) > 0 {
		m[3] = string(res.Map)
	}

	cacheTransform[n] = m
	if debug {
		log.Printf("cache of Transform ", cacheTransform)
	}
}

//export Debugger
func Debugger(n C.int) {
	debug = n == 1
}

//export GetResult
func GetResult(n C.int, t C.int) *C.char {

	if res, ok := cacheTransform[int(n)]; ok {
		if debug {
			log.Printf("found result for %d of %d as %s \n", n, t, res[int(t)])
		}
		return C.CString(res[int(t)])
	}
	if debug {
		log.Printf("result missing of %d:%d with cache %+v \n", n, t, cacheTransform)
	}
	return nil
}

//export EndSession
func EndSession(n C.int) {
	delete(cacheTransform, int(n))
	delete(cache, int(n))
}

//export Transform
func Transform(str *C.char) C.int {
	ced := C.GoString(str)
	if debug {
		log.Printf("code to transform: %s \n", ced)
	}
	res := api.Transform(ced, transform)
	n := C.int(time.Now().UnixMilli())
	putCache(int(n), res)
	return C.int(n)
}

//export  TransformColor
func TransformColor(color C.int) {
	transform.Color = api.StderrColor(color)
}

//export  TransformLogLimit
func TransformLogLimit(logLimit C.int) {
	transform.LogLimit = int(logLimit)
}

//export  TransformLogLevel
func TransformLogLevel(logLevel C.int) {
	transform.LogLevel = api.LogLevel(logLevel)
}

//export  TransformSourceMap
func TransformSourceMap(sourceMap C.int) {
	transform.Sourcemap = api.SourceMap(sourceMap)
}

//export  TransformSourceRoot
func TransformSourceRoot(sourceRoot *C.char) {
	transform.SourceRoot = C.GoString(sourceRoot)
}

//export  TransformSourceContent
func TransformSourceContent(sourceContent C.int) {
	transform.SourcesContent = api.SourcesContent(sourceContent)
}

//export  TransformTarget
func TransformTarget(target C.int) {
	transform.Target = api.Target(target)
}

//export  TransformAddEngine
func TransformAddEngine(engine C.int, version *C.char) {
	transform.Engines = append(transform.Engines, api.Engine{
		Name:    api.EngineName(engine),
		Version: C.GoString(version),
	})
}

//export  TransformCleanEngine
func TransformCleanEngine() {
	transform.Engines = make([]api.Engine, 0)
}

//export  TransformFormat
func TransformFormat(format C.int) {
	transform.Format = api.Format(format)
}

//export  TransformMangleProps
func TransformMangleProps(mangleProps *C.char) {
	transform.MangleProps = C.GoString(mangleProps)
}

//export TransformGlobalName
func TransformGlobalName(v *C.char) {
	transform.GlobalName = C.GoString(v)
}

//export TransformMangleCache
func TransformMangleCache(v C.int) {
	transform.MangleCache = cache[int(v)]
}

//export TransformDrop
func TransformDrop(v C.int) {
	transform.Drop = api.Drop(v)
}

//export TransformMinifyWhitespace
func TransformMinifyWhitespace(v C.int) {
	transform.MinifyWhitespace = v == 1
}

//export TransformMinifyIdentifiers
func TransformMinifyIdentifiers(v C.int) {
	transform.MinifyIdentifiers = v == 1
}

//export TransformMinifySyntax
func TransformMinifySyntax(v C.int) {
	transform.MinifySyntax = v == 1
}

//export TransformCharset
func TransformCharset(v C.int) {
	transform.Charset = api.Charset(v)
}

//export TransformTreeShaking
func TransformTreeShaking(v C.int) {
	transform.TreeShaking = api.TreeShaking(v)
}

//export TransformIgnoreAnnotations
func TransformIgnoreAnnotations(v C.int) {
	transform.IgnoreAnnotations = v == 1
}

//export TransformLegalComments
func TransformLegalComments(v C.int) {
	transform.LegalComments = api.LegalComments(v)
}

//export TransformJSXMode
func TransformJSXMode(v C.int) {
	transform.JSXMode = api.JSXMode(v)
}

//export TransformJSXFactory
func TransformJSXFactory(v *C.char) {
	transform.JSXFactory = C.GoString(v)
}

//export TransformJSXFragment
func TransformJSXFragment(v *C.char) {
	transform.JSXFragment = C.GoString(v)
}

//export TransformTsconfigRaw
func TransformTsconfigRaw(v *C.char) {
	transform.TsconfigRaw = C.GoString(v)
}

//export TransformBanner
func TransformBanner(v *C.char) {
	transform.Banner = C.GoString(v)
}

//export TransformFooter
func TransformFooter(v *C.char) {
	transform.Footer = C.GoString(v)
}

//export TransformAddDefine
func TransformAddDefine(k, v *C.char) {
	if transform.Define == nil {
		transform.Define = make(map[string]string)
	}
	transform.Define[C.GoString(k)] = C.GoString(v)
}

//export TransformCleanDefine
func TransformCleanDefine() {
	transform.Define = nil
}

//export TransformAddPure
func TransformAddPure(v *C.char) {
	transform.Pure = append(transform.Pure, C.GoString(v))
}

//export TransformCleanPure
func TransformCleanPure() {
	transform.Pure = nil
}

//export TransformKeepNames
func TransformKeepNames() C.int {
	if transform.KeepNames {
		return C.int(1)
	}
	return C.int(0)
}

//export TransformSourceFile
func TransformSourceFile() *C.char {
	return C.CString(transform.Sourcefile)
}

//export TransformLoader
func TransformLoader(v C.int) {
	transform.Loader = api.Loader(v)
}

//export  GetTransformColor
func GetTransformColor() C.int {
	return C.int(transform.Color)
}

//export  GetTransformLogLimit
func GetTransformLogLimit() C.int {
	return C.int(transform.LogLimit)
}

//export  GetTransformLogLevel
func GetTransformLogLevel() C.int {
	return C.int(transform.LogLevel)
}

//export  GetTransformSourceMap
func GetTransformSourceMap() C.int {
	return C.int(transform.Sourcemap)
}

//export  GetTransformSourceRoot
func GetTransformSourceRoot() *C.char {
	return C.CString(transform.SourceRoot)
}

//export  GetTransformSourceContent
func GetTransformSourceContent() C.int {
	return C.int(transform.SourcesContent)
}

//export  GetTransformTarget
func GetTransformTarget() C.int {
	return C.int(transform.Target)
}

//export  GetTransformFormat
func GetTransformFormat() C.int {
	return C.int(transform.Format)
}

//export  GetTransformMangleProps
func GetTransformMangleProps() *C.char {
	return C.CString(transform.MangleProps)
}

//export GetTransformGlobalName
func GetTransformGlobalName() *C.char {
	return C.CString(transform.GlobalName)
}

//export GetTransformDrop
func GetTransformDrop() C.int {
	return C.int(transform.Drop)
}

//export GetTransformMinifyWhitespace
func GetTransformMinifyWhitespace() C.int {
	if transform.MinifyWhitespace {
		return C.int(1)
	}
	return C.int(0)
}

//export GetTransformMinifyIdentifiers
func GetTransformMinifyIdentifiers() C.int {
	if transform.MinifyIdentifiers {
		return C.int(1)
	}
	return C.int(0)
}

//export GetTransformMinifySyntax
func GetTransformMinifySyntax() C.int {
	if transform.MinifySyntax {
		return C.int(1)
	}
	return C.int(0)
}

//export GetTransformCharset
func GetTransformCharset() C.int {
	return C.int(transform.Charset)
}

//export GetTransformTreeShaking
func GetTransformTreeShaking() C.int {
	return C.int(transform.TreeShaking)
}

//export GetTransformIgnoreAnnotations
func GetTransformIgnoreAnnotations() C.int {
	if transform.IgnoreAnnotations {
		return C.int(1)
	}
	return C.int(0)
}

//export GetTransformLegalComments
func GetTransformLegalComments() C.int {
	return C.int(transform.LegalComments)
}

//export GetTransformJSXMode
func GetTransformJSXMode() C.int {
	return C.int(transform.JSXMode)
}

//export GetTransformJSXFactory
func GetTransformJSXFactory() *C.char {
	return C.CString(transform.JSXFactory)
}

//export GetTransformJSXFragment
func GetTransformJSXFragment() *C.char {

	return C.CString(transform.JSXFragment)
}

//export GetTransformTsconfigRaw
func GetTransformTsconfigRaw() *C.char {
	return C.CString(transform.TsconfigRaw)
}

//export GetTransformBanner
func GetTransformBanner() *C.char {
	return C.CString(transform.Banner)
}

//export GetTransformFooter
func GetTransformFooter() *C.char {
	return C.CString(transform.Footer)
}

//export GetTransformKeepNames
func GetTransformKeepNames() C.int {
	if transform.KeepNames {
		return C.int(1)
	}
	return C.int(0)
}

//export GetTransformSourceFile
func GetTransformSourceFile() *C.char {
	return C.CString(transform.Sourcefile)
}

//export GetTransformLoader
func GetTransformLoader() C.int {
	return C.int(transform.Loader)
}
