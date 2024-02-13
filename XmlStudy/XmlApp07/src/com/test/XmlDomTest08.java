package com.test;

import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class XmlDomTest08
{

	/* ===============================================
	 	XmlDomTest08.java
	 	- 콘솔 기반 자바 프로그램
	 	- XML DOM 활용 → 원격(remote) XML 읽어내기
		  (https://fs.jtbc.co.kr/RSS/newsflash.xml)
		  ※ 언론사 뉴스로부터 얻어낸 데이터
	 ================================================*/

	/*
		title>JTBC News
		link>https://fs.jtbc.co.kr/RSS/newsflash.xml
		description>속보 RSS
		copyright>Copyright(C) JTBC All rights reserved.
		주요 기사 ------------------------------------------------------------
		title>[날씨] 전국 대체로 흐림…곳곳 미세먼지 '나쁨'
		description> 오늘(2일)은 전국이 대체로 흐린 가운데, 일부 지역의 미세먼지가 '나쁨' 수준을 보이겠습니다.낮 최고기온은 3도에서 10도로 포근한 날씨가 예상됩니다.
		link>https://news.jtbc.co.kr/article/article.aspx?news_id=NB12163616
		pubDate>2024.02.02
		
		title>외식비 급등에 인기 '쑥'…냉동치킨 '영양성분' 꼭 확인하세요
		description> [앵커]프랜차이즈 치킨값이 2만 원을 훌쩍 넘는 요즘, 대체품으로 마트의 냉동 치킨을 찾는 경우가 늘어났습니다. 그런데 잘 살펴보셔야 합니다. 인기 제품들 가운데 포화지방과 나트륨이 과하게 들어 있거나, 원산
		link>https://news.jtbc.co.kr/article/article.aspx?news_id=NB12163595
		pubDate>2024.02.02
	 */
		public static void main(String[] args)
		{
			/* 1. 원격 XML 정보를 요청하고, 그 결과를 메모리에 로드
				      → XML DOM 구성
				     	·DB 활용
					  	·DBF 활용
					 	·XML 로딩
				   2. 루트 엘리먼트 접근
				   3. 특정 하위 엘리먼트 접근
				   4. 텍스트 노드 접근
				      → 필요한 데이터 획득
				   5. 결과 처리(출력)
			 */
			try
			{
				// ※ DOM(Document Object Model)
				//    - XML 이나 HTML Document(문서)를 응용프로램에서 사용하기 위한 API 규칙
				//    - DOM 은 Document(문서)의 각 부분들을 객체(Object)로 표현한 API
				
				// ※ DOM(Document Object Model) 파서 (parser)
				//    - XML 문서를 읽고, 해석한 후
				//      해석한 결과를 메모리에 DOM 객체 트리 구조로 생성시키는 파서(parser)
				//    - 원하는 데이터에 접근할 수 있도록 해주어
				//      대상 데이터를 검색, 수정, 삭제할 수 있도록 지원
				
				
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				DocumentBuilder builder = factory.newDocumentBuilder();
				Document xmlObj = null;
				
				URL url = new URL("https://fs.jtbc.co.kr/RSS/newsflash.xml");
				String str = String.format("https://fs.jtbc.co.kr/RSS/newsflash.xml");
				InputSource is = new InputSource(str);
				
				xmlObj = builder.parse(is);
				
				// 루트 엘리먼트 구성
				Element root = xmlObj.getDocumentElement();
				
				// 하위 엘리먼트
				Node channelNode = root.getElementsByTagName("channel").item(0);
				Element channelElement = (Element)channelNode;
				
				System.out.printf("title> %s%nlink> %s%ndescription> %s%ncopyright> %s%n "
								 ,XMLDOM.getText(channelElement, "title")
								 ,XMLDOM.getText(channelElement, "link")
								 ,XMLDOM.getText(channelElement, "description")
								 ,XMLDOM.getText(channelElement, "copyright"));
				
				System.out.println();
				// 주요 기사
				System.out.println("주요 기사 --------------------------------------------------------------------------");
				
				NodeList itemNodeList = channelElement.getElementsByTagName("item");
				
				for (int i = 0; i < itemNodeList.getLength(); i++)
				{
					Node itemNode = itemNodeList.item(i);
					Element itemElement = (Element)itemNode;
					
					System.out.printf("title> %s%ndescription> %s%nlink> %s%npubData> %s%n "
								     ,XMLDOM.getText(itemElement, "title")
								     ,XMLDOM.getText(itemElement, "description")
								     ,XMLDOM.getText(itemElement, "link")
								     ,XMLDOM.getText(itemElement, "pubDate"));
					System.out.println();
					
				}
			} catch (Exception e)
			{
				System.out.println(e.toString());
			}
		}
	}
//--==>>
/*
 title> JTBC News
link> https://fs.jtbc.co.kr/RSS/newsflash.xml
description> 속보 RSS
copyright> Copyright(C) JTBC All rights reserved.
 
주요 기사 --------------------------------------------------------------------------
title> 2월 2일 (금) 아침& 다시보기
description>  시청자 여러분 안녕하십니까, 2월 2일 JTBC 아침& 시작합니다. 먼저 오늘 아침 주요뉴스입니다.
link> https://news.jtbc.co.kr/article/article.aspx?news_id=NB12163608
pubData> 2024.02.02
 
title> '아형' 여자아이들 소연, "신곡 뮤직비디오 제작비 11억 썼다"
description> (여자)아이들 소연이 신곡 에피소드를 전한다.3일(토) 방송되는 JTBC '아는 형님'에는 정규 2집 '2'(Two)의 타이틀곡 'Super Lady(슈퍼 레이디)'로 돌아온 (여자)아이들의 미연, 민니, 소연, 우기, 슈화가 출연한다.
link> https://news.jtbc.co.kr/article/article.aspx?news_id=NB12163637
pubData> 2024.02.02
 
title> [날씨] 전국 대체로 흐림…곳곳 미세먼지 '나쁨'
description>  오늘(2일)은 전국이 대체로 흐린 가운데, 일부 지역의 미세먼지가 '나쁨' 수준을 보이겠습니다.낮 최고기온은 3도에서 10도로 포근한 날씨가 예상됩니다.
link> https://news.jtbc.co.kr/article/article.aspx?news_id=NB12163616
pubData> 2024.02.02
 
title> 외식비 급등에 인기 '쑥'…냉동치킨 '영양성분' 꼭 확인하세요
description>  [앵커]프랜차이즈 치킨값이 2만 원을 훌쩍 넘는 요즘, 대체품으로 마트의 냉동 치킨을 찾는 경우가 늘어났습니다. 그런데 잘 살펴보셔야 합니다. 인기 제품들 가운데 포화지방과 나트륨이 과하게 들어 있거나, 원산
link> https://news.jtbc.co.kr/article/article.aspx?news_id=NB12163595
pubData> 2024.02.02
 
title> '불황 속 호황'…경기 침체 속 '로또' 불티나게 팔렸다
description>  [앵커]경제와 생활 소식을 전해드리는 '아침 앤 라이프' 경제산업부 정아람 기자가 나와있습니다.오늘(2일)의 키워드는 뭔가요.[기자]오늘 키워드는 '불황 속 호황'으로 잡아봤습니다.지난해에 이어서, 올해 경기도
link> https://news.jtbc.co.kr/article/article.aspx?news_id=NB12163599
pubData> 2024.02.02
 
title> '강제동원 조선인 추도비' 결국 산산조각 냈다…비문만 남겨
description>  [앵커]일본 군마현의 '조선인 노동자 추도비'가 결국 철거돼 산산조각이 났습니다. 강제징용을 반성한다는 의미로 세운 건데, 시민 단체가 철거에 반발했지만 소용없었습니다.김혜미 기자입니다.[기자]공원 한 켠에
link> https://news.jtbc.co.kr/article/article.aspx?news_id=NB12163596
pubData> 2024.02.02
 
title> 해병사령관 통화기록 입수…안보실 2차장과 '두 차례 통화'
description>  [앵커]채 상병 사건을 조사하다 항명죄로 기소된 박정훈 대령의 재판에서 수사 외압의 핵심인물, 김계환 해병대 사령관이 증인으로 참석했습니다. 김 사령관은 대통령실 개입 여부를 질문받자 '그런 일은 없다'고 
link> https://news.jtbc.co.kr/article/article.aspx?news_id=NB12163597
pubData> 2024.02.02
 
title> 미군 인태사령관 지명자 "확장억제, 대북억지에 필수"
description>  새뮤얼 파파로 미군 인도&middot;태평양 사령관 지명자는 핵 무력을 고도화하고 있는 북한을 막기 위해, 한국에 대한 '확장억제'가 꼭 필요하다고 강조했습니다.확장 억제는 미군이 보유한 막강한 핵 전력의 위력을
link> https://news.jtbc.co.kr/article/article.aspx?news_id=NB12163615
pubData> 2024.02.02
 
title> 이정재·이병헌·공유 '오겜2'…넷플릭스가 공개한 이 장면 [소셜픽]
description>  드라마 '오징어 게임'이 시즌 2로 돌아옵니다.넷플릭스는 올해 기대작들을 예고하면서 모든 작품 중 가장 마지막으로 이 장면을 공개했습니다.[{네가 한 선택을 후회하게 될 거야} 널 찾아낼 거야, 무슨 수를 써서
link> https://news.jtbc.co.kr/article/article.aspx?news_id=NB12163606
pubData> 2024.02.02
 
title> 나이는 숫자일 뿐…'88세 최고령 게이머' 기네스 인정 [소셜픽]
description>  일본 아키타현의 E 스포츠팀이 주목을 받고 있습니다.특별한 점은 평균 연령은 67살, 최고 연장자는 75의 게이머들이라는 겁니다.팀의 이름은 '마타기 스나이퍼스'.67살 '마크25'의 플레이를 보고 계십니다.주 종목
link> https://news.jtbc.co.kr/article/article.aspx?news_id=NB12163607
pubData> 2024.02.02
 
title> "승전국 조약서 같았다" 주호민, 특수교사 선처 철회한 이유 [소셜픽]
description>  웹툰 작가 주호민 씨가 개인 생방송을 통해 개인의 입장을 털어놨습니다.주 씨는 특수교사가 아들을 정서적으로 학대했다며 신고했고, 어제(1일) 법원은 교사 A 씨에게 벌금 200만 원의 선고유예 판결을 내렸습니다
link> https://news.jtbc.co.kr/article/article.aspx?news_id=NB12163600
pubData> 2024.02.02
 
title> BTS·블랙핑크도 틱톡서 '음소거'…협상 결렬 여파
description>  [앵커]동영상 공유 플랫폼, 틱톡에서 팝 스타들의 음악이 사라지기 시작했습니다. 세계 최대 음악 콘텐츠 기업인 유니버설 뮤직 그룹과 틱톡의 계약이 결렬되면서, 틱톡에서는 방탄소년단의 노래도 들을 수 없게 됐
link> https://news.jtbc.co.kr/article/article.aspx?news_id=NB12163601
pubData> 2024.02.02
 
title> 일본 공격수 이토 준야 '성범죄 혐의'…대표팀서 아웃
description>   일본 축구대표팀 공격수 이토 준야가 대표팀에서 떠났습니다.일본축구협회는 "2023 카타르 아시안컵에 출전 중인 일본 대표팀에서 이토가 떠나게 됐음을 알린다"고 밝혔습니다.일본 데일리 신조에 따르면 이토는 
link> https://news.jtbc.co.kr/article/article.aspx?news_id=NB12163612
pubData> 2024.02.02
 
title> 호주와의 8강전, 관건은 체력…"빠른 선제골을 노려라"
description>  [앵커]64년 만에 아시안컵 우승을 노리는 한국 축구 대표팀이 내일(3일) 새벽 호주와 8강전을 치릅니다. 우리보다 이틀 더 쉰 호주가 상대여서 대표팀의 체력이 변수입니다. 발이 느린 호주 수비진을 상대로 경기 
link> https://news.jtbc.co.kr/article/article.aspx?news_id=NB12163602
pubData> 2024.02.02
 
title> 대통령실, 불교계 보낸 선물에 "하나님 아버지…아멘" 기도문이
description>  [앵커]대통령실이 불교계에 대통령 설 선물을 보냈는데, 십자가가 그려진 선물 상자 안에는 '하나님 감사합니다'로 시작하는 기도문도 포함됐습니다. '종교 편향'이라는 반발에, 비서실장이 고개를 숙였습니다.배양
link> https://news.jtbc.co.kr/article/article.aspx?news_id=NB12163598
pubData> 2024.02.02
 
title> 중대재해처벌법 '50인 미만 확대 유예' 또 불발
description>  50인 미만 사업장까지 확대 적용되는 중대재해처벌법 시행의 유예를 둘러싼 여야 협상이 또 불발됐습니다.여당은 법 적용을 2년 더 미루되, 산업안전보건청을 2년 뒤 출범시키는 절충안을 냈지만 민주당은 노동자의
link> https://news.jtbc.co.kr/article/article.aspx?news_id=NB12163603
pubData> 2024.02.02
 
title> 정부 '필수의료 살리기' 10조원 투입…실효성 우려도
description>  [앵커]외과&middot;소아과 같은 필수 의료를 살리기 위해 정부가 올해 입시부터 의대 정원을 늘리고, 필수의료 지원에 10조원 넘게 투입하겠다고 밝혔습니다. 윤석열 대통령은 의료 사고에서 의사들이 법적 리스크
link> https://news.jtbc.co.kr/article/article.aspx?news_id=NB12163610
pubData> 2024.02.02
 
title> '문경 화재' 현장 합동감식…순직 두 소방관 내일 영결식
description>  [앵커]이틀 전 경북 문경의 공장에서 난 불로 젊은 소방관 2명이 숨졌습니다. 불이 왜 났는지 원인을 찾을 시간입니다. 공장 설비의 문제는 없었는지 등 본격적인 조사가 오늘(2일) 시작되는데, 현장에 나가 있는 
link> https://news.jtbc.co.kr/article/article.aspx?news_id=NB12163604
pubData> 2024.02.02
 
title> 오늘의 주요뉴스
description>  1. 오늘 합동 감식&hellip;시민 분향소 마련화재로 소방관 두 명의 목숨을 앗아간 경북 문경 공장에서 오늘 합동 감식이 이뤄집니다. 시민들이 추모할 수 있는 분향소가 차려진 가운데 영결식은 내일 문경 실내체육
link> https://news.jtbc.co.kr/article/article.aspx?news_id=NB12163605
pubData> 2024.02.02
 
title> 2월 1일 (목) 뉴스룸 다시보기
description>  오늘(1일) 저희 뉴스룸은 생때같은 젊은 소방관들의 목숨을 빼앗아 간 경북 문경의 화재 현장에서 전해드립니다. 보시는 것처럼 철골 구조는 엿가락처럼 다 휘었고, 공장은 원래 모습을 전혀 찾아볼 수 없습니다. 
link> https://news.jtbc.co.kr/article/article.aspx?news_id=NB12163571
pubData> 2024.02.01

*/

