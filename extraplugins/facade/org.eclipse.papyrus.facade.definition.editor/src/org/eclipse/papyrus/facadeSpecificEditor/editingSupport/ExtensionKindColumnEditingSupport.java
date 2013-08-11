package org.eclipse.papyrus.facadeSpecificEditor.editingSupport;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.papyrus.facade.Facade;
import org.eclipse.papyrus.facade.extensiondefinition.ExtensionDefinition;
import org.eclipse.papyrus.facade.extensiondefinition.ExtensionDefinitionKind;
import org.eclipse.papyrus.facade.extensiondefinition.ExtensiondefinitionPackage;
import org.eclipse.papyrus.facadeSpecificEditor.utils.ProfileUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;

public class ExtensionKindColumnEditingSupport extends EditingSupport {

	protected AdapterFactoryEditingDomain editingDomain;

	protected Composite parent;

	public ExtensionKindColumnEditingSupport(ColumnViewer viewer, AdapterFactoryEditingDomain editingDomain, Composite parent) {
		super(viewer);
		this.editingDomain = editingDomain;
		this.parent = parent;
	}

	protected void transformIntoAssociation(ExtensionDefinition element) {
		SetCommand command = new SetCommand(editingDomain, element, ExtensiondefinitionPackage.eINSTANCE.getExtensionDefinition_Kind(), ExtensionDefinitionKind.ASSOCIATION); //$NON-NLS-1$
		editingDomain.getCommandStack().execute(command);

	}

	protected void transformIntoGeneralization(ExtensionDefinition element) {

		SetCommand command = new SetCommand(editingDomain, element, ExtensiondefinitionPackage.eINSTANCE.getExtensionDefinition_Kind(), ExtensionDefinitionKind.GENERALIZATION); //$NON-NLS-1$
		editingDomain.getCommandStack().execute(command);

	}

	protected void transformIntoMultiGeneralization(ExtensionDefinition element) {

		SetCommand command = new SetCommand(editingDomain, element, ExtensiondefinitionPackage.eINSTANCE.getExtensionDefinition_Kind(), ExtensionDefinitionKind.MULTI_GENERALIZATION); //$NON-NLS-1$
		editingDomain.getCommandStack().execute(command);

	}

	protected void transformIntoFusion(ExtensionDefinition element) {

		SetCommand command = new SetCommand(editingDomain, element, ExtensiondefinitionPackage.eINSTANCE.getExtensionDefinition_Kind(), ExtensionDefinitionKind.FUSION); //$NON-NLS-1$
		editingDomain.getCommandStack().execute(command);

	}

	protected boolean stereotypeUsedElsewhere(ExtensionDefinition extensionDefinition) {
		EList<ExtensionDefinition> allExtensionDefintion = extensionDefinition.getFacade().getExtensionDefinitions();

		for(ExtensionDefinition otherExtensionDefinition : allExtensionDefintion) {
			if(otherExtensionDefinition != extensionDefinition) {
				for(Property property : otherExtensionDefinition.getStereotype().getAttributes()) {
					if(property.getType() == extensionDefinition.getStereotype()) {
						return true;
					}
				}
			}
		}

		return false;
	}

	protected boolean hasOtherExtension(ExtensionDefinition extensionDefinition) {
		EList<ExtensionDefinition> allExtensionDefintion = extensionDefinition.getFacade().getExtensionDefinitions();

		for(ExtensionDefinition otherExtensionDefinition : allExtensionDefintion) {
			if(otherExtensionDefinition != extensionDefinition) {
				if(extensionDefinition.getStereotype() == otherExtensionDefinition.getStereotype()) {
					return true;
				}
			}
		}

		return false;
	}

	@Override
	protected void setValue(final Object element, final Object value) {
		final ExtensionDefinitionKind newValue = ExtensionDefinitionKind.get((Integer)value);


		if(element instanceof ExtensionDefinition) {

			ProgressMonitorDialog dialog = new ProgressMonitorDialog(Display.getCurrent().getActiveShell());
			try {
				dialog.run(false, false, new IRunnableWithProgress() {

					public void run(IProgressMonitor monitor) {
						monitor.beginTask("Updating stereotypes definitions", IProgressMonitor.UNKNOWN);

						Facade facade = ((ExtensionDefinition)element).getFacade();

						if(newValue == ExtensionDefinitionKind.ASSOCIATION) {

							transformIntoAssociation((ExtensionDefinition)element);

							// All children and generals must be set to Association as well
							HashSet<Stereotype> siblings = ProfileUtils.getSiblings(((ExtensionDefinition)element).getStereotype());

							for(ExtensionDefinition extensionDefinition : facade.getExtensionDefinitions()) {

								if(extensionDefinition.getExtension() == ((ExtensionDefinition)element).getExtension()) {
									if(siblings.contains(extensionDefinition.getStereotype())) {

										transformIntoAssociation(extensionDefinition);
									}
								}
							}

							// // Clear incompatibilities
							// EditionUtils.clearStereotypeCombinations(facade, editingDomain);

						} else if(newValue == ExtensionDefinitionKind.GENERALIZATION) {

							if(((ExtensionDefinition)element).getExtension().getMetaclass().isAbstract()) {

								MessageDialog.openInformation(Display.getCurrent().getActiveShell(), "Warning", "The extension extends an abstract class. The extension cannot be a generalization.");

							} else {
								if(((ExtensionDefinition)element).getExtension().isRequired()) {
									MessageDialog.openInformation(Display.getCurrent().getActiveShell(), "Warning", "The extension is required. The extension cannot be a generalization.");
								} else {

									transformIntoGeneralization((ExtensionDefinition)element);
									// All children and generals must be set to generalization as well
									HashSet<Stereotype> siblings = ProfileUtils.getSiblings(((ExtensionDefinition)element).getStereotype());

									for(ExtensionDefinition extensionDefinition : facade.getExtensionDefinitions()) {
										if(extensionDefinition.getExtension() == ((ExtensionDefinition)element).getExtension()) {
											if(siblings.contains(extensionDefinition.getStereotype())) {
												transformIntoGeneralization(extensionDefinition);
											}
										}
									}
								}
							}



							// // Init incompatibilities
							// EditionUtils.initStereotypeCombinations(facade, editingDomain);

						} else if(newValue == ExtensionDefinitionKind.MULTI_GENERALIZATION) {

							if(hasOtherExtension((ExtensionDefinition)element) && stereotypeUsedElsewhere((ExtensionDefinition)element)) {
								MessageDialog.openInformation(Display.getCurrent().getActiveShell(), "Warning", "Cannot change the extension kind to MultiGeneralization because stereotype is used to  type a property elsewhere. ");
							} else {
								transformIntoMultiGeneralization((ExtensionDefinition)element);
								// All children and generals must be set to generalization as well
								HashSet<Stereotype> siblings = ProfileUtils.getSiblings(((ExtensionDefinition)element).getStereotype());

								for(ExtensionDefinition extensionDefinition : facade.getExtensionDefinitions()) {
									if(extensionDefinition.getExtension() == ((ExtensionDefinition)element).getExtension()) {
										if(siblings.contains(extensionDefinition.getStereotype())) {
											transformIntoMultiGeneralization(extensionDefinition);
										}
									}
								}
							}

						} else if(newValue == ExtensionDefinitionKind.FUSION) {
							if(hasOtherExtension((ExtensionDefinition)element) && stereotypeUsedElsewhere((ExtensionDefinition)element)) {
								MessageDialog.openInformation(Display.getCurrent().getActiveShell(), "Warning", "Cannot change the extension kind to Fusion because stereotype is used to  type a property elsewhere. ");
							} else {
								transformIntoFusion((ExtensionDefinition)element);

								// All children and generals must be set to generalization as well
								HashSet<Stereotype> siblings = ProfileUtils.getSiblings(((ExtensionDefinition)element).getStereotype());

								for(ExtensionDefinition extensionDefinition : facade.getExtensionDefinitions()) {
									if(extensionDefinition.getExtension() == ((ExtensionDefinition)element).getExtension()) {
										if(siblings.contains(extensionDefinition.getStereotype())) {
											transformIntoFusion(extensionDefinition);
										}
									}
								}
							}
						}

						// Clear incompatibilities that don't exist anymore
						EditionUtils.clearAllStereotypeCombinations(facade, editingDomain);
						// Init new incompatibilities
						EditionUtils.initAllStereotypeCombinations(facade, editingDomain);
						// Update isPossible
						EditionUtils.initIsPossible(facade, editingDomain);

						monitor.done();

					}

				});
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			getViewer().refresh();
		}
	}

	@Override
	protected Object getValue(Object element) {
		//		System.err.println("LA : " + element);
		if(element instanceof ExtensionDefinition) {
			int value = ((ExtensionDefinition)element).getKind().getValue();
			return value;

		}
		return null;
	}

	@Override
	protected CellEditor getCellEditor(Object element) {

		if(element instanceof ExtensionDefinition) {


			//			String[] itemsArray = { ExtensionDefinitionKind.ASSOCIATION.getName(), ExtensionDefinitionKind.GENERALIZATION.getName(), ExtensionDefinitionKind.MULTI_GENERALIZATION.getName(), ExtensionDefinitionKind.FUSION.getName() };
			String[] itemsArray = { ExtensionDefinitionKind.ASSOCIATION.getName(), ExtensionDefinitionKind.GENERALIZATION.getName(), ExtensionDefinitionKind.MULTI_GENERALIZATION.getName() };


			ComboBoxCellEditor combo = new ComboBoxCellEditor(parent, itemsArray, SWT.READ_ONLY);


			return combo;
		}

		return null;
	}

	@Override
	protected boolean canEdit(Object element) {
		return true;
	}

}
