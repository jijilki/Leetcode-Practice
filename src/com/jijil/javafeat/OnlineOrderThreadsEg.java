package com.jijil.javafeat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OnlineOrderThreadsEg {

}


class PhotoFrame {
    private  int id;
    private String material;
    private String texture;
    private String size;
    private String color;

    public PhotoFrame(int id, String material, String texture, String size, String color) {
        this.id = id;
        this.material = material;
        this.texture = texture;
        this.size = size;
        this.color = color;
    }
}


class MaintainPhotoFrame {

    Map<String, List<PhotoFrame>> availablePhotoFrames = new HashMap<>();

    //methods

    public boolean isAvailable(){

        return false;
    }


    public void buyStock(String type){


    }


    public void updateAvailabilityToBuyer(String type){


    }

    public void updateAvailabilityOnUI(String type){


    }

    public void putStock(PhotoFrame photoFrame){

    }

    

}


class InterThreadCommunication {

    public static void main(String[] args) {

        MaintainPhotoFrame maintainPhotoFrame = new MaintainPhotoFrame();

        Thread UIThread = new Thread(new Runnable() {
            @Override
            public void run() {
                String type = "cBrown-tCrack";
                maintainPhotoFrame.updateAvailabilityOnUI(type);
            }
        },"UIThread");


        Thread buyerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                String type = "cBrown-tCrack";
                maintainPhotoFrame.buyStock(type);
            }
        },"buyerThread");


        Thread selletThread = new Thread(new Runnable() {
            @Override
            public void run() {

                PhotoFrame phFrame = new PhotoFrame(101,"wood","Crack","4x6","Brown");
                maintainPhotoFrame.putStock(phFrame);

            }
        },"sellerThread");

    }

}