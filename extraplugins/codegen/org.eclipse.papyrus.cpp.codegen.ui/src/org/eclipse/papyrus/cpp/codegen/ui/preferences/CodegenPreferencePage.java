/*******************************************************************************
 * Copyright (c) 2013 CEA LIST
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Ansgar Radermacher - Initial API and implementation
 *******************************************************************************/

package org.eclipse.papyrus.cpp.codegen.ui.preferences;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.papyrus.cpp.codegen.Activator;
import org.eclipse.papyrus.cpp.codegen.preferences.CppCodeGenConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;


/**
 * This class represents a preference page that is contributed to the
 * Preferences dialog. By subclassing <samp>FieldEditorPreferencePage </samp>,
 * we can use the field support built into JFace that allows us to create a page
 * that is small and knows how to save, restore and apply itself.
 * <p>
 * This page is used to modify preferences only. They are stored in the preference store that belongs to the main plug-in class. That way, preferences
 * can be accessed directly via the preference store.
 */

public class CodegenPreferencePage extends FieldEditorPreferencePage implements
	IWorkbenchPreferencePage {

	private Document pCommentDoc = new Document();

	public CodegenPreferencePage() {
		super(GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription("This preferences page allows to customize Papyrus C++ code generation");
	}

	public void addTextField(String name, String label, Document currentDoc) {
		// ///////////////////////////////////////////////////////////////////////
		// Create a Group for the text
		// ///////////////////////////////////////////////////////////////////////
		Group txtGroup = new Group(getFieldEditorParent(), SWT.RESIZE);
		txtGroup.setLayout(new FillLayout());
		txtGroup.setText(label);
		GridData gd = new GridData(GridData.FILL_BOTH /* FILL_HORIZONTAL */);
		// gd.heightHint = 250;
		gd.horizontalSpan = 2;
		txtGroup.setLayoutData(gd);

		// Text area
		SourceViewer txtViewer = new SourceViewer(txtGroup, null, SWT.MULTI
			| SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);

		txtViewer.setDocument(currentDoc);

		// Retrieving existing preference
		String content = getPreferenceStore().getString(name);

		// Loading preference in txt zone
		currentDoc.set(content);

	}

	/**
	 * Creates the field editors. Field editors are abstractions of the common
	 * GUI blocks needed to manipulate various types of preferences. Each field
	 * editor knows how to save and restore itself.
	 */

	@Override
	public void createFieldEditors() {

		addField(new StringFieldEditor(CppCodeGenConstants.P_HEADER_SUFFIX,
			"Suffix for C++ header files ", getFieldEditorParent()));
		addField(new StringFieldEditor(CppCodeGenConstants.P_IMPLEM_SUFFIX,
			"Suffix for C++ implementation files ", getFieldEditorParent()));

		// Add P_COMMENT_HEADER
		addTextField(CppCodeGenConstants.P_COMMENT_HEADER, "Header for generated files",
			pCommentDoc);
	}

	public void init(IWorkbench workbench) {
	}

	@Override
	public void performDefaults() {

		// initialize comment field from default
		pCommentDoc.set(getPreferenceStore().getDefaultString(CppCodeGenConstants.P_COMMENT_HEADER));
		super.performDefaults();
	}

	@Override
	public boolean performOk() {

		// Store txt for P_COMMENT_HEADER
		String currentComment = pCommentDoc.get();
		getPreferenceStore().setValue(CppCodeGenConstants.P_COMMENT_HEADER, currentComment);

		return super.performOk();
	}
}
