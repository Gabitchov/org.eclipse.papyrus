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
package org.eclipse.papyrus.customization.properties.editor.actions;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.action.StaticSelectionCommandAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.widgets.Activator;
import org.eclipse.papyrus.views.properties.contexts.Section;
import org.eclipse.papyrus.views.properties.runtime.ConfigurationManager;
import org.eclipse.papyrus.views.properties.ui.CompositeWidget;
import org.eclipse.papyrus.views.properties.ui.Layout;
import org.eclipse.papyrus.views.properties.ui.UiFactory;
import org.eclipse.papyrus.views.properties.ui.ValueAttribute;

/**
 * An Action to create a section's XWT Resource, with a default Composite
 * and layout.
 * 
 * @author Camille Letavernier
 */
public class CreateSectionWidgetAction extends StaticSelectionCommandAction {

	private Section section;

	/**
	 * Constructor.
	 * 
	 * @param selection
	 *        The current selection. The first element should be a Section.
	 */
	public CreateSectionWidgetAction(ISelection selection) {
		if(selection instanceof IStructuredSelection) {
			IStructuredSelection sSelection = (IStructuredSelection)selection;

			Object selectedElement = sSelection.getFirstElement();

			if(selectedElement instanceof Section) {
				section = (Section)selectedElement;
			}
		}
		configureAction(selection);
	}

	@Override
	protected Command createActionCommand(EditingDomain editingDomain, Collection<?> collection) {
		if(section == null) {
			return UnexecutableCommand.INSTANCE;
		}

		CompositeWidget newWidget = createWidget();

		CompoundCommandActionDelegate createActionCommand = new CompoundCommandActionDelegate();
		createActionCommand.setImage(Activator.getDefault().getImage("org.eclipse.papyrus.views.properties.model.edit", "icons/full/obj16/CompositeWidget.gif")); //$NON-NLS-1$//$NON-NLS-2$
		createActionCommand.append(getCreateResourceCommand(newWidget));
		createActionCommand.append(getSetWidgetCommand(newWidget));

		return createActionCommand;
	}

	private CompositeWidget createWidget() {
		CompositeWidget newWidget = UiFactory.eINSTANCE.createCompositeWidget();


		for(Map.Entry<String, String> entry : getNamespaces().entrySet()) {
			ValueAttribute attribute = UiFactory.eINSTANCE.createValueAttribute();
			attribute.setName(entry.getKey());
			attribute.setValue(entry.getValue());
			newWidget.getAttributes().add(attribute);
		}

		newWidget.setWidgetType(ConfigurationManager.getInstance().getDefaultCompositeType());

		Layout layout = UiFactory.eINSTANCE.createLayout();
		layout.setLayoutType(ConfigurationManager.getInstance().getDefaultLayoutType());
		newWidget.setLayout(layout);

		return newWidget;
	}

	private Map<String, String> getNamespaces() {
		Map<String, String> namespaces = new HashMap<String, String>();
		namespaces.put("xmlns", "http://www.eclipse.org/xwt/presentation"); //$NON-NLS-1$ //$NON-NLS-2$
		namespaces.put("xmlns:x", "http://www.eclipse.org/xwt"); //$NON-NLS-1$ //$NON-NLS-2$
		namespaces.put("xmlns:ppe", "clr-namespace:org.eclipse.papyrus.views.properties.widgets"); //$NON-NLS-1$ //$NON-NLS-2$
		namespaces.put("xmlns:ppel", "clr-namespace:org.eclipse.papyrus.views.properties.widgets.layout"); //$NON-NLS-1$ //$NON-NLS-2$
		return namespaces;
	}

	private Command getCreateResourceCommand(CompositeWidget newWidget) {
		URI widgetURI;
		if(section.getSectionFile() == null || section.getSectionFile().equals("")) { //$NON-NLS-1$
			section.setSectionFile(section.getName() + ".xwt"); //$NON-NLS-1$
		}

		widgetURI = URI.createURI(section.getSectionFile());
		widgetURI = widgetURI.resolve(section.eResource().getURI());
		Command createWidget = new CreateResourceCommand(newWidget, widgetURI, section.eResource().getResourceSet());

		return createWidget;
	}

	private Command getSetWidgetCommand(CompositeWidget newWidget) {
		if(section.getWidget() == null) {
			return SetCommand.create(editingDomain, section, section.eClass().getEStructuralFeature("widget"), newWidget); //$NON-NLS-1$
		} else {
			return UnexecutableCommand.INSTANCE;
		}
	}
}
