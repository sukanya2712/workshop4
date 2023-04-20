import java.time.DayOfWeek;
import java.time.LocalDate;

public class hotel {

        String name;
        int rating;
        int weekdayRegulaRate;
        int weekdayRewardRate;
        int weekendRegularRate;
        int weekendRewardRate;

        public hotel(String name, int rating,int weekdayRegulaRate, int weekdayRewardRate, int weekendRegularRate, int weekendRewardRate) {
            this.name = name;
            this.rating = rating;
            this.weekdayRegulaRate = weekdayRegulaRate;
            this.weekdayRewardRate = weekdayRewardRate;
            this.weekendRegularRate = weekendRegularRate;
            this.weekendRewardRate = weekendRewardRate;

        }

        public int calculateTotalRate(boolean isRewardCustomer, LocalDate startDate, LocalDate endDate){
            int totalrate=0;
            LocalDate  date=startDate;
            while(!date.isAfter(endDate)){
                DayOfWeek date1= date.getDayOfWeek();
                if(date1 == DayOfWeek.SATURDAY || date1 ==  DayOfWeek.SUNDAY){
                    totalrate  += isRewardCustomer ? weekendRewardRate : weekendRegularRate;

                }else{
                    totalrate += isRewardCustomer ? weekdayRewardRate : weekdayRegulaRate;
                }
                date = date.plusDays(1);
            }
            return totalrate;
        }
    }

