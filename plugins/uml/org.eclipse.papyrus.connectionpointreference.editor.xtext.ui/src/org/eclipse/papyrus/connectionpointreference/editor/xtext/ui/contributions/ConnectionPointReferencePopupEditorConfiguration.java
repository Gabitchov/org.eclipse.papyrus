package org.eclipse.papyrus.connectionpointreference.editor.xtext.ui.contributions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.connectionpointreference.editor.xtext.uMLConnectionPointReference.ConnectionPointReferenceRule;
import org.eclipse.papyrus.connectionpointreference.editor.xtext.ui.internal.UMLConnectionPointReferenceActivator;
import org.eclipse.papyrus.connectionpointreference.editor.xtext.validation.UMLConnectionPointReferenceJavaValidator;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.extensionpoints.editors.ui.IPopupEditorHelper;
import org.eclipse.uml2.uml.ConnectionPointReference;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.xtext.gmf.glue.PopupEditorConfiguration;
import org.eclipse.xtext.gmf.glue.edit.part.IXtextEMFReconciler;

import com.google.inject.Injector;

public class ConnectionPointReferencePopupEditorConfiguration extends PopupEditorConfiguration {

	private ConnectionPointReference connectionPoint ;

	private List<Pseudostate> newEntries = new ArrayList<Pseudostate>() ;
	private List<Pseudostate> newExits = new ArrayList<Pseudostate>() ;
	
	public ConnectionPointReferencePopupEditorConfiguration() {
		super() ;
	}

	@Override
	public String getTextToEdit(Object editedObject) {
		if (editedObject instanceof ConnectionPointReference) {
			ConnectionPointReference ref = (ConnectionPointReference)editedObject ;
			String label = "" ;
			if (!ref.getEntries().isEmpty()) {
				label += "entry " ;
				boolean first = true ;
				for (Pseudostate p : ref.getEntries()) {
					if (!first) {
						label += ", " ;
					}
					else {
						first = false ;
					}
					label += p.getName() ;
				}
			}
			else if (!ref.getExits().isEmpty()) {
				label += "exit " ;
				boolean first = true ;
				for (Pseudostate p : ref.getExits()) {
					if (!first) {
						label += ", " ;
					}
					else {
						first = false ;
					}
					label += p.getName() ;
				}
			}
			return label ;
		}
		return "not a ConnectionPointReference" ;
	}

	@Override
	public IPopupEditorHelper createPopupEditorHelper(Object editPart) {
		// resolves the edit part, and the associated semantic element
		IGraphicalEditPart graphicalEditPart = null;
		if(!(editPart instanceof IGraphicalEditPart))
			return null;
		graphicalEditPart = (IGraphicalEditPart)editPart;
		if(!(graphicalEditPart.resolveSemanticElement() instanceof ConnectionPointReference))
			return null;
		connectionPoint = (ConnectionPointReference)graphicalEditPart.resolveSemanticElement();

		UMLConnectionPointReferenceJavaValidator.init(connectionPoint) ;
		
		// retrieves the XText injector
		Injector injector = UMLConnectionPointReferenceActivator.getInstance().getInjector("org.eclipse.papyrus.connectionpointreference.editor.xtext.UMLConnectionPointReference");

		// builds the text content and extension for a temporary file, to be edited by the xtext editor
		String textToEdit = "" + this.getTextToEdit(graphicalEditPart.resolveSemanticElement());
		String fileExtension = "" + ".conncectionpointreference";

		// builds a new IXtextEMFReconciler.
		// Its purpose is to extract any relevant information from the textual specification,
		// and then merge it in the context UML model if necessary
		IXtextEMFReconciler reconciler = new IXtextEMFReconciler() {

			public void reconcile(EObject modelObject, EObject xtextObject) {
				
				newEntries = new ArrayList<Pseudostate>() ;
				newExits = new ArrayList<Pseudostate>() ;
				
				ConnectionPointReferenceRule rule = (ConnectionPointReferenceRule)xtextObject ;
				if (! rule.getEntry().isEmpty()) {
					newEntries.addAll(rule.getEntry()) ;
				}
				else if (! rule.getExit().isEmpty()) {
					newExits.addAll(rule.getExit()) ;
				}
				
				// Creates and executes the update command
				UpdateConnectionPointReferenceCommand updateCommand = new UpdateConnectionPointReferenceCommand(connectionPoint);
				
				try {
					OperationHistoryFactory.getOperationHistory().execute(updateCommand, new NullProgressMonitor(), null) ;
				}
				catch (ExecutionException e) {
					org.eclipse.papyrus.properties.runtime.Activator.log.error(e);
				}
			}
		};
		return super.createPopupEditorHelper(graphicalEditPart, injector, reconciler, textToEdit, fileExtension);
	}
	
	/**
	 * @author CEA LIST
	 *
	 * A command for updating the context UML model
	 */
	protected class UpdateConnectionPointReferenceCommand extends AbstractTransactionalCommand {

		private ConnectionPointReference connectionPointReference ;
		
		/* (non-Javadoc)
		 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor, org.eclipse.core.runtime.IAdaptable)
		 */
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor arg0,
				IAdaptable arg1) throws ExecutionException {
			
			connectionPointReference.getEntries().clear() ;
			connectionPointReference.getExits().clear() ;
			
			connectionPointReference.getEntries().addAll(newEntries) ;
			connectionPointReference.getExits().addAll(newExits) ;
			
			return CommandResult.newOKCommandResult(connectionPointReference);
		}
		
		public UpdateConnectionPointReferenceCommand(ConnectionPointReference connectionPointReference) {
			super(EditorUtils.getTransactionalEditingDomain(), 
					"ConnectionPointReference Update", 
					getWorkspaceFiles(connectionPointReference));
			this.connectionPointReference = connectionPointReference ;
		}	
	}
}
