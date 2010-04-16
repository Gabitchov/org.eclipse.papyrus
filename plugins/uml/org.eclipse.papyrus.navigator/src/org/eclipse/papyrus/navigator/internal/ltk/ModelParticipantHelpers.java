/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  <a href="mailto:thomas.szadel@atosorigin.com">Thomas Szadel</a> - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.navigator.internal.ltk;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.papyrus.core.utils.DiResourceSet;

public class ModelParticipantHelpers {

	/**
	 * get the files related the initialFile which need to be modified/deleted
	 * if initialFile is modified/deleted
	 * 
	 * @param initialFile
	 * @return a list of related files. Does not include initialFile.
	 */
	public static Set<IResource> getRelatedFiles(IFile initialFile) {

		Set<IResource> relatedFiles = new HashSet<IResource>();

		IContainer parent = initialFile.getParent();
		IPath initialPath = initialFile.getFullPath();

		IPath diPath = null;

		if(DiResourceSet.DI_FILE_EXTENSION.equalsIgnoreCase(initialPath.getFileExtension())) {
			diPath = initialPath;
		} else {
			// try to find a di file with the same name
			try {
				for(IResource r : parent.members()) {
					IPath p = r.getFullPath();
					if(DiResourceSet.DI_FILE_EXTENSION.equalsIgnoreCase(p.getFileExtension()) && p.removeFileExtension().equals(initialPath.removeFileExtension())) {
						diPath = p;
						break;
					}
				}
			} catch (CoreException e) {
			}
		}

		if(diPath != null) {
			IFile diFile = parent.getFile(diPath.makeRelativeTo(parent.getFullPath()));

			if(diFile.exists()) {
				relatedFiles.add(diFile);

				// add the notation file
				IPath notationPath = initialPath.removeFileExtension().addFileExtension(DiResourceSet.NOTATION_FILE_EXTENSION);
				IFile notationFile = parent.getFile(notationPath.makeRelativeTo(parent.getFullPath()));

				if(notationFile.exists()) {
					relatedFiles.add(notationFile);

					// find the related model files referenced in the notation file
					URI notationURI = URI.createPlatformResourceURI(notationPath.toString(), true);
					ResourceSet rs = new ResourceSetImpl();
					Resource notationResource = rs.getResource(notationURI, true);

					if(notationResource != null) {
						relatedFiles.addAll(getModelFilesFromNotationResource(notationResource));
					}
				}
			}
		}

		// If the initialFile is contained in the list, we remove it
		if(relatedFiles.contains(initialFile)) {
			relatedFiles.remove(initialFile);
		}

		return relatedFiles;
	}

	private static List<IResource> getModelFilesFromNotationResource(Resource notationResource) {
		List<IResource> modelFiles = new ArrayList<IResource>();

		// look for a model associated with a diagram in notation
		for(EObject eObject : notationResource.getContents()) {
			if(eObject instanceof Diagram) {
				Diagram diagram = (Diagram)eObject;
				InternalEObject element = (InternalEObject)diagram.eGet(NotationPackage.Literals.VIEW__ELEMENT, false);
				if(element != null && element.eIsProxy()) {
					URI modelURI = element.eProxyURI().trimFragment();
					if(modelURI.isPlatform()) {
						IResource modelFile = ResourcesPlugin.getWorkspace().getRoot().findMember(modelURI.toPlatformString(true));
						if(modelFile != null) {
							modelFiles.add(modelFile);
						}
					}
				}
			}
		}

		return modelFiles;
	}
}
