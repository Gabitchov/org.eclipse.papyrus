/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.uml.diagram.clazz.providers;

import java.lang.ref.WeakReference;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.CreateGraphicEditPartOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.IEditPartOperation;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.providers.DefaultEditPartProvider;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ModelEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.UMLEditPartFactory;
import org.eclipse.papyrus.uml.diagram.clazz.part.UMLVisualIDRegistry;

/**
 * @generated
 */
public class UMLEditPartProvider extends DefaultEditPartProvider {

	/**
	 * @generated
	 */
	public UMLEditPartProvider() {
		super(new UMLEditPartFactory(), UMLVisualIDRegistry.TYPED_INSTANCE, ModelEditPart.MODEL_ID);
	}
}
