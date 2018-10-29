import java.util.Arrays;
 
public class SubArrayWhoseSumIsNumber
{
    static void findSubArray(int[] inputArray, int inputNumber)
    {
        //Initializing sum with the first element of the inputArray
 
        int sum = inputArray[0];
 
        //Initializing starting point with 0
 
        int start = 0;
 
        //Iterating through inputArray starting from second element
 
        for (int i = 1; i < inputArray.length; i++)
        {
            //Adding inputArray[i] to the current 'sum'
 
            sum = sum + inputArray[i];
 
            //If sum is greater than inputNumber then following loop is executed until
 
            //sum becomes either smaller than or equal to inputNumber
 
            while(sum > inputNumber && start <= i-1)
            {
                //Removing starting elements from the 'sum'
 
                sum = sum - inputArray[start];
 
                //Incrementing start by 1
 
                start++;
            }
 
            //If 'sum' is equal to 'inputNumber' then printing the sub array
 
            if(sum == inputNumber)
            {
                System.out.println("Continuous sub array of "+Arrays.toString(inputArray)+" whose sum is "+inputNumber+" is ");
 
                for (int j = start; j <= i; j++)
                {
                    System.out.print(inputArray[j]+" ");
                }
 
                System.out.println();
            }
        }
    }
 
    public static void main(String[] args)
    {
        findSubArray(new int[]{42, 15, 12, 8, 6, 32}, 26);
 
        findSubArray(new int[]{12, 5, 31, 13, 21, 8}, 49);
 
        findSubArray(new int[]{15, 51, 7, 81, 5, 11, 25}, 41);
    }
}
