
public final class CallZone {

    public static boolean isValidZone(String zone) {
        zone = zone.toLowerCase();
        return (zone.equals("canada") ||
            zone.equals("usa") ||
            zone.equals("europe") ||
            zone.equals("asia") ||
            zone.equals("anz") ||
            zone.equals("latinam") ||
            zone.equals("africa")
        );
    }

}