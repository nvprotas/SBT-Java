import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

//Реализовать следующий класс по документации
public class BeanUtils {
    /**
     * Scans object "from" for all getters. If object "to"
     * contains correspondent setter, it will invoke it
     * to set property value for "to" which equals to the property
     * of "from".
     * <p/>
     * The type in setter should be compatible to the value returned
     * by getter (if not, no invocation performed).
     * Compatible means that parameter type in setter should
     * be the same or be superclass of the return type of the getter.
     * <p/>
     * The method takes care only about public methods.
     *
     * @param to   Object which properties will be set.
     * @param from Object which properties will be used to get values.
     */
    public static void assign(Object to, Object from) {
        if((to == null)||(from == null)) return;

        List<Method> setters = getMethods(to,"set");
        List<Method> getters = getMethods(from,"get");

        for (Method getter : getters) {
            for (Method setter : setters) {
                if(checkIfCompatible(setter,getter)){
                    try {
                        setter.invoke(to, getter.invoke(from));
                    } catch (InvocationTargetException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

    private static boolean checkIfCompatible(Method setter, Method getter) {
        return  ((setter.getName().substring(3).equals(getter.getName().substring(3)))&&
                (!getter.getReturnType().equals(void.class))&&
                (setter.getParameterTypes().length == 1));
    }

    private static List<Method> getMethods(Object o,String pattern) {
        Method[] methods = o.getClass().getMethods();
        List<Method> ListOfMethods = new ArrayList<>();
        for (Method method : methods) {
            if (method.getName().toLowerCase().startsWith(pattern.toLowerCase())) {
                ListOfMethods.add(method);
            }
        }
        return ListOfMethods;
    }
}