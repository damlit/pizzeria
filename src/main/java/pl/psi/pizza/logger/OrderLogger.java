package pl.psi.pizza.logger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class OrderLogger {

    private final Logger logger = Logger.getLogger(getClass().getName());
    private FileHandler fh = null;

    public OrderLogger() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy_MM_dd-hh_mm_ss", Locale.GERMANY);
        try {
            fh = new FileHandler("ordersLog/order_"
                    + simpleDateFormat.format(new Date()) + ".log");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        fh.setFormatter(new SimpleFormatter());
        logger.addHandler(fh);
    }

    public Logger getLogger() {
        return logger;
    }
}
