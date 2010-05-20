/**
 * 
 */
package org.eclipse.papyrus.resource;

import org.eclipse.papyrus.core.utils.caches.TypeCacheInitializer;
import org.eclipse.papyrus.resource.notation.NotationModel;
import org.eclipse.papyrus.resource.sasheditor.SashModel;
import org.eclipse.papyrus.resource.uml.ExtendedUmlModel;
import org.eclipse.papyrus.resource.uml.UmlModel;
import org.eclipse.papyrus.resource.uml.UmlSnippet;


/**
 * A reader to read model from Eclipse extension
 * and register them to the specified ModelManager.
 * 
 * @author cedric dumoulin
 *
 */
public class ModelsReader {

	/**
	 * Populate the manager with models found in Eclipse extensions.
	 * 
	 * @param modelManager
	 */
	public void readModel( ModelSet modelManager) {
		
		// Actually, we register model manually.
		// TODO: read from Eclipse extension.
		modelManager.registerModel( new SashModel() );
		modelManager.registerModel( new NotationModel() );
		// uml model
		UmlModel umlModel = new ExtendedUmlModel();
		umlModel.addModelSnippet(new UmlSnippet());
		modelManager.registerModel(umlModel);
		// global snippets
		modelManager.addModelSetSnippet(new TypeCacheInitializer());
	}
}
