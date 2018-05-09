package src.Model;

import java.util.Random;

import static java.lang.Math.random;

public class Oracle {
    int difficulty;

    public Oracle(int difficulty) {
        this.difficulty = difficulty;
    }

    // Renvoie la ligne et la colonne du prochain coup à jouer
    public int [] nextPlay(Board b ) {
        int [] nextPlay = new int[2];
        switch (difficulty) {
            case 1 : nextPlay = IARandom(b);

            //TODO
        }
        return nextPlay;
    }

    public  int[] IARandom(Board  b){
        int [] next2 = new int[2];
        boolean test = true;
        while (test ){
            next2 = rand();
            test = b.board[next2[0]][next2[1]].color!=Color.noColor;
        }
        return next2;
    }

    public int [] rand(){
        Random rand = new Random();
        int linerand = rand.nextInt(11);
        int columnrand;
        if (linerand < 7 ){
            columnrand = rand.nextInt( linerand+5);
        }
        else {
            int ter = 5 - (linerand - 6)*2;
            columnrand = rand.nextInt( linerand - ter);
        }
        int [] next = new int[2];
        next[0]= linerand;
        next[1]= columnrand;
        return  next;

    }
}
