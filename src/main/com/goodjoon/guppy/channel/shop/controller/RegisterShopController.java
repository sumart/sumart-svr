package com.goodjoon.guppy.channel.shop.controller;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.goodjoon.guppy.channel.common.controller.BaseController;
import com.goodjoon.guppy.channel.common.model.DefaultResponse;
import com.goodjoon.guppy.common.util.FileUtils;
import com.goodjoon.guppy.engine.common.dao.CodeMasterDao;
import com.goodjoon.guppy.engine.common.model.CodeMaster;
import com.goodjoon.guppy.engine.common.proc.CodeMasterProc;
import com.goodjoon.guppy.engine.common.util.DataUtils;
import com.goodjoon.guppy.engine.service.shop.model.Shop;
import com.goodjoon.guppy.engine.service.shop.proc.RegisterShopProc;
import com.goodjoon.guppy.exception.GuppyException;

@Controller
@RequestMapping(value="/shop")
public class RegisterShopController extends BaseController {
	protected static String SHOP_IMAGE_DIRECTORY_PATH;
	
	@Autowired
	protected RegisterShopProc registerShopProc;
	
	@Autowired
	protected CodeMasterProc codeMasterProc;
	
	@Autowired
	SqlSessionFactory sf;
	
	
	@RequestMapping(method=RequestMethod.POST)
	public @ResponseBody DefaultResponse registerShop(Shop shop, HttpServletRequest req) throws GuppyException {
		debugRequest(req);		
		
		String shopId = registerShopProc.registerShop(shop);
		
		//----
				
		DefaultResponse res = new DefaultResponse();
		res.setSuccess("OK");
		HashMap<String, String> result = new HashMap<String, String>();
		
		// TODO: 우선 그냥 status 값은 hasImage 값만으로 판단한다. 원래는 Session 에 기본정보 올리고 있어야 한다.
		result.put("status", String.valueOf((shop.isHasImages())?1:0));
		result.put("id",shopId);
		res.setResult(result);
		
		return res;
	}
	
	@RequestMapping(value="/image", method=RequestMethod.POST)
	public @ResponseBody DefaultResponse registerImage(@RequestParam String shopId, @RequestParam boolean hasMoreImage, 
			MultipartRequest multipartRequest, HttpServletRequest req) throws GuppyException{
		
		DefaultResponse res = new DefaultResponse();
		debugRequest(req);
		debugRequest(multipartRequest);

		try {
			Map<String, MultipartFile> multipartMap = multipartRequest.getFileMap();
			Set<String> fileNameSet = multipartMap.keySet();
			Date curDate = new Date();
			ArrayList<String> storedFilePaths = new ArrayList<String>();
			
			for (String keyName : fileNameSet) {
				MultipartFile srcFile = multipartMap.get(keyName);
				
				
				DateFormatter formatter = new DateFormatter("yyyy"+File.separator + "MM" 
										+ File.separator + "dd" + File.separator + "HH" );
				String storeTargetSubDir = formatter.print(curDate, new Locale("ko_KR")); // 이미지 저장할 서브디렉토리
				String storedFilePath = FilenameUtils.concat(getShopImageDirectoryPath(),  // 호스트별 디렉토리 Full Path
						storeTargetSubDir);
				
				if (!FileUtils.isFileExists(storedFilePath))
					FileUtils.forceMkdir(storedFilePath);
				
				String fileName = DataUtils.makeRandomUUIDString(true); // 저장 할 파일명
				storedFilePath = FilenameUtils.concat(storedFilePath, fileName); // 저장할 파일의 Full File Path
				
				FileUtils.WriteInputStreamToFile(srcFile.getInputStream(), storedFilePath);
				storedFilePaths.add(FilenameUtils.concat(storeTargetSubDir, fileName)); 
			}
			
			// 정상 파일저장 후 DB Tracsaction
			Shop shop = new Shop();
			shop.setId(shopId);
			shop.setImages(storedFilePaths.toArray(new String[0]));
			registerShopProc.registerShopImages(shop);
			
			// DB 실패 시 File 삭제
		} catch (IOException e) {
			// File Write 실패. DB 에 Insert 안하고 Error 리턴해야 함.
			// TODO: 에러 메커니즘 설계해야 한다. Exception 분류별로 Throw 하면, 요놈으로 Response 만들어 줘야 한다.
			e.printStackTrace();
		}
		
		
		res.setSuccess("OK");
		
		if (hasMoreImage) {
			res.setResult(new Object() {
				public int getStatus() {
					return 1;
				}});
		} else
			res.setResult(new Object() {
				public int getStatus() {
					return 0;
				}
			});
		
		return res;
	}
	
	protected String getShopImageDirectoryPath() throws GuppyException{
		if (SHOP_IMAGE_DIRECTORY_PATH == null || "".equals(SHOP_IMAGE_DIRECTORY_PATH)) {
			CodeMaster cm = new CodeMaster();
			cm.setCodeGroup("java");
			cm.setCodeName(CodeMasterDao.CN_SHOP_IMAGE_DIRECTORY);
			try {
			cm.setCodeOption(InetAddress.getLocalHost().getHostName());
			} catch (UnknownHostException e) {
				throw new GuppyException("Cannot Get HostName", e);
			}
			
			List<CodeMaster> cmList = new ArrayList<CodeMaster>();
			
			cmList = codeMasterProc.getCodeMasterData(cm);
			if (cmList.size() != 1)
				throw new GuppyException("Shop Image Directory for " + 
							cm.getCodeOption() + " is not exists or has more than 1 data.");
			
			SHOP_IMAGE_DIRECTORY_PATH = cmList.get(0).getCodeValue();
		}
		
		return SHOP_IMAGE_DIRECTORY_PATH;
	}
}
