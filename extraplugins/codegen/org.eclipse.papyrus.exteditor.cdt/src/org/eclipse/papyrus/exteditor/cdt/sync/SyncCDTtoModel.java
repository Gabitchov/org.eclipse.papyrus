/*******************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Ansgar Radermacher - ansgar.radermacher@cea.fr CEA LIST - initial API and implementation
 *
 *******************************************************************************/

package org.eclipse.papyrus.exteditor.cdt.sync;

import org.eclipse.cdt.core.CCorePlugin;
import org.eclipse.cdt.core.dom.ast.ExpansionOverlapsBoundaryException;
import org.eclipse.cdt.core.dom.ast.IASTCompoundStatement;
import org.eclipse.cdt.core.dom.ast.IASTDeclSpecifier;
import org.eclipse.cdt.core.dom.ast.IASTFileLocation;
import org.eclipse.cdt.core.dom.ast.IASTFunctionDeclarator;
import org.eclipse.cdt.core.dom.ast.IASTFunctionDefinition;
import org.eclipse.cdt.core.dom.ast.IASTName;
import org.eclipse.cdt.core.dom.ast.IASTNode;
import org.eclipse.cdt.core.dom.ast.IASTNodeSelector;
import org.eclipse.cdt.core.dom.ast.IASTParameterDeclaration;
import org.eclipse.cdt.core.dom.ast.IASTStatement;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;
import org.eclipse.cdt.core.index.IIndex;
import org.eclipse.cdt.core.model.CModelException;
import org.eclipse.cdt.core.model.CoreModel;
import org.eclipse.cdt.core.model.ICElement;
import org.eclipse.cdt.core.model.ICProject;
import org.eclipse.cdt.core.model.IFunctionDeclaration;
import org.eclipse.cdt.core.model.IMethodDeclaration;
import org.eclipse.cdt.core.model.IParent;
import org.eclipse.cdt.core.model.ISourceRange;
import org.eclipse.cdt.core.model.ISourceReference;
import org.eclipse.cdt.core.model.ITranslationUnit;
import org.eclipse.cdt.core.model.IWorkingCopy;
import org.eclipse.cdt.core.parser.IToken;
import org.eclipse.cdt.ui.CDTUITools;
import org.eclipse.cdt.ui.CUIPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.C_Cpp.Array;
import org.eclipse.papyrus.C_Cpp.Const;
import org.eclipse.papyrus.C_Cpp.Include;
import org.eclipse.papyrus.C_Cpp.Ptr;
import org.eclipse.papyrus.C_Cpp.Ref;
import org.eclipse.papyrus.cpp.codegen.Constants;
import org.eclipse.papyrus.cpp.profile.StUtils;
import org.eclipse.papyrus.exteditor.cdt.CommandSupport;
import org.eclipse.papyrus.exteditor.cdt.Utils;
import org.eclipse.papyrus.exteditor.cdt.listener.ModelListener;
import org.eclipse.ui.IEditorInput;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.OpaqueBehavior;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;


public class SyncCDTtoModel implements Runnable {

	public static final String sAtParam = "@param"; //$NON-NLS-1$
	
	public static final String ansiCLib = "AnsiCLibrary"; //$NON-NLS-1$
	
	public SyncCDTtoModel(IEditorInput input, Classifier classifier, String projectName) {
		m_input = input;
		m_classifier = classifier;
		m_projectName = projectName;
	}

	public final String langID = "C/C++"; //$NON-NLS-1$

	public void syncCDTtoModel() {
		CommandSupport.exec("update model from CDT", this);
	}

	public void run() {
		ICElement ice = CDTUITools.getEditorInputCElement(m_input);
		ModelListener.syncFromEditor = true;

		if(ice instanceof ITranslationUnit) {
			ICProject project = CoreModel.getDefault().getCModel().getCProject(m_projectName);

			IIndex index = null;
			try {
				index = CCorePlugin.getIndexManager().getIndex(project);
				index.acquireReadLock();

				// index = CCorePlugin.getIndexManager().getIndex(project);
				ITranslationUnit itu = (ITranslationUnit)ice;
				// hack: force re-evaluation of AST node, requires modified CDT!
				// Seems to be no longer required.
				// ASTProvider.getASTProvider().fCache.setActiveElement(itu);

				IASTTranslationUnit ast = itu.getAST(index, ITranslationUnit.AST_SKIP_INDEXED_HEADERS);
				IASTNodeSelector selector = ast.getNodeSelector(null);
				System.err.println(ast);

				examineChildren(itu, selector, itu);
				updateCppInclude(itu);

				CUIPlugin.getDefault().getProblemMarkerManager();
				if(itu instanceof IWorkingCopy) {
					// ((IWorkingCopy)itu).commit(true, new NullProgressMonitor());
					// ((IWorkingCopy)itu).reconcile();
					((IWorkingCopy)itu).reconcile(true, new NullProgressMonitor());
					// ((IWorkingCopy)itu).reconcile(true, true, new NullProgressMonitor());
				}

			} catch (CModelException e) {
				System.err.println(e);
			} catch (Exception e) {
				System.err.println(e);
			} finally {
				if(index != null) {
					index.releaseReadLock();
				}
			}
		}
		ModelListener.syncFromEditor = false;
	}

	/**
	 * Examine the children of a translation unit in order to extract the methods that are defined within
	 * hte unit
	 * 
	 * @param itu
	 * @param selector
	 * @param parent
	 * @throws CModelException
	 */
	public void examineChildren(ITranslationUnit itu, IASTNodeSelector selector, IParent parent) throws CModelException {

		int position = 0;
		// if (parent instanceof Namespace) {
		for(ICElement child : parent.getChildren()) {
			if(child instanceof IParent) {
				examineChildren(itu, selector, (IParent)child);
			}
			ISourceRange range = null;
			if(child instanceof ISourceReference) {
				range = ((ISourceReference)child).getSourceRange();
			}
			if(child instanceof IFunctionDeclaration) {
				// function declaration is a superclass for method declaration (but need to trace functions differently?)
				String name = ((IFunctionDeclaration)child).getElementName();
				IASTNode node = selector.findEnclosingNode(range.getStartPos(), range.getLength());
				if(node instanceof IASTFunctionDefinition) {
					IASTFunctionDefinition definition = (IASTFunctionDefinition)node;
					IASTFunctionDeclarator declarator = definition.getDeclarator();
					String body = getBody(itu, definition);
					Operation operation = updateMethod(position, parent, name, body, declarator);
					updateComment(itu, definition, operation);
					// System.err.println("body source <" + body + ">");
				}
				position++;
			}
		}
	}

	/**
	 * update the contents of the CppInclude directive
	 * 
	 * @param itu
	 *        the translation unit
	 */
	public void updateCppInclude(ITranslationUnit itu) {
		String contents = new String(itu.getContents());
		int preBodyStart = contents.indexOf(Constants.cppIncPreBodyStart);
		int preBodyEnd = contents.indexOf(Constants.cppIncPreBodyEnd);
		String preBody = ""; //$NON-NLS-1$
		String body = ""; //$NON-NLS-1$
		if(preBodyStart != -1) {
			preBodyStart += Constants.cppIncPreBodyStart.length();
			if(preBodyEnd > preBodyStart) {
				preBody = contents.substring(preBodyStart, preBodyEnd).trim();
			}
		}

		int bodyStart = contents.indexOf(Constants.cppIncBodyStart);
		int bodyEnd = contents.indexOf(Constants.cppIncBodyEnd);

		if(bodyStart != -1) {
			bodyStart += Constants.cppIncBodyStart.length() + 1;
			if(bodyEnd > bodyStart) {
				body = contents.substring(bodyStart, bodyEnd).trim();
			}
		}
		if(body.length() > 0 || preBody.length() > 0) {
			Include Include = StUtils.applyApp(m_classifier, Include.class);
			Include.setPreBody(preBody);
			Include.setBody(body);
		}
	}

	/**
	 * Update a method in the model while passing the qualified name
	 * 
	 * @param position
	 *        The position of the method within the file. Used to identify renaming operations
	 * @param parent
	 *        the CDT parent which is used to get a list of children
	 * @param qualifiedName
	 *        the qualified name of a method
	 * @param body
	 *        the method body
	 * @param declarator
	 *        the declarator for the method
	 */
	public Operation updateMethod(int position, IParent parent, String qualifiedName, String body, IASTFunctionDeclarator declarator) {

		String names[] = qualifiedName.split(Utils.nsSep);
		String name = names[names.length - 1];

		Operation operation = m_classifier.getOperation(name, null, null);
		if(operation == null) {
			// operation is not found via name in the model. That does not necessarily mean that this is a new method.
			// It may also have been renamed.
			// Strategy: try to locate the operation in the model at the same "position" as the method in the file and
			// verify that this method does not have the same name as any method in the CDT file.
			if(position < m_classifier.getOperations().size()) {
				operation = m_classifier.getOperations().get(position);
				String modelName = operation.getName();
				try {
					for(ICElement child : parent.getChildren()) {
						if(child instanceof IMethodDeclaration) {
							String cdtName = ((IMethodDeclaration)child).getElementName();
							if(cdtName.equals(modelName)) {
								// an existing operation in the CDT file already has this name
								operation = null;
								break;
							}
						}
					}
				} catch (CModelException e) {
				}
			}
			if(operation != null) {
				operation.setName(name);
			}
			else {
				// still null => create new operation in model
				if(m_classifier instanceof Class) {
					operation = ((Class)m_classifier).createOwnedOperation(name, null, null);
				}
				else if(m_classifier instanceof DataType) {
					operation = ((DataType)m_classifier).createOwnedOperation(name, null, null);
				}
			}
		}

		OpaqueBehavior ob = null;
		if(operation.getMethods().size() == 0) {
			// does not exist, create

			if(m_classifier instanceof Class) {
				ob = (OpaqueBehavior)((Class)m_classifier).createOwnedBehavior(name, UMLPackage.eINSTANCE.getOpaqueBehavior());
			}
			else if(m_classifier instanceof DataType) {
				//ob = (OpaqueBehavior) ((DataType) m_classifier).createOwnedBehavior(name, UMLPackage.eINSTANCE.getOpaqueBehavior());
			}
			ob.setSpecification(operation);
			ob.setIsReentrant(false);
		}
		else {
			ob = (OpaqueBehavior)operation.getMethods().get(0);
			if(!ob.getName().equals(name)) {
				ob.setName(name);
			}
		}

		operation.getOwnedParameters().clear();
		ob.getOwnedParameters().clear();
		for(IASTNode declaratorChild : declarator.getChildren()) {
			if(declaratorChild instanceof IASTParameterDeclaration) {
				IASTParameterDeclaration parameter = (IASTParameterDeclaration)declaratorChild;
				IASTName parameterName = parameter.getDeclarator().getName();
				IASTDeclSpecifier parameterType = parameter.getDeclSpecifier();
				boolean isPointer = false;
				boolean isRef = false;
				String array = "";  //$NON-NLS-1$
				String parameterTypeName = ""; //$NON-NLS-1$
				try {
					IToken token = parameter.getDeclarator().getSyntax();
					while(token != null) {
						String tokenStr = token.toString();
						if(tokenStr.equals("*")) { //$NON-NLS-1$
							isPointer = true;
						}
						else if(tokenStr.equals("&")) { //$NON-NLS-1$
							isRef = true;
						}
						else if (tokenStr.equals("[")) { //$NON-NLS-1$
							while (token != null) {
								array += token.toString();
								token = token.getNext();
							}
							if (token == null) {
								break;
							}
						}
 						token = token.getNext();
					}

					token = parameterType.getSyntax();
					while(token != null) {
						String tokenStr = token.toString();
						if(tokenStr.equals("*")) { //$NON-NLS-1$
							// TODO: check, if this can be called (depending on * position with different semantics?)
							isPointer = true;
						}
						else if(tokenStr.equals("&")) { //$NON-NLS-1$
							isRef = true;
						}
						else if(tokenStr.equals("const")) { //$NON-NLS-1$
							// do nothing (use isConst() operation of parameterType)
							// is not part of parameter type
						}
						else {
							if(parameterTypeName.length() > 0) {
								parameterTypeName += " "; //$NON-NLS-1$
							}
							parameterTypeName += tokenStr;
						}
						token = token.getNext();
					}
				} catch (ExpansionOverlapsBoundaryException e) {
				}

				NamedElement umlParameterType = Utils.getQualifiedElement(Utils.getTop(m_classifier), parameterTypeName);
				if(umlParameterType == null) {
					umlParameterType = Utils.getQualifiedElement(Utils.getTop(m_classifier), ansiCLib + Utils.nsSep + parameterTypeName);
				}
				if(parameterType.isRestrict()) {
				}
				Parameter umlParameter = null;
				if(umlParameterType instanceof Type) {
					umlParameter = operation.createOwnedParameter(parameterName.toString(), (Type)umlParameterType);
					ob.createOwnedParameter(parameterName.toString(), (Type)umlParameterType);
				}
				else {
					umlParameter = operation.createOwnedParameter(parameterName.toString(), null);
					ob.createOwnedParameter(parameterName.toString(), null);
				}
				if(parameterType.isConst()) {
					StUtils.apply(umlParameter, Const.class);
				}
				if(isPointer) {
					StUtils.apply(umlParameter, Ptr.class);
				}
				else if(isRef) {
					StUtils.apply(umlParameter, Ref.class);
				}
				if(array.length() > 0) {
					Array arraySt = StUtils.applyApp(umlParameter, Array.class);
					if (!array.equals("[]") && (!array.equals("[ ]"))) {  //$NON-NLS-1$//$NON-NLS-2$
						arraySt.setDefinition(array);
					}
				}
			
			}
		}

		if(ob.getBodies().size() == 0) {
			ob.getLanguages().add(langID);
			ob.getBodies().add(""); //$NON-NLS-1$
		}
		for(int i = 0; i < ob.getLanguages().size(); i++) {
			if(ob.getLanguages().get(i).equals(langID)) {
				if(i < ob.getBodies().size()) { // should always be true, unless sync between languages/bodies is lost
					ob.getBodies().set(i, body);
				}
			}
		}
		return operation;
	}

	public static String getBody(ITranslationUnit itu, IASTFunctionDefinition definition) {
		IASTStatement body = definition.getBody();

		if(body instanceof IASTCompoundStatement) {
			IASTCompoundStatement bodyComp = (IASTCompoundStatement)body;

			IASTFileLocation bodyLoc = bodyComp.getFileLocation();
			int start = bodyLoc.getNodeOffset();
			int end = start + bodyLoc.getNodeLength();
			char contents[] = itu.getContents();
			// body contains enclosing { } which we need to remove (+2, -2). We cannot use the
			// first and last statement, since leading and trailing comments are not part
			// of the AST tree.
			return Utils.decreaseIndent(contents, start + 2, end - 2);
		}
		return ""; //$NON-NLS-1$
	}

	public void updateComment(ITranslationUnit itu, IASTFunctionDefinition definition, Operation operation) {
		IASTFileLocation bodyLoc = definition.getFileLocation();
		int start = bodyLoc.getNodeOffset() - 1;
		int end = start;
		char contents[] = itu.getContents();
		String comment = ""; //$NON-NLS-1$
		// backward scan for beginning /* 
		while(start > 0) {
			if(contents[start] == '/' && contents[start + 1] == '*') {
				start += "/**".length(); // TODO: common string constants with generator //$NON-NLS-1$
				for(int i = start; i < end; i++) {
					comment += contents[i];
				}
				comment = comment.replace("\n * ", "\n").	//$NON-NLS-1$//$NON-NLS-2$
						replace("*/", "").trim();  			//$NON-NLS-1$//$NON-NLS-2$
				break;
			}
			start--;
		}
		if(comment.length() > 0) {
			// filter @param
			int atParam = comment.indexOf(sAtParam);
			String commentMethodOnly = (atParam != -1) ? comment.substring(0, atParam).trim() : comment;

			EList<Comment> commentsUML = operation.getOwnedComments();
			Comment commentUML;
			if(commentsUML.size() == 0) {
				commentUML = operation.createOwnedComment();
				commentUML.getAnnotatedElements().add(commentUML);
			}
			else {
				commentUML = commentsUML.get(0);
			}
			while(atParam != -1) {
				int currentAtParam = atParam;
				atParam = comment.indexOf(sAtParam, atParam + 1);
				String commentParam = (atParam != -1) ? comment.substring(currentAtParam, atParam) : comment.substring(currentAtParam);
				Comment commentParamUML;
				int atParamName = sAtParam.length();

				while((atParamName < commentParam.length()) && Character.isWhitespace(commentParam.charAt(atParamName))) {
					atParamName++;
				}
				int atParamNameEnd = atParamName;
				while((atParamNameEnd < commentParam.length()) && !Character.isWhitespace(commentParam.charAt(atParamNameEnd))) {
					atParamNameEnd++;
				}
				if(atParamNameEnd < commentParam.length() - 1) {
					String parameterName = commentParam.substring(atParamName, atParamNameEnd);
					String commentParamText = commentParam.substring(atParamNameEnd).trim();
					Parameter parameter = operation.getOwnedParameter(parameterName, null, false, false);
					if(parameter != null) {
						EList<Comment> commentsParamUML = parameter.getOwnedComments();
						if(commentsParamUML.size() == 0) {
							commentParamUML = parameter.createOwnedComment();
							commentParamUML.getAnnotatedElements().add(commentParamUML);
						}
						else {
							commentParamUML = commentsParamUML.get(0);
						}
						commentParamUML.setBody(commentParamText);
					}
					else {
						// parameter is not found in model, e.g. either renamed or not yet existing
						// store comment in operation comment
						commentMethodOnly += "\n " + sAtParam + parameterName + //$NON-NLS-1$
								" not found(!) " + commentParamText; //$NON-NLS-1$
					}
				}
			}
			commentUML.setBody(commentMethodOnly);
		}
	}


	protected IEditorInput m_input;

	protected Classifier m_classifier;

	protected String m_projectName;
}
