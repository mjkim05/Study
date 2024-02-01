/* ===============================================
 	XmlDomTest03.java
 	- 콘솔 기반 자바 프로그램
 	- XML DOM 활용 → 로컬(local) XML 읽어내기
 	  (memList.xml)
 ================================================*/

package com.test;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlDomTest03
{
	public static void main(String[] args) 
	{
		try
		{
			//xml builder 만들기 + xml 메모리 로드
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document xmlObj = null;
			
			String url = "memList.xml";
			xmlObj = builder.parse(url);
			
			// 루트 엘리먼트 접근
			Element root = xmlObj.getDocumentElement();
			
			// 특정 하위 엘리먼트 접근
			NodeList memNodeList = root.getElementsByTagName("memberInfo");
			
			for (int i = 0; i < memNodeList.getLength(); i++)
			{
				Node memNode = memNodeList.item(i);
				Element memElement = (Element)memNode;
				
				System.out.printf( "이름 : %s%n전화번호 : %s%n나이 : %s%n"
								 , getText(memElement, "name")
								 , getText(memElement, "telephone")
								 , getText(memElement, "age"));
				
				NodeList foodNodeList = memElement.getElementsByTagName("food");
			
				
				if(foodNodeList.getLength() > 0)
				{
					Node foodNode = foodNodeList.item(0);
					Element foodElement = (Element)foodNode;
				
					NodeList likeNodeList =	foodElement.getElementsByTagName("like");
					NodeList hateNodeList =	foodElement.getElementsByTagName("hate");
					
					for (int j = 0; j <likeNodeList.getLength(); j++)
					{

						Node likeNode = likeNodeList.item(j);
						Element likeElement = (Element)likeNode;
						Node hateNode = hateNodeList.item(j);
						Element hateElement = (Element)hateNode;
						
						System.out.printf("좋아하는 음식 : %s%n싫어하는 음식 : %s%n"
										  ,likeElement.getTextContent()
										  ,hateElement.getTextContent());
					
					}
					
				}
				System.out.println();
			}
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
	}
	
	
	private static String getText(Element parent, String tagName)
	{
		String result = "";
		
		Node node = parent.getElementsByTagName(tagName).item(0);
		Element element = (Element)node; 
				
		result = element.getChildNodes().item(0).getNodeValue();
		
		
		return result;
	}
	
}
