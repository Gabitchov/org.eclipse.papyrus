/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mathieu Velten (Atos Origin) mathieu.velten@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.part;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PropertyEditPart;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.helper.BlockPropertyHelper;
import org.eclipse.uml2.uml.Property;


public class BlockPropertyEditPart extends PropertyEditPart {

	BlockPropertyHelper notifier;

	public BlockPropertyEditPart(View view) {
		super(view);
		// get the block node (the second parent because of the compartment)
		EObject blockNode = view.eContainer().eContainer();
		if(blockNode instanceof Node) {
			notifier = new BlockPropertyHelper((Node)blockNode);
		}
	}

	/**
	 * Activate a listener to handle notification
	 */
	public void activate() {
		super.activate();
		EObject property = resolveSemanticElement();
		if(property instanceof Property && notifier != null) {
			notifier.listenObject(property);
		}
	}

	@Override
	public void deactivate() {
		if(notifier != null) {
			notifier.unlistenAll();
		}
		super.deactivate();
	}

	/**
	 * Remove listeners to handle notification
	 * 
	 */
	@Override
	public void removeNotify() {
		if(notifier != null) {
			notifier.unlistenAll();
		}
		super.removeNotify();
	}

}
