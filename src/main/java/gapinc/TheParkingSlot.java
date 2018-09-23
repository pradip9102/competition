package gapinc;

import java.util.*;

class ParkingArea {
    private Map<Integer, ParkingSlot> _parkingSlots;
    private Map<Integer, List<Route>> _routes;
    private Integer _totalRoutes;
    private Integer _parkingFee;

    ParkingArea(Integer nSlot, Integer nRoute, Integer parkingFee) {
        _parkingSlots = new HashMap<>(nSlot);
        _routes = new HashMap<>(nSlot);
        _totalRoutes = nRoute;
        _parkingFee = parkingFee;
    }

    public Integer getTotalSlot() {
        return ParkingSlot.getTotalSlot();
    }

    public Integer getTotalRoute() {
        return _totalRoutes;
    }

    public Integer getParkingFee() {
        return _parkingFee;
    }

    public ParkingSlot getParkingSlot(Integer slotId) {
        return _parkingSlots.get(slotId - 1);
    }

    public void addParkingSlot(Integer capacity) {
        ParkingSlot parkingSlot = new ParkingSlot(capacity);
        _parkingSlots.put(parkingSlot.getSlotId(), parkingSlot);
    }

    public void addRoute(Integer slot1Id, Integer slot2Id, Integer cost) {
        ParkingSlot slot1 = _parkingSlots.get(slot1Id);
        ParkingSlot slot2 = _parkingSlots.get(slot2Id);

        _routes.putIfAbsent(slot1.getSlotId(), new ArrayList<>());
        _routes.get(slot1.getSlotId()).add(new Route(slot1, slot2, cost));

        _routes.putIfAbsent(slot2.getSlotId(), new ArrayList<>());
        _routes.get(slot2.getSlotId()).add(new Route(slot2, slot1, cost));
    }

    public Route getRoute(ParkingSlot slot1, ParkingSlot slot2) {
        List<Route> availableRoutes = _routes.get(slot1.getSlotId());
        return availableRoutes.stream()
                .filter(route -> Objects.equals(slot2.getSlotId(), route.to().getSlotId()))
                .findFirst()
                .orElse(null);
    }
}

class ParkingSlot {
    private static Integer _counter = 0;
    private Integer _slotId;
    private Integer _capacity;

    public ParkingSlot(Integer capacity) {
        _slotId = ++_counter;
    }

    public Integer getSlotId() {
        return _slotId;
    }

    public Integer getCapacity() {
        return _capacity;
    }

    static Integer getTotalSlot() {
        return _counter;
    }
}

class Route {
    private ParkingSlot _from;
    private ParkingSlot _to;
    private Integer _cost;

    public Route(ParkingSlot from, ParkingSlot to, Integer cost) {
        _from = from;
        _to = to;
        _cost = cost;
    }

    public ParkingSlot from() {
        return _from;
    }

    public ParkingSlot to() {
        return _to;
    }

    public Integer getCost() {
        return _cost;
    }
}

public class TheParkingSlot {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        ParkingArea parkingArea = new ParkingArea(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        for (int i = 0; i < parkingArea.getTotalSlot(); i++) {
            parkingArea.addParkingSlot(scanner.nextInt());
        }
        for (int i = 0; i < parkingArea.getTotalRoute(); i++) {
            parkingArea.addRoute(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        }
        Integer nIncomingVehical = scanner.nextInt();
    }
}
