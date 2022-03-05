package cn.zenliu.java.esbuild;

import org.junit.jupiter.api.Test;

class EsBuildTest {
    @Test
    void testTransform() {
        System.out.println(EsBuild.TransformConfig.reset()
                .setLoader(Loader.TS)
                .setTarget(Target.ES2015)
                .transform("export const x=1"));
    }
}