/**
 * Homework 7
 * Nathan Bingham
 * 2015-03-27
 */

import java.util.Random;
import java.util.Scanner;

/**
 * Write a program to add random numbers chosen from [0,1] until the first time the sum is greater than one.
 * Have your program repeat this experiment a number of times to estimate the expected number of selections
 * necessary in order that the sum of the chosen numbers first exceeds 1. On the basis of your experiments,
 * what is your estimate for this number?
 */

public class randomAdder
{
    public static void main(String[] args)
    {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        double total;
        double nextDouble;
        double average = 0;
        int count = 0;
        int[] histogram = new int[10];

        System.out.printf("Input times to run experiment: ");
        int input = scanner.nextInt();

        for (int i = input; i > 0; i--)
        {
            total = 0;

            while (total <= 1)
            {
                nextDouble = random.nextDouble() * (1 + Double.MIN_VALUE); // 1 + Double.MIN_VALUE ensures 1 is included.
                histogram[(int)Math.ceil(nextDouble * 10)-1]++;
                total += nextDouble;
                count++;
            }

            average++;
        }

        average = count / average;

        System.out.printf("Average random variables before sum exceeds 1: %f\n\n",average);

        for (int i = 0; i < histogram.length; i++)
        {
            System.out.printf("~0.%d: ", i);
            for (int j = 0; j < histogram[i]; j++)
            {
                    System.out.printf("|");
            }
            System.out.println();
        }
    }
}
