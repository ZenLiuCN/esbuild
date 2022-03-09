package cn.zenliu.java.esbuild;

import jnr.ffi.LibraryLoader;
import jnr.ffi.annotations.Encoding;
import lombok.experimental.UtilityClass;
import lombok.val;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Zen.Liu
 * @since 2022-03-02
 */
@SuppressWarnings("unused")
public interface EsBuild {
    Build buildConfig = Build.$i;
    Transform Transform = Transform.$i;

    final class Build {
        final static Build $i = new Build();

        public Build reset() {
            $.instance.ResetBuild();
            return this;
        }

        public BuildResult build() {
            return $.instance.build();
        }

        public boolean isWatch() {
            return $.instance.getBuildWatch();
        }

        public Map<String, String> getFooter() {
            return $.instance.getBuildFooter();
        }

        public Map<String, String> getBanner() {
            return $.instance.getBuildBanner();
        }

        public Map<String, String> getOutExtensions() {
            return $.instance.getBuildOutExtensions();
        }

        public boolean isWrite() {
            return $.instance.getBuildWrite();
        }

        public boolean isIncremental() {
            return $.instance.getBuildIncremental();
        }

        public boolean isAllowOverwrite() {
            return $.instance.getBuildAllowOverwrite();
        }

        public String getPublicPath() {
            return $.instance.GetBuildPublicPath();
        }

        public String getAssetNames() {
            return $.instance.GetBuildAssetNames();
        }

        public String getChunkNames() {
            return $.instance.GetBuildChunkNames();
        }

        public List<String> getResolveExtensions() {
            return $.instance.getBuildResolveExtensions();
        }

        public List<String> getEntryPoints() {
            return $.instance.getBuildEntryPoints();
        }

        public List<String> getNodePaths() {
            return $.instance.getBuildNodePaths();
        }

        public List<String> getInject() {
            return $.instance.getBuildInject();
        }

        public List<String> getConditions() {
            return $.instance.getBuildConditions();
        }

        public List<String> getExternal() {
            return $.instance.getBuildExternal();
        }

        public List<String> getMainFields() {
            return $.instance.getBuildMainFields();
        }


        public boolean isBundle() {
            return $.instance.getBuildBundle();
        }

        public boolean isPreserveSymlinks() {
            return $.instance.getBuildPreserveSymlinks();
        }

        public boolean isSplitting() {
            return $.instance.getBuildSplitting();
        }


        public boolean isMetafile() {
            return $.instance.getBuildMetafile();
        }

        public String getTsconfig() {
            return $.instance.GetBuildTsconfig();
        }

        public String getOutfile() {
            return $.instance.GetBuildOutfile();
        }

        public String getAbsWorkingDir() {
            return $.instance.GetBuildAbsWorkingDir();
        }

        public String getOutDir() {
            return $.instance.GetBuildOutDir();
        }

        public String getOutBase() {
            return $.instance.GetBuildOutBase();
        }

        public Build addLoader(String k, Loader v) {
            $.instance.BuildAddLoader(k, v.ordinal());
            return this;
        }

        public Build removeLoader(String k) {
            $.instance.BuildRemoveLoader(k);
            return this;
        }

        public Build cleanLoader() {
            $.instance.BuildCleanLoader();
            return this;
        }

        public Build setWatch(boolean v) {
            if (v) $.instance.BuildWatch();
            else $.instance.BuildUnWatch();
            return this;
        }


        public Build addFooter(String k, String v) {
            $.instance.BuildAddFooter(k, v);
            return this;
        }

        public Build removeFooter(String k) {
            $.instance.BuildRemoveFooter(k);
            return this;
        }

        public Build cleanFooter() {
            $.instance.BuildCleanFooter();
            return this;
        }

        public Build aBanner(String k, String v) {
            $.instance.BuildAddBanner(k, v);
            return this;
        }

        public Build removeBanner(String k) {
            $.instance.BuildRemoveBanner(k);
            return this;
        }

        public Build cleanBanner() {
            $.instance.BuildCleanBanner();
            return this;
        }

        public Build addOutExtensions(String k, String v) {
            $.instance.BuildAddOutExtensions(k, v);
            return this;
        }

        public Build removeOutExtensions(String k) {
            $.instance.BuildRemoveOutExtensions(k);
            return this;
        }

        public Build cleanOutExtensions() {
            $.instance.BuildCleanOutExtensions();
            return this;
        }

        public Build addEntryPointsAdvanced(String k, String v) {
            $.instance.BuildAddEntryPointsAdvanced(k, v);
            return this;
        }

        public Build cleanEntryPointsAdvanced() {
            $.instance.BuildCleanEntryPointsAdvanced();
            return this;
        }

        public Build setWrite(boolean v) {
            $.instance.BuildWrite(v ? 1 : 0);
            return this;
        }

        public Build setIncremental(boolean v) {
            $.instance.BuildIncremental(v ? 1 : 0);
            return this;
        }

        public Build setAllowOverwrite(boolean v) {
            $.instance.BuildAllowOverwrite(v ? 1 : 0);
            return this;
        }

        public Build setPublicPath(String v) {
            $.instance.BuildPublicPath(v);
            return this;
        }

        public Build setAssetNames(String v) {
            $.instance.BuildAssetNames(v);
            return this;
        }

        public Build setChunkNames(String v) {
            $.instance.BuildChunkNames(v);
            return this;
        }

        public Build addResolveExtensions(String v) {
            $.instance.BuildAddResolveExtensions(v);
            return this;
        }

        public Build cleanResolveExtensions() {
            $.instance.BuildCleanResolveExtensions();
            return this;
        }

        public Build addEntryPoints(String v) {
            $.instance.BuildAddEntryPoints(v);
            return this;
        }

        public Build cleanEntryPoints() {
            $.instance.BuildCleanEntryPoints();
            return this;
        }

        public Build addNodePaths(String v) {
            $.instance.BuildAddNodePaths(v);
            return this;
        }

        public Build cleanNodePaths() {
            $.instance.BuildCleanNodePaths();
            return this;
        }

        public Build addInject(String v) {
            $.instance.BuildAddInject(v);
            return this;
        }

        public Build cleanInject() {
            $.instance.BuildCleanInject();
            return this;
        }

        public Build addConditions(String v) {
            $.instance.BuildAddConditions(v);
            return this;
        }

        public Build cleanConditions() {
            $.instance.BuildCleanConditions();
            return this;
        }

        public Build addExternal(String v) {
            $.instance.BuildAddExternal(v);
            return this;
        }

        public Build cleanExternal() {
            $.instance.BuildCleanExternal();
            return this;
        }

        public Build addMainFields(String v) {
            $.instance.BuildAddMainFields(v);
            return this;
        }

        public Build cleanMainFields() {
            $.instance.BuildCleanMainFields();
            return this;
        }

        public Build setBundle(boolean v) {
            $.instance.BuildBundle(v ? 1 : 0);
            return this;
        }

        public Build setPreserveSymlinks(boolean v) {
            $.instance.BuildPreserveSymlinks(v ? 1 : 0);
            return this;
        }

        public Build setSplitting(boolean v) {
            $.instance.BuildSplitting(v ? 1 : 0);
            return this;
        }

        public Build setMetafile(boolean v) {
            $.instance.BuildMetafile(v ? 1 : 0);
            return this;
        }

        public Build setTsconfig(String v) {
            $.instance.BuildTsconfig(v);
            return this;
        }

        public Build setOutfile(String v) {
            $.instance.BuildOutfile(v);
            return this;
        }

        public Build setAbsWorkingDir(String v) {
            $.instance.BuildAbsWorkingDir(v);
            return this;
        }

        public Build setOutDir(String v) {
            $.instance.BuildOutDir(v);
            return this;
        }

        public Build setOutBase(String v) {
            $.instance.BuildOutBase(v);
            return this;
        }

        public Build setColor(StderrColor v) {
            $.instance.BuildColor(v.ordinal());
            return this;
        }

        public Build setLogLimit(int v) {
            $.instance.BuildLogLimit(v);
            return this;
        }

        public Build setLogLevel(LogLevel v) {
            $.instance.BuildLogLevel(v.ordinal());
            return this;
        }

        public Build setSourceMap(boolean v) {
            $.instance.BuildSourceMap(v ? 1 : 0);
            return this;
        }

        public Build setSourceRoot(String v) {
            $.instance.BuildSourceRoot(v);
            return this;
        }

        public Build setSourceContent(SourcesContent v) {
            $.instance.BuildSourceContent(v.ordinal());
            return this;
        }

        public Build setTarget(Target v) {
            $.instance.BuildTarget(v.ordinal());
            return this;
        }

        public Build addEngine(EngineName engine, String version) {
            $.instance.BuildAddEngine(engine.ordinal(), version);
            return this;
        }

        public Build cleanEngine() {
            $.instance.BuildCleanEngine();
            return this;
        }

        public Build setFormat(Format v) {
            $.instance.BuildFormat(v.ordinal());
            return this;
        }

        public Build setMangleProps(String v) {
            $.instance.BuildMangleProps(v);
            return this;
        }

        public Build setGlobalName(String v) {
            $.instance.BuildGlobalName(v);
            return this;
        }

        public Build setMangleCache(int v) {
            $.instance.BuildMangleCache(v);
            return this;
        }

        public Build setDrop(Drop v) {
            $.instance.BuildDrop(v.ordinal());
            return this;
        }

        public Build setMinifyWhitespace(boolean v) {
            $.instance.BuildMinifyWhitespace(v ? 1 : 0);
            return this;
        }

        public Build setMinifyIdentifiers(boolean v) {
            $.instance.BuildMinifyIdentifiers(v ? 1 : 0);
            return this;
        }

        public Build setMinifySyntax(boolean v) {
            $.instance.BuildMinifySyntax(v ? 1 : 0);
            return this;
        }

        public Build setCharset(Charset v) {
            $.instance.BuildCharset(v.ordinal());
            return this;
        }

        public Build setTreeShaking(TreeShaking v) {
            $.instance.BuildTreeShaking(v.ordinal());
            return this;
        }

        public Build setIgnoreAnnotations(boolean v) {
            $.instance.BuildIgnoreAnnotations(v ? 1 : 0);
            return this;
        }

        public Build setLegalComments(LegalComments v) {
            $.instance.BuildLegalComments(v.ordinal());
            return this;
        }

        public Build setJSXMode(JSXMode v) {
            $.instance.BuildJSXMode(v.ordinal());
            return this;
        }

        public Build setJSXFactory(String v) {
            $.instance.BuildJSXFactory(v);
            return this;
        }

        public Build setJSXFragment(String v) {
            $.instance.BuildJSXFragment(v);
            return this;
        }

        public Build setBanner(String v) {
            $.instance.BuildBanner(v);
            return this;
        }

        public Build setFooter(String v) {
            $.instance.BuildFooter(v);
            return this;
        }

        public Build addDefine(String k, String v) {
            $.instance.BuildAddDefine(k, v);
            return this;
        }

        public Build cleanDefine() {
            $.instance.BuildCleanDefine();
            return this;
        }

        public Build addPure(String v) {
            $.instance.BuildAddPure(v);
            return this;
        }

        public Build cleanPure() {
            $.instance.BuildCleanPure();
            return this;
        }

        public boolean isKeepNames() {
            return $.instance.BuildKeepNames() == 1;
        }

        public StderrColor getColor() {
            return StderrColor.values()[$.instance.GetBuildColor()];
        }

        public int getLogLimit() {
            return $.instance.GetBuildLogLimit();
        }

        public LogLevel getLogLevel() {
            return LogLevel.values()[$.instance.GetBuildLogLevel()];
        }

        public boolean isSourceMap() {
            return 1 == $.instance.GetBuildSourceMap();
        }

        public String getSourceRoot() {
            return $.instance.GetBuildSourceRoot();
        }

        public SourcesContent getSourceContent() {
            return SourcesContent.values()[$.instance.GetBuildSourceContent()];
        }

        public Target getTarget() {
            return Target.values()[$.instance.GetBuildTarget()];
        }

        public Format getFormat() {
            return Format.values()[$.instance.GetBuildFormat()];
        }

        public String getMangleProps() {
            return $.instance.GetBuildMangleProps();
        }

        public String getGlobalName() {
            return $.instance.GetBuildGlobalName();
        }

        public Drop getDrop() {
            return Drop.values()[$.instance.GetBuildDrop()];
        }

        public boolean isMinifyWhitespace() {
            return 1 == $.instance.GetBuildMinifyWhitespace();
        }

        public boolean isMinifyIdentifiers() {
            return 1 == $.instance.GetBuildMinifyIdentifiers();
        }

        public boolean isMinifySyntax() {
            return 1 == $.instance.GetBuildMinifySyntax();
        }

        public Charset getCharset() {
            return Charset.values()[$.instance.GetBuildCharset()];
        }

        public TreeShaking getTreeShaking() {
            return TreeShaking.values()[$.instance.GetBuildTreeShaking()];
        }

        public boolean isIgnoreAnnotations() {
            return 1 == $.instance.GetBuildIgnoreAnnotations();
        }

        public LegalComments getLegalComments() {
            return LegalComments.values()[$.instance.GetBuildLegalComments()];
        }

        public JSXMode getJSXMode() {
            return JSXMode.values()[$.instance.GetBuildJSXMode()];
        }

        public String getBuildJSXFactory() {
            return $.instance.GetBuildJSXFactory();
        }

        public String getBuildJSXFragment() {
            return $.instance.GetBuildJSXFragment();
        }

        public boolean isBuildKeepNames() {
            return $.instance.GetBuildKeepNames() == 1;
        }
    }

    final class Transform {
        final static Transform $i = new Transform();

        public TransformResult transform(String code) {
            return $.instance.transform(code);
        }

        public Transform reset() {
            $.instance.ResetTransform();
            return this;
        }

        public Transform setColor(StderrColor v) {
            $.instance.transformColor(v);
            return this;
        }

        public Transform setLogLimit(int v) {
            $.instance.transformLogLimit(v);
            return this;
        }

        public Transform setLogLevel(LogLevel v) {
            $.instance.transformLogLevel(v);
            return this;
        }

        public Transform setSourceMap(SourceMap v) {
            $.instance.transformSourceMap(v);
            return this;
        }

        public Transform setSourceRoot(String v) {
            $.instance.transformSourceRoot(v);
            return this;
        }

        public Transform setSourceContent(SourcesContent v) {
            $.instance.transformSourceContent(v);
            return this;
        }

        public Transform setTarget(Target v) {
            $.instance.transformTarget(v);
            return this;
        }

        public Transform setEngine(List<Map.Entry<EngineName, String>> v) {
            $.instance.transformEngine(v);
            return this;
        }

        public Transform setFormat(Format v) {
            $.instance.transformFormat(v);
            return this;
        }

        public Transform setMangleProps(String v) {
            $.instance.transformMangleProps(v);
            return this;
        }

        public Transform setGlobalName(String v) {
            $.instance.transformGlobalName(v);
            return this;
        }

        public Transform setMangleCache(int v) {
            $.instance.transformMangleCache(v);
            return this;
        }

        public Transform setDrop(Drop v) {
            $.instance.transformDrop(v);
            return this;
        }

        public Transform setMinifyWhitespace(boolean v) {
            $.instance.transformMinifyWhitespace(v);
            return this;
        }

        public Transform setMinifyIdentifiers(boolean v) {
            $.instance.transformMinifyIdentifiers(v);
            return this;
        }

        public Transform setMinifySyntax(boolean v) {
            $.instance.transformMinifySyntax(v);
            return this;
        }

        public Transform setCharset(Charset v) {
            $.instance.transformCharset(v);
            return this;
        }

        public Transform setTreeShaking(TreeShaking v) {
            $.instance.transformTreeShaking(v);
            return this;
        }

        public Transform setIgnoreAnnotations(boolean v) {
            $.instance.transformIgnoreAnnotations(v);
            return this;
        }

        public Transform setLegalComments(LegalComments v) {
            $.instance.transformLegalComments(v);
            return this;
        }

        public Transform setJSXMode(JSXMode v) {
            $.instance.transformJSXMode(v);
            return this;
        }

        public Transform setJSXFactory(String v) {
            $.instance.transformJSXFactory(v);
            return this;
        }

        public Transform setJSXFragment(String v) {
            $.instance.transformJSXFragment(v);
            return this;
        }

        public Transform setTsconfigRaw(String v) {
            $.instance.transformTsconfigRaw(v);
            return this;
        }

        public Transform setBanner(String v) {
            $.instance.transformBanner(v);
            return this;
        }

        public Transform setFooter(String v) {
            $.instance.transformFooter(v);
            return this;
        }

        public Transform setAddDefine(Map<String, String> v) {
            $.instance.transformAddDefine(v);
            return this;
        }

        public Transform setPure(List<String> v) {
            $.instance.transformPure(v);
            return this;
        }

        public Transform setKeepNames(boolean v) {
            $.instance.transformKeepNames(v);
            return this;
        }

        public Transform setSourceFile(String v) {
            $.instance.transformSourceFile(v);
            return this;
        }

        public Transform setLoader(Loader v) {
            $.instance.transformLoader(v);
            return this;
        }

        public StderrColor getColor() {
            return $.instance.getTransformColor();
        }

        public int getLogLimit() {
            return $.instance.getTransformLogLimit();
        }

        public LogLevel getLogLevel() {
            return $.instance.getTransformLogLevel();
        }

        public SourceMap getSourceMap() {
            return $.instance.getTransformSourceMap();
        }

        public String getSourceRoot() {
            return $.instance.getTransformSourceRoot();
        }

        public SourcesContent getSourceContent() {
            return $.instance.getTransformSourceContent();
        }

        public Target getTarget() {
            return $.instance.getTransformTarget();
        }

        public Format getFormat() {
            return $.instance.getTransformFormat();
        }

        public String getMangleProps() {
            return $.instance.getTransformMangleProps();
        }

        public String getGlobalName() {
            return $.instance.getTransformGlobalName();
        }

        public Drop getDrop() {
            return $.instance.getTransformDrop();
        }

        public boolean isMinifyWhitespace() {
            return $.instance.getTransformMinifyWhitespace();
        }

        public boolean isMinifyIdentifiers() {
            return $.instance.getTransformMinifyIdentifiers();
        }

        public boolean isMinifySyntax() {
            return $.instance.getTransformMinifySyntax();
        }

        public Charset getCharset() {
            return $.instance.getTransformCharset();
        }

        public TreeShaking getTreeShaking() {
            return $.instance.getTransformTreeShaking();
        }

        public boolean isIgnoreAnnotations() {
            return $.instance.getTransformIgnoreAnnotations();
        }

        public LegalComments getLegalComments() {
            return $.instance.getTransformLegalComments();
        }

        public JSXMode getJSXMode() {
            return $.instance.getTransformJSXMode();
        }

        public String getJSXFactory() {
            return $.instance.getTransformJSXFactory();
        }

        public String getJSXFragment() {
            return $.instance.getTransformJSXFragment();
        }

        public String getTsconfigRaw() {
            return $.instance.getTransformTsconfigRaw();
        }

        public String getBanner() {
            return $.instance.getTransformBanner();
        }

        public String getFooter() {
            return $.instance.getTransformFooter();
        }

        public boolean isKeepNames() {
            return $.instance.getTransformKeepNames();
        }

        public String getSourceFile() {
            return $.instance.getTransformSourceFile();
        }

        public Loader getLoader() {
            return $.instance.getTransformLoader();
        }
    }


    static $.EsBuildNative instance() {
        return $.instance;
    }

    static void reset() {
        $.instance.Reset();
    }

    @UtilityClass
    final class $ {
        //region lib extract from https://github.com/adamheinrich/native-utils/blob/master/src/main/java/cz/adamh/utils/NativeUtils.java
        private static final int MIN_PREFIX_LENGTH = 3;
        public static final String NATIVE_FOLDER_PATH_PREFIX = "nativeutils";
        private static File temporaryDir;

        static <T> T loadLibraryFromJar(String path, Function<String, T> ready) throws IOException {
            if (null == path || !path.startsWith("/")) {
                throw new IllegalArgumentException("The path has to be absolute (start with '/').");
            }

            // Obtain filename from path
            String[] parts = path.split("/");
            String filename = (parts.length > 1) ? parts[parts.length - 1] : null;

            // Check if the filename is okay
            if (filename == null || filename.length() < MIN_PREFIX_LENGTH) {
                throw new IllegalArgumentException("The filename has to be at least 3 characters long.");
            }

            // Prepare temporary file
            if (temporaryDir == null) {
                temporaryDir = createTempDirectory(NATIVE_FOLDER_PATH_PREFIX);
                temporaryDir.deleteOnExit();
            }

            File temp = new File(temporaryDir, filename);

            try (InputStream is = $.class.getResourceAsStream(path)) {
                Files.copy(is, temp.toPath(), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                temp.delete();
                throw e;
            } catch (NullPointerException e) {
                temp.delete();
                throw new FileNotFoundException("File " + path + " was not found inside JAR.");
            }

            try {
                return ready.apply(temp.getAbsolutePath());
            } finally {
                if (isPosixCompliant()) {
                    // Assume POSIX compliant file system, can be deleted after loading
                    temp.delete();
                } else {
                    // Assume non-POSIX, and don't delete until last file descriptor closed
                    temp.deleteOnExit();
                }
            }
        }

        private static boolean isPosixCompliant() {
            try {
                return FileSystems.getDefault()
                        .supportedFileAttributeViews()
                        .contains("posix");
            } catch (FileSystemNotFoundException
                    | ProviderNotFoundException
                    | SecurityException e) {
                return false;
            }
        }

        private static File createTempDirectory(String prefix) throws IOException {
            String tempDir = System.getProperty("java.io.tmpdir");
            File generatedDir = new File(tempDir, prefix + System.nanoTime());

            if (!generatedDir.mkdir())
                throw new IOException("Failed to create temp directory " + generatedDir.getName());

            return generatedDir;
        }

        //endregion


        @SuppressWarnings("unused")
        public interface EsBuildNative {
            char KeySplitter = 'Θ';
            char ArraySplitter = ',';
            String KeySplitterStr = KeySplitter + "";
            String ArraySplitterStr = ArraySplitter + "";

            enum ResultType {
                Warn,
                Error,
                Code,
                SourceMap,
                Meta,
                Output,
            }

            void Debugger(int v);


            //region BuildConfig
            void ResetBuild();

            int GetBuildWatch();

            default boolean getBuildWatch() {
                return GetBuildWatch() == 1;
            }

            @Encoding("UTF-8")
            String GetBuildFooter();

            default Map<String, String> getBuildFooter() {
                val s = GetBuildFooter();
                if (s.isEmpty()) return Collections.emptyMap();
                return Arrays.stream(s.split(ArraySplitterStr))
                        .sequential().map(x -> {
                            val e = x.split(KeySplitterStr);
                            if (e.length != 2) return null;
                            return new AbstractMap.SimpleEntry<>(e[0], e[1]);
                        })
                        .filter(Objects::nonNull)
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
            }

            @Encoding("UTF-8")
            String GetBuildBanner();

            default Map<String, String> getBuildBanner() {
                val s = GetBuildBanner();
                if (s.isEmpty()) return Collections.emptyMap();
                return Arrays.stream(s.split(ArraySplitterStr))
                        .sequential().map(x -> {
                            val e = x.split(KeySplitterStr);
                            if (e.length != 2) return null;
                            return new AbstractMap.SimpleEntry<>(e[0], e[1]);
                        })
                        .filter(Objects::nonNull)
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
            }

            @Encoding("UTF-8")
            String GetBuildOutExtensions();

            default Map<String, String> getBuildOutExtensions() {
                val s = GetBuildOutExtensions();
                if (s.isEmpty()) return Collections.emptyMap();
                return Arrays.stream(s.split(ArraySplitterStr))
                        .sequential().map(x -> {
                            val e = x.split(KeySplitterStr);
                            if (e.length != 2) return null;
                            return new AbstractMap.SimpleEntry<>(e[0], e[1]);
                        })
                        .filter(Objects::nonNull)
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
            }

            int GetBuildWrite();

            default boolean getBuildWrite() {
                return GetBuildWrite() == 1;
            }

            int GetBuildIncremental();

            default boolean getBuildIncremental() {
                return GetBuildIncremental() == 1;
            }

            int GetBuildAllowOverwrite();

            default boolean getBuildAllowOverwrite() {
                return GetBuildAllowOverwrite() == 1;
            }

            @Encoding("UTF-8")
            String GetBuildPublicPath();

            @Encoding("UTF-8")
            String GetBuildAssetNames();

            @Encoding("UTF-8")
            String GetBuildChunkNames();

            @Encoding("UTF-8")
            String GetBuildResolveExtensions();

            default List<String> getBuildResolveExtensions() {
                return Arrays.stream(GetBuildResolveExtensions().split(ArraySplitterStr))
                        .sequential()
                        .filter(x -> !x.isEmpty())
                        .collect(Collectors.toList());
            }

            @Encoding("UTF-8")
            String GetBuildEntryPoints();

            default List<String> getBuildEntryPoints() {
                return Arrays.stream(GetBuildEntryPoints().split(ArraySplitterStr))
                        .sequential()
                        .filter(x -> !x.isEmpty())
                        .collect(Collectors.toList());
            }

            @Encoding("UTF-8")
            String GetBuildNodePaths();

            default List<String> getBuildNodePaths() {
                return Arrays.stream(GetBuildNodePaths().split(ArraySplitterStr))
                        .sequential()
                        .filter(x -> !x.isEmpty())
                        .collect(Collectors.toList());
            }

            @Encoding("UTF-8")
            String GetBuildInject();

            default List<String> getBuildInject() {
                return Arrays.stream(GetBuildInject().split(ArraySplitterStr))
                        .sequential()
                        .filter(x -> !x.isEmpty())
                        .collect(Collectors.toList());
            }

            @Encoding("UTF-8")
            String GetBuildConditions();

            default List<String> getBuildConditions() {
                return Arrays.stream(GetBuildConditions().split(ArraySplitterStr))
                        .sequential()
                        .filter(x -> !x.isEmpty())
                        .collect(Collectors.toList());
            }

            @Encoding("UTF-8")
            String GetBuildExternal();

            default List<String> getBuildExternal() {
                return Arrays.stream(GetBuildExternal().split(ArraySplitterStr))
                        .sequential()
                        .filter(x -> !x.isEmpty())
                        .collect(Collectors.toList());
            }

            @Encoding("UTF-8")
            String GetBuildMainFields();

            default List<String> getBuildMainFields() {
                return Arrays.stream(GetBuildMainFields().split(ArraySplitterStr))
                        .sequential()
                        .filter(x -> !x.isEmpty())
                        .collect(Collectors.toList());
            }

            int GetBuildBundle();

            default boolean getBuildBundle() {
                return GetBuildBundle() == 1;
            }

            int GetBuildPreserveSymlinks();

            default boolean getBuildPreserveSymlinks() {
                return GetBuildPreserveSymlinks() == 1;
            }

            int GetBuildSplitting();

            default boolean getBuildSplitting() {
                return GetBuildSplitting() == 1;
            }

            int GetBuildMetafile();

            default boolean getBuildMetafile() {
                return GetBuildMetafile() == 1;
            }

            @Encoding("UTF-8")
            String GetBuildTsconfig();

            @Encoding("UTF-8")
            String GetBuildOutfile();

            @Encoding("UTF-8")
            String GetBuildAbsWorkingDir();

            @Encoding("UTF-8")
            String GetBuildOutDir();

            @Encoding("UTF-8")
            String GetBuildOutBase();


            void BuildAddLoader(@Encoding("UTF-8") String k, int v);

            void BuildRemoveLoader(@Encoding("UTF-8") String k);

            void BuildCleanLoader();

            void BuildWatch();

            void BuildUnWatch();

            void BuildAddFooter(@Encoding("UTF-8") String k, @Encoding("UTF-8") String v);

            void BuildRemoveFooter(@Encoding("UTF-8") String k);

            void BuildCleanFooter();

            void BuildAddBanner(@Encoding("UTF-8") String k, @Encoding("UTF-8") String v);

            void BuildRemoveBanner(@Encoding("UTF-8") String k);

            void BuildCleanBanner();

            void BuildAddOutExtensions(@Encoding("UTF-8") String k, @Encoding("UTF-8") String v);

            void BuildRemoveOutExtensions(@Encoding("UTF-8") String k);

            void BuildCleanOutExtensions();

            void BuildAddEntryPointsAdvanced(@Encoding("UTF-8") String k, @Encoding("UTF-8") String v);

            void BuildCleanEntryPointsAdvanced();

            void BuildWrite(int v);

            void BuildIncremental(int v);

            void BuildAllowOverwrite(int v);

            void BuildPublicPath(@Encoding("UTF-8") String v);

            void BuildAssetNames(@Encoding("UTF-8") String v);

            void BuildChunkNames(@Encoding("UTF-8") String v);

            void BuildAddResolveExtensions(@Encoding("UTF-8") String v);

            void BuildCleanResolveExtensions();

            void BuildAddEntryPoints(@Encoding("UTF-8") String v);

            void BuildCleanEntryPoints();

            void BuildAddNodePaths(@Encoding("UTF-8") String v);

            void BuildCleanNodePaths();

            void BuildAddInject(@Encoding("UTF-8") String v);

            void BuildCleanInject();

            void BuildAddConditions(@Encoding("UTF-8") String v);

            void BuildCleanConditions();

            void BuildAddExternal(@Encoding("UTF-8") String v);

            void BuildCleanExternal();

            void BuildAddMainFields(@Encoding("UTF-8") String v);

            void BuildCleanMainFields();

            void BuildBundle(int v);

            void BuildPreserveSymlinks(int v);

            void BuildSplitting(int v);

            void BuildMetafile(int v);

            void BuildTsconfig(@Encoding("UTF-8") String v);

            void BuildOutfile(@Encoding("UTF-8") String v);

            void BuildAbsWorkingDir(@Encoding("UTF-8") String v);

            void BuildOutDir(@Encoding("UTF-8") String v);

            void BuildOutBase(@Encoding("UTF-8") String v);

            void BuildColor(int color);

            void BuildLogLimit(int logLimit);

            void BuildLogLevel(int logLevel);

            void BuildSourceMap(int sourceMap);

            void BuildSourceRoot(@Encoding("UTF-8") String sourceRoot);

            void BuildSourceContent(int sourceContent);

            void BuildTarget(int target);

            void BuildAddEngine(int engine, @Encoding("UTF-8") String version);

            void BuildCleanEngine();

            void BuildFormat(int format);

            void BuildMangleProps(@Encoding("UTF-8") String mangleProps);

            void BuildGlobalName(@Encoding("UTF-8") String v);

            void BuildMangleCache(int v);

            void BuildDrop(int v);

            void BuildMinifyWhitespace(int v);

            void BuildMinifyIdentifiers(int v);

            void BuildMinifySyntax(int v);

            void BuildCharset(int v);

            void BuildTreeShaking(int v);

            void BuildIgnoreAnnotations(int v);

            void BuildLegalComments(int v);

            void BuildJSXMode(int v);

            void BuildJSXFactory(@Encoding("UTF-8") String v);

            void BuildJSXFragment(@Encoding("UTF-8") String v);

            void BuildBanner(@Encoding("UTF-8") String v);

            void BuildFooter(@Encoding("UTF-8") String v);

            void BuildAddDefine(@Encoding("UTF-8") String k, @Encoding("UTF-8") String v);

            void BuildCleanDefine();

            void BuildAddPure(@Encoding("UTF-8") String v);

            void BuildCleanPure();

            int BuildKeepNames();

            int GetBuildColor();

            int GetBuildLogLimit();

            int GetBuildLogLevel();

            int GetBuildSourceMap();

            @Encoding("UTF-8")
            String GetBuildSourceRoot();

            int GetBuildSourceContent();

            int GetBuildTarget();

            int GetBuildFormat();

            @Encoding("UTF-8")
            String GetBuildMangleProps();

            @Encoding("UTF-8")
            String GetBuildGlobalName();

            int GetBuildDrop();

            int GetBuildMinifyWhitespace();

            int GetBuildMinifyIdentifiers();

            int GetBuildMinifySyntax();

            int GetBuildCharset();

            int GetBuildTreeShaking();

            int GetBuildIgnoreAnnotations();

            int GetBuildLegalComments();

            int GetBuildJSXMode();

            @Encoding("UTF-8")
            String GetBuildJSXFactory();

            @Encoding("UTF-8")
            String GetBuildJSXFragment();


            int GetBuildKeepNames();
            //endregion

            //region TransformConfig
            void ResetTransform();

            void TransformColor(int color);


            void TransformLogLimit(int logLimit);


            void TransformLogLevel(int logLevel);


            void TransformSourceMap(int sourceMap);


            void TransformSourceRoot(String sourceRoot);


            void TransformSourceContent(int sourceContent);


            void TransformTarget(int target);


            void TransformAddEngine(int engine, @Encoding("UTF-8") String version);


            void TransformCleanEngine();


            void TransformFormat(int format);


            void TransformMangleProps(@Encoding("UTF-8") String mangleProps);


            void TransformGlobalName(@Encoding("UTF-8") String v);


            void TransformMangleCache(int v);


            void TransformDrop(int v);


            void TransformMinifyWhitespace(int v);


            void TransformMinifyIdentifiers(int v);


            void TransformMinifySyntax(int v);


            void TransformCharset(int v);


            void TransformTreeShaking(int v);


            void TransformIgnoreAnnotations(int v);


            void TransformLegalComments(int v);


            void TransformJSXMode(int v);


            void TransformJSXFactory(@Encoding("UTF-8") String v);


            void TransformJSXFragment(@Encoding("UTF-8") String v);


            void TransformTsconfigRaw(@Encoding("UTF-8") String v);


            void TransformBanner(@Encoding("UTF-8") String v);


            void TransformFooter(@Encoding("UTF-8") String v);


            void TransformAddDefine(@Encoding("UTF-8") String k, @Encoding("UTF-8") String v);


            void TransformCleanDefine();


            void TransformAddPure(@Encoding("UTF-8") String v);


            void TransformCleanPure();


            void TransformKeepNames(int v);


            void TransformSourceFile(@Encoding("UTF-8") String v);


            void TransformLoader(int v);

            default EsBuildNative transformColor(StderrColor v) {
                TransformColor(v.ordinal());
                return this;
            }

            default EsBuildNative transformLogLimit(int v) {
                TransformLogLimit(v);
                return this;
            }

            default EsBuildNative transformLogLevel(LogLevel v) {
                TransformLogLevel(v.ordinal());
                return this;
            }

            default EsBuildNative transformSourceMap(SourceMap v) {
                TransformSourceMap(v.ordinal());
                return this;
            }

            default EsBuildNative transformSourceRoot(String v) {
                TransformSourceRoot(v);
                return this;
            }

            default EsBuildNative transformSourceContent(SourcesContent v) {
                TransformSourceContent(v.ordinal());
                return this;
            }

            default EsBuildNative transformTarget(Target v) {
                TransformTarget(v.ordinal());
                return this;
            }

            default EsBuildNative transformEngine(List<Map.Entry<EngineName, String>> engines) {
                TransformCleanEngine();
                engines.forEach((k) -> {
                    TransformAddEngine(k.getKey().ordinal(), k.getValue());
                });
                return this;

            }

            default EsBuildNative transformFormat(Format v) {
                TransformFormat(v.ordinal());
                return this;
            }

            default EsBuildNative transformMangleProps(String v) {
                TransformMangleProps(v);
                return this;
            }

            default EsBuildNative transformGlobalName(String v) {
                TransformGlobalName(v);
                return this;
            }

            default EsBuildNative transformMangleCache(int v) {
                TransformMangleCache(v);
                return this;
            }

            default EsBuildNative transformDrop(Drop v) {
                TransformDrop(v.ordinal());
                return this;
            }

            default EsBuildNative transformMinifyWhitespace(boolean v) {
                TransformMinifyWhitespace(v ? 1 : 0);
                return this;
            }

            default EsBuildNative transformMinifyIdentifiers(boolean v) {
                TransformMinifyIdentifiers(v ? 1 : 0);
                return this;
            }

            default EsBuildNative transformMinifySyntax(boolean v) {
                TransformMinifyIdentifiers(v ? 1 : 0);
                return this;
            }

            default EsBuildNative transformCharset(Charset v) {
                TransformCharset(v.ordinal());
                return this;
            }

            default EsBuildNative transformTreeShaking(TreeShaking v) {
                TransformTreeShaking(v.ordinal());
                return this;
            }

            default EsBuildNative transformIgnoreAnnotations(boolean v) {
                TransformIgnoreAnnotations(v ? 1 : 0);
                return this;
            }

            default EsBuildNative transformLegalComments(LegalComments v) {
                TransformLegalComments(v.ordinal());
                return this;
            }

            default EsBuildNative transformJSXMode(JSXMode v) {
                TransformJSXMode(v.ordinal());
                return this;
            }

            default EsBuildNative transformJSXFactory(String v) {
                TransformJSXFactory(v);
                return this;
            }

            default EsBuildNative transformJSXFragment(String v) {
                TransformJSXFragment(v);
                return this;
            }

            default EsBuildNative transformTsconfigRaw(String v) {
                TransformTsconfigRaw(v);
                return this;
            }

            default EsBuildNative transformBanner(String v) {
                TransformBanner(v);
                return this;
            }

            default EsBuildNative transformFooter(String v) {
                TransformFooter(v);
                return this;
            }

            default EsBuildNative transformAddDefine(Map<String, String> define) {
                TransformCleanDefine();
                define.forEach(this::TransformAddDefine);
                return this;
            }

            default EsBuildNative transformPure(List<String> v) {
                TransformCleanPure();
                v.forEach(this::TransformAddPure);
                return this;
            }

            default EsBuildNative transformKeepNames(boolean v) {
                TransformKeepNames(v ? 1 : 0);
                return this;
            }

            default EsBuildNative transformSourceFile(String v) {
                TransformSourceFile(v);
                return this;
            }

            default EsBuildNative transformLoader(Loader v) {
                TransformLoader(v.ordinal());
                return this;
            }


            int GetTransformColor();

            int GetTransformLogLimit();

            int GetTransformLogLevel();

            int GetTransformSourceMap();

            @Encoding("UTF-8")
            String GetTransformSourceRoot();

            int GetTransformSourceContent();

            int GetTransformTarget();

            int GetTransformFormat();

            @Encoding("UTF-8")
            String GetTransformMangleProps();

            @Encoding("UTF-8")
            String GetTransformGlobalName();

            int GetTransformDrop();

            int GetTransformMinifyWhitespace();

            int GetTransformMinifyIdentifiers();

            int GetTransformMinifySyntax();

            int GetTransformCharset();

            int GetTransformTreeShaking();

            int GetTransformIgnoreAnnotations();

            int GetTransformLegalComments();

            int GetTransformJSXMode();

            @Encoding("UTF-8")
            String GetTransformJSXFactory();

            @Encoding("UTF-8")
            String GetTransformJSXFragment();

            @Encoding("UTF-8")
            String GetTransformTsconfigRaw();

            @Encoding("UTF-8")
            String GetTransformBanner();

            @Encoding("UTF-8")
            String GetTransformFooter();

            int GetTransformKeepNames();

            @Encoding("UTF-8")
            String GetTransformSourceFile();

            int GetTransformLoader();

            default StderrColor getTransformColor() {
                return StderrColor.values()[GetTransformColor()];
            }

            default int getTransformLogLimit() {
                return GetTransformLogLimit();
            }

            default LogLevel getTransformLogLevel() {
                return LogLevel.values()[GetTransformLogLevel()];
            }

            default SourceMap getTransformSourceMap() {
                return SourceMap.values()[GetTransformSourceMap()];
            }

            default String getTransformSourceRoot() {
                return GetTransformSourceRoot();
            }

            default SourcesContent getTransformSourceContent() {
                return SourcesContent.values()[GetTransformSourceContent()];
            }

            default Target getTransformTarget() {
                return Target.values()[GetTransformTarget()];
            }

            default Format getTransformFormat() {
                return Format.values()[GetTransformFormat()];
            }

            default String getTransformMangleProps() {
                return GetTransformMangleProps();
            }

            default String getTransformGlobalName() {
                return GetTransformGlobalName();
            }

            default Drop getTransformDrop() {
                return Drop.values()[GetTransformDrop()];
            }

            default boolean getTransformMinifyWhitespace() {
                return GetTransformMinifyWhitespace() == 1;
            }

            default boolean getTransformMinifyIdentifiers() {
                return GetTransformMinifyIdentifiers() == 1;
            }

            default boolean getTransformMinifySyntax() {
                return GetTransformMinifySyntax() == 1;
            }

            default Charset getTransformCharset() {
                return Charset.values()[GetTransformCharset()];
            }

            default TreeShaking getTransformTreeShaking() {
                return TreeShaking.values()[GetTransformTreeShaking()];
            }

            default boolean getTransformIgnoreAnnotations() {
                return GetTransformIgnoreAnnotations() == 1;
            }

            default LegalComments getTransformLegalComments() {
                return LegalComments.values()[GetTransformLegalComments()];
            }

            default JSXMode getTransformJSXMode() {
                return JSXMode.values()[GetTransformJSXMode()];
            }

            default String getTransformJSXFactory() {
                return GetTransformJSXFactory();
            }

            default String getTransformJSXFragment() {
                return GetTransformJSXFragment();
            }

            default String getTransformTsconfigRaw() {
                return GetTransformTsconfigRaw();
            }

            default String getTransformBanner() {
                return GetTransformBanner();
            }

            default String getTransformFooter() {
                return GetTransformFooter();
            }

            default boolean getTransformKeepNames() {
                return GetTransformKeepNames() == 1;
            }

            default String getTransformSourceFile() {
                return GetTransformSourceFile();
            }

            default Loader getTransformLoader() {
                return Loader.values()[GetTransformLoader()];
            }
            //endregion


            default TransformResult transform(String code) {
                val ss = Transform(code);
                val error = getResult(ss, ResultType.Error);
                val warn = getResult(ss, ResultType.Warn);
                val cc = getResult(ss, ResultType.Code);
                val map = getResult(ss, ResultType.SourceMap);
                EndSession(ss);
                return TransformResult.of(cc, map, error, warn);
            }

            int Transform(@Encoding("UTF-8") String v);

            int Build();

            default BuildResult build() {
                val ss = Build();
                val error = getResult(ss, ResultType.Error);
                val warn = getResult(ss, ResultType.Warn);
                val meta = getResult(ss, ResultType.Meta);
                val output = getResult(ss, ResultType.Output);
                val outFile = Arrays.stream(output.split(ArraySplitterStr)).sequential()
                        .map(x -> {
                            val ks = x.split(KeySplitterStr);
                            if (ks.length != 2) return null;
                            return new AbstractMap.SimpleEntry<>(ks[0], ks[1]);
                        })
                        .filter(Objects::nonNull)
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
                EndSession(ss);
                return BuildResult.of(outFile, meta, error, warn);
            }

            void EndSession(int session);

            void Reset();

            @Encoding("UTF-8")
            String GetResult(int session, int type);

            default String getResult(int session, ResultType type) {
                return GetResult(session, type.ordinal());
            }
        }

        static final EsBuildNative instance;
        final boolean IS_WINDOWS;
        final boolean IS_MAC;
        final boolean IS_UNIX;
        final boolean IS_SOLARIS;

        static {
            try {
                val OS = System.getProperty("os.name").toLowerCase();
                IS_WINDOWS = (OS.contains("window"));
                IS_MAC = (OS.contains("mac"));
                IS_UNIX = (OS.contains("nix") || OS.contains("nux") || OS.indexOf("aix") > 0);
                IS_SOLARIS = (OS.contains("sunos"));
                val lib = System.mapLibraryName("esb");
                val ext = lib.substring(lib.lastIndexOf(".") + 1);
                instance = loadLibraryFromJar("/" + (IS_WINDOWS ? lib : ("esb" + "." + (IS_UNIX ? "linux" : "mac") + "." + ext)), p -> LibraryLoader.create(EsBuildNative.class).load(p));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
