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
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.papyrus.infra.gmfdiag.css.Attribute;
import org.eclipse.papyrus.infra.gmfdiag.css.Declaration;
import org.eclipse.papyrus.infra.gmfdiag.css.Expression;
import org.eclipse.papyrus.infra.gmfdiag.css.HexColor;
import org.eclipse.papyrus.infra.gmfdiag.css.Name;
import org.eclipse.papyrus.infra.gmfdiag.css.Number;
import org.eclipse.papyrus.infra.gmfdiag.css.SelectorCondition;
import org.eclipse.papyrus.infra.gmfdiag.css.StringValue;
import org.eclipse.papyrus.infra.gmfdiag.css.Subterm;
import org.eclipse.papyrus.infra.gmfdiag.css.Term;
import org.eclipse.papyrus.infra.gmfdiag.css.properties.provider.CSSStyleSheetContentProvider;
import org.eclipse.papyrus.infra.gmfdiag.css.properties.provider.CSSStyleSheetLabelProvider;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.EmbeddedStyleSheet;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StyleSheet;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StyleSheetReference;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StylesheetsFactory;
import org.eclipse.papyrus.infra.gmfdiag.css.util.CssSwitch;
import org.eclipse.papyrus.infra.widgets.editors.AbstractEditor;
import org.eclipse.papyrus.infra.widgets.editors.BooleanCheckbox;
import org.eclipse.papyrus.infra.widgets.editors.EnumRadio;
import org.eclipse.papyrus.infra.widgets.editors.ICommitListener;
import org.eclipse.papyrus.infra.widgets.editors.ReferenceDialog;
import org.eclipse.papyrus.infra.widgets.editors.StringEditor;
import org.eclipse.papyrus.infra.widgets.editors.StringFileSelector;
import org.eclipse.papyrus.infra.widgets.providers.StaticContentProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;


public class StyleCreationDialog extends TrayDialog {

	private final Map<SelectorCondition, Boolean> conditions;

	private final Map<Declaration, Boolean> declarations;

	private final String selectorName;

	private boolean useSelectorName = true;

	private boolean diagramRestriction = false;

	private String cssClass;

	private View contextView;

	private StyleSheet stylesheet;

	private CLabel errorLabel;

	/**
	 * 
	 * @param shell
	 * @param conditions
	 *        inout
	 * @param declarations
	 *        inout
	 * @param selectorName
	 */
	public StyleCreationDialog(Shell shell, Map<SelectorCondition, Boolean> conditions, Map<Declaration, Boolean> declarations, String selectorName, View context) {
		super(shell);
		this.conditions = conditions;
		this.declarations = declarations;
		this.selectorName = selectorName;
		this.contextView = context;
	}

	@Override
	public void create() {
		super.create();
		Composite parent = getDialogArea();

		CTabFolder tabFolder = new CTabFolder(parent, SWT.BORDER);
		tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		CTabItem conditionsTab = new CTabItem(tabFolder, SWT.NONE);
		CTabItem declarationsTab = new CTabItem(tabFolder, SWT.NONE);
		CTabItem stylesheetTab = new CTabItem(tabFolder, SWT.NONE);

		conditionsTab.setText("Conditions");
		declarationsTab.setText("Properties");
		stylesheetTab.setText("Stylesheet");

		Composite conditionsContainer = new Composite(tabFolder, SWT.NONE);
		conditionsContainer.setLayoutData(new GridData(SWT.BEGINNING, SWT.BEGINNING, true, true));
		conditionsContainer.setBackground(parent.getDisplay().getSystemColor(SWT.COLOR_WHITE));
		conditionsContainer.setBackgroundMode(SWT.INHERIT_DEFAULT);

		conditionsTab.setControl(conditionsContainer);

		Composite declarationsContainer = new Composite(tabFolder, SWT.NONE);
		declarationsContainer.setLayoutData(new GridData(SWT.BEGINNING, SWT.BEGINNING, true, true));
		declarationsContainer.setBackground(parent.getDisplay().getSystemColor(SWT.COLOR_WHITE));
		declarationsContainer.setBackgroundMode(SWT.INHERIT_DEFAULT);

		declarationsTab.setControl(declarationsContainer);

		Composite stylesheetContainer = new Composite(tabFolder, SWT.NONE);
		stylesheetContainer.setLayoutData(new GridData(SWT.BEGINNING, SWT.BEGINNING, true, true));
		stylesheetContainer.setBackground(parent.getDisplay().getSystemColor(SWT.COLOR_WHITE));
		stylesheetContainer.setBackgroundMode(SWT.INHERIT_DEFAULT);

		stylesheetTab.setControl(stylesheetContainer);

		createConditions(conditionsContainer);
		createDeclarations(declarationsContainer);
		createStylesheet(stylesheetContainer);

		updateButtons();

		getShell().setText("New Style");
		getShell().pack();
	}

	protected void updateButtons() {
		//Resets the error message
		setError(null);
		getButton(IDialogConstants.OK_ID).setEnabled(isValid());
		getDialogArea().layout();
	}

	protected boolean isValid() {
		boolean result = true;

		//There must be a stylesheet
		if(getStylesheet() == null) {
			setError("You must select a Stylesheet");
			result = false;
		}

		//There must be at least one property declaration
		boolean atLeastOneDeclaration = false;
		for(Boolean value : declarations.values()) {
			if(value) {
				atLeastOneDeclaration = true;
				break;
			}
		}

		result = result && atLeastOneDeclaration;

		if(!atLeastOneDeclaration) {
			setError("There must be at least one property declaration");
		}

		return result;
	}

	protected void setError(String errorMessage) {
		if(errorMessage == null && errorLabel != null) {
			errorLabel.dispose();
			errorLabel = null;
			return;
		}

		if(errorMessage != null) {
			if(errorLabel == null) {
				errorLabel = new CLabel(getDialogArea(), SWT.WRAP);
				errorLabel.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
				errorLabel.setImage(org.eclipse.papyrus.infra.widgets.Activator.getDefault().getImage("icons/error.gif"));
			}

			if(errorLabel.getText() != null && !errorLabel.getText().trim().equals("")) {
				errorLabel.setText(errorLabel.getText() + "\n" + errorMessage);
			} else {
				errorLabel.setText(errorMessage);
			}
		}
	}

	protected void createConditions(Composite parent) {
		parent.setLayout(new GridLayout(3, false));

		Label conditionsLabel = new Label(parent, SWT.WRAP);
		conditionsLabel.setText("Select the condition(s) under which the style will be applied.");
		conditionsLabel.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false, 3, 1));

		createElementNameSection(parent);
		createAttributeSelectorsSection(parent);
		createStyleNameSection(parent);
	}

	protected void createElementNameSection(Composite parent) {
		EnumRadio diagramRestrictionWidget = new EnumRadio(parent, SWT.NONE, "Diagram:");
		diagramRestrictionWidget.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false, 3, 1));

		ILabelProvider labelProvider = new LabelProvider() {

			@Override
			public String getText(Object element) {
				Boolean value = (Boolean)element;
				return value ? contextView.getDiagram().getType() + " only" : "Any diagram";
			}
		};

		diagramRestrictionWidget.setProviders(new StaticContentProvider(new Boolean[]{ true, false }), labelProvider);
		diagramRestrictionWidget.setValue(this.diagramRestriction);
		diagramRestrictionWidget.addCommitListener(new ICommitListener() {

			public void commit(AbstractEditor editor) {
				diagramRestriction = (Boolean)((EnumRadio)editor).getValue();
			}
		});

		EnumRadio selectorNameWidget = new EnumRadio(parent, SWT.NONE, "Applies to:");
		selectorNameWidget.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false, 3, 1));

		labelProvider = new LabelProvider() {

			@Override
			public String getText(Object element) {
				Boolean value = (Boolean)element;
				return value ? selectorName + " only" : "Any kind of element";
			}
		};

		selectorNameWidget.setProviders(new StaticContentProvider(new Boolean[]{ true, false }), labelProvider);
		selectorNameWidget.setValue(this.useSelectorName);
		selectorNameWidget.addCommitListener(new ICommitListener() {

			public void commit(AbstractEditor editor) {
				useSelectorName = (Boolean)((EnumRadio)editor).getValue();
			}
		});
	}

	protected void createAttributeSelectorsSection(Composite parent) {
		if(conditions.isEmpty()) {
			return;
		}

		Label detailLabel = new Label(parent, SWT.NONE);
		detailLabel.setText("If the following properties are matched:");
		detailLabel.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false, 3, 1));

		for(SelectorCondition condition : conditions.keySet()) {
			final Attribute currentCondition = (Attribute)condition;

			String attributeLabel = currentCondition.getName();
			if(currentCondition.getValue() != null) {
				attributeLabel += " " + currentCondition.getValue().getOperator() + " " + currentCondition.getValue().getValue();
			}

			BooleanCheckbox checkbox = new BooleanCheckbox(parent, SWT.NONE, attributeLabel);

			checkbox.addCommitListener(new ICommitListener() {

				public void commit(AbstractEditor editor) {
					conditions.put(currentCondition, ((BooleanCheckbox)editor).getValue());
				}
			});
		}
	}

	protected void createStyleNameSection(Composite parent) {
		Label styleNameLabel = new Label(parent, SWT.WRAP);

		String label = "If a name is used for this style, it will have to be applied manually:";

		styleNameLabel.setText(label);
		styleNameLabel.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false, 3, 1));

		StringEditor styleNameEditor = new StringEditor(parent, SWT.NONE, "Style name:");
		styleNameEditor.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false, 3, 1));
		styleNameEditor.addCommitListener(new ICommitListener() {

			public void commit(AbstractEditor editor) {
				cssClass = (String)((StringEditor)editor).getValue();
			}

		});
	}

	protected void createDeclarations(Composite parent) {
		parent.setLayout(new GridLayout(3, false));

		Label declarationsLabel = new Label(parent, SWT.WRAP);
		declarationsLabel.setText("Select the properties you want to set. Unchecked properties will keep their default value (Which might be inherited from another style).");
		declarationsLabel.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false, 3, 1));

		for(Declaration declaration : declarations.keySet()) {
			String label = declaration.getProperty() + ": " + getLabel(declaration.getExpression());
			BooleanCheckbox checkbox = new BooleanCheckbox(parent, SWT.NONE, label);

			final Declaration currentDeclaration = declaration;

			checkbox.setValue(declarations.get(currentDeclaration));

			checkbox.addCommitListener(new ICommitListener() {

				public void commit(AbstractEditor editor) {
					boolean value = ((BooleanCheckbox)editor).getValue();
					declarations.put(currentDeclaration, value);
					updateButtons();
				}
			});

			checkbox.setValue(declarations.get(declaration));
		}
	}

	protected void createStylesheet(Composite parent) {
		//TODO: Use a preference to remember the last edited Stylesheet (Per model? Diagram? Workspace? With user choice?)

		parent.setLayout(new GridLayout(1, false));

		//Create or use an existing External Stylesheet
		StringFileSelector externalStylesheet = new StringFileSelector(parent, SWT.NONE);
		externalStylesheet.setAllowFileSystem(false);
		externalStylesheet.setLabel("External stylesheet:");
		externalStylesheet.setToolTipText("Create or use an existing external CSS Stylesheet");
		externalStylesheet.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
		externalStylesheet.addCommitListener(new ICommitListener() {

			public void commit(AbstractEditor editor) {
				String path = (String)((StringEditor)editor).getValue();
				if(path != null && !"".equals(path)) {
					StyleSheetReference stylesheetReference = StylesheetsFactory.eINSTANCE.createStyleSheetReference();
					stylesheetReference.setPath(path);
					stylesheet = stylesheetReference;
					updateButtons();
				}
			}
		});

		Label orLabel = new Label(parent, SWT.NONE);
		orLabel.setText("-- OR --");

		//Create a new Embedded Stylesheet
		StringEditor embeddedStylesheet = new StringEditor(parent, SWT.NONE);
		embeddedStylesheet.setLabel("New local stylesheet:");
		embeddedStylesheet.setToolTipText("Create a new local stylesheet. The stylesheet will be embedded in the current model. Unsupported yet");
		embeddedStylesheet.setReadOnly(true);
		embeddedStylesheet.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
		embeddedStylesheet.addCommitListener(new ICommitListener() {

			public void commit(AbstractEditor editor) {
				String name = (String)((StringEditor)editor).getValue();
				EmbeddedStyleSheet embeddedStylesheet = StylesheetsFactory.eINSTANCE.createEmbeddedStyleSheet();
				embeddedStylesheet.setLabel(name);
				stylesheet = embeddedStylesheet;
				updateButtons();
			}
		});

		orLabel = new Label(parent, SWT.NONE);
		orLabel.setText("-- OR --");

		//Use an existing applied stylesheet (Either Reference or Embedded)
		ReferenceDialog appliedStylesheet = new ReferenceDialog(parent, SWT.NONE);
		appliedStylesheet.setLabel("Applied stylesheet:");
		appliedStylesheet.setToolTipText("Use an existing stylesheet, from the stylesheets applied to the current model");
		appliedStylesheet.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
		appliedStylesheet.setContentProvider(new CSSStyleSheetContentProvider(contextView));
		appliedStylesheet.setLabelProvider(new CSSStyleSheetLabelProvider());
		appliedStylesheet.addCommitListener(new ICommitListener() {

			public void commit(AbstractEditor editor) {
				StyleSheet value = (StyleSheet)((ReferenceDialog)editor).getValue();
				stylesheet = value;
				updateButtons();
			}
		});

	}

	public String getCSSClass() {
		if(cssClass != null) {
			return cssClass.trim().equals("") ? null : cssClass.trim();
		}
		return null;
	}

	protected String getLabel(Expression expression) {
		String label = getLabel(expression.getTerms());
		for(Subterm subTerm : expression.getSubterms()) {
			if(subTerm.getOperator() != null) {
				label += subTerm.getOperator();
			}
			label += " " + getLabel(subTerm.getTerm());
		}
		return label;
	}

	protected String getLabel(Term term) {
		return (new CssSwitch<String>() {

			@Override
			public String caseHexColor(HexColor term) {
				return '#' + term.getValue();
			}

			@Override
			public String caseName(Name term) {
				return term.getValue();
			}

			@Override
			public String caseStringValue(StringValue term) {
				return "\"" + term.getValue() + "\"";
			}

			@Override
			public String caseNumber(Number term) {
				String label = "";
				if(term.getOp() != null) {
					label += term.getOp().getOperator();
				}
				label += term.getValue();
				return label;
			}
		}).doSwitch(term);
	}

	public StyleSheet getStylesheet() {
		return stylesheet;
	}

	@Override
	protected boolean isResizable() {
		return true;
	}

	@Override
	public Composite getDialogArea() {
		return (Composite)super.getDialogArea();
	}

	public boolean useSelectorName() {
		return useSelectorName;
	}

	public boolean getDiagramRestriction() {
		return diagramRestriction;
	}

}
