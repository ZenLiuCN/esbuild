# EsBuild

the java wrapper for EsBuild using JNR-FFI

# compile

1. install golang 1.17+ with go module111 enabled
2. `/src/go/build.sh` to compile all native libraries
3. using maven to pack the jar

# usage

```java
package main;

import cn.zenliu.java.esbuild.*;

public class Main {
    public static void main(String[] args) {
        utilStyle();
        instanceStyle();
    }

    static void utilStyle() {
        EsBuild.transformMinifyIdentifiers(true);
        EsBuild.transformMinifySyntax(true);
        EsBuild.transformMinifyWhitespace(true);
        EsBuild.transformLoader(Loader.TS);
        EsBuild.transformTarget(Target.ES2015);
        EsBuild.transformFormat(Format.ESModule);
        TransformResult result = EsBuild.transform("export const a=1;");
        System.out.println(result);
    }

    static void instanceStyle() {
        TransformResult result = EsBuild.instance()
                .transformMinifyIdentifiers(true)
                .transformMinifySyntax(true)
                .transformMinifyWhitespace(true)
                .transformLoader(Loader.TS)
                .transformTarget(Target.ES2015)
                .transformFormat(Format.ESModule)
                .transform("export const a=1;");
        System.out.println(result);
    }
}
```

# NOTE

this hasn't been well tested. use on your own risks.