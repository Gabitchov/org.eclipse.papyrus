package org.eclipse.papyrus.facadeSpecificEditor.utils;

import java.io.File;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.uml2.uml.resource.UMLResource;

public class UMLModelUtils {

	public static EObject loadModel(File file, ResourceSet resourceSet) {
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(UMLResource.FILE_EXTENSION, UMLResource.Factory.INSTANCE);
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(UMLResource.Factory.Registry.DEFAULT_EXTENSION, UMLResource.Factory.INSTANCE);

		return resourceSet.getResource(URI.createFileURI(file.getAbsolutePath()), true).getContents().get(0);
	}

	public static EObject loadModel(URI uri, ResourceSet resourceSet) {
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(UMLResource.FILE_EXTENSION, UMLResource.Factory.INSTANCE);
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(UMLResource.Factory.Registry.DEFAULT_EXTENSION, UMLResource.Factory.INSTANCE);

		return resourceSet.getResource(uri, true).getContents().get(0);
	}
}
