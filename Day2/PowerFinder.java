import java.util.ArrayList;

class PowerFinder {
    String game;
    CubeCounter counter; 

    PowerFinder(String game) throws Exception { 
        this.game = game;    
        this.counter = new CubeCounter(game);
    }

    int getPower() {
        counter.countCubes();
        
        int power = getMinCubes(counter.getRedCubes());
        power *= getMinCubes(counter.getBlueCubes());
        power *= getMinCubes(counter.getGreenCubes());


        return power;
    }
    
    private int getMinCubes(ArrayList<Integer> cubeList) {
        int minCubes = 0;
        for (Integer num : cubeList) {
            if (num > minCubes) {
                minCubes = num;
            }
        }

        return minCubes;
    }
}
