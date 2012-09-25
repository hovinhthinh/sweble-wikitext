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

package org.sweble.wikitext.engine.ext.parser_functions;

import org.sweble.wikitext.engine.config.ParserFunctionGroup;

public class ParserFunctionsPfnExt
		extends
			ParserFunctionGroup
{
	private static final long serialVersionUID = 1L;
	
	// =========================================================================
	
	protected ParserFunctionsPfnExt()
	{
		super("Extension - Parser Functions");
		addParserFunction(new ParserFunctionExpr());
		addParserFunction(new ParserFunctionIf());
		addParserFunction(new ParserFunctionIfeq());
		addParserFunction(new ParserFunctionIfError());
		addParserFunction(new ParserFunctionIfExist());
		addParserFunction(new ParserFunctionIfExpr());
		addParserFunction(new ParserFunctionSwitch());
		addParserFunction(new ParserFunctionTime());
		addParserFunction(new ParserFunctionTitleparts());
	}
	
	public static ParserFunctionsPfnExt group()
	{
		return new ParserFunctionsPfnExt();
	}
}