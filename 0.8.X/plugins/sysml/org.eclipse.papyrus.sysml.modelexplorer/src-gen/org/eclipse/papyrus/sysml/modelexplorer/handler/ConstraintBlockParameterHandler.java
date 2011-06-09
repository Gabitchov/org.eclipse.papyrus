package org.eclipse.papyrus.sysml.modelexplorer.handler;

import org.eclipse.core.commands.IHandler;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.ISpecializationType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.diagram.common.helper.NamedElementHelper;
import org.eclipse.papyrus.service.edit.commands.ConfigureFeatureCommandFactory;
import org.eclipse.papyrus.service.edit.commands.IConfigureCommandFactory;
import org.eclipse.papyrus.service.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.service.edit.service.IElementEditService;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * <pre>
 * Command handler for Problem creation
 *
 * </pre>
 * @generated
 */
public class ConstraintBlockParameterHandler extends CreateCommandHandler implements IHandler {

	/**
	 * <pre>
	 * @see org.eclipse.papyrus.sysml.modelexplorer.handler.CreateCommandHandler#getElementTypeToCreate()
	 *
	 * @return the IElementType this handler is supposed to create
	 *
	 * </pre>
	 * @generated
	 */
	protected IElementType getElementTypeToCreate() {
    return UMLElementTypes.PROPERTY;
  }
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand buildCommand() {

		if(getSelectedElements().size() != 1) {
			return UnexecutableCommand.INSTANCE;
		}

		EObject container = getSelectedElements().get(0);
		if ((container == null) || !((ISpecializationType) SysMLElementTypes.CONSTRAINT_BLOCK).getMatcher().matches(container)) {
			return UnexecutableCommand.INSTANCE;
		}
		
		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(container);
		if(provider == null) {
			return UnexecutableCommand.INSTANCE;
		}

		// Retrieve create command from the Element Edit service
		String name = NamedElementHelper.EINSTANCE.getNewUMLElementName((Element)container, "parameter"); //$NON-NLS-1$
		CreateElementRequest createRequest = new CreateElementRequest(container, getElementTypeToCreate());
		createRequest.setParameter(IConfigureCommandFactory.CONFIGURE_COMMAND_FACTORY_ID, new ConfigureFeatureCommandFactory(UMLPackage.eINSTANCE.getNamedElement_Name(), name));
		ICommand createGMFCommand = provider.getEditCommand(createRequest);

		return createGMFCommand;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEnabled() {
		return getCommand().canExecute();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isVisible() {
		return getCommand().canExecute();
	}
}

