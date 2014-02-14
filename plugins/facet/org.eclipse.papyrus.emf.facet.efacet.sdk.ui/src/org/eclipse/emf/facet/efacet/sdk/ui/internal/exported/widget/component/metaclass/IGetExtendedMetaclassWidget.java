/**
 * Copyright (c) 2012 Mia-Software.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  	Grégoire Dupé (Mia-Software) - Bug 387470 - [EFacet][Custom] Editors
 */
package org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget.component.metaclass;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.facet.util.emf.ui.internal.exported.wizard.ISelectETypeWizard;
import org.eclipse.emf.facet.util.ui.internal.exported.widget.getorcreate.IAbstractGetOrCreateElementWithButtonWidget;

public interface IGetExtendedMetaclassWidget extends
		IAbstractGetOrCreateElementWithButtonWidget<ISelectETypeWizard<EClass>> {
	// This interface is juste dedicated to simplify the method's signatures
}
