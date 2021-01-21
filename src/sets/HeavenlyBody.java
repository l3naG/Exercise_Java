package sets;

import java.util.HashSet;
import java.util.Set;

public abstract class HeavenlyBody {

    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;
    private final Key key;


    public enum BodyTypes {
        STAR,
        PLANET,
        DWARF_PLANET,
        MOON,
        COMET,
        ASTEROID
    }

//    public static final int STAR = 1;
//    public static final int PLANET = 2;
//    public static final int DWARF_PLANET = 3;
//    public static final int MOON = 4;
//    public static final int COMET = 5;
//    public static final int ASTEROID = 6;


    public HeavenlyBody(String name, double orbitalPeriod, BodyTypes bodyTypes) {
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
        this.key = new Key(name, bodyTypes);
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public Key getKey() {
        return key;
    }

    public boolean addSatellite(HeavenlyBody moon) {
        return satellites.add(moon);
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(satellites);
    }

    @Override
    public final int hashCode() {
        return this.key.hashCode();
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HeavenlyBody) {
            HeavenlyBody theObj = ((HeavenlyBody) obj);
            return this.key.equals(theObj.getKey());
        }
        return true;
    }

    @Override
    public String toString() {
        return this.key.name + ": " + this.key.bodyTypes + ", " + this.orbitalPeriod;
    }

    public static Key makeKey(String name, BodyTypes bodyType) {
        return new Key(name, bodyType);

    }


    //    public boolean equals_2(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (this.getClass() != obj.getClass() || (obj == null)) {
//            return false;
//        }
//        String objName = ((HeavenlyBody) obj).getName();
//        return this.name.equals(objName);
//    }

    public static final class Key {
        private String name;
        private BodyTypes bodyTypes;

        private Key(String name, BodyTypes bodyTypes) {
            this.name = name;
            this.bodyTypes = bodyTypes;
        }

        public String getName() {
            return name;
        }

        public BodyTypes getBodyTypes() {
            return bodyTypes;
        }

        @Override
        public String toString() {
            return this.name + ": " + this.bodyTypes;
        }

        @Override
        public boolean equals(Object obj) {
            Key key = (Key) obj;
            if (this.name.equals(key.getName())) {
                return (this.bodyTypes == key.getBodyTypes());
            }
            return false;
        }

        @Override
        public int hashCode() {
            return this.name.hashCode() + 55 + this.bodyTypes.hashCode();
        }

    }
}
