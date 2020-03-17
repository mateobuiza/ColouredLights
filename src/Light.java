public class Light{

    private int position;
    private String colour;
    private boolean state;

    public Light(int position, String colour){
        this.position = position;
        this.colour = colour;
        this.state = true;
    }

    public boolean getState() {
        return state;
    }

    public void changeState(){
        if(state){
            state = false;
        }else{
            state = true;
        }
    }

    @Override
    public String toString(){
        String stateWords;
        if(state){
            stateWords = "On";
        }else{
            stateWords = "Off";
        }

        return position + " " + colour + " Light " + stateWords;
    }


    public String getColour() {
        return colour;
    }

    public int getPosition() {
        return position;
    }
}