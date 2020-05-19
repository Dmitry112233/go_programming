package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ArrayMergeUtil;
import utils.FileUtil;

import java.util.List;

public class ArrayMergeTest {

    private String arrayOneName = "arrayOne";
    private String arraySecondName = "arraySecond";

    @Test(dataProvider = "arrays")
    public void arrayMergeTest(String arrayOne, String arraySecond, String arrayExpected){

        System.out.println("_________________________Test_______________________________");

        FileUtil fileUtil = new FileUtil();
        ArrayMergeUtil arrayMergeUtil = new ArrayMergeUtil();

        fileUtil.writeArray(arrayOne, arrayOneName);
        fileUtil.writeArray(arraySecond, arraySecondName);

        List arr1 = fileUtil.readArray(arrayOneName);
        List arr2 = fileUtil.readArray(arraySecondName);

        List mergedArray = arrayMergeUtil.mergeArrays(arr1, arr2);
        arrayMergeUtil.printArray(mergedArray);

        Assert.assertEquals(mergedArray, arrayMergeUtil.generateExpectedArray(arrayExpected));
    }


    @DataProvider(name = "arrays")
    public Object[][] getComponents() {
        return new Object[][]{
                {"1 3 5", "2 4 6", "1 2 3 4 5 6"},
                {"1 f 5", "2 4 6", "1 2 4 5 6"},
                {"1.1 3 5", "2 4 6", "2 3 4 5 6"},
                {"1 3 5", "2 4,3 6", "1 2 3 5 6"},
                {"1 % 5", "2 4 6", "1 2 4 5 6"},
                {" 1  3 5", "2    4 6   ", "1 2 3 4 5 6"},
                {"1 3 5", "2 4 6 2147483647 -2147483648", "-2147483648 1 2 3 4 5 6 2147483647"},
                {"1 3 5", "2 4 6 2147483648", "1 2 3 4 5 6"},
                {"1 3 5", "2 4 6 -2147483649", "1 2 3 4 5 6"},
                {"1,3,5", "2,4,6", ""},
                {"", "", ""}
        };
    }
}
