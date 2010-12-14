/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.diagram.profile.service;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.papyrus.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.core.lifecycleevents.DoSaveEvent;
import org.eclipse.papyrus.core.lifecycleevents.ISaveEventListener;
import org.eclipse.papyrus.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.papyrus.diagram.profile.custom.commands.DefineProfileCommand;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.profile.definition.PapyrusDefinitionAnnotation;
import org.eclipse.papyrus.profile.ui.dialogs.ProfileDefinitionDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Profile;

/**
 * This class provides listeners
 * 
 * 
 * This class describes the actions to do just before the save action
 */
public class PreSaveProfileListener implements ISaveEventListener {

	/**
	 * If an error comes here, the save action can't be make entirely -> use try-catch!
	 * 
	 * This function is called before the user make a "save" action
	 */
	public void doSave(DoSaveEvent event) {
		Diagram diag = null;


		try {
			//System.out.println("preSave Event received"); //$NON-NLS-1$
			/**
			 * if the root is a profile, we must define it. If it's another thing, we
			 * do nothing
			 */
			IMultiDiagramEditor multidiag = event.getMultiDiagramEditor();
			if(multidiag instanceof PapyrusMultiDiagramEditor) {
				diag = ((PapyrusMultiDiagramEditor)multidiag).getDiagram();
				
				if(diag == null ||diag.getElement()==null|| (!(diag.getElement() instanceof Profile))) {
					return;
				}
			}

			/**
			 * Does the user want define the profile?
			 */
			String DEFINE_MSG = "In order to apply this profile, it had to be defined.\nWould you like to define it?"; //$NON-NLS-1$
			String PAPYRUS_QUESTION = "Papyrus question"; //$NON-NLS-1$

			boolean result = MessageDialog.openQuestion(Display.getCurrent().getActiveShell(), PAPYRUS_QUESTION, DEFINE_MSG);
			if(!result) {
				return;
			}


			Collection<EditPart> editPartSet = null;
			DiagramEditPart diagramEditPart = null;
			Profile rootProfile = null;

			/**
			 * Obtain the root profile
			 */
			IMultiDiagramEditor diag1 = event.getMultiDiagramEditor();
			Object diagramView = diag1.getAdapter(IDiagramGraphicalViewer.class);
			if(diagramView instanceof DiagramGraphicalViewer) {
				editPartSet = ((DiagramGraphicalViewer)diagramView).getEditPartRegistry().values();

			}
			Iterator<EditPart> editPartIterator = editPartSet.iterator();
			while(editPartIterator.hasNext()) {
				diagramEditPart = DiagramEditPartsUtil.getDiagramEditPart(editPartIterator.next());
				if(diagramEditPart != null)
					break;
			}

			EObject profileEObject = ((Diagram)diagramEditPart.getModel()).getElement();


			if(profileEObject instanceof Profile) {
				rootProfile = (Profile)profileEObject;
			}
			Assert.isNotNull(rootProfile);
			diagramEditPart.getEditingDomain();
			ProfileDefinitionDialog dialog = new ProfileDefinitionDialog(new Shell(), rootProfile);
			dialog.open();
			if(dialog.getReturnCode() == dialog.OK) {



				PapyrusDefinitionAnnotation papyrusAnnotation = dialog.getPapyrusDefinitionAnnotation();
				TransactionalEditingDomain domain = diagramEditPart.getEditingDomain();
				//TODO : research the viewer

				DefineProfileCommand cmd = new DefineProfileCommand(domain, papyrusAnnotation, rootProfile, diagramEditPart.getViewer());
				try {
					diagramEditPart.getDiagramEditDomain().getDiagramCommandStack().execute(new ICommandProxy(cmd));
				} catch (Exception e) {
					e.printStackTrace();
				}

			}


		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * If an error comes here, the save action can't be make entirely -> use try-catch!
	 * 
	 * This function is called before the user make a "save as" action
	 */
	public void doSaveAs(DoSaveEvent event) {
		try {
			//System.out.println("preSaveAS Event received"); //$NON-NLS-1$
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


}
