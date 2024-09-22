public class Hashmap {
    public static void main(String[] args) {

        MyMap map = new MyMap();
        map.put("donkey", "meow");
        map.put("dog", "bark");
        map.put("cow", "moo");
        System.out.println(map.get("donkey"));
    }
}

class MyMap {
    private String arr[] = new String[10];

    public void put(String key, String value) {
        int sum = 0;
        for (int i = 0; i < Math.min(key.length(), 2); i++) {
            int acsii = key.charAt(i);
            sum += acsii;
        }
        sum = sum % arr.length;
        arr[sum] = value;
    }

    public String get(String key) {
        int sum = 0;
        for (int i = 0; i < Math.min(key.length(), 2); i++) {
            int acsii = key.charAt(i);
            sum += acsii;
        }
        sum = sum % arr.length;
        if (arr[sum] != null) {
            return arr[sum];
        }
        return null;
    }
}
