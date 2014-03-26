/*****************************************************************************
 * Copyright (c) 2012, 2014 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 392301
 *  
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.css.configuration.handler;

import static org.eclipse.papyrus.infra.gmfdiag.css.configuration.helper.DiagramTypeHelper.getDiagramType;

import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.e4.ui.css.core.css2.CSS2ColorHelper;
import org.eclipse.gmf.runtime.draw2d.ui.graphics.ColorRegistry;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.papyrus.infra.gmfdiag.css.Attribute;
import org.eclipse.papyrus.infra.gmfdiag.css.AttributeValue;
import org.eclipse.papyrus.infra.gmfdiag.css.Declaration;
import org.eclipse.papyrus.infra.gmfdiag.css.Expression;
import org.eclipse.papyrus.infra.gmfdiag.css.HexColor;
import org.eclipse.papyrus.infra.gmfdiag.css.Name;
import org.eclipse.papyrus.infra.gmfdiag.css.Number;
import org.eclipse.papyrus.infra.gmfdiag.css.SelectorCondition;
import org.eclipse.papyrus.infra.gmfdiag.css.StringValue;
import org.eclipse.papyrus.infra.gmfdiag.css.Subterm;
import org.eclipse.papyrus.infra.gmfdiag.css.Term;
import org.eclipse.papyrus.infra.gmfdiag.css.converters.ColorToGMFConverter;
import org.eclipse.papyrus.infra.gmfdiag.css.util.CssSwitch;
import org.eclipse.papyrus.infra.widgets.editors.AbstractEditor;
import org.eclipse.papyrus.infra.widgets.editors.BooleanCheckbox;
import org.eclipse.papyrus.infra.widgets.editors.EnumRadio;
import org.eclipse.papyrus.infra.widgets.editors.ICommitListener;
import org.eclipse.papyrus.infra.widgets.editors.StringEditor;
import org.eclipse.papyrus.infra.widgets.providers.StaticContentProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.w3c.dom.css.RGBColor;


public abstract class AbstractStyleDialog extends TrayDialog {

	protected final Map<Attribute, Boolean> conditions;

	protected final Map<Declaration, Boolean> declarations;

	protected final String selectorName;

	protected boolean useSelectorName = true;

	protected boolean diagramRestriction = false;

	protected String cssClass;

	protected View contextView;

	protected CLabel errorLabel;

	protected StringEditor selectorPreview;

	protected CTabFolder tabFolder;

	protected Composite conditionsContainer;

	protected Composite declarationsContainer;

	public AbstractStyleDialog(Shell shell, Map<Attribute, Boolean> conditions, Map<Declaration, Boolean> declarations, String selectorName, View context) {
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

		selectorPreview = new StringEditor(parent, SWT.NONE);
		selectorPreview.setReadOnly(true);
		selectorPreview.setLabel("Selector preview:");

		selectorPreview.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
		GridLayout layout = (GridLayout)selectorPreview.getLayout();
		layout.marginWidth = 0;

		tabFolder = new CTabFolder(parent, SWT.BORDER);
		tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		CTabItem conditionsTab = new CTabItem(tabFolder, SWT.NONE);
		CTabItem declarationsTab = new CTabItem(tabFolder, SWT.NONE);

		conditionsTab.setText("Conditions");
		declarationsTab.setText("Properties");

		conditionsContainer = new Composite(tabFolder, SWT.NONE);
		conditionsContainer.setLayoutData(new GridData(SWT.BEGINNING, SWT.BEGINNING, true, true));
		conditionsContainer.setBackground(parent.getDisplay().getSystemColor(SWT.COLOR_WHITE));
		conditionsContainer.setBackgroundMode(SWT.INHERIT_DEFAULT);

		conditionsTab.setControl(conditionsContainer);

		declarationsContainer = new Composite(tabFolder, SWT.NONE);
		declarationsContainer.setLayoutData(new GridData(SWT.BEGINNING, SWT.BEGINNING, true, true));
		declarationsContainer.setBackground(parent.getDisplay().getSystemColor(SWT.COLOR_WHITE));
		declarationsContainer.setBackgroundMode(SWT.INHERIT_DEFAULT);

		declarationsTab.setControl(declarationsContainer);

		createConditions(conditionsContainer);
		createDeclarations(declarationsContainer);

		updateSelectorLabel();
		updateButtons();

		tabFolder.setSelection(conditionsTab);

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
				return value ? getDiagramType(contextView.getDiagram()) + " only" : "Any diagram";
			}
		};

		diagramRestrictionWidget.setProviders(new StaticContentProvider(new Boolean[]{ true, false }), labelProvider);
		diagramRestrictionWidget.setValue(this.diagramRestriction);
		diagramRestrictionWidget.addCommitListener(new ICommitListener() {

			public void commit(AbstractEditor editor) {
				diagramRestriction = (Boolean)((EnumRadio)editor).getValue();
				updateSelectorLabel();
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
				updateSelectorLabel();
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
			checkbox.setValue(conditions.get(currentCondition));

			checkbox.addCommitListener(new ICommitListener() {

				public void commit(AbstractEditor editor) {
					conditions.put(currentCondition, ((BooleanCheckbox)editor).getValue());
					updateSelectorLabel();
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
		styleNameEditor.setValue(cssClass);
		styleNameEditor.addCommitListener(new ICommitListener() {

			public void commit(AbstractEditor editor) {
				cssClass = (String)((StringEditor)editor).getValue();
				updateSelectorLabel();
			}

		});
	}

	protected void createDeclarations(Composite parent) {
		parent.setLayout(new GridLayout(3, false));

		Label declarationsLabel = new Label(parent, SWT.WRAP);
		declarationsLabel.setText("Select the properties you want to set. Unchecked properties will keep their default value\n (Which might be inherited from another style).");
		declarationsLabel.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false, 3, 1));

		for(Declaration declaration : declarations.keySet()) {
			//Separate checkbox and label (Checkbox - Label) - (Checkbox - Label) - (Checkbox - Label)
			//This is required to paint a custom foreground color on non-classic windows Theme 
			//Checkboxes do not support foreground color on Windows, except for the Classic theme
			Composite propertyComposite = new Composite(parent, SWT.NONE);
			GridLayout compositeLayout = new GridLayout(2, false);
			compositeLayout.marginWidth = 0;
			compositeLayout.marginHeight = 0;
			propertyComposite.setLayout(compositeLayout);
			propertyComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));

			String label = declaration.getProperty() + ": " + getLabel(declaration.getExpression());
			final BooleanCheckbox checkbox = new BooleanCheckbox(propertyComposite, SWT.NONE);
			checkbox.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));

			Label labelWidget = new Label(propertyComposite, SWT.NONE);
			labelWidget.setText(label);

			MouseListener listener = new MouseAdapter() {

				@Override
				public void mouseUp(MouseEvent e) {
					checkbox.setValue(!checkbox.getValue());
				}
			};

			propertyComposite.addMouseListener(listener);
			labelWidget.addMouseListener(listener);

			Color[] colors = getColors(declaration.getExpression());
			propertyComposite.setBackground(colors[0]);
			labelWidget.setForeground(colors[1]);

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

	protected Color[] getColors(Expression expression) {
		Term term = expression.getTerms();
		if(term instanceof HexColor) {
			HexColor hexColor = (HexColor)term;
			return getColors(hexColor);
		}

		for(Subterm subterm : expression.getSubterms()) {
			if(subterm.getTerm() instanceof HexColor) {
				return getColors((HexColor)subterm.getTerm());
			}
		}

		return new Color[]{ Display.getDefault().getSystemColor(SWT.COLOR_WHITE), Display.getDefault().getSystemColor(SWT.COLOR_BLACK), };
	}

	protected Color[] getColors(HexColor hexColor) {
		Color[] colors = new Color[]{ Display.getDefault().getSystemColor(SWT.COLOR_WHITE), Display.getDefault().getSystemColor(SWT.COLOR_BLACK), };

		Color color = getColor(hexColor);
		colors[0] = color;

		if(getLightness(color) < 130) {
			colors[1] = Display.getDefault().getSystemColor(SWT.COLOR_WHITE);
		}

		return colors;
	}

	private int getLightness(Color color) {
		//Computes the lightness of the color
		int M = Math.max(color.getGreen(), Math.max(color.getRed(), color.getBlue()));
		int m = Math.min(color.getGreen(), Math.min(color.getRed(), color.getBlue()));
		int L = (M + m) / 2;
		return L;
	}

	protected Color getColor(HexColor color) {
		RGBColor rgbColor = CSS2ColorHelper.getRGBColor("#" + color.getValue());
		int intColor = ColorToGMFConverter.getIntColor(rgbColor);
		return ColorRegistry.getInstance().getColor(intColor);
	}

	public String getCSSClass() {
		if(cssClass != null) {
			return cssClass.trim().equals("") ? null : cssClass.trim();
		}
		return null;
	}

	protected String getLabel(Expression expression) {
		if(expression == null) {
			return "";
		}
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

	protected void updateSelectorLabel() {
		String selectorText = "";

		if(diagramRestriction) {
			selectorText += getDiagramType(contextView.getDiagram()) + " ";
		}

		selectorText += useSelectorName ? selectorName : "*";

		for(Entry<Attribute, Boolean> selectorEntry : conditions.entrySet()) {
			if(selectorEntry.getValue()) {
				Attribute condition = selectorEntry.getKey();
				Attribute attribute = condition;
				AttributeValue value = attribute.getValue();
				selectorText += "[" + attribute.getName() + value.getOperator() + value.getValue() + "]";
			}
		}

		if(cssClass != null && !"".equals(cssClass)) {
			selectorText += "." + cssClass;
		}

		selectorPreview.setValue(selectorText);
		getDialogArea().layout();
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
