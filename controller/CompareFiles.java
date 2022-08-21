package controller;

import java.lang.Object;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
// import org.apache.commons.io.FileUtils;
import java.io.IOException;

// class CompareFiles{
//     private static boolean isEquals(File file1, File file2){
//         try {
//             return FileUtils.contentEquals(file1, file2);
//         } catch (Exception e) {
//             e.printStackTrace();
//             return false;
//         }
//     }

//     public static void main(String[] args)
// 	{
// 		File file1 = new File("./file1.txt");
// 		File file2 = new File("./file2.txt");

// 		boolean equal = isEquals(file1, file2);
// 		if (equal) {
// 			System.out.println("Files are equal.");
// 		}
// 		else {
// 			System.out.println("Files are not equal.");
// 		}
// 	}
// }

class CompareFiles{
    public static void main(String[] args) throws IOException
	{
		File file1 = new File("./file1.txt");
		File file2 = new File("./file2.txt");

		boolean equal = isEquals(file1, file2);
		if (equal) {
			System.out.println("Files are equal.");
		}
		else {
			System.out.println("Files are not equal.");
		}
}

    private static boolean isEquals(File file1, File file2) throws IOException { 
        try (BufferedInputStream inp1 = new BufferedInputStream(new FileInputStream(file1));
        BufferedInputStream inp2 = new BufferedInputStream(new FileInputStream(file2))){
            
        int c = 0;
        int position = 1;
        
        while ((c = inp1.read()) != -1) {
            if (c != inp2.read()) {
                return false;
            }
            position++;
        }
        if (inp2.read() == -1) {
            return true;
        }
        else {
            return false;
        }
    }
}

}