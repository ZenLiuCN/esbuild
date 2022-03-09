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
      instanceStyle();
   }

   static void instanceStyle() {
      TransformResult result = EsBuild.Transform.reset()
              .setLoader(Loader.JS)
              .setTarget(Target.ES2015)
              .setFormat(Format.ESModule)
              .setMinifyIdentifiers(true)
              .setMinifySyntax(true)
              .setMinifyWhitespace(true)
              .setSourceMap(SourceMap.Inline)
              .transform("export const x=1");
      System.out.println(result);
   }
}
```

# NOTE

1. this hasn't been well tested. use on your own risks.
2. current use global transform options, that means every configuration change immediately effect for later `transform`
   execution.
3. There use code from [native-utils](https://github.com/adamheinrich/native-utils) and do small modification for fetch
   native library from Jar.

# LICENSE

Apache 2.0 