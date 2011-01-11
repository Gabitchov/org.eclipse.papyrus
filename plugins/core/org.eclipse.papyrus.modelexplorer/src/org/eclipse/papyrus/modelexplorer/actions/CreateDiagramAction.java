package org.eclipse.papyrus.modelexplorer.actions;

import static org.eclipse.papyrus.modelexplorer.Activator.log;

import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.jface.action.Action;
import org.eclipse.papyrus.core.adaptor.gmf.DiagramsUtil;
import org.eclipse.papyrus.core.extension.commands.CreationCommandDescriptor;
import org.eclipse.papyrus.core.navigation.NavigableElement;
import org.eclipse.papyrus.core.utils.DiResourceSet;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.modelexplorer.handler.GMFtoEMFCommandWrapper;
/**
 * Action to create a diagram on a navigable element
 *
 * @author mvelten
 *
 */
// TODO change diagram name
public class CreateDiagramAction extends Action {

	private final NavigableElement navElement;

	private final CreationCommandDescriptor commandDescriptor;

	/**
	 * Constructor
	 * 
	 * @param selectedObject
	 *        the selected Element on which the diagram is to be associated
	 */
	public CreateDiagramAction(NavigableElement navElement, CreationCommandDescriptor commandDescriptor) {
		this.navElement = navElement;
		this.commandDescriptor = commandDescriptor;
		setText(commandDescriptor.getLabel());
		setImageDescriptor(commandDescriptor.getIcon());
	}

	/**
	 * @see org.eclipse.jface.action.Action#isEnabled()
	 */
	@Override
	public boolean isEnabled() {
		return navElement != null && navElement.getElement() != null;
	}

	/**
	 * This methods creates a new Diagram to be associated with the given domain
	 * element
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {

		try {
			DiResourceSet diResourceSet = EditorUtils.getDiResourceSet();
			
			CompositeCommand compositeCommand = DiagramsUtil.getLinkCreateAndOpenNavigableDiagram(navElement, commandDescriptor.getCommand(), null, diResourceSet);

			diResourceSet.getTransactionalEditingDomain().getCommandStack().execute(new GMFtoEMFCommandWrapper(compositeCommand));
		} catch (Exception e) {
			log.error(e);
		}
	}
}
