package org.eclipse.papyrus.constraintwithvsl.editor.xtext.ui.contributions;

import java.util.ArrayList;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.papyrus.constraintwithvsl.editor.xtext.constraintWithVSLl.ConstraintRule;
import org.eclipse.papyrus.constraintwithvsl.editor.xtext.constraintWithVSLl.ConstraintSpecification;
import org.eclipse.papyrus.constraintwithvsl.editor.xtext.ui.internal.ConstraintWithVSLlActivator;
import org.eclipse.papyrus.constraintwithvsl.editor.xtext.validation.ConstraintWithVSLlJavaValidator;
import org.eclipse.papyrus.constraintwithvsl.editor.xtext.validation.SemanticValidator;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.extensionpoints.editors.configuration.IPopupEditorConfiguration;
import org.eclipse.papyrus.extensionpoints.editors.ui.IPopupEditorHelper;
import org.eclipse.papyrus.marte.vsl.extensions.VSLSerializationUtil;
import org.eclipse.papyrus.marte.vsl.validation.VSLJavaValidator;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.uml2.uml.ConnectionPointReference;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.xtext.gmf.glue.PopupEditorConfiguration;
import org.eclipse.xtext.gmf.glue.edit.part.IXtextEMFReconciler;

import com.google.inject.Injector;

public class ConstraintWithVSLPopupEditorConfiguration extends PopupEditorConfiguration  {

	private Constraint constraint = null ;
	private String newBody = "" ;
	
	public ConstraintWithVSLPopupEditorConfiguration() {
		super() ;
	}


	@Override
	public String getTextToEdit(Object editedObject) {
		if (editedObject instanceof Constraint) {
			Constraint theConstraint = (Constraint)editedObject ;
			if (theConstraint.getSpecification() != null && theConstraint.getSpecification() instanceof OpaqueExpression) {
				OpaqueExpression spec = (OpaqueExpression)theConstraint.getSpecification() ;
				int indexOfVSLExpression = -1 ;
				int i = 0 ;
				for (String language : spec.getLanguages()) {
					if (language.equals("VSL")) {
						indexOfVSLExpression = i ;
					}
					i++ ;
				}
				return indexOfVSLExpression != -1 ? spec.getBodies().get(indexOfVSLExpression) : "" ;
			}
			else {
				return "" ;
			}
		}
		else 
			return "Not a Constraint" ;
	}

	

	@Override
	public IPopupEditorHelper createPopupEditorHelper(Object editPart) {
		// resolves the edit part, and the associated semantic element
		IGraphicalEditPart graphicalEditPart = null;
		if(!(editPart instanceof IGraphicalEditPart))
			return null;
		graphicalEditPart = (IGraphicalEditPart)editPart;
		if(!(graphicalEditPart.resolveSemanticElement() instanceof Constraint))
			return null;
		constraint = (Constraint)graphicalEditPart.resolveSemanticElement();

		ConstraintWithVSLlJavaValidator.init(constraint) ;
		// initializes VSL editor
		VSLJavaValidator.init(constraint) ;
		
		// retrieves the XText injector
		Injector injector = ConstraintWithVSLlActivator.getInstance().getInjector("org.eclipse.papyrus.constraintwithvsl.editor.xtext.ConstraintWithVSLl");

		// builds the text content and extension for a temporary file, to be edited by the xtext editor
		String textToEdit = "" + this.getTextToEdit(graphicalEditPart.resolveSemanticElement());
		String fileExtension = "" + ".constraintwithvsl";

		// builds a new IXtextEMFReconciler.
		// Its purpose is to extract any relevant information from the textual specification,
		// and then merge it in the context UML model if necessary
		IXtextEMFReconciler reconciler = new IXtextEMFReconciler() {

			public void reconcile(EObject modelObject, EObject xtextObject) {
				
				ConstraintSpecification newSpecification = null ;
				
				ConstraintRule rule = (ConstraintRule)xtextObject ;
				newSpecification = rule.getSpecification() ;
				if (newSpecification != null) {
					newBody = VSLSerializationUtil.printExpression(newSpecification.getExpression()) ;
				}
				
				// Creates and executes the update command
				UpdateConstraintWithVSLCommand updateCommand = new UpdateConstraintWithVSLCommand((Constraint)VSLJavaValidator.getContextElement());
				
				try {
					OperationHistoryFactory.getOperationHistory().execute(updateCommand, new NullProgressMonitor(), null) ;
				}
				catch (ExecutionException e) {
					org.eclipse.papyrus.properties.runtime.Activator.log.error(e);
				}
			}
		};
		return super.createPopupEditorHelper(graphicalEditPart, 
											injector, 
											reconciler, 
											textToEdit, 
											fileExtension,
											new SemanticValidator());
	}
	
	/**
	 * @author CEA LIST
	 *
	 * A command for updating the context UML model
	 */
	protected class UpdateConstraintWithVSLCommand extends AbstractTransactionalCommand {

		private Constraint theConstraint ;
		
		/* (non-Javadoc)
		 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor, org.eclipse.core.runtime.IAdaptable)
		 */
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor arg0,
				IAdaptable arg1) throws ExecutionException {
			
			theConstraint.setSpecification(null) ;
			
			OpaqueExpression opaqueExp = UMLFactory.eINSTANCE.createOpaqueExpression() ;
			opaqueExp.getLanguages().add("VSL") ;
			opaqueExp.getBodies().add(newBody) ;
			
			theConstraint.setSpecification(opaqueExp) ;
			
			return CommandResult.newOKCommandResult(theConstraint);
		}
		
		public UpdateConstraintWithVSLCommand(Constraint constraint) {
			super(EditorUtils.getTransactionalEditingDomain(), 
					"Constraint Update", 
					getWorkspaceFiles(constraint));
			this.theConstraint = constraint ;
		}	
	}
}
