//Write a Java program to turn on/off a set of coloured lights.
//The number of lights should be configurable on the command line with a default value of 20.
//The set of lights will be made up of a repeating set of colours in a fixed order (e.g red, green, white)
//When you run the program, it should turn each light in the set on for 1 second and then turn it off.
//The output of the program should be formatted as follows: {HH:MM:SS} {light no / position} {colour} Light {light state}
//12:00:01: 1 Red Light On 12:00:02: 1 Red Light Off 12:00:02: 2 Green Light On 12:00:03: 2 Green Light Off 12:00:03: 3
// White Light On 12:00:04: 3 White Light Off etc. etc.
//The sequence should continue in a loop until the program is interrupted.
//Design the program so that it would be easy to modify the colours and the number of colours that make up the set of
// lights using object oriented techniques. (e.g. blue, red, yellow, white).

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main extends TimerTask{

    private Scanner input;
    private int numOfColours;
    private Light[] colours;
    private int index = 0;

    /**
     * Gets the input from user to determine number of colours
     */
    public void inputNumOfColours() {
        input = new Scanner(System.in);
        while(colours == null) {
            System.out.println("Enter the number of colours you want: ");
            try {
                numOfColours = input.nextInt();
                colours = new Light[numOfColours];

            } catch (Exception e) {
                System.out.println("Please enter a number...");
                input.nextLine();

            }
        }

    }

    /**
     * Gets the input from user to determine the colours they wish to input
     */
    public void inputColours(){
        System.out.println("Please enter your colour(s): ");
        int count = 0;
        while(count < numOfColours){
            Light light = new Light(count + 1, input.next());
            colours[count] = light;
            count++;
        }
    }

    /**
     * Returns the list of colours
     * @return a list of Light objects
     */
    public Light[] getColoursList() {
        return colours;
    }

    /**
     * Gives output of time, position, colour and state of each Light object
     */
    @Override
    public void run(){
        // withNano(0) removes the milliseconds
        System.out.println(java.time.LocalTime.now().withNano(0) + ": " + colours[index].toString());

        if(!colours[index].getState()){

            if((numOfColours - 1) == index){
                System.out.println(java.time.LocalTime.now().withNano(0) + ": " + colours[0].toString());
                colours[index].changeState();
                index = 0;
            }else{
                System.out.println(java.time.LocalTime.now().withNano(0) + ": " + colours[index + 1].toString());
                colours[index].changeState();
                index++;
            }
        }

        colours[index].changeState();

    }


    public static void main(String[] args) {
        Main main = new Main();
        main.inputNumOfColours();
        main.inputColours();

        Timer timer = new Timer();
        timer.schedule(main, 0, 1000);

    }


}