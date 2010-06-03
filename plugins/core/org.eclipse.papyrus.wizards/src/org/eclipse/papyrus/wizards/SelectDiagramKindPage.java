/*******************************************************************************
 * Copyright (c) 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *     Tatiana Fesenko(CEA) - improved look&feel
 *******************************************************************************/
package org.eclipse.papyrus.wizards;

import static org.eclipse.papyrus.wizards.Activator.log;

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
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.papyrus.core.extension.NotFoundException;
import org.eclipse.papyrus.core.extension.commands.CreationCommandDescriptor;
import org.eclipse.papyrus.core.extension.commands.CreationCommandRegistry;
import org.eclipse.papyrus.core.extension.commands.ICreationCommand;
import org.eclipse.papyrus.core.extension.commands.ICreationCommandRegistry;
import org.eclipse.papyrus.core.utils.DiResourceSet;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.resource.IModel;
import org.eclipse.papyrus.resource.notation.NotationModel;
import org.eclipse.papyrus.resource.sasheditor.DiModel;
import org.eclipse.papyrus.resource.uml.UmlModel;
import org.eclipse.papyrus.wizards.template.SelectModelTemplateComposite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

/**
 * This WizardPage to select the kind of Papyrus Diagram. List all kind of diagrams registered with
 * creationCommand attribute in PapyrusDiagram Eclipse extension.
 * 
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 * @author Tatiana Fesenko
 */
public class SelectDiagramKindPage extends WizardPage {


	/**
	 * The creation command registry
	 */
	ICreationCommandRegistry creationCommandRegistry;

	/**
	 * The selected creation command
	 */
	private ICreationCommand creationCommand;

	/**
	 * The diagram name text field
	 */
	private Text nameText;

	private CheckboxTableViewer diagramKindTableViewer;

	/** The select template composite. */
	private SelectModelTemplateComposite selectTemplateComposite;

	/**
	 * @return the new diagram name
	 */
	public String getDiagramName() {
		return nameText.getText();
	}

	/**
	 * @return the creation command
	 */
	public ICreationCommand getCreationCommand() {
		return creationCommand;
	}

	/**
	 * Instantiates a new select diagram kind page.
	 * 
	 * @param pageName
	 *        the page name
	 */
	public SelectDiagramKindPage() {
		super("Select kind of diagram");
		setPageComplete(false);
		setTitle("Initialization information");
		setDescription("Select name and kind of the diagram");
	}

	/**
	 * Creates the control.
	 * 
	 * @param parent
	 *        the parent {@inheritDoc}
	 */
	public void createControl(Composite parent) {
		Composite plate = new Composite(parent, SWT.NONE);
		plate.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		GridLayout gridLayout = new GridLayout(1, false);
		gridLayout.marginWidth = 10;
		plate.setLayout(gridLayout);
		setControl(plate);

		createNameForm(plate);

		createDiagramKindForm(plate);

		createModelTemplateComposite(plate);

		setPageComplete(validatePage());

	}

	private void createModelTemplateComposite(Composite composite) {
		Group group = createGroup(composite, "You can load a template:");
		selectTemplateComposite = new SelectModelTemplateComposite(group);
	}

	/**
	 * Creates the diagram kind form.
	 * 
	 * @param composite
	 *        the composite
	 */
	private void createDiagramKindForm(Composite composite) {
		Group group = createGroup(composite, "Select a Diagram Kind:");
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
		group.setData(data);

		final Table diagramKindTable = new Table(group, SWT.NO_BACKGROUND | SWT.CHECK);
		diagramKindTable.setFont(group.getFont());
		diagramKindTable.setBackground(group.getBackground());

		GridLayout layout = new GridLayout(1, false);
		layout.marginHeight = 5;
		layout.marginWidth = 5;
		diagramKindTable.setLayout(layout);

		GridData data2 = new GridData(SWT.FILL, SWT.FILL, true, false);
		diagramKindTable.setLayoutData(data2);

		diagramKindTable.addSelectionListener(new SelectionListener() {

			/**
			 * {@inheritDoc}
			 */
			public void widgetSelected(SelectionEvent e) {
				if(e.detail == SWT.CHECK) {
					TableItem item = (TableItem)e.item;
					for(TableItem next : diagramKindTable.getItems()) {
						next.setChecked(false);
					}
					item.setChecked(true);
					setDiagramCreationCommand(((CreationCommandDescriptor)item.getData()).getCommandId());
					setPageComplete(validatePage());
					
				}
			}

			/**
			 * {@inheritDoc}
			 */
			public void widgetDefaultSelected(SelectionEvent e) {
				// does nothing
			}
		});
		diagramKindTableViewer = new CheckboxTableViewer(diagramKindTable);
		diagramKindTableViewer.setContentProvider(new DiagramCategoryTableContentProvider());
		diagramKindTableViewer.setLabelProvider(new DiagramCategoryLabelProvider());
		diagramKindTableViewer.setInput(getDiagramCategory());
	}

	/**
	 * @see org.eclipse.jface.dialogs.DialogPage#setVisible(boolean)
	 * 
	 * @param visible
	 */
	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		diagramKindTableViewer.setInput(getDiagramCategory());
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
	 * Sets the diagram creation command.
	 * 
	 * @param commandId
	 *        the new diagram creation command
	 */
	private void setDiagramCreationCommand(String commandId) {
		try {
			creationCommand = commandId != null ? getCreationCommandRegistry().getCommand(commandId) : null;
		} catch (NotFoundException e) {
			log.error(e);
		}
	}

	/**
	 * Creates the group.
	 * 
	 * @param parent
	 *        the parent
	 * @param name
	 *        the name
	 * @return the group
	 */
	private static Group createGroup(Composite parent, String name) {
		Group group = new Group(parent, SWT.NONE);
		group.setText(name);
		GridLayout layout = new GridLayout(1, false);
		layout.marginHeight = 5;
		layout.marginWidth = 5;
		group.setLayout(layout);
		GridData data = new GridData(SWT.FILL, SWT.BEGINNING, true, false);
		group.setLayoutData(data);
		return group;
	}

	/**
	 * Creates the name form.
	 * 
	 * @param composite
	 *        the composite
	 */
	private void createNameForm(Composite composite) {
		Group group = createGroup(composite, "Diagram Name:");

		nameText = new Text(group, SWT.BORDER);
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		nameText.setLayoutData(data);
		nameText.setText("NewDiagram");
		nameText.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				dialogChanged();
			}
		});
		dialogChanged();
	}

	/**
	 * Validate the changes on the page.
	 */
	private void dialogChanged() {
		if((nameText.getText() == null) || nameText.getText().length() == 0) {
			updateStatus("The diagram name must entered");
			return;
		}
		updateStatus(null);
	}

	/**
	 * Gets the creation command registry.
	 * 
	 * @return the creation command registry
	 */
	private ICreationCommandRegistry getCreationCommandRegistry() {
		if(creationCommandRegistry == null) {
			this.creationCommandRegistry = new CreationCommandRegistry(org.eclipse.papyrus.core.Activator.PLUGIN_ID);
		}
		return creationCommandRegistry;
	}

	/**
	 * Update page status.
	 * 
	 * @param message
	 *        is the error message.
	 */
	private void updateStatus(String message) {
		setErrorMessage(message);
		setPageComplete(message == null);
	}

	/**
	 * Validate page.
	 * 
	 * @return true, if successful
	 */
	protected boolean validatePage() {
		return false == "".equals(getDiagramName()) && getCreationCommand() != null;
	}

	/**
	 * Creates the diagram.
	 * 
	 * @param diResourceSet
	 *        the di resource set
	 * @param root
	 *        the root
	 * @return true, if successful
	 */
	public boolean createDiagram(DiResourceSet diResourceSet, EObject root) {
		String diagramName = getDiagramName();
		ICreationCommand creationCommand = getCreationCommand();

		if(creationCommand != null) {
			creationCommand.createDiagram(diResourceSet, root, diagramName);
		} else {
			// Create an empty editor (no diagrams opened)
			// Geting an IPageMngr is enough to initialize the
			// SashSystem.
			EditorUtils.getTransactionalIPageMngr(diResourceSet.getDiResource(), diResourceSet.getTransactionalEditingDomain());
		}
		try {
			diResourceSet.save(new NullProgressMonitor());
		} catch (IOException e) {
			log.error(e);
			return false;
		}
		return true;
	}

	/**
	 * The Class DiagramCategoryTableContentProvider.
	 */
	public class DiagramCategoryTableContentProvider implements IStructuredContentProvider {

		public void dispose() {
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}

		/**
		 * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
		 * 
		 * @param inputElement
		 * @return
		 */

		public Object[] getElements(Object inputElement) {
			if(inputElement instanceof String) {
				String diagramCategory = (String)inputElement;
				List<CreationCommandDescriptor> result = new ArrayList<CreationCommandDescriptor>();
				for(CreationCommandDescriptor desc : getCreationCommandRegistry().getCommandDescriptors()) {
					if(diagramCategory == null || diagramCategory.equals(desc.getLanguage())) {
						result.add(desc);
					}
				}
				return result.toArray();
			}
			return null;
		}
	}

	/**
	 * The Class DiagramCategoryLabelProvider.
	 */
	protected static class DiagramCategoryLabelProvider implements ILabelProvider {

		private static final String UNDEFINED_ELEMENT = "<undefined>";

		public Image getImage(Object element) {
			// TODO use ImageRegistry to store images
			if(element != null && element instanceof CreationCommandDescriptor) {
				ImageDescriptor image = ((CreationCommandDescriptor)element).getIcon();
				// image is an optional attribute
				if(image != null) {
					return new Image(null, image.getImageData());
				}
			}
			return null;
		}

		public String getText(Object element) {
			if(element != null && element instanceof CreationCommandDescriptor) {
				return ((CreationCommandDescriptor)element).getLabel();
			}
			return UNDEFINED_ELEMENT;
		}

		/**
		 * {@inheritDoc}
		 */
		public void addListener(ILabelProviderListener listener) {
		}

		/**
		 * {@inheritDoc}
		 */
		public void dispose() {
		}

		/**
		 * {@inheritDoc}
		 */
		public boolean isLabelProperty(Object element, String property) {
			return false;
		}

		/**
		 * {@inheritDoc}
		 */
		public void removeListener(ILabelProviderListener listener) {
		}

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
		boolean useTemplate = templatePath != null;
		if(useTemplate) {
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
