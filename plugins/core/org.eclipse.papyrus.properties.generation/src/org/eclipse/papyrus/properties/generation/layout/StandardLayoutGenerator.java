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
package org.eclipse.papyrus.properties.generation.layout;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.properties.contexts.ContextsFactory;
import org.eclipse.papyrus.properties.contexts.Property;
import org.eclipse.papyrus.properties.contexts.Section;
import org.eclipse.papyrus.properties.contexts.View;
import org.eclipse.papyrus.properties.environment.CompositeWidgetType;
import org.eclipse.papyrus.properties.environment.LayoutType;
import org.eclipse.papyrus.properties.environment.Type;
import org.eclipse.papyrus.properties.runtime.ConfigurationManager;
import org.eclipse.papyrus.properties.ui.CompositeWidget;
import org.eclipse.papyrus.properties.ui.Layout;
import org.eclipse.papyrus.properties.ui.PropertyEditor;
import org.eclipse.papyrus.properties.ui.UiFactory;
import org.eclipse.papyrus.properties.ui.ValueAttribute;


public class StandardLayoutGenerator implements ILayoutGenerator {

	private TreeMap<Category, List<PropertyEditor>> editorsByCategory = new TreeMap<Category, List<PropertyEditor>>();

	public List<Section> layoutElements(List<PropertyEditor> editors, View parent) {

		editorsByCategory.clear();

		for(PropertyEditor editor : editors) {
			Category category = new Category(editor.getProperty());
			getByCategory(category).add(editor);
		}

		ConfigurationManager configManager = ConfigurationManager.instance;

		Section section = ContextsFactory.eINSTANCE.createSection();
		section.setName(parent.getName());
		section.setSectionFile("ui/" + section.getName().replaceAll(" ", "") + ".xwt"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$

		URI compositeURI = URI.createURI(section.getSectionFile());
		compositeURI = compositeURI.resolve(parent.eResource().getURI());
		Resource resource = parent.eResource().getResourceSet().createResource(compositeURI);

		CompositeWidgetType compositeType = configManager.getDefaultCompositeType();
		LayoutType propertiesLayoutType = configManager.getDefaultLayoutType();

		CompositeWidget sectionRoot = UiFactory.eINSTANCE.createCompositeWidget();
		sectionRoot.setWidgetType(compositeType);
		Layout layout = UiFactory.eINSTANCE.createLayout();
		layout.setLayoutType(propertiesLayoutType);
		sectionRoot.setLayout(layout);
		sectionRoot.getAttributes().addAll(createNamespaces());

		section.setWidget(sectionRoot);

		resource.getContents().add(sectionRoot);

		for(Map.Entry<Category, List<PropertyEditor>> mapping : editorsByCategory.entrySet()) {
			Category category = mapping.getKey();
			List<PropertyEditor> categorizedEditors = mapping.getValue();

			CompositeWidget container = UiFactory.eINSTANCE.createCompositeWidget();
			container.setWidgetType(compositeType);
			layout = UiFactory.eINSTANCE.createLayout();
			container.setLayout(layout);
			ValueAttribute numColumns = UiFactory.eINSTANCE.createValueAttribute();
			numColumns.setName("numColumns"); //$NON-NLS-1$
			numColumns.setValue(category.getNumColumns().toString());
			layout.getAttributes().add(numColumns);
			layout.setLayoutType(propertiesLayoutType);
			container.getWidgets().addAll(categorizedEditors);

			sectionRoot.getWidgets().add(container);
		}

		return Collections.singletonList(section);
	}

	private List<ValueAttribute> createNamespaces() {
		List<ValueAttribute> namespaces = new LinkedList<ValueAttribute>();
		for(Map.Entry<String, String> entry : getNamespaces().entrySet()) {
			ValueAttribute attribute = UiFactory.eINSTANCE.createValueAttribute();
			attribute.setName(entry.getKey());
			attribute.setValue(entry.getValue());
			namespaces.add(attribute);
		}
		return namespaces;
	}

	private Map<String, String> getNamespaces() {
		Map<String, String> namespaces = new HashMap<String, String>();
		namespaces.put("xmlns", "http://www.eclipse.org/xwt/presentation"); //$NON-NLS-1$ //$NON-NLS-2$
		namespaces.put("xmlns:x", "http://www.eclipse.org/xwt"); //$NON-NLS-1$ //$NON-NLS-2$
		namespaces.put("xmlns:ppe", "clr-namespace:org.eclipse.papyrus.properties.widgets"); //$NON-NLS-1$ //$NON-NLS-2$
		namespaces.put("xmlns:ppel", "clr-namespace:org.eclipse.papyrus.properties.widgets.layout"); //$NON-NLS-1$ //$NON-NLS-2$
		return namespaces;
	}

	private List<PropertyEditor> getByCategory(Category category) {
		if(!editorsByCategory.containsKey(category)) {
			editorsByCategory.put(category, new LinkedList<PropertyEditor>());
		}
		return editorsByCategory.get(category);
	}

	private class Category implements Comparable<Category> {

		public Type editorType;

		public int multiplicity;

		public Integer getNumColumns() {
			switch(editorType) {
			case BOOLEAN:
				return 2;
			case ENUMERATION:
				return 1;
			case INTEGER:
				return 2;
			case REFERENCE:
				return 1;
			case STRING:
				return 1;
			}
			return 1; //Cannot happen
		}

		public Category(Property property) {
			this.editorType = property.getType();
			this.multiplicity = property.getMultiplicity();
		}

		@Override
		public int hashCode() {
			return editorType.hashCode() * multiplicity;
		}

		@Override
		public boolean equals(Object o) {
			if(o == null)
				return false;
			if(!(o instanceof Category))
				return false;

			Category category = (Category)o;
			return category.editorType == editorType && category.multiplicity == multiplicity;
		}

		public int compareTo(Category category) {
			if(category == null)
				return -1;

			if(category.multiplicity != multiplicity) {
				return multiplicity == 1 ? -1 : 1;
			}

			int result = getTypeIndex().compareTo(category.getTypeIndex());
			return result;
		}

		public Integer getTypeIndex() {
			int i = 0;
			for(Type type : orderedTypes) {
				if(type == editorType)
					return i;
				i++;
			}
			return orderedTypes.length;
		}

		@Override
		public String toString() {
			return (multiplicity == 1 ? "Single" : "Multiple") + editorType.toString(); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	public static Type[] orderedTypes = new Type[]{ Type.STRING, Type.BOOLEAN, Type.INTEGER, Type.ENUMERATION, Type.REFERENCE };

	public String getName() {
		return "Standard layout generator";
	}
}
