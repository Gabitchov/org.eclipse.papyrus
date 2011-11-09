/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.customization.properties.generation.wizard;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.papyrus.customization.properties.generation.Activator;
import org.eclipse.papyrus.customization.properties.generation.fieldselection.ContextElement;
import org.eclipse.papyrus.customization.properties.generation.fieldselection.FieldSelection;
import org.eclipse.papyrus.customization.properties.generation.fieldselection.FieldSelectionFactory;
import org.eclipse.papyrus.customization.properties.generation.fieldselection.FieldSelectionPackage;
import org.eclipse.papyrus.customization.properties.generation.fieldselection.PropertyDefinition;
import org.eclipse.papyrus.customization.properties.generation.generators.IGenerator;
import org.eclipse.papyrus.customization.properties.generation.messages.Messages;
import org.eclipse.papyrus.customization.properties.generation.wizard.widget.TernaryButton;
import org.eclipse.papyrus.views.properties.contexts.Context;
import org.eclipse.papyrus.views.properties.contexts.DataContextElement;
import org.eclipse.papyrus.views.properties.contexts.DataContextPackage;
import org.eclipse.papyrus.views.properties.contexts.DataContextRoot;
import org.eclipse.papyrus.views.properties.contexts.Property;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

/**
 * A WizardPage to choose the fields that will be displayed in the Property view.
 * For each property, the choice can be either "True", "False" or "Default".
 * The visibility of properties marked as Default is decided by the Generator.
 * When the context is regenerated, the visibility of properties marked as default
 * may change (If the generator is changed)
 * 
 * @author Camille Letavernier
 */
public class SelectFieldsPage extends AbstractCreateContextPage {

	private URI targetURI;

	private Context context;

	private Composite root;

	private Composite fields;

	private FieldSelection fieldSelection;

	/**
	 * Constructor.
	 */
	protected SelectFieldsPage() {
		super(Messages.SelectFieldsPage_title);
	}

	public void createControl(Composite parent) {
		root = new Composite(parent, SWT.NONE);
		root.setLayout(new GridLayout(1, true));

		setControl(root);
		setPageComplete(false);

		setDescription(Messages.SelectFieldsPage_selectFields);
	}

	/**
	 * Sets the generated partial context
	 * 
	 * @param context
	 *        The partially generated context
	 */
	public void setContext(Context context) {
		if(context == null) {
			Activator.log.warn("Generated context is null"); //$NON-NLS-1$
			return;
		}

		this.context = context;

		fieldSelection = createNewFieldSelection();

		getWizard().setContext(context);

		Label label = new Label(root, SWT.NONE);
		label.setText(Messages.SelectFieldsPage_availableFields);

		ScrolledComposite scrollableFields = new ScrolledComposite(root, SWT.V_SCROLL | SWT.H_SCROLL);
		scrollableFields.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		scrollableFields.getVerticalBar().setIncrement(10);

		fields = new Composite(scrollableFields, SWT.NONE);
		scrollableFields.setContent(fields);

		fields.setLayout(new GridLayout(4, false));

		Label fieldLabel = new Label(fields, SWT.NONE);
		Label selectionSingle = new Label(fields, SWT.NONE);
		Label selectionMultiple = new Label(fields, SWT.NONE);
		Label descriptionLabel = new Label(fields, SWT.NONE);

		selectionSingle.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false));
		selectionMultiple.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false));
		descriptionLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false));

		fieldLabel.setText(Messages.SelectFieldsPage_field);
		selectionSingle.setText(Messages.SelectFieldsPage_displaySingle);
		selectionMultiple.setText(Messages.SelectFieldsPage_displayMultiple);
		descriptionLabel.setText(Messages.SelectFieldsPage_description);

		for(DataContextRoot dataContextRoot : context.getDataContexts()) {
			displayFields(dataContextRoot);
		}

		fields.setSize(fields.computeSize(SWT.DEFAULT, SWT.DEFAULT));

		root.layout();
		fields.layout();
		scrollableFields.layout();
	}

	private FieldSelection createNewFieldSelection() {
		FieldSelection selection = FieldSelectionFactory.eINSTANCE.createFieldSelection();

		for(DataContextRoot dataContextRoot : context.getDataContexts()) {
			ContextElement definition = createContextPackage(dataContextRoot);
			selection.getContextElements().add(definition);
		}

		return selection;
	}

	private ContextElement createContextPackage(DataContextPackage sourcePackage) {
		ContextElement element = createContextElement(sourcePackage);

		for(DataContextElement sourceElement : sourcePackage.getElements()) {
			ContextElement subElement;
			if(sourceElement instanceof DataContextPackage) {
				subElement = createContextPackage((DataContextPackage)sourceElement);
			} else {
				subElement = createContextElement(sourceElement);
			}
			element.getElements().add(subElement);
		}
		return element;
	}

	private ContextElement createContextElement(DataContextElement sourceElement) {
		ContextElement element = FieldSelectionFactory.eINSTANCE.createContextElement();
		element.setName(sourceElement.getName());

		for(Property property : sourceElement.getProperties()) {
			PropertyDefinition propertyDefinition = FieldSelectionFactory.eINSTANCE.createPropertyDefinition();
			propertyDefinition.setName(property.getName());
			propertyDefinition.setValueSingle(TernaryButton.State.DEFAULT);
			propertyDefinition.setValueMultiple(TernaryButton.State.DEFAULT);
			element.getProperties().add(propertyDefinition);
		}

		return element;
	}

	private void displayFields(DataContextElement contextElement) {

		if(contextElement.getProperties().size() > 0) {

			Label separator = new Label(fields, SWT.SEPARATOR | SWT.HORIZONTAL);
			GridData data = new GridData(SWT.FILL, SWT.CENTER, true, false, 4, 1);
			separator.setLayoutData(data);

			Label elementName = new Label(fields, SWT.NONE);
			elementName.setText(contextElement.getName());
			FontData[] fontDatas = elementName.getFont().getFontData();
			for(FontData fontData : fontDatas) {
				fontData.setStyle(SWT.BOLD);
				// fontData.setHeight(fontData.getHeight() + 2);
			}
			elementName.setFont(new Font(elementName.getDisplay(), fontDatas));

			data = new GridData(SWT.FILL, SWT.CENTER, true, false, 4, 1);
			elementName.setLayoutData(data);

			Label separator2 = new Label(fields, SWT.SEPARATOR | SWT.HORIZONTAL);
			data = new GridData(SWT.FILL, SWT.CENTER, true, false, 4, 1);
			separator2.setLayoutData(data);

			for(Property property : contextElement.getProperties()) {
				Label label = new Label(fields, SWT.NONE);
				label.setText(property.getName());

				TernaryButton showSingle = new TernaryButton(fields, getGenerator().isSelectedSingle(property));
				TernaryButton showMultiple = new TernaryButton(fields, getGenerator().isSelectedMultiple(property));

				PropertyDefinition propertyDefinition = getWizard().getPropertyDefinition(fieldSelection, property);

				IObservableValue singleValue = EMFProperties.value(FieldSelectionPackage.eINSTANCE.getPropertyDefinition_ValueSingle()).observe(propertyDefinition);
				IObservableValue multipleValue = EMFProperties.value(FieldSelectionPackage.eINSTANCE.getPropertyDefinition_ValueMultiple()).observe(propertyDefinition);

				showSingle.setObservable(singleValue);
				showMultiple.setObservable(multipleValue);

				Label description = new Label(fields, SWT.WRAP);
				String propertyDescription = "";// property.getTooltipText(); //$NON-NLS-1$
				if(propertyDescription == null || propertyDescription.trim().equals("")) { //$NON-NLS-1$
					propertyDescription = Messages.SelectFieldsPage_descriptionNotAvailable;
					description.setAlignment(SWT.CENTER);
				}
				description.setText(propertyDescription);

				data = new GridData(SWT.FILL, SWT.CENTER, true, false);
				label.setLayoutData(data);
				data = new GridData(SWT.FILL, SWT.CENTER, true, false);
				showSingle.setLayoutData(data);
				data = new GridData(SWT.FILL, SWT.CENTER, true, false);
				showMultiple.setLayoutData(data);
				data = new GridData(SWT.CENTER, SWT.CENTER, true, false);
				data.widthHint = 500;
				description.setLayoutData(data);
			}
		}

		if(contextElement instanceof DataContextPackage) {
			DataContextPackage contextPackage = (DataContextPackage)contextElement;
			for(DataContextElement element : contextPackage.getElements()) {
				displayFields(element);
			}
		}
	}

	private IGenerator getGenerator() {
		return getWizard().generator;
	}

	/**
	 * Sets the URI of the generated context
	 * 
	 * @param uri
	 *        The URI of the generated context
	 */
	public void setTargetURI(URI uri) {
		this.targetURI = uri;
	}

	@Override
	public void setVisible(boolean visible) {
		super.setPageComplete(true);
		super.setVisible(visible);
		if(context == null && visible) {
			setContext(getWizard().generator.generate(targetURI));
		}
	}

	/**
	 * @return the result of the user's field selection
	 */
	public FieldSelection getFieldSelection() {
		return fieldSelection;
	}

}
