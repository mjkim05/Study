/* ===============
 	XMLDOM.java
 =============== */

package com.test;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class XMLDOM
{
	public static String getText(Element parent, String tagName)
	{
		String result="";
		
		Node node = parent.getElementsByTagName(tagName).item(0);
		Element element = (Element)node;

		// 대상 엘리먼트(element)의 자식 노드(텍스트 노드)의 값 얻어오기
		result = element.getChildNodes().item(0).getNodeValue();
		
		return result;
		
	}
}
