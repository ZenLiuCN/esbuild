package cn.zenliu.java.esbuild;

import lombok.Value;

/**
 * @author Zen.Liu
 * @since 2022-03-02
 */
@Value(staticConstructor = "of")
public
class TransformResult {
    public String code;
    public String map;
    public String error;
    public String warn;

}
