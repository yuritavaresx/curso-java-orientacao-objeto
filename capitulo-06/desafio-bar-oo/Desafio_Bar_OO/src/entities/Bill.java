package entities;

public class Bill {

    public char gender;
    public int beer;
    public int barbecue;
    public int softDrink;

    public double feeding(){
        return (beer * 5.0) + (barbecue * 7.0) + (softDrink * 3.0);
    }

    public double cover(){
        if (feeding() >= 30.0){
            return 0.0;
        }
        else {
            return 4.0;
        }
    }

    public double ticket(){
        if (gender == 'F' || gender == 'f'){
            return 8.0;
        }
        else if (gender == 'M' || gender == 'm'){
            return 10.0;
        }
        else {
            return 0.0;
        }
    }

    public double total(){
        return feeding() + cover() + ticket();
    }


}
