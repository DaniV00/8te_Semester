package exercise1;

public class ElectricalComponent {
    private final String id;
    private final ComponentType type;
    private int durability;

    public ElectricalComponent(String id, ComponentType type) {
        this.id = id;
        this.type = type;
        this.durability = 10;
    }

    public void performMaintenance() throws MaintenanceException {
        if (durability == 0) {
            throw new MaintenanceException("Component: '" + id + "' is broken");
        }
        durability--;
    }

    public String getId() {
        return id;
    }

    public ComponentType getType() {
        return type;
    }
}
