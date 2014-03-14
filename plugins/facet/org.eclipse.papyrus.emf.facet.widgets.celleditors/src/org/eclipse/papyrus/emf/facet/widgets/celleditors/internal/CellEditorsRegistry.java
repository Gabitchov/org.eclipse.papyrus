/*******************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Nicolas Bros (Mia-Software) - initial API and implementation
 *    Nicolas Bros (Mia-Software) - Bug 338437 - compositeEditors extension point cannot be used to register user types
 *    Nicolas Guyomar (Mia-Software) - Bug 339554 - org.eclipse.papyrus.emf.facet.widgets.celleditors API cleaning
 *    Nicolas Bros (Mia-Software) - Bug 339855 - ModelCellEditor class should not be exposed
 *    Gregoire Dupe (Mia-Software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.widgets.celleditors.internal;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.emf.facet.util.core.Logger;
import org.eclipse.papyrus.emf.facet.util.core.internal.exported.AbstractRegistry;
import org.eclipse.papyrus.emf.facet.widgets.celleditors.ICellEditorsRegistry;
import org.eclipse.papyrus.emf.facet.widgets.celleditors.IModelCellEditor;
import org.eclipse.papyrus.emf.facet.widgets.celleditors.IModelCellEditorContainer;
import org.eclipse.papyrus.emf.facet.widgets.celleditors.INaryFeatureCellEditor;
import org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.AbstractModelCellEditor;
import org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.BasicCellEditor;
import org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.ModelCellEditorDeclarations;
import org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.NaryFeatureCellEditor;
import org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.UnaryReferenceCellEditor;

/** Registry for the "loadingDepth" extension point */
public class CellEditorsRegistry extends AbstractRegistry implements ICellEditorsRegistry {

	private static final String EXTENSION_POINT_NAMESPACE = "org.eclipse.papyrus.emf.facet.widgets.celleditors"; //$NON-NLS-1$
	private static final String EXTENSION_POINT_NAME = "celleditors"; //$NON-NLS-1$

	private static final String CELL_EDITORS_MODEL_ELEMENT = "cellEditorsModel"; //$NON-NLS-1$
	private static final String PATH_ATTRIBUTE = "path"; //$NON-NLS-1$

	/** A list of basic cell editors */
	private final List<ModelCellEditorContainer<BasicCellEditor>> basicCellEditors = new ArrayList<ModelCellEditorContainer<BasicCellEditor>>();
	/** A list of unary reference cell editors */
	private final List<ModelCellEditorContainer<UnaryReferenceCellEditor>> unaryReferenceCellEditors = new ArrayList<ModelCellEditorContainer<UnaryReferenceCellEditor>>();
	/** A list of n-ary reference cell editors */
	private final List<ModelCellEditorContainer<NaryFeatureCellEditor>> naryFeatureCellEditors = new ArrayList<ModelCellEditorContainer<NaryFeatureCellEditor>>();

	public CellEditorsRegistry() {
		initialize();
	}

	public List<IModelCellEditorContainer<? extends AbstractModelCellEditor>> getAllCellEditors() {
		List<IModelCellEditorContainer<? extends AbstractModelCellEditor>> allCellEditors = new ArrayList<IModelCellEditorContainer<? extends AbstractModelCellEditor>>();
		for (ModelCellEditorContainer<BasicCellEditor> basicCellEditor : this.basicCellEditors) {
			allCellEditors.add(basicCellEditor);
		}
		for (ModelCellEditorContainer<UnaryReferenceCellEditor> unaryReferenceCellEditor : this.unaryReferenceCellEditors) {
			allCellEditors.add(unaryReferenceCellEditor);
		}
		for (ModelCellEditorContainer<NaryFeatureCellEditor> naryReferenceCellEditor : this.naryFeatureCellEditors) {
			allCellEditors.add(naryReferenceCellEditor);
		}
		return allCellEditors;
	}

	/**
	 * Returns a cell editor wrapper for the given type, or <code>null</code> if none was found.
	 * Custom cell editors override the default ones (from
	 * "org.eclipse.papyrus.emf.facet.widgets.celleditors").
	 * 
	 * @param type
	 *            the type for which to get a cell editor wrapper
	 * @param many
	 *            whether to get a cell editor to edit a single value or a list of values
	 * @return the cell editor wrapper or <code>null</code> if none was found for the given type
	 */
	public ModelCellEditor getCellEditorWrapperFor(final EClassifier type, final boolean many) {
		return getCellEditorWrapperFor(type, many, null);
	}

	/**
	 * Returns a cell editor to edit a single value of the given type, or <code>null</code> if none
	 * was found. Custom cell editors override the default ones (from
	 * "org.eclipse.papyrus.emf.facet.widgets.celleditors").
	 * 
	 * @param type
	 *            the type for which to get a cell editor
	 * @return the cell editor or <code>null</code> if none was found for the given type
	 */
	public IModelCellEditor getCellEditorFor(final EClassifier type) {
		ModelCellEditor cellEditorWrapper = getCellEditorWrapperFor(type, false);
		if (cellEditorWrapper != null) {
			return (IModelCellEditor) cellEditorWrapper.getCellEditorImplementation();
		}
		return null;
	}

	/**
	 * Returns a cell editor wrapper to edit a list of values of the given type, or
	 * <code>null</code> if none was found. Custom cell editors override the default ones (from
	 * "org.eclipse.papyrus.emf.facet.widgets.celleditors").
	 * 
	 * @param type
	 *            the type for which to get a cell editor
	 * @return the cell editor wrapper or <code>null</code> if none was found for the given type
	 */
	public INaryFeatureCellEditor getNaryCellEditorFor(final EClassifier type) {
		ModelCellEditor cellEditorWrapper = getCellEditorWrapperFor(type, true);
		if (cellEditorWrapper != null) {
			return (INaryFeatureCellEditor) cellEditorWrapper.getCellEditorImplementation();
		}
		return null;
	}

	public IModelCellEditor getCellEditorFor(final EClassifier type,
			final List<AbstractModelCellEditor> preferredCellEditors) {
		ModelCellEditor cellEditorWrapper = getCellEditorWrapperFor(type, false,
				preferredCellEditors);
		if (cellEditorWrapper != null) {
			return (IModelCellEditor) cellEditorWrapper.getCellEditorImplementation();
		}
		return null;
	}

	public INaryFeatureCellEditor getNaryCellEditorFor(final EClassifier type,
			final List<AbstractModelCellEditor> preferredCellEditors) {
		ModelCellEditor cellEditorWrapper = getCellEditorWrapperFor(type, true,
				preferredCellEditors);
		if (cellEditorWrapper != null) {
			return (INaryFeatureCellEditor) cellEditorWrapper.getCellEditorImplementation();
		}
		return null;
	}

	/**
	 * Returns a cell editor for the given type, or <code>null</code> if none was found. Custom cell
	 * editors override the default ones (from "org.eclipse.papyrus.emf.facet.widgets.celleditors").
	 * 
	 * @param type
	 *            the type for which to get a cell editor
	 * @param many
	 *            whether to get a cell editor to edit a single value or a list of values
	 * @param preferredCellEditors
	 *            the cell editors that should be chosen in case of conflicts (several cell editors
	 *            defined for the same type)
	 * @return the cell editor or <code>null</code> if none was found for the given type
	 */
	public ModelCellEditor getCellEditorWrapperFor(final EClassifier type, final boolean many,
			final List<AbstractModelCellEditor> preferredCellEditors) {

		List<IModelCellEditorContainer<? extends AbstractModelCellEditor>> allCellEditorContainers = getAllCellEditors();

		List<ModelCellEditor> cellEditors = new ArrayList<ModelCellEditor>();

		for (IModelCellEditorContainer<? extends AbstractModelCellEditor> modelCellEditorContainer : allCellEditorContainers) {
			AbstractModelCellEditor modelCellEditor = modelCellEditorContainer.getModelCellEditor();
			if (isCellEditorForType(modelCellEditor, type, many)) {
				cellEditors.add(new ModelCellEditor(modelCellEditorContainer.getBundleName(),
						modelCellEditorContainer.getModelCellEditor()));
			}
		}

		ModelCellEditor selectedCellEditor = null;

		if (preferredCellEditors != null) {
			for (AbstractModelCellEditor preferredCellEditor : preferredCellEditors) {
				if (isCellEditorForType(preferredCellEditor, type, many)) {
					if (selectedCellEditor != null) {
						throw new IllegalArgumentException(
								"Several preferred cell editors are defined for type: " //$NON-NLS-1$
										+ EcoreUtil.getURI(type));
					}
					selectedCellEditor = new ModelCellEditor("", preferredCellEditor); //$NON-NLS-1$
				}
			}
		}

		if (selectedCellEditor == null) {
			if (cellEditors.size() == 1) {
				selectedCellEditor = cellEditors.get(0);
			} else if (cellEditors.size() > 1) {
				boolean skippedDefault = false;
				for (ModelCellEditor cellEditor : cellEditors) {
					// lower priority for
					// org.eclipse.papyrus.emf.facet.widgets.celleditors.*
					if (cellEditor.getBundleName().startsWith(
							"org.eclipse.papyrus.emf.facet.widgets.celleditors")) { //$NON-NLS-1$
						if (skippedDefault) {
							Logger.logError(
									"Several default cell editors are defined in EMF Facet for type: " //$NON-NLS-1$
											+ EcoreUtil.getURI(type), Activator.getDefault());
							selectedCellEditor = cellEditor;
							break;
						}
						skippedDefault = true;
						continue;
					}
					if (selectedCellEditor != null) {
						Logger.logWarning("Several cell editors are defined for type: " //$NON-NLS-1$
								+ EcoreUtil.getURI(type), Activator.getDefault());
						break;
					}
					selectedCellEditor = cellEditor;
				}
			}
		}

		return selectedCellEditor;
	}

	public static boolean isCellEditorForType(final AbstractModelCellEditor modelCellEditor,
			final EClassifier type, final boolean many) {
		if (many != (modelCellEditor instanceof NaryFeatureCellEditor)) {
			return false;
		}
		return isSuperType(modelCellEditor.getCellType(), type);
	}

	private static boolean isSuperType(final EClassifier superType, final EClassifier subType) {
		if (superType == subType) {
			return true;
		}

		if (superType instanceof EClass && subType instanceof EClass) {
			// special case because isSuperTypeOf doesn't handle it
			if (superType == EcorePackage.eINSTANCE.getEObject()) {
				return true;
			}

			EClass superTypeEClass = (EClass) superType;
			EClass subTypeEClass = (EClass) subType;
			return superTypeEClass.isSuperTypeOf(subTypeEClass);
		}

		if (superType == EcorePackage.eINSTANCE.getEDataType() && subType instanceof EDataType) {
			// cf Bug 331539 - cell editor registered for type "EDataType"
			return true;
		}

		return false;
	}

	public List<ModelCellEditorContainer<BasicCellEditor>> getBasicCellEditors() {
		return this.basicCellEditors;
	}

	public List<ModelCellEditorContainer<UnaryReferenceCellEditor>> getUnaryReferenceCellEditors() {
		return this.unaryReferenceCellEditors;
	}

	public List<ModelCellEditorContainer<NaryFeatureCellEditor>> getNaryFeatureCellEditors() {
		return this.naryFeatureCellEditors;
	}

	@Override
	protected String getExtensionPointName() {
		return CellEditorsRegistry.EXTENSION_POINT_NAME;
	}

	@Override
	protected String getExtensionPointNamespace() {
		return CellEditorsRegistry.EXTENSION_POINT_NAMESPACE;
	}

	@Override
	protected void handleRootElement(final IConfigurationElement configurationElement) {
		final String name = configurationElement.getName();
		if (name.equalsIgnoreCase(CellEditorsRegistry.CELL_EDITORS_MODEL_ELEMENT)) {
			readModelElement(configurationElement);
		} else {
			logUnknownElement(configurationElement);
		}
	}

	/** Read a 'cellEditorsModel' element */
	private void readModelElement(final IConfigurationElement configurationElement) {
		final String path = configurationElement.getAttribute(CellEditorsRegistry.PATH_ATTRIBUTE);
		String bundleName = configurationElement.getContributor().getName();
		URI uri = URI.createURI("platform:/plugin/" //$NON-NLS-1$
				+ configurationElement.getContributor().getName() + "/" + path); //$NON-NLS-1$
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.getResource(uri, true);
		if (resource != null) {
			EList<EObject> contents = resource.getContents();
			if (contents.size() == 1) {
				EObject eObject = contents.get(0);
				if (eObject instanceof ModelCellEditorDeclarations) {
					ModelCellEditorDeclarations modelCellEditors = (ModelCellEditorDeclarations) eObject;
					EList<AbstractModelCellEditor> allCellEditors = modelCellEditors
							.getModelCellEditors();
					for (AbstractModelCellEditor modelCellEditor : allCellEditors) {
						if (modelCellEditor instanceof BasicCellEditor) {
							BasicCellEditor basicCellEditor = (BasicCellEditor) modelCellEditor;
							ModelCellEditorContainer<BasicCellEditor> modelCellEditorContainer = new ModelCellEditorContainer<BasicCellEditor>();
							modelCellEditorContainer.setBundleName(bundleName);
							modelCellEditorContainer.setModelCellEditor(basicCellEditor);
							this.basicCellEditors.add(modelCellEditorContainer);
						} else if (modelCellEditor instanceof UnaryReferenceCellEditor) {
							UnaryReferenceCellEditor unaryReferenceCellEditor = (UnaryReferenceCellEditor) modelCellEditor;
							ModelCellEditorContainer<UnaryReferenceCellEditor> modelCellEditorContainer = new ModelCellEditorContainer<UnaryReferenceCellEditor>();
							modelCellEditorContainer.setBundleName(bundleName);
							modelCellEditorContainer.setModelCellEditor(unaryReferenceCellEditor);
							this.unaryReferenceCellEditors.add(modelCellEditorContainer);
						} else if (modelCellEditor instanceof NaryFeatureCellEditor) {
							NaryFeatureCellEditor naryFeatureCellEditor = (NaryFeatureCellEditor) modelCellEditor;
							ModelCellEditorContainer<NaryFeatureCellEditor> modelCellEditorContainer = new ModelCellEditorContainer<NaryFeatureCellEditor>();
							modelCellEditorContainer.setBundleName(bundleName);
							modelCellEditorContainer.setModelCellEditor(naryFeatureCellEditor);
							this.naryFeatureCellEditors.add(modelCellEditorContainer);
						} else {
							Logger.logError("Not handled: " //$NON-NLS-1$
									+ modelCellEditor.getClass().getSimpleName(),
									Activator.getDefault());
						}
					}
				} else {
					Logger.logError("Root element must be of type " //$NON-NLS-1$
							+ ModelCellEditorDeclarations.class.getSimpleName() + ": " + uri, //$NON-NLS-1$
							Activator.getDefault());
				}
			} else {
				Logger.logError("Resource should have one and only one root: " + uri, //$NON-NLS-1$
						Activator.getDefault());
			}
		} else {
			Logger.logError("Error reading resource: " + uri, Activator.getDefault()); //$NON-NLS-1$
		}
	}
}