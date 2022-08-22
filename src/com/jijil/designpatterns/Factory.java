package com.jijil.designpatterns;

/*

Factory method is a creational design pattern which solves the problem of creating product objects without specifying their concrete classes.
The Factory Method defines a method, which should be used for creating objects instead of using a direct constructor call (new operator).
Subclasses can override this method to change the class of objects that will be created.


//Lets create a Factory METHOD design pattern instead of Factory pattern which serve for simple purpose

 */

public class Factory {
}


// Client Class

class JerseyClient {

    public static void main(String[] args) {

        JerseyShop soccerJerseyShop = new SoccerJerseyShop();
        soccerJerseyShop.orderJersey(JerseyType.MENS_JERSEY ," Cristiano" , 07 ) ;

        JerseyShop basketBallJerseyShop = new BasketBallJerseyShop();
        basketBallJerseyShop.orderJersey(JerseyType.WOMEN_JERSEY ,"Emma" , 01);



    }



}

enum JerseyType {

    MENS_JERSEY ,
    WOMEN_JERSEY,
    KIDS_JERSEY


}

// Product Interface

abstract class JerseyShop {

    public Jersey orderJersey(JerseyType jerseyType , String jerseyName , int jerseyNo){
        // Concrete method in the Product
        System.out.println("Ordering jersey");
       Jersey jersey =createJersey(jerseyType);
       jersey.makeJersey();
       jersey.printJerseyNameNo(jerseyName,jerseyNo);
       jersey.packJersey();
        return  jersey;
    }

    //Abstract method
    public abstract Jersey createJersey(JerseyType jerseyType) ;

}


// Product Impl 1

class SoccerJerseyShop extends JerseyShop {


    @Override
    public Jersey createJersey(JerseyType jerseyType) {
        Jersey jersey = null;
        if(jerseyType == null )
            return null;
        switch (jerseyType) {
            case MENS_JERSEY -> jersey = new SoccerMenJersey();
            /** case WOMEN_JERSEY -> jersey = new SoccerWomenJersey();
               case KIDS_JERSEY -> jersey = new SoccerKidsJersey();
             */
        }


        return jersey;
    }
}


// Product Impl 2

class BasketBallJerseyShop extends JerseyShop{

    Jersey jersey;

    @Override
    public Jersey createJersey(JerseyType jerseyType) {
        if(jerseyType == null ) return  null;
        switch (jerseyType){
            case WOMEN_JERSEY -> jersey = new BasketballWomenJersey();
            /*case MENS_JERSEY -> new BasketballMenJersey();
            case KIDS_JERSEY -> new BasketballKidJersey();*/
        }

        return  jersey;
    }
}


// Creator Interface

//Interface or Abstract Class
abstract class Jersey {

    public String jerseyName;
    private Integer jerseyNo;
    private String jerseySize;


    public abstract  void makeJersey();
    public abstract void printJerseyNameNo(String jerseyName , int jerseyNo);
    public abstract void packJersey();

}

// Creator Impl

class SoccerMenJersey extends   Jersey{



   public  SoccerMenJersey(){

        System.out.println("Creating  Soccer Jersey");
    }


    @Override
    public void makeJersey() {
        System.out.println("Making  jersey");
    }

    @Override
    public void printJerseyNameNo(String jerseyName , int jerseyNo) {
        System.out.println("Print Soccer Jersey with  Name :" +  jerseyName + " and No :" +jerseyNo);
    }

    @Override
    public void packJersey() {
        System.out.println("Pack Jersey");
    }
}

class BasketballWomenJersey extends Jersey {


    public BasketballWomenJersey(){
        System.out.println("Creating Basketball Jersey");
    }

    @Override
    public void makeJersey() {
        System.out.println("Making jersey");
    }

    @Override
    public void printJerseyNameNo(String jerseyName, int jerseyNo) {
        System.out.println("Print Basketball Jersey with  Name :" +  jerseyName + " and No :" +jerseyNo);

    }

    @Override
    public void packJersey() {

        System.out.println("Pack the jersey");

    }
}