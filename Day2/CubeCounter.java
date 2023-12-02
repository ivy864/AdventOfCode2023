import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

class CubeCounter {
    int RED_BAG_CUBES = 12;
    int GREEN_BAG_CUBES = 13;
    int BLUE_BAG_CUBES = 14;

    ArrayList<Integer> redCubes, greenCubes, blueCubes;

    String game;
    int gameNumber;
    

    CubeCounter (String game) throws Exception {
        this.init();
        this.game = game;

        Pattern p = Pattern.compile("Game (\\d+):[a-z\\d ,;]+");
        Matcher m = p.matcher(game);

        if (m.matches()) {
            gameNumber = Integer.parseInt(m.group(1));
        }
        else {
            throw new Exception("invalid line '" + game + "'.");
        }
    }

    private void init() {
        this.redCubes = new ArrayList<Integer>();
        this.greenCubes = new ArrayList<Integer>();
        this.blueCubes = new ArrayList<Integer>();
    }

    void countCubes() {
        this.game = game.split(": ")[1];
        String[] gameSets = game.split("; ");
        for (int i = 0; i < gameSets.length; i++) {

            String[] setParts = gameSets[i].split(", ");
            this.initCount();

            for (int j = 0; j < setParts.length; j++) {
                String[] parts = setParts[j].split(" ");

                if (parts[1].equals("red")) {
                    redCubes.set(i, redCubes.get(i) + 
                        Integer.parseInt(parts[0]));
                }
                else if (parts[1].equals("blue")) {
                    blueCubes.set(i, blueCubes.get(i) + 
                        Integer.parseInt(parts[0]));
                }
                else if (parts[1].equals("green")) {
                    greenCubes.set(i, greenCubes.get(i) + 
                        Integer.parseInt(parts[0]));
                }    
            }
            
        }
    }

    private void initCount() {
        this.redCubes.add(0);
        this.greenCubes.add(0);
        this.blueCubes.add(0);
    }

    int isGamePossible() {
        this.countCubes();
        System.out.println("Game " + this.gameNumber + ": " + 
            this.greenCubes + " green, " + this.blueCubes + " blue, " + this.redCubes + " red.");

        for (int i = 0; i < redCubes.size(); i++) {
            if (this.greenCubes.get(i) > GREEN_BAG_CUBES) {
                return 0; 
            }
            else if (this.blueCubes.get(i) > BLUE_BAG_CUBES) {
                return 0;
            }
            else if (this.redCubes.get(i) > RED_BAG_CUBES) {
                return 0;
            }    
        }

        return this.gameNumber;
    }
}
