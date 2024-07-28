////////////////////////////////////////////////////////
//   Kush Gandhi 
//   z1968933
//   CSCI 470-PE1 
//   
//  I certify that this is my own work and where appropriate an extension 
//  of the starter code provided for the assignment. 
////////////////////////////////////////////////////////

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class MazeApp
{
    public static void main(String[] args) 
    {
        System.out.println("Welcome to Maze Solver!\n");   
        Scanner input = new Scanner(System.in);
        System.out.print("Enter file name: ");
        String fileName = input.nextLine();
        System.out.println("\nThe Original Maze:\n");
        
        try 
        {
            ArrayList<String> mazeLines = new ArrayList<>();
            File file = new File(fileName);
            Scanner fileScanner = new Scanner(file);
            
            do
            {
                //add the maze lines data into the array list from reading in the file
                mazeLines.add(fileScanner.nextLine());
                
            } while(fileScanner.hasNextLine());
            
            //gets the size and row of col
            int row = mazeLines.size();
            int col = mazeLines.get(0).length();
            
            //then initialize the maze to proper deminsions
            char[][] maze = new char[row][col];
            
            //fills the maze with the data read from array list
            for (int i = 0; i < row; i++)
            {
                String mazeLine = mazeLines.get(i);
                for (int j = 0; j < col; j++)
                {
                    maze[i][j] = mazeLine.charAt(j);
                }
            }
            
            //create the maze object and get initial points in the maze
            Maze m = new Maze(maze, 0, 0, 0, 0);
            m.getStartAndEnd();
            m.printMaze();

            //print message if solvable or not
            if (m.mazeSolver(m.startRow, m.startColumn)) 
            {
                System.out.println("\nThe Solved Maze:\n");
                m.printMaze();
                System.out.println("\nThis maze was solvable!");
            } 
            else 
            {
                System.out.println("\nThe Unsolved Maze:\n");
                m.printMaze();
                System.out.println("\nNo solution for this maze.");
            }

        } 
        catch (FileNotFoundException e) 
        {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}