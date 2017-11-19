import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FindingNumbersDemo {
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        int testCaseCount = Integer.parseInt(scanner.nextLine());
        while(testCaseCount > 0) {
            FindingNumbers findingNumbers = new FindingNumbers();
            findingNumbers.setArraySize(2 * Integer.parseInt(scanner.nextLine()) + 2);
            findingNumbers.setArray(Arrays.copyOfRange(scanner.nextLine().split(" "), 0, findingNumbers.getArraySize()));
            List<Integer> distinct = findingNumbers.getDistinctElements();
            for(int element : distinct)
                System.out.print(element + " ");
            System.out.println();
            --testCaseCount;
        }
    }
}

class FindingNumbers {
    private int arraySize;
    private List<Integer> array = new ArrayList<Integer>();
    
    public int getArraySize() {
        return arraySize;
    }
    
    public void setArraySize(int arraySize) {
        this.arraySize = arraySize;
    }
    
    public List<Integer> getArray() {
        return array;
    }
    
    public void setArray(String[] array) {
        for(String element : array) {
            this.array.add(Integer.parseInt(element));
        }
    }
    
    //Returns non-repeated elements in sorted order
    public List<Integer> getDistinctElements() {
        List<Integer> distinct = new ArrayList<Integer>();
        
        for(int element : array) {
            if(Collections.frequency(array, element) == 1)
                distinct.add(element);
        }
        
        Collections.sort(distinct);
        return distinct;
    }
}
