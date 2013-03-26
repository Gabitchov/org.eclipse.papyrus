package org.eclipse.papyrus.infra.tools.util;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Platform;


public class PlatformHelper {

	public static Object getAdapter(Object adaptable, Class<?> adapterType) {
		if (adapterType.isInstance(adaptable)) {
			return adaptable;
		}
		if (adaptable instanceof IAdaptable) {
			Object result = ((IAdaptable)adaptable).getAdapter(adapterType);
			if (result != null) {
				return result;
			}
		}
		return Platform.getAdapterManager().getAdapter(adaptable, adapterType);
	}
}
