package cn.zenliu.java.esbuild;

import lombok.Value;

import java.util.Map;

/**
 * @author Zen.Liu
 * @since 2022-03-05
 */
@Value(staticConstructor = "of")
public class BuildResult {
        public Map<String, String> outputFile;
        public String meta;
        public String error;
        public String warn;

}
