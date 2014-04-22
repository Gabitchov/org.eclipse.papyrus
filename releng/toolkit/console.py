################################################################################
# Copyright (c) 2014 CEA LIST.
#
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
#
# Contributors:
# Laurent Wouters laurent.wouters@cea.fr - Initial API and implementation
#
################################################################################

# Log levels
LEVELS={
	"DEBUG":0,
	"INFO":0,
	"WARNING":93,
	"ERROR":91
}

# Color codes for the console colors
COLORS={
    "ENDC":0,  # RESET COLOR
    "GREY70":97,
    "RED":91,
    "YELLOW":93,
    "BLUE":94,
    "PURPLE":95,
    "GREEN":92,
}

# Activate/Deactivate the use of console colors
USE_COLOR=False
# Command line option to activate colors
CLI_COLOR="--color"

# Logs the given message at the given level
def log(message, level="INFO"):
	print(__getFormatted(message, level))

# Gets the formatted string for the given message and level
def __getFormatted(message, level):
	if USE_COLOR and LEVELS[level] > 0:
		return  __termcode(LEVELS[level]) + "[" + level + "] " + message + __termcode(0)
	else:
		return "[" + level + "] " + message

# Gets the string for the given console color
def __termcode(num):
    return "\033[%sm"%num