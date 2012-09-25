/**
 * Copyright 2011 The Open Source Research Group,
 *                University of Erlangen-Nürnberg
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.sweble.wikitext.engine.ext.core;

import java.util.List;

import org.sweble.wikitext.engine.ExpansionFrame;
import org.sweble.wikitext.engine.ParserFunctionBase;
import org.sweble.wikitext.engine.PfnArgumentMode;
import org.sweble.wikitext.parser.parser.PageSwitch;

import de.fau.cs.osr.ptk.common.ast.AstNode;

public abstract class CorePfnBehaviorSwitch
		extends
			ParserFunctionBase
{
	private static final long serialVersionUID = 1L;
	
	// =========================================================================
	
	public CorePfnBehaviorSwitch(String name)
	{
		// Page Switches don't take arguments so don't waste time with funny 
		// conversions.
		super(PfnArgumentMode.TEMPLATE_ARGUMENTS, name);
	}
	
	// =========================================================================
	
	@Override
	public final AstNode invoke(
			AstNode pageSwitch,
			ExpansionFrame frame,
			List<? extends AstNode> argsValues)
	{
		return invoke((PageSwitch) pageSwitch, frame);
	}
	
	protected abstract AstNode invoke(PageSwitch var, ExpansionFrame frame);
}