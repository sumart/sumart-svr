package com.goodjoon.guppy.engine.common.dao;

import java.util.List;

import com.goodjoon.guppy.engine.common.model.CodeMaster;

public interface CodeMasterDao extends BaseDao {
	static final String CN_SHOP_IMAGE_DIRECTORY = "shop_image_directory";
	
	List<CodeMaster> getCodeData(CodeMaster codeMaster);
}
