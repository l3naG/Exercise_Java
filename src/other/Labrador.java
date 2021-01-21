package other;

public class Labrador extends Dog {

    public Labrador(String name) {
        super(name);
    }


    // should not be overriden, in superclass equals() declared as final
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj instanceof Labrador) {
//            String objName = ((Labrador) obj).getName();
//            return this.getName().equals(objName);
//        }
//        return false;
//    }


}
