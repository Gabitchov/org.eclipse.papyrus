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


package org.eclipse.papyrus.diagram.profile.custom.policies;

import java.util.ArrayList;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.editpolicies.OrphanViewPolicy;
import org.eclipse.papyrus.diagram.profile.custom.helper.DiagramHelper;
import org.eclipse.papyrus.diagram.profile.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.DataTypeAttributeCompartmentEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.DataTypeAttributeCompartmentEditPartCN;
import org.eclipse.papyrus.diagram.profile.edit.parts.DataTypeOperationCompartmentEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.DataTypeOperationCompartmentEditPartCN;
import org.eclipse.papyrus.diagram.profile.edit.parts.EnumerationEnumerationLiteralCompartmentEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.EnumerationEnumerationLiteralCompartmentEditPartCN;
import org.eclipse.papyrus.diagram.profile.edit.parts.MetaclassEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.MetaclassEditPartCN;
import org.eclipse.papyrus.diagram.profile.edit.parts.ModelPackageableElementCompartmentEditPartCN;
import org.eclipse.papyrus.diagram.profile.edit.parts.ModelPackageableElementCompartmentEditPartTN;
import org.eclipse.papyrus.diagram.profile.edit.parts.PackagePackageableElementCompartmentEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.PackagePackageableElementCompartmentEditPartCN;
import org.eclipse.papyrus.diagram.profile.edit.parts.ProfilePackageableElementCompartmentEditPartCN;
import org.eclipse.papyrus.diagram.profile.edit.parts.ProfilePackageableElementCompartmentEditPartTN;
import org.eclipse.papyrus.diagram.profile.edit.parts.StereotypeAttributeCompartmentEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.StereotypeAttributeCompartmentEditPartCN;
import org.eclipse.papyrus.diagram.profile.edit.parts.StereotypeOperationCompartmentEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.StereotypeOperationCompartmentEditPartCN;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.Profile;


/**
 * <pre>
 * This policy is used to suppress orphan node view in GMF view.
 * The policy to remove orphan connection is more complex. 
 * 
 * As this policy uses VisualID(s), this class obviously depends from
 * the diagram and may not be shared in Common plug-in.
 * 
 * See RemoveOrphanViewPolicy in Class Diagram
 * 
 * This EditPolicy have a custom method isOrphan to delete the Metaclass view if the ElementImport is deleted!
 * </pre>
 */
public class RemoveOrphanViewPolicy extends OrphanViewPolicy {

	/**
	 * the compartment editpartID
	 */
	public int[] notOrphanNode = { PackagePackageableElementCompartmentEditPart.VISUAL_ID, PackagePackageableElementCompartmentEditPartCN.VISUAL_ID, ProfilePackageableElementCompartmentEditPartCN.VISUAL_ID, ProfilePackageableElementCompartmentEditPartTN.VISUAL_ID, StereotypeAttributeCompartmentEditPart.VISUAL_ID, StereotypeAttributeCompartmentEditPartCN.VISUAL_ID, StereotypeOperationCompartmentEditPart.VISUAL_ID, StereotypeOperationCompartmentEditPartCN.VISUAL_ID, StereotypeOperationCompartmentEditPart.VISUAL_ID, ModelPackageableElementCompartmentEditPartCN.VISUAL_ID, ModelPackageableElementCompartmentEditPartTN.VISUAL_ID, EnumerationEnumerationLiteralCompartmentEditPart.VISUAL_ID, EnumerationEnumerationLiteralCompartmentEditPartCN.VISUAL_ID, DataTypeAttributeCompartmentEditPart.VISUAL_ID, DataTypeAttributeCompartmentEditPartCN.VISUAL_ID, DataTypeOperationCompartmentEditPart.VISUAL_ID, DataTypeOperationCompartmentEditPartCN.VISUAL_ID, CommentAnnotatedElementEditPart.VISUAL_ID };

	/**
	 * the metclass editpartID
	 */
	public int[] metaclassNode = { MetaclassEditPart.VISUAL_ID, MetaclassEditPartCN.VISUAL_ID };

	/** array list of visual id that correspond to views that are not linked to semantic elements. For example, comment links */
	private ArrayList<Integer> metaclassNodeList = new ArrayList<Integer>();

	public RemoveOrphanViewPolicy() {
		super();
		init(notOrphanNode, metaclassNode);
	}

	/**
	 * 
	 * @param notOrphanVisualID
	 * @param metaclassNodeID
	 */
	public void init(int[] notOrphanVisualID, int[] metaclassNodeID) {
		init(notOrphanNode);
		for(int i = 0; i < metaclassNodeID.length; i++) {
			metaclassNodeList.add(new Integer(metaclassNodeID[i]));
		}
	}

	// /!\ with this method, we have big problems to make the getReparentCommand for the metaclasses

	@Override
	protected boolean isOrphaned(View view) {
		String semanticHint = view.getType();
		if((metaclassNodeList.contains(new Integer(semanticHint)))) {
			String metaclassName = null;
			EObject el = view.getElement();
			if(el != null && el instanceof Class) {
				metaclassName = ((Class)el).getName();
			}
			/**
			 * get the root profile
			 */
			Profile rootProfile = DiagramHelper.getTopProfile(view);
			EList<ElementImport> importedElement = rootProfile.getElementImports();
			for(ElementImport elementImport : importedElement) {
				if(elementImport.getAlias().equals(metaclassName)) {
					return false;
				}
			}
			return true;
		}

		return super.isOrphaned(view);
	}


}
