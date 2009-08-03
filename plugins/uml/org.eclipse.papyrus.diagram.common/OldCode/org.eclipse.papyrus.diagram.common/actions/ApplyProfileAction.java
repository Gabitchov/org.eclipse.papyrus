/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana .
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Francisco Javier Cano MuÃ±oz (Prodevelop) - initial API implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.common.actions;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.AbstractEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.papyrus.diagram.common.part.CustomMessages;
import org.eclipse.papyrus.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.ProfileApplication;

// TODO: Auto-generated Javadoc
/**
 * The Class ApplyProfileAction.
 */
public class ApplyProfileAction extends DiagramAction {

	/** The Constant EMPTY_NAME. */
	private static final String EMPTY_NAME = CustomMessages.ApplyProfileAction_empty_name;

	/** The my package. */
	private org.eclipse.uml2.uml.Package myPackage;

	/** The my profile. */
	private Profile myProfile;

	/**
	 * Instantiates a new apply profile action.
	 * 
	 * @param workbenchPage
	 *            the workbench page
	 * @param package_
	 *            the package_
	 * @param profile
	 *            the profile
	 */
	public ApplyProfileAction(IWorkbenchPage workbenchPage, org.eclipse.uml2.uml.Package package_, Profile profile) {
		super(workbenchPage);
		myPackage = package_;
		myProfile = profile;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction#createTargetRequest()
	 */
	@Override
	protected Request createTargetRequest() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction#isSelectionListener()
	 */
	@Override
	protected boolean isSelectionListener() {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction#getCommand()
	 */
	@Override
	protected Command getCommand() {
		GraphicalEditPart packageEditPart = getPackageEditPart();
		if (packageEditPart == null) {
			return UnexecutableCommand.INSTANCE;
		}
		TransactionalEditingDomain editingDomain = packageEditPart.getEditingDomain();
		IEditCommandRequest request = new AbstractEditCommandRequest(editingDomain) {

			public Object getEditHelperContext() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		boolean toApply = !isProfileAppliedTo(myPackage, myProfile);
		if (toApply) {
			return new ICommandProxy(new ApplyProfileCommand(CustomMessages.ApplyProfileAction_apply_profile_command,
					myPackage, myProfile, request));
		}
		CompoundCommand cc = new CompoundCommand("Unapply and refresh");
		cc.add(new ICommandProxy(new UnapplyProfileCommand(CustomMessages.ApplyProfileAction_unapply_profile_command,
				myPackage, myProfile, request)));
		cc.add(new RefreshITextAwareEditPartsCommand(packageEditPart));
		return cc;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.action.Action#isEnabled()
	 */
	@Override
	public boolean isEnabled() {
		return getPackageEditPart() != null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction#refresh()
	 */
	@Override
	public void refresh() {
		super.refresh();
		setText(calculateText());
		setChecked(calculateChecked());
	}

	/**
	 * Calculate text.
	 * 
	 * @return the string
	 */
	private String calculateText() {
		String name = myProfile.getName();
		return name != null ? name : EMPTY_NAME;
	}

	/**
	 * Calculate checked.
	 * 
	 * @return true, if successful
	 */
	private boolean calculateChecked() {
		return isProfileAppliedTo(myPackage, myProfile);
	}

	// Modified to avoid using PackageEditPart
	/**
	 * Gets the package edit part.
	 * 
	 * @return the package edit part
	 */
	private GraphicalEditPart getPackageEditPart() {
		for (Object next : getSelectedObjects()) {
			if (isPackageEditPart(next)) {
				GraphicalEditPart packageEditPart = (GraphicalEditPart) next;
				return packageEditPart;
			}
		}
		return null;
	}

	// Added to check if a GraphicalEditPart contains a Package
	/**
	 * Checks if is package edit part.
	 * 
	 * @param obj
	 *            the obj
	 * 
	 * @return true, if is package edit part
	 */
	private boolean isPackageEditPart(Object obj) {
		if (obj instanceof GraphicalEditPart) {
			GraphicalEditPart gEP = (GraphicalEditPart) obj;
			if (gEP.resolveSemanticElement() instanceof org.eclipse.uml2.uml.Package) {
				return true;
			}
			return false;
		}
		return false;
	}

	/**
	 * Checks if is profile applied to.
	 * 
	 * @param package_
	 *            the package_
	 * @param profile
	 *            the profile
	 * 
	 * @return true, if is profile applied to
	 */
	private boolean isProfileAppliedTo(org.eclipse.uml2.uml.Package package_, Profile profile) {
		ProfileApplication profileApplication = package_.getProfileApplication(profile);
		return profileApplication != null && profileApplication.getAppliedDefinition() == profile.getDefinition();
	}

	/**
	 * The Class ApplyProfileCommand.
	 */
	private class ApplyProfileCommand extends EditElementCommand {

		/** The my package. */
		org.eclipse.uml2.uml.Package myPackage;

		/** The my profile. */
		private Profile myProfile;

		/**
		 * Instantiates a new apply profile command.
		 * 
		 * @param label
		 *            the label
		 * @param package_
		 *            the package_
		 * @param profile
		 *            the profile
		 * @param request
		 *            the request
		 */
		protected ApplyProfileCommand(String label, org.eclipse.uml2.uml.Package package_, Profile profile,
				IEditCommandRequest request) {
			super(label, package_, request);
			myPackage = package_;
			myProfile = profile;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @seeorg.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#
		 * doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor,
		 * org.eclipse.core.runtime.IAdaptable)
		 */
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
				throws ExecutionException {
			myPackage.applyProfile(myProfile);
			return CommandResult.newOKCommandResult(myProfile);
		}

	}

	/**
	 * The Class UnapplyProfileCommand.
	 */
	private class UnapplyProfileCommand extends EditElementCommand {

		/** The my package. */
		org.eclipse.uml2.uml.Package myPackage;

		/** The my profile. */
		private Profile myProfile;

		/**
		 * Instantiates a new unapply profile command.
		 * 
		 * @param label
		 *            the label
		 * @param package_
		 *            the package_
		 * @param profile
		 *            the profile
		 * @param request
		 *            the request
		 */
		protected UnapplyProfileCommand(String label, org.eclipse.uml2.uml.Package package_, Profile profile,
				IEditCommandRequest request) {
			super(label, package_, request);
			myPackage = package_;
			myProfile = profile;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @seeorg.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#
		 * doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor,
		 * org.eclipse.core.runtime.IAdaptable)
		 */
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
				throws ExecutionException {
			myPackage.unapplyProfile(myProfile);
			return CommandResult.newOKCommandResult(myProfile);
		}

	}

	/**
	 * The Class RefreshITextAwareEditPartsCommand.
	 */
	private class RefreshITextAwareEditPartsCommand extends Command {

		/** The edit part. */
		EditPart editPart;

		/**
		 * Instantiates a new refresh i text aware edit parts command.
		 * 
		 * @param editPart
		 *            the edit part
		 */
		protected RefreshITextAwareEditPartsCommand(EditPart editPart) {
			this.editPart = editPart;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.gef.commands.Command#execute()
		 */
		@Override
		public void execute() {
			DiagramEditPartsUtil.refreshITextAwareEditParts(editPart);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.gef.commands.Command#canExecute()
		 */
		@Override
		public boolean canExecute() {
			return editPart != null;
		}
	}
}
