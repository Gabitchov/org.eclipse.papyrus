/*******************************************************************************
 * Copyright (c) 2009 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana .
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Francisco Javier Cano Muñoz (Prodevelop) - initial API implementation
 * Tatiana Fesenko((CEA LIST) - [314614] [Wizard] Add SelectDiagramCategory Wizard page) 
 *
 ******************************************************************************/
package org.eclipse.papyrus.wizards;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.papyrus.core.utils.DiResourceSet;
import org.eclipse.papyrus.resource.IModel;
import org.eclipse.papyrus.resource.notation.NotationModel;
import org.eclipse.papyrus.resource.sasheditor.DiModel;
import org.eclipse.papyrus.resource.uml.UmlModel;
import org.eclipse.papyrus.wizards.template.SelectModelTemplateComposite;
import org.eclipse.swt.widgets.Composite;

/**
 * A wizard page that allows the selection of template models contributed via an
 * extension point.
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 * @see <a href="https://bugs.eclipse.org/bugs/show_bug.cgi?id=293135">Bug #293135</a>
 * 
 */
public class SelectTemplateWizardPage extends WizardPage {

	/** The select template composite. */
	private SelectModelTemplateComposite selectTemplateComposite;

	/**
	 * Instantiates a new select template wizard page.
	 *
	 * @param pageName the page name
	 */
	protected SelectTemplateWizardPage(String pageName) {
		super(pageName);
	}

	/**
	 * Instantiates a new select template wizard page.
	 *
	 * @param editorId the editor id
	 * @param nextPage the next page
	 * @param templatePage the template page
	 */
	public SelectTemplateWizardPage(String editorId, WizardPage nextPage, WizardPage templatePage) {
		super("Select creation approach");
		this.setTitle("Select creation approach");
		this.setDescription("Diagrams can be created from scratch or from a template");
	}


	/**
	 * @see org.eclipse.jface.dialogs.DialogPage#setVisible(boolean)
	 *
	 * @param visible
	 */
	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		selectTemplateComposite.setInput(getDiagramCategory());
	}
	
	/**
	 * Gets the diagram category.
	 * 
	 * @return the diagram category
	 */
	private String getDiagramCategory() {
		IWizardPage previousPage = getPreviousPage();
		if(previousPage == null || false == previousPage instanceof SelectDiagramCategoryPage) {
			return null;
		}
		return ((SelectDiagramCategoryPage)previousPage).getDiagramCategory();
	}

	/**
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 *
	 * @param parent
	 */
	public void createControl(Composite parent) {
		selectTemplateComposite = new SelectModelTemplateComposite(parent);
		setControl(selectTemplateComposite);
	}


	/**
	 * Initialize model resource.
	 *
	 * @param diResourceSet the di resource set
	 * @param newFile the new file
	 * @param root the root
	 * @param modelContentType the model content type
	 * @param modelFileExtension the model file extension
	 */
	public void initializeModelResource(final DiResourceSet diResourceSet, final IFile newFile, final EObject root, final String modelContentType, final String modelFileExtension) {
		RecordingCommand command = new RecordingCommand(diResourceSet.getTransactionalEditingDomain()) {

			@Override
			protected void doExecute() {

				if(root != null) {
					IPath filenameWithoutExtension = newFile.getFullPath().removeFileExtension();

					IModel model = diResourceSet.getModel(DiModel.MODEL_ID);
					model.createModel(filenameWithoutExtension);
					model = diResourceSet.getModel(NotationModel.MODEL_ID);
					model.createModel(filenameWithoutExtension);
					// START OF WORKAROUND for #315083 
					IModel umlModel = new UmlModel() {
						public void createModel(IPath fullPath) {
							try {
								resourceURI = root.eResource().getURI();
								// as resource already exists, use rs.getResource() not rs.createResource() here
								resource = getResourceSet().getResource(resourceURI, true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						};
					};
					diResourceSet.registerModel(umlModel);
					umlModel.createModel(null);

					//					// call snippets to allow them to do their stuff
					//					snippets.performStart(this);
					// END OF WORKAROUND for #315083 
				} else {
					
					// Create Model Resource, Notation Resource, DI Resource
					diResourceSet.createsModels(newFile);


					// Initialize Model Resource
					Resource modelResource = diResourceSet.getModelResource();
					if(modelResource != null) {
						IPath path = new Path(newFile.getName());
						initializeModelResource(modelResource, path.removeFileExtension().toString());
					}
				}
			}
		};
		diResourceSet.getTransactionalEditingDomain().getCommandStack().execute(command);

	}

	/**
	 * Initialize model resource.
	 * 
	 * @param resource
	 *        the resource
	 * @param rootElementName
	 *        the root element name
	 */
	protected void initializeModelResource(Resource resource, String rootElementName) {
		String templatePath = selectTemplateComposite.getTemplatePath();
		boolean initializeFromTemplate = templatePath != null;
		if(initializeFromTemplate) {
			initializeFromTemplate(resource, rootElementName, templatePath);
		} else {
			initializeEmptyModel(resource, rootElementName);
		}
	}

	/**
	 * Initialize from template.
	 * 
	 * @param resource
	 *        the resource
	 * @param rootElementName
	 *        the root element name
	 * @param templatePath
	 *        the template path
	 */
	protected void initializeFromTemplate(Resource resource, String rootElementName, String templatePath) {
		Resource templateResource = loadTemplateResource(templatePath);
		List<EObject> eObjectsToAdd = new ArrayList<EObject>();
		for(EObject eObject : templateResource.getContents()) {
			eObjectsToAdd.add(EcoreUtil.copy(eObject));
		}
		for(EObject eObject : eObjectsToAdd) {
			resource.getContents().add(eObject);
		}
	}

	/**
	 * Initialize empty model.
	 * 
	 * @param resource
	 *        the resource
	 * @param rootElementName
	 *        the root element name
	 */
	protected void initializeEmptyModel(Resource resource, String rootElementName) {
	}

	/**
	 * Load template resource.
	 * 
	 * @param templatePath
	 *        the template path
	 * @return the resource
	 */
	private Resource loadTemplateResource(String templatePath) {
		String templatePluginID = selectTemplateComposite.getTemplatePluginId();
		java.net.URL templateURL = Platform.getBundle(templatePluginID).getResource(templatePath);
		String fullUri = templateURL.getPath();
		URI uri = URI.createPlatformPluginURI(templatePluginID + fullUri, true);
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.getResource(uri, true);
		if(resource.isLoaded()) {
			return resource;
		}
		return null;
	}

}
