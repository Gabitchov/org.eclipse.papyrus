/*****************************************************************************
 * Copyright (c) 2008, 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - only calculate affected files for workspace resources (CDO)
 *  Laurent Wouters (CEA) - laurent.wouters@cea.fr - Refactoring for viewpoints
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common;

import java.util.ArrayList;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.commands.OpenDiagramCommand;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.sasheditor.DiModelUtils;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageManager;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForResource;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationUtils;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramUtils;
import org.eclipse.papyrus.infra.viewpoints.configuration.ModelRule;
import org.eclipse.papyrus.infra.viewpoints.configuration.ui.IModelElementValidator;
import org.eclipse.papyrus.infra.viewpoints.configuration.ui.ModelElementSelectionDialog;
import org.eclipse.papyrus.infra.viewpoints.policy.PolicyChecker;
import org.eclipse.papyrus.infra.viewpoints.policy.ViewPrototype;
import org.eclipse.papyrus.uml.tools.model.UmlUtils;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

/**
 * Command creating a new GMF diagram in Papyrus. This command is intended to be used in eclipse
 * extensions.
 * 
 * Commands to create a GMF Diagram can subclass this class. There is two kinds of commands: -
 * Eclipse handlers issuing commands (toolbar, menu, ...). This commands can find the active editor
 * by using the Worbench.getActivePArt(). The entry point is {@link #execute(ExecutionEvent)}. -
 * Commands called during editor initializing (like wizard). This commands require the diResourceSet
 * to work. The entry point is {@link #createDiagram(Resource, EObject, String)}
 * 
 * @author cedric dumoulin
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public abstract class AbstractPapyrusGmfCreateDiagramCommandHandler extends AbstractHandler implements IHandler, ICreationCommand {

	/**
	 * Inner class for the creation of diagrams
	 * 
	 * @author Laurent Wouters
	 *
	 */
	private class Creator {
		private ModelSet modelSet;
		private EObject owner;
		private EObject element;
		private ViewPrototype prototype;
		private String name;

		public Creator(ModelSet modelSet, EObject owner, EObject element, ViewPrototype prototype, String name) {
			this.modelSet = modelSet;
			this.owner = owner;
			this.element = element;
			this.prototype = prototype;
			this.name = name;
		}

		private Diagram createDiagram() throws ServiceException {
			Resource modelResource = UmlUtils.getUmlResource(modelSet);
			Resource notationResource = NotationUtils.getNotationResource(modelSet);
			Resource diResource = DiModelUtils.getDiResource(modelSet);

			if (owner == null) {
				owner = getRootElement(modelResource);
				attachModelToResource(owner, modelResource);
			}

			if (!PolicyChecker.getCurrent().canOwnNewView(owner, prototype)) {
				ModelElementSelectionDialog dialog = new ModelElementSelectionDialog(Display.getCurrent().getActiveShell(), getMultiDiagramEditor().getServicesRegistry(), "Select an appropriate owner for the diagram:", getRootElement(modelResource), owner,
						new IModelElementValidator() {
							public String isSelectable(EObject element) {
								if (PolicyChecker.getCurrent().canOwnNewView(owner, prototype))
									return null;
								return "This element cannot own the diagram.";
							}
						});
				int result = dialog.open();
				if (result != Window.OK)
					return null;
				owner = dialog.getSelection();
			}

			element = prototype.getRootFor(owner);
			if (!PolicyChecker.getCurrent().canHaveNewView(element, owner, prototype)) {
				StringBuilder builder = new StringBuilder("Select a root element for the diagram. Allowed types: ");
				if (prototype.getConfiguration() == null) {
					builder.append("<unknown>");
				} else if (prototype.getConfiguration().getModelRules().size() == 0) {
					builder.append("<unknown>");
				} else {
					boolean first = true;
					for (ModelRule rule : prototype.getConfiguration().getModelRules()) {
						EClass model = rule.getElement();
						if (model != null) {
							if (!first) {
								builder.append(", ");
							}
							first = false;
							builder.append(model.getName());
						}
					}
				}
				builder.append(".");
				ModelElementSelectionDialog dialog = new ModelElementSelectionDialog(Display.getCurrent().getActiveShell(), getMultiDiagramEditor().getServicesRegistry(), builder.toString(), getRootElement(modelResource), element,
						new IModelElementValidator() {
							public String isSelectable(EObject element) {
								if (PolicyChecker.getCurrent().canHaveNewView(element, owner, prototype))
									return null;
								return "This element cannot be the root element of the diagram.";
							}
						});
				int result = dialog.open();
				if (result != Window.OK)
					return null;
				element = dialog.getSelection();
			}

			if (name == null) {
				name = openDiagramNameDialog(prototype.isNatural() ? getDefaultDiagramName() : "New" + prototype.getLabel().replace(" ", ""));
			}
			// canceled
			if (name == null) {
				return null;
			}

			Diagram diagram = doCreateDiagram(notationResource, owner, element, prototype, name);

			if (diagram != null) {
				IPageManager pageManager = ServiceUtilsForResource.getInstance().getIPageManager(diResource);
				pageManager.addPage(diagram);

			}
			return diagram;
		}
	}


	/**
	 * Get the root element associated with canvas.
	 */
	private EObject getRootElement(Resource modelResource) {
		EObject rootElement = null;
		if (modelResource != null && modelResource.getContents() != null && modelResource.getContents().size() > 0) {
			Object root = modelResource.getContents().get(0);
			if (root instanceof EObject) {
				rootElement = (EObject) root;
			}
		}

		return rootElement;
	}

	/**
	 * Store model element in the resource.
	 */
	private void attachModelToResource(EObject root, Resource resource) {
		resource.getContents().add(root);
	}

	/**
	 * Get the current MultiDiagramEditor.
	 */
	private IMultiDiagramEditor getMultiDiagramEditor() {
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IEditorPart editorPart = page.getActiveEditor();
		return (IMultiDiagramEditor) editorPart;
	}

	/**
	 * Open popup to enter the new diagram name
	 * 
	 * @param defaultValue
	 *            the default value
	 * @return the entered diagram name
	 */
	private String openDiagramNameDialog(String defaultValue) {
		if (defaultValue == null) {
			defaultValue = "";
		}

		InputDialog inputDialog = new InputDialog(Display.getCurrent().getActiveShell(), Messages.AbstractPapyrusGmfCreateDiagramCommandHandler_SelectNewDiagramName, Messages.AbstractPapyrusGmfCreateDiagramCommandHandler_NewDiagramName, defaultValue, null);
		int result = inputDialog.open();

		if (result == Window.OK) {
			String name = inputDialog.getValue();
			if (name == null || name.length() == 0) {
				name = defaultValue;
			}
			return name;
		}
		return null;
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.commands.ICreationCommand#createDiagram(org.eclipse.emf.ecore.resource.Resource, org.eclipse.emf.ecore.EObject, java.lang.String)
	 */
	public final Diagram createDiagram(ModelSet modelSet, EObject owner, String name) {
		ViewPrototype proto = ViewPrototype.get(getCreatedDiagramType(), owner, owner);
		if (proto == null)
			return null;
		return createDiagram(modelSet, owner, owner, proto, name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.commands.ICreationCommand#createDiagram(org.eclipse.emf.ecore.resource.Resource, org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EObject, org.eclipse.papyrus.infra.viewpoints.policy.ViewPrototype, java.lang.String)
	 */
	public final Diagram createDiagram(ModelSet modelSet, EObject owner, EObject element, ViewPrototype prototype, String name) {
		ICommand createCmd = getCreateDiagramCommand(modelSet, owner, element, prototype, name);
		TransactionalEditingDomain dom = modelSet.getTransactionalEditingDomain();
		CompositeCommand cmd = new CompositeCommand("Create diagram");
		cmd.add(createCmd);
		cmd.add(new OpenDiagramCommand(dom, createCmd));
		dom.getCommandStack().execute(new GMFtoEMFCommandWrapper(cmd));
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.commands.ICreationCommand#getCreateDiagramCommand(org.eclipse.papyrus.infra.core.resource.ModelSet, org.eclipse.emf.ecore.EObject, java.lang.String)
	 */
	public final ICommand getCreateDiagramCommand(ModelSet modelSet, EObject owner, String name) {
		ViewPrototype proto = ViewPrototype.get(getCreatedDiagramType(), owner, owner);
		if (proto == null)
			return null;
		return getCreateDiagramCommand(modelSet, owner, owner, proto, name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.commands.ICreationCommand#getCreateDiagramCommand(org.eclipse.papyrus.infra.core.resource.ModelSet, org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EObject, org.eclipse.papyrus.infra.viewpoints.policy.ViewPrototype,
	 * java.lang.String)
	 */
	public final ICommand getCreateDiagramCommand(final ModelSet modelSet, final EObject owner, final EObject element, final ViewPrototype prototype, final String name) {
		// Diagram creation should not change the semantic resource
		final Resource notationResource = NotationUtils.getNotationResource(modelSet);
		final Resource diResource = DiModelUtils.getDiResource(modelSet);

		ArrayList<IFile> modifiedFiles = new ArrayList<IFile>();
		if (notationResource.getURI().isPlatformResource()) {
			modifiedFiles.add(ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(notationResource.getURI().toPlatformString(true))));
		}
		if (diResource.getURI().isPlatformResource()) {
			modifiedFiles.add(ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(diResource.getURI().toPlatformString(true))));
		}

		return new AbstractTransactionalCommand(modelSet.getTransactionalEditingDomain(), Messages.AbstractPapyrusGmfCreateDiagramCommandHandler_CreateDiagramCommandLabel, modifiedFiles) {
			private Diagram diagram = null;
			private EObject diagramElement = null;
			private EObject diagramOwner = null;

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				Creator creator = new Creator(modelSet, owner, element, prototype, name);
				try {
					diagram = creator.createDiagram();
					if (diagram == null)
						return CommandResult.newCancelledCommandResult();
					diagramElement = diagram.getElement();
					diagramOwner = DiagramUtils.getOwner(diagram);
					return CommandResult.newOKCommandResult(diagram);
				} catch (ServiceException e) {
					Activator.log.error(e);
				}
				return CommandResult.newErrorCommandResult("Error during diagram creation");
			}

			@Override
			protected IStatus doUndo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				// the undo corresponds to a destroy diagram command
				// during diagram creation no adapters are set to the diagram so the setElement is not registered
				// to remove the cross reference using the element reference it is better to use the destroy element command
				// DestroyElementPapyrusCommand depc = (diagram != null) ? new DestroyElementPapyrusCommand(new DestroyElementRequest(diagram, false)) : null;
				IStatus status = super.doUndo(monitor, info);
				diagram.setElement(null);
				return status;
			}

			@Override
			protected IStatus doRedo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				diagram.setElement(diagramElement);
				DiagramUtils.setOwner(diagram, diagramOwner);
				IStatus status = super.doRedo(monitor, info);
				return status;
			}
		};
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.commands.ICreationCommand#getCreatedDiagramType()
	 */
	public String getCreatedDiagramType() {
		return getDiagramNotationID();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.commands.ICreationCommand#isParentReassignable()
	 */
	public boolean isParentReassignable() {
		// yes by default
		return true;
	}



	public Object execute(ExecutionEvent event) throws ExecutionException {
		// This method should not be called, use the execute(ExecutionEvent, ViewPrototype, String) method.
		throw new UnsupportedOperationException();
	}


	protected abstract String getDiagramNotationID();

	protected abstract PreferencesHint getPreferenceHint();

	protected abstract String getDefaultDiagramName();

	/**
	 * Overridable method that effectively create the diagram with the given validated parameters
	 * 
	 * @param diagramResource
	 *            the diagram resource
	 * @param owner
	 *            the diagram's owner
	 * @param element
	 *            the diagram's model element
	 * @param prototype
	 *            the diagram's prototype
	 * @param name
	 *            the diagram's name
	 * @return the created diagram, or <code>null</code> if the creation failed
	 */
	protected Diagram doCreateDiagram(Resource diagramResource, EObject owner, EObject element, ViewPrototype prototype, String name) {
		// create diagram
		Diagram diagram = ViewService.createDiagram(element, getDiagramNotationID(), getPreferenceHint());
		if (diagram != null) {
			diagram.setName(name);
			diagram.setElement(element);
			DiagramUtils.setOwner(diagram, owner);
			if (!prototype.isNatural())
				DiagramUtils.setPrototype(diagram, prototype);
			initializeDiagram(diagram);
			diagramResource.getContents().add(diagram);
		}
		return diagram;
	}

	/**
	 * Overridable method for the initialization of create diagrams
	 * 
	 * @param diagram
	 *            the created diagram
	 */
	protected void initializeDiagram(EObject diagram) {

	};
}

