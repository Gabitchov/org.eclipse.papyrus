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
import org.eclipse.papyrus.qompass.designer.core.Activator;
import org.eclipse.papyrus.qompass.designer.core.Messages;
import org.eclipse.papyrus.qompass.designer.core.transformations.TransformationException;


/**
 * Support for multiple target languages via the Eclipse extension mechanism
 */
public class LanguageSupport {

	public static final String ILANG_SUPPORT_ID = Activator.PLUGIN_ID + ".language"; //$NON-NLS-1$

	public static ILangSupport getLangSupport(String language) throws TransformationException
	{
		IExtensionRegistry reg = Platform.getExtensionRegistry();
		IConfigurationElement[] configElements = reg.getConfigurationElementsFor(ILANG_SUPPORT_ID);
		for(IConfigurationElement configElement : configElements) {
			try {
				final String extLanguage = configElement.getAttribute("language"); //$NON-NLS-1$
				if(extLanguage.equals(language)) {
					// TODO: cache returned instance (avoid creating a new instance each time => more efficient, no need for static attributes)
					final Object obj = configElement.createExecutableExtension("class"); //$NON-NLS-1$
					if(obj instanceof ILangSupport) {
						return (ILangSupport)obj;
					}
				}
			} catch (CoreException exception) {
				exception.printStackTrace();
			}
		}
		throw new TransformationException(String.format(Messages.LanguageSupport_LanguageNotSupported, language));
	}
}
