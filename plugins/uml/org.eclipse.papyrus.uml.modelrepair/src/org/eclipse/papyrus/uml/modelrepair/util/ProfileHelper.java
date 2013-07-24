package org.eclipse.papyrus.uml.modelrepair.util;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;


public class ProfileHelper {

	public static Collection<Profile> getAllAppliedProfiles(ModelSet modelSet) {
		UmlModel umlModel = (UmlModel)modelSet.getModel(UmlModel.MODEL_ID);

		if(umlModel != null) {
			Resource mainUMLResource = umlModel.getResource();

			final Set<Profile> allAppliedProfiles = new HashSet<Profile>();

			Iterator<EObject> allContents = mainUMLResource.getAllContents();

			while(allContents.hasNext()) {
				EObject currentElement = allContents.next();
				if(currentElement instanceof Package) {
					Package currentPackage = (Package)currentElement;
					allAppliedProfiles.addAll(currentPackage.getAppliedProfiles());
				}
			}
			return allAppliedProfiles;
		}

		return Collections.emptySet();
	}
}
