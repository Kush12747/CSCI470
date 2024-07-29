public class Maze 
{
    private char[][] maze;
    public int startColumn;
    public int startRow;
    private int endRow;
    private int endColumn;
    
    public Maze(char[][] maze, int startColumn, int startRow, int endColumn, int endRow) 
    {
        this.maze = maze;
        this.startColumn = startColumn;
        this.startRow = startRow;
        this.endColumn = endColumn;
        this.endRow = endRow;
    }

    // this method gets the starting and end points in the maze and sets the variables to the position of + and -
    public void getStartAndEnd() 
    {
        for (int i = 0; i < maze.length; i++) 
        {
            for (int j = 0; j < maze[i].length; j++) 
            {
                if (maze[i][j] == '+') 
                {
                    startRow = i;
                    startColumn = j;
                }
                if (maze[i][j] == '-') 
                {
                    endRow = i;
                    endColumn = j;
                }
            }
        }
    }

    //prints the original and solved maze
    public void printMaze() 
    {
        for (int i = 0; i < maze.length; i++) 
        {
            for (int j = 0; j < maze[i].length; j++) 
            {
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
    }

   //This method checks the path to solve the maze
   public boolean mazeSolver(int row, int col)
   {
       //loop through the maze
       while(true || maze[row][col] != '-')
       {
           // Check if out of bounds
           if (row < 0 || col < 0 || row > maze.length || col > maze[row].length) 
           {
               return false;
           }
           
           // Check if at endpoint
           if (row == endRow && col == endColumn)
           {
               return true;
           }
           
           // Check if the current cell is already visited
           if (maze[row][col] == '*' || maze[row][col] == 'X' || maze[row][col] == '-' || maze[row][col] == '.') 
           {
               return false;
           }
           else 
           {
        	   //place a marker on the position that has been visited
               maze[row][col] = '*';
           
                //recursivly loop by calling each direction
               if (mazeSolver(row, col + 1))
               {
                    return true;
               }
               else if (mazeSolver(row + 1, col))
               {
                   return true;
               }
               else if (mazeSolver(row, col - 1))
               {
                   return true;
               }
               else if (mazeSolver(row - 1, col)) 
               {
                   return true;
               }
               else
               {
                   //if no direction ahead then it will backtrack placing '.'
                   maze[row][col] = '.';
                   return false;
               } 
           }
        }
        return false;
    }
}
