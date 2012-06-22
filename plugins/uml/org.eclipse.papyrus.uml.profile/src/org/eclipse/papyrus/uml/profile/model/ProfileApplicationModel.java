/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.profile.model;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.core.resource.IModelSetSnippet;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.NotFoundException;
import org.eclipse.papyrus.infra.core.resource.uml.UmlModel;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.uml.profile.Activator;
import org.eclipse.papyrus.uml.tools.commands.ApplyProfileCommand;
import org.eclipse.papyrus.uml.tools.utils.ProfileUtil;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;

/**
 * If a local profile is applied on this model, and this profile has been
 * redefined recently, the user will be asked whether the profile should
 * be reapplied.
 * 
 * 
 * @author Camille Letavernier
 * 
 */
public class ProfileApplicationModel implements IModelSetSnippet {

	protected Package rootPackage;

	public void start(ModelSet modelsManager) {
		UmlModel umlModel = (UmlModel)modelsManager.getModel(UmlModel.MODEL_ID);

		rootPackage = getRootPackage(umlModel);

		if(rootPackage == null) {
			return;
		}

		checkAndRefreshProfiles(rootPackage);
	}

	protected Package getRootPackage(UmlModel umlModel) {
		try {
			EObject root = umlModel.lookupRoot();
			if(root instanceof Package) {
				return (Package)root;
			}
		} catch (NotFoundException ex) {
			Activator.log.error(ex);
		}
		return null;
	}

	protected boolean checkAndRefreshProfiles(Package currentPackage) {
		for(Profile profile : currentPackage.getAppliedProfiles()) {
			if(ProfileUtil.isDirty(currentPackage, profile)) {
				RefreshProfileDialog dialog = new RefreshProfileDialog(Display.getCurrent().getActiveShell(), this.rootPackage);
				dialog.setCallback(getCallback(dialog));
				dialog.open();
				return true;
			}
		}

		for(Package nestedPackage : currentPackage.getNestedPackages()) {
			if(checkAndRefreshProfiles(nestedPackage)) {
				return true;
			}
		}

		return false;
	}

	protected Runnable getCallback(final RefreshProfileDialog dialog) {
		return new Runnable() {

			public void run() {
				Map<Package, Collection<Profile>> profilesToReapply = dialog.getProfilesToReapply();
				for(Map.Entry<Package, Collection<Profile>> profiles : profilesToReapply.entrySet()) {
					ApplyProfileCommand command = new ApplyProfileCommand(profiles.getKey(), profiles.getValue());
					EditingDomain domain = EMFHelper.resolveEditingDomain(rootPackage);
					domain.getCommandStack().execute(command);
				}
			}

		};
	}

	public void dispose(ModelSet modelsManager) {
		rootPackage = null;
	}

}
