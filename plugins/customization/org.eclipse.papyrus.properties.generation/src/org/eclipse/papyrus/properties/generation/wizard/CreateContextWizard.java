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
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.operation.IRunnableWithProgress;
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
import org.eclipse.papyrus.properties.generation.messages.Messages;
import org.eclipse.papyrus.properties.generation.wizard.widget.TernaryButton;
import org.eclipse.papyrus.properties.runtime.ConfigurationManager;
import org.eclipse.papyrus.properties.ui.PropertyEditor;
import org.eclipse.papyrus.properties.ui.UiFactory;
import org.eclipse.papyrus.properties.ui.ValueAttribute;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

/**
 * A Wizard for generating Property view contexts
 * 
 * @author Camille Letavernier
 */
public class CreateContextWizard extends Wizard implements INewWizard {

	CreateContextMainPage mainPage;

	GeneratorPage generatorPage;

	//protected LayoutPage layout;

	SelectFieldsPage selectFieldsPage;

	/**
	 * All available context generators
	 */
	protected static List<IGenerator> contextGenerators = new LinkedList<IGenerator>();

	/**
	 * All available layout generators
	 */
	protected static List<ILayoutGenerator> layoutGenerators = new LinkedList<ILayoutGenerator>();

	/**
	 * The generated context
	 */
	protected Context context;

	/**
	 * The IGenerator used to generate the context
	 */
	protected IGenerator generator;

	/**
	 * The ILayoutGenerator used to layout the context's sections
	 */
	protected ILayoutGenerator layoutGenerator;

	public CreateContextWizard() {
		setDefaultPageImageDescriptor(Activator.getDefault().getImageDescriptor("/icons/wizban-custom.png")); //$NON-NLS-1$
	}

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

		URI contextURI = context.eResource().getURI();
		Resource selectionResource = context.eResource().getResourceSet().createResource(URI.createURI(context.getName() + "FieldSelection.xmi").resolve(contextURI)); //$NON-NLS-1$
		selectionResource.getContents().add(fieldSelection);
		try {
			selectionResource.save(null);
		} catch (IOException ex) {
			Activator.log.error("Couldn't persist the field selection model", ex); //$NON-NLS-1$
		}

		layoutGenerator = layoutGenerators.get(0); //TODO : Use the layoutGenerator combo

		for(View view : context.getViews()) {
			if(view.getConstraints().size() == 0) {
				continue;
			}

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

		int i = 1;
		for(Tab tab : context.getTabs()) {
			i += tab.getSections().size();
		}
		final int numberOfSections = i;
		try {
			setNeedsProgressMonitor(true);
			getContainer().run(true, true, new IRunnableWithProgress() {

				public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
					monitor.beginTask(Messages.CreateContextWizard_propertyViewGenerationJobName + context.getName(), numberOfSections + 1);
					monitor.worked(1);

					try {
						context.eResource().save(Collections.EMPTY_MAP);

						monitor.worked(1);
						for(Tab tab : context.getTabs()) {
							for(Section section : tab.getSections()) {
								if(monitor.isCanceled()) {
									return;
								}
								section.getWidget().eResource().save(Collections.EMPTY_MAP);
								monitor.worked(1);
							}
						}
					} catch (IOException ex) {
						Activator.log.error(ex);
						return;
					}
					monitor.done();
				}

			});
		} catch (InvocationTargetException ex) {
			Activator.log.error(ex);
		} catch (InterruptedException ex) {
			Activator.log.error(ex);
		}
		//		Job job = new Job(Messages.CreateContextWizard_propertyViewGenerationJobName + context.getName()) {
		//
		//			@Override
		//			protected IStatus run(IProgressMonitor monitor) {
		//				monitor.beginTask(getName(), numberOfSections);
		//
		//				try {
		//					context.eResource().save(Collections.EMPTY_MAP);
		//
		//					monitor.worked(1);
		//					for(Tab tab : context.getTabs()) {
		//						for(Section section : tab.getSections()) {
		//							if(monitor.isCanceled()) {
		//								return Status.CANCEL_STATUS;
		//							}
		//							section.getWidget().eResource().save(Collections.EMPTY_MAP);
		//							monitor.worked(1);
		//						}
		//					}
		//				} catch (IOException ex) {
		//					Activator.log.error(ex);
		//					return new Status(IStatus.ERROR, Activator.PLUGIN_ID, Messages.CreateContextWizard_propertyViewGenerationError + context.getName(), ex);
		//				}
		//				return Status.OK_STATUS;
		//			}
		//		};
		//		job.setPriority(Job.INTERACTIVE);
		//		job.setUser(true);
		//		job.schedule();

		return true;
	}

	private boolean isSelected(FieldSelection fieldSelection, Property property, boolean multiple) {
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

	PropertyDefinition getPropertyDefinition(FieldSelection fieldSelection, Property property) {
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
		if(currentElement == null) {
			return null;
		}

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

	ContextElement findByName(ContextElement source, String name) {
		for(ContextElement element : source.getElements()) {
			if(element.getName().equals(name)) {
				return element;
			}
		}
		return null;
	}

	List<String> getPropertyPath(DataContextElement element) {
		List<String> result;
		if(element.getPackage() == null) {
			result = new LinkedList<String>();
		} else {
			result = getPropertyPath(element.getPackage());
		}
		result.add(element.getName());
		return result;
	}

	private Set<DataContextElement> getAllContextElements(Collection<DataContextElement> source) {
		Set<DataContextElement> result = new HashSet<DataContextElement>();
		for(DataContextElement element : source) {
			getAllContextElements(element, result);
		}
		return result;
	}

	private void getAllContextElements(DataContextElement source, Set<DataContextElement> result) {
		if(result.contains(source)) {
			return;
		}

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

		setWindowTitle(Messages.CreateContextWizard_pageTitle);

	}

	void setGenerator(IGenerator generator) {
		this.generator = generator;
		generatorPage.setGenerator(generator);
	}

	void setContext(Context context) {
		this.context = context;
	}

	/**
	 * Registers a new context Generator for the CreateContextWizard
	 * 
	 * @param generator
	 *        The IGenerator to register
	 */
	public static void addGenerator(IGenerator generator) {
		contextGenerators.add(generator);
	}

	/**
	 * Registers a new Layout Generator for the CreateContextWizard
	 * 
	 * @param generator
	 *        The ILayoutGenerator to register
	 */
	public static void addLayoutGenerator(ILayoutGenerator generator) {
		layoutGenerators.add(generator);
	}

}
