/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.core.adaptor.gmf;

import java.util.Collections;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.core.editor.BackboneContext;
import org.eclipse.papyrus.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.core.extension.commands.ICreationCommand;
import org.eclipse.papyrus.core.multidiagram.SashDiagramModelUtil;
import org.eclipse.papyrus.core.utils.DiResourceSet;
import org.eclipse.papyrus.di.CoreSemanticModelBridge;
import org.eclipse.papyrus.di.DiFactory;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.diagram.clazz.part.Messages;
import org.eclipse.uml2.diagram.clazz.part.UMLDiagramEditorPlugin;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * Command creating a new GMF diagram in Papyrus. This command is intended to be used in eclipse extensions. This command is to be used with Editors using Context.
 * 
 * @author dumoulin
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public abstract class AbstractPapyrusGmfCreateDiagramCommandHandler extends AbstractHandler implements IHandler, ICreationCommand {

	/**
	 * Method called when the command is invoked.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		BackboneContext context;
		try {
			context = getDefaultContext();
		} catch (ClassCastException ex) {
			// Bad current editor. Skip
			throw new ExecutionException("Current editor type not supported.", ex);
		}
		Element container = null;
		// if editor is open and active
		if (getMultiDiagramEditor() != null) {
			container = getSelectedUmlElement();
		}
		runAsTransaction(context, container);
		return null;
	}

	/**
	 * Create a new class diagram
	 * 
	 * @param sharedObjects
	 * @param container
	 *            The uml element to which the diagram should be attached, if possible.
	 */
	protected void runAsTransaction(BackboneContext sharedObjects, Element container) {
		DiResourceSet diResourceSet = sharedObjects.getResourceSet();
		runAsTransaction(diResourceSet, container, null);
	}

	/**
	 * Create a new class diagram
	 * 
	 * @param sharedObjects
	 * @param container
	 *            The uml element to which the diagram should be attached, if possible.
	 */
	protected void runAsTransaction(final DiResourceSet diResourceSet, final Element container, String name) {
		final String diagramName;
		if (name != null) {
			diagramName = name;
		} else {
			diagramName = getDiagramName();
		}
		if (diagramName != null) {
			// Get the uml element to which the newly created diagram will be attached.
			final Element umlParent = getUmlParentFromElement(container);
			// Create the diagram
			final Resource modelResource = diResourceSet.getUMLModelResource();
			final Resource diagramResource = diResourceSet.getNotationResource();
			final Resource diResource = diResourceSet.getDiResource();
			// TODO: get the appropriate value from diResourceSet
			TransactionalEditingDomain editingDomain = diResourceSet.getTransactionalEditingDomain();

			AbstractTransactionalCommand command = new AbstractTransactionalCommand(editingDomain, Messages.UMLDiagramEditorUtil_CreateDiagramCommandLabel, Collections.EMPTY_LIST) {

				protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
					Element model = umlParent;
					if (model == null) {
						model = getModel(modelResource);
						attachModelToResource(model, modelResource);
					}

					Diagram diagram = createDiagram(diagramResource, model, diagramName);

					SashDiagramModelUtil.openDiagramInCurrentFolder(diResource, diagram);

					return CommandResult.newOKCommandResult();
				}
			};
			try {
				OperationHistoryFactory.getOperationHistory().execute(command, new NullProgressMonitor(), null);
			} catch (ExecutionException e) {
				e.printStackTrace();
				UMLDiagramEditorPlugin.getInstance().logError("Unable to create model and diagram", e); //$NON-NLS-1$
			}
		}
	}

	/**
	 * Get the UML parent into which the diagram can be attached.
	 * 
	 * @param container
	 *            The currently selected UML element. Can be used as an hint to find the possible parent.
	 * @return The suitable UML parent, or null.
	 */
	private Element getUmlParentFromElement(Element umlElement) {
		if (umlElement == null)
			return null;

		return getSurroundingPackage(umlElement);
	}

	/**
	 * Get the nearest surrounding package for the element, or null.
	 * 
	 * @param umlElement
	 * @return the nearest surrounding package for the element, or null.
	 */
	private Element getSurroundingPackage(Element umlElement) {
		return umlElement.getNearestPackage();
	}

	/**
	 * Create a di2 diagram referencing the notation diagram.
	 * 
	 * @param notationDiagram
	 * @return
	 */
	protected org.eclipse.papyrus.di.Diagram createDi2GmfDiagram(Diagram notationDiagram) {
		org.eclipse.papyrus.di.Diagram diDiagram = DiFactory.eINSTANCE.createDiagram();
		CoreSemanticModelBridge bridge = DiFactory.eINSTANCE.createCoreSemanticModelBridge();
		bridge.setElement(notationDiagram);

		diDiagram.setName(notationDiagram.getName());
		diDiagram.setSemanticModel(bridge);
		diDiagram.setType(GmfEditorFactory.GMF_DIAGRAM);
		diDiagram.setIsVisible(true);

		return diDiagram;
	}

	/**
	 * Get the instance of domain element associated with canvas.
	 */
	protected Element getModel(Resource modelResource) {
		if (modelResource != null && modelResource.getContents() != null) {
			if (modelResource.getContents().size() > 0) {
				Object root = modelResource.getContents().get(0);
				if (root instanceof Element) {
					return (Element) root;
				}
			}
		}
		return UMLFactory.eINSTANCE.createModel();
	}

	/**
	 * Store model element in the resource.
	 */
	protected void attachModelToResource(Element model, Resource resource) {
		resource.getContents().add(model);
	}

	/**
	 * @return
	 */
	abstract protected String getDiagramNotationID();

	/**
	 * @return
	 */
	abstract protected PreferencesHint getPreferenceHint();

	/**
	 * Get the name used for diagram.
	 * 
	 * @return
	 */
	abstract protected String getDiagramName();

	/**
	 * Get currently selected UML element.
	 * 
	 * @return The currently selected UML element, or null if any.
	 */
	protected NamedElement getSelectedUmlElement() {

		Object selected = getCurrentSelection();
		if (selected == null)
			return null;
		try {
			return (NamedElement) getDefaultContext().getModelResolver().getBussinessModel(selected);
		} catch (ClassCastException e) {
			// The selected element is not a UML element.
			return null;
		}
	}

	/**
	 * Get current selection first element.
	 * 
	 * @return the selected element or null.
	 */
	private Object getCurrentSelection() {
		ISelection selection = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			return structuredSelection.getFirstElement();
		}

		return null;
	}

	/**
	 * Create a diagram.
	 * 
	 * @param diagramResource
	 *            the diagram resource
	 * @param umlOwner
	 *            the diagram container
	 * @param name
	 *            the diagram name
	 * @return
	 */
	protected Diagram createDiagram(Resource diagramResource, Element umlOwner, String name) {
		// create diagram
		Diagram diagram = ViewService.createDiagram(umlOwner, getDiagramNotationID(), getPreferenceHint());
		if (diagram != null) {
			diagram.setName(name);
			diagram.setElement(umlOwner);
			diagramResource.getContents().add(diagram);
			initializeModel(umlOwner);
			initializeDiagram(diagram);
		}
		return diagram;
	}

	protected void initializeModel(Element umlOwner) {
	};

	protected void initializeDiagram(Diagram diagram) {
	};

	/**
	 * Get the current MultiDiagramEditor.
	 * 
	 * @return
	 */
	protected IMultiDiagramEditor getMultiDiagramEditor() {
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IEditorPart editorPart = page.getActiveEditor();
		return (IMultiDiagramEditor) editorPart;
	}

	/**
	 * Get the shared object.
	 * 
	 * @return
	 */
	protected BackboneContext getDefaultContext() {
		IMultiDiagramEditor editor = getMultiDiagramEditor();
		return (BackboneContext) editor.getDefaultContext();
	}

	/**
	 * Open popup to enter the new diagram name
	 * 
	 * @param defaultValue
	 *            the default value
	 * @return the entered diagram name
	 */
	protected String openDiagramNameDialog(final String defaultValue) {
		InputDialog inputDialog = new InputDialog(Display.getCurrent().getActiveShell(), "Enter a new diagram name", "The new diagram name:", defaultValue, null);
		int ret = inputDialog.open();
		if (ret == Window.OK) {
			String name = inputDialog.getValue();
			if (name == null || name.length() == 0) {
				name = defaultValue;
			}
			return name;
		} else {
			return null;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void createDiagram(final DiResourceSet diResourceSet, final EObject container, final String name) {
		TransactionalEditingDomain transactionalEditingDomain = diResourceSet.getTransactionalEditingDomain();
		RecordingCommand command = new RecordingCommand(transactionalEditingDomain) {

			@Override
			protected void doExecute() {
				runAsTransaction(diResourceSet, (Element) container, name);
			}
		};
		transactionalEditingDomain.getCommandStack().execute(command);
	}

}
