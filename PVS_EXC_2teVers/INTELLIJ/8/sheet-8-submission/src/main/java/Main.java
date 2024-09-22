import exercise1.ComponentType;
import exercise1.ElectricalComponent;
import exercise1.IceCream;
import exercise1.IceCreamMaschine;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Map<IceCream,Integer> stoc = new HashMap<>();
        stoc.put(IceCream.OASEN_FRUCHTMIX,10);
        stoc.put(IceCream.MELANGE_EIS,20);

        ElectricalComponent batt = new ElectricalComponent("1",ComponentType.BATTERY);
        ElectricalComponent fuse = new ElectricalComponent("2",ComponentType.FUSE);

        Map<ComponentType, ElectricalComponent> usedComponents = new HashMap<>();
        usedComponents.put(ComponentType.BATTERY,batt);
        usedComponents.put(ComponentType.ENGINE,fuse);

        Set<ElectricalComponent> replace = HashSet.newHashSet(4);

        IceCreamMaschine machine = new IceCreamMaschine(stoc,usedComponents, replace);

        machine.buyIceCream("OASEN_FRUCHTMIX");
        machine.buyIceCream("OASEN_FRUCHTMIX");
        machine.buyIceCream("MELANGE_EIS");

    }
}
