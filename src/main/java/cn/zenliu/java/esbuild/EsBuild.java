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

    static void transformColor(StderrColor v) {
        $.instance.transformColor(v);
    }

    static void transformLogLimit(int v) {
        $.instance.transformLogLimit(v);
    }

    static void transformLogLevel(LogLevel v) {
        $.instance.transformLogLevel(v);
    }

    static void transformSourceMap(SourceMap v) {
        $.instance.transformSourceMap(v);
    }

    static void transformSourceRoot(String v) {
        $.instance.transformSourceRoot(v);
    }

    static void transformSourceContent(SourcesContent v) {
        $.instance.transformSourceContent(v);
    }

    static void transformTarget(Target v) {
        $.instance.transformTarget(v);
    }

    static void transformEngine(List<Map.Entry<EngineName, String>> v) {
        $.instance.transformEngine(v);
    }

    static void transformFormat(Format v) {
        $.instance.transformFormat(v);
    }

    static void transformMangleProps(String v) {
        $.instance.transformMangleProps(v);
    }

    static void transformGlobalName(String v) {
        $.instance.transformGlobalName(v);
    }

    static void transformMangleCache(int v) {
        $.instance.transformMangleCache(v);
    }

    static void transformDrop(Drop v) {
        $.instance.transformDrop(v);
    }

    static void transformMinifyWhitespace(boolean v) {
        $.instance.transformMinifyWhitespace(v);
    }

    static void transformMinifyIdentifiers(boolean v) {
        $.instance.transformMinifyIdentifiers(v);
    }

    static void transformMinifySyntax(boolean v) {
        $.instance.transformMinifySyntax(v);
    }

    static void transformCharset(Charset v) {
        $.instance.transformCharset(v);
    }

    static void transformTreeShaking(TreeShaking v) {
        $.instance.transformTreeShaking(v);
    }

    static void transformIgnoreAnnotations(boolean v) {
        $.instance.transformIgnoreAnnotations(v);
    }

    static void transformLegalComments(LegalComments v) {
        $.instance.transformLegalComments(v);
    }

    static void transformJSXMode(JSXMode v) {
        $.instance.transformJSXMode(v);
    }

    static void transformJSXFactory(String v) {
        $.instance.transformJSXFactory(v);
    }

    static void transformJSXFragment(String v) {
        $.instance.transformJSXFragment(v);
    }

    static void transformTsconfigRaw(String v) {
        $.instance.transformTsconfigRaw(v);
    }

    static void transformBanner(String v) {
        $.instance.transformBanner(v);
    }

    static void transformFooter(String v) {
        $.instance.transformFooter(v);
    }

    static void transformAddDefine(Map<String, String> v) {
        $.instance.transformAddDefine(v);
    }

    static void transformPure(List<String> v) {
        $.instance.transformPure(v);
    }

    static void transformKeepNames(boolean v) {
        $.instance.transformKeepNames(v);
    }

    static void transformSourceFile(String v) {
        $.instance.transformSourceFile(v);
    }

    static void transformLoader(Loader v) {
        $.instance.transformLoader(v);
    }

    static StderrColor getTransformColor() {
        return $.instance.getTransformColor();
    }

    static int getTransformLogLimit() {
        return $.instance.getTransformLogLimit();
    }

    static LogLevel getTransformLogLevel() {
        return $.instance.getTransformLogLevel();
    }

    static SourceMap getTransformSourceMap() {
        return $.instance.getTransformSourceMap();
    }

    static String getTransformSourceRoot() {
        return $.instance.getTransformSourceRoot();
    }

    static SourcesContent getTransformSourceContent() {
        return $.instance.getTransformSourceContent();
    }

    static Target getTransformTarget() {
        return $.instance.getTransformTarget();
    }

    static Format getTransformFormat() {
        return $.instance.getTransformFormat();
    }

    static String getTransformMangleProps() {
        return $.instance.getTransformMangleProps();
    }

    static String getTransformGlobalName() {
        return $.instance.getTransformGlobalName();
    }

    static Drop getTransformDrop() {
        return $.instance.getTransformDrop();
    }

    static boolean getTransformMinifyWhitespace() {
        return $.instance.getTransformMinifyWhitespace();
    }

    static boolean getTransformMinifyIdentifiers() {
        return $.instance.getTransformMinifyIdentifiers();
    }

    static boolean getTransformMinifySyntax() {
        return $.instance.getTransformMinifySyntax();
    }

    static Charset getTransformCharset() {
        return $.instance.getTransformCharset();
    }

    static TreeShaking getTransformTreeShaking() {
        return $.instance.getTransformTreeShaking();
    }

    static boolean getTransformIgnoreAnnotations() {
        return $.instance.getTransformIgnoreAnnotations();
    }

    static LegalComments getTransformLegalComments() {
        return $.instance.getTransformLegalComments();
    }

    static JSXMode getTransformJSXMode() {
        return $.instance.getTransformJSXMode();
    }

    static String getTransformJSXFactory() {
        return $.instance.getTransformJSXFactory();
    }

    static String getTransformJSXFragment() {
        return $.instance.getTransformJSXFragment();
    }

    static String getTransformTsconfigRaw() {
        return $.instance.getTransformTsconfigRaw();
    }

    static String getTransformBanner() {
        return $.instance.getTransformBanner();
    }

    static String getTransformFooter() {
        return $.instance.getTransformFooter();
    }

    static boolean getTransformKeepNames() {
        return $.instance.getTransformKeepNames();
    }

    static String getTransformSourceFile() {
        return $.instance.getTransformSourceFile();
    }

    static Loader getTransformLoader() {
        return $.instance.getTransformLoader();
    }

    static TransformResult transform(String code) {
        return $.instance.transform(code);
    }

    static $.EsBuildNative instance() {
        return $.instance;
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
            void Debugger(int v);


            //region BuildConfig


            int GetBuildWatch();

            default boolean getBuildWatch() {
                return GetBuildWatch() == 1;
            }

            @Encoding("UTF-8")
            String GetBuildFooter();

            default Map<String, String> getBuildFooter() {
                val s = GetBuildFooter();
                if (s.isEmpty()) return Collections.emptyMap();
                return Arrays.stream(s.split(","))
                        .sequential().map(x -> {
                            val e = x.split("\\^");
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
                return Arrays.stream(s.split(","))
                        .sequential().map(x -> {
                            val e = x.split("\\^");
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
                return Arrays.stream(s.split(","))
                        .sequential().map(x -> {
                            val e = x.split("\\^");
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
                return Arrays.stream(GetBuildResolveExtensions().split(","))
                        .sequential()
                        .filter(x -> !x.isEmpty())
                        .collect(Collectors.toList());
            }

            @Encoding("UTF-8")
            String GetBuildEntryPoints();

            default List<String> getBuildEntryPoints() {
                return Arrays.stream(GetBuildEntryPoints().split(","))
                        .sequential()
                        .filter(x -> !x.isEmpty())
                        .collect(Collectors.toList());
            }

            @Encoding("UTF-8")
            String GetBuildNodePaths();

            default List<String> getBuildNodePaths() {
                return Arrays.stream(GetBuildNodePaths().split(","))
                        .sequential()
                        .filter(x -> !x.isEmpty())
                        .collect(Collectors.toList());
            }

            @Encoding("UTF-8")
            String GetBuildInject();

            default List<String> getBuildInject() {
                return Arrays.stream(GetBuildInject().split(","))
                        .sequential()
                        .filter(x -> !x.isEmpty())
                        .collect(Collectors.toList());
            }

            @Encoding("UTF-8")
            String GetBuildConditions();

            default List<String> getBuildConditions() {
                return Arrays.stream(GetBuildConditions().split(","))
                        .sequential()
                        .filter(x -> !x.isEmpty())
                        .collect(Collectors.toList());
            }

            @Encoding("UTF-8")
            String GetBuildExternal();

            default List<String> getBuildExternal() {
                return Arrays.stream(GetBuildExternal().split(","))
                        .sequential()
                        .filter(x -> !x.isEmpty())
                        .collect(Collectors.toList());
            }

            @Encoding("UTF-8")
            String GetBuildMainFields();

            default List<String> getBuildMainFields() {
                return Arrays.stream(GetBuildMainFields().split(","))
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

            //endregion
            //region ReadConfig
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
                val error = GetResult(ss, 0);
                val warn = GetResult(ss, 1);
                val cc = GetResult(ss, 2);
                val map = GetResult(ss, 3);
                EndSession(ss);
                return TransformResult.of(cc, map, error, warn);
            }

            int Transform(@Encoding("UTF-8") String v);

            void EndSession(int session);

            @Encoding("UTF-8")
            String GetResult(int session, int type);
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

/*    public static void main(String[] args) {
//        $.instance.Debugger(1);
        transformMinifyIdentifiers(true);
        transformMinifySyntax(true);
        transformMinifyWhitespace(true);
        transformLoader(Loader.TS);
        transformTarget(Target.ES2015);
        transformFormat(Format.ESModule);
        //Operating system name
        System.out.println("Your OS name -> " + System.getProperty("os.name"));

        //Operating system version
        System.out.println("Your OS version -> " + System.getProperty("os.version"));

        //Operating system architecture
        System.out.println("Your OS Architecture -> " + System.getProperty("os.arch"));
        System.out.println(transform("export const a=1;"));
    }*/
}
