package com.gengroup.huy.gengo.Common.Helper;

/**
 * Created by
 * Huy on 2/11/2019.
 */

public class TransformValue {
    public static class StatusValue{
        public static final String OPEN = "Open";
        public static final String CLOSED = "Closed";
        public static final String OVER_STOCK = "Over Stock";
        public static final String UNDEFINED = "Undefined";
    }
    public String TransformStatus(int status){
        switch (status){
            case 1:{
                return StatusValue.OPEN;
            }

            case 0:{
                return StatusValue.CLOSED;
            }

            case 2:{
                return StatusValue.OVER_STOCK;
            }
        }
        return StatusValue.UNDEFINED;
    }
}
