package org.eclipse.papyrus.infra.gmfdiag.css.properties.databinding;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

public class RemoveObjectCommand extends RecordingCommand {
	
	EObject object;
	
	public RemoveObjectCommand(TransactionalEditingDomain domain, EObject object) {
		super(domain);
		this.object = object;
	}

	@Override
	protected void doExecute() {
		EcoreUtil.remove(object);
	}
}