package BankAccount;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatDate {
    public String formatDate(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(new Date());
    }
}
