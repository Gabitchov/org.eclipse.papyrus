/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.oclconstraintevaluation;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.Profile;


/**
 * this class is an handler that has in charge to launch an evaluation of the constraint contained in the body of the constraint
 *
 */
public class ComputeConstraintHandler extends AbstractHandler {


	/**
	 * <pre>
	 * Get the selected element, the first selected element if several are selected or null 
	 * if no selection or the selection is not an {@link EObject}. 
	 * 
	 * @return selected {@link EObject} or null
	 * </pre>
	 * 
	 */
	protected EObject getSelectedElement() {
		EObject eObject = null;
		Object selection = null;

		// Get current selection
		selection = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();

		// Get first element if the selection is an IStructuredSelection
		if(selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection)selection;
			selection = structuredSelection.getFirstElement();
		}

		// Treat non-null selected object (try to adapt and return EObject)
		if(selection != null) {

			if(selection instanceof IAdaptable) {
				selection = ((IAdaptable)selection).getAdapter(EObject.class);
			}

			if(selection instanceof EObject) {
				eObject = (EObject)selection;
			}
		}
		return eObject;
	}

/**
 * 
 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
 *
 * @param event
 * @return null
 * @throws ExecutionException
 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		EObject selectedObject=getSelectedElement();

		//test if this is a constraint
		if( selectedObject instanceof Constraint){
			Constraint constraint= (Constraint)selectedObject;

			//test if this is an opaqueExpression
			if( constraint.getSpecification() instanceof OpaqueExpression){
				OpaqueExpression opaqueExpression= ((OpaqueExpression)constraint.getSpecification());

				//look for the good body named OCL
				int indexOfOCLBody=-1;
				for (int i = 0 ; i < opaqueExpression.getLanguages().size() && indexOfOCLBody == -1 ; i++) {
					if (opaqueExpression.getLanguages().get(i).equals("OCL")) {
						indexOfOCLBody = i ;
					}
				}
				if( indexOfOCLBody!=-1){
					try {
						OCLEvaluationView view=(OCLEvaluationView)HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().showView(OCLEvaluationView.ID);
						view.compute(constraint.getContext(), opaqueExpression.getBodies().get(indexOfOCLBody));
					} catch (PartInitException e) {
						e.printStackTrace();
					}
				}


			}
		}

		return null;
	}

	/**
	 * return the root package from an element
	 * @param elem the element
	 * @return the root package 
	 */
	protected org.eclipse.uml2.uml.Package getToPackage(Element elem){
		org.eclipse.uml2.uml.Package tmp= elem.getNearestPackage();
		while(tmp.getOwner()!=null && (tmp.getOwner()instanceof Package)){
			tmp= (org.eclipse.uml2.uml.Package)tmp.getOwner();
		}
		return tmp;
	}
	
	@Override
	public boolean isEnabled() {
		EObject eObject=getSelectedElement();
		if( eObject instanceof Constraint){
			if( !(getToPackage((Element)eObject) instanceof Profile)){
				return true;
			}
		}
		return false;
	}

}