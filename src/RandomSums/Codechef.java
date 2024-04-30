package RandomSums;

import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    public static void main (String[] args) throws java.lang.Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        String[] slabString = sc.nextLine().split(" ");
        int slabs[] = new int[slabString.length];
        int n = slabString.length;
        for(int i = 0; i < slabString.length; i++)
            slabs[i] = Integer.parseInt(slabString[i]);

        String[] taxString = br.readLine().split(" ");
        int taxes[] = new int[taxString.length];
        for(int i = 0; i < taxString.length; i++)
            taxes[i] = Integer.parseInt(taxString[i]);

        int rebate = Integer.parseInt(br.readLine());

        String[] employeeTaxString = br.readLine().split(" ");
        int employeeTaxes[] = new int[employeeTaxString.length];
        for(int i = 0; i < employeeTaxString.length; i++)
            employeeTaxes[i] = Integer.parseInt(employeeTaxString[i]);



        int totalSal = 0;

        for(int i = 0; i < employeeTaxes.length; i++){
            int curEmpSal = 0;
            totalSal += slabs[0] + rebate;
            int tempTax = employeeTaxes[i];
            if(tempTax == 0){
                continue;
            }

            int j = 0;
            while(j < n - 1){
                // System.out.println("curret emp " + curEmpSal);
                int presentTax = (taxes[j] * (slabs[j+1] - slabs[j]))/100;
                if(tempTax >= presentTax ){
                    tempTax -= presentTax;
                    curEmpSal += slabs[j+1] - slabs[j];
                    //  System.out.println(i + "   " + "presentTax :" + presentTax + "  tempTax : " + tempTax);
                }
                else{
                    tempTax = 0;
                    curEmpSal +=  (tempTax * 100) / taxes[j];
                    // System.out.println(i + "   " + "presentTax :" + presentTax + "  tempTax : " + tempTax);
                    break;
                }
                j++;
            }

            if(tempTax > 0){
                curEmpSal += (tempTax * 100) / taxes[j];
            }
            // System.out.println(curEmpSal);
            totalSal += curEmpSal;
        }

        System.out.println(totalSal);

    }
}


