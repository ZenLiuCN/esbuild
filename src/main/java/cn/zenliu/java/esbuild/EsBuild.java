package cn.zenliu.java.esbuild;

import jnr.ffi.LibraryLoader;
import jnr.ffi.annotations.Encoding;
import lombok.Value;
import lombok.experimental.UtilityClass;
import lombok.val;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.*;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * @author Zen.Liu
 * @since 2022-03-02
 */
public interface EsBuild {
    enum Drop {
        Default,
        Console,
        Debugger,
        ;
    }

    enum TreeShaking {
        Default,
        TreeShakingFalse,
        TreeShakingTrue,
        ;
    }

    enum Charset {
        Default,
        ASCII,
        UTF8,
        ;
    }

    enum LogLevel {
        Silent,
        Verbose,
        Debug,
        Info,
        Warning,
        Error,
        ;
    }

    enum StderrColor {
        IfTerminal,
        Never,
        Always,
        ;
    }

    enum EngineName {
        Chrome,
        Edge,
        Firefox,
        IE,
        IOS,
        Node,
        Opera,
        Safari,
        ;
    }

    enum Format {
        Default,
        IIFE,
        CommonJS,
        ESModule,
        ;
    }

    enum Platform {
        Browser,
        Node,
        Neutral,
        ;
    }

    enum Loader {
        None,
        JS,
        JSX,
        TS,
        TSX,
        JSON,
        Text,
        Base64,
        DataURL,
        File,
        Binary,
        CSS,
        Default,


        ;
    }

    enum Target {
        Default,
        ESNext,
        ES5,
        ES2015,
        ES2016,
        ES2017,
        ES2018,
        ES2019,
        ES2020,
        ES2021,
        ;
    }

    enum JSXMode {
        Transform,
        Preserve,
        ;
    }

    enum SourceMap {
        None,
        Inline,
        Linked,
        External,
        InlineAndExternal,
        ;
    }

    enum SourcesContent {
        Include,
        Exclude,
        ;
    }

    enum LegalComments {
        Default,
        None,
        Inline,
        EndOfFile,
        Linked,
        External,
        ;
    }


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

    @Value(staticConstructor = "of")
    class TransformResult {
        public String code;
        public String map;
        public String error;
        public String warn;

    }

    static TransformResult transform(String code) {
        val ss = $.instance.Transform(code);
        val error = $.instance.GetResult(ss, 0);
        val warn = $.instance.GetResult(ss, 1);
        val cc = $.instance.GetResult(ss, 2);
        val map = $.instance.GetResult(ss, 3);
        $.instance.EndSession(ss);
        return TransformResult.of(cc, map, error, warn);
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


        public interface LibGo {
            void Debugger(int v);

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

            default void transformColor(StderrColor v) {
                TransformColor(v.ordinal());
            }

            default void transformLogLimit(int v) {
                TransformLogLimit(v);
            }

            default void transformLogLevel(LogLevel v) {
                TransformLogLevel(v.ordinal());
            }

            default void transformSourceMap(SourceMap v) {
                TransformSourceMap(v.ordinal());
            }

            default void transformSourceRoot(String v) {
                TransformSourceRoot(v);
            }

            default void transformSourceContent(SourcesContent v) {
                TransformSourceContent(v.ordinal());
            }

            default void transformTarget(Target v) {
                TransformTarget(v.ordinal());
            }

            default void transformEngine(List<Map.Entry<EngineName, String>> engines) {
                TransformCleanEngine();
                engines.forEach((k) -> {
                    TransformAddEngine(k.getKey().ordinal(), k.getValue());
                });

            }

            default void transformFormat(Format v) {
                TransformFormat(v.ordinal());
            }

            default void transformMangleProps(String v) {
                TransformMangleProps(v);
            }

            default void transformGlobalName(String v) {
                TransformGlobalName(v);
            }

            default void transformMangleCache(int v) {
                TransformMangleCache(v);
            }

            default void transformDrop(Drop v) {
                TransformDrop(v.ordinal());
            }

            default void transformMinifyWhitespace(boolean v) {
                TransformMinifyWhitespace(v ? 1 : 0);
            }

            default void transformMinifyIdentifiers(boolean v) {
                TransformMinifyIdentifiers(v ? 1 : 0);
            }

            default void transformMinifySyntax(boolean v) {
                TransformMinifyIdentifiers(v ? 1 : 0);
            }

            default void transformCharset(Charset v) {
                TransformCharset(v.ordinal());
            }

            default void transformTreeShaking(TreeShaking v) {
                TransformTreeShaking(v.ordinal());
            }

            default void transformIgnoreAnnotations(boolean v) {
                TransformIgnoreAnnotations(v ? 1 : 0);
            }

            default void transformLegalComments(LegalComments v) {
                TransformLegalComments(v.ordinal());
            }

            default void transformJSXMode(JSXMode v) {
                TransformJSXMode(v.ordinal());
            }

            default void transformJSXFactory(String v) {
                TransformJSXFactory(v);
            }

            default void transformJSXFragment(String v) {
                TransformJSXFragment(v);
            }

            default void transformTsconfigRaw(String v) {
                TransformTsconfigRaw(v);
            }

            default void transformBanner(String v) {
                TransformBanner(v);
            }

            default void transformFooter(String v) {
                TransformFooter(v);
            }

            default void transformAddDefine(Map<String, String> define) {
                TransformCleanDefine();
                define.forEach(this::TransformAddDefine);
            }

            default void transformPure(List<String> v) {
                TransformCleanPure();
                v.forEach(this::TransformAddPure);
            }

            default void transformKeepNames(boolean v) {
                TransformKeepNames(v ? 1 : 0);
            }

            default void transformSourceFile(String v) {
                TransformSourceFile(v);
            }

            default void transformLoader(Loader v) {
                TransformLoader(v.ordinal());
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


            int Transform(@Encoding("UTF-8") String v);

            void EndSession(int session);

            @Encoding("UTF-8")
            String GetResult(int session, int type);
        }

        static final LibGo instance;
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
                instance = loadLibraryFromJar("/" + (IS_WINDOWS ? lib : ("esb" + "." + (IS_UNIX ? "linux" : "mac") + "." + ext)), p -> LibraryLoader.create(LibGo.class).load(p));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
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
    }
}
