/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia Dhouib (CEA LIST) saadia.dhouib@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.robotml.deployment.handlers;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.papyrus.RobotML.Platform;
import org.eclipse.papyrus.robotml.deployment.CommandSupport;
import org.eclipse.papyrus.robotml.deployment.DepCreation;
import org.eclipse.papyrus.robotml.deployment.TransformationException;
import org.eclipse.papyrus.robotml.deployment.Utils;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.util.UMLUtil;

public class CreatePlatformHandler extends CmdHandler {

	private Package platform;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEnabled() {
		updateSelectedEObject();
		EObject selectedObj = getSelectedEObject();
		if(selectedObj instanceof Class && isPlatform((Class)selectedObj)) {
			return true;
		}
		return false;
	}

	private boolean isPlatform(Class elt){
		Platform platform = UMLUtil.getStereotypeApplication((Class)elt, Platform.class);
		if (platform != null){
			return true;
		}
		return false;
		
		
	}
	/**
	 * {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) {
		if(!(getSelectedEObject() instanceof Class)) {
			return null;
		}
		final Class selectedComposite = (Class)getSelectedEObject();

		CommandSupport.exec("Create platform model", new Runnable() {

			public void run() {
				// execute with transaction support
				platform = Utils.getRoot(selectedComposite, "PlatformModel");
			}
		});

		final String newPlatform = selectedComposite.getName() + "Platform";

		try {
			if(platform.getMember(newPlatform) != null) {
				Shell shell = new Shell();
				MessageDialog.openInformation(shell, "Error",
					"Platform definition \"" + newPlatform + "\" exists already");
			} else {
				CommandSupport.exec("Create platform definition", new Runnable() {

					public void run() {
						Package platformPkg = platform.createNestedPackage(newPlatform);
						try {
							DepCreation.createPlatformInstances(platformPkg, selectedComposite, null);
						}
						catch (TransformationException e) {
							System.err.println(e);
						}
					}
				});
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
