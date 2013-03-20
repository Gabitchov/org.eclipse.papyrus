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

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.resource.IModelSetSnippet;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.NotFoundException;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForResourceSet;
import org.eclipse.papyrus.uml.profile.Activator;
import org.eclipse.papyrus.uml.tools.commands.ApplyProfileCommand;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
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
		try {
			//FIXME: The ServiceUtilsForResourceSet initializer service is not started yet. We can't access the ServicesRegistry.
			IMultiDiagramEditor editor = ServiceUtilsForResourceSet.getInstance().getService(IMultiDiagramEditor.class, modelsManager);
			if(editor == null) {
				return; //Do not popup a dialog when there is no Editor
			}
		} catch (ServiceException ex) {
			//return;
		}

		UmlModel umlModel = (UmlModel)modelsManager.getModel(UmlModel.MODEL_ID);
		if(umlModel == null) {
			return;
		}

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
			//Ignore the exception: On diagram creation, the root isn't defined yet. 
			//There's not profile application, and nothing to do.
			//Activator.log.error(ex);
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
				EditingDomain domain = EMFHelper.resolveEditingDomain(rootPackage);

				if(domain instanceof TransactionalEditingDomain) {
					CompoundCommand command = new CompoundCommand();

					for(Map.Entry<Package, Collection<Profile>> profiles : profilesToReapply.entrySet()) {
						command.append(new ApplyProfileCommand(profiles.getKey(), profiles.getValue(), (TransactionalEditingDomain)domain));
					}

					domain.getCommandStack().execute(command);
				} else {
					Activator.log.error(new IllegalArgumentException("Cannot reapply profiles on Package " + rootPackage.getQualifiedName() + ". The EditingDomain cannot be found"));
				}

			}

		};
	}

	public void dispose(ModelSet modelsManager) {
		rootPackage = null;
	}

}
