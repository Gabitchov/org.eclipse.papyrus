package org.eclipse.papyrus.core.adaptor.gmf;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.resources.GMFResource;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.core.extension.commands.ICreationCommand;
import org.eclipse.papyrus.core.navigation.CreatedNavigableElement;
import org.eclipse.papyrus.core.navigation.NavigableElement;
import org.eclipse.papyrus.core.navigation.NavigationHelper;
import org.eclipse.papyrus.core.utils.DiResourceSet;


public class DiagramsUtil {

	/**
	 * Gets the diagrams associated to element.
	 * 
	 * @param element
	 * @param resourceSet
	 *        can be null, it will then try to retrieve it from the element.
	 * @return the list of diagrams associated with the given element
	 */
	public static List<Diagram> getAssociatedDiagrams(EObject element, ResourceSet resourceSet) {
		if(resourceSet == null) {
			if(element != null && element.eResource() != null) {
				resourceSet = element.eResource().getResourceSet();
			}
		}

		if(resourceSet != null) {
			LinkedList<Diagram> diagrams = new LinkedList<Diagram>();
			for (Resource r : resourceSet.getResources()) {
				if (r instanceof GMFResource) {
					for(EObject eObj : r.getContents()) {
						if(eObj instanceof Diagram) {
							Diagram diagram = (Diagram)eObj;
							if(element.equals(diagram.getElement())) {
								diagrams.add(diagram);
							}
						}
					}
				}
			}
			return diagrams;
		}

		return Collections.EMPTY_LIST;
	}

	public static CompositeCommand getLinkCreateAndOpenNavigableDiagram(final NavigableElement navElement, ICreationCommand creationCommandInterface, final String diagramName, DiResourceSet diResourceSet) {
		CompositeCommand compositeCommand = new CompositeCommand("Create diagram");

		if(navElement instanceof CreatedNavigableElement) {
			compositeCommand.add(new AbstractTransactionalCommand(diResourceSet.getTransactionalEditingDomain(), "Create hierarchy", null) {

				@Override
				protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
					NavigationHelper.linkToModel((CreatedNavigableElement)navElement);
					NavigationHelper.setBaseName((CreatedNavigableElement)navElement, diagramName);
					return CommandResult.newOKCommandResult();
				}
			});
		}

		ICommand createDiagCommand = creationCommandInterface.getCreateDiagramCommand(diResourceSet, navElement.getElement(), diagramName);
		compositeCommand.add(createDiagCommand);
		compositeCommand.add(new OpenDiagramCommand(diResourceSet.getAssociatedDiResource(navElement.getElement()), diResourceSet.getTransactionalEditingDomain(), createDiagCommand));

		return compositeCommand;
	}
}
