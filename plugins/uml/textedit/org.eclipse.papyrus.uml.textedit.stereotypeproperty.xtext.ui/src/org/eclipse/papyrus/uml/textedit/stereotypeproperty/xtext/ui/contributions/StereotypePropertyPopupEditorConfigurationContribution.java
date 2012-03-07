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
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.ui.contributions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.Adaptable;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.extensionpoints.editors.ui.IPopupEditorHelper;
import org.eclipse.papyrus.infra.core.utils.EditorUtils;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.profile.structure.AppliedStereotypeProperty;
import org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.ui.internal.AppliedStereotypePropertyActivator;
import org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.validation.AppliedStereotypePropertyJavaValidator;
import org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.validation.SemanticValidator;
//import org.eclipse.papyrus.views.properties.runtime.modelhandler.emf.EMFUtils;
//import org.eclipse.papyrus.views.properties.runtime.modelhandler.emf.TransactionUtil;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.xtext.gmf.glue.PopupEditorConfiguration;
import org.eclipse.xtext.gmf.glue.edit.part.IXtextEMFReconciler;

import com.google.inject.Injector;


/**
 * @author CEA LIST
 * 
 *         This class is used for contribution to the Papyrus extension point DirectEditor. It is used for the integration
 *         of an xtext generated editor, for properties of UML classifiers.
 * 
 */
public class StereotypePropertyPopupEditorConfigurationContribution extends PopupEditorConfiguration {


	/**
	 * Default implementation of the constructor for this class
	 */
	public StereotypePropertyPopupEditorConfigurationContribution() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.xtext.gmf.glue.PopupEditorConfiguration#createPopupEditorHelper(org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart)
	 */
	@Override
	public IPopupEditorHelper createPopupEditorHelper(Object editPart) {
		// resolves the edit part, 
		IGraphicalEditPart graphicalEditPart = null;
		if(!(editPart instanceof IGraphicalEditPart)) {
			return null;
		}
		graphicalEditPart = (IGraphicalEditPart)editPart;
		if (editPart instanceof IAdaptable){
			AppliedStereotypeProperty appliedStereotypeProperty=(AppliedStereotypeProperty) ((IAdaptable)editPart).getAdapter(AppliedStereotypeProperty.class);
			AppliedStereotypePropertyJavaValidator.init(appliedStereotypeProperty);
			// retrieves the XText injector
			Injector injector = AppliedStereotypePropertyActivator.getInstance().getInjector("org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.AppliedStereotypeProperty");
			// builds the text content and extension for a temporary file, to be edited by the xtext editor
			String textToEdit = "" + this.getTextToEdit(appliedStereotypeProperty);
			String fileExtension = "" + ".stereotypeproperty";
			// builds a new IXtextEMFReconciler.
			// Its purpose is to extract any relevant information from the textual specification,
			// and then merge it in the context UML model if necessary
			IXtextEMFReconciler reconciler = new IXtextEMFReconciler() {

				@Override
				public void reconcile(EObject modelObject, EObject xtextObject) {
					// TODO Auto-generated method stub
					
				}
				
			};
			return super.createPopupEditorHelper(graphicalEditPart, injector, reconciler, textToEdit, fileExtension, new SemanticValidator());
		}
		else{ return null;}
	}

	private CompositeCommand getUpdateCommand(EObject editedObject) {

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xtext.gmf.glue.PopupEditorConfiguration#getTextToEdit(java.lang.Object)
	 */
	@Override
	public String getTextToEdit(Object editedObject) {
		if(editedObject instanceof AppliedStereotypeProperty) {
			return AppliedStereotypePropertyEditorUtil.getLabel((AppliedStereotypeProperty)editedObject).trim();
			// TODO: default values not supported by the grammar
			// TODO: either complete the grammar, or use another label provider
		}
		return "<UNDEFINED>";
	}

}
