/**
 * 
 */
package cto.framework.service.helper;

import java.lang.reflect.Constructor;
import java.util.Map;

import org.apache.commons.lang.exception.ExceptionUtils;

import cto.framework.core.util.ParameterUtils;
import cto.framework.core.util.StringHelper;
import cto.framework.service.plugin.schema.Throw;
import cto.framework.service.plugin.schema.types.ThrowTypeType;

/**
 * @author PeterTan
 * 
 */
public class ExceptionHelper extends ExceptionUtils {

	public static void throwRuntimeException(Throw $throw, Map<String, String> propertyMap) throws Exception {
		if ($throw != null) {
			ThrowTypeType $type = $throw.getType();
			String type = $type.value();
			if (StringHelper.isNotBlank(type)) {
				if (!type.startsWith("java.lang.")) {
					type = "java.lang." + type;
				}
				@SuppressWarnings("unchecked")
				Class<RuntimeException> rtEx = (Class<RuntimeException>) Class.forName(type);
				Constructor<RuntimeException> constructor = rtEx.getConstructor(String.class);
				String message = $throw.getMessage();
				if (!StringHelper.isNotBlank(message)) {
					message = "";
				} else {
					ParameterUtils.analyzePropertyValue(message, propertyMap);
				}
				RuntimeException runtimeException = constructor.newInstance(message);
				throw runtimeException;
			}
		}
	}
}
