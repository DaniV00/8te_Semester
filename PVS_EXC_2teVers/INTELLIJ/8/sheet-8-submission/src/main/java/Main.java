import exercise1.*;

import java.util.*;

public class Main {

    public static void main(String[] args) throws IceCreamNotAvailableException {
        Map<IceCream,Integer> stoc = new HashMap<>();
        stoc.put(IceCream.OASEN_FRUCHTMIX,1);
        stoc.put(IceCream.MELANGE_EIS,20);
        List<String> iceCreamList = new ArrayList<>();

        iceCreamList.add("MELANGE_EIS");
        iceCreamList.add("MELANGE_EIS");
        iceCreamList.add("OASEN_FRUCHTMIX");
        iceCreamList.add("VANILLE");
        iceCreamList.add("OASEN_FRUCHTMIX");
        iceCreamList.add("MELANGE_EIS");



        ElectricalComponent batt = new ElectricalComponent("1",ComponentType.BATTERY);
        ElectricalComponent fuse = new ElectricalComponent("2",ComponentType.FUSE);

        Map<ComponentType, ElectricalComponent> usedComponents = new HashMap<>();
        usedComponents.put(ComponentType.BATTERY,batt);
        usedComponents.put(ComponentType.ENGINE,fuse);

        Set<ElectricalComponent> replace = HashSet.newHashSet(4);

        IceCreamMaschine machine = new IceCreamMaschine(stoc,usedComponents, replace);

        machine.buyIceCream("OASEN_FRUCHTMIX");
        machine.buyIceCream(iceCreamList);
       // machine.buyIceCream("OASEN_FRUCHTMIX");
        //machine.buyIceCream("OASEN_FRUCHTMIX");
        //machine.buyIceCream("MELANGE_EIS");

    }
}
