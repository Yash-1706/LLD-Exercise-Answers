import java.util.*;

// Maps room types and add-ons to their pricing implementations (replaces switch/if-else logic).
public class PricingRegistry {

    private final Map<Integer, RoomPricing> roomPricings = new HashMap<>();
    private final Map<AddOn, AddOnPricing> addOnPricings = new HashMap<>();

    public void registerRoom(int roomType, RoomPricing pricing) {
        roomPricings.put(roomType, pricing);
    }

    public void registerAddOn(AddOn addOn, AddOnPricing pricing) {
        addOnPricings.put(addOn, pricing);
    }

    public RoomPricing getRoomPricing(int roomType) {
        return roomPricings.get(roomType);
    }

    public AddOnPricing getAddOnPricing(AddOn addOn) {
        return addOnPricings.get(addOn);
    }
}

