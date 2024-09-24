package exercise1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class IceCreamMaschine {
    private final Map<IceCream, Integer> stock;
    private final Map<ComponentType, ElectricalComponent> usedComponents;
    private final Set<ElectricalComponent> replacementComponents;

    public IceCreamMaschine(Map<IceCream, Integer> stock, Map<ComponentType, ElectricalComponent> usedComponents, Set<ElectricalComponent> replacementComponents) {
        this.stock = stock;
        this.usedComponents = usedComponents;
        this.replacementComponents = replacementComponents;
    }

    public List<IceCream> buyIceCream(List<String> orders) {

        List<IceCream> iceFlave = new ArrayList<>();
        for(String order : orders){

            try{
                iceFlave.add(produceIceCream(order));
            }
            catch(Exception e){
                System.out.println("One flavour is not available");
            }
        }


        System.out.println(iceFlave);
        return iceFlave;

    }

    private IceCream produceIceCream(String sort) {
        return IceCream.valueOf(sort);
    }

    private void performMaintenance() throws MaintenanceException {
        for (ElectricalComponent component : usedComponents.values()) {
            component.performMaintenance();
        }
    }


    public void buyIceCream(String sort) throws IceCreamNotAvailableException {
        IceCream iceToBuy = produceIceCream(sort);
        Integer availableStock = stock.get(iceToBuy);
        if (iceToBuy != null) {
            if (availableStock <= 0) {
                IceCreamNotAvailableException iceException = new IceCreamNotAvailableException("No icecream available");
                throw iceException;
            } else {
                availableStock = availableStock - 1;
                stock.put(iceToBuy, availableStock);
                System.out.println("HOORAY ICE CREAM " + availableStock.intValue());
            }
        }

    }

    private boolean repairMachine(String componentId) {
        return false;
    }
}
