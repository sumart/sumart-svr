package com.goodjoon.guppy.engine.common.proc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.goodjoon.guppy.engine.common.dao.CodeMasterDao;
import com.goodjoon.guppy.engine.common.model.CodeMaster;

@Component
public class CodeMasterProc extends BaseProc {
	@Autowired
	protected CodeMasterDao codeMasterDao; 
	
	public List<CodeMaster> getCodeMasterData(CodeMaster codeMaster) {
		return codeMasterDao.getCodeData(codeMaster);
	}
}
