/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Ansgar Radermacher  ansgar.radermacher@cea.fr  
 *
 *****************************************************************************/

package org.eclipse.papyrus.qompass.modellibs.core.mappingrules;

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.FCM.PortKind;
import org.eclipse.papyrus.FCM.util.ITemplateMappingRule;
import org.eclipse.papyrus.qompass.designer.core.StUtils;
import org.eclipse.papyrus.qompass.designer.core.Utils;
import org.eclipse.papyrus.qompass.designer.core.templates.TemplateInstantiation;
import org.eclipse.papyrus.qompass.designer.core.templates.TemplateUtils;
import org.eclipse.papyrus.qompass.designer.core.transformations.Copy;
import org.eclipse.papyrus.qompass.designer.core.transformations.TransformationException;
import org.eclipse.papyrus.qompass.designer.core.transformations.filters.FixTemplateSync;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.TemplateSignature;
import org.eclipse.uml2.uml.Type;


/**
 * An extended Port in the sense of the DDS4CCM standard: a port typed with a component
 * type. Since the component typing the port can have multiple provided and required
 * ports, the ports are implicitly owned by the port. Conjugation on the level of an extended
 * port level will conjugate all ports of the component typing the port.
 * 
 * The derived interface that is provided will concatenate provided port names within the
 * extended port with the port name and provided a "big" interface.
 * The derived interface that is required is identical, except for a conjugation on the
 * extended port level.
 * 
 * Creates a fixed template binding that binds T (of the extended Port) to the used data type
 * 
 * Here, the idea is that the port type is a classifier, e.g. the data type that is
 * transported by a DDS port. The port kind is the extended port, e.g. DDSWrite.
 * 
 * The derived property isExtended of FCM port-kind is true, if the class representing the port-kind owns at least one
 * port
 * 
 * @author ansgar
 * 
 */
public class TemplatePort implements ITemplateMappingRule {

	public Interface getProvided(org.eclipse.papyrus.FCM.Port p, InstanceSpecification config, boolean update)
	{
		return null;
	}

	public Interface getRequired(org.eclipse.papyrus.FCM.Port p, InstanceSpecification config, boolean update)
	{
		return null;
	}

	public PortKind getBoundType(org.eclipse.papyrus.FCM.Port p)
	{
		Port port = p.getBase_Port();
		Type type = port.getType();
		if(!(type instanceof Classifier)) {
			return null;
		}
		if (p.getKind() == null) {
			return null;
		}
		Class extendedPort = p.getKind().getBase_Class();
		TemplateSignature signature = TemplateUtils.getSignature(extendedPort.getNearestPackage());
		Package pkgTemplate = signature.getNearestPackage();
		if(pkgTemplate != null) {
			EList<Namespace> path = TemplateUtils.relativePathWithMerge(extendedPort, pkgTemplate);
			Package model = Utils.getTop(port);
			
			String name = pkgTemplate.getName() + "_" + type.getName();  //$NON-NLS-1$
			Package pkg = model.getNestedPackage(name);
			if (pkg != null) {
				for (Namespace pathElem : path) {
					pkg = pkg.getNestedPackage(pathElem.getName());
					if (pkg == null) {
						return null;
					}
				}
				PackageableElement boundClass = pkg.getPackagedElement(extendedPort.getName());
				if (boundClass != null) {
					return StUtils.getApplication(boundClass, PortKind.class);
				}
			}
		}
		return null;
	}

	public void updateBinding(org.eclipse.papyrus.FCM.Port p) {
		Port port = p.getBase_Port();
		Type type = port.getType();
		if(!(type instanceof Classifier)) {
			return;
		}
		Class extendedPort = p.getKind().getBase_Class();

		TemplateSignature signature = TemplateUtils.getSignature(extendedPort.getNearestPackage());
		Package pkgTemplate = signature.getNearestPackage();
		if(signature != null) {
			Package model = Utils.getTop(port);
			String name = pkgTemplate.getName() + "_" + type.getName();  //$NON-NLS-1$
			Package pkg = model.getNestedPackage(name);
			try {
				TemplateBinding binding =
					TemplateUtils.fixedBinding(model, extendedPort, (Classifier)type);
				Copy copy = new Copy(model, model, false);
				TemplateInstantiation ti = new TemplateInstantiation(copy, binding);
				// remove listener synchronizing implementation, since it would add derived
				// elements for the extended port itself (e.g. provided operations)
				if(copy.postCopyListeners.contains(FixTemplateSync.getInstance())) {
					copy.postCopyListeners.remove(FixTemplateSync.getInstance());
				}
				if (pkg != null) {
					// bound template already exists, sync copy map
					syncCopy(copy, pkgTemplate, pkg);
				}
				// create a bound element of the extended port. Add bound class to derived interface class
				ti.bindNamedElement(extendedPort);
			} catch (TransformationException e) {
			}
		}
	}
	
	/**
	 * Synchronize the copy map, i.e. put the correspondences between existing source and target elements into the map.
	 * Otherwise, a new binding would produce duplicates.
	 * TODO: A more efficient way would be to cache the copy function and only re-sync, if a new model has been loaded.
	 *   On the other hand, the bound package is normally not very large
	 *   
	 * @param copy A copy map
	 * @param sourcePkg The package template (source)
	 * @param targetPkg The bound package (target)
	 */
	public static void syncCopy(Copy copy, Package sourcePkg, Package targetPkg) {
		copy.put(sourcePkg, targetPkg);
		for (PackageableElement target : targetPkg.getPackagedElements()) {
			if (target instanceof NamedElement) {
				String targetName = ((NamedElement) target).getName();
				PackageableElement source = sourcePkg.getPackagedElement(targetName);
				if((source instanceof Package) && (target instanceof Package)) {
					syncCopy(copy, (Package) source, (Package) target);
				}
				else {
					copy.put(source, target);
				}
			}
		}

	}
}
