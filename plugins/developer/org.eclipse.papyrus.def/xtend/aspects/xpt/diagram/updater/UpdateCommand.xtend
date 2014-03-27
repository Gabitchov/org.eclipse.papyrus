/**
 * Copyright (c) 2007, 2009, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package aspects.xpt.diagram.updater

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.gmf.codegen.gmfgen.GenDiagramUpdater
import xpt.Common

@Singleton class UpdateCommand extends xpt.diagram.updater.UpdateCommand {
	@Inject extension Common;



	override def execute(GenDiagramUpdater it) '''
		«generatedMemberComment»
		public Object execute(org.eclipse.core.commands.ExecutionEvent event) throws org.eclipse.core.commands.ExecutionException {
			org.eclipse.jface.viewers.ISelection selection = org.eclipse.ui.PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();
			if (selection instanceof org.eclipse.jface.viewers.IStructuredSelection) {
				org.eclipse.jface.viewers.IStructuredSelection structuredSelection = (org.eclipse.jface.viewers.IStructuredSelection) selection;
				if (structuredSelection.size() != 1) {
					return null;
				}
				if (structuredSelection.getFirstElement() instanceof org.eclipse.gef.EditPart && ((org.eclipse.gef.EditPart) structuredSelection.getFirstElement()).getModel() instanceof org.eclipse.gmf.runtime.notation.View) {
					org.eclipse.emf.ecore.EObject modelElement = ((org.eclipse.gmf.runtime.notation.View) ((org.eclipse.gef.EditPart) structuredSelection.getFirstElement()).getModel()).getElement();
					java.util.List<?> editPolicies = org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy.getRegisteredEditPolicies(modelElement);
					for (java.util.Iterator<?> it = editPolicies.iterator(); it.hasNext();) {
						org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy nextEditPolicy = (org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy) it.next();
						nextEditPolicy.refresh();
					}
					
				}
			}
			return null;
		}
	'''
}
