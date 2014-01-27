/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.facadeSpecificEditor.utils;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualClassifier;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualElement;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetaclass;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetamodel;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualTypedElement;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualmetamodelPackage;
import org.eclipse.papyrus.facadeSpecificEditor.metamodel.MetamodelUtils;
import org.eclipse.swt.widgets.Display;

public class PrunerUtils {

	//	protected static VirtualElement findVirtualElement(EObject element, VirtualMetamodel metamodel) {
	//		TreeIterator<EObject> it = metamodel.eAllContents();
	//
	//		while(it.hasNext()) {
	//			EObject eObject = (EObject)it.next();
	//			if(eObject instanceof VirtualElement) {
	//				if(((VirtualElement)eObject).getRepresentedElement() == element) {
	//					return (VirtualElement)eObject;
	//				}
	//			}
	//		}
	//		return null;
	//	}

	//	protected static boolean isUsed(VirtualClassifier classifier, VirtualMetamodel metamodel) {
	//
	//		TreeIterator<EObject> it = metamodel.eAllContents();
	//
	//		while(it.hasNext()) {
	//			EObject element = (EObject)it.next();
	//			if(element != classifier) {
	//				//VirtualMetclass of type of the property must be not kept
	//				if(element instanceof VirtualProperty) {
	//					if(((VirtualProperty)element).isKept()) {
	//
	//						if(((VirtualProperty)element).getRepresentedElement() instanceof Property) {
	//							Type typeOfTheProperty = ((Property)((VirtualProperty)element).getRepresentedElement()).getType();
	//
	//							if(findVirtualElement(typeOfTheProperty, metamodel).isKept()) {
	//
	//							}
	//
	//						} else if(((VirtualProperty)element).getRepresentedElement() instanceof EStructuralFeature) {
	//							EClassifier typeOfTheProperty = ((EStructuralFeature)((VirtualProperty)element).getRepresentedElement()).getEType();
	//						} else {
	//							org.eclipse.papyrus.facadeSpecificEditor.FacadeDefinitionEditorActivator.log.info("The kind of the property is unknown: " + element);
	//						}
	//					}
	//
	//				}
	//
	//			}
	//
	//		}
	//
	//		return true;
	//	}

	public static boolean classifierUnkeep(VirtualElement element, VirtualMetamodel metamodel, EditingDomain editingDomain) {
		List<EObject> typedElementToUnkeep = new ArrayList<EObject>();

		if(element instanceof VirtualClassifier) {
			List<VirtualMetaclass> children = MetamodelUtils.getChildren((VirtualMetaclass)element);

			for(VirtualMetaclass child : children) {
				if(classifierUnkeep(child, metamodel, editingDomain) == false) {
					return false;
				}
			}

			TreeIterator<EObject> it = metamodel.eAllContents();

			while(it.hasNext()) {
				EObject metamodelElement = (EObject)it.next();
				if(metamodelElement != element) {
					//VirtualMetclass of type of the property must be not kept
					if(metamodelElement instanceof VirtualTypedElement) {
						if(((VirtualTypedElement)metamodelElement).isKept()) {

							if(((VirtualTypedElement)metamodelElement).getType() == element) {
								if(((VirtualTypedElement)metamodelElement).getLower() > 0) {
									MessageDialog.openWarning(Display.getCurrent().getActiveShell(), "Cannot unkeep this element", "This element cannot be unkept because it is used by : " + ((VirtualTypedElement)metamodelElement).getAliasName());
									return false;
								}

								typedElementToUnkeep.add(metamodelElement);
							}
						}
					}
				}
			}
		}

		for(EObject eObject : typedElementToUnkeep) {
			SetCommand command = new SetCommand(editingDomain, (VirtualElement)eObject, VirtualmetamodelPackage.eINSTANCE.getVirtualElement_Kept(), false); //$NON-NLS-1$
			editingDomain.getCommandStack().execute(command);
		}

		SetCommand command = new SetCommand(editingDomain, (VirtualElement)element, VirtualmetamodelPackage.eINSTANCE.getVirtualElement_Kept(), false); //$NON-NLS-1$
		editingDomain.getCommandStack().execute(command);

		return true;
	}

}
