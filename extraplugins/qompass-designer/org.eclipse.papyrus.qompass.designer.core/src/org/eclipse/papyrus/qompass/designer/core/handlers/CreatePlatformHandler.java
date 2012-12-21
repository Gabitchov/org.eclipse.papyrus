package org.eclipse.papyrus.qompass.designer.core.handlers;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Package;

import org.eclipse.papyrus.qompass.designer.core.CommandSupport;
import org.eclipse.papyrus.qompass.designer.core.Utils;
import org.eclipse.papyrus.qompass.designer.core.deployment.DepCreation;
import org.eclipse.papyrus.qompass.designer.core.transformations.TransformationException;

public class CreatePlatformHandler extends CmdHandler {

	private Package platform;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEnabled() {
		updateSelectedEObject();
		EObject selectedObj = getSelectedEObject();
		if(selectedObj instanceof Class) {
			return true;
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
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
