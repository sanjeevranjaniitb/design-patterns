package creational.factorymethod;

import java.io.File;

import org.apache.commons.lang3.SerializationUtils;

public class ZipArchiver implements Archiver {

	@Override
	public void archive(File directory) {
		System.out.println("Zip Archiver");
	}
	
}
