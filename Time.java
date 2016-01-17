import java.util.*;
import java.util.concurrent.*;

/**
 * Time class.
 *
 * @author Lucas Rezende Correa de Souza
 *
 */

public class Time {
  private Date date = new Date();
  
  public Time(Date date) {
    this.date = date;
  }
  
  public String getOrderTime() {
    return date.toString();
  }
  
  public long getDateDiff(TimeUnit timeUnit) {
    Date newDate = new Date();
    long diffInMillies = newDate.getTime() - date.getTime();
    return timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
  }
}
