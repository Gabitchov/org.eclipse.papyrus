/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	Gabriel Pascual (ALL4TEC) gabriel.pascual@all4tec.net - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.css.property;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.Activator;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.ModelStyleSheets;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.impl.StylesheetsFactoryImpl;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbenchPropertyPage;
import org.eclipse.ui.dialogs.PropertyPage;



/**
 * Preference page to associate set of style sheets to Papyrus project.
 * <p>
 * The preference is stored in a file with EMF format. The target is file .settings/stylesheets.xmi
 * </p>
 *
 * @author gpascual
 */
public class StyleSheetsPropertyPage extends PropertyPage implements IWorkbenchPropertyPage {

	private Resource resource;

	/**
	 * Default Constructor.
	 *
	 */
	public StyleSheetsPropertyPage() {
		//This preference is stored with EMF format : .settings/stylesheets.xmi
		setPreferenceStore(null);
	}




	/**
	 * Get Style sheets model file to manage preference.
	 * 
	 * @return a new style sheets model or the exiting one
	 */
	private ModelStyleSheets getProjectStylesheets() {
		//Get selected project
		Object pageElement = getElement().getAdapter(IProject.class);

		//Initialize preferences data
		ResourceSet resourceSet = new ResourceSetImpl();
		ModelStyleSheets rootModel = null;

		//Check if element is a project
		if(pageElement instanceof IProject) {
			// Build path of preference file
			ProjectScope pageProject = new ProjectScope((IProject)pageElement);
			IPath preferencePath = pageProject.getLocation().append("stylesheets.xmi");

			// Check path is valid
			if(preferencePath != null) {

				// Verify presence of file in project
				IPath projectRelativePath = preferencePath.makeRelativeTo(((IProject)pageElement).getLocation());
				IFile preferenceFile = ((IProject)pageElement).getFile(projectRelativePath);
				if(preferenceFile.exists()) {

					//Load existing preference file
					resource = resourceSet.getResource(URI.createURI(preferenceFile.getFullPath().toOSString()), true);
					EList<EObject> resourceContents = resource.getContents();
					if(!resourceContents.isEmpty() && resourceContents.get(0) instanceof ModelStyleSheets) {
						rootModel = (ModelStyleSheets)resourceContents.get(0);
					}

				} else {

					//Create default preference file
					resource = resourceSet.createResource(URI.createPlatformResourceURI(preferenceFile.getFullPath().toOSString(), true));
					rootModel = StylesheetsFactoryImpl.eINSTANCE.createModelStyleSheets();
					resource.getContents().add(rootModel);

				}
			}
		}

		return rootModel;
	}

	/**
	 * 
	 * @see org.eclipse.jface.preference.PreferencePage#createContents(org.eclipse.swt.widgets.Composite)
	 *
	 * @param parent
	 * @return
	 */
	@Override
	protected Control createContents(Composite parent) {
		getProjectStylesheets();
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.jface.preference.PreferencePage#performOk()
	 *
	 * @return
	 */
	@Override
	public boolean performOk() {
		boolean performOK = false;

		try {
			// Save preference file
			resource.save(Collections.EMPTY_MAP);
			performOK = true;
		} catch (IOException e) {
			Activator.log.error(e);
		}

		return performOK;
	}

}
