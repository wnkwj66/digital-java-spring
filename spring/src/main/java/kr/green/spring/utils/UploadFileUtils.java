package kr.green.spring.utils;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;

public class UploadFileUtils {
	public static String uploadFile(String uploadPath, String originalName, byte[] 	
			fileData)throws Exception{
		UUID uid = UUID.randomUUID();
		String savedName = uid.toString() +"_" + originalName;
		String savedPath = calcPath(uploadPath);
		//file target :실제 업로드할 경로?
		//new File을 통해 이름을 가진 빈 파일이 생성 된다.
		File target = new File(uploadPath + savedPath, savedName);
		//FileCopyUtils : 파일 복사
		FileCopyUtils.copy(fileData, target);
		//폴더 경로를 \가 아닌 /로 바꾸는 코드
		String uploadFileName = makeIcon(uploadPath, savedPath, savedName);
		return uploadFileName;
	}
	
	private static String calcPath(String uploadPath) {
		//업로드 날짜 정보를 생성
		Calendar cal = Calendar.getInstance();
		//년도 경로를 생성? -> 오늘 : \2020 (OS:윈도우)
		String yearPath = File.separator+cal.get(Calendar.YEAR);
		//monthpath :년+월을 합친 월 경로를 생성 : \2020\07
		String monthPath = yearPath + File.separator 
            + new DecimalFormat("00").format(cal.get(Calendar.MONTH)+1);
		//datepath : 년+월+일을 합친 일 경로를 생성 : \2020\07\22
		String datePath = monthPath + File.separator 
            + new DecimalFormat("00").format(cal.get(Calendar.DATE));
		makeDir(uploadPath, yearPath, monthPath, datePath);
		
		return datePath;
 
	}
	private static void makeDir(String uploadPath, String... paths) { //String... paths:가변 매개변수 : 배열로 저장됨
		if(new File(uploadPath+paths[paths.length-1]).exists())
			return;
		for(String path : paths) {
			File dirPath = new File(uploadPath + path);
			if( !dirPath.exists())//경로에 해당 파일이 없으면 폴더를 만들고 있으면 넘어감
				dirPath.mkdir();
		}
	}
	private static String makeIcon(String uploadPath, String path, String fileName)
        	throws Exception{
		String iconName = uploadPath + path + File.separator + fileName;
		return iconName.substring(uploadPath.length()).replace(File.separatorChar, '/');
	}
}
