/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.customization.properties.generation.wizard;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.WizardPage;

/**
 * An abstract WizardPage for the CreateContext wizard, providing helper
 * methods to its implementers
 * 
 * @author Camille Letavernier
 */
public abstract class AbstractCreateContextPage extends WizardPage {

	/**
	 * Builds a new WizardPage with the given pageName
	 * Constructor.
	 * 
	 * @param pageName
	 *        The name of this wizard page
	 */
	public AbstractCreateContextPage(String pageName) {
		super(pageName);
	}

	/**
	 * 
	 * Builds a new WizardPage with the given pageName, title and image
	 * 
	 * @param pageName
	 *        the name of the page
	 * @param title
	 *        the title for this wizard page, or <code>null</code> if none
	 * @param titleImage
	 *        the image descriptor for the title of this wizard page,
	 *        or <code>null</code> if none
	 */
	public AbstractCreateContextPage(String pageName, String title, ImageDescriptor titleImage) {
		super(pageName, title, titleImage);
	}

	@Override
	public CreateContextWizard getWizard() {
		return (CreateContextWizard)super.getWizard();
	}

}
