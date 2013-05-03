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

package org.eclipse.papyrus.infra.gmfdiag.xtext.glue;

import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.papyrus.extensionpoints.editors.configuration.IPopupEditorConfiguration;
import org.eclipse.papyrus.extensionpoints.editors.ui.IPopupEditorHelper;
import org.eclipse.papyrus.infra.gmfdiag.xtext.glue.edit.part.IXTextSemanticValidator;
import org.eclipse.papyrus.infra.gmfdiag.xtext.glue.edit.part.IXtextEMFReconciler;
import org.eclipse.papyrus.infra.gmfdiag.xtext.glue.edit.part.PopupXtextEditorHelper;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;

import com.google.inject.Injector;


/**
 * @author CEA LIST - Initial contribution and API
 * This class is provided as a basis for contribution to the extension point directEditors of Papyrus,
 * for the case of popup editors.
 * Clients must simply override the method createPopupEditorHelper(Object editPart)
 */
public abstract class PopupEditorConfiguration implements IPopupEditorConfiguration {

	private String language = "";
	
	/**
	 * Default constructor
	 */
	public PopupEditorConfiguration() {
		// Auto-generated constructor stub
	}

	/**
	 * This abstract method must be implemented for the integration of each specific textual editor. 
	 * Implementation usually consist in calling createPopupEditorHelper. 
	 * The implementation must simply determine the values to be passed as parameters of this method call.
	 * 
	 * @param editPart The edit part on which a direct edit has been performed. The type of this element 
	 * is Object, in order to avoid direct dependencies with GMF (see the direct editors extension point of
	 * Papyrus). It is however expected that editPart is instanceof IGraphicalEditPart. 
	 */
	public abstract IPopupEditorHelper createPopupEditorHelper(Object editPart) ;
	
	/**
	 * Basic implementation which simply consists in returning a new PopupXtextEditorHelper
	 * @param editPart The editPart on which a direct edit has been performed.
	 * @param xtextInjector The xtextInjector.
	 * @param xtextEditorContextUpdater The IXtextEditorContextUpdater, to update the currently select xtext editor
	 * @param modelReconciler The IXtextEMFReconciler, to update the context UML model with changes textually specified in the popup xtext editor
	 * @param textToEdit the initialization text, used as the initial textual content for the popup xtext editor 
	 * @param fileExtension the extension for the temporary textual file (underlying the editor)
	 * @param semanticValidator the semantic validator used to semantically validate the model before saving 
	 * @return IPopupEditorHelper
	 */
	public IPopupEditorHelper createPopupEditorHelper(IGraphicalEditPart editPart, 
					Injector xtextInjector,
					IXtextEMFReconciler modelReconciler,
					String textToEdit, 
					String fileExtension,
					IXTextSemanticValidator semanticValidator) {

		return new PopupXtextEditorHelper(editPart, 
						xtextInjector, 
						modelReconciler,
						textToEdit, 
						fileExtension,
						semanticValidator);
	}

	////
	
	public int getStyle() {
		// Auto-generated method stub
		return 0;
	}

	public Point getPreferedSize() {
		// Auto-generated method stub
		return null;
	}

	public SourceViewerConfiguration getSourceViewerConfiguration() {
		// Auto-generated method stub
		return null;
	}

	public String getTextToEdit(Object editedObject) {
		// Auto-generated method stub
		return null;
	}

	public Object preEditAction(Object editedObject) {
		// Auto-generated method stub
		return null;
	}

	public Object postEditAction(Object editedObject, String newText) {
		// Auto-generated method stub
		return null;
	}

	public Composite createExtendedDialogArea(Composite parent) {
		// Auto-generated method stub
		return null;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = "" + language ;
	}

	
	public IInputValidator getInputValidator() {
		// Auto-generated method stub
		return null;
	}

	public void setInputValidator(IInputValidator validator) {
		// Auto-generated method stub
		
	}

	public Selection getTextSelection(String value, Object editedObject) {
		// Auto-generated method stub
		return null;
	}

	
	
}
