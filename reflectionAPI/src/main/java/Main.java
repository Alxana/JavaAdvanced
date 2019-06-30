public class Main {
    public static void main(String[] args){
            Properties1Interface prop = PropertyFactory.createProperty(Properties1Interface.class);
            System.out.println(prop.getKey1Value());
            System.out.println(prop.getKey2Value());
    }
}
