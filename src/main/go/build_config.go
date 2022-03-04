package main

import "C"
import (
	"github.com/evanw/esbuild/pkg/api"
	"strings"
)

var (
	build = api.BuildOptions{
		Plugins: nil,
	}
)

//export GetBuildWatch
func GetBuildWatch() C.int {
	if build.Watch == nil {
		return C.int(0)
	}
	return C.int(1)
}

//export GetBuildFooter
func GetBuildFooter() *C.char {
	s := new(strings.Builder)
	for k, v := range build.Footer {
		s.WriteString(k)
		s.WriteRune('^')
		s.WriteString(v)
	}
	return C.CString(s.String())
}

//export GetBuildBanner
func GetBuildBanner() *C.char {
	s := new(strings.Builder)
	for k, v := range build.Banner {
		s.WriteString(k)
		s.WriteRune('^')
		s.WriteString(v)
	}
	return C.CString(s.String())
}

//export GetBuildOutExtensions
func GetBuildOutExtensions() *C.char {
	s := new(strings.Builder)
	for k, v := range build.OutExtensions {
		s.WriteString(k)
		s.WriteRune('^')
		s.WriteString(v)
	}
	return C.CString(s.String())
}

//export GetBuildWrite
func GetBuildWrite() C.int {
	if build.Write {
		return C.int(1)
	}
	return C.int(0)
}

//export GetBuildIncremental
func GetBuildIncremental() C.int {
	if build.Write {
		return C.int(1)
	}
	return C.int(0)
}

//export GetBuildAllowOverwrite
func GetBuildAllowOverwrite() C.int {
	if build.Write {
		return C.int(1)
	}
	return C.int(0)
}

//export BuildPublicPath
func GetBuildPublicPath() *C.char {
	return C.CString(build.PublicPath)
}

//export BuildAssetNames
func GetBuildAssetNames() *C.char { return C.CString(build.AssetNames) }

//export BuildChunkNames
func GetBuildChunkNames() *C.char { return C.CString(build.ChunkNames) }

//export GetBuildResolveExtensions
func GetBuildResolveExtensions() *C.char {
	return C.CString(strings.Join(build.ResolveExtensions, ","))
}

//export GetBuildEntryPoints
func GetBuildEntryPoints() *C.char { return C.CString(strings.Join(build.EntryPoints, ",")) }

//export GetBuildNodePaths
func GetBuildNodePaths() *C.char { return C.CString(strings.Join(build.NodePaths, ",")) }

//export GetBuildInject
func GetBuildInject() *C.char { return C.CString(strings.Join(build.Inject, ",")) }

//export GetBuildConditions
func GetBuildConditions() *C.char { return C.CString(strings.Join(build.Conditions, ",")) }

//export GetBuildExternal
func GetBuildExternal() *C.char { return C.CString(strings.Join(build.External, ",")) }

//export GetBuildMainFields
func GetBuildMainFields() *C.char { return C.CString(strings.Join(build.MainFields, ",")) }

//export GetBuildBundle
func GetBuildBundle() C.int {
	if build.Bundle {
		return C.int(1)
	}
	return C.int(0)
}

//export GetBuildPreserveSymlinks
func GetBuildPreserveSymlinks() C.int {
	if build.PreserveSymlinks {
		return C.int(1)
	}
	return C.int(0)
}

//export GetBuildSplitting
func GetBuildSplitting() C.int {
	if build.Splitting {
		return C.int(1)
	}
	return C.int(0)
}

//export GetBuildMetafile
func GetBuildMetafile() C.int {
	if build.Metafile {
		return C.int(1)
	}
	return C.int(0)
}

//export GetBuildTsconfig
func GetBuildTsconfig() *C.char { return C.CString(build.Tsconfig) }

//export GetBuildOutfile
func GetBuildOutfile() *C.char { return C.CString(build.Outfile) }

//export GetBuildAbsWorkingDir
func GetBuildAbsWorkingDir() *C.char { return C.CString(build.AbsWorkingDir) }

//export GetBuildOutDir
func GetBuildOutDir() *C.char { return C.CString(build.Outdir) }

//export GetBuildOutBase
func GetBuildOutBase() *C.char { return C.CString(build.Outbase) }

//export BuildAddLoader
func BuildAddLoader(k *C.char, v C.int) {
	if build.Loader == nil {
		build.Loader = make(map[string]api.Loader)
	}
	build.Loader[C.GoString(k)] = api.Loader(v)
}

//export BuildRemoveLoader
func BuildRemoveLoader(k *C.char) {
	delete(build.Loader, C.GoString(k))
}

//export BuildCleanLoader
func BuildCleanLoader() {
	build.Loader = nil
}

//export BuildWatch
func BuildWatch() {
	build.Watch = &api.WatchMode{}
}

//export BuildUnWatch
func BuildUnWatch() {
	build.Watch = nil
}

//export BuildAddFooter
func BuildAddFooter(k, v *C.char) {
	if build.Footer == nil {
		build.Footer = make(map[string]string)
	}
	build.Footer[C.GoString(k)] = C.GoString(v)
}

//export BuildRemoveFooter
func BuildRemoveFooter(k *C.char) {
	delete(build.Footer, C.GoString(k))
}

//export BuildCleanFooter
func BuildCleanFooter() {
	build.Footer = nil
}

//export BuildAddBanner
func BuildAddBanner(k, v *C.char) {
	if build.Banner == nil {
		build.Banner = make(map[string]string)
	}
	build.Banner[C.GoString(k)] = C.GoString(v)
}

//export BuildRemoveBanner
func BuildRemoveBanner(k *C.char) {
	delete(build.Banner, C.GoString(k))
}

//export BuildCleanBanner
func BuildCleanBanner() {
	build.Banner = nil
}

//export BuildAddOutExtensions
func BuildAddOutExtensions(k, v *C.char) {
	if build.OutExtensions == nil {
		build.OutExtensions = make(map[string]string)
	}
	build.OutExtensions[C.GoString(k)] = C.GoString(v)
}

//export BuildRemoveOutExtensions
func BuildRemoveOutExtensions(k *C.char) {
	delete(build.OutExtensions, C.GoString(k))
}

//export BuildCleanOutExtensions
func BuildCleanOutExtensions() {
	build.OutExtensions = nil
}

//export  BuildAddEntryPointsAdvanced
func BuildAddEntryPointsAdvanced(k, v *C.Char) {
	build.EntryPointsAdvanced = append(build.EntryPointsAdvanced, api.EntryPoint{
		InputPath:  C.GoString(k),
		OutputPath: C.GoString(v),
	})
}

//export  BuildCleanEntryPointsAdvanced
func BuildCleanEntryPointsAdvanced() {
	build.EntryPointsAdvanced = nil
}

//export  BuildWrite
func BuildWrite(v C.int) {
	build.Write = v == 1
}

//export  BuildIncremental
func BuildIncremental(v C.int) {
	build.Incremental = v == 1
}

//export  BuildAllowOverwrite
func BuildAllowOverwrite(v C.int) {
	build.AllowOverwrite = v == 1
}

//export  BuildPublicPath
func BuildPublicPath(v *C.Char) {
	build.PublicPath = C.GoString(v)
}

//export  BuildAssetNames
func BuildAssetNames(v *C.Char) {
	build.AssetNames = C.GoString(v)
}

//export  BuildChunkNames
func BuildChunkNames(v *C.Char) {
	build.ChunkNames = C.GoString(v)
}

//export BuildAddResolveExtensions
func BuildAddResolveExtensions(v *C.char) {
	build.ResolveExtensions = append(build.ResolveExtensions, C.GoString(v))
}

//export BuildCleanResolveExtensions
func BuildCleanResolveExtensions() {
	build.ResolveExtensions = nil
}

//export BuildAddEntryPoints
func BuildAddEntryPoints(v *C.char) {
	build.EntryPoints = append(build.EntryPoints, C.GoString(v))
}

//export BuildCleanEntryPoints
func BuildCleanEntryPoints() {
	build.EntryPoints = nil
}

//export BuildAddNodePaths
func BuildAddNodePaths(v *C.char) {
	build.NodePaths = append(build.NodePaths, C.GoString(v))
}

//export BuildCleanNodePaths
func BuildCleanNodePaths() {
	build.NodePaths = nil
}

//export BuildAddInject
func BuildAddInject(v *C.char) {
	build.Inject = append(build.Inject, C.GoString(v))
}

//export BuildCleanInject
func BuildCleanInject() {
	build.Inject = nil
}

//export BuildAddConditions
func BuildAddConditions(v *C.char) {
	build.Conditions = append(build.Conditions, C.GoString(v))
}

//export BuildCleanConditions
func BuildCleanConditions() {
	build.Conditions = nil
}

//export BuildAddExternal
func BuildAddExternal(v *C.char) {
	build.External = append(build.External, C.GoString(v))
}

//export BuildCleanExternal
func BuildCleanExternal() {
	build.External = nil
}

//export BuildAddMainFields
func BuildAddMainFields(v *C.char) {
	build.MainFields = append(build.MainFields, C.GoString(v))
}

//export BuildCleanMainFields
func BuildCleanMainFields() {
	build.MainFields = nil
}

//export  BuildBundle
func BuildBundle(v C.int) {
	build.Bundle = v == 1
}

//export  BuildPreserveSymlinks
func BuildPreserveSymlinks(v C.int) {
	build.PreserveSymlinks = v == 1
}

//export  BuildSplitting
func BuildSplitting(v C.int) {
	build.Splitting = v == 1
}

//export  BuildMetafile
func BuildMetafile(v C.int) {
	build.Metafile = v == 1
}

//export  BuildTsconfig
func BuildTsconfig(v *C.Char) {
	build.Tsconfig = C.GoString(v)
}

//export  BuildOutfile
func BuildOutfile(v *C.Char) {
	build.Outfile = C.GoString(v)
}

//export  BuildAbsWorkingDir
func BuildAbsWorkingDir(v *C.Char) {
	build.AbsWorkingDir = C.GoString(v)
}

//export  BuildOutDir
func BuildOutDir(v *C.Char) {
	build.Outdir = C.GoString(v)
}

//export  BuildOutBase
func BuildOutBase(v *C.Char) {
	build.Outbase = C.GoString(v)
}

//----------------

//export  BuildColor
func BuildColor(color C.int) {
	build.Color = api.StderrColor(color)
}

//export  BuildLogLimit
func BuildLogLimit(logLimit C.int) {
	build.LogLimit = int(logLimit)
}

//export  BuildLogLevel
func BuildLogLevel(logLevel C.int) {
	build.LogLevel = api.LogLevel(logLevel)
}

//export  BuildSourceMap
func BuildSourceMap(sourceMap C.int) {
	build.Sourcemap = api.SourceMap(sourceMap)
}

//export  BuildSourceRoot
func BuildSourceRoot(sourceRoot *C.char) {
	build.SourceRoot = C.GoString(sourceRoot)
}

//export  BuildSourceContent
func BuildSourceContent(sourceContent C.int) {
	build.SourcesContent = api.SourcesContent(sourceContent)
}

//export  BuildTarget
func BuildTarget(target C.int) {
	build.Target = api.Target(target)
}

//export  BuildAddEngine
func BuildAddEngine(engine C.int, version *C.char) {
	build.Engines = append(build.Engines, api.Engine{
		Name:    api.EngineName(engine),
		Version: C.GoString(version),
	})
}

//export  BuildCleanEngine
func BuildCleanEngine() {
	build.Engines = make([]api.Engine, 0)
}

//export  BuildFormat
func BuildFormat(format C.int) {
	build.Format = api.Format(format)
}

//export  BuildMangleProps
func BuildMangleProps(mangleProps *C.char) {
	build.MangleProps = C.GoString(mangleProps)
}

//export BuildGlobalName
func BuildGlobalName(v *C.char) {
	build.GlobalName = C.GoString(v)
}

//export BuildMangleCache
func BuildMangleCache(v C.int) {
	build.MangleCache = cacheMangle[int(v)]
}

//export BuildDrop
func BuildDrop(v C.int) {
	build.Drop = api.Drop(v)
}

//export BuildMinifyWhitespace
func BuildMinifyWhitespace(v C.int) {
	build.MinifyWhitespace = v == 1
}

//export BuildMinifyIdentifiers
func BuildMinifyIdentifiers(v C.int) {
	build.MinifyIdentifiers = v == 1
}

//export BuildMinifySyntax
func BuildMinifySyntax(v C.int) {
	build.MinifySyntax = v == 1
}

//export BuildCharset
func BuildCharset(v C.int) {
	build.Charset = api.Charset(v)
}

//export BuildTreeShaking
func BuildTreeShaking(v C.int) {
	build.TreeShaking = api.TreeShaking(v)
}

//export BuildIgnoreAnnotations
func BuildIgnoreAnnotations(v C.int) {
	build.IgnoreAnnotations = v == 1
}

//export BuildLegalComments
func BuildLegalComments(v C.int) {
	build.LegalComments = api.LegalComments(v)
}

//export BuildJSXMode
func BuildJSXMode(v C.int) {
	build.JSXMode = api.JSXMode(v)
}

//export BuildJSXFactory
func BuildJSXFactory(v *C.char) {
	build.JSXFactory = C.GoString(v)
}

//export BuildJSXFragment
func BuildJSXFragment(v *C.char) {
	build.JSXFragment = C.GoString(v)
}

//export BuildAddDefine
func BuildAddDefine(k, v *C.char) {
	if build.Define == nil {
		build.Define = make(map[string]string)
	}
	build.Define[C.GoString(k)] = C.GoString(v)
}

//export BuildCleanDefine
func BuildCleanDefine() {
	build.Define = nil
}

//export BuildAddPure
func BuildAddPure(v *C.char) {
	build.Pure = append(build.Pure, C.GoString(v))
}

//export BuildCleanPure
func BuildCleanPure() {
	build.Pure = nil
}

//export BuildKeepNames
func BuildKeepNames() C.int {
	if build.KeepNames {
		return C.int(1)
	}
	return C.int(0)
}

//export  GetBuildColor
func GetBuildColor() C.int {
	return C.int(build.Color)
}

//export  GetBuildLogLimit
func GetBuildLogLimit() C.int {
	return C.int(build.LogLimit)
}

//export  GetBuildLogLevel
func GetBuildLogLevel() C.int {
	return C.int(build.LogLevel)
}

//export  GetBuildSourceMap
func GetBuildSourceMap() C.int {
	return C.int(build.Sourcemap)
}

//export  GetBuildSourceRoot
func GetBuildSourceRoot() *C.char {
	return C.CString(build.SourceRoot)
}

//export  GetBuildSourceContent
func GetBuildSourceContent() C.int {
	return C.int(build.SourcesContent)
}

//export  GetBuildTarget
func GetBuildTarget() C.int {
	return C.int(build.Target)
}

//export  GetBuildFormat
func GetBuildFormat() C.int {
	return C.int(build.Format)
}

//export  GetBuildMangleProps
func GetBuildMangleProps() *C.char {
	return C.CString(build.MangleProps)
}

//export GetBuildGlobalName
func GetBuildGlobalName() *C.char {
	return C.CString(build.GlobalName)
}

//export GetBuildDrop
func GetBuildDrop() C.int {
	return C.int(build.Drop)
}

//export GetBuildMinifyWhitespace
func GetBuildMinifyWhitespace() C.int {
	if build.MinifyWhitespace {
		return C.int(1)
	}
	return C.int(0)
}

//export GetBuildMinifyIdentifiers
func GetBuildMinifyIdentifiers() C.int {
	if build.MinifyIdentifiers {
		return C.int(1)
	}
	return C.int(0)
}

//export GetBuildMinifySyntax
func GetBuildMinifySyntax() C.int {
	if build.MinifySyntax {
		return C.int(1)
	}
	return C.int(0)
}

//export GetBuildCharset
func GetBuildCharset() C.int {
	return C.int(build.Charset)
}

//export GetBuildTreeShaking
func GetBuildTreeShaking() C.int {
	return C.int(build.TreeShaking)
}

//export GetBuildIgnoreAnnotations
func GetBuildIgnoreAnnotations() C.int {
	if build.IgnoreAnnotations {
		return C.int(1)
	}
	return C.int(0)
}

//export GetBuildLegalComments
func GetBuildLegalComments() C.int {
	return C.int(build.LegalComments)
}

//export GetBuildJSXMode
func GetBuildJSXMode() C.int {
	return C.int(build.JSXMode)
}

//export GetBuildJSXFactory
func GetBuildJSXFactory() *C.char {
	return C.CString(build.JSXFactory)
}

//export GetBuildJSXFragment
func GetBuildJSXFragment() *C.char {
	return C.CString(build.JSXFragment)
}

//export GetBuildKeepNames
func GetBuildKeepNames() C.int {
	if build.KeepNames {
		return C.int(1)
	}
	return C.int(0)
}
