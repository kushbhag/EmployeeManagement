/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeeproject;

/**
 *
 * @author 602497
 */
import java.util.ArrayList;

public class MyHashTable {
    // ATTRIBUTES
    // buckets is an array of ArrayList. Each item in an ArrayList is an StudentInfo
    // object.
    private ArrayList<EmployeeInfo>[] buckets;

    // CONSTRUCTOR
    public MyHashTable(int howManyBuckets) {
        // Construct the hash table (open hashing/closed addressing) as an array of
        // howManyBuckets ArrayLists.

        // Instantiate an array to have an ArrayList as each element of the array.
        buckets = new ArrayList[howManyBuckets];

        // For each element in the array, instantiate its ArrayList.
        for (int i = 0; i < howManyBuckets; i++) {
            buckets[i] = new ArrayList(); // Instantiate the ArrayList for bucket i.
        }
    }

    // METHODS
    public void addHash(EmployeeInfo student) {
        int bucket = calcBucket(student.employeeNumber);
        buckets[bucket].add(student);
    }

    public void displayHash() {
        // To display all student numbers in the Hash Table
        for (int i = 0; i < buckets.length; i++) { // Counted loop for each bucket
//
            System.out.print("Bucket #" + i + " [");

            for (int x = 0; x < buckets[i].size(); x++) { // Counted loop for each size of the bucket

                // Print the student number of each item
                System.out.print(" " + (buckets[i].get(x)).employeeNumber + " ");

            }
            System.out.println("]");
        }
    }

    public void removeHash(int eN) {
        // To remove item based on employee number
        int check = 0;
        int removeItem = calcBucket(eN);

        for (int x = 0; x < buckets[removeItem].size(); x++) {          //Counted loop for size of bucket

            if (eN == (buckets[removeItem].get(x)).employeeNumber) {   //Comparing each item in the bucket to sN

                //Remove item if sN matches remove number
                System.out.println("Item with employee number '" + eN + "' is being removed");
                buckets[removeItem].remove(x);

                //Check to know that item was removed
                check++;
            }
        }
        if (check == 0) {
            System.out.println("There was no item in the Hash Table with employee number '" + eN + "' ");
        }
    }

    public void searchHash(int eN) {
        int check = 0;
        int searchItem = calcBucket(eN);

        for (int x = 0; x < buckets[searchItem].size(); x++) {          //Counted loop for size of bucket

            if (eN == (buckets[searchItem].get(x)).employeeNumber) {   //Comparing each item in the bucket to sN

                //Remove item if sN matches remove number
                System.out.println("Item with student number '" + eN + "' is in bucket '" + searchItem + "' position #" + x);

                //Check to know that item was found
                check++;
            }
        }
        if (check == 0) {
            System.out.println("There was no item in the Hash Table with employee number '" + eN + "' ");
        }
    }

    private EmployeeInfo get(ArrayList<EmployeeInfo> arrayList) {
        // TODO Auto-generated method stub
        return null;
    }

    public EmployeeInfo giveEmp(int x){
        return buckets[0].get(x);
    }
    public int length (){
        return buckets[0].size();
    }
    
    public int calcBucket(int keyValue) {
        // Returns the bucket number as the integer keyValue modulo the number of
        // buckets for the hash table.
        return (keyValue % buckets.length);
    }
}
