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
package org.eclipse.papyrus.properties.generation.generators;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.m2m.qvt.oml.BasicModelExtent;
import org.eclipse.m2m.qvt.oml.ModelExtent;
import org.eclipse.papyrus.properties.contexts.DataContextElement;
import org.eclipse.papyrus.properties.contexts.Property;
import org.eclipse.papyrus.properties.generation.Activator;
import org.eclipse.papyrus.properties.generation.wizard.widget.FileChooser;
import org.eclipse.papyrus.properties.root.PropertiesRoot;
import org.eclipse.papyrus.properties.runtime.ConfigurationManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;


public class ProfileGenerator extends AbstractQVTGenerator {

	private FileChooser sourceFileChooser;

	private Profile umlProfile;

	public void createControls(Composite parent) {
		Composite root = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(2, false);
		layout.marginWidth = 0;
		root.setLayout(layout);

		Label sourceLabel = new Label(root, SWT.NONE);
		sourceLabel.setText("Source :");
		GridData data = new GridData();
		data.widthHint = 100;
		sourceLabel.setLayoutData(data);

		sourceFileChooser = new FileChooser(root, false);
		sourceFileChooser.setFilterExtensions(new String[]{ "profile.uml" }); //$NON-NLS-1$
		sourceFileChooser.addListener(this);
	}

	public String getDescription() {
		return "Generate a new Property View context from a UML Profile\nChose the UML Profile corresponding to your metamodel";
	}

	public boolean isReady() {
		return sourceFileChooser.getFilePath() != null;
	}

	public String getName() {
		return "Create from UML Profile";
	}

	@Override
	protected List<ModelExtent> getModelExtents() {
		try {
			URI profileURI = URI.createPlatformResourceURI(sourceFileChooser.getFilePath(), true);
			umlProfile = (Profile)loadEMFModel(profileURI);
			ModelExtent inPackage = new BasicModelExtent(Collections.singletonList(umlProfile));

			EPackage umlPackage = EPackage.Registry.INSTANCE.getEPackage("http://www.eclipse.org/uml2/3.0.0/UML"); //$NON-NLS-1$
			ModelExtent inUml = new BasicModelExtent(Collections.singletonList(umlPackage));

			PropertiesRoot root = ConfigurationManager.instance.getPropertiesRoot();
			ModelExtent inRoot = new BasicModelExtent(Collections.singletonList(root));

			LinkedList<ModelExtent> result = new LinkedList<ModelExtent>();
			result.add(inPackage);
			result.add(getOutContextExtent());
			result.add(inUml);
			result.add(inRoot);

			return result;
		} catch (Exception ex) {
			Activator.log.error(ex);
		}

		return null;
	}

	@Override
	protected URI getTransformationURI() {
		return URI.createPlatformPluginURI("org.eclipse.papyrus.properties.generation/transforms/profile2datacontext.qvto", true); //$NON-NLS-1$
	}

	protected Stereotype findStereotype(List<String> path, Profile profile) {
		NamedElement element = profile.getOwnedMember(path.get(0));
		path.remove(0);
		if(path.size() == 0) {
			if(element instanceof Stereotype) {
				return (Stereotype)element;
			}
		} else {
			if(element instanceof Profile) {
				return findStereotype(path, (Profile)element);
			}
		}
		return null;
	}

	protected List<String> getPath(Property property) {
		List<String> result = getPath(property.getContextElement());
		return result;
	}

	protected List<String> getPath(DataContextElement element) {
		List<String> result;
		if(element.getPackage() == null) {
			result = new LinkedList<String>();
		} else {
			result = getPath(element.getPackage());
		}

		result.add(element.getName());
		return result;
	}

	protected org.eclipse.uml2.uml.Property getAttribute(Property property) {
		List<String> path = getPath(property);
		path.remove(0); //The first path element corresponds to this.umlProfile
		Stereotype stereotype = findStereotype(path, umlProfile);

		org.eclipse.uml2.uml.Property attribute = stereotype.getOwnedAttribute(property.getName(), null);
		return attribute;
	}

	public boolean isSelectedSingle(Property property) {
		org.eclipse.uml2.uml.Property attribute = getAttribute(property);
		if(attribute.isDerived()) {
			return false;
		}

		if(attribute.isReadOnly()) {
			return false;
		}

		return true;
	}

	public boolean isSelectedMultiple(Property property) {
		if(!isSelectedSingle(property)) {
			return false;
		}

		org.eclipse.uml2.uml.Property attribute = getAttribute(property);

		Set<String> validDataTypes = new HashSet<String>(Arrays.asList(new String[]{ "Integer", "Boolean", "Float", "Double" })); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$

		if(attribute.getType() instanceof DataType) {
			if(validDataTypes.contains(((DataType)attribute.getType()).getName()))
				return true;
		}

		if(attribute.getType() instanceof Enumeration) {
			return true;
		}

		return false;
	}

	public boolean isSelectedSingle(Property property, DataContextElement element) {
		return isSelectedSingle(property);
	}

	public boolean isSelectedMultiple(Property property, DataContextElement element) {
		return isSelectedMultiple(property);
	}

}
