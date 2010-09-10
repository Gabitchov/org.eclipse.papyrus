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
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.creation.helper;

import java.util.Collection;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.ICompositeCommand;
import org.eclipse.gmf.runtime.emf.core.util.CrossReferenceAdapter;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.uml.UMLPackage;


/**
 * this is a default Helper for UML element
 * 
 */
public class CollaborationEditHelper extends DefaultUMLHelper {

	protected ICommand getDestroyReferenceCommand(DestroyReferenceRequest req) {

		ICompositeCommand cc = new CompositeCommand("Del ref ???");

		// Role
		if(UMLPackage.eINSTANCE.getCollaboration_CollaborationRole().equals(req.getContainingFeature())) {

			ECrossReferenceAdapter crossReferencer;

			crossReferencer = CrossReferenceAdapter.getExistingCrossReferenceAdapter(req.getReferencedObject());
			if(crossReferencer == null) {
				crossReferencer = ECrossReferenceAdapter.getCrossReferenceAdapter(req.getReferencedObject());
			}
			if(crossReferencer != null) {
				Collection inverseReferences = crossReferencer.getInverseReferences(req.getReferencedObject());
				if(inverseReferences != null) {
					int size = inverseReferences.size();
					if(size > 0) {
						Setting setting;
						EReference eRef;
						Setting[] settings = (Setting[])inverseReferences.toArray(new Setting[size]);
						for(int i = 0; i < size; ++i) {


							setting = settings[i];
							eRef = (EReference)setting.getEStructuralFeature();
							if(eRef.isChangeable() && (eRef.isDerived() == false) && (eRef.isContainment() == false) && (eRef.isContainer() == false)) {

								if(setting.getEObject() instanceof View) {
									View roleView = (View)setting.getEObject();
									EAnnotation eRefInfo = roleView.getEAnnotation("EREF");
									if(eRefInfo != null) {
										EObject expectedContainer = eRefInfo.getReferences().get(0);
										EObject expectedRef = eRefInfo.getReferences().get(1);

										if((expectedRef == req.getContainingFeature()) && (expectedContainer == req.getContainer())) {
											org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand deleteRoleViewCommand = new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(req.getEditingDomain(), roleView);
											cc.add(deleteRoleViewCommand);
											cc.toString();
										}
									}



									//									Iterator<?> children = collaborationView.getChildren().iterator();
									//									while(children.hasNext()) {
									//										Object object = (Object)children.next();
									//
									//										if(object instanceof View) {
									//											View tmp = (View)object;
									//
									//											// Sub children 
									//											Iterator<?> subChildren = tmp.getChildren().iterator();
									//											while(subChildren.hasNext()) {
									//												Object subObject = (Object)subChildren.next();
									//
									//												if(subObject instanceof View) {
									//													View child = (View)subObject;
									//
									//
									//
									//													if(child.isSetElement() && (child.getElement() == req.getReferencedObject())) {
									//														org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand deleteRoleViewCommand = new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(req.getEditingDomain(), child);
									//														cc.add(deleteRoleViewCommand);
									//														cc.toString();
									//													}
									//
									//
									//												}
									//											}
									//										}
									//									}
								}

							}


						}
					}
				}

			}

		}

		cc.add(new DestroyReferenceCommand(req));
		return cc;
		//return new DestroyReferenceCommand(req);
	}
}
