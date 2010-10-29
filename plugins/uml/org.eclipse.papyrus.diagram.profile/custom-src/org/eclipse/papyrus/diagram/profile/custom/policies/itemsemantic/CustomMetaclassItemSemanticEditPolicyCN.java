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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.profile.custom.policies.itemsemantic;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.papyrus.diagram.profile.custom.commands.CustomAssociationCreateCommand;
import org.eclipse.papyrus.diagram.profile.custom.commands.CustomExtensionCreateCommand;
import org.eclipse.papyrus.diagram.profile.custom.commands.CustomExtensionReorientCommand;
import org.eclipse.papyrus.diagram.profile.custom.helper.MetaclassHelper;
import org.eclipse.papyrus.diagram.profile.edit.commands.AssociationBranchCreateCommand;
import org.eclipse.papyrus.diagram.profile.edit.parts.ExtensionEditPart;
import org.eclipse.papyrus.diagram.profile.edit.policies.MetaclassItemSemanticEditPolicyCN;
import org.eclipse.papyrus.diagram.profile.providers.UMLElementTypes;

/**
 * 
 * This class provides a custom Item Semantic for the metaclass
 * <ul>
 * <li>allow the creation of the Extension link</li>
 * <li>retarget an extension link</li>
 * <li>manage the deletion of a metaclass figure in the diagram</li>
 * </ul>
 * 
 */
public class CustomMetaclassItemSemanticEditPolicyCN extends MetaclassItemSemanticEditPolicyCN {

	/**
	 * 
	 * @see org.eclipse.papyrus.diagram.profile.edit.policies.MetaclassItemSemanticEditPolicyCN#getCompleteCreateRelationshipCommand(org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest)
	 * 
	 * @param req
	 * @return
	 */
	@Override
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {

		if(UMLElementTypes.Extension_1013 == req.getElementType()) {
			return getGEFWrapper(new CustomExtensionCreateCommand(req, req.getSource(), req.getTarget()));
		} else if(UMLElementTypes.Association_4001 == req.getElementType()) {
			return getGEFWrapper(new CustomAssociationCreateCommand(req, req.getSource(), req.getTarget()));
		} else if(UMLElementTypes.Association_4019 == req.getElementType()) {
			return getGEFWrapper(new AssociationBranchCreateCommand(req, req.getSource(), req.getTarget()));
		}

		return super.getCompleteCreateRelationshipCommand(req);
	}

	/**
	 * this command is called with Delete From Model. It destroys :
	 * - the ElementImport associated with the metaclass
	 * - the metaclass's extensions
	 * - the property in the stereotype
	 * 
	 * @see org.eclipse.papyrus.diagram.profile.edit.policies.MetaclassItemSemanticEditPolicy#getDestroyElementCommand(org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest)
	 * 
	 * @param req
	 * 
	 * @return
	 */

	@Override
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		CompoundCommand cc = new CompoundCommand("Destroy Element Import"); //$NON-NLS-1$

		EObject elementToDestroy = req.getElementToDestroy();
		if(elementToDestroy instanceof org.eclipse.uml2.uml.Class) {
			EObject parentProfile = MetaclassHelper.getParentProfile(this.getHost().getParent());
			cc.add(MetaclassHelper.getDestroyMetaclassCommand((org.eclipse.uml2.uml.Class)elementToDestroy, parentProfile));
		}

		return cc;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.diagram.profile.edit.policies.MetaclassItemSemanticEditPolicy#getReorientRelationshipCommand(org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest)
	 * 
	 * @param req
	 * @return
	 */
	@Override
	protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {
		switch(getVisualID(req)) {
		case ExtensionEditPart.VISUAL_ID:
			return getGEFWrapper(new CustomExtensionReorientCommand(req));
		default:
		}
		return super.getReorientRelationshipCommand(req);
	}
}
