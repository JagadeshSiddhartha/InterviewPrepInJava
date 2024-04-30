package LLD;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.HashMap;

import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class SnakeAndLadder {
    int[] boardArray = new int[100];
    int[][] snakePointers = null;
    int[][] ladderPointers = null;
    int snakePointersSize = 0;
    Map<String, User> userList = new HashMap<String, User>();
    int ladderPointersSize = 0;
    int currentUserIndex = 0;
    boolean multiUser = false;

    public SnakeAndLadder() {
        loadGameBoard();
    }

    public static void main(String[] args) {
        SnakeAndLadder sl = new SnakeAndLadder();

        System.out.println("Snake & Ladder Game \n User Options");
        System.out.println("1. Start Game \n2. "
                + "Sinlge Player \n3. Multi Players(only 2) \n4. Exit Game");
        System.out.print("Please provide your option : ");

        int i = 1;

        while (i != 0) {
            Scanner in = new Scanner(System.in);
            i = in.nextInt();

            switch (i) {
                case 1:
                    if (sl.userList.size() == 0) {
                        System.out.println("Please create users and play the game..");
                        break;
                    } else {
                        sl.playGame();
                    }
                    break;

                case 2:
                    sl.createSingleUser();
                    break;

                case 3:
                    sl.createMultipleUser();
                    break;

                case 4:
                    System.exit(0);
            }

            System.out.println();
            System.out.println("Snake & Ladder Game \n Select User Options");
            System.out.println("1. Start Game \n2. "
                    + "Sinlge Player \n3. Multi Players(only 2) \n4. Exit Game");
            System.out.print("Please provide your option : ");
        }
    }

    public void loadGameBoard() {
        for (int i = 0; i < 100; i++) {
            boardArray[i] = i + 1;
        }

        Properties prop = new Properties();
        try {
            prop.load(getClass().getClassLoader().getResourceAsStream("game.properties"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
        game.properties
        snake.pointers.total=4
        snake.pointers.1=98,21
        snake.pointers.2=72,34
        snake.pointers.3=57,25
        snake.pointers.4=49,17

        ladder.pointers.total=4
        ladder.pointers.1=11,28
        ladder.pointers.2=36,62
        ladder.pointers.3=24,49
        ladder.pointers.4=51,87
         */

        snakePointersSize = Integer.parseInt(prop.getProperty("snake.pointers.total"));

        ladderPointersSize = Integer.parseInt(prop.getProperty("ladder.pointers.total"));

        snakePointers = new int[snakePointersSize][2];

        ladderPointers = new int[ladderPointersSize][2];

        for (int i = 0; i < snakePointersSize; i++) {
            String[] a = prop.getProperty("snake.pointers." + (i + 1)).split(",");
            snakePointers[i][0] = Integer.parseInt(a[0]);
            snakePointers[i][1] = Integer.parseInt(a[1]);
        }

        for (int i = 0; i < ladderPointersSize; i++) {
            String[] a = prop.getProperty("ladder.pointers." + (i + 1)).split(",");
            ladderPointers[i][0] = Integer.parseInt(a[0]);
            ladderPointers[i][1] = Integer.parseInt(a[1]);
        }
    }

    public void displayGameBoard() {
        System.out.println();
        for (int i = 99; i >= 0; i--) {
            if (i == 99) {
                System.out.print("   ");
            }

            System.out.print(boardArray[i]);
            System.out.print("    ");

            if ((i) % 10 == 0) {
                int f = i - 10;
                for (int k = f; k < i; k++) {
                    if (k == f) {
                        System.out.println();
                        System.out.print("    ");
                    }
                    if (boardArray[k] / 10 == 0) {
                        System.out.print(" ");
                        System.out.print(boardArray[k]);
                    } else {
                        System.out.print(boardArray[k]);
                    }
                    System.out.print("    ");
                }
                i = f;
                System.out.println();
                System.out.print("    ");
            }
        }
        displaySLPointers();
    }

    public void displaySLPointers() {
        System.out.println();
        System.out.print("Snake Pointers  ");
        for (int i = 0; i < snakePointers.length; i++) {
            System.out.print("[" + snakePointers[i][0] + "->" + snakePointers[i][1] + "] ");
        }
        System.out.println();
        System.out.print("Ladder Pointers  ");
        for (int i = 0; i < ladderPointers.length; i++) {
            System.out.print("[" + ladderPointers[i][0] + "->" + ladderPointers[i][1] + "] ");
        }
        System.out.println();
    }

    public void createSingleUser() {
        userList.clear();
        int id = 1;
        User usr = new User(id);
        userList.put("user" + id, usr);
        System.out.println("user" + id + " created successfully");
    }

    public void createMultipleUser() {
        userList.clear();
        multiUser = true;
        for (int i = 0; i < 2; i++) {
            int id = i + 1;
            User usr = new User(id);
            userList.put("user" + id, usr);
            System.out.println("user" + id + " created successfully");
        }
    }

    public int rollDice() {
        Random rn = new Random();
        int op = rn.nextInt(5) + 1;
        System.out.println("Dice Value is...." + op);
        return op;
    }

    public void playGame() {
        int i = 0;
        System.out.println("Game Started.....  ");
        do {
            String curName = getCurrentUserName();
            System.out
                    .println("1. Roll Dice \n2. Show Positions \n3. Display Board \n4. Stop Game");
            System.out.println("Chance for User..." + curName);
            System.out.print("Please provide your option : ");

            Scanner in = new Scanner(System.in);
            i = in.nextInt();

            switch (i) {
                case 1:
                    int curPos = this.updateUserPositions(curName);
                    if (curPos >= 100) {
                        System.out
                                .println(curName + " has successfully won the game. \n Game exit");
                        return;
                    }
                    break;

                case 2:
                    this.displayUserPositions();
                    if (multiUser == true)
                        currentUserIndex = (currentUserIndex == 2) ? 1 : 0;
                    break;

                case 3:
                    this.displayGameBoard();
                    if (multiUser == true)
                        currentUserIndex = (currentUserIndex == 2) ? 1 : 0;
                    break;

                case 4:
                    return;
            }
            System.out.println();
        } while (i != 0);
    }

    public int updateUserPositions(String name) {
        Set keyset = userList.keySet();
        if (keyset.contains(name)) {
            User ur = userList.get(name);
            ur.setCurrentPosition(checkSLPointersForCurPos(ur.getCurrentPosition()
                    + this.rollDice()));

            System.out.println(name + " current position is " + ur.getCurrentPosition());
            return ur.getCurrentPosition();
        }
        return 0;
    }

    public void displayUserPositions() {
        Set keyset = userList.keySet();
        Iterator it = keyset.iterator();
        while (it.hasNext()) {
            String key = (String) it.next();
            User us = userList.get(key);
            System.out.println(key + "current position is...." + us.getCurrentPosition());
        }
    }

    public String getCurrentUserName() {
        if (currentUserIndex == 0) {
            currentUserIndex++;
            return "user" + (currentUserIndex);
        } else if (currentUserIndex == 1) {
            if (multiUser == false)
                return "user" + currentUserIndex;
            else
                currentUserIndex++;
            return "user" + currentUserIndex;
        } else {
            currentUserIndex--;
            return "user" + (currentUserIndex);
        }
    }

    public int checkSLPointersForCurPos(int curPos) {
        for (int i = 0; i < snakePointers.length; i++) {
            if (snakePointers[i][0] == curPos) {
                System.out.println("OOPs!! you have been dropped down by Snake...");
                return snakePointers[i][1];
            }
        }

        for (int i = 0; i < ladderPointers.length; i++) {
            if (ladderPointers[i][0] == curPos) {
                System.out.println("Wow!! you have climbed up the ladder...");
                return ladderPointers[i][1];
            }
        }
        return curPos;
    }
}

class User {

    int id;

    int currentPosition = 0;

    public User(int uId) {
        id = uId;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }
}