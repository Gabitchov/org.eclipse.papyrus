/*****************************************************************************
 * Copyright (c) 2010, 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - Use URIs to support non-URL-compatible storage (CDO)
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.runtime;

import java.net.URL;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.views.properties.Activator;
import org.eclipse.papyrus.views.properties.catalog.PropertiesURIHandler;
import org.eclipse.papyrus.views.properties.contexts.Context;
import org.eclipse.papyrus.views.properties.contexts.Section;
import org.eclipse.papyrus.views.properties.contexts.Tab;
import org.eclipse.papyrus.views.properties.contexts.View;
import org.eclipse.papyrus.views.properties.modelelement.DataSource;
import org.eclipse.papyrus.views.properties.util.EMFURLStreamHandler;
import org.eclipse.papyrus.views.properties.xwt.XWTTabDescriptor;
import org.eclipse.papyrus.xwt.DefaultLoadingContext;
import org.eclipse.papyrus.xwt.ILoadingContext;
import org.eclipse.papyrus.xwt.XWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.views.properties.tabbed.ITabDescriptor;

/**
 * A default implementation for {@link DisplayEngine}
 * 
 * @author Camille Letavernier
 */
public class DefaultDisplayEngine implements DisplayEngine {

	private ILoadingContext loadingContext = new DefaultLoadingContext(getClass().getClassLoader());

	private Set<String> displayedSections = new HashSet<String>();

	private Set<Control> controls = new HashSet<Control>();

	private boolean allowDuplicate;

	/**
	 * Constructs a new DisplayEnginet that doesn't allow the duplication of sections
	 */
	public DefaultDisplayEngine() {
		this(false);
	}

	/**
	 * Constructor.
	 * 
	 * @param allowDuplicate
	 *        If false, two calls of {@link #createSection(Composite, Section, DataSource)} with the same
	 *        section will display the section only once : only the first call is taken into account
	 *        The main property view doesn't allow duplication, to avoid redundancy when two views link to
	 *        the same section.
	 */
	public DefaultDisplayEngine(boolean allowDuplicate) {
		this.allowDuplicate = allowDuplicate;
	}

	public List<ITabDescriptor> getTabDescriptors(Set<View> views) {

		Map<String, XWTTabDescriptor> result = new LinkedHashMap<String, XWTTabDescriptor>();

		Set<String> selectedSections = new HashSet<String>();

		for(View view : views) {
			for(Section section : view.getSections()) {
				if(selectedSections.contains(section.getName())) {
					continue;
				}

				Tab tab = section.getTab();

				if(tab == null) {
					Activator.log.warn("Null tab for " + section); //$NON-NLS-1$
					continue;
				}

				XWTTabDescriptor descriptor;

				if(result.containsKey(tab.getId())) {
					descriptor = result.get(tab.getId());
				} else {
					descriptor = new XWTTabDescriptor(tab);
					result.put(tab.getId(), descriptor);
				}

				descriptor.addSection(section, view, this);
				selectedSections.add(section.getName());
			}
		}

		disposeControls();
		return new LinkedList<ITabDescriptor>(result.values());
	}

	/**
	 * Disposes the controls created by this DisplayEngine
	 * This should not dispose the engine itself, which can be reused.
	 */
	protected void disposeControls() {
		for(Control control : controls) {
			control.dispose();
		}
		displayedSections.clear();
		controls.clear();
	}

	/**
	 * {@inheritDoc}
	 */
	public void dispose() {
		disposeControls();
	}

	public Control createSection(Composite parent, Section section, DataSource source) {
		if(source == null) {
			return null;
		}

		if(!allowDuplicate && displayedSections.contains(section.getName())) {
			return null;
		}

		Control control = createSection(parent, section, loadXWTFile(section), source);

		displayedSections.add(section.getName());

		if(control != null) {
			controls.add(control);
		}

		return control;
	}

	public void refreshSection(Composite parent, Section section, DataSource source) {
		for(Control control : parent.getChildren()) {
			control.dispose();
		}

		Control control = createSection(parent, section, loadXWTFile(section), source);

		displayedSections.add(section.getName());

		if(control != null) {
			controls.add(control);
		}
	}

	public Control createSection(Composite parent, Section section, URI sectionFile, DataSource source) {
		if(sectionFile == null) {
			sectionFile = loadXWTFile(section);
			if(sectionFile == null) {
				return null;
			}
		}

		ILoadingContext xwtContext = XWT.getLoadingContext();
		XWT.setLoadingContext(loadingContext);

		Control control = null;

		try {
			ResourceSet rset = section.eResource().getResourceSet();
			URL url = new URL(null, sectionFile.toString(), new EMFURLStreamHandler(rset.getURIConverter()));
			control = (Control)XWT.load(parent, url, source);

			if(control != null) {
				control.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
				controls.add(control);
			}
		} catch (Exception ex) {
			Activator.log.error("Error while loading " + section.getSectionFile(), ex); //$NON-NLS-1$
			disposeControls();
			Label label = new Label(parent, SWT.NONE);
			label.setText("An error occured in the property view. The file " + section.getSectionFile() + " could not be loaded"); //$NON-NLS-1$ //$NON-NLS-2$
		}
		layout(parent);

		XWT.setLoadingContext(xwtContext);

		return control;
	}

	private URI loadXWTFile(Section section) {
		EObject tab = section.eContainer();
		Context context = (Context)tab.eContainer();
		if(context.eResource() == null) {
			context = ConfigurationManager.getInstance().getContext(context.getName());
			Activator.log.warn("No resource for Context : " + context + " ; refreshing the model"); //$NON-NLS-1$ //$NON-NLS-2$
		}

		URI sectionURI = URI.createURI(section.getSectionFile());
		URI baseURI = context.eResource().getURI();
		if(PropertiesURIHandler.PROPERTIES_SCHEME.equals(baseURI.scheme())) {
			PropertiesURIHandler handler = new PropertiesURIHandler();
			baseURI = handler.getConvertedURI(baseURI);
		}
		sectionURI = sectionURI.resolve(baseURI);

		return sectionURI;
	}

	private void layout(Composite parent) {
		parent.getParent().getParent().layout();
		parent.getParent().layout();
		parent.layout();
	}

	public void removeSection(Composite parent) {
		for(Control control : parent.getChildren()) {
			control.dispose();
		}
		layout(parent);
	}
}
