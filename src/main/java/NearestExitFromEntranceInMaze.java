import java.util.*;

public class NearestExitFromEntranceInMaze {
    public int nearestExit(char[][] maze, int[] entrance) {
        Set<Coord> visited = new HashSet<Coord>();
        Deque<Coord> paths = new ArrayDeque<>();
        Coord entra = new Coord(entrance[0], entrance[1], 0);
        paths.add(entra);

        while(!paths.isEmpty()) {
            Coord current = paths.pollFirst();

            if (current.x != entrance[1] || current.y != entrance[0]) {
                if (maze[current.y][current.x] == '.') {
                    if (current.x == 0)
                        return current.steps;

                    if (current.x == maze[0].length - 1)
                        return current.steps;

                    if (current.y == 0)
                        return current.steps;

                    if (current.y == maze.length - 1)
                        return current.steps;
                }
            }

            //add paths from current possition
            //Move "UP"
            if(current.y - 1 >= 0 && maze[current.y-1][current.x] != '+'){
                //set as zero the step to be able to
                Coord coord = new Coord( current.y-1, current.x, 0);
                if(!visited.contains(coord)){
                    visited.add(coord);
                    paths.add(new Coord(coord.y, coord.x, current.steps+1));
                }
            }
            //Move "DOWN"
            if(current.y + 1 < maze.length && maze[current.y+1][current.x] != '+'){
                //set as zero the step to be able to
                Coord coord = new Coord(current.y+1, current.x, 0);
                if(!visited.contains(coord)){
                    visited.add(coord);
                    paths.add(new Coord(coord.y, coord.x, current.steps+1));
                }
            }

            //Move "Left"
            if(current.x -1 >= 0 && maze[current.y][current.x-1] != '+'){
                //set as zero the step to be able to
                Coord coord = new Coord(current.y, current.x-1, 0);
                if(!visited.contains(coord)){
                    visited.add(coord);
                    paths.add(new Coord(coord.y, coord.x, current.steps+1));
                }
            }

            //Move "right"
            if(current.x +1 < maze[0].length && maze[current.y][current.x+1] != '+'){
                //set as zero the step to be able to
                Coord coord = new Coord(current.y, current.x+1, 0);
                if(!visited.contains(coord)){
                    visited.add(coord);
                    paths.add(new Coord(coord.y, coord.x, current.steps+1));
                }
            }

        }
        return -1;
    }
}

class Coord {
    int y=0;
    int x=0;
    int steps=0;
    public Coord(int y, int x, int steps) {
        this.y = y;
        this.x = x;
        this.steps = steps;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coord coord = (Coord) o;
        return y == coord.y && x == coord.x && steps == coord.steps;
    }

    @Override
    public int hashCode() {
        return Objects.hash(y, x, steps);
    }
}
