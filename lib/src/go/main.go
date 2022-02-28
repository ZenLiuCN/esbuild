package main

/*
typedef struct conf {
    int color,
	logLimit,
	logLevel,
	sourceMap,
	sourceRoot,
	sourcesContent,
	target,
	format,
	globalName,
	minify,
	treeshaking;
int loader;
} cfg;
typedef struct result{
	*char code;
	**char error;
} res;
*/
import "C"
import "github.com/evanw/esbuild/pkg/api"

func main() {

}

func Transform(str *C.Char, conf *C.cfg) *C.res {
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
}
