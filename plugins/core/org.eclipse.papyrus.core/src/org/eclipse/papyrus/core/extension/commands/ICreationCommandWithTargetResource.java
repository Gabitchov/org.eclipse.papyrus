package org.eclipse.papyrus.core.extension.commands;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.papyrus.core.utils.DiResourceSet;


public interface ICreationCommandWithTargetResource extends ICreationCommand {
	/**
	 * Get a command to create a new diagram in diResourceSet with the given
	 * name.
	 * 
	 * @param diResourceSet
	 *        the resourceSet containing all diagrams
	 * @param targetResource
	 *        the target resource, the diagram will be stored in the associated notation resource
	 * @param container
	 *        of the diagram, if container is null, the diagram is contained
	 *        by the top level container
	 * @param diagramName
	 *        the name of the new diagram or null to use a dialog to choose
	 *        the name
	 */
	public ICommand getCreateDiagramCommand(final DiResourceSet diResourceSet, final Resource targetResource, final EObject container, final String diagramName);
}
