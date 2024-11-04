package behavioral.strategy;

import java.io.File;
import java.util.List;

//Strategy Interface
@FunctionalInterface
public interface CompressionStrategy {
	void compressFiles(List<File> files);
}
