/*******************************************************************************
 * Copyright (c) 2011 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA LIST - initial API and implementation
 *******************************************************************************/

package org.eclipse.papyrus.qompass.designer.core.extensions;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.FCM.BindingHelper;
import org.eclipse.papyrus.FCM.util.IBindingHelper;
import org.eclipse.papyrus.qompass.designer.core.listeners.PostCopyListener;
import org.eclipse.papyrus.qompass.designer.core.listeners.PreCopyListener;
import org.eclipse.papyrus.qompass.designer.core.transformations.LazyCopier;
import org.eclipse.papyrus.qompass.designer.core.transformations.TransformationRTException;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.TemplateBinding;


/**
 * Support for binding helper
 */
public class BindingHelperExt {

	public static final String IBINDING_HELPER_ID = org.eclipse.papyrus.FCM.Activator.PLUGIN_ID + ".fcmBindingHelper"; //$NON-NLS-1$

	/**
	 * 
	 * @param iConfiguratorName
	 * @param component
	 *        containing composite (container)
	 * @param instance
	 */
	public static EObject applyPreHelper(BindingHelper helper, LazyCopier copier, TemplateBinding binding, EObject sourceEObj) {
		IBindingHelper ihelper = getBindingHelper(helper.getBase_Class().getName());
		if (sourceEObj instanceof Element) {
			ihelper.handleElement(binding, (Element) sourceEObj);
		}
		if(ihelper instanceof PreCopyListener) {
			return ((PreCopyListener) ihelper).preCopyEObject(copier, sourceEObj);
		}
		return sourceEObj;
	}
	
	/**
	 * 
	 * @param iConfiguratorName
	 * @param component
	 *        containing composite (container)
	 * @param instance
	 */
	public static void applyPostHelper(BindingHelper helper, LazyCopier copier, TemplateBinding binding, EObject targetEObj) {
		IBindingHelper ihelper = getBindingHelper(helper.getBase_Class().getName());
		if (targetEObj instanceof Element) {
			ihelper.handleElement(binding, (Element) targetEObj);
		}
		if(ihelper instanceof PostCopyListener) {
			((PostCopyListener) ihelper).postCopyEObject(copier, targetEObj);
		}
	}

	public static IBindingHelper getBindingHelper(BindingHelper helper) {
		if (helper != null) {
			return getBindingHelper(helper.getBase_Class().getName());
		}
		return null;
	}

	public static IBindingHelper getBindingHelper(String helperName) {
		IExtensionRegistry reg = Platform.getExtensionRegistry();
		IConfigurationElement[] configElements = reg.getConfigurationElementsFor(IBINDING_HELPER_ID);
		for(IConfigurationElement configElement : configElements) {
			try {
				final String configHelperName = configElement.getAttribute("bindingHelperName"); //$NON-NLS-1$
				if(configHelperName.equals(helperName)) {
					// TODO: cache returned instance (avoid creating a new instance each time => more efficient, no need for static attributes)
					final Object obj = configElement.createExecutableExtension("class"); //$NON-NLS-1$
					if(obj instanceof IBindingHelper) {
						return (IBindingHelper)obj;
					}
				}
			} catch (CoreException exception) {
				exception.printStackTrace();
			}
		}
		throw new TransformationRTException(
				String.format("Cannot find binding helper <%s>", helperName));
	}
}
