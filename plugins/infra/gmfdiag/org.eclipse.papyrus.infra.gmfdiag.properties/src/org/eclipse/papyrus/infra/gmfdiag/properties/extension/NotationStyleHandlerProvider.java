/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.properties.extension;

import org.eclipse.gmf.runtime.notation.datatype.GradientData;
import org.eclipse.papyrus.infra.constraints.constraints.Constraint;
import org.eclipse.papyrus.infra.gmfdiag.common.helper.NotationHelper;
import org.eclipse.papyrus.infra.gmfdiag.properties.constraint.GMFNotationConstraint;
import org.eclipse.papyrus.infra.gmfdiag.properties.modelelement.NotationModelElementFactory;
import org.eclipse.papyrus.infra.gmfdiag.properties.modelelement.StyleHandlerProvider;
import org.eclipse.papyrus.views.properties.contexts.DataContextElement;
import org.eclipse.papyrus.views.properties.modelelement.ModelElement;
import org.eclipse.papyrus.views.properties.modelelement.ModelElementFactory;

/**
 * Default implementation of StyleHandlerProvider
 * Handles the GMF Notation views (With a low priority)
 * 
 * @author Camille Letavernier
 */
public class NotationStyleHandlerProvider implements StyleHandlerProvider {

	private ModelElementFactory factory = new NotationModelElementFactory();

	public Constraint createConstraint() {
		return new GMFNotationConstraint();
	}

	public boolean isProviderFor(Object selection) {
		if(selection instanceof GradientData) {
			return true;
		}
		return NotationHelper.findView(selection) != null;
	}

	public ModelElement createModelElement(Object selection, DataContextElement context) {
		return factory.createFromSource(selection, context);
	}

}
