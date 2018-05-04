package src.Model;
import  src.Model.Cell;

public class TestCell {
    public static void main(String[] args){
        Cell test1 = new Cell(0, 1 , 5);
        Cell test2 = new Cell(1 , 1 , 4);
        Cell test3 = new Cell(1 , 1 , 5);

        boolean bool1 = test1.equalPos(test3);
        test2.setColumn(5);

        boolean bool2 = test2.equalPos(test3);

        test3.setColor(2);

        boolean bool3 =test2.equalPos(test3);

        if (!bool1 && bool2 && !bool3){
            System.out.println("TestCell is good");
        }


    }

}
