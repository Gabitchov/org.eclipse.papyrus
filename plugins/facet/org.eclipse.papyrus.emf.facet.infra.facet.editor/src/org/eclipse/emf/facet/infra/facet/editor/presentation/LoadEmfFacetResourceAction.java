/*******************************************************************************
 * Copyright (c) 2009 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Gregoire DUPE (Mia-Software) - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.facet.infra.facet.editor.presentation;

import java.util.Arrays;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.presentation.EcoreEditorPlugin;
import org.eclipse.emf.ecore.provider.EcoreEditPlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.ui.action.LoadResourceAction;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.emf.facet.infra.common.ui.internal.dialogs.GetEmfFacetResourceDialog;
import org.eclipse.emf.facet.infra.facet.editor.Messages;
import org.eclipse.emf.facet.infra.query.core.ModelQuerySetCatalog;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

/**
 * @author Grégoire Dupé
 * 
 */
public class LoadEmfFacetResourceAction extends LoadResourceAction {

	public LoadEmfFacetResourceAction() {
		super();
		setText(Messages.LoadEmfFacetResourceAction_0);
	}

	@Override
	public void run() {
		// initialize query catalog
		ModelQuerySetCatalog.getSingleton();

		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getShell();

		GetEmfFacetResourceDialog dialog = new GetEmfFacetResourceDialog(
				shell);
		dialog.open();
		Object[] results = dialog.getResult();
		// if user cancel the selection of meta models, results = null
		if (results != null) {
			ResourceSet resourceSet = this.domain.getResourceSet();
			for (Object result : results) {
				if (result instanceof EObject) {
					EObject eObject = (EObject) result;
					URI uri = eObject.eResource().getURI();
					Resource r = resourceSet.getResource(uri, true);
					if (!resourceSet.getResources().contains(r)) {
						Registry packageRegistry = resourceSet
								.getPackageRegistry();
						for (EObject eObject2 : r.getContents()) {
							if (eObject2 instanceof EPackage) {
								EPackage ePackage = (EPackage) eObject2;
								packageRegistry.put(ePackage.getNsURI(),
										ePackage);
							}
						}
						resourceSet.getResources().add(r);
					}
				}

			}
		}
	}

	public class RegisteredPackageDialog2 extends ElementListSelectionDialog {

		public RegisteredPackageDialog2(final Shell parent) {
			super(parent, new LabelProvider() {
				@Override
				public Image getImage(final Object element) {
					return ExtendedImageRegistry.getInstance().getImage(
							EcoreEditPlugin.INSTANCE
									.getImage("full/obj16/EPackage")); //$NON-NLS-1$
				}
			});

			setMultipleSelection(true);
			setMessage(EcoreEditorPlugin.INSTANCE
					.getString("_UI_SelectRegisteredPackageURI")); //$NON-NLS-1$
			setFilter("*"); //$NON-NLS-1$
			setTitle(EcoreEditorPlugin.INSTANCE
					.getString("_UI_PackageSelection_label")); //$NON-NLS-1$
			Object[] result = EPackage.Registry.INSTANCE.keySet().toArray(
					new Object[EPackage.Registry.INSTANCE.size()]);
			Arrays.sort(result);
			setElements(result);
		}
	}

}
