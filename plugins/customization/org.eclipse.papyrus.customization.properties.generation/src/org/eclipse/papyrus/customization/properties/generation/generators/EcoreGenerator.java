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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.m2m.qvt.oml.BasicModelExtent;
import org.eclipse.m2m.qvt.oml.ModelExtent;
import org.eclipse.papyrus.customization.properties.generation.Activator;
import org.eclipse.papyrus.customization.properties.generation.messages.Messages;
import org.eclipse.papyrus.customization.properties.generation.wizard.widget.FileChooser;
import org.eclipse.papyrus.views.properties.contexts.DataContextElement;
import org.eclipse.papyrus.views.properties.contexts.Property;
import org.eclipse.papyrus.views.properties.root.PropertiesRoot;
import org.eclipse.papyrus.views.properties.runtime.ConfigurationManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

/**
 * An IGenerator to create Property view contexts from an Ecore metamodel
 * FIXME : The generator doesn't seem to keep the Metaclass inheritance
 * 
 * @author Camille Letavernier
 */
public class EcoreGenerator extends AbstractQVTGenerator {

	private FileChooser sourceFileChooser;

	private EPackage ecorePackage;

	public void createControls(Composite parent) {
		Composite root = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(2, false);
		layout.marginWidth = 0;
		root.setLayout(layout);

		Label sourceLabel = new Label(root, SWT.NONE);
		sourceLabel.setText(Messages.EcoreGenerator_source);
		GridData data = new GridData();
		data.widthHint = 100;
		sourceLabel.setLayoutData(data);

		sourceFileChooser = new FileChooser(root, false);
		sourceFileChooser.setFilterExtensions(new String[]{ "ecore" }); //$NON-NLS-1$
		sourceFileChooser.addListener(this);
	}

	public String getDescription() {
		return Messages.EcoreGenerator_ecoreGeneratorDescription;
	}

	public boolean isReady() {
		return sourceFileChooser.getFilePath() != null;
	}

	public String getName() {
		return Messages.EcoreGenerator_ecoreGeneratorName;
	}

	public boolean isSelectedSingle(Property property) {
		EStructuralFeature feature = getFeature(property);
		if(feature == null) {
			return false;
		}

		if(feature.isDerived()) {
			return false;
		}

		if(!feature.isChangeable()) {
			return false;
		}

		if(feature instanceof EReference) {
			EReference reference = (EReference)feature;
			if(reference.isContainer() || reference.isContainment()) {
				return false;
			}
		}

		return true;
	}

	/**
	 * Retrieve the EStructuralFeature corresponding to the given property
	 * 
	 * @param property
	 * @return
	 *         The EStructuralFeature corresponding to the given property
	 */
	protected EStructuralFeature getFeature(Property property) {
		List<String> path = getPath(property);
		path.remove(0); //Root = EPackage

		EPackage currentPackage = ecorePackage;

		EClassifier classifier = findClassifier(path, currentPackage);
		if(classifier == null) {
			return null;
		}

		if(!(classifier instanceof EClass)) {
			return null;
		}

		EClass eClass = (EClass)classifier;
		return eClass.getEStructuralFeature(property.getName());
	}

	/**
	 * Retrieve the Classifier corresponding to the given path, in the given EPackage
	 * 
	 * @param path
	 *        The list of package and subpackages names, and the classifier name, i.e.
	 *        the list of segments in the classifier's qualified name
	 * @param source
	 *        The root EPackage in which the classifier should be retrieved
	 * @return
	 *         The corresponding EClassifier, or null if it couldn't be retrieved
	 */
	protected EClassifier findClassifier(List<String> path, EPackage source) {
		String qualifier = path.get(0);
		EClassifier classifier = source.getEClassifier(qualifier);
		if(classifier == null) {
			source = findSubPackage(source, qualifier);
			if(source == null) {
				return null;
			}
			path.remove(0);
			return findClassifier(path, source);
		} else {
			return classifier;
		}
	}

	/**
	 * Retrieve the subpackage corresponding to the given packageName, in the given
	 * package
	 * 
	 * @param currentPackage
	 *        The EPackage in which the subpackage should be found
	 * @param packageName
	 *        The name of the EPackage to find
	 * @return
	 *         The corresponding EPackage, or null if it couldn't be found
	 */
	protected EPackage findSubPackage(EPackage currentPackage, String packageName) {
		for(EPackage pack : currentPackage.getESubpackages()) {
			if(pack.getName().equals(packageName)) {
				return pack;
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

	public boolean isSelectedMultiple(Property property) {
		if(!isSelectedSingle(property)) {
			return false;
		}

		EStructuralFeature feature = getFeature(property);

		Set<String> validDataTypes = new HashSet<String>(Arrays.asList(new String[]{ "int", "boolean", "float", "double" })); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$

		if(feature.getEType() instanceof EDataType) {
			if(validDataTypes.contains(((EDataType)feature.getEType()).getInstanceTypeName())) {
				return true;
			}
		}

		if(feature.getEType() instanceof EEnum) {
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

	@Override
	protected URI getTransformationURI() {
		return URI.createPlatformPluginURI(Activator.PLUGIN_ID + "/transforms/ecore2datacontext.qvto", true); //$NON-NLS-1$
	}

	@Override
	protected List<ModelExtent> getModelExtents() {
		try {
			URI packageURI = URI.createPlatformResourceURI(sourceFileChooser.getFilePath(), true);
			ecorePackage = (EPackage)loadEMFModel(packageURI);
			ModelExtent inPackage = new BasicModelExtent(Collections.singletonList(ecorePackage));

			PropertiesRoot root = ConfigurationManager.instance.getPropertiesRoot();
			ModelExtent inRoot = new BasicModelExtent(Collections.singletonList(root));

			LinkedList<ModelExtent> result = new LinkedList<ModelExtent>();
			result.add(inPackage);
			result.add(inRoot);
			result.add(getOutContextExtent());
			return result;
		} catch (Exception ex) {
			return null;
		}
	}
}
