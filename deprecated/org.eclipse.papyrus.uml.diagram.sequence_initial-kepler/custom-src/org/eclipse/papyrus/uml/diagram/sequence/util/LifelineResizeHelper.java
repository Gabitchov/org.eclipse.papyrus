/*****************************************************************************
 * Copyright (c) 2009 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.util;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;


public class LifelineResizeHelper {

	private static final String MANUAL_LABEL_SIZE = "manual.label.size";
	private static final String CUSTOM_EXTENSION_INFO = "CustomExtensionInfo";

	public static boolean isManualSize(LifelineEditPart lp){
		View view = lp.getNotationView();
		EAnnotation oldAnnotation = view.getEAnnotation(CUSTOM_EXTENSION_INFO);
		if(oldAnnotation != null) {			
			String val = oldAnnotation.getDetails().get(MANUAL_LABEL_SIZE);
			return "true".equalsIgnoreCase(val);
		}
		return false;
	}
	
	public static ICommand createManualLabelSizeCommand(TransactionalEditingDomain domain, IAdaptable adapter){
		return new ManualLabelSizeCommand(domain, adapter, CUSTOM_EXTENSION_INFO);
	}
	
	public static ICommand createManualLabelSizeCommand(LifelineEditPart lifelineEP){
		return new ManualLabelSizeCommand(lifelineEP.getEditingDomain(), lifelineEP.getNotationView(), CUSTOM_EXTENSION_INFO);
	}
	
	public static class ManualLabelSizeCommand extends AbstractTransactionalCommand {

		public EModelElement getObject() {
			if(object != null)
				return object;
			if(adapter != null){
				return (View)adapter.getAdapter(View.class);
			}
			return null;
		}		

		/** The object. */
		private EModelElement object;

		/** The e annotation name. */
		private String eAnnotationName;
		
		private IAdaptable adapter;
		
		public ManualLabelSizeCommand(TransactionalEditingDomain domain, EModelElement object, String eannotationName) {
			super(domain,"manual size", null);
			this.object = object;
			this.eAnnotationName = eannotationName;
		}
		
		public ManualLabelSizeCommand(TransactionalEditingDomain domain, IAdaptable adapter, String eannotationName) {
			super(domain,"manual size", null);
			this.adapter = adapter;
			this.eAnnotationName = eannotationName;
		}
 
		protected EAnnotation createEAnnotation() {
			EAnnotation eannotation = EcoreFactory.eINSTANCE.createEAnnotation();
			eannotation.setSource(eAnnotationName);
			return eannotation;
		}
		
		protected void attachEannotation(EAnnotation annotation, EModelElement object) {
			object.getEAnnotations().add(annotation);
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			EAnnotation oldAnnotation = getObject().getEAnnotation(eAnnotationName);
			if(oldAnnotation == null) {
				oldAnnotation = createEAnnotation();
				attachEannotation(oldAnnotation, getObject());
			}
			oldAnnotation.getDetails().put(MANUAL_LABEL_SIZE, "true");
			return CommandResult.newOKCommandResult();
		}
	}
	
}
