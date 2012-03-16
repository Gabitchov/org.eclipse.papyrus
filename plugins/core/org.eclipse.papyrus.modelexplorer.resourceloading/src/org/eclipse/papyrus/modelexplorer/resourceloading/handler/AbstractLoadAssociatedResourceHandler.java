package org.eclipse.papyrus.modelexplorer.resourceloading.handler;

import java.util.Set;

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.resource.ModelSet;


public abstract class AbstractLoadAssociatedResourceHandler extends AbstractResourceHandler {

	@Override
	protected void handleEObject(final EObject eObj, final ModelSet modelSet, CompoundCommand cc, Set<URI> handledURI) {
		final Resource originalResource = eObj.eResource();
		if (originalResource != null && originalResource.getURI() != null) {
			URI trimmedURI = originalResource.getURI().trimFileExtension();
			if (!handledURI.contains(trimmedURI)) {
				handledURI.add(trimmedURI);

				final URI associatedResourceURI = trimmedURI.appendFileExtension(getFileExtension());
				
				Resource associatedResource = modelSet.getResource(associatedResourceURI, false);
				if (associatedResource == null || !associatedResource.isLoaded()) {
					Command cmd = new AbstractCommand() {

						protected Resource r;

						public void execute() {
							redo();
						}

						public void redo() {
							try {
								r = modelSet.getResource(associatedResourceURI, true);
								if(r != null && !r.isLoaded()) {
									r.load(null);
								}
							} catch (Exception e) {
							}
						}

						@Override
						public boolean canUndo() {
							return false;
						}

						public boolean canExecute() {
							return true;
						}
					};
					cc.append(cmd);
				}
			}
		}
	}
	protected abstract String getFileExtension();
}
