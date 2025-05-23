using System;
using System.Collections.Generic;

class bubbleSort
{
    static void Main()
    List<int> list = new List<int>();
    Console.WriteLine("Enter numbers for the list (type a non-number to stop):");

    
    while(true){
        Console.writeLine("Enter a number: ")
        string input = Console.ReadLine();

        if (int.Tryparse(input, out num)){
            list.Add(num);
        } else {
            Console.WriteLine("Invalid input or non number. Shutting input");
        }
    }

    foreach (int num in list) {
        Console.WriteLine(num);
    }
    


    
}