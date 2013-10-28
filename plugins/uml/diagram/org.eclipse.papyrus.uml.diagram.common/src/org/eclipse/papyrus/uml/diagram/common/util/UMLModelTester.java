/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.util;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.NotFoundException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;

/**
 * 
 * @author Camille Letavernier
 * 
 */
public class UMLModelTester extends PropertyTester {

	/** Tester ID for UML Model nature */
	public final static String IS_UML_MODEL = "isUMLModel";

	/** Tester ID for UML Profile nature */
	public final static String IS_UML_PROFILE = "isUMLProfile";

	/** Test the receiver against the selected property */
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		Object currentValue = null;
		if(IS_UML_MODEL.equals(property)) {
			currentValue = testUMLModelNature(receiver);
			return (currentValue == expectedValue);
		} else if(IS_UML_PROFILE.equals(property)) {
			currentValue = testUMLProfileNature(receiver);
			return (currentValue == expectedValue);
		}

		return false;
	}

	/** True if root object is a UML Model */
	protected boolean testUMLModelNature(Object receiver) {
		EObject root = getRoot(receiver);

		/*
		 * For controlled resources, it is very important to consider root of UML model can be a Package. Of course, we
		 * can still exclude Profile, which should be dedicated to profile diagrams.
		 */
		return root instanceof Package && !(root instanceof Profile);
	}

	/** True if root object is a UML Profile */
	protected boolean testUMLProfileNature(Object receiver) {
		return (getRoot(receiver) instanceof Profile);
	}

	private EObject getRoot(Object receiver) {
		ModelSet modelSet = getModelSet(receiver);
		return getRoot(modelSet);
	}

	private ModelSet getModelSet(Object receiver) {
		if(receiver instanceof IWorkbenchPart) {
			try {

				/* First, retrieve the ModelSet from the Active Part (e.g. ActiveEditor, ModelExplorer, ...) */
				IWorkbenchPart currentPart = (IWorkbenchPart)receiver;
				ServicesRegistry servicesRegistry = (ServicesRegistry)currentPart.getAdapter(ServicesRegistry.class);

				if(servicesRegistry != null) {
					return ServiceUtils.getInstance().getModelSet(servicesRegistry);
				}

				/* If not found, retrieve the ModelSet from the Active Editor */

				IEditorPart activeEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
				servicesRegistry = (ServicesRegistry)activeEditor.getAdapter(ServicesRegistry.class);

				if(servicesRegistry != null) {
					return ServiceUtils.getInstance().getModelSet(servicesRegistry);
				}

			} catch (Exception ex) {
				return null; //NPE (getActiveEditor) or ServiceException (Service registry cannot be found). In both cases, we just don't handle the event. Fail silently.
			}
		}

		return null;
	}

	/** Returns the root EObject of currently opened model */
	private EObject getRoot(ModelSet modelSet) {
		UmlModel openedModel = (UmlModel)modelSet.getModel(UmlModel.MODEL_ID);
		if(openedModel != null) {
			EObject root;
			try {
				root = openedModel.lookupRoot();
			} catch (NotFoundException e) {
				return null;
			}
			return root;
		}

		return null;
	}

}
