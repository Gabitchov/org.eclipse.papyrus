# <a id="Limitations">Limitations and Known Issues</a>

The following Papyrus capabilities are supported on models in CDO repositories:

* create new UML and SysML models
	* initialize Papyrus model from existing domain model resource in the repository
	* import models from the workspace
	* reorganize models in folders by drag-and-drop
* create and edit all kinds of UML and SysML diagram
* create and edit tables
* export models to the workspace
* browse connected repositories for importing packages and applying profiles
* CSS diagram styling and themes (with restrictions, see below)
* properties view customization models can be stored in and loaded from the repository

Some capabilities of Papyrus are not support on models in CDO repositories in this release:

* compare/merge:  the **Model Repositories** view does not support branches and no "compare with each other" action is provided
* although CSS styling of diagrams is supported, this extends only to CSS stylsheets deployed in plug-ins.  Custom stylesheets stored locally in the workspace or in a repository are not supported
* controlled resources are not supported
* attaching documents to model elements is not supported