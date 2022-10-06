import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BubbleSort {

public static void writeArrayToFile(int array [], String filename) {
    try {
        FileWriter fileWriter = new FileWriter(filename);
        for (int a: array){
            fileWriter.write(a + "\n");
        }
        fileWriter.close();
    } catch (IOException e) {
        System.out.println("Encountered an IOException");
        e.printStackTrace();
    }
}

public static int [] readFileToArray(String filename) {
    File file = new File(filename);
    try {
    Scanner scnr = new Scanner(file);
    ArrayList<Integer> arrayList = new ArrayList<>();
    while (scnr.hasNextLine()){
        String str = scnr.nextLine();
        int a = Integer.parseInt(str);
        arrayList.add(a);
    }
    int array [] = new int[arrayList.size()];
    for (int i = 0; i < arrayList.size(); i++){
        array[i] = arrayList.get(i);
    }
    scnr.close();
    return array;
} catch (FileNotFoundException e){
    e.printStackTrace();
}
return null;
}


public static int[] createRandomArray(int arrayLength) {
    int array [] = new int[arrayLength];
    Random rand = new Random();
        for (int i = 0; i < arrayLength; i++){
            array[i] = rand.nextInt(101);
        }
        return array;
}


public static void printArray(int array []) {
    for (int a: array){
        System.out.print(a + " ");
    }
    System.out.println();
}


public static void bubbleSort(int array[]) {
    for (int i = array.length - 1; i > 0; i--){
        for (int j = 0; j < i; j++){
            if (array[j] > array[j+1]){
                int temp = array[j];
                array[j] = array[j+1];
                array[j+1] = temp;
            }
        }
        printArray(array);
    }
}


    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input a filename: ");
        String filename = scanner.next();
        int array [] = readFileToArray(filename);
        bubbleSort(array);
        writeArrayToFile(array, filename);
        scanner.close();
    }
}