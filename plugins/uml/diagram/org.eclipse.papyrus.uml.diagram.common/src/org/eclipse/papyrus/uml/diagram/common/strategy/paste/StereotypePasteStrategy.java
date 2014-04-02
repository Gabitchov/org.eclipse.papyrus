/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Benoit Maggi (CEA LIST) benoit.maggi@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.strategy.paste;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.commands.wrappers.EMFtoGEFCommandWrapper;
import org.eclipse.papyrus.infra.core.clipboard.IClipboardAdditionalData;
import org.eclipse.papyrus.infra.core.clipboard.PapyrusClipboard;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.IPasteStrategy;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.common.preferences.IStereotypePasteStrategyPreferenceConstant;
import org.eclipse.papyrus.uml.tools.commands.ApplyProfileCommand;
import org.eclipse.papyrus.uml.tools.commands.ApplyStereotypeCommand;
import org.eclipse.papyrus.uml.tools.utils.PackageUtil;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * Offer a strategy for copying stereotypes.
 */
public class StereotypePasteStrategy implements IPasteStrategy {

	/** The instance. */
	private static IPasteStrategy instance = new StereotypePasteStrategy();

	/**
	 * Gets the single instance of StereotypePasteStrategy.
	 *
	 * @return single instance of StereotypePasteStrategy
	 */
	public static IPasteStrategy getInstance() {
		return instance;
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.IPasteStrategy#getLabel()
	 */
	public String getLabel() {
		return "StereotypeStrategy"; //$NON-NLS-1$
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.IPasteStrategy#getID()
	 */
	public String getID() {
		return Activator.ID + ".StereotypeStrategy"; //".ClassifierToStructureCompDrop"; //$NON-NLS-1$
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.IPasteStrategy#getDescription()
	 */
	public String getDescription() {
		return "Paste stereotype elements"; //$NON-NLS-1$
	}

	/**
	 * Gets the category id.
	 *
	 * @return the category id
	 */
	public String getCategoryID() {
		return "org.eclipse.papyrus.strategy.paste"; //$NON-NLS-1$
	}

	/**
	 * Gets the category label.
	 *
	 * @return the category label
	 */
	public String getCategoryLabel() {
		return "Paste all copied elements"; //$NON-NLS-1$
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.IPasteStrategy#getImage()
	 */
	@Deprecated
	public Image getImage() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.IPasteStrategy#getPriority()
	 */
	@Deprecated
	public int getPriority() {
		return 1;
	}

	/**
	 * Sets the options.
	 *
	 * @param options
	 *        the options
	 */
	public void setOptions(Map<String, Object> options) {
		//Nothing
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.IPasteStrategy#getSemanticCommand(org.eclipse.emf.edit.domain.EditingDomain,
	 * org.eclipse.emf.ecore.EObject, org.eclipse.papyrus.infra.core.clipboard.PapyrusClipboard)
	 */
	@Override
	public org.eclipse.emf.common.command.Command getSemanticCommand(EditingDomain domain, EObject targetOwner, PapyrusClipboard<Object> papyrusClipboard) {
		
		if (targetOwner instanceof Element){
			CompoundCommand compoundCommand = new CompoundCommand("Copy all stereotypes"); //$NON-NLS-1$
			
			Map<Profile,List<ApplyStereotypeCommand>> missingProfiles = new HashMap<Profile,List<ApplyStereotypeCommand>>();
			Package targetPackage = ((Element)targetOwner).getNearestPackage();
			
			// 1. init all ApplyStereotypeCommand
			for(Iterator<Object> iterator = papyrusClipboard.iterator(); iterator.hasNext();) {
				Object object = (Object)iterator.next();
				// get target Element
				EObject target = papyrusClipboard.getTragetCopyFromInternalClipboardCopy(object);
				if(target != null && target instanceof Element) {
					// get affiliate StereotypeClipboard
					Map<Object, ?> additionalDataMap = papyrusClipboard.getAdditionalDataForStrategy(getID());
					Object additionnalData = additionalDataMap.get(object);
					if(additionnalData instanceof StereotypeClipboard) {
						StereotypeClipboard stereotypeClipboard = (StereotypeClipboard)additionnalData;
						Collection<Stereotype> stereotypes = stereotypeClipboard.getStereotypes();
//						Collection<Stereotype> stereotypeListInTargetContext = new ArrayList<Stereotype>();
						for(Stereotype stereotype : stereotypes) {
							// reload the stereotype in the new Contex-ResourceSet (Required because in org.eclipse.uml2.uml.internal.operations.PackageOperations
							// L960 in getProfileApplication the test is using == instead of equals)
							Stereotype stereotypeInTargetContext = EMFHelper.reloadIntoContext(stereotype, targetOwner);
							
							Profile profile = stereotypeInTargetContext.getProfile();
							ApplyStereotypeCommand applyStereotypeCommand = new ApplyStereotypeCommand((Element)target, stereotypeInTargetContext, (TransactionalEditingDomain)domain);
							if (isProfileAppliedRecursive(targetPackage, profile)){		
								compoundCommand.append(applyStereotypeCommand);
							} else { // Profile is missing
//								Activator.getDefault().logWarning(profile.getName()+" is missing", null);
								List<ApplyStereotypeCommand> stereotypeListMissingProfiles = missingProfiles.get(profile);
								if (stereotypeListMissingProfiles!= null && !stereotypeListMissingProfiles.isEmpty()){
									stereotypeListMissingProfiles.add(applyStereotypeCommand);
								} else {
									stereotypeListMissingProfiles = new ArrayList<ApplyStereotypeCommand>();
									stereotypeListMissingProfiles.add(applyStereotypeCommand);
									missingProfiles.put(profile, stereotypeListMissingProfiles);
								}
							}
						}
					}
				}
			}
			
			// 2. user preferences (Apply profiles, data...)
			IPreferenceStore preferenceStore = Activator.getDefault().getPreferenceStore();
			String preferenceProfileStrategy = preferenceStore.getString(IStereotypePasteStrategyPreferenceConstant.PROFILE_STRATEGY);	
		
			if (IStereotypePasteStrategyPreferenceConstant.ASK_POPUP.equals(preferenceProfileStrategy)){// Ask user for instruction
				// TODO:  2. user choices (Apply profiles, data...)
			} else if (IStereotypePasteStrategyPreferenceConstant.IMPORT_MISSING_PROFILE.equals(preferenceProfileStrategy)){ // apply profile
				Set<Profile> keySet = missingProfiles.keySet();
				Package rootPackage = PackageUtil.getRootPackage((Element)targetOwner);
				ApplyProfileCommand applyProfileCommand = new ApplyProfileCommand(rootPackage, keySet, (TransactionalEditingDomain)domain);
				compoundCommand.append(applyProfileCommand);
				for(Profile profile : keySet) {
					List<ApplyStereotypeCommand> list = missingProfiles.get(profile);
					for(ApplyStereotypeCommand applyStereotypeCommand : list) {
						compoundCommand.append(applyStereotypeCommand);
					}
				}
			}
			
			
			// An empty can't be executed 
			if(compoundCommand.getCommandList().isEmpty()) {
				return null;
			}
			return compoundCommand;			
		}
		return UnexecutableCommand.INSTANCE;

	}




	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.IPasteStrategy#getGraphicalCommand(org.eclipse.emf.edit.domain.EditingDomain,
	 * org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart, org.eclipse.papyrus.infra.core.clipboard.PapyrusClipboard)
	 */
	@Override
	public Command getGraphicalCommand(EditingDomain domain, org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart targetEditPart, PapyrusClipboard<Object> papyrusClipboard) {
		org.eclipse.gef.commands.CompoundCommand compoundCommand = new org.eclipse.gef.commands.CompoundCommand("Stereotype Semantic And Graphical paste"); //$NON-NLS-1$
		Map<Profile,List<ApplyStereotypeCommand>> missingProfiles = new HashMap<Profile,List<ApplyStereotypeCommand>>();
		View view = (View)targetEditPart.getModel();
		EObject modelTargetOwner = (EObject)view.getElement();
		Package targetPackage = ((Element)modelTargetOwner).getNearestPackage();
		// apply stereotypes 
		for(Iterator<Object> iterator = papyrusClipboard.iterator(); iterator.hasNext();) {
			Object object = (Object)iterator.next();
			// get target Element
			EObject target = papyrusClipboard.getTragetCopyFromInternalClipboardCopy(object);
			if(target != null && target instanceof Element) {
				// get affiliate StereotypeClipboard
				Map<Object, ?> additionalDataMap = papyrusClipboard.getAdditionalDataForStrategy(getID());
				Object additionnalData = additionalDataMap.get(object);
				if(additionnalData instanceof StereotypeClipboard) {
					StereotypeClipboard stereotypeClipboard = (StereotypeClipboard)additionnalData;
					Collection<Stereotype> stereotypes = stereotypeClipboard.getStereotypes();
					for(Stereotype stereotype : stereotypes) {
						// reload the stereotype in the new Contex-ResourceSet (Required because in org.eclipse.uml2.uml.internal.operations.PackageOperations
						// L960 in getProfileApplication the test is using == instead of equals)
						Stereotype stereotypeInTargetContext = EMFHelper.reloadIntoContext(stereotype, modelTargetOwner);
						ApplyStereotypeCommand applyStereotypeCommand = new ApplyStereotypeCommand((Element)target, stereotypeInTargetContext, (TransactionalEditingDomain)domain);
						
						Profile profile = stereotypeInTargetContext.getProfile();
						if (isProfileAppliedRecursive(targetPackage, profile)){
							EMFtoGEFCommandWrapper emFtoGEFCommandWrapper = new EMFtoGEFCommandWrapper(applyStereotypeCommand);
							compoundCommand.add(emFtoGEFCommandWrapper);
						} else { // Profile is missing
							List<ApplyStereotypeCommand> stereotypeListMissingProfiles = missingProfiles.get(profile);
							if (stereotypeListMissingProfiles!= null && !stereotypeListMissingProfiles.isEmpty()){
								stereotypeListMissingProfiles.add(applyStereotypeCommand);
							} else {
								stereotypeListMissingProfiles = new ArrayList<ApplyStereotypeCommand>();
								stereotypeListMissingProfiles.add(applyStereotypeCommand);
								missingProfiles.put(profile, stereotypeListMissingProfiles);
							}	
						}	
					}

				}
			}
		}

		// 2. user preferences (Apply profiles, data...)
		IPreferenceStore preferenceStore = Activator.getDefault().getPreferenceStore();
		String preferenceProfileStrategy = preferenceStore.getString(IStereotypePasteStrategyPreferenceConstant.PROFILE_STRATEGY);	
	
		if (IStereotypePasteStrategyPreferenceConstant.ASK_POPUP.equals(preferenceProfileStrategy)){// Ask user for instruction
			// TODO:  2. user choices (Apply profiles, data...)
		} else if (IStereotypePasteStrategyPreferenceConstant.IMPORT_MISSING_PROFILE.equals(preferenceProfileStrategy)){ // apply profile
			Set<Profile> keySet = missingProfiles.keySet();
			Package rootPackage = PackageUtil.getRootPackage((Element)modelTargetOwner);
			ApplyProfileCommand applyProfileCommand = new ApplyProfileCommand(rootPackage, keySet, (TransactionalEditingDomain)domain);
			EMFtoGEFCommandWrapper emFtoGEFCommandWrapper = new EMFtoGEFCommandWrapper(applyProfileCommand);
			compoundCommand.add(emFtoGEFCommandWrapper);
			for(Profile profile : keySet) {
				List<ApplyStereotypeCommand> list = missingProfiles.get(profile);
				for(ApplyStereotypeCommand applyStereotypeCommand : list) {
					compoundCommand.add(new EMFtoGEFCommandWrapper(applyStereotypeCommand));
				}
			}
		}		
		
		
		if(compoundCommand.size() == 0) {// TODO : use unwrap if no use of UnexecutableCommand.INSTANCE
			return null;
		}
		return compoundCommand;
	}


	/**
	 * Checks recursively if a profile is applied .
	 *
	 * @param element
	 *        the element
	 * @param profile
	 *        the profile
	 * @return true, if is profile applied recursive
	 */
	private boolean isProfileAppliedRecursive(Element element, Profile profile) {
		if(element instanceof Package) {
			Package pkg = (Package)element;
			boolean profileApplied = pkg.isProfileApplied(profile);

			if(pkg instanceof Model) {
				return profileApplied;
			}

			if(!profileApplied) {
				return isProfileAppliedRecursive(element.getOwner(), profile);
			} else {
				return true;
			}
		}
		return isProfileAppliedRecursive(element.getOwner(), profile);
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.IPasteStrategy#dependsOn()
	 */
	@Override
	public IPasteStrategy dependsOn() {
		return DefaultPasteStrategy.getInstance();
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.strategy.paste.IPasteStrategy#prepare(org.eclipse.papyrus.infra.core.clipboard.PapyrusClipboard)
	 */
	@Override
	public void prepare(PapyrusClipboard<Object> papyrusClipboard) {
		Map<Object, IClipboardAdditionalData> mapCopyToStereotypeData = new HashMap<Object, IClipboardAdditionalData>();
		for(Iterator<EObject> iterator = papyrusClipboard.iterateOnSource(); iterator.hasNext();) {
			EObject eObjectSource = (EObject)iterator.next();
			if(eObjectSource instanceof Element) {
				Element element = (Element)eObjectSource;
				EList<EObject> stereotypeApplications = element.getStereotypeApplications();
				if(stereotypeApplications != null && !stereotypeApplications.isEmpty()) {
					List<Stereotype> stereotypeList = new ArrayList<Stereotype>();
					for(EObject stereotypeApplication : stereotypeApplications) {
						Stereotype stereotype = UMLUtil.getStereotype(stereotypeApplication);
						stereotypeList.add(stereotype);
					}
					StereotypeClipboard stereotypeClipboard = new StereotypeClipboard(stereotypeList);
					Object copy = papyrusClipboard.getCopyFromSource(eObjectSource);
					mapCopyToStereotypeData.put(copy, stereotypeClipboard);
				}
			}
		}
		papyrusClipboard.pushAdditionalData(getID(), mapCopyToStereotypeData);
	}


	//	protected ICommand getOpenDialogCommand(final TransactionalEditingDomain domain, final Collection<EditPart> selectedEditPart, final Map<EditPart, Set<EObject>> availableLinks, final Collection<EObject> initialSelection, final Map<EObject, LinkEndsMapper> linkMapping) {
	//		final ICommand cmd = new AbstractTransactionalCommand(domain, "Open Show/HideDialogCommand", null) {//$NON-NLS-1$
	//
	//			@Override
	//			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
	//				final ShowHideRelatedLinkSelectionDialog dialog = new ShowHideRelatedLinkSelectionDialog(Display.getDefault().getActiveShell(), new UMLLabelProvider(), new AbstractShowHideRelatedLinkEditPolicy.LinkContentProvider(availableLinks), availableLinks, linkMapping);
	//				dialog.setTitle("Show/Hide Links");//$NON-NLS-1$
	//				dialog.setMessage("Choose the links to show.");//$NON-NLS-1$
	//				dialog.setInput(selectedEditPart);
	//				dialog.setInitialSelection(initialSelection);
	//				dialog.setExpandedElements(selectedEditPart.toArray());
	//				dialog.setContainerMode(true);
	//				int status = dialog.open();
	//				if(status == Window.CANCEL) {
	//					return CommandResult.newCancelledCommandResult();
	//				}
	//				return CommandResult.newOKCommandResult(Arrays.asList(dialog.getResult()));
	//			}
	//		};
	//
	//		return cmd;
	//	}



	// TODO : remove no internal class
	/**
	 * The Class StereotypeClipboard.
	 */
	private class StereotypeClipboard implements IClipboardAdditionalData {

		/** The stereotype. */
		private Collection<Stereotype> stereotypes;

		/**
		 * @param stereotypes
		 */
		public StereotypeClipboard(Collection<Stereotype> stereotypes) {
			this.stereotypes = stereotypes;
		}

		/**
		 * @return
		 */
		public Collection<Stereotype> getStereotypes() {
			return stereotypes;
		}

	}





}
