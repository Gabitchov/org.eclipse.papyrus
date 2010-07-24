/**
 * 
 */
package javagen.umlparser;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.resource.UMLResource;

/**
 * This class is responsible of the life cycle of the model.
 * 
 * @author dumoulin
 * 
 */
public class ModelManager {

	private Resource model;

	private ResourceSet resourceSet;

	/**
	 * @return the resourceSet
	 */
	public ResourceSet getResourceSet() {
		return resourceSet;
	}

	/**
	 * @return the model
	 */
	public Resource getModel() {
		return model;
	}

	/**
	 * 
	 * @param filename
	 */
	protected void createModel(String filename) {
		// Create a resource set.
		resourceSet = new ResourceSetImpl();


		// Register the default resource factory -- only needed for stand-alone!
		//			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(UMLResource.FILE_EXTENSION, UMLResource.Factory.INSTANCE);
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(UMLResource.Factory.Registry.DEFAULT_EXTENSION, UMLResource.Factory.INSTANCE);

		// Get the URI of the model file.
		URI fileURI = URI.createFileURI(new File(filename).getAbsolutePath());

		System.out.println("URI= " + fileURI);
		// Create a resource for this file.
		model = resourceSet.createResource(fileURI);

	}

	/**
	 * 
	 * @param filename
	 */
	protected void loadModel(String filename) {
		UMLFactory.eINSTANCE.createActor();
		// Create a resource set.
		resourceSet = new ResourceSetImpl();


		// Register the default resource factory -- only needed for stand-alone!
		//		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(UMLResource.FILE_EXTENSION, UMLResource.Factory.INSTANCE);
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(UMLResource.Factory.Registry.DEFAULT_EXTENSION, UMLResource.Factory.INSTANCE);

		// Get the URI of the model file.
		URI fileURI = URI.createFileURI(new File(filename).getAbsolutePath());

		System.out.println("URI= " + fileURI);
		// Create a resource for this file.
		model = resourceSet.getResource(fileURI, true);

	}

	public void save() {
		try {
			System.out.println("Save model.");

			model.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
