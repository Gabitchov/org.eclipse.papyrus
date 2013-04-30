/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
package org.eclipse.papyrus.alf.ui.integration;

import org.eclipse.papyrus.alf.ui.internal.AlfActivator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditor;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorFactory;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorModelAccess;
import org.eclipse.xtext.ui.editor.embedded.IEditedResourceProvider;

import com.google.inject.Injector;

@SuppressWarnings("restriction")
public class AlfPopupEditor {

	/**
	 * The context element being edited
	 */
	protected Element contextElement ;

	/**
	 * Optional arguments for the creation of the AlfPopupEditor
	 *  
	 */
	protected Object[] args ;

	/**
	 * The Injector for the Alf editor
	 */
	protected Injector alfInjector = null;

	/**
	 * The parent Shell for embedding the Alf editor
	 */
	protected Shell alfEditorParentComposite ;

	/**
	 * The model access to the Alf editor embedded in alfEditorParentComposite
	 */
	protected EmbeddedEditorModelAccess embeddedEditorAccess ;

	public AlfPopupEditor (Element contextElement, Object[] args) {
		if (contextElement == null)
			return ;
		this.contextElement = contextElement ;
		this.alfInjector = AlfActivator.getInstance().getInjector("org.eclipse.papyrus.alf.Alf");
		this.args = args ;
	}

	public void openEditor() {
		AlfEditorUtils.clean() ;
		// Creation of the parent shell
		this.alfEditorParentComposite = new Shell(SWT.RESIZE | SWT.DIALOG_TRIM | SWT.ON_TOP) ;
		String title = "" ;
		if (contextElement != null) {
			if (contextElement instanceof NamedElement) {
				title += "Editing " + contextElement.eClass().getName() + " " + ((NamedElement)contextElement).getQualifiedName() ;
			}
		}
		this.alfEditorParentComposite.setLayout(new FillLayout()) ;
		this.alfEditorParentComposite.setText(title) ;
		// Creation of the embedded xtext editor
		IEditedResourceProvider embeddedAlfResourceProvider = new AlfEditedResourceProvider(this.alfInjector);
		EmbeddedEditorFactory editorFactory = this.alfInjector.getInstance(EmbeddedEditorFactory.class) ;
		EmbeddedEditor editor = editorFactory.newEditor(embeddedAlfResourceProvider).showErrorAndWarningAnnotations().withParent(this.alfEditorParentComposite);
		this.embeddedEditorAccess = editor.createPartialEditor();
		this.embeddedEditorAccess.updateModel("", AlfEditorUtils.getTextualRepresentation(this.contextElement, this.args), "") ;
		this.registerKeyListener(editor.getViewer().getTextWidget()) ; 
		this.alfEditorParentComposite.setVisible(true);
	}

	protected void registerKeyListener(StyledText textWidget) {
		AlfEditorKeyListener keyListener = new AlfEditorKeyListener(this.contextElement, this.args, this.embeddedEditorAccess) ;
		textWidget.addVerifyKeyListener(keyListener);
		textWidget.addKeyListener(keyListener);
	}

}
