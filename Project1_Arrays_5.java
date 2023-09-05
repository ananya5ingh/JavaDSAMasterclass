// Project - how many days above avg temp project

import java.util.Scanner;

class Operations {

    int[] arr1 = null;

    public void askForTemp(int noOfDays) {

        Scanner input2 = new Scanner(System.in);

        arr1 = new int[noOfDays];

        for (int i = 0; i < noOfDays; i++) {

            System.out.printf("Day %d's high temp: ", i + 1);
            arr1[i] = input2.nextInt();
        }
        input2.close();
    }

    public float calculateAverage() {

        int sum = 0;

        for (int i = 0; i < arr1.length; i++) {
            sum += arr1[i];
        }

        int average = sum / arr1.length;

        return average;
    }

    public void daysAboveAvg(float average) {

        int count = 0;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] > average) {
                count++;
            }
        }
        System.out.println(count + " day(s) above average");
    }

}

public class Project1_Arrays_5 {

    public static void main(String[] args) {

        Scanner input1 = new Scanner(System.in);

        System.out.print("How many days' temperatures? ");
        int noOfDays = input1.nextInt();

        Operations obj = new Operations();

        obj.askForTemp(noOfDays);

        float average = obj.calculateAverage();
        System.out.println();
        System.out.println("Average: " + average);

        obj.daysAboveAvg(average);

        input1.close();

    }
}
