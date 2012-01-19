package org.eclipse.papyrus.uml.diagram.common.commands;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.View;


public class SetNodeVisibilityCommand extends RecordingCommand {

	protected View view;
	protected Boolean isVisible;

	public SetNodeVisibilityCommand(TransactionalEditingDomain domain, View view,Boolean isVisible ) {
		super(domain);
		this.view=view;
		this.isVisible=isVisible;
	}

	@Override
	protected void doExecute() {
		if(view.isVisible()!=isVisible){
			view.setVisible(isVisible);
		}
		

	}

}
