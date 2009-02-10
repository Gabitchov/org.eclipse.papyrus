/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.Tessier@cea.fr - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.diagram.clazz.custom.policies;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.part.UMLDiagramUpdater;
import org.eclipse.papyrus.diagram.clazz.part.UMLNodeDescriptor;
import org.eclipse.uml2.uml.AssociationClass;

/**
 * this policy is used to supress orphan node view in GMF view the prolicy to remove orphan connection is more complex. It is dependent of the diagram. see remove OrphanConnectionView policy in
 * clazzdiagram
 * 
 * @author Patrick Tessier
 */
public class RemoveOrphanNodeViewPolicy extends CanonicalEditPolicy {

	/**
	 * 
	 * {@inheritDoc}
	 */
	protected Command getCreateViewCommand(CreateRequest request) {
		return null;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	protected List getSemanticChildrenList() {

		View viewObject = (View) getHost().getModel();
		List result = new LinkedList();
		for (Iterator<?> it = UMLDiagramUpdater.getPackage_1000SemanticChildren(viewObject).iterator(); it.hasNext();) {
			result.add(((UMLNodeDescriptor) it.next()).getModelElement());
		}
		ArrayList<AssociationClass> associationClassResult = new ArrayList<AssociationClass>();

		for (Iterator ite = result.iterator(); ite.hasNext();) {
			EObject eobject = (EObject) ite.next();
			if (eobject instanceof AssociationClass) {
				associationClassResult.add((AssociationClass) eobject);
			}
		}

		return result;
	}
}
