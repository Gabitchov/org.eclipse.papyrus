package org.eclipse.papyrus.uml.diagram.common.commands;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.common.helper.NamedElementHelper;
import org.eclipse.papyrus.uml.diagram.common.service.ApplyStereotypeRequest;
import org.eclipse.papyrus.uml.tools.utils.NamedElementUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Stereotype;


public class ApplyStereotypeCommand extends AbstractTransactionalCommand {

	protected ApplyStereotypeRequest req;

	public ApplyStereotypeCommand(TransactionalEditingDomain domain, ApplyStereotypeRequest req) {
		super(domain, "Apply stereotype", null);
		this.req = req;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		// retrieves the list of stereotypes to be applied
		List<String> stereotypeQNames = req.getStereotypesToApply();
		Element element = req.getElement();
		List<EObject> result = new ArrayList<EObject>();
		for(String stereotypeQName : stereotypeQNames) {
			// retrieve the stereotype to apply
			Stereotype stereotype = element.getApplicableStereotype(stereotypeQName);
			if(stereotype == null) {
				// stereotype has no been found. should ask for
				// profile application ?
				Activator.log.warn("impossible to retrieve the stereotype " + stereotypeQName);
			} else {
				result.add(element.applyStereotype(stereotype));
			}
		}

		if (req.renameWithFirstStereotype() && element instanceof NamedElement && !stereotypeQNames.isEmpty()) {
			String stereotypeName = NamedElementUtil.getNameFromQualifiedName(stereotypeQNames.get(0));
			// find a new name for the element
			String name = NamedElementHelper.EINSTANCE.getNewUMLElementName(element.getOwner(), stereotypeName);
			((NamedElement)element).setName(name);
		}


		if (result.size() > 1) {
			return CommandResult.newOKCommandResult(result);
		} else if (result.size() == 1) {
			return CommandResult.newOKCommandResult(result.get(0));
		}
		return CommandResult.newOKCommandResult();
	}
}
