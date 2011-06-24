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


package org.eclipse.papyrus.diagram.profile.custom.commands;

import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.profile.definition.PapyrusDefinitionAnnotation;
import org.eclipse.papyrus.profile.definition.ProfileRedefinition;
import org.eclipse.papyrus.umlutils.PackageUtil;
import org.eclipse.uml2.uml.Profile;


/**
 * This command is used to define a profile
 * 
 * @author VL222926
 * 
 */

public class DefineProfileCommand extends AbstractTransactionalCommand {


	/**
	 * the {@link EditPartViewer}
	 */
	private EditPartViewer viewer;

	/**
	 * the {@link PapyrusDefinitionAnnotation}
	 */
	private PapyrusDefinitionAnnotation papyrusAnnotation;

	/**
	 * the profile to define
	 */
	private Profile rootProfile;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param domain
	 * @param papyrusAnnotation
	 * @param rootProfile
	 * @param viewer
	 */
	public DefineProfileCommand(TransactionalEditingDomain domain, PapyrusDefinitionAnnotation papyrusAnnotation, Profile rootProfile, EditPartViewer viewer) {
		super(domain, "DefineProfileCommand", null); //$NON-NLS-1$
		this.viewer = viewer;
		this.rootProfile = rootProfile;
		this.papyrusAnnotation = papyrusAnnotation;

	}



	/**
	 * 
	 * 
	 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor,
	 *      org.eclipse.core.runtime.IAdaptable)
	 * 
	 * @param monitor
	 * @param info
	 * @return
	 * @throws ExecutionException
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		PackageUtil.defineProfiles(rootProfile);
		try {
			ProfileRedefinition.redefineProfile(rootProfile, papyrusAnnotation);
			ProfileRedefinition.cleanProfile(rootProfile);
		} catch (Exception e) {
			e.printStackTrace();
		}


		setResult(CommandResult.newOKCommandResult());
		return CommandResult.newOKCommandResult();
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#getAffectedFiles()
	 * 
	 * @return
	 */
	@Override
	public List getAffectedFiles() {
		if(viewer != null) {
			EditPart editpart = viewer.getRootEditPart().getContents();
			if(editpart instanceof IGraphicalEditPart) {
				View view = (View)((IGraphicalEditPart)editpart).getModel();
				if(view != null) {
					IFile f = WorkspaceSynchronizer.getFile(view.eResource());
					return f != null ? Collections.singletonList(f) : Collections.EMPTY_LIST;
				}
			}
		}
		return super.getAffectedFiles();

	}
}
