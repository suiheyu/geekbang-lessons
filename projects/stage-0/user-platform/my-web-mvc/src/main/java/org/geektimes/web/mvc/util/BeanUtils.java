package org.geektimes.web.mvc.util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.function.Supplier;

/**
 * @author hexinyu
 * @version 1.0
 * @description
 * @date 2021/03/03
 * @link
 * @see
 */
public class BeanUtils {

    public static Object stringToOther(String str, Class<?> otherT){
        if(String.class.equals(otherT)){
            return str;
        }
        if(Long.class.equals(otherT) && StringUtils.isNumnic(str)){
            return Long.parseLong(str);
        }
        if(Integer.class.equals(otherT) && StringUtils.isNumnic(str)){
            return Integer.parseInt(str);
        }
        return null;
    }

    public static <T> T initByMap(Supplier<T> supplier, Map<String, String> filedValueMap){
        T target = supplier.get();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(target.getClass(), Object.class);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                Method writeMethod = propertyDescriptor.getWriteMethod();
                String filedName = propertyDescriptor.getName();
                if(writeMethod != null){
                    Class<?>[] parameterTypes = writeMethod.getParameterTypes();
                    if(parameterTypes.length == 1){
                        writeMethod.invoke(target, stringToOther(filedValueMap.get(filedName), parameterTypes[0]));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return target;
    }
}
