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
package org.eclipse.papyrus.properties.generation.wizard;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.papyrus.properties.contexts.Context;
import org.eclipse.papyrus.properties.contexts.DataContextElement;
import org.eclipse.papyrus.properties.contexts.DataContextPackage;
import org.eclipse.papyrus.properties.contexts.DataContextRoot;
import org.eclipse.papyrus.properties.contexts.Property;
import org.eclipse.papyrus.properties.generation.Activator;
import org.eclipse.papyrus.properties.generation.fieldselection.ContextElement;
import org.eclipse.papyrus.properties.generation.fieldselection.FieldSelection;
import org.eclipse.papyrus.properties.generation.fieldselection.FieldSelectionFactory;
import org.eclipse.papyrus.properties.generation.fieldselection.FieldSelectionPackage;
import org.eclipse.papyrus.properties.generation.fieldselection.PropertyDefinition;
import org.eclipse.papyrus.properties.generation.generators.IGenerator;
import org.eclipse.papyrus.properties.generation.wizard.widget.TernaryButton;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class SelectFieldsPage extends AbstractCreateContextPage {

	private URI targetURI;

	private Context context;

	private Composite root;

	private Composite fields;

	private FieldSelection fieldSelection;

	protected SelectFieldsPage() {
		super("Select fields");
	}

	public void createControl(Composite parent) {
		root = new Composite(parent, SWT.NONE);
		root.setLayout(new GridLayout(1, true));

		setControl(root);
		setPageComplete(false);

		setDescription("Select the fields you want to be displayed in the Property view");
	}

	public void setContext(Context context) {
		if(context == null) {
			Activator.log.warn("Generated context is null"); //$NON-NLS-1$
			return;
		}

		this.context = context;

		fieldSelection = createNewFieldSelection();

		getWizard().setContext(context);

		Label label = new Label(root, SWT.NONE);
		label.setText("Available fields :");

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

		fieldLabel.setText("Field");
		selectionSingle.setText("Display single");
		selectionMultiple.setText("Display multiple");
		descriptionLabel.setText("Description");

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


		ResourceSet resourceSet = new ResourceSetImpl();
		URI uri = URI.createPlatformResourceURI("test.xwt/fields.xmi", true); //$NON-NLS-1$
		Resource resource = resourceSet.createResource(uri);
		resource.getContents().add(selection);
		try {
			resource.save(Collections.EMPTY_MAP);
		} catch (IOException ex) {
			Activator.log.error(ex);
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
					propertyDescription = "N/A";
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
		return getWizard().generatorPage.getGenerator();
	}

	public void setTargetURI(URI uri) {
		this.targetURI = uri;
	}

	@Override
	public void setVisible(boolean visible) {
		super.setPageComplete(true);
		super.setVisible(visible);
		if(context == null && visible) {
			setContext(getWizard().generatorPage.getGenerator().generate(targetURI));
		}
	}

	public FieldSelection getFieldSelection() {
		return fieldSelection;
	}

}
