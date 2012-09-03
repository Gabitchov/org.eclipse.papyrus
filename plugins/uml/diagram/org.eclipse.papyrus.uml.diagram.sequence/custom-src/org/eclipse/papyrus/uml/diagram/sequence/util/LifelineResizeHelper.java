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
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;


public class LifelineResizeHelper {

	public static boolean isManualSize(LifelineEditPart lp){
		View view = lp.getNotationView();
		EAnnotation oldAnnotation = view.getEAnnotation("CustomExtensionInfo");
		if(oldAnnotation != null) {			
			String val = oldAnnotation.getDetails().get("manual.label.size");
			return "true".equalsIgnoreCase(val);
		}
		return false;
	}
	
	public static Command createManualLabelSizeCommand(LifelineEditPart lifelineEP){
		ManualLabelSizeCommand m = new ManualLabelSizeCommand(lifelineEP.getEditingDomain(), lifelineEP.getNotationView(), "CustomExtensionInfo");
		return new ICommandProxy(m) ;
	}
	
	public static class ManualLabelSizeCommand extends AbstractTransactionalCommand {

		public EModelElement getObject() {
			return object;
		}		

		/** The object. */
		private EModelElement object;

		/** The e annotation name. */
		private String eAnnotationName;
		
		public ManualLabelSizeCommand(TransactionalEditingDomain domain, EModelElement object, String eannotationName) {
			super(domain,"manual size", null);
			this.object = object;
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
			oldAnnotation.getDetails().put("manual.label.size", "true");
			return CommandResult.newOKCommandResult();
		}
	}
	
}
