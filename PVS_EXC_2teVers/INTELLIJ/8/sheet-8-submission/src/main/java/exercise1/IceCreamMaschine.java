package exercise1;

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
        return null;
    }

    private IceCream produceIceCream(String sort) {
        return IceCream.valueOf(sort);
    }

    private void performMaintenance() throws MaintenanceException {
        for (ElectricalComponent component : usedComponents.values()) {
            component.performMaintenance();
        }
    }

    public IceCream buyIceCream(String sort){
        IceCream iceToBuy = produceIceCream(sort);
        Integer availableStock = stock.get(iceToBuy);
        if(iceToBuy != null){
            availableStock = availableStock - 1;
            stock.put(iceToBuy, availableStock);
            System.out.println("HOORAY ICE CREAM " + availableStock.intValue());
        }
        else {
            throw new IllegalArgumentException();
        }

        return iceToBuy;
    }

    private boolean repairMachine(String componentId) {
        return false;
    }
}
