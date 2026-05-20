package factory;

import enums.PricingStrategies;
import strategy.*;


public class PricingStrategyFactory {

    public static PricingStrategy getPricingStrategy(PricingStrategies strategy){

        System.out.println("Strategy using :"+strategy);
        if(strategy==PricingStrategies.EVENT_BASED)
            return new EventBasedPricingStrategy();
        else if(strategy==PricingStrategies.TIME_BASED)
            return new TimeBasedPricingStrategy();
        
        return null;
    }
}
