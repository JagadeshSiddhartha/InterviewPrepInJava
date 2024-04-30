import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class AnotherSub {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int code = Integer.parseInt(read.readLine());
        String name = read.readLine();
        int acountNumber = Integer.parseInt(read.readLine());
        int balance = Integer.parseInt(read.readLine());
        Date start = new Date(read.readLine());
        Date end = new Date(read.readLine());
        if(code == 1) {
            CurrentAccount acc = new CurrentAccount(name, acountNumber, balance, start, end);
            System.out.println(acc.calculateInterest(end));
        } else if(code == 2) {


        }
    }
}

abstract class Account {
    String name;
    int number, balance;
    Date first;
    abstract Double calculateInterest(Date date);
}
class CurrentAccount extends Account {
    Date last;
    CurrentAccount(String name, int accountNumber, int balance, Date startDate, Date endDate) {
        this.name = name;
        this.number = accountNumber;
        this.balance = balance;
        this.first = startDate;
        this.last = endDate;
    }

    @Override
    Double calculateInterest(Date date) {
        int diff = getDiffYears(first, date);
        System.out.println(diff);
        return (balance *  diff * 5) / 100.0;
    }
    public static int getDiffYears(Date first, Date last) {
        Calendar a = getCalendar(first);
        Calendar b = getCalendar(last);

        int diff = b.get(Calendar.YEAR) - a.get(Calendar.YEAR);
        if (a.get(Calendar.MONTH) > b.get(Calendar.MONTH) ||
                (a.get(Calendar.MONTH) == b.get(Calendar.MONTH) && a.get(Calendar.MONTH) > b.get(Calendar.MONTH))) {
            diff--;
        }
        return diff;
    }

    public static Calendar getCalendar(Date date) {
        Calendar cal = Calendar.getInstance(Locale.US);
        cal.setTime(date);
        return cal;
    }
}


class SavingsAccount extends Account {
    Date last;
    SavingsAccount(String name, int accountNumber, int balance, Date startDate, Date endDate) {
        this.name = name;
        this.number = accountNumber;
        this.balance = balance;
        this.first = startDate;
        this.last = endDate;
    }

    @Override
    Double calculateInterest(Date date) {
        int diff = getDiffYears(first, date);
        System.out.println(diff);
        return (balance *  diff * 12) / 100.0;
    }
    public static int getDiffYears(Date first, Date last) {
        Calendar a = getCalendar(first);
        Calendar b = getCalendar(last);

        int diff = b.get(Calendar.YEAR) - a.get(Calendar.YEAR);
        if (a.get(Calendar.MONTH) > b.get(Calendar.MONTH) ||
                (a.get(Calendar.MONTH) == b.get(Calendar.MONTH) && a.get(Calendar.MONTH) > b.get(Calendar.MONTH))) {
            diff--;
        }
        return diff;
    }

    public static Calendar getCalendar(Date date) {
        Calendar cal = Calendar.getInstance(Locale.US);
        cal.setTime(date);
        return cal;
    }
}

