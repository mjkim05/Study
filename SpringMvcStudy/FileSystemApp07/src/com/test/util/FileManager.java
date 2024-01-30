/* ================
  FileManager.java
 ================ */

package com.test.util;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletResponse;

public class FileManager
{
	// 파일 다운로드
	// -- 다운로드할 파일이 정상적으로 존재할 경우 true 발생
	//    파일이 존재하지 않아 정상적인 처리가 이루어지지 않을 경우 false 반환
	// -- saveFileName     : 서버에 저장된 파일의 이름
	// -- originalFileName : 클라이언트가 업로드한 파일의 이름
	// -- path 			   : 서버에 저장된 경로
	// -- response         : HttpServletResponse 응답 객체
	public static boolean doFileDownload(String saveFileName, String originalFileName, String path, HttpServletResponse response)
	{
		// 워크스페이스 - 물리적인 실제 파일이 존재하는 서버 경로 → 전체 경로
		String loadDir = path + File.separator + saveFileName;
		
		// 확인 
		System.out.println(loadDir);
		
		try
		{
			if(originalFileName == null || originalFileName.equals(""))
			{
				originalFileName = saveFileName;
			}
			
			//new String(originalFileName.getBytes("EUC-KR"),"ISO-8859-1");
			originalFileName = new String(originalFileName.getBytes("EUC-KR"),"8859_1");
			
		//} catch (Exception e)
		}catch(UnsupportedEncodingException e)
		{
			System.out.println(e.toString());
		}
		
		try
		{
			File file = new File(loadDir);
			
			if (file.exists())	// 물리적 파일이 존재할 때
			{
				byte[] readByte = new byte[4*1024];		//-- 4096 byte == 4kb
				
				response.setContentType("application/octet-stream");
				response.setHeader("Content-disposition","attachment;filename=" + originalFileName);
				//                 ---------------------------------  -----------------------------
				//                          여기까지는 약속					 우리가 별도로 구성
				
				// 서버의 물리적 파일의 전체 경로로 FileInputStream 객체 생성
				// 이 객체를 BufferedInputStream 객체로 감싸는 처리
				BufferedInputStream fis = new BufferedInputStream(new FileInputStream(file));
				
				OutputStream os = response.getOutputStream();
				
				int read;
				while ((read=fis.read(readByte, 0, 4096))!= -1)
				{
					os.write(readByte, 0 , read);
				}
				
				// 버퍼의 내용을 밀어내기
				// → 응답하는 스트림으로 밀어낸다.
				os.flush();
				
				// 리소스 반납
				os.close();
				fis.close();
				
				// 파일이 존재하는 상황이므로 true 반환
				return true;
		
			}
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		// 파일이 존재하지 않아 정상적인 처리가 이루어지지 않는 상황이므로 false 반환
		return false;
		
	}// end doFileDownload()
	
	
	// 실제 서버의 파일 삭제 (제거) 참고 자료
	public static void doFileDelete(String fileName, String path)
	{
		
		try
		{
			File file = null;
			
			String fullFileName = path + File.pathSeparator + fileName;
			file = new File(fullFileName);
			
			if(file.exists())
			{
				file.delete();
			}
			
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
	}

}
