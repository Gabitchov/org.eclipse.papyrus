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
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.papyrus.properties.contexts.Context;
import org.eclipse.papyrus.properties.contexts.ContextsFactory;
import org.eclipse.papyrus.properties.contexts.DataContextElement;
import org.eclipse.papyrus.properties.contexts.Property;
import org.eclipse.papyrus.properties.contexts.Section;
import org.eclipse.papyrus.properties.contexts.Tab;
import org.eclipse.papyrus.properties.contexts.View;
import org.eclipse.papyrus.properties.generation.Activator;
import org.eclipse.papyrus.properties.generation.fieldselection.ContextElement;
import org.eclipse.papyrus.properties.generation.fieldselection.FieldSelection;
import org.eclipse.papyrus.properties.generation.fieldselection.PropertyDefinition;
import org.eclipse.papyrus.properties.generation.generators.IGenerator;
import org.eclipse.papyrus.properties.generation.layout.ILayoutGenerator;
import org.eclipse.papyrus.properties.generation.wizard.widget.TernaryButton;
import org.eclipse.papyrus.properties.runtime.ConfigurationManager;
import org.eclipse.papyrus.properties.ui.PropertyEditor;
import org.eclipse.papyrus.properties.ui.UiFactory;
import org.eclipse.papyrus.properties.ui.ValueAttribute;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;


public class CreateContextWizard extends Wizard implements INewWizard {

	protected CreateContextMainPage mainPage;

	protected GeneratorPage generatorPage;

	//protected LayoutPage layout;

	protected SelectFieldsPage selectFieldsPage;

	protected static List<IGenerator> contextGenerators = new LinkedList<IGenerator>();

	protected static List<ILayoutGenerator> layoutGenerators = new LinkedList<ILayoutGenerator>();

	protected Context context;

	protected IGenerator generator;

	protected ILayoutGenerator layoutGenerator;

	@Override
	public boolean performFinish() {
		if(generator == null || context == null) {
			return false;
		}

		ConfigurationManager configManager = ConfigurationManager.instance;

		Tab defaultTab = ContextsFactory.eINSTANCE.createTab();
		defaultTab.setCategory("default"); //$NON-NLS-1$
		defaultTab.setId("default"); //$NON-NLS-1$
		defaultTab.setLabel("Default"); //$NON-NLS-1$
		context.getTabs().add(defaultTab);

		FieldSelection fieldSelection = selectFieldsPage.getFieldSelection();

		layoutGenerator = layoutGenerators.get(0);
		for(View view : context.getViews()) {
			List<PropertyEditor> editors = new LinkedList<PropertyEditor>();
			for(DataContextElement element : getAllContextElements(view.getDatacontexts())) {
				for(Property property : element.getProperties()) {
					if(isSelected(fieldSelection, property, view.getElementMultiplicity() != 1)) {
						PropertyEditor editor = UiFactory.eINSTANCE.createPropertyEditor();
						editor.setProperty(property);
						editor.setWidgetType(configManager.getDefaultEditorType(property));
						editors.add(editor);
						ValueAttribute input = UiFactory.eINSTANCE.createValueAttribute();
						input.setName("input"); //$NON-NLS-1$
						input.setValue("{Binding}"); //$NON-NLS-1$
						editor.getAttributes().add(input);
					}
				}
			}

			List<Section> generatedSections = layoutGenerator.layoutElements(editors, view);
			defaultTab.getSections().addAll(generatedSections);
			view.getSections().addAll(generatedSections);
			context.getViews().add(view);
		}

		try {
			context.eResource().save(Collections.EMPTY_MAP);
			//TODO : Add a progress bar here
			for(Tab tab : context.getTabs()) {
				for(Section section : tab.getSections()) {
					section.getWidget().eResource().save(Collections.EMPTY_MAP);
				}
			}
			return true;
		} catch (IOException ex) {
			Activator.log.error(ex);
			return false;
		}
	}

	public boolean isSelected(FieldSelection fieldSelection, Property property, boolean multiple) {
		PropertyDefinition definition = getPropertyDefinition(fieldSelection, property);
		if(definition == null) {
			return false;
		}
		TernaryButton.State value = multiple ? definition.getValueMultiple() : definition.getValueSingle();
		switch(value) {
		case TRUE:
			return true;
		case FALSE:
			return false;
		case DEFAULT:
			return multiple ? generator.isSelectedMultiple(property) : generator.isSelectedSingle(property);
		}

		return false;
	}

	public PropertyDefinition getPropertyDefinition(FieldSelection fieldSelection, Property property) {
		List<String> propertyPath = getPropertyPath(property.getContextElement());
		if(propertyPath.isEmpty()) {
			return null;
		}

		ContextElement currentElement = null;
		for(ContextElement contextRoot : fieldSelection.getContextElements()) {
			if(contextRoot.getName().equals(propertyPath.get(0))) {
				currentElement = contextRoot;
			}
		}
		propertyPath.remove(0);
		if(currentElement == null)
			return null;

		while(propertyPath.size() > 0) {
			String name = propertyPath.get(0);
			propertyPath.remove(0);
			currentElement = findByName(currentElement, name);
		}

		for(PropertyDefinition definition : currentElement.getProperties()) {
			if(definition.getName().equals(property.getName())) {
				return definition;
			}
		}

		return null;
	}

	public ContextElement findByName(ContextElement source, String name) {
		for(ContextElement element : source.getElements()) {
			if(element.getName().equals(name))
				return element;
		}
		return null;
	}

	public List<String> getPropertyPath(DataContextElement element) {
		List<String> result;
		if(element.getPackage() == null) {
			result = new LinkedList<String>();
		} else {
			result = getPropertyPath(element.getPackage());
		}
		result.add(element.getName());
		return result;
	}

	public Set<DataContextElement> getAllContextElements(List<DataContextElement> source) {
		Set<DataContextElement> result = new HashSet<DataContextElement>();
		for(DataContextElement element : source) {
			getAllContextElements(element, result);
		}
		return result;
	}

	public void getAllContextElements(DataContextElement source, Set<DataContextElement> result) {
		if(result.contains(source))
			return;

		result.add(source);
		for(DataContextElement element : source.getSupertypes()) {
			getAllContextElements(element, result);
		}
	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		addPage(mainPage = new CreateContextMainPage());
		addPage(generatorPage = new GeneratorPage());
		addPage(selectFieldsPage = new SelectFieldsPage());
		//addPage(layout = new LayoutPage());

		setWindowTitle("New Property view Context");

	}

	public void setGenerator(IGenerator generator) {
		this.generator = generator;
		generatorPage.setGenerator(generator);
	}

	public void setContext(Context context) {
		this.context = context;
	}

	public static void addGenerator(IGenerator generator) {
		contextGenerators.add(generator);
	}

	public static void addLayoutGenerator(ILayoutGenerator generator) {
		layoutGenerators.add(generator);
	}

}
