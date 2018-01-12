package pf.aqsa.com.retroo;

import com.squareup.otto.Bus;

/**
 * Created by Mahek on 1/12/2018.
 */

public class BusProvider {


    private static final Bus BUS = new Bus();

    public static Bus getInstance(){
        return BUS;
    }

    public BusProvider(){}





}
