/**
 * 
 */
package org.eclipse.papyrus.diagram.umltools.clazz;

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
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.core.utils.BusinessModelResolver;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.sasheditor.contentprovider.di.IPageMngr;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.diagram.clazz.part.UMLDiagramEditorPlugin;
import org.eclipse.uml2.uml.UMLFactory;


/**
 * A Handler responsible to create the EObject representing a UmlTools class diagram.
 * The handler also add the created EObject to the SashContainerProvider. In reaction, the SashEditor 
 * will instanciate the corresponding Editor.
 * 
 * @author cedric dumoulin
 *
 */
public class CreateClassDiagramHandler extends AbstractHandler implements IHandler {

	/**
	 * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 *
	 * @param event
	 * @return
	 * @throws ExecutionException
	 */
	
	public Object execute(ExecutionEvent event) throws ExecutionException {

		// Choose one of the two execution mode.
		executeAsTransaction(event);
//		doExecute(event);
		// Return null, as required by the API
		return null;
	}

	/**
	 * Execute the handler in a undoable transaction.
	 * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 *
	 * @param event
	 * @return
	 * @throws ExecutionException
	 */
	
	public void executeAsTransaction(final ExecutionEvent event) throws ExecutionException {

		TransactionalEditingDomain editingDomain = EditorUtils.getTransactionalEditingDomain();

		// Create a transactional command.
		AbstractTransactionalCommand command = new AbstractTransactionalCommand(editingDomain,"Create Class Diagram", Collections.EMPTY_LIST) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {

				CommandResult commandResult;
				try {
					// Call the real implementation
					CreateClassDiagramHandler.this.doExecute(event);
					commandResult = CommandResult.newOKCommandResult();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					commandResult = CommandResult.newErrorCommandResult("Error during diagram creation");
				}
				return commandResult;
			}
		};
		
		// Execute the command
		try {
			OperationHistoryFactory.getOperationHistory().execute(command, new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
			e.printStackTrace();
			// TODO log the error
		}
	}

	/**
	 * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 *
	 * @param event
	 * @return
	 * @throws ExecutionException
	 */
	
	public void doExecute(ExecutionEvent event) throws ExecutionException {

		// First, create the EObject used to represent the Editor.
		// This is generally the root object used to instantiate the corresponding editor.
		EObject editorRootObject = createEditorRootObject();
		// Then add the root object to the SashContainerProvider
		IPageMngr pageMngr = EditorUtils.getIPageMngr();
		pageMngr.openPage(editorRootObject);
	}

	/**
	 * Create the root object used to find the type of the editor to create, and provided to the new instance.
	 * 
	 * @return
	 */
	private EObject createEditorRootObject() {
		
		String diagramName = "newDiagram";
		EObject associatedDomainRoot = getDomainRoot();
		Resource diagramResource = getDiagramResource();
		
		Diagram diagram = ViewService.createDiagram(associatedDomainRoot, getDiagramNotationID(), getPreferenceHint());
		if(diagram != null) {
			diagram.setName(diagramName);
			// TODO : required ??
			diagram.setElement(associatedDomainRoot);
			diagramResource.getContents().add(diagram);
//			initializeModel(owner);
//			initializeDiagram(diagram);
		}
		
		
		return diagram;
	}

	/**
	 * Get the domain element that will be associated to the Diagram.
	 * chack if the selected element can be used as domain element.
	 * If nothing is found, create a domain element.
	 * @return The domain element that will be associated to the diagram.
	 * 
	 */
	private EObject getDomainRoot() {
		
		EObject domainElement = getSelectedDomainElement();
		if( domainElement != null)
			return domainElement;
		
		// Create one
		return createDomainElement();
	}

	/**
	 * Create the domain element that will be associated to the Diagram.
	 * @return
	 */
	protected EObject createDomainElement() {
		return UMLFactory.eINSTANCE.createModel();

	}

	/**
	 * Get the domain element associated to the current selection.
	 * @return The domain EObject associated to the current Eclipse selection, or null.
	 */
	private EObject getSelectedDomainElement() {
		EObject eObject = null;
		Object selection = getCurrentSelection();
		if(selection != null) {
			Object businessObject = getDomainModel(selection);
			if(businessObject instanceof EObject) {
				eObject = (EObject)businessObject;
			}
		}
		return eObject;
	}

	/**
	 * Get current selection first element.
	 * 
	 * @return the selected element or null.
	 */
	private Object getCurrentSelection() {
		ISelection selection = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();
		if(selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection)selection;
			return structuredSelection.getFirstElement();
		}

		return null;
	}

	/**
	 * Get the domain object associated to the provided object, if any. 
	 * The provided object is a graphical artifact (EditPart, View, ...)
	 * This method navigate throw the object if the object is a graphical artifact or a
	 * diagram artifact.
	 * 
	 * @param object Graphical artifact associated to a domain object.
	 * @return Object The domain object associated to the graphical artifact.
	 */
	private Object getDomainModel(Object object) {
		if(object instanceof EditPart) {
			// Check model. It can be a GraphNode.
			Object model = ((EditPart)object).getModel();
			// Check if it is a notation View
			if(model instanceof View) { 
				return ((View)model).getElement();

			} else
				return model;
			
		} 
		else if(object instanceof View) {
			return ((View)object).getElement();
		}
		else
			return object;

	}


	/**
	 * Get the resource containing notation.Diagram.
	 * @return
	 */
	private Resource getDiagramResource() {
		return EditorUtils.getDiResourceSet().getNotationResource();
	}

	/**
	 * Get the ID identifying the type of the Diagram.
	 * {@inheritDoc}
	 */
	protected String getDiagramNotationID() {
		return org.eclipse.uml2.diagram.clazz.edit.parts.PackageEditPart.MODEL_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	protected PreferencesHint getPreferenceHint() {
		return UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT;
	}
	
}
