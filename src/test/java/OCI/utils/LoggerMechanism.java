package OCI.utils;

import OCI.testBase.TestBase;
import org.apache.log4j.Logger;


public class LoggerMechanism extends TestBase {

    public static Logger log = Logger.getLogger("devpinoyLogger");

    public  void logINFO(String info){
        log.info(info);
    }

    public  void logEROOR(String info){
        log.error(info);
    }

    public  void logINFO(Exception e) {
        // TODO Auto-generated method stub
        LoggerMechanism.log.info(e);
    }

    public static void logINFO(Boolean serviceMetrics) {
        // TODO Auto-generated method stub
        LoggerMechanism.log.info(serviceMetrics);
    }
}
