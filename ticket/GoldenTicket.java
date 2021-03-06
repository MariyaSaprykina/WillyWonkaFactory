package ticket;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GoldenTicket {

    private String code;
    private Date raffled;
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    public GoldenTicket() {

    }

    public GoldenTicket(String code, Date raffled) {
        super();
        this.code = code;
        this.raffled = raffled;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getRaffled() {
        return raffled;
    }

    public void setRaffled(Date raffled) {
        this.raffled = raffled;
    }

    public boolean isRaffled() {
        return raffled != null;
    }

    @Override
    public String toString() {
        String strRaffled = "null";
        if (raffled != null) {
            strRaffled = dateFormat.format(raffled);
        }
        return "GoldenTicket{" + "code=" + code + ", raffled=" + strRaffled + '}';
    }

}

