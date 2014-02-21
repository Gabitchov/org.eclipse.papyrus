/**
 * Copyright (c) 2012 Mia-Software.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  	Alban Ménager (Soft-Maint) - Bug 387470 - [EFacet][Custom] Editors
 *  	Grégoire Dupé (Mia-Software) - Bug 387470 - [EFacet][Custom] Editors
 */
package org.eclipse.papyrus.emf.facet.util.emf.ui.internal.exported.wizard;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.wizard.IExtendedWizard;

/**
 * @since 0.3
 */
public interface ISelectETypeWizard<T extends EClassifier> extends
		IExtendedWizard {

	T getSelectedEClassifier();
}
