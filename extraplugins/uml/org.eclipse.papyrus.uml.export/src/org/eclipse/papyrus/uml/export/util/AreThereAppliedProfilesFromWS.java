/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia DHOUIB (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.export.util;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.resource.NotFoundException;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.uml.export.Activator;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Profile;


// TODO: Auto-generated Javadoc
/**
 * The Class AreThereAppliedProfilesFromWS.
 */
public class AreThereAppliedProfilesFromWS extends PropertyTester {

	/** The Constant ARE_THERE_APPLIED_PROFILES. */
	public final static String ARE_THERE_APPLIED_PROFILES = "AreThereAppliedProfiles";



	/**
	 * @see org.eclipse.core.expressions.IPropertyTester#test(java.lang.Object, java.lang.String, java.lang.Object[], java.lang.Object)
	 * 
	 * @param receiver
	 * @param property
	 * @param args
	 * @param expectedValue
	 * @return
	 */

	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {

		// Ensure Papyrus is the active editor

		IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if((editor == null) || (!(editor instanceof IMultiDiagramEditor))) {
			return false;
		}
		Object currentValue = null;
		if(ARE_THERE_APPLIED_PROFILES.equals(property)) {

			ServicesRegistry registry = ((IMultiDiagramEditor)editor).getServicesRegistry();
			UmlModel openedModel;
			try {
				openedModel = (UmlModel)ServiceUtils.getInstance().getModelSet(registry).getModel(UmlModel.MODEL_ID);
				EObject root = openedModel.lookupRoot();
				Object[] profiles = ProfileUtil.getAppliedProfilesFromWS(root);

				for(int i = 0; i < profiles.length; i++) {
					if(profiles[i] instanceof Profile) {
						currentValue = true;
						break;
					}
				}
				return (currentValue == expectedValue);
			} catch (ServiceException e) {
				Activator.log.error(e);
			} catch (NotFoundException e) {
				Activator.log.error(e);
			}

		}

		return false;
	}



}
