import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Second {
    public static void main(String[] args) {
        Settings settings = new Settings();
        settings.put("name", String.class, "jagadesh");
        System.out.println(settings.get("name", String.class));


    }
}
class ObjectType{
    Object o;
    String type;
    ObjectType(Object o, String type) {
        this.o = o;
        this.type = type;
    }
}
class Settings2 {
    private final Map<String, ObjectType>  internalMap;

    public Settings2() {
        internalMap = new HashMap<>();
    }
    public <T> void put(String key, ObjectType objectPair) {
        internalMap.put(key, objectPair);
    }
    public <T> T get(String key) {
        ObjectType objectType = internalMap.get(key);
        if(objectType.type.equals("Map")) {
            return (T) HashMap.class.cast(objectType.o);
        } else {
            return (T) String.class.cast(objectType.o);
        }
    }

}
class Settings {

    private final Map<String, Map<Class<?>, Object>> internalMap;

    public Settings() {
        internalMap = new HashMap<>();
    }

    public <T> void put(String textKey, Class<T> typeKey, T chachedValue) {
        Map<Class<?>, Object> mapForTextKey = getMapForTextKey(textKey);
        mapForTextKey.put(typeKey, chachedValue);
    }

    private Map<Class<?>, Object> getMapForTextKey(String textKey) {
        if (!internalMap.containsKey(textKey))
            internalMap.put(textKey, new HashMap<>());
        return internalMap.get(textKey);
    }

    public <T> T get(String textKey, Class<T> typeKey) {
        Object untypedSettingsdValue = getUntyped(textKey, typeKey);
        // the cast can not fail because:
        // - if there is no value for those keys, the argument is null,
        //      which can always be cast
        // - if there is a value for those keys, `put` made sure that
        //      its type matches the type used as a key
        return typeKey.cast(untypedSettingsdValue);
    }

    private Object getUntyped(String textKey, Class<?> typeKey) {
        if (internalMap.containsKey(textKey))
            return internalMap.get(textKey).get(typeKey);
        else
            return null;
    }

}
/*
10 10
1 3 2 1 2 3 4 3 2 3
1 5
2 6
1 4
1 9
4 7
6 9
2 6
3 9
4 8
2 10
 */