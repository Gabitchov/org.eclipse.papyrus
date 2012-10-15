/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.modelexplorer.widgets;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.ModelUtils;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.EditorUtils;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.papyrus.uml.tools.model.UmlUtils;
import org.eclipse.papyrus.views.modelexplorer.widgets.MetamodelContentProvider;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;


public class ProfileContentProvider extends MetamodelContentProvider {
	@Override
	public Object[] getElements(Object inputElement){
		Object[] parentElements = super.getElements(inputElement);

		List<Object> result = new LinkedList<Object>(Arrays.asList(parentElements));

		result.addAll(getAppliedProfile(inputElement));

		return result.toArray();
	}

	/**
	 * 
	 * @return all profile without doublon. it is never null
	 * 
	 * @throws ServiceException
	 */
	protected HashSet<Profile> getAppliedProfile(Object root) {
		HashSet<Profile> profileList = new HashSet<Profile>();
		//a root has been given.
		if(root != null && root instanceof Package) {
			profileList.addAll(((Package)root).getAllAppliedProfiles());
			return profileList;

		}
		//look for from contentprovider
		ServicesRegistry servicesRegistry = EditorUtils.getMultiDiagramEditor().getServicesRegistry();
		if(servicesRegistry != null) {
			UmlModel umlModel = null;
			try {
				ModelSet modelSet = ModelUtils.getModelSetChecked(servicesRegistry);
				umlModel = (UmlUtils.getUmlModel(modelSet));

			} catch (Exception e) {
				Activator.log.error("Cannot succeed to access to modelSet by using service Registry", e);
			}
			if(umlModel == null) {
				return profileList;
			}
			EList<EObject> contents = umlModel.getResource().getContents();
			Iterator<EObject> iterator = contents.iterator();
			while(iterator.hasNext()) {
				EObject eObject = iterator.next();
				if(eObject instanceof Package) {
					profileList.addAll(((Package)eObject).getAllAppliedProfiles());
				}
			}
		}
		return profileList;
	}
}
