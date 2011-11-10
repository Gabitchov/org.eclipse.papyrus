/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.composite.custom.ui;


import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.diagram.common.util.Util;
import org.eclipse.papyrus.uml.diagram.composite.custom.messages.Messages;
import org.eclipse.papyrus.uml.tools.utils.NamedElementUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLPackage;


/**
 * This dialog allows to create easily a new element in a UML Model.
 */
public class CreateUmlElementDialog extends ElementTreeSelectionDialog {

	/** the hinted type of the element to create. */
	private IHintedType hintedType;

	/** the parent container of the element to create. */
	private Object parentContainer;

	/** the type of the element to create. */
	private String type;

	/** the root of the model. */
	private Package pack;

	/** the text field used to display the choose the name of the future element. */
	private Text text;

	/** creation request. */
	private CreateElementRequest request;

	/** the editing domain. */
	private TransactionalEditingDomain domain;

	/** The element to create is represented by this field. */
	private NewElementRepresentation elementToCreate;

	/** this Set contains names to exclude from the proposed name. */
	private List<String> forbiddenNames;




	/**
	 * Constructor.
	 * 
	 * @param parent
	 *        the parent
	 * @param domain
	 *        the domain
	 * @param labelProvider
	 *        the label provider
	 * @param contentProvider
	 *        the content provider
	 * @param pack
	 *        the pack
	 * @param hintedType
	 *        the hinted type
	 */
	public CreateUmlElementDialog(Shell parent, TransactionalEditingDomain domain, ILabelProvider labelProvider, ITreeContentProvider contentProvider, Package pack, IHintedType hintedType) {
		super(parent, labelProvider, contentProvider);
		Assert.isNotNull(pack);
		Assert.isNotNull(hintedType);
		this.pack = pack;
		this.hintedType = hintedType;
		this.domain = domain;
		init();
	}

	/**
	 * Initializes the field {@link #type};.
	 */
	protected void init() {
		EClass eClass = hintedType.getEClass();
		this.type = eClass.getName();
		this.parentContainer = null;
		this.forbiddenNames = null;
	}

	/**
	 * Sets the forbidden names.
	 * 
	 * @param forbiddenNames
	 *        the new forbidden names
	 */
	public void setForbiddenNames(List<String> forbiddenNames) {
		this.forbiddenNames = forbiddenNames;
	}

	/**
	 * Creates the dialog area.
	 * 
	 * @param parent
	 *        the parent
	 * @return the control
	 * @see org.eclipse.ui.dialogs.ElementTreeSelectionDialog#createDialogArea(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Control createDialogArea(Composite parent) {

		GridData data = (GridData)parent.getLayoutData();
		data.grabExcessHorizontalSpace = true;
		data.horizontalSpan = 1;
		data.horizontalAlignment = SWT.FILL;
		data.verticalAlignment = SWT.FILL;
		Composite composite = (Composite)super.createDialogArea(parent);
		composite.setLayout(new GridLayout());
		GridData dat = new GridData(GridData.FILL_BOTH);
		composite.setLayoutData(dat);
		createNameSection(parent);

		return composite;
	}

	/**
	 * Creates the name section and put it at the top of the composite.
	 * 
	 * @param parent
	 *        the composite parent
	 */
	protected void createNameSection(Composite parent) {

		Composite nameSection = new Composite(parent, SWT.NONE);

		//the label
		Label label = new Label(nameSection, SWT.NONE);
		label.setText(Messages.CreateUmlElementDialog_New_Element_Name);

		//the text field
		text = new Text(nameSection, SWT.BORDER);
		text.setText(getDefaultName());
		GridData textData = new GridData(GridData.FILL_HORIZONTAL);
		text.setLayoutData(textData);

		//layout for the nameSection
		GridLayout layout = new GridLayout(2, false);
		GridData data = new GridData(GridData.FILL_BOTH);
		nameSection.setLayout(layout);
		nameSection.setLayoutData(data);

		//we set the name section in first!
		nameSection.moveAbove(null);
	}

	/**
	 * Returns the default name for the new Element.
	 * 
	 * @return the default name
	 *         the default name for the new Element
	 */
	protected String getDefaultName() {

		boolean existsInterface = false;
		String defaultName;
		int max = 0;
		do {

			ArrayList<?> allInterface = Util.getInstancesFilteredByType(pack, Interface.class, null);
			for(Object object : allInterface) {
				String name = NamedElementUtil.getName((NamedElement)object);
				if(name != null && name.startsWith(type)) {
					name = name.substring(type.length());
					Integer val = null;
					try {
						val = Integer.parseInt(name);
					} catch (NumberFormatException e) {
						//Nothing to do
					}
					if(val != null) {
						max = Math.max(Integer.valueOf(val), max);
						existsInterface = true;
					}
				}
			}
			if(existsInterface) {
				defaultName = type + new Integer(max + 1).toString();
			} else {
				defaultName = type + new Integer(max).toString();
			}
			max++;
		} while(!isCorrectName(defaultName));
		return defaultName;
	}

	/**
	 * Tests if the proposed name is not forbidden
	 * 
	 * @param name
	 *        a name
	 * @return
	 *         <code>true</code> if the proposed name is not forbidden
	 */
	protected boolean isCorrectName(String name) {
		if(forbiddenNames == null) {
			return true;
		}
		return !forbiddenNames.contains(name);
	}

	/**
	 * Returns the command to create the new element which the chosen name.
	 * 
	 * @return the command
	 *         the command to create the new element which the chosen name
	 */
	public Command getCommand() {

		CompositeCommand cmd = new CompositeCommand("Create new element command"); //$NON-NLS-1$
		//request to create the new Interface
		if(elementToCreate.getCreateElementRequest() != null) {
			ICommand command = getCommand(elementToCreate.getCreateElementRequest());
			if(command.canExecute()) {
				cmd.add(command);
				SetNameCommand nameCommand = new SetNameCommand(domain, "Set Name Command", null, request, elementToCreate); //$NON-NLS-1$
				if(nameCommand.canExecute()) {
					cmd.add(nameCommand);
				}
			}
			return new ICommandProxy(cmd);
		} else {
			return new ICommandProxy(new CustomCreateElementCommand(domain, "CustomCreateElementCommand", null, elementToCreate)); //$NON-NLS-1$
		}
	}

	/**
	 * Compute result.
	 * 
	 * @see org.eclipse.ui.dialogs.ElementTreeSelectionDialog#computeResult()
	 */
	@Override
	protected void computeResult() {
		java.util.List<Object> result = new ArrayList<Object>();
		result.add(elementToCreate);
		setResult(result);
	}

	/**
	 * Set the value to {@link #name} and {@link #parentContainer}.
	 * 
	 * @see org.eclipse.ui.dialogs.SelectionStatusDialog#okPressed()
	 */
	@Override
	protected void okPressed() {
		ISelection selection = getTreeViewer().getSelection();
		parentContainer = ((IStructuredSelection)selection).getFirstElement();
		CreateElementRequest request = null;
		if(parentContainer instanceof EObject) {
			request = new CreateElementRequest(domain, (EObject)parentContainer, this.hintedType);
		}
		elementToCreate = new NewElementRepresentation(this.text.getText(), parentContainer, hintedType, request);
		super.okPressed();
	}

	/**
	 * Returns a command corresponding to this request.
	 * 
	 * @param request
	 *        a request
	 * @return the command
	 *         The command corresponding to this request or an {@link UnexecutableCommand} when the command can not be build
	 */
	private ICommand getCommand(IEditCommandRequest request) {
		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(UMLPackage.eINSTANCE.getNamedElement());
		{
			if(provider != null) {
				ICommand cmd = provider.getEditCommand(request);
				if(cmd != null && cmd.canExecute()) {
					return cmd;
				}
			}
		}
		return org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand.INSTANCE;
	}

	/**
	 * This command is used to set the chosen name to the new element.
	 */
	public class SetNameCommand extends AbstractTransactionalCommand {

		/** the representation that will own the new element when it will be created. */
		private NewElementRepresentation representation;

		/**
		 * Constructor.
		 * 
		 * @param domain
		 *        the domain
		 * @param label
		 *        the label
		 * @param affectedFiles
		 *        the affected files
		 * @param previousRequest
		 *        the previous request
		 * @param representation
		 *        the representation
		 */
		public SetNameCommand(TransactionalEditingDomain domain, String label, List<?> affectedFiles, CreateElementRequest previousRequest, NewElementRepresentation representation) {
			super(domain, label, affectedFiles);
			this.representation = representation;
		}

		/**
		 * Do execute with result.
		 * 
		 * @param monitor
		 *        the monitor
		 * @param info
		 *        the info
		 * @return the command result
		 * @throws ExecutionException
		 *         the execution exception
		 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor,
		 *      org.eclipse.core.runtime.IAdaptable)
		 */
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			if(representation.getEObject() instanceof NamedElement) {
				NamedElement el = (NamedElement)representation.getEObject();
				el.setName(representation.getName());
			}

			return CommandResult.newOKCommandResult(representation);
		}

	}

	/**
	 * This command allows to create a new element when its parent is not yet created when the command is build
	 * 
	 * We need a such command, because {@link CreateRelationshipCommand#getCommandResult()} return <code>null</code> when the command has not been
	 * executed.
	 */
	public class CustomCreateElementCommand extends AbstractTransactionalCommand {

		/** the representation of the element to create. */
		private NewElementRepresentation elementToCreate;

		/**
		 * Constructor.
		 * 
		 * @param domain
		 *        the domain
		 * @param label
		 *        the label
		 * @param affectedFiles
		 *        the affected files
		 * @param elementToCreate
		 *        the element to create
		 */
		public CustomCreateElementCommand(TransactionalEditingDomain domain, String label, List<?> affectedFiles, NewElementRepresentation elementToCreate) {
			super(domain, label, affectedFiles);
			this.elementToCreate = elementToCreate;
		}

		/**
		 * Do execute with result.
		 * 
		 * @param monitor
		 *        the monitor
		 * @param info
		 *        the info
		 * @return the command result
		 * @throws ExecutionException
		 *         the execution exception
		 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor,
		 *      org.eclipse.core.runtime.IAdaptable)
		 */
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			EObject container = elementToCreate.getEObjectParent();
			CreateElementRequest request = new CreateElementRequest(domain, container, hintedType);
			ICommand command = getCommand(request);
			command.execute(new NullProgressMonitor(), null);
			EObject newEl = request.getNewElement();

			if(newEl instanceof NamedElement) {
				((NamedElement)newEl).setName(elementToCreate.getName());
			}

			elementToCreate.setCreateElement(request.getNewElement());
			return CommandResult.newOKCommandResult(elementToCreate);
		}
	}
}
