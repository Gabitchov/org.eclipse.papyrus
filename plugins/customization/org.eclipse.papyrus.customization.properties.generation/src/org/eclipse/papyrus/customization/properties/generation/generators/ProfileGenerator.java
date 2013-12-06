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
package org.eclipse.papyrus.customization.properties.generation.generators;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.qvt.oml.BasicModelExtent;
import org.eclipse.m2m.qvt.oml.ModelExtent;
import org.eclipse.papyrus.customization.properties.generation.Activator;
import org.eclipse.papyrus.customization.properties.generation.messages.Messages;
import org.eclipse.papyrus.customization.properties.generation.wizard.widget.FileChooser;
import org.eclipse.papyrus.views.properties.contexts.Context;
import org.eclipse.papyrus.views.properties.contexts.DataContextElement;
import org.eclipse.papyrus.views.properties.contexts.Property;
import org.eclipse.papyrus.views.properties.root.PropertiesRoot;
import org.eclipse.papyrus.views.properties.runtime.ConfigurationManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Profile;

/**
 * An IGenerator for building Contexts from a UML Profile
 * 
 * @author Camille Letavernier
 */
public class ProfileGenerator extends AbstractQVTGenerator {

	private FileChooser sourceFileChooser;

	private Profile umlProfile;

	public void createControls(Composite parent) {
		Composite root = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(2, false);
		layout.marginWidth = 0;
		root.setLayout(layout);

		Label sourceLabel = new Label(root, SWT.NONE);
		sourceLabel.setText(Messages.ProfileGenerator_source);
		GridData data = new GridData();
		data.widthHint = 100;
		sourceLabel.setLayoutData(data);

		sourceFileChooser = new FileChooser(root, false);
		sourceFileChooser.setFilterExtensions(new String[]{ "profile.uml" }); //$NON-NLS-1$
		sourceFileChooser.addListener(this);
	}

	public String getDescription() {
		return Messages.ProfileGenerator_description;
	}

	public boolean isReady() {
		return sourceFileChooser.getFilePath() != null;
	}

	public String getName() {
		return Messages.ProfileGenerator_name;
	}

	@Override
	protected List<ModelExtent> getModelExtents() {
		try {
			URI profileURI = URI.createPlatformResourceURI(sourceFileChooser.getFilePath(), true);
			umlProfile = (Profile)loadEMFModel(profileURI);
			ModelExtent inProfile = new BasicModelExtent(Collections.singletonList(umlProfile));

			URI umlURI = URI.createURI("ppe:/context/org.eclipse.papyrus.uml.properties/Model/UML/UML.ctx", true);
			Context umlContext = (Context)loadEMFModel(umlURI);
			if(umlContext == null) {
				Activator.log.warn("Cannot find the UML Property View configuration");
			}
			ModelExtent inUml = new BasicModelExtent(Collections.singletonList(umlContext));

			PropertiesRoot root = ConfigurationManager.getInstance().getPropertiesRoot();
			ModelExtent inRoot = new BasicModelExtent(Collections.singletonList(root));

			LinkedList<ModelExtent> result = new LinkedList<ModelExtent>();
			result.add(inProfile);
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
		return URI.createPlatformPluginURI("org.eclipse.papyrus.customization.properties.generation/transforms/profile2datacontext.qvto", true); //$NON-NLS-1$
	}

	/**
	 * Retrieve the Classifier corresponding to the given path, in the given Package
	 * 
	 * @param path
	 *        The list of package and subpackages names, and the classifier name, i.e.
	 *        the list of segments in the classifier qualified name
	 *        e.g. : SysML::Blocks::Block : ["SysML", "Blocks", "Block"]
	 * @param rootPackage
	 *        The root Package in which the stereotype should be retrieved
	 * @return
	 *         The corresponding Classifier, or null if it couldn't be retrieved
	 */
	protected Classifier findClassifier(List<String> path, Package rootPackage) {
		NamedElement element = rootPackage.getOwnedMember(path.get(0));
		path.remove(0);
		if(path.size() == 0) {
			if(element instanceof Classifier) {
				return (Classifier)element;
			}
		} else {
			if(element instanceof Package) {
				return findClassifier(path, (Package)element);
			}
		}
		return null;
	}

	private List<String> getPath(Property property) {
		List<String> result = getPath(property.getContextElement());
		return result;
	}

	private List<String> getPath(DataContextElement element) {
		List<String> result;
		if(element.getPackage() == null) {
			result = new LinkedList<String>();
		} else {
			result = getPath(element.getPackage());
		}

		result.add(element.getName());
		return result;
	}

	/**
	 * Retrieve the UML Property corresponding to the given Property view context Property
	 * 
	 * @param property
	 * @return
	 */
	public org.eclipse.uml2.uml.Property getAttribute(Property property) {
		List<String> path = getPath(property);

		Package propertyRootPackage = findPackage(path.remove(0));
		if(propertyRootPackage == null) {
			return null;
		}

		Classifier classifier = findClassifier(path, propertyRootPackage);
		if(classifier == null) {
			return null;
		}

		org.eclipse.uml2.uml.Property attribute = classifier.getAttribute(property.getName(), null);
		return attribute;
	}

	public Package findPackage(String name) {
		for(Resource resource : umlProfile.eResource().getResourceSet().getResources()) {
			for(Object rootElement : resource.getContents()) {
				if(rootElement instanceof Package) {
					Package rootPackage = (Package)rootElement;
					if(name.equals(rootPackage.getName())) {
						return rootPackage;
					}
				}
			}
		}
		return null;
	}

	public boolean isSelectedSingle(Property property) {
		org.eclipse.uml2.uml.Property attribute = getAttribute(property);
		if(attribute == null) {
			Activator.log.warn("Cannot find the Property corresponding to " + getPath(property)); //$NON-NLS-1$
			return false;
		}

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

		if(attribute.getType() instanceof PrimitiveType) {
			return validDataTypes.contains(((PrimitiveType)attribute.getType()).getName());
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
