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
package org.eclipse.papyrus.customization.properties.generation.layout;

import java.util.List;

import org.eclipse.papyrus.customization.properties.generation.Activator;
import org.eclipse.papyrus.customization.properties.generation.generators.IGenerator;
import org.eclipse.papyrus.customization.properties.generation.generators.ProfileGenerator;
import org.eclipse.papyrus.views.properties.contexts.Context;
import org.eclipse.papyrus.views.properties.contexts.DataContextElement;
import org.eclipse.papyrus.views.properties.contexts.DataContextPackage;
import org.eclipse.papyrus.views.properties.contexts.DataContextRoot;
import org.eclipse.papyrus.views.properties.contexts.Property;
import org.eclipse.papyrus.views.properties.contexts.View;
import org.eclipse.papyrus.views.properties.environment.CompositeWidgetType;
import org.eclipse.papyrus.views.properties.environment.Environment;
import org.eclipse.papyrus.views.properties.environment.LayoutType;
import org.eclipse.papyrus.views.properties.environment.PropertyEditorType;
import org.eclipse.papyrus.views.properties.environment.Type;
import org.eclipse.papyrus.views.properties.runtime.ConfigurationManager;
import org.eclipse.papyrus.views.properties.ui.CompositeWidget;
import org.eclipse.papyrus.views.properties.ui.Layout;
import org.eclipse.papyrus.views.properties.ui.PropertyEditor;
import org.eclipse.papyrus.views.properties.ui.UiFactory;
import org.eclipse.papyrus.views.properties.ui.ValueAttribute;
import org.eclipse.papyrus.views.properties.util.PropertiesUtil;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLPackage;


public class ProfileWithDatatypes extends StandardLayoutGenerator {

	protected IGenerator generator;

	@Override
	protected void sortEditors(List<PropertyEditor> editors) {
		for(PropertyEditor editor : editors) {
			Category category = new TypeCategory(editor.getProperty());
			getByCategory(category).add(editor);

			if(editor.getWidgetType() == null) {
				Activator.log.warn(String.format("Editor for property %s doesn't have a WidgetType", editor.getProperty().getName())); //$NON-NLS-1$
				continue;
			}

			namespaces.add(editor.getWidgetType().getNamespace());
		}
	}

	@Override
	protected CompositeWidget layoutCategorizedEditors(Category category, List<PropertyEditor> editors) {
		if(((TypeCategory)category).isDatatype) {
			CompositeWidgetType compositeType = ConfigurationManager.getInstance().getDefaultCompositeType();

			CompositeWidget container = UiFactory.eINSTANCE.createCompositeWidget();
			container.setWidgetType(compositeType);

			Layout layout = createLayout(category.getNumColumns());
			container.setLayout(layout);

			for(PropertyEditor editor : editors) {
				CompositeWidget group = createDataTypeGroup(editor.getProperty());

				PropertyEditor viewEditor = UiFactory.eINSTANCE.createPropertyEditor();
				viewEditor.setWidgetType(getViewEditor());
				viewEditor.setProperty(editor.getProperty());

				ValueAttribute view = UiFactory.eINSTANCE.createValueAttribute();
				view.setName("view");
				view.setValue(getViewName(editor.getProperty()));
				viewEditor.getAttributes().add(view);

				group.getWidgets().add(viewEditor);
				container.getWidgets().add(group);
			}

			return container;
		}

		return super.layoutCategorizedEditors(category, editors);
	}

	protected String getViewName(Property property) {
		if(!(generator instanceof ProfileGenerator)) {
			return "";
		}

		org.eclipse.uml2.uml.Property attribute = ((ProfileGenerator)generator).getAttribute(property);

		Package nearestPackage = attribute.getType().getNearestPackage();
		Package rootPackage = nearestPackage;
		while(rootPackage.getNestingPackage() != null) {
			rootPackage = rootPackage.getNestingPackage();
		}

		//TODO : We're assuming the rootPackage has the same name as the context...
		//This layout generator is really only compatible with ProfileGenerator
		return rootPackage.getName() + ":Single " + attribute.getType().getName();
	}

	protected Context findContext(Property property) {
		DataContextElement element = property.getContextElement();
		if(element instanceof DataContextRoot) {
			//TODO : Add a container reference to Context
			return (Context)element.eContainer();
		}

		return findContext(element);
	}

	protected Context findContext(DataContextElement element) {
		DataContextPackage dataContextPackage = element.getPackage();
		if(dataContextPackage instanceof DataContextRoot) {
			return (Context)dataContextPackage.eContainer();
		}
		return findContext(dataContextPackage);
	}

	protected String getQualifiedName(View view) {
		return view.getContext().getName() + ":" + view.getName();
	}

	protected CompositeWidget createDataTypeGroup(Property property) {
		CompositeWidgetType groupType = getGroupComposite();
		CompositeWidget group = UiFactory.eINSTANCE.createCompositeWidget();
		group.setWidgetType(groupType);

		ValueAttribute text = UiFactory.eINSTANCE.createValueAttribute();
		text.setName("text");
		text.setValue(PropertiesUtil.getLabel(property));

		group.getAttributes().add(text);

		Layout layout = createLayout(1);
		group.setLayout(layout);

		return group;
	}

	protected Layout createLayout(Integer columns) {
		LayoutType propertiesLayoutType = ConfigurationManager.getInstance().getDefaultLayoutType();

		Layout layout = UiFactory.eINSTANCE.createLayout();
		ValueAttribute numColumns = UiFactory.eINSTANCE.createValueAttribute();
		numColumns.setName("numColumns"); //$NON-NLS-1$
		numColumns.setValue(columns.toString());

		layout.getAttributes().add(numColumns);
		layout.setLayoutType(propertiesLayoutType);

		return layout;
	}

	protected CompositeWidgetType getGroupComposite() {
		for(Environment environment : ConfigurationManager.getInstance().getPropertiesRoot().getEnvironments()) {
			for(CompositeWidgetType widgetType : environment.getCompositeWidgetTypes()) {
				if(widgetType.getNamespace() == null && widgetType.getWidgetClass().equals("Group")) {
					return widgetType;
				}
			}
		}

		Activator.log.warn("Cannot find the Group composite type");
		return ConfigurationManager.getInstance().getDefaultCompositeType();
	}

	protected PropertyEditorType getViewEditor() {
		for(Environment environment : ConfigurationManager.getInstance().getPropertiesRoot().getEnvironments()) {
			for(PropertyEditorType widgetType : environment.getPropertyEditorTypes()) {
				if(widgetType.getNamespace() != null && "ppe".equals(widgetType.getNamespace().getName()) && widgetType.getWidgetClass().equals("ViewEditor")) {
					return widgetType;
				}
			}
		}

		Activator.log.warn("Cannot find the Group composite type");
		return ConfigurationManager.getInstance().getDefaultEditorType(Type.STRING, false);
	}

	@Override
	public void setGenerator(IGenerator generator) {
		this.generator = generator;
	}

	protected class TypeCategory extends Category {

		protected boolean isDatatype;

		public TypeCategory(Property property) {
			super(property);
			org.eclipse.uml2.uml.Property attribute = resolveProperty(property);
			if(attribute != null) {
				isDatatype = attribute.getType().eClass() == UMLPackage.eINSTANCE.getDataType();
			}
		}

		protected org.eclipse.uml2.uml.Property resolveProperty(Property property) {
			//TODO : We should not have to rely on the IGenerator to retrieve the property...
			if(generator instanceof ProfileGenerator) {
				ProfileGenerator profileGenerator = (ProfileGenerator)generator;
				return profileGenerator.getAttribute(property);
			}

			return null;
		}

		@Override
		public Integer getNumColumns() {
			if(isDatatype) {
				return 1;
			}
			return super.getNumColumns();
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = super.hashCode();
			result = prime * result + getOuterType().hashCode();
			result = prime * result + (isDatatype ? 1231 : 1237);
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if(this == obj) {
				return true;
			}
			if(!super.equals(obj)) {
				return false;
			}
			if(!(obj instanceof TypeCategory)) {
				return false;
			}
			TypeCategory other = (TypeCategory)obj;
			if(!getOuterType().equals(other.getOuterType())) {
				return false;
			}
			if(isDatatype != other.isDatatype) {
				return false;
			}
			return true;
		}

		@Override
		public Integer getTypeIndex() {
			if(isDatatype) {
				return orderedTypes.length + 1;
			}
			return super.getTypeIndex();
		}

		private ProfileWithDatatypes getOuterType() {
			return ProfileWithDatatypes.this;
		}
	}

	@Override
	public String getName() {
		return "UML Profile with DataTypes";
	}
}
