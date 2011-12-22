/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.runtime.controller.descriptor;

import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.papyrus.views.properties.runtime.Activator;
import org.eclipse.papyrus.views.properties.runtime.controller.PropertyEditorController;
import org.eclipse.papyrus.views.properties.runtime.controller.PropertyEditorControllerService;
import org.eclipse.papyrus.views.properties.runtime.modelhandler.emf.IEMFModelHandler;
import org.eclipse.papyrus.views.properties.runtime.modelhandler.emf.IEMFModelHandlerState;
import org.eclipse.papyrus.views.properties.runtime.propertyeditor.descriptor.IPropertyEditorDescriptor;
import org.eclipse.papyrus.views.properties.runtime.state.IState;
import org.eclipse.papyrus.views.properties.runtime.state.ITraversableModelElement;
import org.eclipse.papyrus.views.properties.runtime.view.constraints.IConstraintDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * Basic configuration for property editor controllers
 */
public class EMFTPropertyEditorControllerDescriptor implements IPropertyEditorControllerDescriptor {

	/** handler used by this controller */
	protected final IEMFModelHandler handler;

	/** boolean that indicates if the controller accepts multi selection */
	protected final boolean multiSelection;

	/** controller unique identifier */
	protected final String controllerID;

	/** name of the feature to edit */
	protected final String featureNameToEdit;

	/** editor descriptor */
	protected final IPropertyEditorDescriptor editorDescriptor;

	/** list of constraints for this descriptors */
	private final List<IConstraintDescriptor> constraints;

	/**
	 * {@inheritDoc}
	 */
	public boolean acceptMultiSelection() {
		return multiSelection;
	}

	/**
	 * Returns the name of the feature to edit
	 * 
	 * @return the name of the feature to edit
	 */
	public String getFeatureNameToEdit() {
		return featureNameToEdit;
	}

	/**
	 * Returns the handler id for the controller
	 * 
	 * @return the handler id for the controller
	 */
	public IEMFModelHandler getHandler() {
		return handler;
	}

	/**
	 * Creates a new PropertyEditorDescriptor.
	 * 
	 * @param controllerID
	 *        id of the controller described by this element
	 * @param multiSelection
	 *        boolean that indicates if the controller described accepts multi-selection
	 * @param featureNameToEdit
	 *        the name of feature to edit for the controller configured by this descriptor
	 * @param handler
	 *        the handler id for the controller
	 * @param editorDescriptor
	 *        descriptor of the editor managed by this controller
	 * @param constraints
	 *        list of constraints applying on this descriptor
	 */
	public EMFTPropertyEditorControllerDescriptor(String controllerID, boolean multiSelection, String featureNameToEdit, IEMFModelHandler handler, IPropertyEditorDescriptor editorDescriptor, List<IConstraintDescriptor> constraints) {
		this.controllerID = controllerID;
		this.multiSelection = multiSelection;
		this.featureNameToEdit = featureNameToEdit;
		this.handler = handler;
		this.editorDescriptor = editorDescriptor;
		this.constraints = constraints;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getControllerID() {
		return controllerID;
	}

	/**
	 * {@inheritDoc}
	 */
	public IPropertyEditorDescriptor getEditorDescriptor() {
		return editorDescriptor;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<IConstraintDescriptor> getConstraintDescriptors() {
		return constraints;
	}

	/**
	 * {@inheritDoc}
	 */
	public Image getImage() {
		return Activator.getImage("/icons/EMFTController.gif"); //$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 */
	public String getText() {
		return "Property editor for: " + getFeatureNameToEdit();
	}

	/**
	 * {@inheritDoc}
	 */
	public ControllerDescriptorState createState(boolean readOnly) {
		return new EMFTPropertyEditorControllerDescriptorState(this, readOnly);
	}

	/**
	 * state for {@link EMFTPropertyEditorControllerDescriptor}
	 */
	public class EMFTPropertyEditorControllerDescriptorState extends ControllerDescriptorState {

		/** change support for this bean */
		private PropertyChangeSupport changeSupport;

		/** state for the feature name */
		private String featureNameState;

		/** model handler state */
		private IEMFModelHandlerState modelHandlerState;

		/** multi selection state */
		private boolean multiSelectionState;

		/** state of the editor */
		private IState editorState;

		/**
		 * Creates a new EMFTPropertyEditorControllerDescriptorState.
		 * 
		 * @param descriptor
		 *        descriptor to manage
		 * @param readOnly
		 *        the read only mode of this state
		 */
		public EMFTPropertyEditorControllerDescriptorState(EMFTPropertyEditorControllerDescriptor descriptor, boolean readOnly) {
			super(descriptor, readOnly);
			featureNameState = descriptor.getFeatureNameToEdit();
			multiSelectionState = descriptor.acceptMultiSelection();
			modelHandlerState = descriptor.getHandler().createState(true); // read only element
			editorState = descriptor.getEditorDescriptor().createState(readOnly);
			// register change support
			changeSupport = new PropertyChangeSupport(this);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public EMFTPropertyEditorControllerDescriptor getDescriptor() {
			return (EMFTPropertyEditorControllerDescriptor)super.getDescriptor();
		}


		/**
		 * Returns the changeSupport for this state
		 * 
		 * @return the changeSupport for this state
		 */
		public PropertyChangeSupport getChangeSupport() {
			return changeSupport;
		}

		/**
		 * Sets the changeSupport for this state
		 * 
		 * @param changeSupport
		 *        the changeSupport to set
		 */
		public void setChangeSupport(PropertyChangeSupport changeSupport) {
			this.changeSupport = changeSupport;
		}

		/**
		 * Returns the featureNameState for this state
		 * 
		 * @return the featureNameState for this state
		 */
		public String getFeatureNameState() {
			return featureNameState;
		}

		/**
		 * Sets the featureNameState for this state
		 * 
		 * @param featureNameState
		 *        the featureNameState to set
		 */
		public void setFeatureNameState(String featureNameState) {
			String oldName = this.featureNameState;
			this.featureNameState = featureNameState;

			changeSupport.firePropertyChange("featureNameState", oldName, this.featureNameState);
		}

		/**
		 * Returns the modelHandler for this state
		 * 
		 * @return the modelHandler for this state
		 */
		public IEMFModelHandlerState getModelHandlerState() {
			return modelHandlerState;
		}

		/**
		 * Sets the modelHandler for this state
		 * 
		 * @param modelHandlerState
		 *        the modelHandler to set
		 */
		public void setModelHandler(IEMFModelHandlerState modelHandlerState) {
			IEMFModelHandlerState oldHandlerState = this.modelHandlerState;
			this.modelHandlerState = modelHandlerState;

			changeSupport.firePropertyChange("modelHandler", oldHandlerState, this.modelHandlerState);
		}

		/**
		 * Returns the multiSelection for this state
		 * 
		 * @return the multiSelection for this state
		 */
		public boolean isMultiSelection() {
			return multiSelection;
		}

		/**
		 * Sets the multiSelection for this state
		 * 
		 * @param multiSelectionState
		 *        the multiSelection to set
		 */
		public void setMultiSelection(boolean multiSelectionState) {
			boolean oldSelection = this.multiSelectionState;
			this.multiSelectionState = multiSelectionState;
			changeSupport.firePropertyChange("multiSelection", oldSelection, this.multiSelectionState);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public List<? extends ITraversableModelElement> getChildren() {
			List<ITraversableModelElement> children = new ArrayList<ITraversableModelElement>(1);
			children.add(modelHandlerState);
			return children;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Node generateNode(Document document) {
			Element node = document.createElement("controller");
			node.setAttribute("id", getId());

			//			<controller id="emftStructuralFeatureController">
			//			<feature name="qualifiedName" handlerID="String"/>
			//			<editor id="org.eclipse.papyrus.views.properties.runtime.textPropertyEditor" label="Qualified Name:" labelPosition="16384">
			//				<icon pluginID="org.eclipse.papyrus.views.properties.tabbed.uml" path="/icons/tool.gif"/>
			//			</editor>
			//			</controller>

			node.appendChild(modelHandlerState.generateNode(document));

			generateEditorNode(node, document);
			return node;
		}

		/**
		 * Generates the editor node for the controller
		 * 
		 * @param node
		 *        the parent node for generated nodes
		 * @param document
		 *        the document used to create elements
		 */
		protected void generateEditorNode(Element node, Document document) {
			Node editorNode = editorState.generateNode(document);
			node.appendChild(editorNode);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void createPreview(org.eclipse.swt.widgets.Composite composite) {
			PropertyEditorController controller = PropertyEditorControllerService.getInstance().createPropertyEditorController(Collections.emptyList(), composite, descriptor);

			if(controller != null) {
				// use the state to create this
				controller.createPropertyEditor(this.getDescriptor().getEditorDescriptor(), new TabbedPropertySheetWidgetFactory());
			}
		}
	}

}
