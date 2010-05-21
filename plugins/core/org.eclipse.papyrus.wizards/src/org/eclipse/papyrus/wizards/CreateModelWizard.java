/*******************************************************************************
 * Copyright (c) 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.wizards;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.papyrus.core.extension.commands.ICreationCommand;
import org.eclipse.papyrus.core.utils.DiResourceSet;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.core.utils.PapyrusTrace;
import org.eclipse.papyrus.resource.uml.UmlModel;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;

/**
 * Create new model file and initialize a selected diagram. This wizard create
 * several files : *.di : the DI file to store Di diagrams and references all
 * external diagrams like GMF diagrams. *.notation : the file to store pure GMF
 * diagrams *.uml : the standard UML file to store UML semantics elements.
 * (Model, Package, Class,...)
 * 
 * Those files can be used with the PapyrusEditor (see plugin.xml).
 * 
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public abstract class CreateModelWizard extends Wizard implements INewWizard {

	/** New model file page for the file */
	private NewModelFilePage newModelFilePage;

	/** Select kind of new diagram the wizard must create */
	private SelectDiagramKindPage selectDiagramKindPage;

	/** Select the root element containing the new diagram */
	private SelectRootElementPage selectRootElementPage;

	// fjcano #293135 :: support model templates
	/** Select a template to initialize the model with */
	private SelectTemplateWizardPage selectTemplateWizardPage;

	/** Current workbench */
	private IWorkbench workbench;

	/**
	 * The URI of the selected domain model. Do not create a new uml model, but
	 * use the selected
	 */
	private URI domainModelURI;

	/**
	 * ResourceSet used to link all Resource (Model and DI)
	 */
	private DiResourceSet diResourceSet;

	public CreateModelWizard() {
		this(null);
	}

	public CreateModelWizard(URI domainModelURI) {
		super();
		setWindowTitle("New Papyrus Model");
		this.domainModelURI = domainModelURI;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addPages() {
		addPage(newModelFilePage);
		// fjcano #293135 :: support model templates
		addPage(selectTemplateWizardPage);
		addPage(selectDiagramKindPage);
		if(domainModelURI != null) {
			addPage(selectRootElementPage);
		}
	}

	/**
	 * Initializes this creation wizard using the passed workbench and object
	 * selection.
	 * <p>
	 * This method is called after the no argument constructor and before other methods are called.
	 * </p>
	 * 
	 * @param workbench
	 *        the current workbench
	 * @param selection
	 *        the current object selection
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.diResourceSet = new DiResourceSet();
		IFile file = getSelectedFile(selection);
		// builds a new Papyrus Model for an existing domain model
		if(isSupportedDomainModelFile(file)) {
			this.domainModelURI = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
			this.newModelFilePage = new NewModelFilePage("Create a new Papyrus model", "Create a new Papyrus model from an existing semantic model", selection, true);
			this.newModelFilePage.setFileName(getDiagramFileName(file));

			// I don't understand a need to load the model during initialization, 
			// I rather expect it to be loaded when wizard is finished and executed or
			// when the page that needs the model is initialized 
			Resource resource = diResourceSet.loadModelResource(file);

			EObject diagramRoot = resource.getContents().get(0);
			this.selectRootElementPage = new SelectRootElementPage("Select the root element", diagramRoot);
		}
		if(domainModelURI == null) {
			this.newModelFilePage = new NewModelFilePage("Create a new Papyrus model", "Create a new empty Papyrus model", selection, false);
		}
		selectDiagramKindPage = new SelectDiagramKindPage("Select kind of diagram");
		// fjcano #293135 :: support model templates
		selectTemplateWizardPage = new SelectTemplateWizardPage(Activator.PLUGIN_ID, null, null);
	}
	
	/**
	 * Suggests a name of diagram file for the domain model file 
	 */
	protected String getDiagramFileName(IFile domainModel) {
		String diModelFileName = (domainModel.getLocation().removeFileExtension().lastSegment());
		diModelFileName += ".di";
		return diModelFileName;
	}

	/**
	 * Returns the first file from the given selection 
	 */
	private IFile getSelectedFile(IStructuredSelection selection) {
		if(selection != null && !selection.isEmpty() && selection.getFirstElement() instanceof IFile) {
			return (IFile)selection.getFirstElement();
		}
		return null;
	}

	/**
	 * Returns true is the file can be served as a model model for the diagram
	 */
	protected boolean isSupportedDomainModelFile(IFile file) {
		return file != null && getModelFileExtension().equals(file.getFileExtension());
	}


	/**
	 * This method will be invoked, when the "Finish" button is pressed.
	 * 
	 * @return <code>true</code> if everything runs without problems, <code>false</code> if an exception must be caught.
	 * 
	 */
	@Override
	public boolean performFinish() {
		try {
			// create a new file, result != null if successful
			final IFile newFile = newModelFilePage.createNewFile();

			RecordingCommand command = new RecordingCommand(diResourceSet.getTransactionalEditingDomain()) {

				@Override
				protected void doExecute() {
					// Create Model Resource, Notation Resource, DI Resource
					diResourceSet.createModelResources(newFile, getModelContentType(), getModelFileExtension());

					// Initialize Model Resource
					Resource modelResource = diResourceSet.getModelResource();
					if(modelResource != null) {
						IPath path = new Path(newFile.getName());
						initializeModelResource(modelResource, path.removeFileExtension().toString());
					}
				}
			};
			diResourceSet.getTransactionalEditingDomain().getCommandStack().execute(command);

			// WorkspaceModifyOperation operation = new
			// WorkspaceModifyOperation() {
			// @Override
			// protected void execute(IProgressMonitor progressMonitor) {
			//			
			// }
			// };
			//		
			// getContainer().run(false, false, operation);

			// open newly created file in the editor
			IWorkbenchPage page = workbench.getActiveWorkbenchWindow().getActivePage();
			if((newFile != null) && (page != null)) {

				String diagramName = selectDiagramKindPage.getDiagramName();
				ICreationCommand creationCommand = selectDiagramKindPage.getCreationCommand();

				if(creationCommand == null) {
					// Create an empty editor (no diagrams opened)
					// Geting an IPageMngr is enough to initialize the
					// SashSystem.
					EditorUtils.getTransactionalIPageMngr(diResourceSet.getDiResource(), diResourceSet.getTransactionalEditingDomain());
				} else {
					EObject root = domainModelURI != null ? selectRootElementPage.getModelElement() : null;
					creationCommand.createDiagram(diResourceSet, root, diagramName);
				}
				try {
					diResourceSet.save(new NullProgressMonitor());
				} catch (IOException e) {
					PapyrusTrace.log(e);
					return false;
				}

				try {
					IDE.openEditor(page, newFile, true);
				} catch (PartInitException e) {
					PapyrusTrace.log(e);
					return false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	protected abstract String getModelContentType();

	protected abstract String getModelFileExtension();

	// fjcano #293135 :: support model templates
	private void initializeModelResource(Resource resource, String rootElementName) {
		String templatePath = selectTemplateWizardPage.getTemplatePath();
		boolean initializeFromTemplate = templatePath != null;
		if(initializeFromTemplate) {
			initializeFromTemplate(resource, rootElementName, templatePath);
		} else {
			initializeEmptyModel(resource, rootElementName);
		}
	}

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

	protected void initializeEmptyModel(Resource resource, String rootElementName) {
	}

	private Resource loadTemplateResource(String templatePath) {
		String templatePluginID = selectTemplateWizardPage.getTemplatePluginId();
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
