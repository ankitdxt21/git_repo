package com.prac.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompareXml {

	public static void main(String[] args) throws IOException {
		
		// Custom example where we are comparing two boot.ini files based on some parameters
		
		List<String> list = compareXmlLineByLine(new File("local"), new File("dnld"));
		list.forEach(s->System.out.println(s));

	}

	private static List<String> compareXmlLineByLine(File localPath, File downloadPath) throws IOException {

		try (Stream<String> localPathStream = Files.lines(Paths.get(localPath.getPath()));
				Stream<String> dnldPathStream = Files.lines(Paths.get(downloadPath.getPath()))) {
			List<String> localPathList = localPathStream.collect(Collectors.toList());
			List<String> dnldPathList = dnldPathStream.collect(Collectors.toList());
			return dnldPathList.stream().filter(s -> !localPathList.contains(s))
					.filter(s -> s.contains("<name>") && s.contains("</name>") && s.contains(".jar"))
					.map(s -> s.trim().substring(6, patternMatch(s.trim()))).collect(Collectors.toList());

		}

	}

	private static int patternMatch(String jar) {

		Matcher m = Pattern.compile("(_)|(-)|.jar").matcher(jar);
		if (m.find()) {
			return m.start();
		}
		return jar.length();

	}

}
