package cn.zenliu.java.esbuild;

import org.junit.jupiter.api.Test;

class EsBuildTest {
    @Test
    void testTransform() {
        System.out.println(EsBuild.Transform.reset()
                .setLoader(Loader.JS)
                .setTarget(Target.ES2015)
                .setFormat(Format.ESModule)
                .setMinifyIdentifiers(true)
                .setMinifySyntax(true)
                .setMinifyWhitespace(true)
                .setSourceMap(SourceMap.Inline)
                .transform("export const x=1"));
    }
}