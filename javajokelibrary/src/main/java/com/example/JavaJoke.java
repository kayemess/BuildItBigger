package com.example;



public class JavaJoke {

    public int NUMBER_OF_JOKES = 9;
    String joke;

    public String getJoke() {
        return this.getJoke(3);
    }

    public String getJoke(int randomInt){
        // Jokes from: http://www.ducksters.com/jokes/silly.php
        switch (randomInt){
            case 0:
                joke = "Q: What goes up and down but does not move? \nA: Stairs.";
                break;
            case 1:
                joke = "Q: Where should a 500 pound alien go? \nA: On a diet.";
                break;
            case 2:
                joke = "Q: What did one toilet say to the other? \nA: You look a bit flushed.";
                break;
            case 3:
                joke = "Q: Why did the picture go to jail? \nA: Because it was framed.";
                break;
            case 4:
                joke = "Q: What did one wall say to the other wall? \nA: I'll meet you at the corner.";
                break;
            case 5:
                joke = "Q: What do you call a boy named Lee that no one talks to? \nA: Lonely";
                break;
            case 6:
                joke = "Q: What gets wetter the more it dries? \nA: A towel.";
                break;
            case 7:
                joke = "Q: Why do bicycles fall over? \nA: Because they are two-tired!";
                break;
            case 8:
                joke = "Q: Why do dragons sleep during the day? \nA: So they can fight knights!";
                break;
            case 9:
                joke = "Q: What did Cinderella say when her photos did not show up? \nA: Someday my prints will come!";
                break;
            default:
                joke = "Q: What did the paper say to the pencil? \nA: Write on!";
                break;
        }

        return joke;
    }
}


