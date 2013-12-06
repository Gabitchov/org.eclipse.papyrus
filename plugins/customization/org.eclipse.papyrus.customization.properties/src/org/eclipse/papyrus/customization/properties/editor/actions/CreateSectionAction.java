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
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.command.CreateChildCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.action.StaticSelectionCommandAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.views.properties.contexts.Context;
import org.eclipse.papyrus.views.properties.contexts.ContextsFactory;
import org.eclipse.papyrus.views.properties.contexts.Section;
import org.eclipse.papyrus.views.properties.contexts.View;
import org.eclipse.papyrus.views.properties.runtime.ConfigurationManager;
import org.eclipse.papyrus.views.properties.ui.CompositeWidget;
import org.eclipse.papyrus.views.properties.ui.Layout;
import org.eclipse.papyrus.views.properties.ui.UiFactory;
import org.eclipse.papyrus.views.properties.ui.ValueAttribute;

/**
 * A Command for create a {@link Section} in the given View.
 * 
 * In the physical EMF Model, the section is owned by a Tab, and referenced
 * by one or more views. However, in the logical model used by the Customization
 * editor (Which is slightly different to be simpler), the view directly owns the
 * section, and the section refers to its Tab.
 * 
 * This command creates the section in the default Tab, and creates a reference
 * from the view to the section.
 * 
 * It also instantiates the XWT Resource associated to this sections, and fills
 * it with a default Composite widget and Layout.
 * 
 * The command can be undone in a single operation.
 * 
 * @author Camille Letavernier
 * 
 */
public class CreateSectionAction extends StaticSelectionCommandAction {

	private IStructuredSelection selection;

	private String sectionName, sectionFile;

	/**
	 * Constructor.
	 * 
	 * Creates a new CreateSectionAction, with the given name and file.
	 * The sectionFile is a relative path from the section's URI, which is
	 * the same as it's owning view.
	 * 
	 * @param selection
	 *        The current selection
	 * @param sectionName
	 *        The new section's name
	 * @param sectionFile
	 *        The path to the section's XWT resource
	 */
	public CreateSectionAction(ISelection selection, String sectionName, String sectionFile) {
		this.sectionName = sectionName;
		this.sectionFile = sectionFile;

		if(selection instanceof IStructuredSelection) {
			this.selection = (IStructuredSelection)selection;
			configureAction(selection);
		}
	}

	@Override
	protected Command createActionCommand(EditingDomain editingDomain, Collection<?> collection) {
		Object selectedElement = selection.getFirstElement();
		View view = null;
		if(selectedElement instanceof View) {
			view = (View)selectedElement;
		}

		if(view == null) {
			return UnexecutableCommand.INSTANCE;
		}

		EObject tab = null;

		for(Section section : view.getSections()) {
			if(section.getTab() != null) {
				tab = section.getTab();
				break;
			}
		}

		if(tab == null) {
			Context context = (Context)view.eContainer();
			if(context.getTabs().size() > 0) {
				tab = context.getTabs().get(0);
			}
		}

		if(tab == null) {
			return UnexecutableCommand.INSTANCE;
		}

		Section newSection = ContextsFactory.eINSTANCE.createSection();
		newSection.setName(getSectionName());

		CompositeWidget newWidget = createWidget();

		CommandParameter tabParameter = new CommandParameter(tab, tab.eClass().getEStructuralFeature("sections"), newSection); //$NON-NLS-1$

		Command createInTab = CreateChildCommand.create(editingDomain, tab, tabParameter, collection);
		Command addInView = AddCommand.create(editingDomain, view, view.eClass().getEStructuralFeature("sections"), newSection); //$NON-NLS-1$
		Command createWidgetResource = getCreateResourceCommand(newWidget, newSection, view.eResource());
		Command setWidget = getSetWidgetCommand(newWidget, newSection);


		CompoundCommand createActionCommand = new CompoundCommandActionDelegate();
		createActionCommand.append(createInTab);
		createActionCommand.append(addInView);
		createActionCommand.append(createWidgetResource);
		createActionCommand.append(setWidget);

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

	private Command getCreateResourceCommand(CompositeWidget newWidget, Section section, Resource baseResource) {
		URI widgetURI;
		if(section.getSectionFile() == null || section.getSectionFile().equals("")) { //$NON-NLS-1$
			section.setSectionFile(getSectionFile());
		}

		widgetURI = URI.createURI(section.getSectionFile());
		widgetURI = widgetURI.resolve(baseResource.getURI());
		Command createWidget = new CreateResourceCommand(newWidget, widgetURI, baseResource.getResourceSet());

		return createWidget;
	}

	private Command getSetWidgetCommand(CompositeWidget newWidget, Section section) {
		if(section.getWidget() == null) {
			return SetCommand.create(editingDomain, section, section.eClass().getEStructuralFeature("widget"), newWidget); //$NON-NLS-1$
		} else {
			return UnexecutableCommand.INSTANCE;
		}
	}

	private String getSectionFile() {
		return sectionFile;
	}

	private String getSectionName() {
		return sectionName;
	}

}
