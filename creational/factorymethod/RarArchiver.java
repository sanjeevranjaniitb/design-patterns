package creational.factorymethod;

import java.io.File;

import org.apache.commons.lang3.SerializationUtils;

public class RarArchiver implements Archiver {

	@Override
	public void archive(File directory) {
		System.out.println("Rar archiver");
	}
	
}
