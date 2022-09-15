package com.jijil.codility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * How many combination of seats available for family of 3 with all three can sit together . Input is already occupied seats
 * Flight layout 10 rows , with 3- 4 -3 arrangement.
 */
public class FlightSeat {

    public static void main(String[] args) {

        int solution = solution("1A 7B 9F 7J");
        System.out.println("Result ::: " + solution);
  }

    //Flight Booking
    public static int solution(String bookedSeats){
        int result = 0 ;
        int maxRowCount =  10;

        // Split the booked seats
        // TODO Check the length , array size > 0 etc
        String[] splitSeats = bookedSeats.split(" ");
        Arrays.sort(splitSeats);
        for(int length =0 ;length < splitSeats.length ; length++){
            System.out.println(splitSeats[length]);
        }

        //Make seat structure , Fill with zero for empty seat.

        List<List<List<Integer>>> rows = new ArrayList<List<List<Integer>>> ();
        for(int rowCount= 0 ; rowCount <maxRowCount ; rowCount++) {
            List leftRow = new ArrayList<Integer>();
            leftRow.add(0);
            leftRow.add(0);
            leftRow.add(0);

            List middleRow = new ArrayList<Integer>();
            middleRow.add(0);
            middleRow.add(0);
            middleRow.add(0);
            middleRow.add(0);

            List rightRow = new ArrayList<Integer>();
            rightRow.add(0);
            rightRow.add(0);
            rightRow.add(0);


            List<List<Integer>> singleRow = new ArrayList<List<Integer>>();
            singleRow.add(leftRow);
            singleRow.add(middleRow);
            singleRow.add(rightRow);

            rows.add(singleRow);
        }

        // Mark booked seats with 1 .

        for(String bookedSeat : splitSeats ) {
            int bookedRow =Integer.parseInt(bookedSeat.substring(0,1));
            char bookedColumn = bookedSeat.charAt(1);
            switch (bookedColumn) {

                case 'A'    :
                    rows.get(bookedRow).get(0).set(0,1);
                    break;
                case 'B'    :
                    rows.get(bookedRow).get(0).set(1,1);
                    break;
                case 'C'    :
                    rows.get(bookedRow).get(0).set(2,1);
                    break;

                case 'D'    :
                    rows.get(bookedRow).get(1).set(0,1);
                    break;
                case 'E'    :
                    rows.get(bookedRow).get(1).set(1,1);
                    break;
                case 'F'    :
                    rows.get(bookedRow).get(1).set(2,1);
                    break;
                case 'G'    :
                    rows.get(bookedRow).get(1).set(3,1);
                    break;

                case 'H'    :
                    rows.get(bookedRow).get(2).set(0,1);
                    break;
                case 'J'    :
                    rows.get(bookedRow).get(2).set(1,1);
                    break;
                case 'K'    :
                    rows.get(bookedRow).get(2).set(2,1);
                    break;

            }


        }


        //Predicate
        /**
         Predicate<List<Integer>> containsOne = x -> x.contains(1);

         for (int i = 0 ; i < maxRowCount ; i++ ) {

         System.out.println(rows.get(i).stream().anyMatch(containsOne));

         }

         **/




        for(List<List<Integer>> row : rows ) {
            // Increment the count of seats with left unit

            if(!row.get(0).contains(1)){
                result++;
            }


            // Increment the count of seats with right unit

            if(!row.get(2).contains(1)){
                result++;
            }

            // Increment the count of seats with middle  unit
            // x x x x
            if(!row.get(1).contains(1)){
                result++;
            }else {

                if((row.get(1).get(0) == 0 && row.get(1).get(1) == 0 && row.get(1).get(2) == 0 ) || (row.get(1).get(1) == 0 && row.get(1).get(2) == 0 && row.get(1).get(3) == 0 )) {

                    result++;
                }


            }

        }




        return result;
    }
}
