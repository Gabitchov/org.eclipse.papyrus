/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.tabbed.customization.dialog;

import java.io.File;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.papyrus.properties.tabbed.customization.Activator;
import org.w3c.dom.Document;


/**
 * Wizard for Property View Customization
 */
public class CustomizePropertyViewWizard extends Wizard {

	/** page to select the xml file to edit */
	protected SelectConfigurationFileWizardPage selectXmlFilePage = new SelectConfigurationFileWizardPage();

	/** Customize the content of the page */
	protected CustomizeContentWizardPage customizeContentPage = new CustomizeContentWizardPage();

	/**
	 * Creates a new CustomizePropertyViewWizard.
	 * 
	 */
	public CustomizePropertyViewWizard() {
		setDialogSettings(Activator.getDefault().getDialogSettings());
		setNeedsProgressMonitor(true);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addPages() {
		addPage(selectXmlFilePage);
		addPage(customizeContentPage);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean performFinish() {
		final Document document = customizeContentPage.getFinalContent();
		final File file = ResourcesPlugin.getWorkspace().getRoot().getRawLocation().append("test.xml").toFile();
		Job job = new Job("Saving XML File") {

			/**
			 * {@inheritDoc}
			 */
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				try {
					TransformerFactory factory = TransformerFactory.newInstance();
					Transformer transformer = factory.newTransformer();

					Source source = new DOMSource(document);
					Result result = new StreamResult(file);

					transformer.transform(source, result);
					return Status.OK_STATUS;
				} catch (TransformerException e) {
					Activator.log.error(e);
					return new Status(Status.ERROR, Activator.PLUGIN_ID, e.getLocalizedMessage());
				}

			}
		};
		job.schedule();

		// there, the xml file should be serialized
		return true;
	}
}
