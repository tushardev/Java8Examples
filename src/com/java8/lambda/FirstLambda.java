package com.java8.lambda;

import java.io.File;
import java.io.FileFilter;

public class FirstLambda {
	
	public static void main(String[] args) {
		
		
		/* Get the files without Lambda */
		FileFilter fileFilter = new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				return pathname.getName().endsWith(".docx");
			}	
		};
		
		File dir = new File("H:\\E Drive\\Resumes\\Resume 2018");
		
		File[] files = dir.listFiles(fileFilter);
		
		for (File file : files) {
			System.out.println(file.getName());
			System.out.println(file.getAbsolutePath());
		}
		
		
		
		
		/* Get the files with Lambda */
		FileFilter fileFilterLambda = (File pathname) -> pathname.getName().endsWith(".docx");
		
		File dirLambda = new File("H:\\E Drive\\Resumes\\Resume 2018");
		
		File[] filesLambda = dirLambda.listFiles(fileFilterLambda);
		
		for (File file : filesLambda) {
			System.out.println(file.getName());
			System.out.println(file.getAbsolutePath());
		}
		
		
		
	}
}


/*** For writing lambda 
1.Write argument passed
2.Write hyphen and greater than arrow
3.Write execution code
In this example we have only one argument and one line of code for execution.
We will have multiple arguments and multiple lines of code execution.
 * 
 */
