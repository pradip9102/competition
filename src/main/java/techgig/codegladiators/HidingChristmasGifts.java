package techgig.codegladiators;

import java.util.*;

class House {
    int name;
    List<House> linkedHouses = new ArrayList<>();
    int giftCount = 0;

    House(int name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return name == house.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

public class HidingChristmasGifts {

    private static List<House> getDirections(House start, House finish) {
        Map<House, Boolean> vis = new HashMap<>();
        Map<House, House> prev = new HashMap<>();

        List<House> directions = new LinkedList<>();
        Queue<House> q = new LinkedList<>();
        House current = start;
        q.add(current);
        vis.put(current, true);
        while (!q.isEmpty()) {
            current = q.remove();
            if (current.equals(finish)) {
                break;
            } else {
                for (House house : current.linkedHouses) {
                    if (!vis.containsKey(house)) {
                        q.add(house);
                        vis.put(house, true);
                        prev.put(house, current);
                    }
                }
            }
        }
        if (!current.equals(finish)) {
//            System.out.println("can't reach destination");
        }
        for (House house = finish; house != null; house = prev.get(house)) {
            directions.add(house);
        }

        Collections.reverse(directions);
        return directions;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int houseCount = scanner.nextInt();
        int dayCount = scanner.nextInt();

        List<House> houses = new ArrayList<>(houseCount);
        for (int i = 0; i <= houseCount; i++) {
            houses.add(new House(i));
        }
        for (int i = 1; i < houseCount; i++) {
            House h1 = houses.get(scanner.nextInt());
            House h2 = houses.get(scanner.nextInt());
            h1.linkedHouses.add(h2);
            h2.linkedHouses.add(h1);
        }

        for (int i = 0; i < dayCount; i++) {
            House start = houses.get(scanner.nextInt());
            House finish = houses.get(scanner.nextInt());
            List<House> directions = getDirections(start, finish);
            directions.forEach(house -> ++house.giftCount);
//            directions.forEach(house -> System.out.print(house.name + " "));
//            System.out.println();
        }

        System.out.println(houses.stream().map(house -> house.giftCount).max(Integer::compareTo).orElse(0));
    }

}
