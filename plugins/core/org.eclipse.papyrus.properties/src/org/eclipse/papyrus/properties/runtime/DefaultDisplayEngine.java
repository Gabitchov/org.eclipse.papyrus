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
package org.eclipse.papyrus.properties.runtime;

import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.e4.xwt.DefaultLoadingContext;
import org.eclipse.e4.xwt.ILoadingContext;
import org.eclipse.e4.xwt.XWT;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.properties.Activator;
import org.eclipse.papyrus.properties.contexts.Context;
import org.eclipse.papyrus.properties.contexts.Section;
import org.eclipse.papyrus.properties.contexts.Tab;
import org.eclipse.papyrus.properties.contexts.View;
import org.eclipse.papyrus.properties.xwt.XWTTabDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.views.properties.tabbed.ITabDescriptor;

public class DefaultDisplayEngine implements DisplayEngine {

	private ILoadingContext loadingContext = new DefaultLoadingContext(getClass().getClassLoader());

	private Set<String> displayedSections = new HashSet<String>();

	private Set<Control> controls = new HashSet<Control>();

	private boolean allowDuplicate;

	public DefaultDisplayEngine() {
		this(false);
	}

	public DefaultDisplayEngine(boolean allowDuplicate) {
		this.allowDuplicate = allowDuplicate;
	}

	public List<ITabDescriptor> getTabDescriptors(Set<View> views) {

		Map<String, XWTTabDescriptor> result = new LinkedHashMap<String, XWTTabDescriptor>();

		Set<String> selectedSections = new HashSet<String>();

		for(View view : views) {
			for(Section section : view.getSections()) {
				if(selectedSections.contains(section.getName()))
					continue;

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

		dispose();
		return new LinkedList<ITabDescriptor>(result.values());
	}

	public void dispose() {
		for(Control control : controls) {
			control.dispose();
		}
		displayedSections.clear();
		controls.clear();
	}

	public Control createSection(Composite parent, Section section, DataSource source) {
		if(source == null) {
			return null;
		}

		if(!allowDuplicate && displayedSections.contains(section.getName())) {
			return null;
		}

		Control control = createSection(parent, section, loadXWTFile(section), source);

		if(control != null) {
			displayedSections.add(section.getName());
			controls.add(control);
		}

		return control;
	}

	public void refreshSection(Composite parent, Section section, DataSource source) {
		for(Control control : parent.getChildren()) {
			control.dispose();
		}

		Control control = createSection(parent, section, loadXWTFile(section), source);

		if(control != null)
			controls.add(control);
	}

	public Control createSection(Composite parent, Section section, URL sectionFile, DataSource source) {
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
			control = XWT.load(parent, sectionFile, source);
			if(control != null) {
				control.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
				controls.add(control);
			}
			layout(parent);
		} catch (Exception ex) {
			Activator.log.error(ex);
			dispose();
			Label label = new Label(parent, SWT.NONE);
			label.setText("An error occured in the property view. The file " + section.getSectionFile() + " could not be loaded"); //$NON-NLS-1$ //$NON-NLS-2$
			layout(parent);
		}

		XWT.setLoadingContext(xwtContext);

		return control;
	}

	private URL loadXWTFile(Section section) {
		EObject tab = section.eContainer();
		Context context = (Context)tab.eContainer();
		if(context.eResource() == null) {
			Activator.log.warn("No resource for Context : " + context); //$NON-NLS-1$
		}

		URI sectionURI = URI.createURI(section.getSectionFile());
		sectionURI = sectionURI.resolve(context.eResource().getURI());

		try {
			URL url = new URL(sectionURI.toString());
			return url;
		} catch (IOException ex) {
			Activator.log.error(ex);
		}

		return null;
	}

	private void layout(Composite parent) {
		parent.getParent().getParent().layout(true);
		parent.getParent().layout(true);
		parent.layout(true);
	}

	public void hideSection(Composite parent) {
		for(Control control : parent.getChildren()) {
			control.dispose();
		}
		layout(parent);
	}
}
