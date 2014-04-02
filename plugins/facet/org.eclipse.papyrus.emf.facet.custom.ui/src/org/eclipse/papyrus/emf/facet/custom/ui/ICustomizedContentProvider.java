/**
 *  Copyright (c) 2011 Mia-Software.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *  	Gregoire Dupe (Mia-Software) - Bug 361794 - [Restructuring] New customization meta-model
 *      Gregoire Dupe (Mia-Software) - Bug 373078 - API Cleaning
 */
package org.eclipse.papyrus.emf.facet.custom.ui;

import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.papyrus.emf.facet.custom.core.ICustomizationManager;

/**
 * This interface allow to used a {@link IContentProvider} which is implemented
 * and customizable using the EMF Facet customization mechanism.
 * 
 * @author Gregoire Dupe
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 * @deprecated use {@link ICustomizedTreeContentProvider} (Bug 380229 - [deprecated] ICustomizedContentProvider)
 */
@Deprecated
public interface ICustomizedContentProvider extends IContentProvider {
	/**
	 * This method returns the customization manager used by the content provider. The
	 * customization stack update have to be done using this
	 * {@link ICustomizationManager}.
	 * 
	 * @return the customization manager used by the content provider.
	 */
	ICustomizationManager getCustomizationManager();
}
