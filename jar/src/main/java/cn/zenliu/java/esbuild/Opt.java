package cn.zenliu.java.esbuild;

import jnr.ffi.Runtime;
import jnr.ffi.Struct;

public class Opt extends Struct {
    public Struct.int32_t color;
    public Struct.int32_t target;

    protected Opt(Runtime runtime) {
        super(runtime);
    }
}
