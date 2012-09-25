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
package org.sweble.wikitext.engine.astwom;

import static org.junit.Assert.*;
import static org.sweble.wikitext.engine.wom.tools.AstWomBuilder.*;

import org.junit.Before;
import org.junit.Test;
import org.sweble.wikitext.engine.astwom.adapters.PageAdapter;
import org.sweble.wikitext.engine.wom.WomPage;
import org.sweble.wikitext.parser.preprocessor.XmlComment;
import org.sweble.wikitext.parser.parser.RtData;
import org.sweble.wikitext.parser.utils.RtWikitextPrinter;

import de.fau.cs.osr.ptk.common.ast.ContentNode;

public class CommentAdapterTest
{
	private WomPage womPage;
	
	private ContentNode astPage;
	
	@Before
	public void initialize()
	{
		womPage = womPage().withBody(
				womComment().build()).build();
		
		astPage = ((PageAdapter) womPage).getAstNode();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void illegalCommentTextRaisesException()
	{
		womPage().withBody(
				womComment().withText(" -- ").build()).build();
	}
	
	@Test
	public void rtDataSupportsCorrectRendering()
	{
		assertEquals(
				"<!-- Default Comment Text -->",
				RtWikitextPrinter.print(astPage));
	}
	
	@Test
	public void theAstOfAWomCommentIsCorrect()
	{
		XmlComment c = (XmlComment) astPage.getContent().get(0);
		
		assertNull(c.getPrefix());
		assertNull(c.getSuffix());
		assertEquals(" Default Comment Text ", c.getContent());
		assertEquals(
				RtData.build("<!-- Default Comment Text -->"),
				c.getAttribute("RTD"));
	}
}