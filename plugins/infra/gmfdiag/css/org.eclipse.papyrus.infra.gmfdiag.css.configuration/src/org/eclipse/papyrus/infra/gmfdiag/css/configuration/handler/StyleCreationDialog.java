/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.css.configuration.handler;

import java.util.Map;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.css.Attribute;
import org.eclipse.papyrus.infra.gmfdiag.css.Declaration;
import org.eclipse.papyrus.infra.gmfdiag.css.properties.provider.CSSStyleSheetContentProvider;
import org.eclipse.papyrus.infra.gmfdiag.css.properties.provider.CSSStyleSheetLabelProvider;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.EmbeddedStyleSheet;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StyleSheet;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StyleSheetReference;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StylesheetsFactory;
import org.eclipse.papyrus.infra.widgets.editors.AbstractEditor;
import org.eclipse.papyrus.infra.widgets.editors.ICommitListener;
import org.eclipse.papyrus.infra.widgets.editors.ReferenceDialog;
import org.eclipse.papyrus.infra.widgets.editors.StringEditor;
import org.eclipse.papyrus.infra.widgets.editors.StringFileSelector;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;


public class StyleCreationDialog extends AbstractStyleDialog {

	private StringFileSelector externalStylesheetEditor;

	private StringEditor embeddedStylesheetEditor;

	private ReferenceDialog appliedStylesheetEditor;

	private boolean ignoreEvents = false;

	private AbstractEditor stylesheetSource;

	private StyleSheet stylesheet;

	/**
	 * 
	 * @param shell
	 * @param conditions
	 *        inout
	 * @param declarations
	 *        inout
	 * @param selectorName
	 */
	public StyleCreationDialog(Shell shell, Map<Attribute, Boolean> conditions, Map<Declaration, Boolean> declarations, String selectorName, View context) {
		super(shell, conditions, declarations, selectorName, context);
	}

	@Override
	public void create() {
		super.create();

		Composite parent = getDialogArea();

		CTabItem stylesheetTab = new CTabItem(tabFolder, SWT.NONE);
		stylesheetTab.setText("Stylesheet");

		Composite stylesheetContainer = new Composite(tabFolder, SWT.NONE);
		stylesheetContainer.setLayoutData(new GridData(SWT.BEGINNING, SWT.BEGINNING, true, true));
		stylesheetContainer.setBackground(parent.getDisplay().getSystemColor(SWT.COLOR_WHITE));
		stylesheetContainer.setBackgroundMode(SWT.INHERIT_DEFAULT);

		stylesheetTab.setControl(stylesheetContainer);
		createStylesheet(stylesheetContainer);

		getShell().setText("Create a new style");
	}

	@Override
	protected boolean isValid() {
		boolean result = true;

		//There must be a stylesheet
		if(getStyleSheet() == null) {
			setError("You must select a Stylesheet");
			result = false;
		}

		//EmbeddedStyleSheets are not yet supported
		if(getStyleSheet() instanceof EmbeddedStyleSheet) {
			setError("Edition of embedded stylesheets is not yet supported. Please select an external stylesheet");
			result = false;
		}

		return super.isValid() && result;
	}

	protected void createStylesheet(Composite parent) {
		//TODO: Use a preference to remember the last edited Stylesheet (Per model? Diagram? Workspace? With user choice?)

		parent.setLayout(new GridLayout(1, false));

		//Create or use an existing External Stylesheet
		externalStylesheetEditor = new StringFileSelector(parent, SWT.NONE);
		externalStylesheetEditor.setFilters(new String[]{ "*.css", "*" }, new String[]{ "CSS Stylesheets (*.css)", "All (*)" });
		externalStylesheetEditor.setAllowFileSystem(false);
		externalStylesheetEditor.setLabel("External stylesheet:");
		externalStylesheetEditor.setToolTipText("Create or use an existing external CSS Stylesheet");
		externalStylesheetEditor.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
		externalStylesheetEditor.addCommitListener(new ICommitListener() {

			public void commit(AbstractEditor editor) {
				String path = (String)((StringEditor)editor).getValue();


				if((path != null && !"".equals(path)) || stylesheetSource == externalStylesheetEditor) {
					StyleSheetReference stylesheetReference = null;
					if(path != null && !"".equals(path)) {
						stylesheetReference = StylesheetsFactory.eINSTANCE.createStyleSheetReference();
						stylesheetReference.setPath(path);
					}

					stylesheet = stylesheetReference;
					resetStylesheetEditors(externalStylesheetEditor);
					updateButtons();
				}
			}
		});

		Label orLabel = new Label(parent, SWT.NONE);
		orLabel.setText("-- OR --");

		//Create a new Embedded Stylesheet
		embeddedStylesheetEditor = new StringEditor(parent, SWT.NONE);
		embeddedStylesheetEditor.setLabel("New local stylesheet:");

		//FIXME: Change the tooltip text when the X-Text editor can edit local stylesheets 
		embeddedStylesheetEditor.setToolTipText("Enter the new local stylesheet's name");
		//		embeddedStylesheetEditor.setToolTipText("Create a new local stylesheet. The stylesheet will be embedded in the current model. Unsupported yet");

		//FIXME: Set read only to false when the X-Text editor can edit local stylesheets
		embeddedStylesheetEditor.setReadOnly(true);
		embeddedStylesheetEditor.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
		embeddedStylesheetEditor.addCommitListener(new ICommitListener() {

			public void commit(AbstractEditor editor) {
				//TODO: Check empty names & set the stylesheet to null when the name is null/empty
				String name = (String)((StringEditor)editor).getValue();
				EmbeddedStyleSheet embeddedStylesheet = StylesheetsFactory.eINSTANCE.createEmbeddedStyleSheet();
				embeddedStylesheet.setLabel(name);
				stylesheet = embeddedStylesheet;
				resetStylesheetEditors(embeddedStylesheetEditor);
				updateButtons();
			}
		});

		orLabel = new Label(parent, SWT.NONE);
		orLabel.setText("-- OR --");

		//Use an existing applied stylesheet (Either Reference or Embedded)
		appliedStylesheetEditor = new ReferenceDialog(parent, SWT.NONE);
		appliedStylesheetEditor.setLabel("Applied stylesheet:");
		appliedStylesheetEditor.setToolTipText("Use an existing stylesheet, from the stylesheets applied to the current model");
		appliedStylesheetEditor.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
		appliedStylesheetEditor.setContentProvider(new CSSStyleSheetContentProvider(contextView));
		appliedStylesheetEditor.setLabelProvider(new CSSStyleSheetLabelProvider());
		appliedStylesheetEditor.addCommitListener(new ICommitListener() {

			public void commit(AbstractEditor editor) {
				StyleSheet value = (StyleSheet)((ReferenceDialog)editor).getValue();
				if(!(ignoreEvents && value == null)) {
					stylesheet = value;
					resetStylesheetEditors(appliedStylesheetEditor);
				}
				updateButtons();
			}
		});

	}

	private void resetStylesheetEditors(AbstractEditor stylesheetSource) {
		if(ignoreEvents) {
			return;
		}

		ignoreEvents = true;
		if(stylesheetSource != externalStylesheetEditor) {
			externalStylesheetEditor.setValue(null);
		}

		if(stylesheetSource != embeddedStylesheetEditor) {
			embeddedStylesheetEditor.setValue(null);
		}

		if(stylesheetSource != appliedStylesheetEditor) {
			appliedStylesheetEditor.setValue(null);
		}

		this.stylesheetSource = stylesheetSource;
		ignoreEvents = false;
	}

	public StyleSheet getStyleSheet() {
		return stylesheet;
	}

}
