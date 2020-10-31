package data;

import java.util.*;

public class Data {

    private static Map<String,Map> symbolsandMins;

    private static final List<String> symbols=new ArrayList<>(Arrays.asList(
            "","",""));


    private static final List<String> orderSides=new ArrayList<>(Arrays.asList(
            "buy", "sell"    ));

    private static final List<String> orderTypes=new ArrayList<>(Arrays.asList(
            "exchange stop limit", "exchange limit"    ));

    private static final List<String> orderExecutionOptions=new ArrayList<>(Arrays.asList(
                    "maker-or-cancel","immediate-or-cancel","fill-or-kill",
                    "auction-only","indication-of-interest"));
    public Data() {

    }

    public static List<String> getOrderTypes() {
        return orderTypes;
    }

    public static List<String> getOrderExecutionOptions() {
        return orderExecutionOptions;
    }

    static {
        Map values=new HashMap();
        Map symbols=new HashMap();


    }






}
