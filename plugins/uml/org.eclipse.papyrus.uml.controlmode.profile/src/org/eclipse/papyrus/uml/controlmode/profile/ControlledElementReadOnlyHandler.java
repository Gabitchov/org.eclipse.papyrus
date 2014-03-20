/*****************************************************************************
 * Copyright (c) 2013, 2014 Atos, CEA, and others.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Arthur Daussy (Atos) arthur.daussy@atos.net - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 429826
 *  Camille Letavernier (CEA LIST) - Bug 430118
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.controlmode.profile;

import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.core.resource.AbstractReadOnlyHandler;
import org.eclipse.papyrus.infra.core.resource.ReadOnlyAxis;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.builders.NotificationBuilder;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;

import com.google.common.base.Optional;


/**
 * Read only handler that will prevent model fragment to be modified it the root element is not a package
 * This restriction is because of the UML2 implementation which delete stereotype applications if the current model can not find the corresponding
 * profile
 * application. This handler is discretion-based.
 *
 * @author adaussy
 *
 */
public class ControlledElementReadOnlyHandler extends AbstractReadOnlyHandler {

	public ControlledElementReadOnlyHandler(EditingDomain editingDomain) {
		super(editingDomain);
	}

	public Optional<Boolean> anyReadOnly(Set<ReadOnlyAxis> axes, URI[] uris) {
		if((getEditingDomain() == null) || !axes.contains(ReadOnlyAxis.DISCRETION)) {
			return Optional.absent();
		}
		ResourceSet resourceSet = getEditingDomain().getResourceSet();
		if(resourceSet != null) {
			for(URI uri : uris) {
				if(UmlModel.UML_FILE_EXTENSION.equals(uri.fileExtension())) {
					Resource resource = resourceSet.getResource(uri.trimFragment(), false);
					if(resource != null) {
						if(!resource.getContents().isEmpty()) {
							//A sub model can only be writable if the root element is package or if the root is contained by another loaded resource
							EObject root = resource.getContents().get(0);
							if(!(root instanceof Package) && root instanceof Element) {
								return Optional.of(((Element)root).getNearestPackage() == null);
							}
						}
					}
				}
			}
		}
		return Optional.absent();
	}

	public Optional<Boolean> makeWritable(Set<ReadOnlyAxis> axes, URI[] uris) {
		//Never authorize write
		NotificationBuilder.createErrorPopup("This model fragment can not be modified independently from the rest of the model").run();
		return Optional.absent();
	}

}
