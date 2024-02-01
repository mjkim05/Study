/* ===============================================
 	XmlDomTest05.java
 	- 콘솔 기반 자바 프로그램
 	- XML DOM 활용 → 로컬(local) XML 읽어내기
 	  (VEHICLES.xml)
 ================================================*/

package com.test;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlDomTest05
{
	public static void main(String[] args)
	{
		try
		{
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document xmlObj = null;
			
			String url = "VEHICLES.xml";
			xmlObj = builder.parse(url);
			
			// 루트 엘리먼트
			Element root = xmlObj.getDocumentElement();
			
			// 하위 엘리먼트
			NodeList vehiclesNodeList = root.getElementsByTagName("VEHICLE");
			
			// 공통 사항
			for (int i = 0; i < vehiclesNodeList.getLength(); i++)
			{
				Node vehiclesNode = vehiclesNodeList.item(i);
				Element vehiclesElement = (Element)vehiclesNode;
				
				System.out.println("---------------------------------------------------------------------");
				System.out.println("NO      MAKE     MODEL     YEAR    STYLE          PRICE");
				System.out.println("---------------------------------------------------------------------");
				System.out.printf("%s    %7s    %5s   %5s    %s      %s%n"
								  ,getText(vehiclesElement, "INVENTORY_NUMBER")
								  ,getText(vehiclesElement, "MAKE")
								  ,getText(vehiclesElement, "MODEL")
								  ,getText(vehiclesElement, "YEAR")
								  ,getText(vehiclesElement, "STYLE")
								  ,getText(vehiclesElement, "PRICE"));
				System.out.println("Options --------------------------------------------------------------");
				
				NodeList optionsNodeList = vehiclesElement.getElementsByTagName("OPTIONS");
				Node optionsNode = optionsNodeList.item(0);
				Element optionsElement = (Element)optionsNode;
				
				NodeList optionList = optionsElement.getChildNodes();
				for (int j = 0; j < optionList.getLength(); j++)
				{
					Node optionNode = optionList.item(j);
					if (optionNode.getNodeType()==1)
					{
						Element optionElement = (Element)optionNode;
						System.out.printf("%s : %s%n"
										  ,optionElement.getNodeName()
										  ,optionElement.getTextContent());
					}
				}
				
				System.out.println("---------------------------------------------------------------------");
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
