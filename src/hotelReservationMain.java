import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class hotelReservationMain {

//    static class hotel{
//        String name;
//        int rating;
//        int weekdayRegulaRate;
//        int weekdayRewardRate;
//        int weekendRegularRate;
//        int weekendRewardRate;
//
//        public hotel(String name, int rating,int weekdayRegulaRate, int weekdayRewardRate, int weekendRegularRate, int weekendRewardRate) {
//              this.name = name;
//              this.rating = rating;
//              this.weekdayRegulaRate = weekdayRegulaRate;
//              this.weekdayRewardRate = weekdayRewardRate;
//              this.weekendRegularRate = weekendRegularRate;
//              this.weekendRewardRate = weekendRewardRate;
//
//        }
//
//        public int calculateTotalRate(boolean isRewardCustomer, LocalDate startDate, LocalDate endDate){
//          int totalrate=0;
//          LocalDate  date=startDate;
//          while(!date.isAfter(endDate)){
//                  DayOfWeek date1= date.getDayOfWeek();
//              if(date1 == DayOfWeek.SATURDAY || date1 ==  DayOfWeek.SUNDAY){
//                    totalrate  += isRewardCustomer ? weekendRewardRate : weekendRegularRate;
//
//              }else{
//                  totalrate += isRewardCustomer ? weekdayRewardRate : weekdayRegulaRate;
//              }
//              date = date.plusDays(1);
//          }
//          return totalrate;
//        }
//    }

    public static void main(String[] args) {
        List<hotel> hotels = Arrays.asList(
                new hotel("lakewood",3,110,80,90,80),
                new hotel("bridgewood",4,160,110,60,50),
                new hotel("ridgewood",5,220,100,150,40));

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the startdate : ");
        LocalDate startDate = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        System.out.println("Enter the enddate : ");
        LocalDate endDate = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        System.out.println("Enter the customer-type:");
        String customerType = sc.nextLine();


        hotel cheapesthotel = hotels.stream().min(Comparator.comparing(Hotel -> Hotel.calculateTotalRate(customerType.equals("rewards"),startDate,endDate))).orElse(null);

        if (cheapesthotel != null){
            System.out.println("cheapesthotel :"+cheapesthotel.name);
        }else {
            System.out.println("no hotels found");
        }


    }
}

//    A hotel chain operating in Miami wishes to offer room reservation services over the internet. They
//        have three hotels in Miami: Lakewood, Bridgewood and Ridgewood. Each hotel has separate
//        weekday and weekend (Saturday and Sunday) rates. There are special rates for rewards customer
//        as a part of loyalty program. Each hotel has a rating assigned to it.
//        Lakewood with a rating of 3 has weekday rates as 110$ for regular customer and 80$ for rewards
//        customer. The weekend rates are 90 for regular customer and 80 for a rewards customer.
//        Bridgewood with a rating of 4 has weekday rates as 160$ for regular customer and 110$ for
//        rewards customer. The weekend rates are 60 for regular customer and 50 for a rewards customer.
//        Ridgewood with a rating of 5 has weekday rates as 220$ for regular customer and 100$ for rewards
//        customer. The weekend rates are 150 for regular customer and 40 for a rewards customer.
//        Can you write a program to help an online customer find the cheapest hotel?