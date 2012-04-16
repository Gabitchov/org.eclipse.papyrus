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
package org.eclipse.papyrus.uml.diagram.usecase.edit.policies;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.diagram.usecase.command.CustomSubjectClassifierCreateCommandTN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.commands.SubjectClassifierCreateCommandTN;
import org.eclipse.papyrus.uml.diagram.usecase.providers.UMLElementTypes;


/**
 * this class is used to specialize the creation of a subject here a classifier
 * before to propose element it test if can create it.
 * 
 * there also the possibility to add parameter to the request in order to precise the semantic to avoid the selecion dialog.
 *
 */
public class CustomUseCaseDiagramItemSemanticEditPolicy extends UseCaseDiagramItemSemanticEditPolicy {
	public static final String SUBJECT_SEMANTIC_HINT = "Subject_SemanticHint";
	ArrayList<IHintedType> possibleSubject= new ArrayList<IHintedType>();

	public CustomUseCaseDiagramItemSemanticEditPolicy() {
		possibleSubject.add(org.eclipse.papyrus.uml.service.types.element.UMLElementTypes.CLASS);
		possibleSubject.add(org.eclipse.papyrus.uml.service.types.element.UMLElementTypes.INTERFACE);
		possibleSubject.add(org.eclipse.papyrus.uml.service.types.element.UMLElementTypes.COMPONENT);
		possibleSubject.add(org.eclipse.papyrus.uml.service.types.element.UMLElementTypes.DATA_TYPE);
		possibleSubject.add(org.eclipse.papyrus.uml.service.types.element.UMLElementTypes.STATE_MACHINE);
		possibleSubject.add(org.eclipse.papyrus.uml.service.types.element.UMLElementTypes.SIGNAL);
	}
	@Override
	protected Command getCreateCommand(CreateElementRequest req) {
		//the case of the subject the semantic element can be various
		EObject containerElement=req.getContainer();

		if(UMLElementTypes.Classifier_2015 == req.getElementType()) {
			ArrayList<ICommand> executableCommandCreation=new ArrayList<ICommand>();
			ArrayList<IHintedType> executableHTypeCreation=new ArrayList<IHintedType>();

			// test if the semantic is preciced
			if(req.getParameter(SUBJECT_SEMANTIC_HINT)!=null){
				IHintedType semanticHint=(IHintedType)req.getParameter(SUBJECT_SEMANTIC_HINT);
				CreateElementRequest createElementRequest= new CreateElementRequest(containerElement, semanticHint);
				IElementEditService provider = ElementEditServiceUtils.getCommandProvider(containerElement);
				ICommand createCommand = provider.getEditCommand(createElementRequest);
				if (createCommand.canExecute()){
					executableCommandCreation.add(createCommand);
					executableHTypeCreation.add(semanticHint);
				}
			}
			else{
				// no precision, so try to find all possibles commands
				for( int i=0; i<possibleSubject.size();i++){
					IHintedType currentHType=possibleSubject.get(i);

					CreateElementRequest createElementRequest= new CreateElementRequest(containerElement, currentHType);
					IElementEditService provider = ElementEditServiceUtils.getCommandProvider(containerElement);
					ICommand createCommand = provider.getEditCommand(createElementRequest);
					if (createCommand.canExecute()){
						executableCommandCreation.add(createCommand);
						executableHTypeCreation.add(currentHType);
					}

				}
			}

			//only one command so no dialog
			if(executableCommandCreation.size()==1){
				return new ICommandProxy(executableCommandCreation.get(0));
			}
			// several possible command--> dialog is set.
			else if(executableCommandCreation.size()>1){
				return new ICommandProxy(new  CustomSubjectClassifierCreateCommandTN(req, containerElement, executableHTypeCreation));
			}
			return getGEFWrapper(new SubjectClassifierCreateCommandTN(req));
		}

		return super.getCreateCommand(req);


	}
}
//SubjectSelectionDialog dialog= new SubjectSelectionDialog(new Shell(), SWT.NATIVE);
//dialog.open();
//Classifier newElement=null;
//EClass eclass=dialog.getSelectedMetaclass();
//IElementType elementType=ElementTypeRegistry.getInstance().getElementType(eclass,ClientContextManager.getInstance().getClientContext("org.eclipse.papyrus.infra.services.edit.TypeContext"));
//EObject element=((CreateElementRequest)getRequest()).getContainer();
//CreateElementRequest createElementRequest= new CreateElementRequest(element, elementType);
//
//IElementEditService provider = ElementEditServiceUtils.getCommandProvider(element);
//if(provider != null) {
//	// Retrieve delete command from the Element Edit service
//	ICommand createCommand = provider.getEditCommand(createElementRequest);
//	createCommand.execute(new NullProgressMonitor(), null);
//	createCommand.getCommandResult().getReturnValue();
//	newElement=(Classifier)createCommand.getCommandResult().getReturnValue();
//}
//return  CommandResult.newOKCommandResult(newElement);